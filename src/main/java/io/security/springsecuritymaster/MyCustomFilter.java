package io.security.springsecuritymaster;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class MyCustomFilter extends OncePerRequestFilter {
    private boolean flag;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(flag){
            try {
                request.login("user", "1111");
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            flag = false;
        }
        filterChain.doFilter(request,response);
    }

    public void setFlag(boolean flag){
        this.flag = flag;
    }
}
