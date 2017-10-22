package Controleur;
import Modele.Employee.*;

import Modele.Enclos.*;
import Modele.Animal.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

/**
 * public class MonZoo
 * Class Zoo
 * Classe principale
 */
public class MonZoo {

	/**
	 * public MonZoo(String nom, Employe employer, int maxEnclos)
	 * Constructeur
	 * @param nom
	 * @param employer
	 * @param maxEnclos
	 */
	public MonZoo(String nom, Employe employer, int maxEnclos) {
		// TODO Auto-generated constructor stub
		this.nom = nom;
		this.employer = employer;
		this.maxEnclos = maxEnclos;
		this.setListeEnclos(new ArrayList<Enclos>());
	}
	/**
	 * Variable protegee de type String
	 * Nom est le nom du Zoo
	 */
	protected String nom;
	
	/**
	 * Variable protegee de type Employe
	 * Employe du Zoo
	 */
	protected Employe employer;
	
	/**
	 * Variable protegee de type Int
	 * MaxEnclos, maximum d'enclos possible
	 */
	protected int maxEnclos;
	
	/**
	 * Variable protegee de type List
	 * Liste des enclos que contient le zoo
	 */
	protected List<Enclos> listeEnclos =  new ArrayList<Enclos>();
	
	/**
	 * Getters listeEnclos
	 * @return listeEnclos
	 */
	public List<Enclos> getListeEnclos() {
		return listeEnclos;
	}
	/**
	 * Setters listeEnclos
	 */
	public void setListeEnclos(List<Enclos> listeEnclos) {
		this.listeEnclos = listeEnclos;
	}

	/**
	 * Getters nom
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * Setters nom
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getters employer
	 * @return employer
	 */
	public Employe getEmployer() {
		return employer;
	}
	
	/**
	 * Setters employer
	 * @param employer
	 */
	public void setEmployer(Employe employer) {
		this.employer = employer;
	}

	/**
	 * Getters maxEnclos
	 * @return maxEnclos
	 */
	public int getMaxEnclos() {
		return maxEnclos;
	}
	/**
	 * Setters maxEnclos
	 * @param maxEnclos
	 */
	public void setMaxEnclos(int maxEnclos) {
		this.maxEnclos = maxEnclos;
	}
	
