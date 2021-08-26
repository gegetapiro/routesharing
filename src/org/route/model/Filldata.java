package org.route.model;

import java.sql.*;

import javax.servlet.http.HttpSession;

public class Filldata {
	HttpSession session = null;
	String thedrive = Togetdb.costdrive;

	String theurldb = Togetdb.costtheurldb;

	String esit;

	String latitudea;

	String longitudea;

	String latitudeb;

	String longitudeb;

	String soprannome;

	String email;

	String cellulare;

	String telefono;

	String indirizzo;

	String indirizzo2;

	String note;

	String ladata;

	String lapass;

	public Filldata(String cordistarta, String cordistartb, String cordiarrivea, String cordiarriveb, String innik, String inmail, String incell, String inphone, String inaddress, String inaddress2,
			String innote, String inpass) {
		this.latitudea = cordistarta;
		this.longitudea = cordistartb;
		this.latitudeb = cordiarrivea;
		this.longitudeb = cordiarriveb;
		this.soprannome = innik;
		this.email = inmail;
		this.cellulare = incell;
		this.telefono = inphone;
		this.indirizzo = inaddress;
		this.indirizzo2 = inaddress2;
		this.note = innote;
		this.lapass = inpass;
		Whattaday wdy = new Whattaday();
		ladata = wdy.alltogheter;

	}

	public String putindata() {
		try {
			Class.forName(thedrive);
			Connection conni = null;
			conni = DriverManager.getConnection(theurldb);
			Statement statment = conni.createStatement();
			String thequery = "INSERT INTO sharinguser(nikname, mail, cellulare, " + "telefono, indirizzo, indirizzolav, note, startpointlati, startpointlongi, "
					+ "arrivepointlati, arrivepointlongi, datainserimento, password)" + "values('"
					+ soprannome
					+ "', '"
					+ email
					+ "', '"
					+ cellulare
					+ "', '"
					+ telefono
					+ "', '"
					+ indirizzo
					+ "', '"
					+ indirizzo2
					+ "', '"
					+ note
					+ "', '"
					+ latitudea
					+ "', '"
					+ longitudea
					+ "', '" + latitudeb + "', '" + longitudeb + "','" + ladata + "', '" + lapass + "')";
			statment.executeUpdate(thequery);
			statment.close();
			conni.close();
			esit = "caricamento dati riuscito in data " + ladata;

		} catch (Exception e) {
			esit = "caricamento dati fallito a causa: " + e;

		}
		return esit;

	}
}
