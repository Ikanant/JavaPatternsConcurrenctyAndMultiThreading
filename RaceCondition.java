public class RaceCondition{
  public static void main(String[] args){
    LongWrapper lw = new LongWrapper(0L);

    Runnable r = () -> {
      for (int i=0; i<1_000; i++) {
        lw.incrementValue();
      }
    };

    Thread t = new Thread(r);

    t.start();

    try{
      t.join();
    } catch (InterruptedException e){
      System.out.println(e.toString());
    }

    System.out.println("Value= " + lw.getValue());
  }
}

 class LongWrapper{
  private long l;

  public LongWrapper (long l){
    this.l = l;
  }

  public long getValue(){
    return l;
  }

  public void incrementValue(){
    l++;
  }
}
