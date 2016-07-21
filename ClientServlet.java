package servlets;

import helpers.Utils;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Client")
public class ClientServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public ClientServlet() 
	{
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		if (session!=null)
		{
			try 
			{
				String nextServlet = "/client.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextServlet);
				dispatcher.forward(request,response);
			} 
			catch (ServletException | IOException e) 
			{
				Utils.functionForError(request, response, e);
			}	
		}
	}
}
