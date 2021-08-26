package org.route.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Calcrowvalid {
	String thedrive = Togetdb.costdrive;

	String theurldb = Togetdb.costtheurldb;

	double latihunter;

	double longihunter;

	double latihunterarrive;

	double longihunterarrive;

	double latiprey;

	double longiprey;

	double latipreyarrive;

	double longipreyarrive;

	double distanza;

	double distanza2;

	double tolleranza = 0.056481249541418956;

	String escludiuser;
	int manyrow;

	public Calcrowvalid(String inputlatihunter, String inputlongihunter, String inputlathuarrive,
			String inputlonghuarrive, String inesuser) {
		this.latihunter = Double.parseDouble(inputlatihunter);
		this.longihunter = Double.parseDouble(inputlongihunter);
		this.latihunterarrive = Double.parseDouble(inputlathuarrive);
		this.longihunterarrive = Double.parseDouble(inputlonghuarrive);
		this.escludiuser = inesuser;

	}

	public int getConto() {
		try {
			Class.forName(thedrive);
			Connection coni = DriverManager.getConnection(theurldb);
			Statement sti = coni.createStatement();
			String aquery = "SELECT * FROM sharinguser WHERE mail != '" + escludiuser + "'";
			ResultSet rs = sti.executeQuery(aquery);
			while (rs.next()) {
				latiprey = Double.parseDouble(rs.getString(9));
				longiprey = Double.parseDouble(rs.getString(10));
				Pitagora pit = new Pitagora(latihunter, longihunter, latiprey, longiprey);
				distanza = pit.getDistance();
				if (distanza < tolleranza) {
					latipreyarrive = Double.parseDouble(rs.getString(11));
					longipreyarrive = Double.parseDouble(rs.getString(12));
					Pitagora pit2 = new Pitagora(latihunterarrive, longihunterarrive,
							latipreyarrive, longipreyarrive);
					distanza2 = pit2.getDistance();
					if (distanza2 < tolleranza) {

						if (rs.getString(1) != null) {

							manyrow++;

						}

					} else {
						manyrow = 0;
					}

				} else {
					manyrow = 0;
				}

			}

		} catch (Exception e) {
			manyrow = -1;
		}

		return manyrow;
	}
}