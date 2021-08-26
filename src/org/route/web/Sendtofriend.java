package org.route.web;

import java.io.EOFException;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.route.model.Mailutility;

/**
 * Servlet implementation class Sendtofriend
 */
public class Sendtofriend extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Sendtofriend() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sendername = request.getParameter("sendername");
		String receivername = request.getParameter("recevivername");
		String sendermail = request.getParameter("udmail");
		String destinatarymail = request.getParameter("friendmail");
		String sendernote = request.getParameter("notesender");
		String object = "da Routesharing.org caro " + receivername + " un suggerimento dal tuo amico: " + sendername;
		String resmail;
		try {
			Mailutility.sendMail(destinatarymail, sendermail, object, sendernote);
			resmail = "comunicazione inviata correttamente al tuo amico " + sendername;
		} catch (MessagingException exc) {
			resmail = "invio comunicazione al tuo amico " + sendername + " fallito " + exc;
		}
		request.setAttribute("resmail", resmail);
		RequestDispatcher view = request.getRequestDispatcher("mailresult.jsp");
		view.forward(request, response);

	}
}
