package com.ventoelectrics.waterheater;

public class VentoHeater implements VentoPoweredDevice {
	
	private boolean powerEnabled = false;
	
	@Override
	public void enablePower() {
		powerEnabled = true;
		System.out.println("Heater Powered On ...");
	}

	@Override
	public void disablePower() {
		powerEnabled = false;
		System.out.println("Heater Powered Off...");
	}
	
	public void enable() {
		if (!powerEnabled) {
			throw new NoPowerException();
		}
		System.out.println("VentoHeater.enable()");
	}
	
	public void disable() {
		System.out.println("VentoHeater.disable()");
	}
}
