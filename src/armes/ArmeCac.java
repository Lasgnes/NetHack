package armes;

import java.util.Random;

import personnage.Personnage;

public class ArmeCac implements Arme{
	
	private String nom = "Epée";
	private int forceMod = 0;
	private int degat = 1;
	
	public ArmeCac() { }
	
	public ArmeCac(String nom, int forceMod, int degat) {
		this.nom = nom;
		this.forceMod = forceMod;
		this.degat = degat;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean toucher(Personnage att, Personnage def) {
		Random rand = new Random();
		int resultat = rand.nextInt(6) + 1;
		boolean touche = false;
		int cible = 0;
		int ccAtt = att.getCc();
		int ccDef = def.getCc();
		
		//définir la cible à atteindre avec le résultat du random
		if(ccAtt > ccDef){
			cible = 3;
		}else if(ccAtt == ccDef){
			cible = 4;
		}else {
			cible = 5;
		}
		System.out.println("cible : " + cible + " resultat : " + resultat);
		//résultat : si on touche, appel à blesser(int, Personnage), sinon on relance si on peut, sinon on rate
		if(resultat >= cible){
			touche = true;
			System.out.println("touché");
		}else {
			System.out.println("raté");
		}
		return touche;
	}

	@Override
	public boolean blesser(Personnage att, Personnage def) {
		Random rand = new Random();
		int resultat = rand.nextInt(6) + 1;
		int cible = 0;
		int f = att.getF();
		int e = def.getE();
		
		//définir la cible à atteindre avec le résultat du random
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
			//si on blesse on applique les dégats
			if(resultat >= cible){
				System.out.println("blessé");
			}else {
				System.out.println("raté");
			}
		}else {
			System.out.println("pas assez de force");
		}
		return true;
	}

	@Override
	public void appliquerDegats(Personnage p) {
		Random rand = new Random();
		int resultat = rand.nextInt(degat) + 1;
		p.setPv(p.getPv() - resultat);
		System.out.println(resultat + " dégat(s) infligé(s)");
	}
	
	@Override
	public String description() {
		String desc = "Arme au corps à corps (Nom : " + nom + ", force modificateur : " + forceMod + ", degat(s) : 1d" + degat + ")";
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
