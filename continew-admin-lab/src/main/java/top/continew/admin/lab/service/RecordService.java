package top.continew.admin.lab.service;

import top.continew.starter.extension.crud.service.BaseService;
import top.continew.admin.lab.model.query.RecordQuery;
import top.continew.admin.lab.model.req.RecordReq;
import top.continew.admin.lab.model.resp.RecordDetailResp;
import top.continew.admin.lab.model.resp.RecordResp;

/**
 * 记录管理业务接口
 *
 * @author xiahaike
 * @since 2024/06/17 08:25
 */
public interface RecordService extends BaseService<RecordResp, RecordDetailResp, RecordQuery, RecordReq> {}