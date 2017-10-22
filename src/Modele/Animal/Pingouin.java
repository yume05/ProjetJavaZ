package  Modele.Animal;
import  Modele.Employee.*;
import  Modele.Enclos.*;
import  Modele.Animal.*;
import  Modele.Interface.Animal.*;
import  Modele.Interface.Employee.*;
import  Controleur.*;

/***
 * public class Pingouin extends Animal implements Marin, Terrestre, Ovipare
 * Classe heritant de la classe Animal, et implementant les interface Marin, Terrestre et Mammifere
 */
public class Pingouin extends Animal implements Marin, Terrestre, Ovipare {

	/**
	 * public Pingouin()
	 * Constructeur
	 */
	public Pingouin() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * public Pingouin (String nom, Boolean sexe, int poids, int taille, int age)
	 * Constructeur de la classe permettant de creer un Pingouin
	 * @param nom
	 * @param sexe
	 * @param poids
	 * @param taille
	 * @param age
	 */
	public Pingouin (String nom, Boolean sexe, int poids, int taille, int age){
		this.nom = nom;
		this.sexe = sexe;
		this.poids = poids;
		this.taille = taille;
		this.age = age;
	}

	/**
	 * Variable protegee de type Boolean
	 * Gestation de l'animal
	 * Si True alors pondreOeuf
	 */
	protected Boolean gestation;
	
	/**
	 * protected void mangerVrai()
	 * Methode permettant de faire manger le Pingouin
	 */
	protected void mangerVrai(){
		System.out.println("Je mange du poisson frais !");
	}
	
	/**
	 * public void crier ()
	 * Methode qui permet de faire crier le pingouin
	 */
	public void crier (){
		System.out.println("Kaaa Kaaa je suis un pingouin");
	}

	/**
	 * public void nager ()
	 * Methode permettant de faire nager le Pingouin
	 */
	public void nager (){
		System.out.println("Je nage dans l'eau comme un pingouin ! ");
	}
	
	/**
	 * public void deplacement ()
	 * Methode permettant de faire se deplacer l'animal sur la terre ferme
	 */
	public void deplacement (){
		System.out.println("Je glisse sur la banquise ! ");
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
	 * public void ponreOeuf()
	 * Methode permettant de faire pondre si gestation est à true
	 */
	public void pondreOeuf(){
		if(this.gestation){
			
		}
	}
}
