package zoo.Modele.Animal;

import java.util.Random;

/**
 * public abstract class Animal
 * Classe abstraite Animal
 * Classe permettant de creer des animaux
 */
public abstract class Animal{

	/**
	 * public Animal()
	 * Constructeur de la classe Animal
	 */
	public Animal() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Variable protegee de type String
	 * Nom de l'animal
	 */
	protected String nom;
	/**
	 * Variable protegee de type Boolean
	 * Sexe de l'animal
	 */
	protected Boolean sexe;
	/**
	 * Variable protegee de type String
	 * Le sexe de l'animal en String "Femelle" "Male"
	 */
	protected String sexeString;
	/**
	 * Variable protegee de type int
	 * Poids de l'animal
	 */
	protected int poids;
	/**
	 * Variable protegee de type int
	 * Taille de l'animal
	 */
	protected int taille;
	/**
	 * Variable protegee de type int
	 * Age de l'animal
	 */
	protected int age;
	//True == les indices sont tous à 100 % donc pas besoin de manger, dormir, ou être soigne
	/**
	 * Variable privee de type Boolean
	 * Indice de faim de l'animal 
	 * True etant le fait que l'animal n'a pas faim.
	 */
	private Boolean indiceFaim = true;
	/**
	 * Variable privee de type Boolean
	 * Indice de sommeil de l'animal
	 * True etant le fait que l'animal à besoin de dormir
	 */
	private Boolean indiceSommeil = false;
	
	/**
	 * Variable privee de type Boolean
	 * Indice de Sante de l'animal
	 * Tue etant le fait que l'animal doit se faire soigner
	 */
	private Boolean indiceSante = false;
	
	/**
	 * protected abstract void mangerVrai();
	 * Methode abstraite protegee permettant à l'animal de manger
	 */
	protected abstract void mangerVrai();
	
	/*/**
	 * protected abstract void crier();
	 * Methode abstraite protegee permettant à l'animal de crier
	 */
	//protected abstract void crier();*/
	
	/**
	 * protected abstract void accouplement(Animal a1, Animal a2);
	 * Methode abstraite protege permettant à l'animal de s'accoupler
	 * @param a1
	 * @param a2
	 */
	protected abstract void accouplement(Animal a1, Animal a2);
	
	/**
	 * Getters de l'indice Faim
	 * @return indiceFaim
	 */
	public Boolean getIndiceFaim() {
		return indiceFaim;
	}
	
	/**
	 * Setters de l'indice Faim
	 */
	public void setIndiceFaim(Boolean indiceFaim) {
		this.indiceFaim = indiceFaim;
	}

	/**
	 * Getters de l'indice de Sommeil
	 * @return indiceSommeil
	 */
	public Boolean getIndiceSommeil() {
		return indiceSommeil;
	}

	/**
	 * Setters de l'indice de Sommeil
	 */
	public void setIndiceSommeil(Boolean indiceSommeil) {
		this.indiceSommeil = indiceSommeil;
	}

	/**
	 * Getter de l'indice de sante
	 * @return indiceSante
	 */
	public Boolean getIndiceSante() {
		return indiceSante;
	}

	/**
	 * Setter de l'indice de sante
	 */
	public void setIndiceSante(Boolean indiceSante) {
		this.indiceSante = indiceSante;
	}
	
	/**
	 * Getter de nom
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Setter de nom
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter de sexe
	 * @param sexe
	 */
	public void setSexe(Boolean sexe) {
		this.sexe = sexe;
	}
	
	/**
	 * Setter de sexe
	 * @return sexe 
	 */
	public boolean isSexe(){
		return sexe;
	}
	
	/**
	 * Getter de poids
	 * @return poids
	 */
	public int getPoids() {
		return poids;
	}

	/**
	 * Setter de poids
	 * @param poids
	 */
	public void setPoids(int poids) {
		this.poids = poids;
	}
	
	/**
	 * Getter de taille
	 * @return taille
	 */
	public int getTaille() {
		return taille;
	}
	
	/**
	 * Setter de taille
	 * @param taille
	 */
	public void setTaille(int taille) {
		this.taille = taille;
	}

	/**
	 * Getter d'age
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Setter d'age
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	
	/**
	 * public String toString()
	 * Premiere Methode appelait lors de l'execution de la classe
	 * Permet d'afficher les caracteristiques de l'animal
	 * @Override
	 * @return str
	 */
	public String toString() {
		if(this.isSexe()){
			sexeString = "femelle";
		}else{
			sexeString = "mâle";
		}
		String str = "Nom ="+this.getNom()+"; sexe = "+sexeString+"; age= "+this.getAge()+" ans; pèse ="+this.getPoids()+"kg; taille= "+this.getTaille()+"cm.";
		return str;
	}

	
	/**
	 * public void soigner()
	 * Methode permettant de soigner l'animal s'il est malade
	 */
	public void soigner(){
		if(this.indiceSante){
			System.out.println("Je suis malade..");
			this.indiceSante = false;
			System.out.println("Merci, je suis soigne !");
		}else{
			System.out.println("Je suis dejà soigne..");
		}
			
	}
	
	/**
	 * public Boolean getRandomBoolean()
	 * Methode de type Boolean permettant de renvoyer un boolean random (True or False)
	 * @return random.nextBoolean()
	 */
	public Boolean getRandomBoolean(){
		Random random = new Random();
		return random.nextBoolean();
	}
	
	/**
	 * public void dormir()
	 * Methode permettant de faire dormir l'animal s'il en a besoin
	 */
	public void dormir(){
		if(this.indiceSommeil){
			System.out.println("J'ai sommeil je m'endors...");
			this.indiceSommeil = false;
		} else {
			System.out.println("Je dors dejà.. Chut..");
		}
	}
	
	/**
	 * public void seReveiller()
	 * Methode permettant de reveiller l'animal s'il dort
	 */
	public void seReveiller(){
		if(this.indiceSommeil == true){
			System.out.println("Je ne peux pas me reveiller, je ne suis pas entrain de dormir !");
		} else {
			System.out.println("Je me reveille...");
			this.indiceSommeil = true;
			this.indiceFaim = false;
		}
	}
	
	/**
	 * public void manger()
	 * Methode permettant de faire manger l'animal s'il a faim
	 */
	public void manger(){
		if(this.indiceFaim == true){
			System.out.println("Je ne veux pas manger, je n'ai pas faim ...");
		}else if(this.indiceFaim == false){
			mangerVrai();
			this.indiceFaim = true;
			System.out.println("Nous avons bien ete nourris !");
		}
	}
	
	/**
	 * public void crier()
	 * Méthode permettant de faire crier l'animal
	 */
	public void crier(){
		crier();
	}

}
