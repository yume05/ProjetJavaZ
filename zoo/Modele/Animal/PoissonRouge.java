package zoo.Modele.Animal;
import zoo.Modele.Employee.*;
import zoo.Modele.Enclos.*;
import zoo.Modele.Animal.*;
import zoo.Modele.Interface.Animal.*;
import zoo.Modele.Interface.Employee.*;
import zoo.Controleur.*;

/**
 * public class PoissonRouge extends Animal implements Marin, Ovipare
 * Classe heritant de la classe Animal, et implementant les interface Marin et Ovipare
 */
public class PoissonRouge extends Animal implements Marin, Ovipare {

	/**
	 * public PoissonRouge()
	 * Constructeur
	 */
	public PoissonRouge() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * public PoissonRouge (String nom, Boolean sexe, int poids, int taille, int age)
	 * Constructeur permettant de creer un poisson rouge
	 * @param nom
	 * @param sexe
	 * @param poids
	 * @param taille
	 * @param age
	 */
	public PoissonRouge (String nom, Boolean sexe, int poids, int taille, int age){
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
	 * Methode permettant de faire manger le Poisson
	 */
	protected void mangerVrai(){
		System.out.println("Je mange des granules !");
	}
	
	/**
	 * public void crier ()
	 * Methode qui permet de faire crier le poisson
	 */
	public void crier (){
		System.out.println("Gloup.. Glop... Glup.. Blup..");
	}

	/**
	 * public void nager ()
	 * Methode permettant de faire nager le poisson
	 */
	public void nager (){
		System.out.println("Je nage dans l'eau comme un poisson ! ");
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
