
public class BoxVolumeApplication {
	public static void main(String[] args){
		BoxVolume box= new BoxVolume(10,20,40);
		BoxVolume box2=new BoxVolume(20,40,60);
		int boxVolume=box.calculateVolume();
		int boxVolume2=box2.calculateVolume();
		int maxVolume=Math.max(boxVolume,boxVolume2);
		if(maxVolume==boxVolume) box.print(); else box2.print();
	}

}
