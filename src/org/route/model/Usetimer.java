package org.route.model;

import java.util.Timer;

import org.route.model.batchjob.Jobnextrun;

public class Usetimer {
	Timer timer = new Timer();

	public void parti() {
		// Job job = new Job();
		// timer.schedule(job, 0, 1000);
		Jobnextrun jbnx = new Jobnextrun();
		 timer.schedule(jbnx, 0, 2000);
		//timer.schedule(jbnx, 0, 1000);

	}

}
