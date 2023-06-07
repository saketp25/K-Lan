package com.chatting;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Signup extends javax.servlet.http.HttpServlet
{
  public Signup() {}
  
  public void doPost(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws ServletException, IOException
  {
    PrintWriter localPrintWriter = paramHttpServletResponse.getWriter();
    try {
      paramHttpServletResponse.setContentType("text/html");
      
      Class.forName("com.mysql.jdbc.Driver");
      Connection localConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?characterEncoding=latin1","root","password");
      Statement localStatement = localConnection.createStatement();
      
      String str1 = paramHttpServletRequest.getParameter("uname");
      System.out.println(str1);
      String str2 = paramHttpServletRequest.getParameter("pw");
      System.out.println(str2);
      String str3 = "select * from chatting where username='" + str1 + "'";
      
      ResultSet localResultSet = localStatement.executeQuery(str3);
      if (localResultSet.next())
      {
    	localPrintWriter.println("User Already Exists!!");
    	localPrintWriter.println("<a href='signup.jsp'>Go Back</a>");
      } else {
          HttpSession localHttpSession = paramHttpServletRequest.getSession();
          String str5 = "INSERT INTO chatting values('" + str1 + "','" + str2 + "');";
          localStatement.executeUpdate(str5);
          localHttpSession.setAttribute("name", str1);
          localPrintWriter.println("Welcome, " + str1.toUpperCase());
          localPrintWriter.println("<a href='startchat.jsp'>let's Enter the Chat Room</a>");
          localPrintWriter.println("<a href='logout.jsp' class='logout-chat'>Logout</a>");
      }
      

      localConnection.close();
    } catch (Exception localException) {
      localException.printStackTrace();
      System.out.println("Invalid User");
    }
  }
  
  public void doGet(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws ServletException, IOException {
    doGet(paramHttpServletRequest, paramHttpServletResponse);
  }
}