package com.swt.fordcs.services;

import org.springframework.stereotype.Service;

import com.swt.fordcs.device.FordCSSettingDataX;
import com.swt.fordcs.device.FordCsFSM;
import com.swt.fordcs.device.FordCsFSM.Event;
import com.swt.fordcs.device.FordCsFSM.State;


@Service
public class CsFactorySettingService {
	// create the state machine as singleton!
	private static FordCsFSM fordCsFSM = FordCsFSM.getInstance();
	private FordCSSettingDataX fordCSSettingDataX = new FordCSSettingDataX(true);
	
	public State getState() {
		return fordCsFSM.getState();
	}

	public State transToState(Event event) {
		return fordCsFSM.triggerFMS(event);
	}

	public FordCSSettingDataX getDeviceFactorySettings() {
		return fordCSSettingDataX;
	}

	

}

