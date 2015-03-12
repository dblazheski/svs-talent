package sumandremainapplication;

public class SumAndRemain {
    int broj,broj2,sum,remain;

    public SumAndRemain(int broj, int broj2) {
        this.broj = broj;
        this.broj2 = broj2;
    }
    
    public void divide(){
        sum=broj/broj2;
    }
    public void remain(){
        remain=broj%broj2;
    }
    public void print(){
        System.out.println("The sum of "+broj+" and "+broj2+" = "+sum+"\t and remain is " +remain);
    }
}
