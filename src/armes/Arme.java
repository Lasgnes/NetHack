package armes;

import personnage.Personnage;

public interface Arme {

	boolean toucher(Personnage att, Personnage def);

	boolean blesser(Personnage att, Personnage def);

	void appliquerDegats(Personnage p);
	
	String description();
	
}
