package metiers;

import personnage.Personnage;

public class Magicien implements Metier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void appliquerMod(Personnage p) {
		// TODO Auto-generated method stub
		p.setCc(p.getCc() - 1);
		p.setCt(p.getCt() - 1);
	}

	@Override
	public void enleverMod(Personnage p) {
		// TODO Auto-generated method stub
		p.setCc(p.getCc() + 1);
		p.setCt(p.getCt() + 1);
	}

}
