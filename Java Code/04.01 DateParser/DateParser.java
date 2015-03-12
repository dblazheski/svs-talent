import java.util.StringTokenizer;
public class DateParser {
	
	public static void main(String[] args){
		StringTokenizer st1;
		String date= "12/04/2007";
		st1= new StringTokenizer(date,"/");
		System.out.println("Day: "+ st1.nextToken()+"\nMonth: "+st1.nextToken()+"\nYear: "+st1.nextToken());
	}
}