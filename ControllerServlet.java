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

@WebServlet("/Controller")
public class ControllerServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public ControllerServlet() 
	{
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		String command = request.getParameter("command");
		String nextServlet = null;

		if(command!=null)
		{
			if(command.equals("logout"))
			{
				HttpSession session = request.getSession(false);			
				if(session!=null)
				{
					session.invalidate();
				}
				nextServlet = "/login.jsp";
			}
			else if(command.equals("homePage"))
			{
				nextServlet = "/main.jsp";
			}
			else if(command.equals("viewActivities"))
			{
				nextServlet = "/Activities";
			}
			else if(command.equals("viewDeposits"))
			{
				nextServlet = "/Deposits";
			}
			else if(command.equals("viewAccount"))
			{
				nextServlet = "/Account";
			}
			else if(command.equals("viewDetails"))
			{
				nextServlet = "/Client";
			}
			else if(command.equals("viewProperties"))
			{
				nextServlet = "/Properties";
			}
			else if(command.equals("withdraw"))
			{
				nextServlet = "/withdraw.jsp";
			}
			else if(command.equals("deposit"))
			{
				nextServlet = "/depositToAccount.jsp";
			}
			else if(command.equals("newDeposit"))
			{
				nextServlet = "/newDeposit.jsp";
			}
			else if(command.equals("preOpenDeposit"))
			{
				nextServlet = "/preOpenDeposit.jsp";
			}
			else if(command.equals("updateDetails"))
			{
				nextServlet = "/updateClientDetails.jsp";
			}
			else if(command.equals("aboutMbank"))
			{
				nextServlet = "/aboutMbank.jsp";
			}
			else if(command.equals("contactUs"))
			{
				nextServlet = "/contactUs.jsp";
			}

			try 
			{
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
