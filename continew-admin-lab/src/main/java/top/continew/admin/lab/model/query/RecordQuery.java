package top.continew.admin.lab.model.query;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.format.annotation.DateTimeFormat;
import top.continew.admin.common.config.CustomLocalDateTimeDeserializer;
import top.continew.starter.data.core.annotation.Query;
import top.continew.starter.data.core.enums.QueryType;

/**
 * 记录管理查询条件
 *
 * @author xiahaike
 * @since 2024/06/17 08:25
 */
@Data
@Schema(description = "记录管理查询条件")
public class RecordQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 实验室id
     */
    @Schema(description = "实验室id")
    @Query(type = QueryType.EQ)
    private Long labId;

    private String labName;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    @Query(type = QueryType.EQ)
    private Long userId;

    private String userName;

    /**
     * 检查日期
     */
    @Schema(description = "检查日期")
    @Query(type = QueryType.LIKE_LEFT)
    private String inspectionDate;

    /**
     * 消防设备是否存在
     */
    @Schema(description = "消防设备是否存在")
    @Query(type = QueryType.EQ)
    private Integer fireDeviceExist;
}