package org.route.web;

import java.io.IOException;
import java.security.cert.CollectionCertStoreParameters;
import java.util.Collections;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.route.model.Getalluser;

/**
 * Servlet implementation class Checkpassword
 */
public class Checkpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Checkpassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = "protocollo1";
		String password = "cazzuiu";
		String inputuser = request.getParameter("user");
		String inputpassword = request.getParameter("password");
		String inputchicedb = request.getParameter("sceltadb");

		if (user.equals(inputuser)) {
			if (password.equals(inputpassword)) {
				Getalluser getal = new Getalluser(inputchicedb);
				String[][] tuttidati = getal.getAllrow();

				request.setAttribute("tuttidati", tuttidati);
				RequestDispatcher view = request.getRequestDispatcher("webMaterViewResult.jsp");
				view.forward(request, response);

			}
		} else {
			String errore = "password o user errata";
			request.setAttribute("errore", errore);
			RequestDispatcher view = request.getRequestDispatcher("errorWebMaster.jsp");
			view.forward(request, response);
		}

	}
}
