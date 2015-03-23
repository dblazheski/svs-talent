package stopwatchapplication;

public class Stopwatch implements Runnable{
    int counter=0;
    boolean wait=false;
    boolean running=true;
    final Thread thread;

    public Stopwatch() {
        this.thread=new Thread(this);
        thread.start();
    }
    
    public void pause(){
        wait=true;
    }

    public void resume(){
        wait=false;
        synchronized (thread){
        thread.notify();
        }
    }
    
    public void stop(){
        running=false;
        thread.interrupt();
    }
    
    public void reset(){
        this.counter=0;
    }
    
    @Override
    public void run() {
        while(running){
            System.out.println(counter++);
            if(Thread.interrupted()){
            return;
            }
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {}
            
            if(wait)
                try{
                synchronized(thread){ thread.wait(); }
                }catch(InterruptedException e){}
        }
    }
    
}
