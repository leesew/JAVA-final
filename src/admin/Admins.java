package admin;

public class Admins {
	private int aId;
	private String aName;
	private String aPassword;
	private String aDept;
	private String aTel;
	
	
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public String getaPassword() {
		return aPassword;
	}
	public void setaPassword(String aPassword) {
		this.aPassword = aPassword;
	}
	public String getaDept() {
		return aDept;
	}
	public void setaDept(String aDept) {
		this.aDept = aDept;
	}
	public String getaTel() {
		return aTel;
	}
	public void setaTel(String aTel) {
		this.aTel = aTel;
	}
	
	@Override
	public String toString() {
		return "Admins [aId=" + aId + ", aName=" + aName + ", aPassword=" + aPassword + ", aDept=" + aDept + ", aTel="
				+ aTel + "]";
	}
}
