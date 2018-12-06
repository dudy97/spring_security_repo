package com.luv2code.springsecurity.demo.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by admin on 23.11.2018.
 */
@Component
public class MySuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response,
                          Authentication authentication) throws IOException, ServletException {
        String target = determineTargetUrl(authentication);
        if(response.isCommitted()){
            System.out.println("Response is commited");
            return;
        }
        redirectStrategy.sendRedirect(request,response,target);
    }

    private String determineTargetUrl(Authentication authentication) {
        String url = "";
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = new ArrayList<>();
        for(GrantedAuthority ga:authorities)
            roles.add(ga.getAuthority());
        if(isUser(roles))
            url="/employee";
        return url;
    }

    private boolean isUser(List<String> roles) {
        return roles.contains("ROLE_EMPLOYEE");
    }


}
