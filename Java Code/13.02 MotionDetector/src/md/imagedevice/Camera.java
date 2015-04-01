package md.imagedevice;

import java.util.Scanner;

public class Camera implements ImageCapturedDevice {

	private Scanner scanner;
	String image;
	
	public Camera() {
		this.scanner=new Scanner(System.in);
	}
	
	public void scanImage(){
		this.image=scanner.next();
	}
	
	@Override
	public String getImage() {
		scanImage();
		return image;
	}
	
	public void turnOff(){
		scanner.close();
	}

}