	/**
	 * public void transfererAnimal()
	 * Methode pour transferer un Animal
	 * D'un enclos choisie à un autre qui y correspond
	 */
	public void transfererAnimal(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Choisir l'enclos d'origine");
		int choiceEnclos = scan.nextInt();
		if(choiceEnclos <= (this.listeEnclos.size()-1)){
			System.out.println("Choisir l'enclos vers qui transferer");
			int choiceFutur = scan.nextInt();
			if(choiceFutur != choiceEnclos && choiceFutur <= (this.listeEnclos.size() - 1)){
				Enclos<Animal> enclos1  = this.listeEnclos.get(choiceEnclos);
				String e1 = enclos1.recupClass();
				Enclos<Animal> enclos2  = this.listeEnclos.get(choiceFutur);
				String e2 = enclos2.recupClass();
				if(e2.equals(e1)){
					if(this.listeEnclos.get(choiceEnclos).listeAnimaux.size() > 0 || this.listeEnclos.get(choiceEnclos).getNbrAnimaux()<=this.listeEnclos.get(choiceEnclos).getMaxAnimaux()){
						System.out.println("Les animaux de l'enclos :\n");
						List<Animal> liste= this.listeEnclos.get(choiceEnclos).listeAnimaux;
						int i =0;
						for(Animal a : liste){
							System.out.println("	"+i+"- "+a);
							i++;
						}
						
							System.out.println("Choisir l'animal :");
							int choiceAnimal = scan.nextInt();
							if(choiceAnimal<= (liste.size()-1)){
								employer.transferAnimalEnclos(this.listeEnclos.get(choiceEnclos), this.listeEnclos.get(choiceFutur), liste.get(choiceAnimal));
							}else{
								System.out.println("Erreur de saisie.");
							}
							
							
					}else{
						System.out.println("Il n'y à pas d'animaux !");
					}
				}else{
					System.out.println("Veuillez choisir un enclos qui correspond !");
				}
			}else{
				System.out.println("Erreur de saisie, recommencez.");
			}
			
		}else{
			System.out.println("Erreur de saisie.");
		}
		
		
	}
	/**
	 * public void supprimerAnimal(int enclos)
	 * Méthode permettant de supprimer un Animal d'un enclos
	 * @param enclos
	 */
	public void supprimerAnimal(int enclos){
		if(enclos <= (this.listeEnclos.size() - 1)){
			Scanner scan = new Scanner(System.in);
			Enclos<Animal> enclos1  = this.listeEnclos.get(enclos);
			int i = 0;
			//On vérifie si l'enclos possède des animaux
			if(enclos1.listeAnimaux.size() >0){
				System.out.println("\nListe des animaux se trouvant dans cet enclos :\n");
				//On affiche les animaux qui se trouve dans l'enclos
				for(Animal a : enclos1.listeAnimaux){
					System.out.println(i+" - "+a);
					i++;
				}
				System.out.println("\nChoississez l'animal à supprimer :");
				int choix = scan.nextInt();
				if(choix <= (enclos1.listeAnimaux.size() - 1)){
					Animal animalSupp = enclos1.listeAnimaux.get(choix);
			
					System.out.println("Etes-vous sur de vouloir enlever "+animalSupp.getNom()+" du zoo ?... y/n");
					animalSupp.crier();
					String choixVerif = scan.next();
					choixVerif.toLowerCase();
					if(choixVerif.equals("y")){
						 enclos1.listeAnimaux.remove(animalSupp);
				            System.out.println("Animal supprimé...");
					}else{
						System.out.println("Ouf, une vie de sauvé...");
					}
				}else{
					System.out.println("Erreur de saisie.");
				}
				
			}else{
				System.out.println("Aucun animal trouvé dans cet enclos !!");
			}
		}else{
			System.out.println("Erreur de saisie.");
		}
		
	}
	/**
	 * public void creerAnimal(int enclos)
	 * Methode pour creer un animal dans un enclos qui existe.
	 * @param enclos
	 */
	public void creerAnimal(int enclos){
		if(enclos <= (this.listeEnclos.size() - 1)){
			Enclos<Animal> enclos1  = this.listeEnclos.get(enclos);
			int max = enclos1.getMaxAnimaux();
			int nbr = enclos1.getNbrAnimaux();
			if(nbr == max){
				System.out.println("Le nombre maximum d'animaux à été atteint.");
			}else{
				Scanner scan = new Scanner(System.in);
				System.out.println("VOTRE ANIMAL :");
				System.out.println("Entrer son nom (en un mot) :");
				String nomAnimal = scan.next();
				System.out.println("Entrer son sexe (F/M) :");
				String sexeAnimal = scan.next();
				scan.nextLine();
				Boolean sexeA;
				if(sexeAnimal.toUpperCase().equals("F")){
					sexeA = true;
				}else if(sexeAnimal.toUpperCase().equals("M")){
					sexeA = false;
				}else{
					sexeA = false;
				}
				System.out.println("Entrer son poids :");
				int poidsAnimal = scan.nextInt();
				System.out.println("Entrer sa taille :");
				int tailleAnimal = scan.nextInt();
				System.out.println("Entrer son age :");
				int ageAnimal = scan.nextInt();
				
				String mot = enclos1.recupClass();
				switch(mot){
				case "Baleine":
					Baleine b = new Baleine(nomAnimal, sexeA, poidsAnimal, tailleAnimal, ageAnimal);
					enclos1.ajoutAnimal(b);
					System.out.println("Bienvenue à la nouvelle baleine !");
					b.crier();
					b.nager();
					break;
				case "Requin":
					Requin r = new Requin(nomAnimal, sexeA, poidsAnimal, tailleAnimal, ageAnimal);
					enclos1.ajoutAnimal(r);
					System.out.println("Bienvenue au nouveau requin !");
					r.crier();
					r.nager();
					break;
				case "Pingouin":
					Pingouin p = new Pingouin(nomAnimal, sexeA, poidsAnimal, tailleAnimal, ageAnimal);
					enclos1.ajoutAnimal(p);
					System.out.println("Bienvenue au nouveau pingouin !");
					p.crier();
					p.deplacement();
					break;
				case "PoissonRouge":
					PoissonRouge pr = new PoissonRouge(nomAnimal, sexeA, poidsAnimal, tailleAnimal, ageAnimal);
					enclos1.ajoutAnimal(pr);
					System.out.println("Bienvenue au nouveau poisson rouge !");
					pr.crier();
					pr.nager();
					break;
				case "Aigle":
					Aigle a = new Aigle(nomAnimal, sexeA, poidsAnimal, tailleAnimal, ageAnimal);
					enclos1.ajoutAnimal(a);
					System.out.println("Bienvenue au nouvel aigle !");
					a.crier();
					a.voler();
					break;
				case "Loup":
					Loup l = new Loup(nomAnimal, sexeA, poidsAnimal, tailleAnimal, ageAnimal);
					enclos1.ajoutAnimal(l);
					System.out.println("Bienvenue au nouveau loup !");
					l.crier();
					l.deplacement();
					break;
				case "Ours":
					Ours o = new Ours(nomAnimal, sexeA, poidsAnimal, tailleAnimal, ageAnimal);
					enclos1.ajoutAnimal(o);
					System.out.println("Bienvenue au nouvel ours !");
					o.crier();
					o.deplacement();
					break;
				case "Tigre":
					Tigre t = new Tigre(nomAnimal, sexeA, poidsAnimal, tailleAnimal, ageAnimal);
					enclos1.ajoutAnimal(t);
					System.out.println("Bienvenue au nouveau tigre !");
					t.crier();
					t.deplacement();
					break;
				}
				
			}
		}else{
			System.out.println("Erreur de saisie.");
		}
		
	}
	
