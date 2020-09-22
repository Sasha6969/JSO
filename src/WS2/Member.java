package WS2;

public class Member {

    private int UID;
    private String PN;
    private String name;

	public int getUID() {
		return UID;
	}

	public void setUID(int UID) {
		this.UID = UID;
	}

	public String getPN() {
		return PN;
	}

	public void setPN(String PN) {
		this.PN = PN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Member(String name, int UID, String PN) {
        this.UID = UID;
        this.PN = PN;
        this.name = name;
    }


}
