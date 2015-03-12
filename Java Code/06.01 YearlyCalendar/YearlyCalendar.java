
public class YearlyCalendar {

    final int monthIn = 12;
    int year;
    int days;
    String daysInYear[];
	
	YearlyCalendar(int year){
		this.year=year;
	}
	
    static int countDays(int month, int year) {
        int count = -1;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                count = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                count = 30;
                break;
            case 2:
                if (year % 4 == 0) {
                    count = 29;
                } else {
                    count = 28;
                }
                if ((year % 100 == 0) & (year % 400 != 0)) {
                    count = 28;
                }
        }
        return count;
    }
    
    public int countYearDays(){
    	int days=0;
    for(int i=1;i<=12;i++){
    	days+=countDays(i, year);
    }
    this.days=days;
    return days;
    }
	
	public void setdaysInYear(){
		this.daysInYear=new String[days];
	}
	
    public void createArrayDays(){
    	setdaysInYear();
		int day;
    	for(int i=1,k=0;i<=monthIn;i++){
    		day=countDays(i, year);
    		for(int j=1;j<=day;j++,k++)
    			daysInYear[k]=j+"-"+i+"-"+year;
    	}
    }
	
    public void print(){
    	for(int i=1;i<days;i++)
    		System.out.println(daysInYear[i]);
    }
}

