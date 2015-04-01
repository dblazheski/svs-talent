package acme;

import java.util.concurrent.TimeUnit;

import acme.heater.AcmeHeater;
import acme.thermometer.AcmeThermometer;


public class AcmeEfficientThermoregulator implements AcmeThermoregulator,Runnable{

	private boolean powered;
	private Integer temperature;
	private Integer thermometerTemperature;
	AcmeThermometer thermometer;
	AcmeHeater heater;
	
	public AcmeEfficientThermoregulator(AcmeThermometer thermometer, AcmeHeater heater) {
		this.thermometer=thermometer;
		this.heater=heater;
	}
	
	@Override
	public void setThermoregulatorTemperature(Integer temperature) {
		this.temperature=temperature;
	}

	@Override
	public void turnPowerOff() {
		System.out.println("Thermoregulator Powered Off ...");
		powered=false;
	}

	@Override
	public void turnPowerOn() {
		System.out.println("Thermoregulator Powered On ...");
		powered=true;
	}

	public void setThermometerTemperature(){
		this.thermometerTemperature=thermometer.getThermometerTemperature();
	}
	
	@Override
	public void run() {
		while(powered){
			try{
				TimeUnit.SECONDS.sleep(1);
				setThermometerTemperature();
				if(thermometerTemperature>temperature){
					System.out.println(temperature+" < "+thermometerTemperature+" : Thermoregulator turning off the Heater ...");
					heater.turnHeaterOff();
				}
				else {
					System.out.println(temperature+" > "+thermometerTemperature+" : Thermoregulator turning on the Heater ...");
					heater.turnHeaterOn();
				}
			}
			catch(InterruptedException e){}
		}
	}
	
}
