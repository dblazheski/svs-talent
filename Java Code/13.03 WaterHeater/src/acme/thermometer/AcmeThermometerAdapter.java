package acme.thermometer;

import com.ventoelectrics.waterheater.VentoThermometer;

public class AcmeThermometerAdapter implements AcmeThermometer {
	private VentoThermometer thermometer;
	
	public AcmeThermometerAdapter(VentoThermometer thermometer) {
		this.thermometer=thermometer;
	}
	@Override
	public Integer getThermometerTemperature() {
		Integer temperature=thermometer.getTemperature();
		return temperature;
	}

}
