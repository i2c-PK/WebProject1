package com.ibm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginAction
 */
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//String unUserVariable;
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("Servlet-Get- userName: " + userName);
		System.out.println("Servlet-Get- password: " + password);
		
		if (userName.equals("Ali") && password.equals("Imran"))
		{
			request.setAttribute("validuser","This is valid user");
		}
		else
		{
			request.setAttribute("validuser","This is In-valid user");
		}
	
		ServletContext context= getServletContext();
		RequestDispatcher rd= context.getRequestDispatcher("/response.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
