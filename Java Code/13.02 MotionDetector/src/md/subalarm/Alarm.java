package md.subalarm;

public class Alarm implements SubscribedAlarmChannel {
	
	public Alarm() {
	}
	@Override
	public void turnAlarm() {
		System.out.println(" Alarm Turned ON");
	}

}
