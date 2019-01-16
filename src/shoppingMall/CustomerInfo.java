package shoppingMall;

public class CustomerInfo {
	
	private String oDate;
	private String oCustomerId;
	private String cName;
	private String oId;
	private String oPrice;
	
	public String getoDate() {
		return oDate;
	}
	public void setoDate(String oDate) {
		this.oDate = oDate;
	}
	public String getoCustomerId() {
		return oCustomerId;
	}
	public void setoCustomerId(String oCustomerId) {
		this.oCustomerId = oCustomerId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getoId() {
		return oId;
	}
	public void setoId(String oId) {
		this.oId = oId;
	}
	public String getoPrice() {
		return oPrice;
	}
	public void setoPrice(String oPrice) {
		this.oPrice = oPrice;
	}
	@Override
	public String toString() {
		return "CustomerInfo [oDate=" + oDate + ", oCustomerId=" + oCustomerId + ", cName=" + cName + ", oId=" + oId
				+ ", oPrice=" + oPrice + "]";
	}
	
	

}
