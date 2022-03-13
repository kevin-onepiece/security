package foo.hk.cn.secutitydemo.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 系统角色
 * @TableName t_sys_role
 */
@TableName(value ="t_sys_role")
@Data
public class Role implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色编码
     */
    private String roleCode;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}