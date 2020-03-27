package laskin;

import java.util.ArrayList;

public class Muisti {

	private ArrayList<Integer> tulokset;
	private int index;
	
	private Muisti() {
		tulokset = new ArrayList<>();
		index = 0;
		tulokset.add(index);
	}
	
	public static Muisti alusta() {
		return new Muisti();
	}
	
	public int getTulos() {
		return tulokset.get(index);
	}
	
	public void addTulos(int tulos) {
		tulokset.add(tulos);
		index++;
	}
	
	public ArrayList<Integer> getTulokset() {
		return tulokset;
	}
	
	public void setTulokset(ArrayList<Integer> tulokset) {
		this.tulokset = tulokset;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	@Override
	public String toString() {
		String s = "";
		for(int i: tulokset) {
			s += i + " ";
		}
		return s;
	}
}
