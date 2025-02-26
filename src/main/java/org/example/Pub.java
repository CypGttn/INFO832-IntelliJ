package org.example;
import java.util.logging.Level;

/**
 * Virtual PUB
 */
public class Pub {
	private Bar bar;
	private Cave cave;

	public Pub() {
		this.bar = new Bar();
		this.cave = new Cave();
	}

	public void approvisionnerBar(String nom) {
		this.bar.add(this.cave.take(nom));
	}

	public Bar getBar() {
		return bar;
	}

	public Cave getCave() {
		return cave;
	}
}
