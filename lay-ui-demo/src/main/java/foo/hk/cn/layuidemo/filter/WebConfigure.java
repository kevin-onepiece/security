package foo.hk.cn.layuidemo.filter;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author foo
 * @since 2022-03-10
 */
@Component
@ConfigurationProperties(prefix = "security.web")
public class WebConfigure implements WebMvcConfigurer {

    @Setter
    List<String> excludes;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(excludes);
    }

}
