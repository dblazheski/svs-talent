package md;
import md.imagedevice.Camera;
import md.imagedevice.ImageCapturedDevice;
import md.subalarm.Alarm;
import md.subalarm.SubscribedAlarmChannel;


public class MotionDetectorApplication {
	
	public static void main(String[] args) {
		ImageCapturedDevice camera = new Camera();
		SubscribedAlarmChannel alarm = new Alarm();
		MotionDetector detector = new MotionDetector(camera,alarm);
		detector.run();
	}
}
