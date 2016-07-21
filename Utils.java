package helpers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Utils
{
	public static void functionForError(HttpServletRequest request, HttpServletResponse response, Exception e) throws ServletException, IOException
	{
		request.setAttribute("errorMsg", e.getMessage());
		request.setAttribute("errorCause", e.getCause());
		String nextServlet = "/error.jsp";
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(nextServlet);
		dispatcher.forward(request,response);
	}

	public static void functionForSuccess(HttpServletRequest request, HttpServletResponse response, String msg) throws ServletException, IOException
	{
		request.setAttribute("successMsg", msg);			
		String nextServlet = "/success.jsp";
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(nextServlet);
		dispatcher.forward(request,response);
	}
}
