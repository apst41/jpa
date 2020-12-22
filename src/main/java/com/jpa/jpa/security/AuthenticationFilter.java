package com.jpa.jpa.security;

import com.jpa.jpa.controller.InvalidData;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
    String request=httpServletRequest.getHeader("data");
       if (!request.equals("ajay")){
           httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "invalid data");
       }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
