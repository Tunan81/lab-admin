package top.continew.admin.lab.model.req;

import java.io.Serial;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;

import top.continew.admin.common.config.CustomLocalDateTimeDeserializer;
import top.continew.starter.extension.crud.model.req.BaseReq;

/**
 * 创建或修改记录管理信息
 *
 * @author xiahaike
 * @since 2024/06/17 08:25
 */
@Data
@Schema(description = "创建或修改记录管理信息")
public class RecordReq extends BaseReq {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 实验室id
     */
    @Schema(description = "实验室id")
    @NotNull(message = "实验室id不能为空")
    private Long labId;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    @NotNull(message = "用户id不能为空")
    private Long userId;

    /**
     * 检查日期
     */
    @Schema(description = "检查日期")
    //@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    //@JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    //@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private String inspectionDate;

    /**
     * 消防设备是否存在
     */
    @Schema(description = "消防设备是否存在")
    private Integer fireDeviceExist;

    /**
     * 消防设备是否存在备忘录
     */
    @Schema(description = "消防设备是否存在备忘录")
    @Length(max = 100, message = "消防设备是否存在备忘录长度不能超过 {max} 个字符")
    private String fireDeviceExistMemo;

    /**
     * 消防设施是否有效
     */
    @Schema(description = "消防设施是否有效")
    private Integer fireDeviceValid;

    /**
     * 消防设施是否有效备忘录
     */
    @Schema(description = "消防设施是否有效备忘录")
    @Length(max = 100, message = "消防设施是否有效备忘录长度不能超过 {max} 个字符")
    private String fireDeviceValidMemo;

    /**
     * 其他安全隐患
     */
    @Schema(description = "其他安全隐患")
    @Length(max = 100, message = "其他安全隐患长度不能超过 {max} 个字符")
    private String otherRisks;

    /**
     * 问题处理0-未上报 1-已上报 2-已处理
     */
    @Schema(description = "问题处理0-未上报 1-已上报 2-已处理")
    private Integer problemHandling;
}