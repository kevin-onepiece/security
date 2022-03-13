package foo.hk.cn.secutitydemo.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author foo
 * @since 2022-03-10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_sys_user")
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;

	/**
	 * 用户名称
	 */
	private String username;

	/**
	 * 用户昵称
	 */
	private String nickname;

	/**
	 * 用户密码
	 */
	@JsonIgnore
	private String password;

}
