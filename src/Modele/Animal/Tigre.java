package  Modele.Animal;
import  Modele.Employee.*;
import  Modele.Enclos.*;
import  Modele.Animal.*;
import  Modele.Interface.Animal.*;
import  Modele.Interface.Employee.*;
import  Controleur.*;

/***
 * public class Tigre extends Animal implements Terrestre, Mammifere
 * Classe heritant de la classe Animal, et implementant les interface Terrestre et Mammifere
 */
public class Tigre extends Animal implements Terrestre, Mammifere {

	/**
	 * public Tigre()
	 * Constructeur de la classe Tigre
	 */
	public Tigre() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * public Tigre (String nom, Boolean sexe, int poids, int taille, int age)
	 * Constructeur permettant de creer un Tigre
	 * @param nom
	 * @param sexe
	 * @param poids
	 * @param taille
	 * @param age
	 */
	public Tigre (String nom, Boolean sexe, int poids, int taille, int age){
		this.nom = nom;
		this.sexe = sexe;
		this.poids = poids;
		this.taille = taille;
		this.age = age;
	} 
	
	/**
	 * Variable protegee de type Boolean
	 * Gestation de l'animal
	 * Si True alors mettre bas
	 */
	protected Boolean gestation;
	
	/**
	 * protected void mangerVrai()
	 * Methode permettant de faire manger l'animal
	 */
	protected void mangerVrai(){
		System.out.println("Je croque des gazelles, sauf si elles sont trop rapide ! ...");
	}
	
	/**
	 * public void crier()
	 * Methode permettant à l'animal demettre un son
	 */
	public void crier(){
		System.out.println("Grrr Grrr je suis un tigre");
	}

	/**
	 * public void deplacement ()
	 * Methode permettant à l'animal de se deplacer
	 */
	public void deplacement (){
		System.out.println("Je marche dans la savane silencieusement..");
	}
	
	/**
	 * public void accouplement(Animal l1, Animal l2)
	 * Methode permettant à l'animal de s'accoupler avec un autre
	 */
	public void accouplement(Animal l1, Animal l2){
		if(l1.isSexe()==true && l2.isSexe() == false){
			this.gestation = true;
		}
		else if(l2.isSexe()==true && l1.isSexe() == false){
			this.gestation = true;
		}else{
			System.out.println("Les animaux ne sont pas compatibles desole..");
		}
	}
	
	/**
	 * public void mettreBas()
	 * Methode permettant de mettre bas si gestion est à true
	 */
	public void mettreBas(){
		if(this.gestation){
			
		}
	}
}
