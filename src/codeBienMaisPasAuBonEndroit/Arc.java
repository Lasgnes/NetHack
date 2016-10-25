package codeBienMaisPasAuBonEndroit;

import java.util.Random;

import metiers.*;
import personnage.*;
import races.*;

public class Arc implements Arme {
	
	private String nom = "Arc court";
	private int forceMod = 0;
	private int degat = 1;

	public static void main(String[] args) {
		Personnage p1 = new Personnage("Legolas", new Elf(), new Ranger());
		Personnage p2 = new Personnage("Gimli fils de Gloin", new Nain(), new Guerrier());
		Arc a = new Arc("Long Bow", 1, 3);
		a.attaquer(p1, p2);

	}
	/**
	 * Constructeur vide
	 */
	public Arc() { }
	/**
	 * Constructeur
	 * @param nom : Nom de l'Arc
	 * @param forceMod : Modificateur de force
	 * @param degat : degat de l'Arc
	 */
	public Arc(String nom, int forceMod, int degat) {
		this.nom = nom;
		this.forceMod = forceMod;
		this.degat = degat;
	}

	@Override
	public void attaquer(Personnage att, Personnage def) {
		String log = att.getNom() + " attaque " + def.getNom() + " avec " + this.toString() + "\n";
		log = log + this.toucher(att.getCt(), att.getF(), def);
		System.out.println(log);
	}
	/**
	 * Test pour toucher
	 * @param ct : Capacité de tir de l'attaquant
	 * @param f : Force de l'attaquant
	 * @param def : Défenseur
	 * @return
	 */
	private String toucher(int ct, int f, Personnage def){
		Random rand = new Random();
		int resultat = rand.nextInt(6) + 1;
		int cible = 0;
		boolean relance = false;
		
		//définir la cible à atteindre avec le résultat du random
		if(ct < 6){
			cible = 7 - ct;
		}else {
			cible = 2;
			relance = true;
		}
		
		String log = " (resultat : " + resultat + ", cible : " + cible + ")\n";
		//résultat : si on touche, appel à blesser(int, Personnage), sinon on relance si on peut, sinon on rate
		if(resultat >= cible){
			log = "et touche" + log + blesser(f, def);
		}else if(relance){
			log = "et rate" + log + "relance : " + toucher(ct - 5, f, def);
		}else {
			log = "et rate car il est naze" + log;
		}
		return log;
	}
	/**
	 * Test pour blesser
	 * @param f : force de l'attaquant
	 * @param def : défenseur
	 * @return
	 */
	private String blesser(int f, Personnage def){
		Random rand = new Random();
		int resultat = rand.nextInt(6) + 1;
		int cible = 0;
		f = f + forceMod;
		int e = def.getE();
		
		//définir la cible à atteindre avec le résultat du random
		if(f == e){
			cible = 4;
		}else if(f > e){
			if(f >= e + 2){
				cible = 2;
			}else {
				cible = 3;
			}
		}else {
			if(f <= e-2 && f > e-4){
				cible = 6;
			}else if(f == e-1){
				cible = 5;
			}else if(f <= e-4){
				cible = 7;
			}
		}
		
		
		String log = " (resultat : " + resultat + ", cible " + cible + ")\n";
		//si on a assez de force
		if(cible < 7){
			//si on blesse on applique les dégats
			if(resultat >= cible){
				log = "et blesse \\o/" + log + appliquerDegat(def);
			}else {
				log = "mais ne le blesse pas :/" + log;
			}
		}else {
			log = "mais sa force (" + f + ") est trop faible pour blesser une créature d'endurance (" + e + ")\n";
		}
		return log;
	}
	/**
	 * @return
	 */
	public String toString() {
		return nom + "(force : " + forceMod + ", dégats : 1d" + degat + ")";
	}
	/**
	 * appliquer des dégats à un Personnage
	 * @param p : Personnage bléssé
	 * @return
	 */
	public String appliquerDegat(Personnage p) {
		Random rand = new Random();
		int resultat = rand.nextInt(degat) + 1;
		p.setPv(p.getPv() - resultat);
		return "et inflige " + resultat + " dégats";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getForceMod() {
		return forceMod;
	}

	public void setForceMod(int forceMod) {
		this.forceMod = forceMod;
	}

	public int getDegat() {
		return degat;
	}

	public void setDegat(int degat) {
		this.degat = degat;
	}

}
