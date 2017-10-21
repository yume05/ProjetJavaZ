package zoo.Modele.Enclos;

import zoo.Modele.Animal.*;
import zoo.Modele.Interface.Animal.*;

/***
 * public class Voliere <T extends Animal & Volant> extends Enclos<T>
 * @param <T>
 * 			Genericite, la classe Voliere possède un type Volant et d'Animal
 */
public class Voliere <T extends Animal & Volant> extends Enclos<T>{

	/**
	 * public Voliere(String nom, double superficie, int maxAnimaux, double hauteur)
	 * Constructeur de la classe Voliere permettant de creer un voliere
	 * @param nom
	 * @param superficie
	 * @param maxAnimaux
	 * @param hauteur
	 */
	public Voliere(String nom, double superficie, int maxAnimaux, double hauteur) {
		// TODO Auto-generated constructor stub
		super(nom, superficie, maxAnimaux);
		this.hauteur = hauteur;
		this.setEtatToit(true);
		this.setNbrAnimaux(0);
	}
	
	/**
	 * Variable protegee de type double
	 * Hauteur de la voliere
	 */
	protected double hauteur;
	
	/**
	 * Variable protegee de type Boolean
	 * Etat du toi de la voliere
	 */
	protected Boolean etatToit;

	/**
	 * Getters de etatToit
	 * @return etatToit
	 */
	public Boolean getEtatToit() {
		return etatToit;
	}
	
	/**
	 * Setters de etatToit
	 */
	public void setEtatToit(Boolean etatToit) {
		this.etatToit = etatToit;
	}

	/**
	 * Getters de hauteur
	 * @return hauteur
	 */
	public double getHauteur() {
		return hauteur;
	}
	/**
	 * Setters de hauteur
	 */
	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}
	
	/**
	 * public void salirEnclos()
	 * Methode permettant de salir un enclos
	 */
	public void salirEnclos(){
		if(this.getEtatToit()){
			this.setEtatToit(false);
		}
	}
	
	/**
	 * public void entretenirEnclos()
	 * Methode permettant d'entretenir un enclos
	 */
	public void entretenirEnclos(){
		super.entretenirEnclos();
		if(!this.getEtatToit()){
			this.setEtatToit(true);
		}
	}
	
	/**
	 * public String toString()
	 * Premiere methode appelait lors de l'execution de la classe
	 * Renvoie les caracteristiques de la voliere
	 */
	public String toString() {
		String etatToits;
		if(this.etatToit == false){
			etatToits = "mauvais";
		}else{
			etatToits = "bon";
		}
		return("Ma Volière s'appelle \"" + this.getNom() + "\", possède une superficie de " + this.getSuperficie()+ ", peut contenir maximum " + this.getMaxAnimaux() + " animaux volants, contient actuellement " + this.getNbrAnimaux()+ " animaux, sa hauteur est de "+this.getHauteur()+ " et le toit est en "+etatToits+" etat.");
	}

	/**
	 * public void ajoutAnimal(T animal)
	 * Methode permettant d'ajouer un animal à la voliere
	 */
	public void ajoutAnimal(T animal){
		super.ajoutAnimal(animal);
	}
	
	/**
	 * public Enclos creerEnclosTemporaire()
	 * Methode permettant de creer un enclos temporaire
	 * @Override
	 * @return enclosTemporaire
	 */
	public Enclos creerEnclosTemporaire() {
		Voliere<T> enclosTemporaire = new Voliere<T>(this.getNom(), this.getSuperficie(), this.getMaxAnimaux(), this.getHauteur());
		return enclosTemporaire;
	}


}
