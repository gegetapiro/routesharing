package org.route.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.route.model.Clearrow;

/**
 * Servlet implementation class Clearuser
 */
public class Clearuser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Clearuser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String whouser = request.getParameter("mailtoclear");
		String whatpw = request.getParameter("clearpass");
		String whattatab = "sharinguser";
		String esito;
		Clearrow clolt = new Clearrow(whouser, whatpw, whattatab);
		esito = clolt.doit();
		request.setAttribute("esito", esito);
		RequestDispatcher view = request.getRequestDispatcher("editclearpage.jsp");
		view.forward(request, response);

	}

}
