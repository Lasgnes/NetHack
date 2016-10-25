package personnage;

import armes.*;
import metiers.*;
import races.*;

public class Personnage {

	private int x; // position abscisse
	private int y; // position ordonnée
	private String nom = "Jhon Doe"; // nom
	private Race race = new Humain(); // race
	private Metier metier = new Guerrier(); // métier
	private int cc = 3; // capacité de combat (corps à corps)
	private int ct = 3; // capacité de tir
	private int f = 3; // force
	private int e = 3; // endurance
	private int i = 3; // initiative
	private int a = 1; // attaque
	private int cd = 7; // commandement (moral/discipline...) ?
	private int m = 4; // mouvement
	private int pv = 3; // points de vie
	private int maxPv = 3; // points de vie max
	private Arme arme; // arme

	/*
	 * Constructeur
	 */
	public Personnage() {
		this.appliquerMod();
	}

	/**
	 * 
	 * @param nom
	 * @param race
	 * @param metier
	 */
	public Personnage(String nom, Race race, Metier metier) {
		this.nom = nom;
		this.race = race;
		this.metier = metier;
		this.appliquerMod();
	}

	/**
	 * 
	 * @param p
	 */
	public Personnage(Personnage p) {
		this.nom = p.getNom();
		this.race = p.getRace();
		this.metier = p.getMetier();
		this.cc = p.getCc();
		this.ct = p.getCt();
		this.f = p.getF();
		this.e = p.getE();
		this.i = p.getI();
		this.a = p.getA();
		this.cd = p.getCd();
		this.m = p.getM();
		this.pv = p.getPv();
		this.arme = p.getArme();
	}

	public static void main(String[] args) {
		Personnage p = new Personnage("Karl Franz", new Elf(), new Guerrier());
		Personnage p1 = new Personnage("dummy", new Halfelin(), new Voleur());
		p.attaquer(p1);
		p.setArme(new ArmeCac());
		p.attaquer(p1);
	}

	/**
	 * appliquer les modificateurs de race et de métier
	 */
	public void appliquerMod() {
		race.appliquerMod(this);
		metier.appliquerMod(this);
	}

	/**
	 * vérifie si le personnage est vivant
	 * @return
	 */
	public boolean estVivant() {
		boolean vivant = true;
		if (pv <= 0) {
			vivant = false;
		}
		return vivant;
	}

	/**
	 * attaquer un autre personnage
	 * @param p
	 */
	public void attaquer(Personnage p) {
		if(arme == null){
			arme = new ArmeCac("Poings", -1, 1);
		}
		System.out.println(nom + " attaque " + p.getNom());
		System.out.println(arme.description());
		if (arme.toucher(this, p)) {
			if (arme.blesser(this, p)) {
				arme.appliquerDegats(p);
			}
		}
	}

	//getters et setters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public int getCt() {
		return ct;
	}

	public void setCt(int ct) {
		this.ct = ct;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getCd() {
		return cd;
	}

	public void setCd(int cd) {
		this.cd = cd;
	}

	public Metier getMetier() {
		return metier;
	}

	public void setMetier(Metier metier) {
		this.metier = metier;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	public Arme getArme() {
		return arme;
	}

	public void setArme(Arme arme) {
		this.arme = arme;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getMaxPv() {
		return maxPv;
	}

	public void setMaxPv(int maxPv) {
		this.maxPv = maxPv;
	}

}
