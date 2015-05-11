package com.softserve.edu.config;

import com.allanditzel.springframework.security.web.csrf.CsrfTokenResponseHeaderBindingFilter;
import com.softserve.edu.security.AjaxAuthenticationSuccessHandler;
import com.softserve.edu.security.SecurityUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CsrfFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityUserDetailsService userDetailsService;

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        CsrfTokenResponseHeaderBindingFilter csrfTokenFilter = new CsrfTokenResponseHeaderBindingFilter();
        http.addFilterAfter(csrfTokenFilter, CsrfFilter.class);

        http
                .authorizeRequests()
                    .antMatchers("/resources/assets/**", "/resources/app/welcome/**").permitAll()
                    .antMatchers("/resources/app/admin/**", "/admin").hasAuthority("SYS_ADMIN")
                    .antMatchers("/resources/app/provider/**", "/provider/**").hasAnyAuthority("PROVIDER_EMPLOYEE", "PROVIDER_ADMIN")
                    .antMatchers("/resources/app/calibrator/**", "/calibrator/**").hasAnyAuthority("CALIBRATOR_EMPLOYEE", "CALIBRATOR_ADMIN")
                    .antMatchers("/resources/app/verificator/**", "/verificator/**").hasAnyAuthority("STATE_VERIFICATOR_EMPLOYEE", "STATE_VERIFICATOR_ADMIN")
                .and()
                    .formLogin()
                    .defaultSuccessUrl("/")
                    .loginProcessingUrl("/authenticate")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .successHandler(new AjaxAuthenticationSuccessHandler(new SavedRequestAwareAuthenticationSuccessHandler()))
                    .loginPage("/#login")
                    .permitAll()
                .and()
                    .httpBasic()
                .and()
                    .logout()
                    .logoutSuccessUrl("/")
                    .logoutUrl("/logout")
                    .permitAll();
        }
}