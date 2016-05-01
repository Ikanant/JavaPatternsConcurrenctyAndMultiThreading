public class RaceCondition{
  public static void main(String[] args){
    LongWrapper lw = new LongWrapper(0L);

    Runnable r = () -> {
      for (int i=0; i<1_000; i++) {
        lw.incrementValue();
      }
    };

    //Thread t = new Thread(r);
    // Create an Array of 1000 Threads that will add the same value... We should get 1_000_000
    Thread threads[] = new Thread[1000];
    for(int j=0; j<threads.length; j++){
      threads[j] = new Thread(r);
      threads[j].start();
      System.out.println("Thread: " + j + " has the value:" + lw.getValue());
    }

    try{
      for(int k=0; k<threads.length; k++){
          threads[k].join();
      }
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
