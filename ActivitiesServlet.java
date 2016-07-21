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
import actions.ClientActions;
import beans.ActivityBean;
import beans.ClientBean;

@WebServlet("/Activities")
public class ActivitiesServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public ActivitiesServlet()
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
				List<ActivityBean> clientActivities = clientAction.viewClientActivities(clientBean.getClientId());
				session.setAttribute("clientActivities", clientActivities);
				String nextServlet = "/activities.jsp";
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
