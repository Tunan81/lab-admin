package top.continew.admin.lab.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.starter.extension.crud.model.query.PageQuery;
import top.continew.starter.extension.crud.model.resp.PageResp;
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
public class RecordServiceImpl extends BaseServiceImpl<RecordMapper, RecordDO, RecordResp, RecordDetailResp, RecordQuery, RecordReq> implements RecordService {


    @Resource
    private RecordMapper recordMapper;

    @Override
    public PageResp<RecordResp> myPage(RecordQuery recordQuery, PageQuery pageQuery) {
        QueryWrapper<RecordDO> queryWrapper = this.buildQueryWrapper(recordQuery);
        IPage<RecordResp> page = recordMapper.myPage(pageQuery.toPage(), queryWrapper,
                recordQuery.getUserName(),recordQuery.getLabName(),recordQuery.getInspectionDate());
        return PageResp.build(page);
    }
}