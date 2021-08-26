package org.route.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.route.model.Putcount;
import org.route.model.Togetdb;

/**
 * Servlet implementation class Counter
 */
public class Counter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Counter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String valoreip = request.getParameter("valoreip");

		Putcount putco = new Putcount(valoreip);
		String oresult = putco.insertip();
//		System.out.print(oresult);

	}
}