package com.softserve.edu.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private AuthenticationSuccessHandler defaultHandler;

    public AjaxAuthenticationSuccessHandler(AuthenticationSuccessHandler defaultHandler) {
        this.defaultHandler = defaultHandler;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {

        if ("true".equals(httpServletRequest.getHeader("X-Login-Ajax-call"))) {
            String authority = authentication.getAuthorities().iterator().next().getAuthority();
            httpServletResponse.getWriter().print(authority);
            httpServletResponse.getWriter().flush();
        } else {
            defaultHandler.onAuthenticationSuccess(httpServletRequest, httpServletResponse, authentication);
        }

    }
}
