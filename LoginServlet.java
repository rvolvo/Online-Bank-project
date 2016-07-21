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
import beans.ClientBean;
import actions.ClientActions;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	//In this project JDBC is being used so we add the JDBC driver name to the project
	//We called the Class.forName method from init method of LoginServlet
	public void init() throws ServletException 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}

	//This function gets all the requests which send from the browser in get method
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//Returns the client to the welcome file of the MbankOnline
		//Prevent from clients to send sensitive info by String Query  
		//sendRedirect for create new request & response
		response.sendRedirect("http://localhost:8080/MbankOnline");
	}

	//This function gets all the requests which send from the browser in post method
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ClientActions clientActions = new ClientActions();
		boolean login = false;
		try 
		{
			if(request.getParameter("clientId")!=null)
			{
				login = clientActions.login(Long.parseLong(
						request.getParameter("clientId")), 
						request.getParameter("clientName"), 
						request.getParameter("clientPassword"));
			}
			String nextServlet;
			if(login)
			{
				//If all the login parameters are valid and correct
				//we create a new session and forward the client to the main page
				request.setAttribute("isLogin", "true");
				ClientBean clientBean = clientActions.viewClientDetails(Long.parseLong(request.getParameter("clientId")));
				HttpSession session = request.getSession(true);
				session.setAttribute("clientBean", clientBean);
				session.setAttribute("clientAction", clientActions);
				nextServlet = "/main.jsp";
			}
			else
			{
				request.setAttribute("isLogin", "false");
				nextServlet = "/login.jsp";
			}
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextServlet);
			dispatcher.forward(request,response);
		} 
		catch (NumberFormatException | SQLException | ClientDoesNotExistException | ServletException | IOException e) 
		{
			Utils.functionForError(request, response, e);
		} 
	}
}
