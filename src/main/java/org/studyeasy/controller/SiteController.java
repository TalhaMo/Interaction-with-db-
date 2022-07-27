package org.studyeasy.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/site")
public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String page = request.getParameter("page");
		//page=page.toLowerCase();
		switch(page) {
		case "home":
			homePage(request, response);
			break;
	
			default:
				errorPage(request, response);
				break;
		}
	}

	public void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "error page");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
	public void homePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "home Page");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
