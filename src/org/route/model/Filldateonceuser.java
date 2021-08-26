package org.route.model;

import java.sql.*;

public class Filldateonceuser {
	String thedrive = Togetdb.costdrive;
	String theurldb = Togetdb.costtheurldb;
	String esito;
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
	String startdate;
	String possibleDelay;
	String kynddeal;
	String immisionDate;
	String howmuch;

	public Filldateonceuser(String cordistarta, String cordistartb, String cordiarrivea, String cordiarriveb, String innik, String inmail, String incell, String inphone, String inaddress,
			String inaddress2, String innote, String inpass, String instartdate, String inpossibleDelay, String inKyndeal, String howmuch) {

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
		this.startdate = instartdate;
		this.possibleDelay = inpossibleDelay;
		this.kynddeal = inKyndeal;
		Whattaday wd = new Whattaday();
		this.immisionDate = wd.alltogheter;
		this.howmuch = howmuch;
	}

	public String insertData() {

		try {
			Class.forName(thedrive);
			Connection conect = null;
			conect = DriverManager.getConnection(theurldb);
			Statement st = conect.createStatement();
			String aquery = "INSERT INTO sharinguseronce(nikname, mail, cellulare, telefono, indirizzo_partenza,"
					+ " indirizzo_arrivo, note, startpointlati, startpoinlogi, arrivepointlati, arrivepointlongi,"
					+ " start_date, delay_accordion, kynddeal, password, immision_date, contributorichiesto) values ('"
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
					+ "', '" + latitudeb + "', '" + longitudeb + "', '" + startdate + "', '" + possibleDelay + "', '" + kynddeal + "', '" + lapass + "', '" + immisionDate + "', '" + howmuch + "')";
			st.executeUpdate(aquery);
			st.close();
			conect.close();
			esito = "dati per viaggio una tantum salvati correttamente";
		} catch (Exception e) {
			esito = "problema nel salvataggio dei dati: " + e;
		}
		return esito;
	}
}
