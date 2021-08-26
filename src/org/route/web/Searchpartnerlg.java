package org.route.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.route.model.Searchcomplongtrip;
import org.route.model.Simplececk;

/**
 * Servlet implementation class Searchpartnerlg
 */
public class Searchpartnerlg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Searchpartnerlg() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String esitonegativo;
		String atabella = "sharinguseronce";
		int campo = 14;
		String aud = request.getParameter("udmaillt");
		String apass = request.getParameter("passwordlt");
		int choiceddiam = Integer.parseInt(request.getParameter("diametroricerca"));
		String language = getInitParameter("whatlanguage");
		String[] cordibase = new String[4];
		int q = 0;
		int c = 0;
		int i = 0;
		ArrayList<String> usergot = new ArrayList<String>();
		Simplececk sick = new Simplececk(aud, campo, atabella);
		String risu = sick.getUser();
		if (risu.equals(apass)) {
			cordibase = sick.gethuntercordi();
			Searchcomplongtrip secomtrip = new Searchcomplongtrip(cordibase[0], cordibase[1], cordibase[2], cordibase[3], aud, choiceddiam);
			usergot = secomtrip.Ceckcompatibility();
			String[][] usermatrix = new String[usergot.size()][11];
			while (q < usergot.size()) {
				usermatrix[i][c] = usergot.get(q);
				c++;
				if (c == 11) {
					c = 0;
					i++;
				}
				q++;
			}
			request.setAttribute("elements", i);
			request.setAttribute("matrix", usermatrix);
			if (language.equals("english")) {
				RequestDispatcher vista = request.getRequestDispatcher("worldwide/resreslongtrip.jsp");
				vista.forward(request, response);
			} else {
				RequestDispatcher vista = request.getRequestDispatcher("resreslongtrip.jsp");
				vista.forward(request, response);
			}

		} else {
			esitonegativo = "user o pasword errata";
			request.setAttribute("esitonegativo", esitonegativo);
			if (language.equals("english")) {
				RequestDispatcher vista = request.getRequestDispatcher("worldwide/errorpage.jsp");
				vista.forward(request, response);
			} else {
				RequestDispatcher vista = request.getRequestDispatcher("errorpage.jsp");
				vista.forward(request, response);
			}

		}

	}
}
