
package henry416;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.util.*;


@WebFilter(urlPatterns="/*", asyncSupported=true)
public class UrlAccessLog implements Filter {

    private FilterConfig filterConf = null;

    public void init(FilterConfig filterConf) {
        this.filterConf = filterConf;
    }

    public void doFilter(ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        String userAddy = request.getRemoteHost();
        filterConf.getServletContext().log("Vistor User IP: " + userAddy);
		/*
		// Get the IP address of client machine.   
		String ipAddress = request.getRemoteAddr();

		// Log the IP address and current timestamp.
		System.out.println("IP "+ ipAddress + ", Time " + new Date().toString());
		*/
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
