package org.route.model;

import java.sql.*;

public class Getusers {
	String thedrive = Togetdb.costdrive;

	String theurldb = Togetdb.costtheurldb;

	String esito;

	int quantirow;

	int contatore = 0;

	int many;

	public String[][] viewuser() {

		try {
			Class.forName(thedrive);
			Connection cno = DriverManager.getConnection(theurldb);
			Statement sta = cno.createStatement();
			String thequery = "SELECT COUNT(*) AS quanti FROM sharinguser";
			ResultSet rs = sta.executeQuery(thequery);
			rs.next();
			many = rs.getInt("quanti");
			sta.close();
			cno.close();

		} catch (Exception e) {

		}
		String alluser[][] = new String[many][19];
		try {
			Class.forName(thedrive);
			Connection cno = DriverManager.getConnection(theurldb);
			Statement sta = cno.createStatement();
			String thequery2 = "SELECT * FROM sharinguser";
			ResultSet rs2 = sta.executeQuery(thequery2);
			while (rs2.next()) {

				for (int i = 1; i < 19; i++) {
					alluser[contatore][i] = rs2.getString(i);
				}
				contatore++;

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return alluser;
	}
}
