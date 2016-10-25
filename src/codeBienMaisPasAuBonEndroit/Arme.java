package codeBienMaisPasAuBonEndroit;

import personnage.Personnage;

public interface Arme extends Item{
	
	/**
	 * Attaquer un Personnage avec un autre Personnage
	 * @param att : Attaquant
	 * @param def : Défanseur
	 */
	public void attaquer(Personnage att, Personnage def);
}
