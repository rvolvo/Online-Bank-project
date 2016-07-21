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
import actions.ClientActions;
import beans.ClientBean;

@WebServlet("/DepositToAccount")
public class DepositToAccountServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public DepositToAccountServlet() 
	{
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		if (session!=null)
		{
			double depositAmount = Double.parseDouble(request.getParameter("depositAmount"));
			ClientActions clientAction = (ClientActions)session.getAttribute("clientAction");
			ClientBean clienBean = (ClientBean)session.getAttribute("clientBean");
			try 
			{
				clientAction.depositToAccount(clienBean.getClientId(), depositAmount);
				String msg = "You deposited "+depositAmount
						+ "$ in your account. Activity has been saved in your records";
				Utils.functionForSuccess(request, response, msg);
			} 
			catch (SQLException | ClientDoesNotExistException | ServletException | IOException e) 
			{
				Utils.functionForError(request, response, e);
			} 	
		}
	}
}
