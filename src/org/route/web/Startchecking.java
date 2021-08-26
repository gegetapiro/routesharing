package org.route.web;

import java.io.IOException;
import java.util.Timer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.route.model.Dailyjob;
import org.route.model.Usetimer;
import org.route.model.batchjob.Intermediatejob;

/**
 * Servlet implementation class Startchecking
 */
public class Startchecking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public boolean rungoing = false;
	Intermediatejob interjob;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Startchecking() {
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
		if (rungoing == false) {
			interjob = new Intermediatejob();
			interjob.lancia();
			rungoing = true;
		} else {
			interjob.stoppa();
			rungoing = false;
		}
		

	}
}
