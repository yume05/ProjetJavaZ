package zoo.Modele.Enclos;

import zoo.Modele.Animal.*;


import java.util.ArrayList;


/**
 * public abstract class Enclos<T extends Animal>
 * Classe abstraite Enclos
 * @author camille
 * @param <T> 
 * 	    Genericite, c'est à dire qu'un enclos possède une espèce d'Animal.
 */
public abstract class Enclos<T extends Animal> {
	/**
	 * public Enclos()
	 * Constructeur Enclos vide
	 */
	public Enclos() {
		// TODO Auto-generated constructor stub
	}
	
	 /**
	  * public Enclos(String nom, double superficie, int maxAnimaux)
	  * Constructeur de la classe Enclos pour creer un Enclos
	  * @param nom
	  * @param superficie
	  * @param maxAnimaux
	  */
	public Enclos(String nom, double superficie, int maxAnimaux){
		this.nom = nom;
		this.superficie = superficie;
		this.maxAnimaux = maxAnimaux;
		this.proprete = PROPRETE1;
		this.setNbrAnimaux(0);
		
	}
	
	/**
	 * Constantes de type String
	 * Proprete1 = "Bon"
	 */
	public static final String PROPRETE1 = "bon";
	
	/**
	 * Constantes de type String
	 * Proprete2 = "Correct"
	 */
	public static final String PROPRETE2 = "correct";
	
	/**
	 * Constantes de type String
	 * Proprete3 = "Mauvais"
	 */
	public static final String PROPRETE3 = "mauvais";
	
	/**
	 * Variable protegee de type String
	 * Nom est le nom de l'enclos
	 */
	protected String nom;
	/**
	 * Variable protegee de type Double
	 * Superficie est la superficie de l'enclos
	 */
	protected double superficie;
	/**
	 * Variable protegee de type int
	 * MaxAnimaux est le maximum d'animaux possible dans cet enclos
	 */
	protected int maxAnimaux;
	/**
	 * Variable protegee de type int
	 * NbrAnimaux est le nombre d'animaux que contient en ce moment l'enclos
	 */
	protected int nbrAnimaux;
	/**
	 * Variable protegee de type String
	 * Proprete est la proprete de l'enclos 
	 */
	protected String proprete;
	/**
	 * ArrayList<T> listeAnimaux, <T> herite d'Animal
	 * Liste des animaux/especes que contient l'enclos
	 */
	public ArrayList<T> listeAnimaux =  new ArrayList<T>();
	/**
	 * ArrayList<T> listeAnimauxTemporaire, <T> herite d'Animal
	 * Liste des animaux temporaire appartenant à l'enclos temporaire
	 * Pour la methode permettant d'entretenir l'enclos
	 */
	public ArrayList<T> listeAnimauxTemporaire =  new ArrayList<T>();
	/**
	 * ArrayList<T> listeAnimauxInvisible, <T> herite d'Animal
	 * Liste des animaux invisible, est la liste creee des un enclos creer qui sera invisible
	 * Cette liste aide à la creation de l'animal, pour maintenir l'espèce de l'enclos et de l'animal en accord
	 */
	public ArrayList<T> listeAnimauxInvisible =  new ArrayList<T>();
	
	/**
	 * Getters de la variable Nom
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * Setters de la variable Nom
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Getters de la variable superficie
	 * @return superficie
	 */
	public double getSuperficie() {
		return superficie;
	}
	/**
	 * Setters de la variable superficie
	 * @param superficie
	 */
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	
	/**
	 * Getters de la variable MaxAnimaux
	 * @return maxAnimaux
	 */
	public int getMaxAnimaux() {
		return maxAnimaux;
	}
	/**
	 * Setters de la variable MaxAnimaux
	 * @param maxAnimaux
	 */
	public void setMaxAnimaux(int maxAnimaux) {
		this.maxAnimaux = maxAnimaux;
	}
	
	/**
	 * Getters de la variable NbrAnimaux
	 * @return nbrAnimaux
	 */
	public int getNbrAnimaux() {
		return nbrAnimaux;
	}
	/**
	 * Setters de la variable NbrAnimaux
	 * @param animaux
	 */
	public void setNbrAnimaux(int animaux) {
		this.nbrAnimaux = nbrAnimaux;
	}
	
	/**
	 * Getters de la variable Proprete
	 * @return proprete
	 */
	public String getProprete() {
		return proprete;
	}
	/**
	 * Setters de la variable Proprete
	 * @param proprete
	 */
	public void setProprete(String proprete) {
		this.proprete = proprete;
	}

