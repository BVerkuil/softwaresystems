package ss.week2;

public class ThreeWayLampNewTest {
	
	public static void main(String[] args) {
		//Er wordt een nieuwe lamp gemaakt met setting 0
		ThreeWayLampNew lamp1 = new ThreeWayLampNew();
		//De setting wordt geprint
		System.out.println(lamp1.getSetting());
		//De switchSetting method wordt uitgevoerd
		lamp1.switchSetting();
		//De setting van lamp1 wordt na het uitvoeren nog een keer geprint
		System.out.println(lamp1.getSetting());
	}
}
