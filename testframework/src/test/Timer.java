package testframework;

import java.lang.System.*;


public class Timer {

  public long begin(){
    return (System.currentTimeMillis());
  }

  public double end(long p_begin){
    return (double)(System.currentTimeMillis()-p_begin)/1000;
  }

}
