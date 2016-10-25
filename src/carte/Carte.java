package carte;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import personnage.Personnage;

public class Carte {
	
	private char[][] carte = new char[24][80];
	private char[][] masque = new char[24][80];
	
	public Carte() {
		BufferedReader br = null;

		try {

			//char c;
			String s;

			br = new BufferedReader(new FileReader("cartes\\carte1.txt"));
			
			int i = 0;
			while ((s = br.readLine()) != null) {
				//System.out.println(s + s.length());
				for(int j=0; j<80; j++){
					carte[i][j] = s.charAt(j);
				}
				i ++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Carte c = new Carte();
		Personnage p = new Personnage();
		p.setX(20);
		p.setY(20);
		c.masque[p.getX()][p.getY()] = '@';
		c.afficher();
		while(true){
			Scanner sc = new Scanner(System.in);
			String touche = sc.nextLine();
			c.deplacerPersonnage(p, touche);
			c.afficher();
		}
	}
	
	public String afficher() {
		String s = "";
		for(int i=0; i<24; i++){
			for(int j=0; j<80; j++){
				if(masque[i][j] != '\u0000'){
					//System.out.print(masque[i][j]);
					s += masque[i][j];
				}else {
					//System.out.print(carte[i][j]);
					s += carte[i][j];
				}
			}
			//System.out.println();
			s += "\n";
		}
		return s;
	}
	
	public void deplacerPersonnage(Personnage p, String direction){
		masque[p.getX()][p.getY()] = '\u0000';
		if(direction.equals("z")){
			p.setX(p.getX() - 1);
			if(carte[p.getX()][p.getY()] == '#'){
				p.setX(p.getX() + 1);
				System.out.println("you bumbed in a wall!");
			}
		}
		if(direction.equals("q")){
			p.setY(p.getY() - 1);
			if(carte[p.getX()][p.getY()] == '#'){
				p.setY(p.getY() + 1);
				System.out.println("you bumbed in a wall!");
			}
		}
		if(direction.equals("s")){
			p.setX(p.getX() + 1);
			if(carte[p.getX()][p.getY()] == '#'){
				p.setX(p.getX() - 1);
				System.out.println("you bumbed in a wall!");
			}
		}
		if(direction.equals("d")){
			p.setY(p.getY() + 1);
			if(carte[p.getX()][p.getY()] == '#'){
				p.setY(p.getY() - 1);
				System.out.println("you bumbed in a wall!");
			}
		}
		masque[p.getX()][p.getY()] = '@';
	}

	public char[][] getCarte() {
		return carte;
	}

	public void setCarte(char[][] carte) {
		this.carte = carte;
	}

}
