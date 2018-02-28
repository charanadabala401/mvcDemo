package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.BankBean;
import com.daoimpl.BankImpl;

/**
 * Servlet implementation class AddBankAction
 */
/**
 * @author Charan
 * 
 * 
 * Add Employee Controller
 *
 */
@WebServlet("/addbankaction")
public class AddBankAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBankAction() {
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
		b.setBankName(request.getParameter("bankname"));
		b.setIfsc(request.getParameter("ifsc"));
		b.setAddress(request.getParameter("address"));
		BankImpl bi=new BankImpl();
		String status=bi.addBank(b);
		if(status.equals("Success")){
			request.setAttribute("message","Bank Added");
			RequestDispatcher rd=request.getRequestDispatcher("AddBank.jsp");
			rd.forward(request, response);
		}
		else{
			request.setAttribute("message","Fail to Add Bank");
			RequestDispatcher rd=request.getRequestDispatcher("AddBank.jsp");
			rd.forward(request, response);
		}
	}

}
