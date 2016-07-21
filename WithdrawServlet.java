package servlets;

import helpers.Utils;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import exceptions.ClientDoesNotExistException;
import exceptions.WithdrawException;
import actions.ClientActions;
import beans.ClientBean;

@WebServlet("/Withdraw")
public class WithdrawServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public WithdrawServlet() 
	{
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		if (session!=null)
		{
			double withdrawAmount = Double.parseDouble(request.getParameter("amount"));	
			ClientActions clientAction = (ClientActions)session.getAttribute("clientAction");
			ClientBean clientBean = (ClientBean)session.getAttribute("clientBean");
			try 
			{
				clientAction.withdrawFromAccount(clientBean.getClientId(), withdrawAmount);
				String msg = "You have successfully withdrawed "+withdrawAmount
						+"$ from your account. Activity has been saved in your records";		
				Utils.functionForSuccess(request, response, msg);
			} 
			catch (SQLException | ClientDoesNotExistException | WithdrawException | ServletException | IOException e) 
			{
				Utils.functionForError(request, response, e);
			} 
		}
	}
}