	/**
	 * public void supprimerEnclos(int enclos)
	 * Methode pour supprimer un enclos et ses animaux dedans.
	 * @param enclos
	 */
	public void supprimerEnclos(int enclos){
		if(enclos <= (this.listeEnclos.size() - 1)){
			Enclos<Animal> enclos1  = this.listeEnclos.get(enclos);
			Scanner scan = new Scanner(System.in);
			if (this.getListeEnclos().size() < this.getMaxEnclos()) {
				System.out.println("Supprimer enclos avec les animaux dedans ?... y/n");
				String choix = scan.next();
				choix = choix.toLowerCase();
				if(choix.equals("y")){
					 this.getListeEnclos().remove(enclos1);
					 this.attenteCreation("ES");
			         System.out.println("Enclos supprimé..");
				}else{
					System.out.println("Ouf...");
				}
	           
	        } else {
	            // TODO : throw exception
	            System.out.println("Erreur, aucun enclos trouve.");
	        }
		}else{
			System.out.println("Erreur de saisie.");
		}
		
	}
	
	/**
	 * public void afficheNbreAnimaux ()
	 * Methode qui affiche le nombre d'animaux dans le zoo
	 * Et affiche le nombre d'enclos.
	 */
	public void afficheNbreAnimaux (){
		int nbrAnimaux = 0;
		for (Enclos<Animal> enclos : listeEnclos){
			nbrAnimaux += enclos.getNbrAnimaux();
		}
		System.out.println("Le nombre d'animaux dans le zoo est de : "+nbrAnimaux);
		System.out.println("Le nombre d'enclos dans le zoo est de : "+this.listeEnclos.size());
	}
	
