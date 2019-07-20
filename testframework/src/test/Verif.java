package testframework;

import logger.ConsoleLogger;


public class Verif{

static  double cmpt_Ok=0;
  public static String verifieVrai(boolean condition) {
    if(condition) {

      cmpt_Ok++;
      return "OK";
    } else {

      return "KO";
    }
  }
  public static String verifieEgal(int attendu, int resultat) {
    if(attendu == resultat) {
      cmpt_Ok++;
      return "OK";
    } else {

      return "KO";
    }
  }

  public static String verifieString (String attendu, String resultat) {

    if (attendu.equals(resultat)) {

        cmpt_Ok++;
        return "OK";
      } else {

        return "KO";
      }
    }

  public static void afficheTest (String className, String methodName, String status, double timer) {
    ConsoleLogger logger = new ConsoleLogger();
    if(status.equals("OK"))
      logger.info("OUTPUT", "Summary : class "+className+", method "+methodName+ ", status = "+status+", time = "+String.valueOf(timer));
    else
      logger.error("OUTPUT", "Summary : class "+className+", method "+methodName+ ", status = "+status+", time = "+String.valueOf(timer));
  }

  public static double get_nbOK(){
    return cmpt_Ok;
  }

  }
