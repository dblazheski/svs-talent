
public class NumberPrinter implements Runnable {
	public int number;
	
	public NumberPrinter(int number) {
		this.number=number;
	}
	
	public void run(){
		for(int i=1;i<number;i++){
			System.out.println(i);

			if(Thread.interrupted()){
				System.out.println("Thread interupted");
				return;
			}
		}
		
	}
	

}
