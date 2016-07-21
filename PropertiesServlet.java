package servlets;

import helpers.Utils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import exceptions.PropertyDoesNotExistException;
import actions.ClientActions;

@WebServlet("/Properties")
public class PropertiesServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public PropertiesServlet() 
	{
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		if (session!=null)
		{
			ClientActions clientAction = (ClientActions)session.getAttribute("clientAction");
			try 
			{
				List<String> propertiesList = clientAction.viewAllPropertiesKeys();
				Map<String, String> propMap = new HashMap<String, String>();
				for (int i=0; i<propertiesList.size(); i++)
				{
					if((!propertiesList.get(i).equals("admin_username")) &&
							(!propertiesList.get(i).equals("admin_password")))	
					{
						propMap.put(propertiesList.get(i), clientAction.viewSystemProperty(propertiesList.get(i)));
					}
				}
				session.setAttribute("propMap", propMap);
				String nextServlet = "/properties.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextServlet);
				dispatcher.forward(request,response);
			} 
			catch (SQLException | PropertyDoesNotExistException | ServletException | IOException e)
			{
				Utils.functionForError(request, response, e);
			}
		}
	}
}
