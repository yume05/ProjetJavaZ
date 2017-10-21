package zoo.Modele.Enclos;

import zoo.Modele.Animal.*;
import zoo.Modele.Interface.Animal.*;

/***
 * Classe EnclosTerrestre heritant de la classe Enclos<T>
 * @param <T>
 * 			Genericite, la classe EnclosTerrestre possède un type Terrestre et d'Animal
 */
public class EnclosTerrestre <T extends Animal & Terrestre> extends Enclos<T> {

	/**
	 * public EnclosTerrestre(String nom, double superficie, int maxAnimaux)
	 * Constructeur de la classe EnclosTerrestre
	 * Permet de creer un enclosTerrestre
	 * @param nom
	 * @param superficie
	 * @param maxAnimaux
	 */
	public EnclosTerrestre(String nom, double superficie, int maxAnimaux) {
		// TODO Auto-generated constructor stub
		super(nom, superficie, maxAnimaux);
		super.setNbrAnimaux(0);
	}
	
	/**
	 * public String toString()
	 * Premiere methode executait lors du lancement de la classe EnclosTerrestre
	 * Permet d'afficher les caracteristiques de l'enclos
	 */
	public String toString() {
		return("Mon enclos s'appelle \"" + this.getNom() + "\", il a une superficie de " + this.getSuperficie()+ ", il peut posseder pas plus de " + this.getMaxAnimaux() + " animaux, son etat d'entretien est à " + this.getProprete() + " et son nombre d'animaux actuelle est de "+this.getNbrAnimaux()+" animaux.");	
	}
	
	/**
	 * public void salirEnclos()
	 * Methode permettant de salir l'enclos
	 */
	public void salirEnclos(){
		super.deterioreEnclos();
	}
	
	/**
	 * public void ajoutAnimal(T animal)
	 * Methode permettant d'ajouter un animal à l'enclos
	 */
	public void ajoutAnimal(T animal){
		super.ajoutAnimal(animal);
	}
	
	
	/**
	 * public Enclos creerEnclosTemporaire()
	 * Methode permettant de creer un enclos temporaire
	 * Avec les mêmes caracteristiques que l'enclos courant
	 * @Override
	 * @return enclosTemporaire
	 */
	public Enclos creerEnclosTemporaire() {
		// TODO Auto-generated method stub
		EnclosTerrestre<T> enclosTemporaire = new EnclosTerrestre<T>(this.getNom(), this.superficie, this.getMaxAnimaux());
		return enclosTemporaire;
	}
	
	/**
	 * public void entretenirEnclos()
	 * Methode permettant d'entretenir l'enclos
	 */
	public void entretenirEnclos(){
		super.entretenirEnclos();
	}

}
