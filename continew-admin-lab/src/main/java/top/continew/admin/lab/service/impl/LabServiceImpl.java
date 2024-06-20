package top.continew.admin.lab.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.admin.system.model.entity.LogDO;
import top.continew.admin.system.model.entity.UserDO;
import top.continew.starter.extension.crud.model.query.PageQuery;
import top.continew.starter.extension.crud.model.resp.PageResp;
import top.continew.starter.extension.crud.service.impl.BaseServiceImpl;
import top.continew.admin.lab.mapper.LabMapper;
import top.continew.admin.lab.model.entity.LabDO;
import top.continew.admin.lab.model.query.LabQuery;
import top.continew.admin.lab.model.req.LabReq;
import top.continew.admin.lab.model.resp.LabDetailResp;
import top.continew.admin.lab.model.resp.LabResp;
import top.continew.admin.lab.service.LabService;

import java.util.List;

/**
 * 实验室业务实现
 *
 * @author xiahaike
 * @since 2024/06/17 03:08
 */
@Service
@RequiredArgsConstructor
public class LabServiceImpl extends BaseServiceImpl<LabMapper, LabDO, LabResp, LabDetailResp, LabQuery, LabReq> implements LabService {


    @Resource
    private LabMapper labMapper;

    @Override
    public PageResp<LabResp> myPage(LabQuery query, PageQuery pageQuery) {
        QueryWrapper<LabDO> queryWrapper = this.buildQueryWrapper(query);
        IPage<LabResp> page = labMapper.myPage(pageQuery.toPage(),
                queryWrapper,query.getDeptName(),query.getUserId(),query.getName(),query.getUserName(),query.getBuildingName());
        return PageResp.build(page);
    }

    @Override
    public List<LabDO> selectLabByName(String labName) {
        QueryWrapper<LabDO> query = new QueryWrapper<>();
        query.like("name",labName);
        return baseMapper.selectList(query);
    }

    @Override
    public List<LabDO> selectLabByUserId(Long id) {
        QueryWrapper<LabDO> query = new QueryWrapper<>();
        query.eq("user_id",id);
        return baseMapper.selectList(query);
    }
}