	/**
	 * public void afficheAnimauxEnclos()
	 * Methode qui affiche les animaux et leur enclos
	 */
	public void afficheAnimauxEnclos(){
		for (Enclos<Animal> enclos : listeEnclos){
			System.out.println("\n -- "+enclos+"\n");
			ArrayList<Animal> a = enclos.listeAnimaux;
			for(Animal animal : a){
				System.out.println("	-- "+animal);
			}
		}
	}
	
	/**
	 * public void deteriorerEnclos()
	 * Methode qui deteriore les enclos aleatoirement.
	 */
	public void deteriorerEnclos(){
		if(listeEnclos.size() > 0){
	        for (Enclos enclos : this.getListeEnclos()) {
	            enclos.salirEnclos();
	        }
	        System.out.println("Message de la voix du zoo : \"Les enclos sont deteriores, il faut les entretenir !\"\n");
		}
	}
	
	/**
	 * public void randomAll()
	 * Methode qui permet de deteriorer le zoo
	 * Tout au long de l'utilisation du Zoo.
	 */
	public void randomAll(){
		this.deteriorerEnclos();
		for(Enclos enclos : this.listeEnclos){
			enclos.randomAnimaux();
		}
	}
	
	/**
	 * public void attenteCreation(String action)
	 * Methode permettant d'afficher l'attente en fonction de l'action
	 * @param action
	 */
	public void attenteCreation(String action){
		if(action.equals("A")){
			System.out.println("Création de l'aquarium en cours...");
	         try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         System.out.println("Ajout de l'habitat naturel de l'animal...");
	         try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         System.out.println("Montage de l'aquarium....");
	         try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         System.out.println("Remplissage d'eau et traitement....");
	         try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        
	         System.out.println("Ajout de décoration aquatiques....");
	         try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         System.out.println(".....");
	         try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}else if(action.equals("V")){
			System.out.println("Création de la volière en cours...");
	         try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         System.out.println("Création de barriere....");
	         try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         System.out.println("Création d'un toit anti-escapade....");
	         try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        
	         System.out.println("Ajout d'arbres et de nids....");
	         try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         System.out.println(".....");
	         try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}else if(action.equals("E")){
			System.out.println("Construction de barrieres sécurisés...");
	         try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         System.out.println("Ajout de points d'eaux et de nourritures....");
	         try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         System.out.println("Aménagement d'habitat naturel....");
	         try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        
	         System.out.println("Ajout de décoration aquatiques....");
	         try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         System.out.println(".....");
	         try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}else if(action.equals("ES")){
			System.out.println("Nettoyage de l'enclos...");
	         try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         System.out.println("Destruction des barrières et de l'habitat....");
	         try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         System.out.println("Construction d'une cabane à hot-dogs à la place....");
	         try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         System.out.println(".....");
	         try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		 
	}
	
	/**
	 * public static void main(String[] args)
	 * Main de la classe Zoo
	 * Executer des le debut.
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Creation des instances.
		Employe employer = new Employe("Lisa", false, 20);
		MonZoo zoo = new MonZoo("", employer, 20);
		int choiceEnclos = 0;
		int choiceFutur = 0;
		int choiceAnimal = 0;
		int i = 0;
		Scanner scan = new Scanner(System.in);
		if(zoo.getNom() == ""){
			System.out.println("Avant de commencer, comment voulez vous appeler votre Zoo ?");
			String nomZoo = scan.nextLine();
			zoo.setNom(nomZoo);
		}
		EnclosTerrestre<Ours> oursE = new EnclosTerrestre<Ours>("Ours", 40, 4);
		Ours ours1 = new Ours("temporaire", false, 0, 0, 0);
		Ours ours2 = new Ours("temporaire", false, 0, 0, 0);
		oursE.listeAnimauxInvisible.add(ours1);
        zoo.getListeEnclos().add(oursE);
        EnclosTerrestre<Ours> oursE1 = new EnclosTerrestre<Ours>("Ours", 40, 4);
		
        EnclosTerrestre<Tigre> tigreE = new EnclosTerrestre<Tigre>("Tigre", 40, 4);
		Tigre tigre1 = new Tigre("temporaire", false, 0, 0, 0);
		tigreE.listeAnimauxInvisible.add(tigre1);
        zoo.getListeEnclos().add(tigreE);
        
		oursE1.listeAnimauxInvisible.add(ours2);
        zoo.getListeEnclos().add(oursE1);
			
		String especeEnclos;
		int choice = 0;
		Boolean loop = true;
		int indice;
		System.out.println("*****************************************************************");
		System.out.println("*  ____ _____ ______ _   ___      ________ _   _ _    _ ______  *");
		System.out.println("* | _  \\_   _|  ____| \\ | \\ \\    / /  ____| \\ | | |  | |  ____| *");
		System.out.println("* | |_) || | | |__  |  \\| |\\ \\  / /| |__  |  \\| | |  | | |__    * ");
		System.out.println("* |  _ < | | |  __| | . ` | \\ \\/ / |  __| | . ` | |  | |  __|   *");
		System.out.println("* | |_) || |_| |____| |\\  |  \\  /  | |____| |\\  | |__| | |____  *");
		System.out.println("* |____/_____|______|_| \\_|   \\/   |______|_| \\_|\\____/|______| * ");
		System.out.println("*                                                               *");
		System.out.println("*****************************************************************");
		System.out.println("\n\nBienvenue dans le zoo \""+zoo.getNom().toUpperCase()+"\" !!");
		System.out.println("___________________________________________\n");
		
		//Lancement du Menu
		do{
				System.out.println("\n\n          QUE VOULEZ VOUS FAIRE ? \n");
		        System.out.println("********************************************");
		        System.out.println("1 - Creer enclos");
		        System.out.println("2 - Supprimer enclos");
		        System.out.println("3 - Creer animal");
		        System.out.println("4 - Supprimer animal");
		        System.out.println("5 - Afficher les enclos et leurs animaux");
		        System.out.println("6 - Afficher le nombre d'enclos existant");
		        System.out.println("7 - Passez la main à l'employe !");
		        System.out.println("9 - Quitter");
		        System.out.print("\nVotre choix: ");
		        choice = scan.nextInt();
			switch (choice){
				//CREER ENCLOS
				case 1:
					System.out.println("\nCREER ENCLOS");
					System.out.println("============\n");
					i = 0;
					System.out.println("1 - ENCLOS TERRESTRE");
				    System.out.println("2 - VOLIERE");
				    System.out.println("3 - AQUARIUM");
				    System.out.println("9 - Annuler");
				    System.out.print("\nVotre choix: ");
				    choice = scan.nextInt();
				    switch(choice){
				    //CREER ENCLOS TERRESTRE
				    case 1 :
				    	System.out.println("\nEntrer un nom d'enclos (Un seul mot) :");
						String nomEnclos = scan.next();
						scan.nextLine();
				    	System.out.println("Entrer une superficie d'enclos :");
						float superficieEnclos = scan.nextFloat();
						System.out.println("Entrer un nombre maximum d'animaux :");
						int nbrMaxAnimaux= scan.nextInt();
						System.out.println("Choississez l'espèce d'animal qu'aura cet enclos :");
						System.out.println("T pour tigre, O pour ours, L pour loup...");
						System.out.print("\nVotre choix: ");
						especeEnclos = scan.next();
						especeEnclos = especeEnclos.toUpperCase();
						if (zoo.getListeEnclos().size() < zoo.getMaxEnclos()) {
							//EnclosTerrestre<Tigre> 
							if(especeEnclos.equals("T")){
								EnclosTerrestre<Tigre> a = new EnclosTerrestre<Tigre>(nomEnclos, superficieEnclos, nbrMaxAnimaux);
								Tigre t = new Tigre("temporaire", false, 0, 0, 0);
								a.listeAnimauxInvisible.add(t);
					            zoo.getListeEnclos().add(a);
					            zoo.attenteCreation("E");
					            System.out.println("Enclos cree !");
					            break;
							}else
								if(especeEnclos.equals("O")){
									EnclosTerrestre<Ours> a = new EnclosTerrestre<Ours>(nomEnclos, superficieEnclos, nbrMaxAnimaux);
									Ours t = new Ours("temporaire", false, 0, 0, 0);
									a.listeAnimauxInvisible.add(t);
						            zoo.getListeEnclos().add(a);
						            zoo.attenteCreation("E");
						            System.out.println("Enclos cree !");
						            break;
								}else
									if(especeEnclos.equals("L")){
										EnclosTerrestre<Loup> a = new EnclosTerrestre<Loup>(nomEnclos, superficieEnclos, nbrMaxAnimaux);
										Loup t = new Loup("temporaire", false, 0, 0, 0);
										a.listeAnimauxInvisible.add(t);
							            zoo.getListeEnclos().add(a);
							            zoo.attenteCreation("E");
							            System.out.println("Enclos cree !");
							            break;
									}
								
							
							System.out.println("Erreur !!");
							break;
							
				        } else {
				            // TODO : throw exception
				            System.out.println("Erreur, vous avez depasse le nombre maximum d'enclos creer.");
				            break;
				        }
					//CREER VOLIERE
				    case 2:
				    	System.out.println("Entrer un nom de volière (Un seul mot) :");
						String nomV = scan.next();
						scan.nextLine();
						System.out.println("Entrer une superficie d'enclos :");
						float superficieV = scan.nextFloat();
						System.out.println("Entrer un nombre maximum d'animaux :");
						int nbrMaxV = scan.nextInt();
						System.out.println("Entrer l'hauteur de la volière :");
						int hauteurV = scan.nextInt();
						System.out.println("Choississez l'espèce d'animal qu'aura cet enclos :");
						System.out.println("A pour aigle...");
						System.out.print("\nVotre choix: ");

						especeEnclos = scan.next();
						especeEnclos = especeEnclos.toUpperCase();
						especeEnclos.toUpperCase();
						if (zoo.getListeEnclos().size() < zoo.getMaxEnclos()) {
							
							if(especeEnclos.equals("A")){
								Voliere<Aigle> v = new Voliere<Aigle>(nomV, superficieV, nbrMaxV, hauteurV);
								Aigle t = new Aigle("temporaire", false, 0, 0, 0);
								v.listeAnimauxInvisible.add(t);
					            zoo.getListeEnclos().add(v);
					            zoo.attenteCreation("V");
					            System.out.println("Volière cree !");
					            break;
							}else{
								System.out.println("Erreur !!");
								break;
							}

				        } else {
				            // TODO : throw exception
				            System.out.println("Erreur, vous avez depasse le nombre maximum d'enclos creer.");
				        }
				    break;
				    	
				    //CREER AQUARIUM
				    case 3:
						System.out.println("Entrer un nom d'aquarium (Un seul mot) :");
						String nomA = scan.next();
						scan.nextLine();
						System.out.println("Entrer une superficie d'enclos :");
						float superficieA = scan.nextFloat();
						System.out.println("Entrer un nombre maximum d'animaux :");
						int nbrMaxA = scan.nextInt();
						System.out.println("Entrer une profondeur :");
						int profondeurA = scan.nextInt();
						System.out.println("Choississez l'espèce d'animal qu'aura cet enclos :");
						System.out.println("B pour baleine, P pour pingouin, E pour poisson rouge, R pour requin...");
						System.out.print("\nVotre choix: ");
						scan.nextLine();
						especeEnclos = scan.next();
						especeEnclos = especeEnclos.toUpperCase();
						especeEnclos.toUpperCase();
						if (zoo.getListeEnclos().size() < zoo.getMaxEnclos()) {
							if(especeEnclos.equals("B")){
								Aquarium<Baleine> c = new Aquarium<Baleine>(nomA, superficieA, nbrMaxA, profondeurA);
								Baleine t = new Baleine("temporaire", false, 0, 0, 0);
								c.listeAnimauxInvisible.add(t);
					            zoo.getListeEnclos().add(c);  
					            zoo.attenteCreation("A");
					            System.out.println("Aquarium cree !");
					            break;
							} else if(especeEnclos.equals("P")){
								Aquarium<Pingouin> c = new Aquarium<Pingouin>(nomA, superficieA, nbrMaxA, profondeurA);
								Pingouin t = new Pingouin("temporaire", false, 0, 0, 0);
								c.listeAnimauxInvisible.add(t);
					            zoo.getListeEnclos().add(c);   
					            zoo.attenteCreation("A");
					            System.out.println("Aquarium cree !");
					            break;
							} else if(especeEnclos.equals("E")){
								Aquarium<PoissonRouge> c = new Aquarium<PoissonRouge>(nomA, superficieA, nbrMaxA, profondeurA);
								PoissonRouge t = new PoissonRouge("temporaire", false, 0, 0, 0);
								c.listeAnimauxInvisible.add(t);
					            zoo.getListeEnclos().add(c);    
					            zoo.attenteCreation("A");
					            System.out.println("Aquarium cree !");
					            break;
							} else if(especeEnclos.equals("R")){
								Aquarium<Requin> c = new Aquarium<Requin>(nomA, superficieA, nbrMaxA, profondeurA);
								Requin t = new Requin("temporaire", false, 0, 0, 0);
								c.listeAnimauxInvisible.add(t);
					            zoo.getListeEnclos().add(c);   
					            zoo.attenteCreation("A");
					            System.out.println("Aquarium cree !");
					            break;
							}else{
								System.out.println("Erreur !!");
								break;
							}
							
				        } else {
				            // TODO : throw exception
				            System.out.println("Erreur, vous avez depasse le nombre maximum d'enclos creer.");
				        }
						break;
				    	case 9 :
				    		System.out.println("A toute !");
						break;
				    }
					
				break;
					
				//SUPPRIMER ENCLOS
				case 2:
					System.out.println("\nSUPPRIMER ENCLOS");
					System.out.println("=================\n");
					if(zoo.listeEnclos.size() ==0){
						System.out.println("\nCreer d'abord un enclos !!");
						break;
					}
					System.out.println("\nListe des enclos\n");
					indice = 0;
					for(Enclos a : zoo.listeEnclos){
						System.out.println("--- "+indice+" "+a.getNom());
						indice++;
					}
					System.out.print("\nVotre choix: ");
					int enclos = scan.nextInt();
					zoo.supprimerEnclos(enclos);
				break;
						
				//CREER ANIMAL
				case 3:
					System.out.println("\nCREER ANIMAL");
					System.out.println("============\n");
					if(zoo.listeEnclos.size() ==0){
						System.out.println("\nCreer d'abord un enclos !!");
						break;
					}
					System.out.println("\nListe des enclos\n");
					indice = 0;
					for(Enclos a : zoo.listeEnclos){
						System.out.println("--- "+indice+" "+a.getNom());
						indice++;
					}
					System.out.print("\nVotre choix: \n");
					enclos = scan.nextInt();
					zoo.creerAnimal(enclos);
					break;
					
				//SUPPRIMER ANIMAL
				case 4:
					System.out.println("\nSUPPRIMER ANIMAL");
					System.out.println("================\n");
					if(zoo.listeEnclos.size() ==0){
						System.out.println("\nCreer d'abord un enclos !!");
						break;
					}
					System.out.println("\nListe des enclos\n");
					indice = 0;
					for(Enclos a : zoo.listeEnclos){
						System.out.println("--- "+indice+" "+a.getNom());
						indice++;
					}
					System.out.print("\nVotre choix: \n");
					enclos = scan.nextInt();
					zoo.supprimerAnimal(enclos);
					break;
						
				//AFFICHER ENCLOS
				case 5:
					if(zoo.listeEnclos.size() ==0){
						System.out.println("Aucun enclos présent dans le zoo !!");
						break;
					}
					zoo.afficheAnimauxEnclos();
				break;
					
				//AFFICHER NOMBRE D'ANIMAUX ET D'ENCLOS
				case 6:
					if(zoo.listeEnclos.size() ==0){
						System.out.println("Aucun enclos présent dans le zoo !!");
						break;
					}
					zoo.afficheNbreAnimaux();
				break;
				
				//MENU EMPLOYER
				case 7:
					System.out.println("\n*************************");
					System.out.println("VOUS ETES L'EMPLOYER");
					System.out.println("*************************\n");

					choiceEnclos = 0;
					String choiceEmployer;
					Boolean loop1 = true;
					
					//SOUS MENU
					do{
						indice = 0;
						System.out.println("\nListe enclos :\n");
						for(Enclos a : zoo.listeEnclos){
							System.out.println("--- "+indice+" "+a.getNom());
							indice++;
						}
						System.out.println("\n Que voulez vous faire ? :"+" \n"+
								"a: Examiner un enclos"+"\n"+
								"b: Nettoyer un enclos"+" \n"+
								"c: Nourir un enclos"+" \n"+
								"d: Transferer un animal"+" \n"+
								"q: Quit"+"\n");
						System.out.print("Votre choix: ");
						choiceEmployer = scan.next();
						
						switch (choiceEmployer){
							//EXAMINER UN ENCLOS
							case "a":
								System.out.println("-----EXAMINER ENCLOS--------");
								if(zoo.listeEnclos.size() ==0){
									System.out.println("Creer d'abord un enclos !!");
									break;
								}
								System.out.println("\nChoisir un enclos :");
								choiceEnclos = scan.nextInt();
								employer.examinerEnclos(zoo.listeEnclos.get(choiceEnclos));
							break;
		
							//NETTOYER UN ENCLOS
						    case "b":
					    		i = 0;
						    	System.out.println("---------NETTOYER UN ENCLOS------");
								if(zoo.listeEnclos.size() == 0){
									System.out.println("Creer d'abord un enclos !!");
									break;
								}
						    	System.out.println("\nChoisir un enclos :");
								choiceEnclos = scan.nextInt();
								employer.nettoyerEnclos(zoo.listeEnclos.get(choiceEnclos));
					        break;
						        
					        //NOURIR UN ENCLOS
						    case "c":
					    		i = 0;
						    	System.out.println("---------NOURIR UN ENCLOS------");
								if(zoo.listeEnclos.size() ==0){
									System.out.println("Creer d'abord un enclos !!");
									break;
								}
						    	System.out.println("\nChoisir un enclos :");
								choiceEnclos = scan.nextInt();
								if(choiceEnclos <= (zoo.listeEnclos.size()-1)){
									employer.nourirAnimauxEnclos(zoo.listeEnclos.get(choiceEnclos));
								}else{
									System.out.println("Erreur de saisie.");
								}
								
					        break;
					        
					        //TRANSFERER UN ANIMAL DANS UN AUTRE ENCLOS
						    case "d":
					    		i = 0;
						    	System.out.println("---------TRANSFERER ANIMAL------");
								if(zoo.listeEnclos.size()==0){
									System.out.println("Creer d'abord un enclos !!");
									break;
								}
						    	zoo.transfererAnimal();
							break;
							
							//QUITTER LE SOUS MENU
						    case "q":
						    	System.out.println("Bye !");
						    	loop1 = false;
						    break;
					    }
					}while(loop1 == true);
					
				break;
				
				//QUITTER LE PROGRAMME
				case 9:
					System.out.println("Bye !");
					loop = false;
				break;		
			}
			
			System.out.println("\n\n");
			zoo.randomAll();
			
		}while(loop == true);
	}

}
