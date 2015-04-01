package acme.heater;

import com.ventoelectrics.waterheater.VentoHeater;

public class AcmeHeaterAdapter implements AcmeHeater{
	private VentoHeater heater;
	
	public AcmeHeaterAdapter(VentoHeater heater) {
		this.heater=heater;
	}
	@Override
	public void turnHeaterOn() {
		heater.enable();
	}

	@Override
	public void turnHeaterOff() {
		heater.disable();
	}

}
