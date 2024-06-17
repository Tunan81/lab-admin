package top.continew.admin.lab.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.starter.extension.crud.service.impl.BaseServiceImpl;
import top.continew.admin.lab.mapper.RecordMapper;
import top.continew.admin.lab.model.entity.RecordDO;
import top.continew.admin.lab.model.query.RecordQuery;
import top.continew.admin.lab.model.req.RecordReq;
import top.continew.admin.lab.model.resp.RecordDetailResp;
import top.continew.admin.lab.model.resp.RecordResp;
import top.continew.admin.lab.service.RecordService;

/**
 * 记录管理业务实现
 *
 * @author xiahaike
 * @since 2024/06/17 08:25
 */
@Service
@RequiredArgsConstructor
public class RecordServiceImpl extends BaseServiceImpl<RecordMapper, RecordDO, RecordResp, RecordDetailResp, RecordQuery, RecordReq> implements RecordService {}