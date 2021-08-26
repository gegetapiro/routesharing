package org.route.web;

import java.io.IOException;
/*import java.io.PrintWriter;*/

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.*;

import org.route.model.Mailutility;

public class Mailsend extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String resmail;

	public Mailsend() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String onome = request.getParameter("name");
		String amail = request.getParameter("mail");
		String otelefono = request.getParameter("tel");
		String ocell = request.getParameter("cell");
		String enote = request.getParameter("note");
		String language = request.getParameter("whatlanguage");

		String bodymail = onome + " " + amail + " " + otelefono + " " + ocell + " " + enote;

		String sender = request.getParameter("param_2");
		String recevier = request.getParameter("param_1");
		String object = request.getParameter("param_3");

		try {
			Mailutility.sendMail(recevier, sender, object, bodymail);
			resmail = "comunicazione inviata correttamente";
		} catch (MessagingException exc) {
			resmail = "invio comunicazione fallito " + exc;
		}

		request.setAttribute("resmail", resmail);
		if (language.equals("english")) {
			RequestDispatcher view = request.getRequestDispatcher("worldwide/mailresult.jsp");
			view.forward(request, response);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("mailresult.jsp");
			view.forward(request, response);
		}

	}
}