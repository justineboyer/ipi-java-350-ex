package com.ipiecole.java.java350.model;

import com.ipiecoles.java.java350.model.Employe;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class EmployeTest {

    @Test
    public void testGetNombreAnneeAncienneteNow () {
        // Given
        Employe employe = new Employe(); // J'initialise un employé
        LocalDate dateEmbauche = LocalDate.now(); // Je mets la date d'embauche de maintenant
        employe.setDateEmbauche(dateEmbauche); // Je dois stocker cette date dans l'employé

        // When
        Integer nbAnnee = employe.getNombreAnneeAnciennete(); // Je récupère le nombre d'années dans une variable avec la méthode. Cette méthode repose sur une instance donc on doit instancier un employé dans les données d'entrée

        // Then
        // nbAnnee = 0 // Je vérifie que cette date soit égale à la valeur attendue
        Assertions.assertThat(nbAnnee).isEqualTo(0);
    }

    @Test
    public void testGetNombreAnneeAncienneteNull () {
        // Given
        Employe e = new Employe(); // J'initialise un employé
        e.setDateEmbauche(null); // Je dois stocker cette date dans l'employé

        // When
        Integer nbAnnee = e.getNombreAnneeAnciennete(); // Je récupère le nombre d'années dans une variable avec la méthode. Cette méthode repose sur une instance donc on doit instancier un employé dans les données d'entrée

        // Then
        // nbAnnee = 0 // Je vérifie que cette date soit égale à la valeur attendue
        Assertions.assertThat(nbAnnee).isEqualTo(0);
    }

    @Test
    public void testGetNombreAnneeAncienneteNMoins2 () {
        // Given
        Employe e = new Employe(); // J'initialise un employé
        e.setDateEmbauche(LocalDate.now().minusYears(2)); // Je dois stocker cette date dans l'employé

        // When
        Integer nbAnnee = e.getNombreAnneeAnciennete(); // Je récupère le nombre d'années dans une variable avec la méthode. Cette méthode repose sur une instance donc on doit instancier un employé dans les données d'entrée

        // Then
        // nbAnnee = 0 // Je vérifie que cette date soit égale à la valeur attendue
        Assertions.assertThat(nbAnnee).isEqualTo(2);
    }

    @Test
    public void testGetNombreAnneeAncienneteNPlus2 () {
        // Given
        Employe e = new Employe(); // J'initialise un employé
        e.setDateEmbauche(LocalDate.now().plusYears(2)); // Je dois stocker cette date dans l'employé

        // When
        Integer nbAnnee = e.getNombreAnneeAnciennete(); // Je récupère le nombre d'années dans une variable avec la méthode. Cette méthode repose sur une instance donc on doit instancier un employé dans les données d'entrée

        // Then
        // nbAnnee = 0 // Je vérifie que cette date soit égale à la valeur attendue
        Assertions.assertThat(nbAnnee).isEqualTo(0);
    }
}