package servlets;

import helpers.Utils;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import exceptions.ClientDoesNotExistException;
import beans.AccountBean;
import beans.ClientBean;
import actions.ClientActions;

@WebServlet("/Account")
public class AccountServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public AccountServlet() 
	{
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		if (session!=null)
		{
			ClientActions clientAction = (ClientActions)session.getAttribute("clientAction");
			ClientBean clienBean = (ClientBean)session.getAttribute("clientBean");
			try 
			{
				AccountBean accountBean = clientAction.viewAccountDetails(clienBean.getClientId());
				session.setAttribute("accountBean", accountBean);
				String nextServlet = "/account.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextServlet);
				dispatcher.forward(request,response);
			} 
			catch (SQLException | ClientDoesNotExistException | ServletException | IOException e) 
			{
				Utils.functionForError(request, response, e);
			} 		
		}
	}
}
