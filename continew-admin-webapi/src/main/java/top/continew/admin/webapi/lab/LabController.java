package top.continew.admin.webapi.lab;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.continew.admin.lab.model.query.LabQuery;
import top.continew.admin.lab.model.req.LabReq;
import top.continew.admin.lab.model.resp.LabDetailResp;
import top.continew.admin.lab.model.resp.LabResp;
import top.continew.admin.lab.service.LabService;
import top.continew.admin.system.service.UserService;
import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.starter.extension.crud.controller.BaseController;
import top.continew.starter.extension.crud.enums.Api;
import top.continew.starter.extension.crud.model.query.PageQuery;
import top.continew.starter.extension.crud.model.resp.PageResp;
import top.continew.starter.web.model.R;

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

    @Operation(summary = "分页查询列表", description = "分页查询列表")
    @ResponseBody
    @GetMapping
    public R<PageResp<LabResp>> page(LabQuery labQuery, @Validated PageQuery pageQuery) {
        this.checkPermission(Api.LIST);
        PageResp<LabResp> labRespPageResp = labService.page(labQuery,pageQuery);
        labRespPageResp.getList().forEach(labResp -> {
            labResp.setUserName(userService.getById(labResp.getUserId()).getUsername());
        });
        return R.ok(labRespPageResp);
    }
}