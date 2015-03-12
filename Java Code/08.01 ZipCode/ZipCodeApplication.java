package zipcodeapplication;

public class ZipCodeApplication {

    public static void main(String[] args) {
        ZipCode zip = new ZipCode(123456789);
        System.out.println("Value "+zip.getZipCode()+" has " +zip.isValid() +" format.");
    }
    
}
