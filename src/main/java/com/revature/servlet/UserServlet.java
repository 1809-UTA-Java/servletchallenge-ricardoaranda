package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.User;

@SuppressWarnings("serial")
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		String arg1 = req.getParameter("username");
		String arg2 = req.getParameter("password");
		
		HttpSession session = req.getSession();
		
//		if (session != null)
//			arg1 = (String) session.getAttribute("username");
		
//		pw.println("GET " + arg1 + " you are " + arg2);
		pw.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		String arg1 = req.getParameter("username");
		String arg2 = req.getParameter("password");
		User user = new User("caco", "asdf");
		
		if (!arg1.equals(user.getUsername()) || !arg2.equals(user.getPassword())) {
			pw.println("Wrong username or password.");
			pw.close();
		}
		else {
			pw.println("POST: Welcome " + arg1 + "!");
			pw.close();
		}
	}

}
