package top.continew.admin.lab.model.resp;

import java.io.Serial;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.admin.common.config.CustomLocalDateTimeDeserializer;
import top.continew.starter.extension.crud.model.resp.BaseResp;

/**
 * 记录管理信息
 *
 * @author xiahaike
 * @since 2024/06/17 08:25
 */
@Data
@Schema(description = "记录管理信息")
public class RecordResp extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 实验室id
     */
    @Schema(description = "实验室id")
    private Long labId;

    /**
     * 实验室名称
     */
    private String labName;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    private Long userId;

    /**
     * 用户名称
     */
    @Schema(description = "用户id")
    private String userName;

    /**
     * 检查日期
     */
    @Schema(description = "检查日期")
    //@JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    //@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private String inspectionDate;

    /**
     * 门窗完好及关闭
     */
    @Schema(description = "门窗完好及关闭")
    private Integer door;

    /**
     * 门窗完好及关闭备忘录
     */
    @Schema(description = "门窗完好及关闭备忘录")
    private String doorMemo;

    /**
     * 消防设备是否存在
     */
    @Schema(description = "消防设备是否存在")
    private Integer fireDeviceExist;

    /**
     * 消防设备是否存在备忘录
     */
    @Schema(description = "消防设备是否存在备忘录")
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
    private String fireDeviceValidMemo;

    /**
     * 其他安全隐患
     */
    @Schema(description = "其他安全隐患")
    private String otherRisks;

    /**
     * 问题处理0-未上报 1-已上报 2-已处理
     */
    @Schema(description = "问题处理0-未上报 1-已上报 2-已处理")
    private Integer problemHandling;

    /**
     * 修改人
     */
    @Schema(description = "修改人")
    private Long updateUser;

    /**
     * 修改时间
     */
    @Schema(description = "修改时间")
    private LocalDateTime updateTime;
}