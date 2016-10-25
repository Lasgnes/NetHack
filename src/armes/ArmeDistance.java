package armes;

import java.util.Random;

import personnage.Personnage;

public class ArmeDistance implements Arme{
	
	private String nom = "Arc court";
	private int forceMod = 0;
	private int degat = 1;
	
	public ArmeDistance() { }
	
	public ArmeDistance(String nom, int forceMod, int degat) {
		this.nom = nom;
		this.forceMod = forceMod;
		this.degat = degat;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean toucher(Personnage att, Personnage def) {
		Random rand = new Random();
		int resultat = rand.nextInt(6) + 1;
		boolean touche = false;
		int cible = 0;
		boolean relance = false;
		int ct = att.getCt();
		
		//d�finir la cible � atteindre avec le r�sultat du random
		if(ct < 6){
			cible = 7 - ct;
		}else {
			cible = 2;
			relance = true;
		}
		System.out.println("cible : " + cible + " resultat : " + resultat);
		//r�sultat : si on touche, appel � blesser(int, Personnage), sinon on relance si on peut, sinon on rate
		if(resultat >= cible){
			touche = true;
			System.out.println("touch�");
		}else if(relance){
			System.out.println("rat�, relance");
			Personnage p = new Personnage(att);
			p.setCt(p.getCt() - 5);
			touche = toucher(p, def);
		}else {
			System.out.println("rat�");
		}
		return touche;
	}
	
	public boolean blesser(Personnage att, Personnage def){
		Random rand = new Random();
		int resultat = rand.nextInt(6) + 1;
		int cible = 0;
		int f = att.getF();
		int e = def.getE();
		
		//d�finir la cible � atteindre avec le r�sultat du random
		f = f + forceMod;
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
		System.out.println("cible : " + cible + " resultat : " + resultat);
		//si on a assez de force
		if(cible < 7){
			//si on blesse on applique les d�gats
			if(resultat >= cible){
				System.out.println("bless�");
			}else {
				System.out.println("rat�");
			}
		}else {
			System.out.println("pas assez de force");
		}
		return true;
	}
	
	public void appliquerDegats(Personnage p) {
		Random rand = new Random();
		int resultat = rand.nextInt(degat) + 1;
		p.setPv(p.getPv() - resultat);
		System.out.println(resultat + " d�gat(s) inflig�(s)");
	}

	@Override
	public String description() {
		String desc = "Arme � distance (Nom : " + nom + ", force modificateur : " + forceMod + ", degat(s) : 1d" + degat + ")";
		return desc;
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
