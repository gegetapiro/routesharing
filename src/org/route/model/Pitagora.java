package org.route.model;

public class Pitagora {
	double latihunter;

	double longihunter;

	double latiprey;

	double longiprey;

	double distanza;

	public Pitagora(double inlatihunter, double inlongihunter, double inlatiprey, double inlongiprey) {
		this.latihunter = inlatihunter;
		this.longihunter = inlongihunter;
		this.latiprey = inlatiprey;
		this.longiprey = inlongiprey;

	}

	// latihunter and

	public double getDistance() {
		distanza = Math.sqrt(Math.pow((latiprey - latihunter), 2)
				+ Math.pow((longiprey - longihunter), 2));
		return distanza;

	}

}
