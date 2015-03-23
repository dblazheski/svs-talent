
public class NumberPrinterApplication {

	public static void main(String[] args){
		int number = Integer.parseInt(args[0]);
		int interval= Integer.parseInt(args[1]);
		NumberPrinter numberp=new NumberPrinter(number);
		Thread thread = new Thread(numberp);
		thread.start();
		try {
			Thread.sleep(interval);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(thread.isAlive())
		thread.interrupt();
		else System.out.println("Thread is already finished");
	}
}
