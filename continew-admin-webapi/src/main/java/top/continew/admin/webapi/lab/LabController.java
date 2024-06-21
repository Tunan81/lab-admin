package top.continew.admin.webapi.lab;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.continew.admin.common.model.dto.LoginUser;
import top.continew.admin.common.model.dto.RoleDTO;
import top.continew.admin.common.util.helper.LoginHelper;
import top.continew.admin.lab.model.entity.LabDO;
import top.continew.admin.lab.model.query.LabQuery;
import top.continew.admin.lab.model.req.LabReq;
import top.continew.admin.lab.model.resp.LabDetailResp;
import top.continew.admin.lab.model.resp.LabResp;
import top.continew.admin.lab.service.LabService;
import top.continew.admin.system.model.entity.DeptDO;
import top.continew.admin.system.model.entity.UserDO;
import top.continew.admin.system.service.DeptService;
import top.continew.admin.system.service.UserService;
import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.starter.extension.crud.controller.BaseController;
import top.continew.starter.extension.crud.enums.Api;
import top.continew.starter.extension.crud.model.query.PageQuery;
import top.continew.starter.extension.crud.model.resp.PageResp;
import top.continew.starter.web.model.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 实验室管理 API
 *
 * @author xiahaike
 * @since 2024/06/17 02:32
 */
@Tag(name = "实验室管理 API")
@RestController
@RequiredArgsConstructor
@CrudRequestMapping(value = "/lab/lab", api = {Api.PAGE, Api.GET, Api.ADD, Api.UPDATE, Api.DELETE, Api.EXPORT})
public class LabController extends BaseController<LabService, LabResp, LabDetailResp, LabQuery, LabReq> {

    @Resource
    private LabService labService;

    @Resource
    private UserService userService;

    @Resource
    private DeptService deptService;

    @Operation(summary = "分页查询列表", description = "分页查询列表")
    @ResponseBody
    @GetMapping
    @Override
    public R<PageResp<LabResp>> page(LabQuery labQuery, @Validated PageQuery pageQuery) {
        this.checkPermission(Api.LIST);
        PageResp<LabResp> labRespPageResp = labService.myPage(labQuery, pageQuery);
        labRespPageResp.getList().forEach(labResp -> {
            labResp.setUserName(userService.getById(labResp.getUserId()).getUsername());
            // 查询部门名称 只查上一级名称（学院）
            DeptDO deptDO = deptService.getById(labResp.getDeptId());
            String parentName = "";
            System.out.println("deptDO.getParentId() = " + deptDO.getParentId());
            System.out.println("deptDO.getParentId() = " + deptDO.getId());
            if (deptDO.getParentId() != 0) {
                parentName = deptService.getById(deptDO.getParentId()).getName();
            }
            if (!"".equals(parentName)) {
                labResp.setDeptName(deptDO.getName() + "(" + parentName + ")");
            }
        });
        return R.ok(labRespPageResp);
    }

    @Operation(
            summary = "查询详情",
            description = "查询详情"
    )
    @ResponseBody
    @GetMapping("/{id}")
    @Override
    public R<LabDetailResp> get(@PathVariable Long id) {
        this.checkPermission(Api.LIST);
        LabDetailResp labResp = labService.get(id);
        labResp.setDeptName(deptService.getById(labResp.getDeptId()).getName());
        labResp.setUserName(userService.getById(labResp.getUserId()).getUsername());
        return R.ok(labResp);
    }

    @ResponseBody
    @GetMapping("/user/{userName}")
    public R<List<UserDO>> selectUsersByName(@PathVariable String userName) {
        return R.ok(userService.selectUsersByName(userName));
    }

    /**
     * 根据用户id查询所管理的实验室
     */
    @Operation(summary = "根据当前登录用户查询所管理的实验室", description = "根据当前登录用户查询所管理的实验室")
    @ResponseBody
    @GetMapping("/loginUser")
    public R<List<LabDO>> selectLabByLoginUser() {
        LoginUser loginUser = LoginHelper.getLoginUser();
        // 如果是管理员则查询所有
        Set<RoleDTO> roles = loginUser.getRoles();
        boolean isAdmin = roles.stream().anyMatch(r -> r.getId() == 1);
        if (isAdmin) {
            List<LabDO> labels = labService.myList();
            labels.forEach(labDO -> {
                labDO.setDeptName(deptService.getById(labDO.getDeptId()).getName());
            });
            return R.ok(labels);
        }
        List<LabDO> labDOS = labService.selectLabByUserId(loginUser.getId());
        labDOS.forEach(labDO -> {
            labDO.setDeptName(deptService.getById(labDO.getDeptId()).getName());
        });
        return R.ok(labDOS);
//        PageResp<LabResp> labRespPageResp = labService.myPage(labQuery, pageQuery);
//        labRespPageResp.getList().forEach(labResp -> {
//            labResp.setUserName(userService.getById(labResp.getUserId()).getUsername());
//            // 查询部门名称 只查上一级名称（学院）
//            DeptDO deptDO = deptService.getById(labResp.getDeptId());
//            String parentName = null;
//            if (deptDO.getParentId() != null) {
//                parentName = deptService.getById(deptDO.getParentId()).getName();
//            }
//            labResp.setDeptName(deptDO.getName() + "(" + parentName + ")");
//        });
        //return R.ok(labRespPageResp);
    }

    /**
     * 查询学院列表
     */
    @Operation(summary = "根查询学院列表", description = "查询学院列表")
    @ResponseBody
    @GetMapping("/dept/{deptName}")
    public R<List<DeptDO>> selectDept(@PathVariable String deptName) {
        // todo 优化
        QueryWrapper<DeptDO> queryWrapper = new QueryWrapper<>();
        // 为1表示校区
        //queryWrapper.eq("parent_id", 1);
        queryWrapper.like("name",deptName);
        List<DeptDO> deptDOS = deptService.list(queryWrapper);
        // 根据父id 查询父name
        for (DeptDO deptDO : deptDOS) {
            Long pId = deptDO.getParentId();
            if (pId != 0){
                DeptDO parent = deptService.getById(pId);
                deptDO.setName(deptDO.getName() + "(" + parent.getName() + ")");
            }
        }
//        List<DeptDO> childDept = new ArrayList<>();
//        for (DeptDO dept : deptDOS) {
//            QueryWrapper<DeptDO> childQueryWrapper = new QueryWrapper<>();
//            childQueryWrapper.eq("parent_id", dept.getId());
//            childDept.addAll(deptService.list(childQueryWrapper));
//        }
        return R.ok(deptDOS);
    }

}