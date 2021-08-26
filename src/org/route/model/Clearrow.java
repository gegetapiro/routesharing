package org.route.model;

import java.sql.DriverManager;

import java.sql.*;

import org.route.model.Togetdb;

import com.mysql.jdbc.Connection;

public class Clearrow {
	String thedrive = Togetdb.costdrive;
	String theurldb = Togetdb.costtheurldb;
	String esito;
	String chemail;
	String chepassword;
	String chetab;
	int delete;

	public Clearrow(String whattmail, String whattapw, String chetab) {
		this.chemail = whattmail;
		this.chepassword = whattapw;
		this.chetab = chetab;
	}

	public String doit() {
		try {
			Class.forName(thedrive);
			Connection con = (Connection) DriverManager.getConnection(theurldb);
			Statement stat = con.createStatement();
			String aquery = "DELETE FROM " + chetab + " WHERE mail = '" + chemail
					+ "' AND password = '" + chepassword + "'";
			delete = stat.executeUpdate(aquery);
			if (delete == 1) {
				esito = "Dati cancellati definitivamente";
			} else {
				esito = "cancellazzione fallita, probabile password o user errata";
			}
		} catch (Exception e) {
			esito = "cancellazione fallita " + e;
		}

		return esito;
	}
}
