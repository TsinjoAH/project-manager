package com.management.project.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
public class PreFilter extends AbstractPreAuthenticatedProcessingFilter {

    public PreFilter(){
        Manager manager=new Manager();
        super.setAuthenticationManager(manager);
    }
    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        return request.getHeader("tk");
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return null;
    }
}
