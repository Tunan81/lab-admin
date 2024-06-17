package top.continew.admin.lab.model.entity;

import java.io.Serial;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.admin.common.config.CustomLocalDateTimeDeserializer;
import top.continew.starter.extension.crud.model.entity.BaseDO;

/**
 * 记录管理实体
 *
 * @author xiahaike
 * @since 2024/06/17 08:25
 */
@Data
@TableName("record")
public class RecordDO extends BaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 实验室id
     */
    private Long labId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 检查日期
     */
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime inspectionDate;

    /**
     * 门窗完好及关闭
     */
    private Integer door;

    /**
     * 门窗完好及关闭备忘录
     */
    private String doorMemo;

    /**
     * 消防设备是否存在
     */
    private Integer fireDeviceExist;

    /**
     * 消防设备是否存在备忘录
     */
    private String fireDeviceExistMemo;

    /**
     * 消防设施是否有效
     */
    private Integer fireDeviceValid;

    /**
     * 消防设施是否有效备忘录
     */
    private String fireDeviceValidMemo;

    /**
     * 其他安全隐患
     */
    private String otherRisks;

    /**
     * 问题处理0-未上报 1-已上报 2-已处理
     */
    private Integer problemHandling;
}