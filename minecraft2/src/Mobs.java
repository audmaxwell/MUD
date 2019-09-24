import java.util.ArrayList;

public class Mobs {
	private String name;
	private ArrayList<Room> locations;
	private Room position;
	
	
	public Mobs(String name, ArrayList<Room> locations, Room position) {
		this.name = name;
		this.locations = locations;
		this.position = position;
		
	}

}
