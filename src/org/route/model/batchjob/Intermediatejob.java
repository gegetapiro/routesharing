package org.route.model.batchjob;

import java.util.Timer;

import org.route.model.Dailyjob;

public class Intermediatejob {
	Timer tim;

	public void lancia() {
		tim = new Timer();
		 tim.schedule(new Dailyjob(), 0, 86400000);
		//tim.schedule(new Dailyjob(), 0, 180000);

	}

	public void stoppa() {
		tim.cancel();
		tim.purge();
	}
}
