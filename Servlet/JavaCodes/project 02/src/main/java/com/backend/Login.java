package com.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Login extends HttpServlet{
	
@Override
protected void service(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
	
	PrintWriter out = response.getWriter();
	out.print("Sending Request...");
	
	System.out.println("I am using service method instead of doge method");
	System.out.println("btw they work in same way u can also ask ai for clear answer.");
	
}

}
