package helpers;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter 
{
	public void init(FilterConfig fConfig) throws ServletException 
	{

	}

	public SessionFilter() 
	{

	}

	public void destroy() 
	{

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		//Do not create a new session if one does not exist
		HttpSession session = ((HttpServletRequest) request).getSession(false);
		HttpServletResponse res = (HttpServletResponse) response;

		if(session==null)
		{
			res.sendRedirect("http://localhost:8080/MbankOnline/");
		}
		else
		{	
			chain.doFilter(request, response);
		}
	}
}
