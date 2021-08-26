package org.route.model;

import java.sql.*;
import java.util.ArrayList;
import org.route.model.Togetdb;

public class Searchcomplongtrip {
	int counter = 0;
	String driver = Togetdb.costdrive;
	String dburl = Togetdb.costtheurldb;
	double hunterlat;
	double hunterlong;
	double hunterlatend;
	double hunterlongend;
	double preylat;
	double preylong;
	double preylatend;
	double preylongend;
	double distance;
	double distancesecond;
	int diametroconsentito;
	double disttoll;
	// double tollerance_1 = 0.022070232528182604;
	// double tollerance_2 = 0.022070232528182604;
	// double tollerance_3 = 0.022070232528182604;
	String excludeduser;
	private ArrayList<String> userdata = new ArrayList<String>();

	public Searchcomplongtrip(String cordi_1, String cordi_2, String cordi_3, String cordi_4, String escludiuser, int diametroconsent) {
		this.hunterlat = Double.parseDouble(cordi_1);
		this.hunterlong = Double.parseDouble(cordi_2);
		this.hunterlatend = Double.parseDouble(cordi_3);
		this.hunterlongend = Double.parseDouble(cordi_4);
		this.excludeduser = escludiuser;
		this.diametroconsentito = diametroconsent;
		switch (diametroconsentito) {
		case 1:
			disttoll = 0.022070232528182604;
			break;
		case 2:
			disttoll = 0.04306875634384885;
			break;
		case 3:
			disttoll = 0.05674759682840901;
			break;
		case 4:
			disttoll = 0.08618562506617722;
			break;
		default:
			disttoll = 0.6118285619114012;

		}
	}
	

	public ArrayList<String> Ceckcompatibility() {
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(dburl);
			Statement sta = con.createStatement();
			String thequery = "SELECT * FROM sharinguseronce WHERE mail != '" + excludeduser + "'";
			ResultSet rs = sta.executeQuery(thequery);
			while (rs.next()) {
				preylat = Double.parseDouble(rs.getString(9));
				preylong = Double.parseDouble(rs.getString(10));
				Pitagora pita = new Pitagora(hunterlat, hunterlong, preylat, preylong);
				distance = pita.getDistance();
				if (distance < disttoll) {
					preylatend = Double.parseDouble(rs.getString(11));
					preylongend = Double.parseDouble(rs.getString(12));
					Pitagora pita_2 = new Pitagora(hunterlatend, hunterlongend, preylatend, preylongend);
					distancesecond = pita_2.getDistance();
					if (distancesecond < disttoll) {
						if (rs.getString(1) != null) {
							userdata.add("<strong>nome:</strong> " + rs.getString(2));
							userdata.add(rs.getString(3));
							userdata.add("<strong>cellulare:</strong> " + rs.getString(4));
							userdata.add("<strong>telefono:</strong> " + rs.getString(5));
							userdata.add("<strong>partenza:</strong> " + rs.getString(6));
							userdata.add("<strong>arrivo:</strong> " + rs.getString(7));
							userdata.add("<strong>note:</strong> " + rs.getString(8));
							userdata.add("<strong>data partenza:</strong> " + rs.getString(13));
							userdata.add("<strong>elasticità data:</strong> " + rs.getString(15));
							userdata.add("<strong>tipo di accordo:</strong> " + rs.getString(16));
							userdata.add("<strong>contributo economico:</strong> " + rs.getString(18));

						}

					}
				}
			}

		} catch (Exception e) {
			userdata.add("problemi nella ricerca utenti compatibili " + e);
			return userdata;
		}
		return userdata;
	}

}
