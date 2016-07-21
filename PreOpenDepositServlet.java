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
import exceptions.DepositException;
import actions.ClientActions;

@WebServlet("/PreOpenDeposit")
public class PreOpenDepositServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public PreOpenDepositServlet() 
    {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		if(session!=null)
		{
			long depositId = Long.parseLong(request.getParameter("depositId"));
			ClientActions clientAction = (ClientActions)session.getAttribute("clientAction");
			try 
			{
				clientAction.preOpenDeposit(depositId);
				String msg = "You have successfully pre-open deposit number: "+depositId;
				Utils.functionForSuccess(request, response, msg);
			} 
			catch (SQLException | DepositException | ServletException | IOException e) 
			{
				Utils.functionForError(request, response, e);
			} 
		}
	}
}
