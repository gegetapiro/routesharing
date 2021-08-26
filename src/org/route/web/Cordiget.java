package org.route.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.route.model.Filldata;
import org.route.model.Mailcontrol;

/**
 * Servlet implementation class Cordiget
 */
public class Cordiget extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Cordiget() {
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
		String cordicasalati = request.getParameter("cordistartlat");
		String cordicasalongi = request.getParameter("cordistartlong");
		String cordilavorolati = request.getParameter("cordiarrivelat");
		String cordilavorolongi = request.getParameter("cordiarrivelong");
		String thenik = request.getParameter("nick");
		String themail = request.getParameter("lamail");
		String thecell = request.getParameter("cellphone");
		String thephone = request.getParameter("phone");
		String theaddress = request.getParameter("addresstarthidden");
		String theaddressjob = request.getParameter("addressarrivehidden");
		String thenote = request.getParameter("lenote");
		String thepassword = request.getParameter("pw");
		String language = request.getParameter("whatlanguage");
		int verificamail;

		Mailcontrol mac = new Mailcontrol(themail);
		verificamail = mac.controlla();
		if (verificamail > 0) {
			String errore = "la mail: " + themail + " è già presente scegliere altra mail!";
			request.setAttribute("errore", errore);
			RequestDispatcher view = request.getRequestDispatcher("errorUser.jsp");
			view.forward(request, response);

		} else {
			Filldata fida = new Filldata(cordicasalati, cordicasalongi, cordilavorolati, cordilavorolongi, thenik, themail, thecell, thephone, theaddress, theaddressjob, thenote, thepassword);

			String esito = fida.putindata();
			request.setAttribute("esito", esito);

			request.setAttribute("indimail", themail);
			request.setAttribute("thepassword", thepassword);
			
			if (language.equals("english")) {
				RequestDispatcher view = request.getRequestDispatcher("worldwide/insertresult.jsp");
				view.forward(request, response);
			} else {
				RequestDispatcher view = request.getRequestDispatcher("insertresult.jsp");
				view.forward(request, response);
			}

		}

	}
}
