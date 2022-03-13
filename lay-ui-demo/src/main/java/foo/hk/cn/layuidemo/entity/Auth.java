package foo.hk.cn.layuidemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 系统权限
 * @TableName t_sys_auth
 */
@TableName(value ="t_sys_auth")
@Data
public class Auth implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 权限名称
     */
    private String authName;

    /**
     * 权限标识
     */
    private String permission;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}