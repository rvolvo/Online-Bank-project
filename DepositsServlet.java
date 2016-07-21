package servlets;

import helpers.Utils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import exceptions.ClientDoesNotExistException;
import exceptions.ClientDoesNotHaveDeposit;
import actions.ClientActions;
import beans.ClientBean;
import beans.DepositBean;

@WebServlet("/Deposits")
public class DepositsServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public DepositsServlet() 
	{
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		if (session!=null)
		{
			ClientActions clientAction = (ClientActions)session.getAttribute("clientAction");
			ClientBean clientBean = (ClientBean)session.getAttribute("clientBean");
			try 
			{
				List<DepositBean> clientDeposits = clientAction.viewClientDeposits(clientBean.getClientId());
				session.setAttribute("clientDeposits", clientDeposits);
				String nextServlet = "/deposits.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextServlet);
				dispatcher.forward(request,response);
			} 
			catch (SQLException | ClientDoesNotHaveDeposit | ClientDoesNotExistException | ServletException | IOException e) 
			{
				Utils.functionForError(request, response, e);
			} 
		}
	}
}
