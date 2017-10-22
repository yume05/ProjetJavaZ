package  Modele.Animal;
import  Modele.Employee.*;
import  Modele.Enclos.*;
import  Modele.Animal.*;
import  Modele.Interface.Animal.*;
import  Modele.Interface.Employee.*;
import  Controleur.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Thread;

/***
 * public class Loup extends Animal implements Terrestre, Mammifere
 * Classe héritant de la classe Animal, et implementant les interface Terrestre et Mammifere
 */
public class Loup extends Animal implements Terrestre, Mammifere {

	/**
	 * public Loup()
	 * Constructeur de la classe
	 */
	public Loup() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * public Loup (String nom, Boolean sexe, int poids, int taille, int age)
	 * Constructeur permettant de créer un loup
	 * @param nom
	 * @param sexe
	 * @param poids
	 * @param taille
	 * @param age
	 */
	public Loup (String nom, Boolean sexe, int poids, int taille, int age){
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
		System.out.println("Je mange du Magneau égaré ! Grraow Graow");
	}
	
	/**
	 * public void crier()
	 * Methode permettant à l'animal démettre un son
	 */
	public void crier(){
		System.out.println("Grrr Grrr je suis un loup");
	}

	/**
	 * public void deplacement ()
	 * Methode permettant à l'animal de se déplacer
	 */
	public void deplacement (){
		System.out.println("Je vagabonde dans les champs comme un loup libre !");
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
			System.out.println("Les animaux ne sont pas compatibles désolé..");
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
