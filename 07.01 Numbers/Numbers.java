
public class Numbers {
	String[] numbers;
	
	Numbers(String[] numbers){
		this.numbers=new String[numbers.length];
		for(int i=0;i<numbers.length;i++){
			this.numbers[i]=numbers[i];
		}
	}
		public int numberToInt(String number){
			int num=-1;
			switch(number){
			case "zero" : num=0;break;
			case "one" : num=1;break;
			case "two" : num=2;break;
			case "three" : num =3;break;
			case "four" : num= 4;break;
			case "five" : num= 5;break;
			case "six" : num= 6;break;
			case "seven" : num= 7;break;
			case "eight" : num= 8;break;
			case "nine" : num= 9;break;
			}
			return num;
		}
		
		public int stringToInt(){
			int lastNumber=-1;
			int number=0;
			for(int i=0;i<numbers.length;i++){
				lastNumber=numberToInt(numbers[i]);
				number+=lastNumber;
				number*=10;
			}
			number/=10;
			return number;
		}
	}
