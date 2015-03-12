package investitionapplication;

public class InvestitionApplication {

    public static void main(String[] args) {
        Investition invest = new Investition(14000);
        invest.increasePercent(40);
        invest.decrease(1500);
        invest.increasePercent(12);
        invest.printValue();
    }
    
}
