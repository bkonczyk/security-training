package pl.sda.spring.securitytraining.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors().disable();
        http.headers().frameOptions().disable();

        http.httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers("/hello").permitAll()
            .antMatchers("/api/users/create").permitAll()
            .antMatchers("/admin").hasRole("ADMIN")
            .antMatchers("/h2-console/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll()
            .and()
            .logout().permitAll();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//            .withUser("admin").password(passwordEncoder().encode("password")).roles("ADMIN")
//            .and()
//            .withUser("user").password(passwordEncoder().encode("password")).roles("USER");
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
