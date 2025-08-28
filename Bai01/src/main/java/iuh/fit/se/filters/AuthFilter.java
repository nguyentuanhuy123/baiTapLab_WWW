package iuh.fit.se.filters;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class AuthFilter implements Filter {
    public void init(FilterConfig filterConfig) {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);

        if (session != null && session.getAttribute("user") != null) {
            chain.doFilter(request, response);
        } else {
            HttpServletResponse res = (HttpServletResponse) response;
            res.sendRedirect("login.jsp");
        }
    }

    public void destroy() {}
}
