package ss.week2;

public class ThreeWayLampNew {

public enum LampSetting {
	    OFF, LOW, MEDIUM, HIGH
	}
	

	private LampSetting setting;
	

	public ThreeWayLampNew() {
		this.setting = LampSetting.OFF;
	}

	public LampSetting getSetting(){
		return setting;
	}

	
	public void setSetting(LampSetting newSetting) {
		this.setting = newSetting;
	}

	public void switchSetting(){
		switch (setting) {
		case OFF:
			this.setting = LampSetting.LOW;
			break;
		case LOW:
			this.setting = LampSetting.MEDIUM;
			break;
		case MEDIUM:
			this.setting = LampSetting.HIGH;
			break;
		case HIGH:
			this.setting = LampSetting.OFF;
			break;
		default:
			this.setting = LampSetting.OFF;
		}
		
	}
	
}
