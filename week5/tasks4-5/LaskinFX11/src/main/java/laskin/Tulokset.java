package laskin;

import java.util.ArrayList;

public class Tulokset {
	
	private ArrayList<Integer> tulokset;
	private int index;

	public Tulokset() {
		tulokset = new ArrayList<>();
	}

	public ArrayList<Integer> getTulokset() {
		return tulokset;
	}
	
	public void setTulokset(ArrayList<Integer> tulokset) {
		this.tulokset = tulokset;
	}
}
