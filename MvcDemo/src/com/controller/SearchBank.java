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
 * Servlet implementation class Searchbank
 */
/**
 * @author Charan
 * 
 * Search Particular Bank
 *
 */
@WebServlet("/searchbank")
public class SearchBank extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBank() {
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
		
		BankBean b=new BankBean();
		b.setBankId(Integer.parseInt(request.getParameter("bankId")));
		BankImpl bi=new BankImpl();
		ArrayList<BankBean>bList=bi.searchBank(b.getBankId());
		if(bList!=null){
			request.setAttribute("banklist", bList);
			
		RequestDispatcher rd=request.getRequestDispatcher("BankList.jsp");
		rd.forward(request, response);
		
		
	}
		else{
			
			RequestDispatcher rd=request.getRequestDispatcher("AdminHome.jsp");
			rd.forward(request, response);}
		}


		
	}