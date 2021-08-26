package org.route.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.route.model.Filldateonceuser;
import org.route.model.Insertday;
import org.route.model.Whattaday;

/**
 * Servlet implementation class Cordioncetrip
 */
public class Cordioncetrip extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cordioncetrip() {
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
		String cordistartlat = request.getParameter("cordistartlat");
		String cordistartlong = request.getParameter("cordistartlong");
		String cordiarrivelat = request.getParameter("cordiarrivelat");
		String cordiarrivelong = request.getParameter("cordiarrivelong");
		String thenik = request.getParameter("nick");
		String themail = request.getParameter("lamail");
		String thecell = request.getParameter("cellphone");
		String thephone = request.getParameter("phone");
		String addresstart = request.getParameter("addresstarthidden");
		String addresarrive = request.getParameter("addressarrivehidden");
		String thenote = request.getParameter("lenote");
		String thepassword = request.getParameter("pw");
		String startdate = request.getParameter("datetimepicker4");
		String possibledelay = request.getParameter("giorni");
		String whattadeal = request.getParameter("tipoaccordo");
		String howmuch = request.getParameter("cifra");
		String language = request.getParameter("whatlanguage");
		// Insertday insday = new Insertday();
		// String insertdate = insday.getInsertday();
		String risultato;

		Filldateonceuser fionce = new Filldateonceuser(cordistartlat, cordistartlong, cordiarrivelat, cordiarrivelong, thenik, themail, thecell, thephone, addresstart, addresarrive, thenote,
				thepassword, startdate, possibledelay, whattadeal, howmuch);
		risultato = fionce.insertData();
		request.setAttribute("esito", risultato);
		request.setAttribute("indimail", themail);
		request.setAttribute("thepassword", thepassword);
		if (language.equals("english")) {
			RequestDispatcher view = request.getRequestDispatcher("worldwide/resultlongtrip.jsp");
			view.forward(request, response);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("resultlongtrip.jsp");
			view.forward(request, response);
		}

	}
}
