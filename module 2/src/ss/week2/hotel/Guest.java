package ss.week2.hotel;

/**
 * Hotel Guests that might have a room.
 * @author Bart Verkuil & Justin Altena
 * @version 1.0
 */

public class Guest {
	
	public String toString(){
		return "Name of the guest.:" + this.name;
               
    }
	// ------------------ Instance variables ----------------
	private Room room;
	private String name;

	// ------------------ Constructor ------------------------
	
	/**
	* Creates a <code>Guest</code> with the given name without a room.
	* @param name; name of the new Guest
	*/
	public Guest(String name){
		this.room = null;
		this.name = name;
		
	}
	
	// --------------------- Queries ----------------------
	
	/**
	* Returns the name of the Guest
	*/
	public String getName(){
		return name;
		
	}
	
	/**
	* Returns the Room of the Guest
	*/
	public Room getRoom(){
		return room;
		
	}
	
	// ------------------ Commands --------------------------
	/**
	* Assigns a room to a Guest. The room has to be empty
	*  and the guest can't have other rooms at the same time.
	* @param r
	* @return true when action succeeds, otherwise it returns false
	*/
	public boolean checkin(Room r){
		if(room == null && r.getGuest() == null){
			this.room = r;
			r.setGuest(this);
			return true;
		}else {
			return false;
		}
	}
	
	/**
	* Removes the room from the Guests. It sets the room to 0.
	* @return True when room is successfully removed. If there is
	* no room assigned to the Guest return false.
	*/
	public boolean checkout(){
		if(room == null){
			return false;
		} else{
		room.setGuest(null);
		this.room = null;
		return true;
		}
		
	}
		
}