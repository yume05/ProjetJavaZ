package Modele.Animal;
import Modele.Employee.*;
import Modele.Enclos.*;
import Modele.Animal.*;
import Modele.Interface.Animal.*;
import Modele.Interface.Employee.*;


/***
 * public class Aigle extends Animal implements Volant, Ovipare
 * Classe heritant de la classe Animal, et implmentant les interface Volant et Ovipare
 */
public class Aigle extends Animal implements Volant, Ovipare{

	/**
	 * public Aigle()
	 * Constructeur de la classe Aigle
	 */
	public Aigle() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * public Aigle (String nom, Boolean sexe, int poids, int taille, int age)
	 * Constructeur permettant de creer un aigle
	 * @param nom
	 * @param sexe
	 * @param poids
	 * @param taille
	 * @param age
	 */
	public Aigle (String nom, Boolean sexe, int poids, int taille, int age){
		this.nom = nom;
		this.sexe = sexe;
		this.poids = poids;
		this.taille = taille;
		this.age = age;
	}
	
	/**
	 * Variable protegee de type Boolean
	 * Gestation de l'animal
	 * Si True alors pondre Oeuf
	 */
	protected Boolean gestation;
	
	/**
	 * protected void mangerVrai()
	 * Methode permettant de faire manger l'aigle
	 */
	protected void mangerVrai(){
		System.out.println("Je mange de petits lapins qui n'ont pas eu le temps de se cacher de moi !");
	}
	
	/**
	 * public void crier ()
	 * Methode permettant de faire crier l'animal
	 */
	public void crier (){
		System.out.println("Couuuuuaw je suis un aigle qui domine le ciel Couuuuuaw");
	}

	/**
	 * public void voler()
	 * Methode permettant de faire voler l'animal
	 */
	public void voler(){
		System.out.println("Je vole dans le ciel comme un aigle !");
	}
	
	/**
	 * public void accouplement(Animal l1, Animal l2)
	 * Methode permettant de faire accoupler l'aigle
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
	 * public void pondreOeuf()
	 * Methode permettant de faire pondre l'animal si accouplement fait
	 */
	public void pondreOeuf(){
		if(this.gestation){
			
		}
	}

}
