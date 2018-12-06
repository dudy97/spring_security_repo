package com.luv2code.springsecurity.demo.config;

import com.luv2code.springsecurity.demo.handler.MySuccessHandler;
import com.luv2code.springsecurity.demo.service.UserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * Created by admin on 22.11.2018.
 */
@EnableWebSecurity
@Configuration
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    MySuccessHandler successHandler;

    @Autowired
    DataSource dataSource;

    @Autowired
    private UserService userService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);

//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//        auth.inMemoryAuthentication()
//                .withUser(users.username("adam").password("adam").roles("EMPLOYEE","BOSS"))
//                .withUser(users.username("konrad").password("konrad").roles("EMPLOYEE"))
//                .withUser(users.username("mateusz").password("mateusz").roles("EMPLOYEE", "ASISTANT"));

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/employee").hasRole("EMPLOYEE")
                .antMatchers("/assistants/**").hasRole("ASISTANT")
                .and()
                .formLogin()
                    .loginPage("/showLoginForm")
                    .loginProcessingUrl("/authenticateTheUser").successHandler(successHandler)
                    .permitAll()
                .and()
                    .logout()
                    .permitAll()
                .and()
                .exceptionHandling()
                    .accessDeniedPage("/accessDenied");
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    //authenticationProvider bean definition
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService); //set the custom user details service
        auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
        return auth;
    }
}
