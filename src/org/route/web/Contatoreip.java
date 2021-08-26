package org.route.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.route.model.Readlastputin;
import org.route.model.Viewcount;

/**
 * Servlet implementation class Contatoreip
 */
public class Contatoreip extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Contatoreip() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Viewcount viwc = new Viewcount();
		String[][] tuttiip = viwc.getNumber();
		request.setAttribute("tuttiip", tuttiip);
		// ############ nuovo ######################
		Readlastputin redla = new Readlastputin();
		String[] lastvisit = redla.getLastcount();
		// System.out.println(lastvisit[0]);
		request.setAttribute("lastvisit", lastvisit);
		// #########################################

		RequestDispatcher view = request.getRequestDispatcher("countview.jsp");
		view.forward(request, response);
	}

}
