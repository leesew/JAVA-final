package shoppingMall;

public class ShoppingCart {
	private String cId;
	private String pId;
	private String pName;
	private String pImgName;
	private String description;
	private String unitPrice; // 가격
	private String quantity; // 수량
	private String sum; // 합계
	private String total;
	
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpImgName() {
		return pImgName;
	}
	public void setpImgName(String pImgName) {
		this.pImgName = pImgName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "ShoppingCart [cId=" + cId + ", pId=" + pId + ", pName=" + pName + ", pImgName=" + pImgName
				+ ", description=" + description + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", sum="
				+ sum + ", total=" + total + "]";
	} // 총합
	
	
}

	


