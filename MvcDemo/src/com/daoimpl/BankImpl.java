package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.beans.BankBean;
import com.controller.DbConnection;
import com.dao.Bank;
import com.dao.Queries;

public class BankImpl implements Bank,Queries{
	Connection con=DbConnection.getMySqlConnection();
	PreparedStatement ps=null;
	ResultSet rs=null;

	@Override
	public int login(BankBean b) {
	int status=0;
	try {
		ps=con.prepareStatement(LOGIN);
		ps.setString(1, b.getEmail());
		ps.setString(2, b.getPassword());
		rs=ps.executeQuery();
		String dbEmail="";
		String dbPassword="";
	    int dbroleId=0;
		while(rs.next()){
			dbEmail=rs.getString(3);
			dbPassword=rs.getString(4);
		    dbroleId=rs.getInt(6);	
		}
		if(dbEmail.equals(b.getEmail())&&dbPassword.equals(b.getPassword()) && dbroleId==1){
			status=1;
		}
		else if(dbEmail.equals(b.getEmail())&&dbPassword.equals(b.getPassword()) && dbroleId==2){
			status=2;
		}
		else{
			status=0;
		}
		
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}	
		
		
		
		
		
		
		return status;
	}

	@Override
	public String addBank(BankBean b) {
		String status="";
		try {
			ps=con.prepareStatement(ADDBANK);
			ps.setString(1,b.getBankName());
			ps.setString(2,b.getIfsc());
			ps.setString(3,b.getAddress());
			int i=ps.executeUpdate();
		    if(i==1){
		    	status="Success";
		    }
		    else{
		    	status="Fail";
		    }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public ArrayList<BankBean> viewAllBanks() {
		ArrayList<BankBean> blist=new ArrayList<>();
		try {
			ps=con.prepareStatement(VIEWALLBANKS);
			rs=ps.executeQuery();
			while(rs.next()){
				BankBean b=new BankBean();
				b.setBankId(rs.getInt(1));
				b.setBankName(rs.getString(2));
				b.setIfsc(rs.getString(3));
				b.setAddress(rs.getString(4));
				blist.add(b);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return blist;
	}

	@Override
	public ArrayList<BankBean> searchBank(int bankId) {
			ArrayList<BankBean>bList=new ArrayList<BankBean>();
			
			try {
				ps=con.prepareStatement(SEARCHBANK);
				
				ps.setInt(1,bankId);
				
				rs=ps.executeQuery();
				while(rs.next()){
					BankBean b=new BankBean();
					b.setBankId(rs.getInt(1));
					b.setBankName(rs.getString(2));
					b.setIfsc(rs.getString(3));
					b.setAddress(rs.getString(4));
					bList.add(b);
	
				}
		
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return bList;
		
		}
		

	}