	/**
	 * public void randomAnimaux()
	 * Methode permettant de changer l'etat des animaux aleatoirement
	 */
	public void randomAnimaux(){
		for(Animal a : this.listeAnimaux){
			a.setIndiceFaim(a.getRandomBoolean());
			a.setIndiceSante(a.getRandomBoolean());
			a.setIndiceSommeil(a.getRandomBoolean());
		}
	}
	/**
	 * public void deterioreEnclos()
	 * Methode permettant de deteriorer l'enclos
	 */
	public void deterioreEnclos(){
		if(this.getProprete() == PROPRETE1){
			this.setProprete(PROPRETE2);
		}else if(this.getProprete() == PROPRETE2){
			this.setProprete(PROPRETE3);
		}
	}

	/**
	 * public void enleverAnimal (T animal)
	 * Methode permettant d'enlever un animal de l'enclos
	 */
	public void enleverAnimal (T animal){
		if(this.getNbrAnimaux() > 0){
			this.listeAnimaux.remove(animal);
			this.nbrAnimaux--;
		}else{
			System.out.println("Impossible d'enlever des animaux.");
		}
	}

	/**
	 * public void ajoutAnimal(T animal)
	 * Methode permettant d'ajouter un animal à la listeAnimaux
	 */
	public void ajoutAnimal(T animal){
		this.listeAnimaux.add(animal);
		this.nbrAnimaux++;
		
	}
	
	/**
	 * public void nourirAnimaux()
	 * Methode permettant de nourir les animaux de l'enclos
	 */
	public void nourirAnimaux(){
		for(Animal a : this.listeAnimaux){
			a.manger();
		}
	}
	
	/**
	 * public abstract Enclos<Animal> creerEnclosTemporaire();
	 * Methode abstraite permettant de creer un enclos temporaire pour l'entretient
	 * Pour les classes Aquarium, EnclosTerrestre et Voliere
	 * @return enclosTemporaire
	 */
	 public abstract Enclos<Animal> creerEnclosTemporaire();
	 
	 /**
	  * public abstract void salirEnclos();
	  * Methode abstraite permettant de salir l'enclos
	  * Pour les classes Aquarium, EnclosTerrestre et Voliere
	  */
	 public abstract void salirEnclos();
	
	 /**
	 * public void entretenirEnclos()
	 * Methode permettant d'entretenir l'enclos
	 */
	public void entretenirEnclos(){
		if(this.getNbrAnimaux() > 0){
			if(this.getProprete() == PROPRETE3){
				System.out.println("Il faut entretenir l'enclos !");
				Enclos<Animal> temporaireEnclos = this.creerEnclosTemporaire();
				listeAnimauxTemporaire =  this.listeAnimaux ;
				//On transfere les animaux
				for(T a : listeAnimauxTemporaire){
					temporaireEnclos.ajoutAnimal(a);
				}
				this.setNbrAnimaux(0);
				this.listeAnimaux.clear();
				
				this.setProprete(PROPRETE1);
				System.out.println("Enclos bien nettoye !");
				
				this.listeAnimaux = listeAnimauxTemporaire;
				//On retransfère les animaux
				for(T a : listeAnimauxTemporaire){
					temporaireEnclos.enleverAnimal(a);
				}
				listeAnimauxTemporaire.clear();
			}else if(this.getProprete() == PROPRETE2){
				System.out.println("Il faut entretenir l'enclos !");
				Enclos<Animal> temporaireEnclos = this.creerEnclosTemporaire();
				listeAnimauxTemporaire =  this.listeAnimaux;
				//On transfere les animaux
				for(T a : listeAnimauxTemporaire){
					temporaireEnclos.ajoutAnimal(a);
				}
				this.setNbrAnimaux(0);
				this.listeAnimaux.clear();
				
				this.setProprete(PROPRETE1);
				System.out.println("Enclos bien nettoye !");
				
				this.listeAnimaux = listeAnimauxTemporaire;
				//On retransfère les animaux
				for(T a : listeAnimauxTemporaire){
					temporaireEnclos.enleverAnimal(a);
				}
				listeAnimauxTemporaire.clear();
			}else{
			
					System.out.println("L'enclos n'a pas besoin d'être nettoyer !");
			}
		}else{
			System.out.println("L'enclos n'a pas d'animaux.");
		}
	}
	
	/**
	 * public String recupClass()
	 * Methode permettant de recupere l'espèce de la classe Enclos
	 * @return split4
	 * 			Le String de la classe de l'espèce de l'enclos
	 */
	public String recupClass(){
		//ArrayList<T> a = this.listeAnimaux;
		ArrayList<T> a = this.listeAnimauxInvisible;
		String enclos1 = " ";
		for(Animal b : a){
			enclos1 = b.getClass().toString();	
			System.out.println(enclos1);
		}
		String[]split1 = enclos1.split (" "); 
		String split2 = split1[1];
		System.out.println(split2);
		String[]split3 = split2.split ("\\."); 
		String split4 = split3[3];
		System.out.println(split4);
		return split4;
		
		
	}
}
