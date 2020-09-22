package WS2;

public class Boat {
	
	private int boatLength;
	private String boatType;
	
	
	public int getBoatLength() {
		return boatLength;
	}
	public void setBoatLength(int boatLength) {
		this.boatLength = boatLength;
	}
	public String getBoatType() {
		return boatType;
	}
	public void setBoatType(String boatType) {
		this.boatType = boatType;
	}
	
	public Boat() {}
	
	public Boat(int boatLength, String boatType) {
		boatLength = this.boatLength;
		boatType = this.boatType;
	}
}
