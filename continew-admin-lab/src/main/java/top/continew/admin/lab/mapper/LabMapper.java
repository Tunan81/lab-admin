package top.continew.admin.lab.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import top.continew.admin.lab.model.query.LabQuery;
import top.continew.admin.lab.model.resp.LabResp;
import top.continew.admin.system.model.entity.LogDO;
import top.continew.starter.data.mybatis.plus.base.BaseMapper;
import top.continew.admin.lab.model.entity.LabDO;
import top.continew.starter.extension.crud.model.query.PageQuery;
import top.continew.starter.extension.crud.model.resp.PageResp;

/**
* 实验室 Mapper
*
* @author xiahaike
* @since 2024/06/17 03:08
*/
public interface LabMapper extends BaseMapper<LabDO> {
    /**
    * 分页查询
    * @return 分页结果
    */
    IPage<LabResp> myPage(@Param("page") IPage<LabDO> page,
                          @Param(Constants.WRAPPER) QueryWrapper<LabDO> queryWrapper,
                          @Param("deptName") String deptName,
                          @Param("name") String name,
                          @Param("userName")String userName,
                          @Param("buildingName")String buildingName);

}