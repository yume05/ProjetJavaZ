package zoo.Modele.Interface.Employee;

import zoo.Modele.Enclos.*;
import zoo.Modele.Animal.*;

/**
 * public interface EmployeInterface
 * Interface de la classe Employe
 */
public interface EmployeInterface {
	void examinerEnclos(Enclos<Animal> enclos);
	void nettoyerEnclos(Enclos<Animal> enclos);
	void nourirAnimauxEnclos(Enclos<Animal> enclos);
	void transferAnimalEnclos(Enclos<Animal> enclosOriginal, Enclos<Animal> enclosFutur, Animal monAnimal);
}
