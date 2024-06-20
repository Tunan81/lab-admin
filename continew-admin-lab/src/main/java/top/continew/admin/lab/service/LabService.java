package top.continew.admin.lab.service;

import top.continew.admin.lab.model.entity.LabDO;
import top.continew.admin.system.model.entity.UserDO;
import top.continew.starter.extension.crud.model.query.PageQuery;
import top.continew.starter.extension.crud.model.resp.PageResp;
import top.continew.starter.extension.crud.service.BaseService;
import top.continew.admin.lab.model.query.LabQuery;
import top.continew.admin.lab.model.req.LabReq;
import top.continew.admin.lab.model.resp.LabDetailResp;
import top.continew.admin.lab.model.resp.LabResp;

import java.util.List;

/**
 * 实验室业务接口
 *
 * @author xiahaike
 * @since 2024/06/17 03:08
 */
public interface LabService extends BaseService<LabResp, LabDetailResp, LabQuery, LabReq> {

    PageResp<LabResp> myPage(LabQuery var1, PageQuery var2);

    List<LabDO> selectLabByName(String labName);

    List<LabDO> selectLabByUserId(Long id);
}