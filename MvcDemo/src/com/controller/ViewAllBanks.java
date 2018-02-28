package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.BankBean;
import com.daoimpl.BankImpl;

/**
 * Servlet implementation class ViewAllBanks
 */
/**
 * @author Charan
 * 
 * View All Bank Details
 *
 */
@WebServlet("/viewallbanks")
public class ViewAllBanks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllBanks() {
        super();
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	BankImpl bi=new BankImpl();
	ArrayList<BankBean> blist=bi.viewAllBanks();
	if(blist!=null){
		request.setAttribute("banklist", blist);
		RequestDispatcher rd=request.getRequestDispatcher("BankList.jsp");
		rd.forward(request, response);
	}
	else{
		RequestDispatcher rd=request.getRequestDispatcher("AdminHome.jsp");
		rd.forward(request, response);
	}
	}

}
