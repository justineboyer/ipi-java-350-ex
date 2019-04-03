package com.ipiecoles.java.java350.model;

import com.ipiecoles.java.java350.repository.EmployeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.Date;

public class EmployeTest {

    @Test
    public void getNombreAnneeAncienneteNow(){
        //Given
        Employe e = new Employe();
        e.setDateEmbauche(LocalDate.now());

        //When
        Integer anneeAnciennete = e.getNombreAnneeAnciennete();

        //Then
        Assertions.assertEquals(0, anneeAnciennete.intValue());
    }

    @Test
    public void getNombreAnneeAncienneteNminus2(){
        //Given
        Employe e = new Employe();
        e.setDateEmbauche(LocalDate.now().minusYears(2L));

        //When
        Integer anneeAnciennete = e.getNombreAnneeAnciennete();

        //Then
        Assertions.assertEquals(2, anneeAnciennete.intValue());
    }

    @Test
    public void getNombreAnneeAncienneteNull(){
        //Given
        Employe e = new Employe();
        e.setDateEmbauche(null);

        //When
        Integer anneeAnciennete = e.getNombreAnneeAnciennete();

        //Then
        Assertions.assertEquals(0, anneeAnciennete.intValue());
    }

    @Test
    public void getNombreAnneeAncienneteNplus2(){
        //Given
        Employe e = new Employe();
        e.setDateEmbauche(LocalDate.now().plusYears(2L));

        //When
        Integer anneeAnciennete = e.getNombreAnneeAnciennete();

        //Then
        Assertions.assertEquals(0, anneeAnciennete.intValue());
    }

    @ParameterizedTest
    @CsvSource({
            "1, 'T12345', 0, 1.0, 1000.0",
            "1, 'T12345', 2, 0.5, 600.0",
            "1, 'T12345', 2, 1.0, 1200.0",
            "2, 'T12345', 0, 1.0, 2300.0",
            "2, 'T12345', 1, 1.0, 2400.0",
            "1, 'M12345', 0, 1.0, 1700.0",
            "1, 'M12345', 5, 1.0, 2200.0",
            "2, 'M12345', 0, 1.0, 1700.0",
            "2, 'M12345', 8, 1.0, 2500.0"
    })
    public void getPrimeAnnuelle(Integer performance, String matricule, Long nbYearsAnciennete, Double tempsPartiel, Double primeAnnuelle){
        //Given
        Employe employe = new Employe("Doe", "John", matricule, LocalDate.now().minusYears(nbYearsAnciennete), Entreprise.SALAIRE_BASE, performance, tempsPartiel);

        //When
        Double prime = employe.getPrimeAnnuelle();

        //Then
        Assertions.assertEquals(primeAnnuelle, prime);

    }

//test réalisés pour couvrir la methode augmenterSalaire
// Les conditions utilisées sont un pourcentage egal à 0, un négatif, un élevé et un classique.
@Test
    public void testPourcentageEgal0(){
    //Given
    Employe e = new Employe();
    e.setSalaire(2000.0);
    e.augmenterSalaire(0.0);

    //When
    e.getSalaire();

    //Then

    Assertions.assertEquals(2000.0, e.getSalaire().doubleValue());
    }

    @Test

    public void testPourcentageSuperieurA100(){
        //Given
        Employe e = new Employe();
        e.setSalaire(2000.0);
        e.augmenterSalaire(1.0);

        //When
        e.getSalaire();

        //Then

        Assertions.assertEquals(4000.0, e.getSalaire().doubleValue());
    }


@Test
    public void testPourcentageNegatif(){
    //Given
    Employe e = new Employe();
    e.setSalaire(2000.0);
    e.augmenterSalaire(-1.5);

    //When
    e.getSalaire();

    //Then

    Assertions.assertEquals(0, e.getSalaire().doubleValue());
    }

@Test
    public void testPourcentageOk(){
    //Given
    Employe e = new Employe();
    e.setSalaire(2000.0);
    e.augmenterSalaire(0.5);

    //When
    e.getSalaire();

    //Then

    Assertions.assertEquals(3000.0, e.getSalaire().doubleValue());
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2019-01-01, 8",
            "1, 2021-01-01, 11",
            "0.5, 2022-01-01, 5",
            "0.5, 2032-01-01, 6"
    })
    public void getNbRtt (Double tempsPartiel, LocalDate date, Integer nbRtt){
        //Given
        Employe employe = new Employe();
        employe.setTempsPartiel(tempsPartiel);

        //When
        Integer resultatRtt = employe.getNbRtt(date);

        //Then
        Assertions.assertEquals(nbRtt, resultatRtt);

    }


}