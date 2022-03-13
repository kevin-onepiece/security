package foo.hk.cn.layuidemo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author foo
 * @since 2022-03-10
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {

	/**
	 * 响应码
	 */
	private int code;

	/**
	 * 响应消息体
	 */
	private String msg;

	/**
	 * 响应数据
	 */
	private T data;

	/**
	 * 失败响应
	 *
	 * @param msg 响应消息体
	 * @return
	 */
	public static <T> Response<T> error(String msg) {
		return new Response<T>(500, msg, null);
	}

	/**
	 * 成功响应
	 *
	 * @param data 响应数据
	 * @return
	 */
	public static <T> Response<T> success(T data) {
		return new Response<T>(200, null, data);
	}

	/**
	 * 成功响应
	 *
	 * @param msg 响应消息体
	 * @return
	 */
	public static <T> Response<T> success(String msg) {
		return new Response<T>(200, msg, null);
	}

	/**
	 * 成功响应
	 *
	 * @param msg  响应消息体
	 * @param data 响应数据
	 * @return
	 */
	public static <T> Response<T> success(String msg, T data) {
		return new Response<T>(200, msg, data);
	}

}
