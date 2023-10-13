package com.example.c4zone.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    private UserDetailsService jwtUserDetailService;
    @Autowired
    private JwtRequestFilter jwtRequestFilter;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();

    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().cors().and()
                .authorizeRequests()
                .antMatchers(
                        "/api/user/create/**",
                        "/api/user/confirm/**",
//                        "/api/user/information/**",
                        "/api/user/resetOTP/**",
                        "/api/user/login-by-username/**",
//                        "/api/user/logout/{userName}/**",
//                        "/api/user/get-id-app-user/{userName}",
//                        "/api/user/register/**",
                        "/api/admin/product/**",

                        "/api/admin/employee/list/**",
                        "/api/user/register/**"


                        "/api/admin/employee/list/**",
                        "/api/admin/customer/list/**",
                        "/api/admin/customer/history/**",

                        "/api/user/get-id-app-user/{userName}",
                        "/api/admin/employee/**"

                ).permitAll()

                .antMatchers(
//                        "/api/user/register/**",
//                        "/api/user/information/**",
//                        "/api/user/logout/{userName}/**",
//                        "/api/user/get-id-app-user/{userName}"
                ).hasAnyAuthority("ROLE_ADMIN", "ROLE_SALE", "ROLE_BUSINESS", "ROLE_WAREHOUSE")

                .antMatchers(
                        //admin

                        "/api/user/information/**",
                        "/api/user/logout/{userName}/**",
                        "/api/user/get-id-app-user/{userName}/**"

                ).hasAnyAuthority("ROLE_ADMIN")


                .antMatchers(
                        //sale
                ).hasAnyAuthority("ROLE_SALE")


                .antMatchers(
                        //business
                ).hasAnyAuthority("ROLE_BUSINESS")


                .antMatchers(
                        //warehouse
                ).hasAnyAuthority("ROLE_WAREHOUSE")

                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and().
                sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

//        httpSecurity
//                .authorizeRequests()
//                .anyRequest().permitAll()
//                .and()
//                .csrf().disable();
    }

}
