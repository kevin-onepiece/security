package foo.hk.cn.layuidemo.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author foo
 * @since 2022-03-10
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class MybatisPlusConfig {

	/**
	 * 注入分页插件
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}

}
