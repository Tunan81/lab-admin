package top.continew.admin.lab.model.query;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.data.core.annotation.Query;
import top.continew.starter.data.core.enums.QueryType;

/**
 * 实验室查询条件
 *
 * @author xiahaike
 * @since 2024/06/17 03:08
 */
@Data
@Schema(description = "实验室查询条件")
public class LabQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    @Schema(description = "名称")
    @Query(type = QueryType.LIKE)
    private String name;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    @Query(type = QueryType.EQ)
    private Long userId;

    /**
     * 维护人员姓名
     */
    private String userName;

    /**
     * 所在楼栋名称
     */
    @Schema(description = "所在楼栋名称")
    private String buildingName;

    /**
     * 所属部门名称
     */
    @Schema(description = "所属部门名称")
    private String deptName;
}