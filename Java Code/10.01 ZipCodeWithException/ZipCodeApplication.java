package zipcodeapplication;

public class ZipCodeApplication {

    public static void main(String[] args) {
            ZipCode zip = new ZipCode();
        try {
            zip.setZipCode(123456);
            zip.print();
        } catch (ZipCodeException ex) {
            System.out.println(ex.getMessage());
        }
            
    }
    
}
