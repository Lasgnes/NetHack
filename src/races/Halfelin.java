package races;

import personnage.Personnage;

public class Halfelin implements Race{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void appliquerMod(Personnage p) {
		// TODO Auto-generated method stub
		p.setF(p.getF() - 1);
		p.setE(p.getE() - 1);
	}

	@Override
	public void enleverMod(Personnage p) {
		// TODO Auto-generated method stub
		p.setF(p.getF() + 1);
		p.setE(p.getE() + 1);
	}

}
