package org.route.model.batchjob;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TimerTask;

import org.route.model.Mailutility;
import org.route.model.Searchcompcordi;
import org.route.model.Togetdb;

public class Jobnextrun extends TimerTask {
	private String drive = Togetdb.costdrive;
	private String dburl = Togetdb.costtheurldb;
	private int conto = 0;
	private String latihunter;
	private String longihunter;
	private String latihunterarrive;
	private String longihunterarrive;
	private String pointeduser;
	private int totale;
	ArrayList<String> compuser = new ArrayList<String>();
	// ################### variabili mail avviso #################
	String mailclosingaddress = "passaggi_auto@routesharing.org";
	String mailsender = "info@routesharing.org";
	String oggetto = "conferma bach job routesharing";
	String obody = "tracciatura di avvenuto job periodico su routesharing.org";

	// ########################################################################

	public int getTot() {

		try {
			Class.forName(drive);
			Connection conni = DriverManager.getConnection(dburl);
			Statement sta = conni.createStatement();
			String thequery = "SELECT COUNT(*) AS nRows FROM sharinguser";
			ResultSet rs = sta.executeQuery(thequery);
			rs.next();
			totale = rs.getInt("nRows");
			sta.close();
			conni.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return totale;
	}

	int quantitot = getTot();

	@Override
	public void run() {
		System.out.println(quantitot);
		System.out.println("cazzo va");
		// TODO Auto-generated method stub
		int q = 0;
		int c = 0;
		int i = 0;
		try {
			Class.forName(drive);
			Connection conni = DriverManager.getConnection(dburl);
			Statement sta = conni.createStatement();
			String thequery = "SELECT * FROM sharinguser LIMIT " + conto + ", 1";
			// String thequery = "SELECT * FROM sharinguser LIMIT 4, 1";
			ResultSet rs = sta.executeQuery(thequery);
			rs.next();
			pointeduser = rs.getString(3);
			System.out.println("pointeduser" + pointeduser);
			latihunter = rs.getString(9);
			longihunter = rs.getString(10);
			latihunterarrive = rs.getString(11);
			longihunterarrive = rs.getString(12);
			Searchcompcordi srcc = new Searchcompcordi(latihunter, longihunter, latihunterarrive, longihunterarrive, pointeduser);
			compuser = srcc.ceck();
			String[][] matriceutenti = new String[compuser.size() / 7][7];
			while (q < compuser.size()) {
				matriceutenti[i][c] = compuser.get(q);

				c++;
				if (c == 7) {

					c = 0;
					i++;
				}
				if (q == compuser.size()) {
					q = 0;
				} else {
					q++;
				}

			}

			if (matriceutenti.length != 0) {
				// /############# invio mail #####################
				String destinatary = pointeduser;
				// String destinatary = "passaggi_auto@routesharing.org";
				String sendermail = "info@routesharing.org";
				String maipbj = "invio da routesharing trovata possibile condivisione passaggi";

				try {
					/*for (int v = 0; v <= matriceutenti.length; v++) {

						System.out.println("matriceutenti[" + v + "] - " + matriceutenti[v][0] + " - " + matriceutenti[v][1] + " - " + matriceutenti[v][2] + " - " + matriceutenti[v][3] + " - "
								+ matriceutenti[v][4] + " - " + matriceutenti[v][5] + " - " + matriceutenti[v][6] + " - ");

					}*/

					Listusermailing.sendMail(destinatary, sendermail, maipbj, matriceutenti);

				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			System.out.println(conto);
			conto++;
			if (conto >= quantitot) {
				System.out.println("preso if");
				this.cancel();

				// #################### send mail alert ################
				try {
					Mailutility.sendMail(mailclosingaddress, mailsender, oggetto, obody);
				} catch (Exception e) {
					// TODO: handle exception
				}

				// ########################################################

			}
			// System.out.println("######## CONTO ########### " + conto);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
