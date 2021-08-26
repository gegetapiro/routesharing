package org.route.model;

import java.util.TimerTask;

public class Dailyjob extends TimerTask {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Usetimer ust = new Usetimer();
		ust.parti();
	}

}
