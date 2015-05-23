package com.softserve.edu.config;
import com.allanditzel.springframework.security.web.csrf.CsrfTokenResponseHeaderBindingFilter;
import com.softserve.edu.entity.user.SystemAdmin;
import com.softserve.edu.service.SecurityUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CsrfFilter;

import javax.sql.DataSource;

import static com.softserve.edu.entity.user.SystemAdmin.AdminRole.*;
import static com.softserve.edu.entity.user.CalibratorEmployee.CalibratorEmployeeRole.*;
import static com.softserve.edu.entity.user.ProviderEmployee.ProviderEmployeeRole.*;
import static com.softserve.edu.entity.user.StateVerificatorEmployee.StateVerificatorEmployeeRole.*;

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
                .antMatchers("/resources/assets/**", "/resources/app/welcome/**",
                         "/application/**", "/calibrationTests/**"
                        , "/calibrationTestData/**").permitAll()
                .antMatchers("/resources/app/admin/**", "/admin/**").hasAuthority(SYS_ADMIN.roleName())

                .antMatchers("/resources/app/provider/**", "/provider").hasAnyAuthority(PROVIDER_EMPLOYEE.roleName(), PROVIDER_ADMIN.roleName())
                .antMatchers("/provider/admin/**").hasAuthority(PROVIDER_ADMIN.roleName())
                .antMatchers("/provider/employee/**").hasAuthority(PROVIDER_EMPLOYEE.roleName())

                .antMatchers("/resources/app/calibrator/**", "/calibrator/**").hasAnyAuthority(CALIBRATOR_EMPLOYEE.roleName(), CALIBRATOR_ADMIN.roleName())
                .antMatchers("/calibrator/admin/**").hasAuthority(CALIBRATOR_ADMIN.roleName())
                .antMatchers("/calibrator/employee/**").hasAuthority(CALIBRATOR_EMPLOYEE.roleName())

                .antMatchers("/resources/app/verificator/**", "/verificator/**").hasAnyAuthority(STATE_VERIFICATOR_EMPLOYEE.roleName(), STATE_VERIFICATOR_ADMIN.roleName())
                .antMatchers("/verificator/admin/**").hasAuthority(STATE_VERIFICATOR_ADMIN.roleName())
                .antMatchers("/verificator/employee/**").hasAuthority(STATE_VERIFICATOR_EMPLOYEE.roleName())

                .and()
                .formLogin()
                .defaultSuccessUrl("/")
                .loginProcessingUrl("/authenticate")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(new AjaxAuthenticationSuccessHandler(new SavedRequestAwareAuthenticationSuccessHandler()))
                .loginPage("/")
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