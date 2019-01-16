package shoppingMall;

public class Cart {
	private int cId;
	private String pId;
	private String pName;
	private String imgName;
	private String description;
	private int unitPrice;
	private int quantity;
	private int sum;
	private int total;
	
	public Cart() {}
	
	public Cart(String pId, String pName, int unitPrice, int quantity, int sum, String imgName, String description) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.imgName = imgName;
		this.description = description;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.sum = sum;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
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

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	
}
