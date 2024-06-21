package top.continew.admin.lab.model.entity;

import java.io.Serial;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;
import top.continew.admin.system.model.entity.DeptDO;
import top.continew.admin.system.model.entity.UserDO;
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
     * 实验室名称
     */
    private String name;

    /**
     * 所属管理人员id
     */
    private Long userId;

    /**
     * 所在楼栋名称
     */
    private String buildingName;

    /**
     * 所属部门id
     */
    private Long deptId;

    @TableField(exist = false)
    private String deptName;

    @TableField(exist = false)
    private DeptDO deptDO;

    @TableField(exist = false)
    private UserDO userDO;
}