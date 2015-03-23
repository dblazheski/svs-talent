package zipcodeapplication;

public class ZipCode {
    private int zipCode;

    public ZipCode() {
    }

    public void setZipCode(int zipCode) throws ZipCodeException{
        int temp=length(zipCode);
        if(isValid(temp))
        this.zipCode = zipCode;
        else throw new ZipCodeException("Not a valid value");
    }
    
    public int getZipCode() {
        return zipCode;
    }
    
    public final int length(int value){
        int n=value,len=0;
        while(n>0){
            len++;
            n/=10;
        }
        return len;
    }
    public boolean isValid(int len){
        return (len==5||len==9);
    }
    
    public void print(){
        System.out.println(zipCode);
    }
}
