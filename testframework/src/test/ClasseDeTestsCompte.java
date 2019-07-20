package testframework;

import logger.*;

import banking.*;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class ClasseDeTestsCompte {
/* Initialisation des class */

Compte compteTest = new Compte(" ",0);


Timer timer = new Timer();
ConsoleLogger logger = new ConsoleLogger();
Random rn = new Random();
ClassCompteSimplifie compteSimplifie = new ClassCompteSimplifie();

static double cmpt_totale = 0;
static double cmpt_temps = 0;



// TESTS POUR LA CLASS COMPTE

// TEST SUR SETAGE/GETAGE
public void testsetgetAge() {

  long debut = timer.begin();
  double fin;
  int testage ;
  testage = rn.nextInt();
  compteTest.setAge(testage);
  fin=timer.end(debut);

  Verif.afficheTest("Compte","setgetAge",Verif.verifieEgal(testage, compteTest.getAge()),fin);

  cmpt_temps = cmpt_temps + fin;
  cmpt_totale++;
}

// TEST SUR LES METHODE DE LA CLASS COMPTE
// TEST SUR SETNAME/GETNAME
public void testsetgetName() {
  long debut = timer.begin();
  double fin;
  String testname ;
  testname = "Béatrice";
  compteTest.setName(testname);
  fin=timer.end(debut);

  Verif.afficheTest("Compte","setgetName",Verif.verifieString(testname, compteTest.getName()),fin);

  cmpt_temps = cmpt_temps + fin;
  cmpt_totale++;
}

// TEST SUR SETBALANCE/GETBALANCE
public void testsetgetBalance() {
  long debut = timer.begin();
  double fin;
  float testbalance ;
  testbalance = (float)Math.round(((float)Math.random()*100)/100);
  compteTest.setBalance(testbalance);
  fin=timer.end(debut);

  Verif.afficheTest("Compte","setgetBalance",Verif.verifieVrai(testbalance == compteTest.getBalance()),fin);

  cmpt_temps = cmpt_temps + fin;
  cmpt_totale++;
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




public void testdeposit(){
  long debut = timer.begin();
  double fin;
  String test;
  test = Verif.verifieVrai(compteSimplifie.deposit());
  fin = timer.end(debut);
  Verif.afficheTest("Compte","deposit",test,fin);
  cmpt_temps = cmpt_temps + fin;
  cmpt_totale++;
}


public void testwithdraw(){
  long debut = timer.begin();
  double fin;
  String test;
  test = Verif.verifieVrai(compteSimplifie.withdraw());
  fin = timer.end(debut);
  Verif.afficheTest("Compte","withdraw",test,fin);
  cmpt_temps = cmpt_temps + fin;
  cmpt_totale++;
}

public void testtransfer(){
  long debut = timer.begin();
  Compte compteTest2 = new Compte(" ",0);
  compteTest2.setBalance(rn.nextFloat());
  double fin;
  String test;
  test = Verif.verifieVrai(compteSimplifie.transfert(compteTest2));
  fin = timer.end(debut);
  Verif.afficheTest("Compte","transfert",test,fin);
  cmpt_temps = cmpt_temps + fin;
  cmpt_totale++;
}




public void compteur(){
  logger.info("OUTPUT","          ");
  logger.info("OUTPUT","Pourcentage de réussite: "+(double)Math.round((Verif.get_nbOK()/cmpt_totale*100)*100)/100+"%");
  logger.info("OUTPUT","Durée totale: "+cmpt_temps+" secondes");
  //(float)Math.round(p_balance*100)/100
}



}
