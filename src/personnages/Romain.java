package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force < 1) {
			force = 0;
			parler("J'abandonne !");
		} else {
			parler("Aïe");
		}
	}

	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;

		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé ! ");
			break;

		case 1:
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déjà " + equipement);
			} else {
				ajouterEquipement(equipement);
			}
			break;

		case 0:
			ajouterEquipement(equipement);
			break;
		}
	}

}