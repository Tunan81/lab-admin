package top.continew.admin.lab.model.resp;

import java.io.Serial;
import java.time.LocalDateTime;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.Mapping;
import cn.crane4j.annotation.condition.ConditionOnPropertyNotNull;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;

import top.continew.admin.common.config.CustomLocalDateTimeDeserializer;
import top.continew.admin.lab.util.LocalDateTimeConverter;
import top.continew.admin.lab.util.isOrNoConverter;
import top.continew.starter.extension.crud.model.resp.BaseDetailResp;

/**
 * 记录管理详情信息
 *
 * @author xiahaike
 * @since 2024/06/17 08:25
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "记录管理详情信息")
public class RecordDetailResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 实验室id
     */
    @Schema(description = "实验室id")
    @ExcelIgnore
    private Long labId;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    @ExcelIgnore
    private Long userId;

    /**
     * 门窗完好及关闭
     */
    @Schema(description = "门窗完好及关闭")
    @ExcelProperty(value = "门窗完好及关闭",converter = isOrNoConverter.class,index = 1)
    private Integer door;

    /**
     * 门窗完好及关闭备忘录
     */
    @Schema(description = "门窗完好及关闭备忘录")
    @ExcelProperty(value = "门窗完好及关闭情况",index = 2)
    private String doorMemo;

    /**
     * 消防设备是否存在
     */
    @Schema(description = "消防设备是否存在")
    @ExcelProperty(value = {"消防设施", "消防设备是否存在"},converter = isOrNoConverter.class,index = 3)
    private Integer fireDeviceExist;

    /**
     * 消防设备是否存在备忘录
     */
    @Schema(description = "消防设备是否存在备忘录")
    @ExcelProperty(value = {"消防设施", "消防设备是否存在情况"},index = 4)
    private String fireDeviceExistMemo;

    /**
     * 消防设施是否有效
     */
    @Schema(description = "消防设施是否有效")
    @ExcelProperty(value = {"消防设施", "消防设施是否有效"}, converter = isOrNoConverter.class,index = 5)
    private Integer fireDeviceValid;

    /**
     * 消防设施是否有效备忘录
     */
    @Schema(description = "消防设施是否有效备忘录")
    @ExcelProperty(value = {"消防设施", "消防设施是否有效情况"},index = 6)
    private String fireDeviceValidMemo;

    /**
     * 其他安全隐患
     */
    @Schema(description = "其他安全隐患")
    @ExcelProperty(value = "其他安全隐患",index = 7)
    private String otherRisks;

    /**
     * 问题处理0-未上报 1-已上报 2-已处理
     */
    @Schema(description = "问题处理0-未上报 1-已上报 2-已处理")
    @ExcelProperty(value = "问题处理情况",index = 8)
    private Integer problemHandling;

    /**
     * 检查日期
     */
    @Schema(description = "检查日期")
    @ExcelProperty(value = "检查日期",index = 9,converter = LocalDateTimeConverter.class)
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private LocalDateTime inspectionDate;

    @Schema(
            description = "ID",
            example = "1"
    )
    @ExcelProperty(
            value = {"ID"},
            index = 0
    )
    @ExcelIgnore
    private Long id;
    @JsonIgnore
    @Assemble(
            container = "UserNickname",
            props = {@Mapping(
                    ref = "createUserString"
            )}
    )
    @ExcelIgnore
    private Long createUser;

    @Schema(
            description = "创建人",
            example = "超级管理员"
    )
    @ExcelIgnore
    private String createUserString;

    @Schema(
            description = "创建时间",
            example = "2023-08-08 08:08:08",
            type = "string"
    )
    @ExcelIgnore
    private LocalDateTime createTime;
}