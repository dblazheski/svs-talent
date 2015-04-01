package acme.thermoregulator;

import acme.AcmeStandardThermoregulator;
import acme.heater.AcmeHeaterAdapter;
import acme.thermometer.AcmeThermometerAdapter;

import com.ventoelectrics.waterheater.VentoHeater;
import com.ventoelectrics.waterheater.VentoThermometer;
import com.ventoelectrics.waterheater.VentoThermoregulator;

public class AcmeStandardThermoregulatorAdapter implements VentoThermoregulator{

	private AcmeStandardThermoregulator thermoregulator;
	private Thread thread;
	
	public AcmeStandardThermoregulatorAdapter(VentoThermometer thermometer, VentoHeater heater) {
		AcmeHeaterAdapter ventoHeater = new AcmeHeaterAdapter(heater);
		AcmeThermometerAdapter ventoThermometer = new AcmeThermometerAdapter(thermometer);
		this.thermoregulator=new AcmeStandardThermoregulator(ventoThermometer,ventoHeater);
		this.thread = new Thread(thermoregulator);
	}
	@Override
	public void enablePower() {
		thermoregulator.turnPowerOn();
		thread.start();
	}

	@Override
	public void disablePower() {
		thermoregulator.turnPowerOff();
		thread.interrupt();
	}

	@Override
	public void setTemperature(Integer temperature) {
		thermoregulator.setThermoregulatorTemperature(temperature);
	}

}
