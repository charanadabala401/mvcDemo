package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/update")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = DbConnection.getMySqlConnection();
		try {
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(con!=null)
		{System.out.println("sucess");
			}
		else
		{System.out.println("no sucess");}
		
		try {
			PreparedStatement ps = con.prepareStatement("Update `insurance`.`users` set email=? where user_id=?" );

			ps.setInt(2,Integer.parseInt(request.getParameter("id")));
			ps.setString(1,request.getParameter("email"));
         int b = ps.executeUpdate();
			con.commit();	
			System.out.println("iiiiiiiiiiiiiii"+b+request.getParameter("id")+"\\\\\\\\\\"+request.getParameter("email"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* if(b==1)
		{request.setAttribute("message", "update succes");
		RequestDispatcher rd=request.getRequestDispatcher("Update1.jsp");
		rd.forward(request, response);
			
		}
		else
		{
			request.setAttribute("message", "failed to update");
			RequestDispatcher rd=request.getRequestDispatcher("Update1.jsp");
			rd.forward(request, response);
		}
			 */
		
	}

}
