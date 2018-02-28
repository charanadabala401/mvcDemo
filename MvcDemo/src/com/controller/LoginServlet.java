package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.BankBean;
import com.daoimpl.BankImpl;

/**
 * Servlet implementation class LoginServlet
 */
/**
 * @author Charan
 * 
 * Login 
 *
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	BankBean b=new BankBean();
	b.setEmail(request.getParameter("email"));
	b.setPassword(request.getParameter("password"));
	BankImpl bi=new BankImpl();
	int status=bi.login(b);
	HttpSession session=request.getSession(true);
	session.setAttribute("email",b.getEmail());
	
	
	if(status==1){
		RequestDispatcher rd=request.getRequestDispatcher("AdminHome.jsp");
		rd.forward(request, response);
	}
	else if(status==2){
		RequestDispatcher rd=request.getRequestDispatcher("UserHome.jsp");
		rd.forward(request, response);
	}
	else{
		request.setAttribute("message", "Invalid Email and password");
		RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
		rd.forward(request, response);
	}
	}

}
