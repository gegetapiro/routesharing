package org.route.model;

import java.sql.*;

public class Viewcount {
	int accessi;
	String drive = Togetdb.costdrive;
	String urldb = Togetdb.costtheurldb;
	String[][] allip;
	int c = 0;
	int quanti;

	public String[][] getNumber() {
		try {
			Class.forName(drive);
			Connection con = null;
			con = DriverManager.getConnection(urldb);
			Statement stat = con.createStatement();
			String aquery = "SELECT COUNT(*) AS totale FROM counter5";
			ResultSet lunga = stat.executeQuery(aquery);
			lunga.next();
			quanti = lunga.getInt("totale");
			Putlastread putlsre = new Putlastread();
			putlsre.Putinnum(quanti);
			String thequery = "SELECT * FROM counter5 ORDER BY id DESC";
			ResultSet rest = stat.executeQuery(thequery);
			allip = new String[quanti][3];
			while (rest.next()) {

				allip[c][0] = rest.getString("id");
				allip[c][1] = rest.getString("ip");
				allip[c][2] = rest.getString("data");

				c++;

			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			// allip[0][0] = "fallito recupero dati";
		}
		return allip;

	}

}
