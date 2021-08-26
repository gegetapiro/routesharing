package org.route.model;

import java.util.ArrayList;

public class Utente {
	int c = 0;
	String[] utentefull = new String[7];
	ArrayList<String[]> utenti = new ArrayList<String[]>(1);

	public void setUtentefull(String[] utentefull) {

		this.utentefull = utentefull;
		this.utenti.add(c, utentefull);
		c++;
	}

	public ArrayList<String[]> getUserfull() {
		return this.utenti;
	}

}
