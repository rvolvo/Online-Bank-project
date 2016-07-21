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

@WebServlet("/UpdateClientDetails")
public class UpdateClientDetailsServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public UpdateClientDetailsServlet() 
    {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		if (session!=null)
		{
			String clientName = request.getParameter("clientName");
			String clientPassword = request.getParameter("clientPassword");
			String clientEmail = request.getParameter("clientEmail");
			String clientAddress = request.getParameter("clientAddress");
			String clientPhone = request.getParameter("clientPhone");
			String clientComment = request.getParameter("clientComment");

			ClientActions clientAction = (ClientActions)session.getAttribute("clientAction");
			ClientBean clientBean = (ClientBean)session.getAttribute("clientBean");
			try 
			{
				clientAction.updateClientAddress(clientBean.getClientId(), clientAddress);
				clientAction.updateClientComment(clientBean.getClientId(), clientComment);
				clientAction.updateClientEmail(clientBean.getClientId(), clientEmail);
				clientAction.updateClientName(clientBean.getClientId(), clientName);
				clientAction.updateClientPassword(clientBean.getClientId(), clientPassword);
				clientAction.updateClientPhone(clientBean.getClientId(), Long.parseLong(clientPhone));
				
				clientBean = clientAction.viewClientDetails(clientBean.getClientId());
				session.setAttribute("clientBean", clientBean);
				
				String msg = "You have successfully updated your details.";
				Utils.functionForSuccess(request, response, msg);
			} 
			catch (SQLException | ClientDoesNotExistException | ServletException | IOException e) 
			{
				Utils.functionForError(request, response, e);
			}	
		}
	}
}
