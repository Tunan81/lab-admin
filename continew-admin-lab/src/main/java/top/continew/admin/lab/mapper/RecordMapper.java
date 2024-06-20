package top.continew.admin.lab.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import top.continew.admin.lab.model.resp.RecordResp;
import top.continew.starter.data.mybatis.plus.base.BaseMapper;
import top.continew.admin.lab.model.entity.RecordDO;

/**
* 记录管理 Mapper
*
* @author xiahaike
* @since 2024/06/17 08:25
*/
public interface RecordMapper extends BaseMapper<RecordDO> {
    IPage<RecordResp> myPage(@Param("page")IPage<RecordDO> page,
                             @Param(Constants.WRAPPER)QueryWrapper<RecordDO> queryWrapper,
                             @Param("userId") Long userId,
                             @Param("userName")String userName,
                             @Param("labName")String labName,
                             @Param("inspectionDate")String inspectionDate);
}