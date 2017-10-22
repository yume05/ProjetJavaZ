package  Modele.Employee;

import  Modele.Enclos.*;
import  Modele.Animal.*;
import  Modele.Interface.Employee.*;

/***
 * public class Employe implements EmployeInterface
 * Classe Employe
 * Implémente l'interface EmployeInterface
 */
public class Employe implements EmployeInterface {

	/**
	 * public Employe(String nom, Boolean sexe, int age) 
	 * Constructeur de la classe Employe
	 * @param nom
	 * @param sexe
	 * @param age
	 */
	public Employe(String nom, Boolean sexe, int age) {
		// TODO Auto-generated constructor stub
		this.nom = nom;
		this.sexe = sexe;
		this.age = age;
	}

	/**
	 * Variable protegee de type String
	 * Le nom de l'employé
	 */
	protected String nom;
	
	/**
	 * Variable protegee de type Boolean
	 * Le sexe de l'employé
	 */
	protected Boolean sexe;
	
	/**
	 * Variable protegee de type int
	 * Age de l'empoyé
	 */
	protected int age;
	
	/**
	 * Getters de nom
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Setters de nom
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Getters de sexe
	 * @return sexe
	 */
	public Boolean getSexe() {
		return sexe;
	}
	
	/**
	 * Setters de sexe
	 * @param sexe
	 */
	public void setSexe(Boolean sexe) {
		this.sexe = sexe;
	}

	/**
	 * Getter de Age
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Setter de Age
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}


	/**
	 * public void examinerEnclos(Enclos<Animal> enclos)
	 * Methode permettant d'examiner un enclos
	 */
	public void examinerEnclos(Enclos<Animal> enclos) {
		// TODO Auto-generated method stub
		System.out.println(enclos.toString());
	}

	/**
	 * public void nettoyerEnclos(Enclos<Animal> enclos)
	 * Methode permettant d'entretenir un enclos
	 * @Override
	 */
	
	public void nettoyerEnclos(Enclos<Animal> enclos) {
		// TODO Auto-generated method stub
		enclos.entretenirEnclos();
		
	}
	
	/**
	 * public void nourirAnimauxEnclos(Enclos<Animal> enclos)
	 * Methode permettant de nourir les animaux de l'enclos
	 * @Override
	 */
	public void nourirAnimauxEnclos(Enclos<Animal> enclos) {
		// TODO Auto-generated method stub
		enclos.nourirAnimaux();
	}
	
	
	/**
	 * public void transferAnimalEnclos(Enclos<Animal> enclosOriginal, Enclos<Animal> enclosFutur, Animal monAnimal)
	 * Methode permettant de transferer un animal d'un enclos à un autre
	 * @Override
	 */
	public void transferAnimalEnclos(Enclos<Animal> enclosOriginal, Enclos<Animal> enclosFutur, Animal monAnimal) {
		// TODO Auto-generated method stub
		if(enclosFutur.getNbrAnimaux() < enclosFutur.getMaxAnimaux()){
			if(enclosFutur.getClass() == enclosOriginal.getClass()){
				enclosFutur.ajoutAnimal(monAnimal);
				enclosOriginal.enleverAnimal(monAnimal);
				System.out.println("Le transfère s'est bien passé !");
			}else{
				System.out.println("Vous ne pouvez pas transférer cet animal dans cette enclos ci !!");
			}
			
		}else{
			System.out.println("Impossible de transferer l'animal dans cette enclos");
		}
	}
	
	
}
