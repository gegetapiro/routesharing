package org.route.model;

import java.sql.*;
import java.util.ArrayList;

import org.route.model.Togetdb;

public class Searchcompcordi {
	// int reitera = 0;
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

	double tolleranza = 0.022070232528182604;
	// double tolleranza = 0.056481249541418956;
	// double tolleranza = 0.156481249541418956;

	String escludiuser;
	public ArrayList<String> datiutente = new ArrayList<String>();

	/*
	 * public ArrayList<ArrayList<String>> utentiqui = new
	 * ArrayList<ArrayList<String>>();
	 */

	/* private String[][] datiutente; */

	public Searchcompcordi(String inputlatihunter, String inputlongihunter, String inputlathuarrive, String inputlonghuarrive, String inesuser) {

		this.latihunter = Double.parseDouble(inputlatihunter);
		this.longihunter = Double.parseDouble(inputlongihunter);
		this.latihunterarrive = Double.parseDouble(inputlathuarrive);
		this.longihunterarrive = Double.parseDouble(inputlonghuarrive);
		this.escludiuser = inesuser;
	}

	public ArrayList<String> ceck() {

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
					Pitagora pit2 = new Pitagora(latihunterarrive, longihunterarrive, latipreyarrive, longipreyarrive);
					distanza2 = pit2.getDistance();

					if (distanza2 < tolleranza) {
						if (rs.getString(1) != null) {
							datiutente.add("<strong>nome: </strong> " + rs.getString(2) + " ");
							datiutente.add(rs.getString(3));
							datiutente.add("<strong> cellulare: </strong> " + rs.getString(4));
							datiutente.add("<strong> telefono: </strong> " + rs.getString(5));
							datiutente.add("<strong> abitazione: </strong> " + rs.getString(6));
							datiutente.add("<strong> lavoro: </strong> " + rs.getString(7));
							datiutente.add("<strong> note: </strong> " + rs.getString(8));
						}
					}
				}
			}
		} catch (Exception e) {

			datiutente.add("problemi " + e);
			return datiutente;

		}
		return datiutente;

	}

}
