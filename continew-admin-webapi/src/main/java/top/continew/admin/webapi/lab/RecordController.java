package top.continew.admin.webapi.lab;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import top.continew.admin.lab.model.query.LabQuery;
import top.continew.admin.lab.model.resp.LabResp;
import top.continew.admin.lab.service.LabService;
import top.continew.admin.system.service.UserService;
import top.continew.starter.extension.crud.enums.Api;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.starter.extension.crud.controller.BaseController;
import top.continew.admin.lab.model.query.RecordQuery;
import top.continew.admin.lab.model.req.RecordReq;
import top.continew.admin.lab.model.resp.RecordDetailResp;
import top.continew.admin.lab.model.resp.RecordResp;
import top.continew.admin.lab.service.RecordService;
import top.continew.starter.extension.crud.model.query.PageQuery;
import top.continew.starter.extension.crud.model.resp.PageResp;
import top.continew.starter.web.model.R;

/**
 * 记录管理管理 API
 *
 * @author xiahaike
 * @since 2024/06/17 07:50
 */
@Tag(name = "记录管理管理 API")
@RestController
@CrudRequestMapping(value = "/lab/record", api = {Api.PAGE, Api.GET, Api.ADD, Api.UPDATE, Api.DELETE, Api.EXPORT})
public class RecordController extends BaseController<RecordService, RecordResp, RecordDetailResp, RecordQuery, RecordReq> {

    @Resource
    private RecordService recordService;

    @Resource
    private LabService labService;

    @Resource
    private UserService userService;

    @Operation(summary = "分页查询列表", description = "分页查询列表")
    @ResponseBody
    @GetMapping
    public R<PageResp<RecordResp>> page(RecordQuery recordQuery, @Validated PageQuery pageQuery) {
        this.checkPermission(Api.LIST);
        PageResp<RecordResp> recordRespPageResp = recordService.page(recordQuery,pageQuery);
        recordRespPageResp.getList().forEach(recordResp -> {
            recordResp.setUserName(userService.getById(recordResp.getUserId()).getUsername());
            recordResp.setLabName(labService.get(recordResp.getLabId()).getName());
        });
        return R.ok(recordRespPageResp);
    }
}