package  Modele.Animal;
import  Modele.Employee.*;
import  Modele.Enclos.*;
import  Modele.Animal.*;
import  Modele.Interface.Animal.*;
import  Modele.Interface.Employee.*;
import  Controleur.*;

/***
 * public class Baleine extends Animal implements Marin, Mammifere
 * Classe heritant de la classe Animal, et implementant les interface Marin et Mammifere
 */
public class Baleine extends Animal implements Marin, Mammifere {

	/**
	 * public Baleine()
	 * Constructeur de la classe
	 */
	public Baleine() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * public Baleine (String nom, Boolean sexe, int poids, int taille, int age)
	 * Constructeur permettant de creer une Baleine
	 * @param nom
	 * @param sexe
	 * @param poids
	 * @param taille
	 * @param age
	 */
	public Baleine (String nom, Boolean sexe, int poids, int taille, int age){
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
	 * Methode permettant de faire manger la Baleine
	 */
	protected void mangerVrai(){
		System.out.println("Je mange du plancton !");
	}

	/**
	 * public void crier ()
	 * Methode permettant de faire crier l'animal
	 */
	public void crier (){
		System.out.println("Mooooooooooh je suis une baleine Mooooooh");
	}

	/**
	 * public void nager()
	 * Methode permettant de faire nager l'animal
	 */
	public void nager(){
		System.out.println("Je nage dans l'eau comme une baleine ! !");
	}
	
	/**
	 * public void accouplement(Animal l1, Animal l2)
	 * Methode permettant de faire accoupler l'animal
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
	 * Methode permettant de mettre Bas si accouplement il y a eu
	 */
	public void mettreBas(){
		if(this.gestation){
			
		}
	}
}
