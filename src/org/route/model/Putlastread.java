package org.route.model;

import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.Statement;

public class Putlastread {
	String result;
	int lastcountaccess;
	String drive = Togetdb.costdrive;
	String urldb = Togetdb.costtheurldb;

	public String Putinnum(int lastreadval) {
		try {
			Class.forName(drive);
			Connection conni = null;
			conni = DriverManager.getConnection(urldb);
			Statement sta = conni.createStatement();
			String aquery = "INSERT INTO track_x (lastReading) values ('" + lastreadval + "')";
			sta.executeUpdate(aquery);
			sta.close();
			result = "tutto bene";
		} catch (Exception e) {
			result = "problemi " + e;
		}
		return result;
	}

}
