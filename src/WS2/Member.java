package WS2;

public class Member {
	
	private int UID;
	private long PN;
	private String name;
	
	public int getUID() {
		return UID;
	}
	public void setUID(int uID) {
		UID = uID;
	}
	public long getPN() {
		return PN;
	}
	public void setPN(long pN) {
		PN = pN;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Member(){}
	
	public Member(int UID, long PN, String name){
		UID = this.UID;
		PN = this.PN;
		name = this.name;
	}
	

}
