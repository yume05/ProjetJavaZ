package zoo.Modele.Animal;
import zoo.Modele.Employee.*;

import zoo.Modele.Enclos.*;
import zoo.Modele.Animal.*;
import zoo.Modele.Interface.Animal.*;
import zoo.Modele.Interface.Employee.*;
import zoo.Controleur.*;

/***
 * public class Ours extends Animal implements Terrestre, Mammifere 
 * Classe heritant de la classe Animal, et implementant les interface Terrestre et Mammifere
 */
public class Ours extends Animal implements Terrestre, Mammifere {

	/**
	 * public Ours()
	 * Constructeur de la classe Ours
	 */
	public Ours() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * public Ours (String nom, Boolean sexe, int poids, int taille, int age)
	 * Constructeur de la classe Ours permettant de creer un ours
	 * @param nom
	 * @param sexe
	 * @param poids
	 * @param taille
	 * @param age
	 */
	public Ours (String nom, Boolean sexe, int poids, int taille, int age){
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
		System.out.println("Je mange du miel ! Mmmmh");
	}
	
	/**
	 * public void crier()
	 * Methode permettant de faire emettre un son à l'animal
	 */
	public void crier(){
		System.out.println("Oouuuaar je suis un ours !");
	}

	/**
	 * public void deplacement ()
	 * Methode permettant de faire se deplacer l'animal
	 */
	public void deplacement (){
		System.out.println("Je vagabonde dans la fôret !");
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
	 * Methode permettant de mettre bas si gestation est à true
	 */
	public void mettreBas(){
		if(this.gestation){
			
		}
	}
}
