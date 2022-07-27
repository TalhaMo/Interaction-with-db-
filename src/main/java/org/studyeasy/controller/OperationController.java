package org.studyeasy.controller;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import org.studyeasy.entity.User;
import org.studyeasy.models.UserModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/operation")
public class OperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		page=page.toLowerCase();
		switch(page) {
	
		case "listuser":
			listUsers(request,response);
			break;
		case "adduser":
			addUserFormLoader(request,response);
			break;
		case "updateuser":
			updateUserFormLoader(request,response);
			break;
		case "deleteuser":
			deleteUser(Integer.parseInt(request.getParameter("userId")));
			listUsers(request,response);
			break;
			default:
				errorPage(request, response);
				break;
		}
	}
	private void deleteUser(int userId) {
		new UserModel().deleteUser(userId);
		return;
		
	}
	private void updateUserFormLoader(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("title", "update user");
		try {
			request.getRequestDispatcher("updateUser.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("form");
		operation=operation.toLowerCase();
		switch(operation) {
		case "adduseroperation":
			User newUser=new User(request.getParameter("username"),request.getParameter("email"));
			addUserOperation(newUser);
			listUsers(request,response);
			break;
		case "updateuseroperation":
			User updatedUser=new User(Integer.parseInt(request.getParameter("userId")), request.getParameter("username"),request.getParameter("email"));
			updateUserOperation(updatedUser);
			listUsers(request,response);
			break;
			default:
				errorPage(request, response);
				break;
		}
	}
	

	
	private void updateUserOperation(User updateUser) {
		try {
			new UserModel().updateUser(updateUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
		
	}
	private void addUserOperation(User newUser) {
		try {
			new UserModel().addUser(newUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	public void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> listUsers=new ArrayList<>();
		listUsers=new UserModel().listUsers();
		request.setAttribute("listUsers", listUsers);
		request.setAttribute("title", "list of users");
		request.getRequestDispatcher("listUser.jsp").forward(request, response);
	}
	
	public void addUserFormLoader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "add user");
		request.getRequestDispatcher("addUser.jsp").forward(request, response);
	}
	public void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "error page");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}

}
