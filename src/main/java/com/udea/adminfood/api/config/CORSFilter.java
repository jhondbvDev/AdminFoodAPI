package com.udea.adminfood.api.config;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class CORSFilter implements Filter {


    @Override
	public void destroy() {
	}
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        		HttpServletResponse _response = (HttpServletResponse) response;
                _response.setHeader("Access-Control-Allow-Origin", "*");
                _response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
                _response.setHeader("Access-Control-Allow-Headers", "x-requested-with, origin, content-type, accept");
                _response.setHeader("Access-Control-Max-Age", "1800");
		chain.doFilter(request, response);
        
    }

    @Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
    
}
