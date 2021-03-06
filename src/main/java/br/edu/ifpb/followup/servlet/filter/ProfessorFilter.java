package br.edu.ifpb.followup.servlet.filter;

import br.edu.ifpb.followup.entity.Professor;
import br.edu.ifpb.followup.entity.UserType;
import br.edu.ifpb.followup.entity.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/professor/*"})
public class ProfessorFilter implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        
        Usuario user = (Usuario) req.getSession().getAttribute("user");
        
        if(user != null && user.getUserType() == UserType.PROFESSOR) {
            chain.doFilter(request, response);
        } else {
            resp.sendRedirect("/FollowUP/user/login.xhtml");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    
    @Override
    public void destroy() {
    }
    
}
