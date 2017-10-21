package zoo.Modele.Enclos;

import zoo.Modele.Animal.*;
import zoo.Modele.Interface.Animal.*;

/***
 * public class Aquarium <T extends Animal & Marin> extends Enclos<T>
 * @param <T>
 * 			Genericite, la classe Aquarium possède un type Marin et d'Animal
 */
public class Aquarium <T extends Animal & Marin> extends Enclos<T>{
	
	/**
	 * public Aquarium(String nom, double superficie, int maxAnimaux, int profondeur)
	 * Constructeur de la classe Aquarium
	 * Permet de creer un aquarium
	 * @param nom
	 * @param superficie
	 * @param maxAnimaux
	 * @param profondeur
	 */
	public Aquarium(String nom, double superficie, int maxAnimaux, int profondeur) {
		// TODO Auto-generated constructor stub
		super(nom, superficie, maxAnimaux);
		this.profondeur = profondeur;
		this.setTauxSalinite(100);
		this.hauteurEau = profondeur;
		this.setNbrAnimaux(0);
	}
	
	/**
	 * Variable protegee de type int
	 * La profondeur de l'aquarium
	 */
	protected int profondeur;
	
	/**
	 * Variable protegee de type double
	 * Le taux de salinite de l'aquarium
	 */
	protected double tauxSalinite;
	
	/**
	 * Variable protegee de type int
	 * La hauteur d'eau de l'aquarium
	 */
	protected int hauteurEau;

	/**
	 * Getters de l'hauteur d'eau
	 * @return hauteurEau
	 */
	public int getHauteurEau() {
		return hauteurEau;
	}
	/**
	 * Setters de l'hauteur d'eau
	 */
	public void setHauteurEau(int hauteurEau) {
		this.hauteurEau = hauteurEau;
	}
	
	/**
	 * Getters profondeur d'eau
	 * @return profondeur
	 */
	public int getProfondeur() {
		return profondeur;
	}
	
	/**
	 * Setters profondeur d'eau
	 * Verification que la profondeur ne depasse pas la profondeur qui existe dejà
	 */
	public void setProfondeur(int profondeur) {
		if(hauteurEau >= 0 && hauteurEau <= this.getProfondeur()){
			this.profondeur = profondeur;
		}else{
			System.out.println("L'eau ne peut être plus haute que la profondeur de l'eau autorise.");
		}

	}
	
	/**
	 * Getters du taux de salinite
	 * @return tauxSalinite
	 */
	public double getTauxSalinite() {
		return tauxSalinite;
	}
	
	/**
	 * Setters du taux de salinite
	 * Verification que le taux de salinite ne depasse ni 0 ni 100
	 */
	public void setTauxSalinite(double tauxSalinite) {
		if(tauxSalinite >= 0 && tauxSalinite <= 100){
			this.tauxSalinite = tauxSalinite;
		}
	}

	/**
	 * public void salirEnclos()
	 * Methode permettant de salir l'eau de l'aquarium
	 */
	public void salirEnclos(){
		this.setHauteurEau(this.getHauteurEau() - 1);
		this.setTauxSalinite(this.getTauxSalinite() - 10);
	}
	
	/**
	 * public void entretenirEnclos()
	 * Methode permettant d'entretenir l'aquarium 
	 */
	public void entretenirEnclos(){
		System.out.println("Niveau de l'eau "+this.getHauteurEau()+" mètres de profondeur.");
		if(this.getHauteurEau() < this.getProfondeur()){
			System.out.println("Ajout de l'eau manquante..");
			System.out.println("Bloup...");
			this.setHauteurEau(this.getProfondeur());
			System.out.println("Le niveau de l'eau à bien ete corrige !");
		}
		System.out.println("Le taux de salinite est de "+this.getTauxSalinite() +"%");
		if(this.getTauxSalinite() < 100){
			System.out.println("Et on rajoute du sel !");
			System.out.println("Bloup...");
			this.setTauxSalinite(100);
			System.out.println("Tout est ok !");
		}
	}
	
	/**
	 * public String toString() 
	 * Premiere Methode appelait lors de l'execution de la classe
	 * Renvoie les caracteristiques de l'aquarium
	 */
	public String toString() {
		return("Mon aquarium s'appelle \"" + this.getNom() + "\", sa superficie est de " + this.getSuperficie()+ ", il ne peut contenir pas plus de " + this.getMaxAnimaux() + " animaux, il en possède dejà " + this.getNbrAnimaux()+ ", sa profondeur autorisee est de "+this.getProfondeur()+ ", son taux de salinite est à "+this.getTauxSalinite()+"% et son niveau d'eau "+this.getHauteurEau()+".");
	}
	
	/**
	 * public Enclos creerEnclosTemporaire()
	 * Methode permettant de creer un aquarium temporaire
	 * Utilise lors de l'entretien de l'aquarium
	 * @Override
	 * @return enclosTemporaire
	 */
	public Enclos creerEnclosTemporaire() {
		Aquarium<T> enclosTemporaire = new Aquarium<T>(this.getNom(), this.getSuperficie(), this.getMaxAnimaux(), this.getProfondeur());
		return enclosTemporaire;
	}
	
}
