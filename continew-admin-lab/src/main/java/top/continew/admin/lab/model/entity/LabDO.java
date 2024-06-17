package top.continew.admin.lab.model.entity;

import java.io.Serial;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.starter.extension.crud.model.entity.BaseDO;

/**
 * 实验室实体
 *
 * @author xiahaike
 * @since 2024/06/17 03:08
 */
@Data
@TableName("lab")
public class LabDO extends BaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Long userId;
}