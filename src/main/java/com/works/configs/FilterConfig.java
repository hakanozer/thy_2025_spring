package com.works.configs;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class FilterConfig implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String url = req.getRequestURI();
        String sessionId = req.getSession().getId();
        String userAgent = req.getHeader("User-Agent");
        String ip = req.getRemoteAddr();
        String time = ""+ System.currentTimeMillis();

        System.out.println("url: " + url + " sessionId: " + sessionId + " userAgent: " + userAgent + " ip: " + ip + " time: " + time);
        //if (ip.equals("127.0.0.1") || ip.equals("0:0:0:0:0:0:0:1")) {
        //}else {
            // filterChain.doFilter(req,res);
        //}
        res.addHeader("traceId", "3453j45h43j5hj34");
        filterChain.doFilter(req,res);
    }

}
