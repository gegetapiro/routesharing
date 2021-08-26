package org.route.model;

import java.sql.*;
import java.text.SimpleDateFormat;

public class Readlastputin {
	String result;
	int lastcountaccess;
	String drive = Togetdb.costdrive;
	String urldb = Togetdb.costtheurldb;
	String[] datacount = new String[2];

	public String[] getLastcount() {
		try {
			Class.forName(drive);
			Connection con2 = null;
			con2 = DriverManager.getConnection(urldb);
			Statement st = con2.createStatement();
			String aqueryget = "SELECT * FROM track_x ORDER BY id DESC LIMIT 1";
			ResultSet res = st.executeQuery(aqueryget);
			res.next();
			int quando = res.getInt("lastReading");
			Timestamp ts = res.getTimestamp("date");
			datacount[0] = Integer.toString(quando);
			System.out.println(datacount[0]);
			datacount[1] = new SimpleDateFormat("dd/mm/yy").format(ts);
			con2.close();
		} catch (Exception e) {
			// datacount[0] = "problemi " + e; <----- problema qui --- vedere
			// per debug https://www.youtube.com/watch?v=XdjGQVav10M

		}
		return datacount;

	}

}
