package md;

import md.imagedevice.ImageCapturedDevice;
import md.subalarm.SubscribedAlarmChannel;

public class MotionDetector {
	ImageCapturedDevice device;
	SubscribedAlarmChannel alarm;
	String image;
	String image2;
	
	public MotionDetector(ImageCapturedDevice device,SubscribedAlarmChannel alarm) {
		this.device=device;
		this.alarm=alarm;
	}
	
	public void run(){
		image=device.getImage();
		while((image2=device.getImage())!=null){
			if(!image.equals(image2))
				alarm.turnAlarm();
			image=image2;
		}
		device.turnOff();
	}

}
