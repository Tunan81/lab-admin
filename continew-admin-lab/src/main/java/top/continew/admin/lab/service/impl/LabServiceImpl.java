package top.continew.admin.lab.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.starter.extension.crud.service.impl.BaseServiceImpl;
import top.continew.admin.lab.mapper.LabMapper;
import top.continew.admin.lab.model.entity.LabDO;
import top.continew.admin.lab.model.query.LabQuery;
import top.continew.admin.lab.model.req.LabReq;
import top.continew.admin.lab.model.resp.LabDetailResp;
import top.continew.admin.lab.model.resp.LabResp;
import top.continew.admin.lab.service.LabService;

/**
 * 实验室业务实现
 *
 * @author xiahaike
 * @since 2024/06/17 03:08
 */
@Service
@RequiredArgsConstructor
public class LabServiceImpl extends BaseServiceImpl<LabMapper, LabDO, LabResp, LabDetailResp, LabQuery, LabReq> implements LabService {}