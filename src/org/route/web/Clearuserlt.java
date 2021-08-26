package org.route.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.route.model.Clearrow;

/**
 * Servlet implementation class Clearuserlt
 */
public class Clearuserlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Clearuserlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String whouserlt = request.getParameter("mailtoclearlt");
		String whatpwlt = request.getParameter("clearpasslt");
		String whattatablt = "sharinguseronce";
		String esito;
		Clearrow clo = new Clearrow(whouserlt, whatpwlt, whattatablt);
		esito = clo.doit();
		request.setAttribute("esito", esito);
		RequestDispatcher view = request.getRequestDispatcher("editclearpage.jsp");
		view.forward(request, response);

	}

}
