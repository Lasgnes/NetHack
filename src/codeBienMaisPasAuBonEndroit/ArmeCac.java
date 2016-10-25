package codeBienMaisPasAuBonEndroit;

import java.util.Random;

import metiers.Guerrier;
import metiers.Ranger;
import personnage.Personnage;
import races.Elf;
import races.Nain;

public class ArmeCac implements Arme{
	//Cac pour Corps � Corps
	
	private String nom = "Ep�e";
	private int forceMod = 0;
	private int degat = 1;

	public static void main(String[] args) {
		Personnage p1 = new Personnage("Legolas", new Elf(), new Ranger());
		Personnage p2 = new Personnage("Gimli fils de Gloin", new Nain(), new Guerrier());
		ArmeCac a = new ArmeCac("Ep�e", 1, 3);
		a.attaquer(p1, p2);

	}
	/**
	 * Constructeur vide
	 */
	public ArmeCac() { }
	/**
	 * Constructeur
	 * @param nom : Nom de l'Arc
	 * @param forceMod : Modificateur de force
	 * @param degat : degat de l'Arc
	 */
	public ArmeCac(String nom, int forceMod, int degat) {
		this.nom = nom;
		this.forceMod = forceMod;
		this.degat = degat;
	}

	@Override
	public void attaquer(Personnage att, Personnage def) {
		String log = "";
		if(att.getI() > def.getI()){
			log =  att.getNom() + " (I=" + att.getI() +")attaque " + def.getNom() + " (I=" + def.getI() + ") avec " + this.toString() + "\n";
			log = log + this.toucher(att.getCt(), att.getF(), def);
			if(def.estVivant()){
				log = log + def.getNom() + " (I=" + def.getI() +")attaque " + att.getNom() + " (I=" + att.getI() + ") avec " + this.toString() + "\n";
				log = log + this.toucher(def.getCt(), def.getF(), att);
			}
		}else if(att.getI() < def.getI()){
			log =  def.getNom() + " (I=" + def.getI() +")attaque " + att.getNom() + " (I=" + att.getI() + ") avec " + this.toString() + "\n";
			log = log + this.toucher(def.getCt(), def.getF(), att);
			if(att.estVivant()){
				log = log + att.getNom() + " (I=" + att.getI() +")attaque " + def.getNom() + " (I=" + def.getI() + ") avec " + this.toString() + "\n";
				log = log + this.toucher(att.getCt(), att.getF(), def);
			}
		}else {
			log =  att.getNom() + " (I=" + att.getI() +")attaque " + def.getNom() + " (I=" + def.getI() + ") avec " + this.toString() + "\n";
			log = log + this.toucher(att.getCt(), att.getF(), def);
			log = log + att.getNom() + " (I=" + att.getI() +")attaque " + def.getNom() + " (I=" + def.getI() + ") avec " + this.toString() + "\n";
			log = log + this.toucher(att.getCt(), att.getF(), def);
		}
		System.out.println(log);
	}
	/**
	 * Test pour toucher
	 * @param ct : Capacit� de tir de l'attaquant
	 * @param f : Force de l'attaquant
	 * @param def : D�fenseur
	 * @return
	 */
	private String toucher(int ct, int f, Personnage def){
		Random rand = new Random();
		int resultat = rand.nextInt(6) + 1;
		int cible = 0;
		boolean relance = false;
		
		//d�finir la cible � atteindre avec le r�sultat du random
		if(ct < 6){
			cible = 7 - ct;
		}else {
			cible = 2;
			relance = true;
		}
		
		String log = " (resultat : " + resultat + ", cible : " + cible + ")\n";
		//r�sultat : si on touche, appel � blesser(int, Personnage), sinon on relance si on peut, sinon on rate
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
	 * @param def : d�fenseur
	 * @return
	 */
	private String blesser(int f, Personnage def){
		Random rand = new Random();
		int resultat = rand.nextInt(6) + 1;
		int cible = 0;
		f = f + forceMod;
		int e = def.getE();
		
		//d�finir la cible � atteindre avec le r�sultat du random
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
			//si on blesse on applique les d�gats
			if(resultat >= cible){
				log = "et blesse \\o/" + log + appliquerDegat(def);
			}else {
				log = "mais ne le blesse pas :/" + log;
			}
		}else {
			log = "mais sa force (" + f + ") est trop faible pour blesser une cr�ature d'endurance (" + e + ")\n";
		}
		return log;
	}
	/**
	 * @return
	 */
	public String toString() {
		return nom + "(force : " + forceMod + ", d�gats : 1d" + degat + ")";
	}
	/**
	 * appliquer des d�gats � un Personnage
	 * @param p : Personnage bl�ss�
	 * @return
	 */
	public String appliquerDegat(Personnage p) {
		Random rand = new Random();
		int resultat = rand.nextInt(degat) + 1;
		p.setPv(p.getPv() - resultat);
		return "et inflige " + resultat + " d�gats";
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
