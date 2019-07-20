package testframework;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class RunTest {

  public static void main (String[] args) {

    // REFLEXIVITÉ

    for(int i = 0; i< args.length;i++){
      String className =args[i];  //args[0];
      try {
        Class<?> c = Class.forName(className);


        for(Method method : c.getDeclaredMethods()) {

        //  System.out.println(method.getName());
          Object instance = null;
          try {

            instance = c.newInstance();

          } catch (InstantiationException | IllegalAccessException e) {
            System.out.println(e);

          }
          try {
            method.invoke(instance);
          } catch (InvocationTargetException | IllegalAccessException e) {
            System.out.println(e);

          }
        }


      } catch (ClassNotFoundException e) {
        System.out.println(e);

      }
      //System.out.println(ClasseDeTests.get_compteur());
    }


  }
}
