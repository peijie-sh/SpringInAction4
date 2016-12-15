package spittr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;

/**
 * Author LPJ
 * Date 2016/12/14
 */
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 启用内存用户存储
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN", "USER").and()
                .withUser("user").password("user").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()// 打开默认登录页面
                .loginPage("/login")// 使用自定义页面
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .rememberMe()
                .tokenRepository(new InMemoryTokenRepositoryImpl())
                .tokenValiditySeconds(2419200)
                .key("spittrKey")
                .and()
                .httpBasic()
                .realmName("Spittr")
                .and()
                .authorizeRequests()
                .antMatchers("/spitter/me").authenticated()
                .antMatchers(HttpMethod.POST, "/spittles").authenticated()
                .anyRequest().permitAll()
                .and()
                // 禁用跨站请求，默认是开启的
                .csrf().disable();
    }
}
