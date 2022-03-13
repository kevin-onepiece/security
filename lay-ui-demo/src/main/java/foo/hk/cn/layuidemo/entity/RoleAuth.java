package foo.hk.cn.layuidemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 角色权限关系
 * @TableName t_sys_role_auth
 */
@TableName(value ="t_sys_role_auth")
@Data
public class RoleAuth implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 权限ID
     */
    private Long authId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}