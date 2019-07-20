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

public class ClassCompteSimplifie {
  ConsoleLogger logger = new ConsoleLogger();
  Random rn = new Random();
  Compte compteTest = new Compte(" ",0);


  public boolean deposit() {	//Deposit some money to your account

    Logger logger = LoggerFactory.getLogger();
    float money = (float)Math.round(((float)Math.random()*100)/100);
    float befor_test;

    compteTest.setBalance(rn.nextFloat());
    if (money<0){
      logger.error("OUTPUT","error: montant du depot:"+money+"Le test sur la methode deposit de la class Compte a échoué car la valeur du depot est inferieur a 0");
      return false;
    }
    befor_test = compteTest.getBalance();
    compteTest.setBalance(compteTest.getBalance() + money);

    if((befor_test + money) != compteTest.getBalance()){
      logger.error("OUTPUT","error: Class: Compte, methode: deposit, Montant attendu: "+(befor_test + money) +" Montant obtenu: "+compteTest.getBalance());
      return false;
    }

    return true;
  }

  public boolean withdraw() {	//Withdraw some money from your account

      Logger logger = LoggerFactory.getLogger();
      float money = (float)Math.round(((float)Math.random()*100)/100);
      float befor_test;
      compteTest.setBalance(rn.nextFloat());
      if (money<0){
        logger.error("OUTPUT","montant du depot:"+money+"Le test sur la methode deposit de la class Compte a échoué car la valeur du depot est inferieur a 0");
        return false;
      }

      if (compteTest.getBalance()==0){
        logger.error("OUTPUT"," error: Le test sur la methode withdraw de la class Compte a échoué car la valeur du depot est egale a 0 ");
        return false;
      }
      befor_test = compteTest.getBalance();
      compteTest.setBalance(compteTest.getBalance() - money);

      if((befor_test - money) != compteTest.getBalance()){
        logger.error("OUTPUT","error: Class: Compte, methode: deposit, Montant attendu: "+(befor_test - money)+" Montant obtenu: "+compteTest.getBalance());
        return false;
      }

      return true;
  }

  public boolean transfert(Compte accountTo) {	//Transfert money from one account to another

    Logger logger = LoggerFactory.getLogger();
    float money=(float)Math.round(((float)Math.random()*100)/100);
    compteTest.setBalance(rn.nextFloat());

    float befor_test;
    float befor_test2;
    if(compteTest.getBalance()==0) {
      logger.error("OUTPUT","error");
      return false;
    }
    if (money<0){
      logger.error("OUTPUT","error: montant du depot:"+money+"Le test sur la methode transfert de la class Compte a échoué car la valeur du depot est inferieur a 0");
      return false;
    }
      befor_test = compteTest.getBalance();
      befor_test2 = accountTo.getBalance();
      compteTest.setBalance(compteTest.getBalance() - money); //Substract from
      accountTo.setBalance(accountTo.getBalance() + money);    //Add to


      return true;
    }


}
