package t7ex_kiosk;

public class KioshVO {
	private String userID;
	private String name;
	private String address;
	private String product;
	private int points;
	private int count;
	private String createdAT;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getCreatedAT() {
		return createdAT;
	}
	public void setCreatedAT(String createdAT) {
		this.createdAT = createdAT;
	}
	@Override
	public String toString() {
		return "KioshVO [userID=" + userID + ", name=" + name + ", address=" + address + ", product=" + product
				+ ", points=" + points + ", count=" + count + ", createdAT=" + createdAT + "]";
	}
	
	
	
	
	
	
}
