package top.continew.admin.lab.model.resp;

import java.io.Serial;
import java.time.LocalDateTime;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.extension.crud.model.resp.BaseResp;

/**
 * 实验室信息
 *
 * @author xiahaike
 * @since 2024/06/17 03:08
 */
@Data
@Schema(description = "实验室信息")
public class LabResp extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    @Schema(description = "名称")
    private String name;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    private Long userId;

    /**
     * 用户名
     */
    @Schema(description = "用户名")
    private String userName;

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

    /**
     * 所在楼栋名称
     */
    @Schema(description = "所在楼栋名称")
    private String buildingName;

    /**
     * 所属部门id
     */
    @Schema(description = "所属部门id")
    private Long deptId;

    @Schema(description = "所属部门名称")
    private String deptName;

}