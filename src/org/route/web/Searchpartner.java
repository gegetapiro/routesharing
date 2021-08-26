package org.route.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.route.model.Searchcompcordi;
import org.route.model.Simplececk;

/**
 * Servlet implementation class Searchpartner
 */
public class Searchpartner extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Searchpartner() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tabella = "sharinguser";
		int campo = 14;
		String esitonegativo = "sospeso";
		String auser = request.getParameter("udmail");
		String apassword = request.getParameter("password");
		String language = request.getParameter("whatlanguage");

		String[] cordinatebase = new String[4];
		int q = 0;
		int c = 0;
		int i = 0;
		ArrayList<String> gotuser = new ArrayList<String>();

		/*
		 * ArrayList<ArrayList<String>> gotuser = new
		 * ArrayList<ArrayList<String>>();
		 */

		Simplececk sick = new Simplececk(auser, campo, tabella);
		String risultato = sick.getUser();
		if (risultato.equals(apassword)) {
			cordinatebase = sick.gethuntercordi();
			Searchcompcordi seacoco = new Searchcompcordi(cordinatebase[0], cordinatebase[1], cordinatebase[2], cordinatebase[3], auser);
			gotuser = seacoco.ceck();
			String[][] matriceutenti = new String[gotuser.size()][7];
			System.out.print(" gotuser.size() " + gotuser.size() + " ");
			while (q < gotuser.size()) {
				matriceutenti[i][c] = gotuser.get(q);
				c++;
				if (c == 7) {
					c = 0;
					i++;
				}
				q++;
			}

			request.setAttribute("resullong", i);
			request.setAttribute("risullistcomp", matriceutenti);
			if (language.equals("english")) {
				RequestDispatcher view = request.getRequestDispatcher("worldwide/researchresult.jsp");
				view.forward(request, response);
			} else {
				RequestDispatcher view = request.getRequestDispatcher("researchresult.jsp");
				view.forward(request, response);
			}

		} else {
			esitonegativo = "password o user errata";
			request.setAttribute("esitonegativo", esitonegativo);
			if (language.equals("english")) {
				RequestDispatcher vista = request.getRequestDispatcher("worldwide/errorpage.jsp");
				vista.forward(request, response);
			}
			RequestDispatcher vista = request.getRequestDispatcher("errorpage.jsp");
			vista.forward(request, response);

		}

	}
}
