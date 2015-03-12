package investitionapplication;

public class Investition {
    double invest;

    public Investition(double invest) {
        this.invest = invest;
    }
    public void increasePercent(int value){
        invest+=((invest/100)*value);
        System.out.println("Value after "+value +"% increase is: "+invest);
    }
    public void decrease(int value){
        invest-=value;
        System.out.println("Value after decrease is: "+invest);
    }
    public void printValue(){
        System.out.println("Value is "+invest);
    }
    
}
