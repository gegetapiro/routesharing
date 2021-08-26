package org.route.model;

import java.sql.*;

public class Putcount {
	String ip;
	String drive = Togetdb.costdrive;
	String urldb = Togetdb.costtheurldb;
	String result;

	public Putcount(String ip) {
		this.ip = ip;

	}

	public String insertip() {
		try {
			Class.forName(drive);
			Connection con = null;
			con = DriverManager.getConnection(urldb);
			Statement stat = con.createStatement();
			String manyrowquery = "SELECT COUNT(*) AS totale FROM counter5";
			// String query = "SELECT * FROM counter5";
			ResultSet res = stat.executeQuery(manyrowquery);
			res.next();
			if (res.getInt("totale") == 0) {
				String queryinsert = "INSERT INTO counter5 (ip) values ('" + ip + "')";
				stat.executeUpdate(queryinsert);
				stat.close();
				con.close();
				result = "dato inserito da primo if";

			} else {
				String realquery = "SELECT * FROM counter5 WHERE ip = '" + ip + "'";
				ResultSet res2 = stat.executeQuery(realquery);

				if (!res2.next()) {
					String queryinsert2 = "INSERT INTO counter5 (ip) values ('" + ip + "')";
					stat.executeUpdate(queryinsert2);
					stat.close();
					con.close();

				}
				result = " su else";

			}

		} catch (Exception e) {
			// TODO: handle exception
			result = "dato fallito " + e;
		}
		return result;
	}

}
