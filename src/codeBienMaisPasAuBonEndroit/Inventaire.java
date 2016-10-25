package codeBienMaisPasAuBonEndroit;

import java.util.ArrayList;

public class Inventaire {
	
	private ArrayList<Item> inventaire;
	
	public Inventaire() { }
	
	public Inventaire(Item i) {
		inventaire = new ArrayList<Item>();
		this.ajouterItem(i);
	}
	
	/*Inventaire(ArrayList<Item> listItems) {
		inventaire = listItems;
	}*/
	
	public void ajouterItem(Item i) {
		inventaire.add(i);
	}
	
	public void retirerItem(Item i) {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Item> getInventaire() {
		return inventaire;
	}

	public void setInventaire(ArrayList<Item> inventaire) {
		this.inventaire = inventaire;
	}

}
