package zipcodeapplication;

public class ZipCode {
    private final int zipCode;
    public int length;

    public ZipCode(int zipCode) {
        this.zipCode = zipCode;
        this.length=length();
    }

    public int getZipCode() {
        return zipCode;
    }
    
    public final int length(){
        int n=zipCode,len=0;
        while(n>0){
            len++;
            n/=10;
        }
        return len;
    }
    public boolean isValid(){
        return (length==5||length==9);
    }
    
}
