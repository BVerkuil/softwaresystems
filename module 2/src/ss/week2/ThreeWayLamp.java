package ss.week2;

public class ThreeWayLamp {

	public static final int OFF = 0;
	public static final int LOW = 1;
	public static final int MEDIUM = 2;
	public static final int HIGH = 3;

	//@ invariant getSetting() == OFF || getSetting() == LOW || getSetting() == MEDIUM || getSetting() == HIGH;
	
	private int setting;
	
	//@ requires setting == 0;
	public ThreeWayLamp(int setting) {
		assert setting == 0;
		this.setting = setting;
	}

	/*@pure */public int getSetting(){
		return setting;
	}
	//@ requires newSetting >= 0;
	//@ requires newSetting <= 3;
	public void setSetting(int newSetting) {
		assert newSetting >= 0;
		assert newSetting <= 3;
		this.setting = newSetting;
	}
	//@ ensures getSetting() == \old((getSetting()) + 1) % 4;;
	public void switchSetting(){
		this.setting = (this.setting + 1) % 4;
		
	}
	
}
