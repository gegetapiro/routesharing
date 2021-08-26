package org.route.model;

import java.sql.*;
import org.route.model.Togetdb;

public class Userdata {
	String thedrive = Togetdb.costdrive;
	String theurldb = Togetdb.costtheurldb;
	String[] datiuser = new String[14];
	String user;
	String password;

	public Userdata(String userget, String passwordget) {
		this.user = userget;
		this.password = passwordget;

	}

	public String[] getUserdata() {
		try {
			Class.forName(thedrive);
			Connection co = DriverManager.getConnection(theurldb);
			Statement st = co.createStatement();
			String userquery = "SELECT * FROM sharinguser WHERE mail = '" + user
					+ "' AND password = '" + password + "'";
			ResultSet rs = st.executeQuery(userquery);
			while (rs.next()) {
				for (int i = 1; i < 14; i++) {
					datiuser[i] = rs.getString(i);
				}
			}
			st.close();
			co.close();
		} catch (Exception e) {
			datiuser[0] = "errore user o password errata " + e;
		}
		return datiuser;
	}
}