package top.continew.admin.lab.model.resp;

import java.io.Serial;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;

import top.continew.starter.extension.crud.model.resp.BaseDetailResp;

/**
 * 实验室详情信息
 *
 * @author xiahaike
 * @since 2024/06/17 03:08
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "实验室详情信息")
public class LabDetailResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    @Schema(description = "名称")
    @ExcelProperty(value = "名称")
    private String name;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    @ExcelProperty(value = "用户id")
    private Long userId;


    /**
     * 所在楼栋名称
     */
    @Schema(description = "所在楼栋名称")
    private String buildingName;

    private String deptName;

    private String userName;

    /**
     * 所属部门id
     */
    @Schema(description = "所属部门id")
    private Long deptId;

}