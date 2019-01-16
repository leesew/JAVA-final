package shoppingMall;

import java.util.Date;

public class SoldProducts {
	private String sOrderId;
	private String sProductsId;
	private Date oDate;
	private String sQuantity;
	
	public String getsOrderId() {
		return sOrderId;
	}
	public void setsOrderId(String sOrderId) {
		this.sOrderId = sOrderId;
	}
	public String getsProductsId() {
		return sProductsId;
	}
	public void setsProductsId(String sProductsId) {
		this.sProductsId = sProductsId;
	}
	public Date getoDate() {
		return oDate;
	}
	public void setoDate(Date oDate) {
		this.oDate = oDate;
	}
	public String getsQuantity() {
		return sQuantity;
	}
	public void setsQuantity(String sQuantity) {
		this.sQuantity = sQuantity;
	}
	@Override
	public String toString() {
		return "SoldProducts [sOrderId=" + sOrderId + ", sProductsId=" + sProductsId + ", oDate=" + oDate
				+ ", sQuantity=" + sQuantity + "]";
	}
	
	
	
	
	
}
