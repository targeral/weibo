package L.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.*;
@WebFilter(urlPatterns = { "/*" },
			filterName = "encoding",
			initParams =@WebInitParam(name = "encoder", value = "utf-8")
)
public class myFilter implements Filter {//把所有编码变成UTF-8
	private String encoder;
    public myFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoder);//所有请求的编码变成utf-8
		chain.doFilter(request, response);//将内置对象传向Servlet中
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		encoder=fConfig.getInitParameter("encoder");
	}

}