package com.green.configs.filter;


import org.springframework.http.HttpHeaders;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CrossScriptingFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void destroy() {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        chain.doFilter(new RequestWrapper((HttpServletRequest) request), response);
//        addSameSite(new RequestWrapper((HttpServletRequest) request), response);

    }

    private void addSameSite(HttpServletRequest request, ServletResponse response) {
        String prcURI = "/pay/complextax/order_res.jsp";

        if (prcURI.equals(request.getRequestURI())) {
            String sessionId = request.getRequestedSessionId();

            if (response instanceof HttpServletResponse) {
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.setHeader(HttpHeaders.SET_COOKIE, "JSESSIONID=" + sessionId + "; SameSite=None");
            }
        }
    }

}
