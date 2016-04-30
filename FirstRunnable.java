public class FirstRunnable {
  public static void main(String[] args){

    Runnable runnable = () -> {
      System.out.println("I am running in: " + Thread.currentThread().getName());
    };

    Thread t1 = new Thread(runnable);
    t1.setName("My Thread");
    t1.start();

    // t1.start(); Will start our desired Thread
    // t2.run(); NO NO NO..... this will run on the MAIN thread instead

  }
}
