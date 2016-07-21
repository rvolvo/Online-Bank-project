package servlets;

import helpers.Utils;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import exceptions.ClientDoesNotExistException;
import exceptions.DepositException;
import actions.ClientActions;
import beans.ClientBean;

@WebServlet("/NewDeposit")
public class NewDepositServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public NewDepositServlet() 
	{
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		if (session!=null)
		{
			double newDepositAmount = Double.parseDouble(request.getParameter("depositAmount"));
			Date openingDate = java.sql.Date.valueOf(request.getParameter("openingDate"));
			Date closingDate = java.sql.Date.valueOf(request.getParameter("closingDate"));
			ClientActions clientAction = (ClientActions)session.getAttribute("clientAction");
			ClientBean clienBean = (ClientBean)session.getAttribute("clientBean");
			try 
			{
				clientAction.createNewDeposit(clienBean.getClientId(), newDepositAmount, 
						openingDate, closingDate);	
				String msg = "You have been created a new deposit in mbank systems. "
						+ "The new deposit balance is "+newDepositAmount+ "$. The deposit closing date is "
						+ closingDate +" . Activity has been saved in your records";
				Utils.functionForSuccess(request, response, msg);
			} 
			catch (SQLException | ClientDoesNotExistException | DepositException | ServletException | IOException e) 
			{
				Utils.functionForError(request, response, e);
			} 
		}
	}
}
