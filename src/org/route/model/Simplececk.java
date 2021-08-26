package org.route.model;

import java.sql.*;
import org.route.model.Togetdb;

public class Simplececk {
	String thedrive = Togetdb.costdrive;

	String theurldb = Togetdb.costtheurldb;

	String user;

	String password;

	String esito;

	String[] lecordi = new String[4];

	String startlati;

	String startlong;

	String arrivelati;

	String arrivelong;
	String tabella;
	int campo;

	public Simplececk(String inputuser, int campo, String tabella) {
		this.user = inputuser;
		this.tabella = tabella;
		this.campo = campo;

	}

	public String getUser() {
		try {
			Class.forName(thedrive);
			Connection coni = DriverManager.getConnection(theurldb);
			Statement sti = coni.createStatement();
			String aquery = "SELECT * FROM " + tabella + " WHERE mail = '" + user + "'";
			ResultSet rs = sti.executeQuery(aquery);
			rs.next();
			esito = rs.getString(campo);
			startlati = rs.getString(9);
			startlong = rs.getString(10);
			arrivelati = rs.getString(11);
			arrivelong = rs.getString(12);
			rs.close();
			coni.close();
		} catch (Exception e) {
			esito = "utente non corretto";
			return esito;
		}
		return esito;
	}

	public String[] gethuntercordi() {
		lecordi[0] = startlati;
		lecordi[1] = startlong;
		lecordi[2] = arrivelati;
		lecordi[3] = arrivelong;

		return lecordi;

	}

}
