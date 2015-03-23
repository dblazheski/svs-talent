package stopwatchapplication;

import java.util.Scanner;

public class StopwatchApplication {

    public static void main(String[] args) {
         Stopwatch sw=new Stopwatch();
         Scanner scanner = new Scanner(System.in);
         String choice;
         while(!(choice=scanner.nextLine()).equals("quit")){
             switch(choice){
                 case "stop" : sw.stop();break;
                 case "resume" : sw.resume();break;
                 case "pause" : sw.pause();break;
                 case "reset" : sw.reset();break;
             }
         }
         scanner.close();
        

    }

}
