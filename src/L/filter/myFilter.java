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
public class myFilter implements Filter {//�����б�����UTF-8
	private String encoder;
    public myFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoder);//��������ı�����utf-8
		chain.doFilter(request, response);//�����ö�����Servlet��
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		encoder=fConfig.getInitParameter("encoder");
	}

}