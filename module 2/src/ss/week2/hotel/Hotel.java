package ss.week2.hotel;

public class Hotel {
	
	private String hotelnaam;
	private Password password;
	private Room room1;
	private Room room2;
	
	
	//@ requires hotelnaam != null;
	//@ ensures this.hotelnaam = hotelnaam;
	//@ ensures password.equals(Password.INITIAL);
	//@ ensures room1 != null;
	//@ ensures room2 != null;
	public Hotel(String hotelnaam) {
		assert hotelnaam != null;
		room1 = new Room(1);
		room2 = new Room(2);
		password = new Password();
		this.hotelnaam = hotelnaam;
	}
	
	//@ ensures gast != null;
	//@ ensures room1.getGuest()==null ==> room1.getGuest.getName.equals(name);
	//@ ensures room2.getGuest()==null ==> room2.getGuest.getName.equals(name);
	public Room checkIn(String password, String name) {
		Room booking = null;
			
		if (this.password.testWord(password)  //check pwd
				&& !name.equals(getGuestNameRoom1())
				&& !name.equals(getGuestNameRoom2())) { 
			
			if(room1.getGuest()==null) {
				Guest gast = new Guest(name);
				gast.checkin(room1);
				booking = room1;
			} else if(room2.getGuest()==null) {
				Guest gast = new Guest(name);
				gast.checkin(room2);
				booking = room2;
			}
		} 
		
		return booking;
		
		
	}
	
	//@ ensures name.equals(getGuestNameRoom1()) ==> room1.getGuest() == null;
	//@ ensures name.equals(getGuestNameRoom1()) ==> !room1.getSafe().isActive();
	//@ ensures name.equals(getGuestNameRoom2()) ==> room2.getGuest() == null;
	//@ ensures name.equals(getGuestNameRoom2()) ==> !room2.getSafe().isActive();
	public void checkOut(String name) {
		if (name.equals(getGuestNameRoom1())) {
			room1.getGuest().checkout();
			room1.getSafe().deactivate();
		}
		else if (name.equals(getGuestNameRoom2())) {
			room2.getGuest().checkout();
			room2.getSafe().deactivate();
		}
	}
	

	/* pure */public Room getFreeRoom() {
		Room leeg = null;
		if (room1.getGuest() == null) {
			leeg = room1;
		}
		else if (room2.getGuest() == null) {
			leeg = room2;
		}
		
		return leeg;		
	}
	

	/* pure */public Room getRoom(String name){
		Room kamer = null;
				
		if (name.equals(getGuestNameRoom1())) {
			kamer = room1;
		}
		else if (name.equals(getGuestNameRoom2())) {
			kamer = room2;
		}
		return kamer;		
	}
	
	//@ ensures password == this.password;
	/* pure */public Password getPassword() {
		return password;
	}
	
	//@ ensures room1.getGuest()!=null ==> name1 == room1.getGuest().getName();
	/* pure */public String getGuestNameRoom1() {
		String name1 = null;
		if(room1.getGuest()!=null) {
			name1 = room1.getGuest().getName();
		} 
		return name1;
	}	
	
	//@ ensures room2.getGuest()!=null ==> name2 == room2.getGuest().getName();
	public String getGuestNameRoom2() {
		String name2 = null;
		if(room2.getGuest()!=null) {
			name2 = room2.getGuest().getName();
		} 
		return name2;
	}	
	
	public String toString() {
		return "Status hotel" +
				hotelnaam +
				": room" + room1.getNumber() +
				":" +getGuestNameRoom1() +
				", kluis open?:" +room1.getSafe().isOpen() +
				": room" + room2.getNumber() +
				":" +getGuestNameRoom2() +
				", kluis open?:" +room2.getSafe().isOpen();
				
				
				
	}
}
		
