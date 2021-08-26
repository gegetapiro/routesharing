package org.route.model;

import java.io.StreamCorruptedException;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Getalluser {
	String thedriver = Togetdb.costdrive;
	String dburl = Togetdb.costtheurldb;
	int count = 0;
	private int quanti;
	String[][] alldata;
	String whatdb;

	public Getalluser(String whatdb) {
		this.whatdb = whatdb;

	}

	// private String alldata[][];

	public String[][] getAllrow() {
		try {
			Class.forName(thedriver);
			Connection coni = (Connection) DriverManager.getConnection(dburl);
			Statement sti = (Statement) coni.createStatement();
			if (whatdb.equals("db_1")) {
				String manyrorquery = "SELECT COUNT(*) AS totale FROM sharinguser";
				ResultSet rs = sti.executeQuery(manyrorquery);
				rs.next();
				quanti = rs.getInt("totale");
				alldata = new String[quanti][15];
				String thequery = "SELECT * FROM sharinguser";
				ResultSet rs2 = sti.executeQuery(thequery);
				while (rs2.next()) {

					for (int i = 1; i <= 14; i++) {
						alldata[count][i] = rs2.getString(i);
						System.out.println(alldata[count][i]);

					}

					count++;
				}
			} else if (whatdb.equals("db_2")) {
				String manyrorquery = "SELECT COUNT(*) AS totale FROM sharinguseronce";
				ResultSet rs = sti.executeQuery(manyrorquery);
				rs.next();
				quanti = rs.getInt("totale");
				alldata = new String[quanti][19];
				String thequery = "SELECT * FROM  sharinguseronce ";
				ResultSet rs2 = sti.executeQuery(thequery);
				while (rs2.next()) {

					for (int i = 1; i <= 18; i++) {
						alldata[count][i] = rs2.getString(i);
						System.out.println(alldata[count][i]);

					}

					count++;
				}
			}

			sti.close();
			coni.close();

		} catch (Exception e) {
			// TODO: handle exception
			// alldata[0][0] = " problemi " + e;
			// return alldata;

		}

		return alldata;

	}
}
