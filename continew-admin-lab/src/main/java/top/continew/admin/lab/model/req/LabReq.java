package top.continew.admin.lab.model.req;

import java.io.Serial;
import java.time.LocalDateTime;

import jakarta.validation.constraints.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;

import top.continew.starter.extension.crud.model.req.BaseReq;

/**
 * 创建或修改实验室信息
 *
 * @author xiahaike
 * @since 2024/06/17 03:08
 */
@Data
@Schema(description = "创建或修改实验室信息")
public class LabReq extends BaseReq {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    @Schema(description = "名称")
    @NotBlank(message = "不能为空")
    @Length(max = 255, message = "长度不能超过 {max} 个字符")
    private String name;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    private Long userId;


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

}