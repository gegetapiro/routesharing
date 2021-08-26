package org.route.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Mailcontrol {
	int cont = 0;
	String esito;
	String mailtocheck;
	String driver = Togetdb.costdrive;
	String urldb = Togetdb.costtheurldb;

	public Mailcontrol(String whattamail) {
		this.mailtocheck = whattamail;

	}

	public int controlla() {
		try {
			Class.forName(driver);
			Connection conni = null;
			conni = DriverManager.getConnection(urldb);
			Statement statment = conni.createStatement();
			String aquery = "SELECT * FROM sharinguser WHERE mail = '" + mailtocheck + "'";

			ResultSet resset = statment.executeQuery(aquery);
			while (resset.next()) {
				cont++;
			}
			/*
			 * int quanti = resset.getRow(); if (quanti > 0) { esito =
			 * "mail già presente"; } else { esito = ""; }
			 */
			statment.close();
			conni.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return cont;
	}

}
