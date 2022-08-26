package day17;


public class ProductInfo {
	private String ProdName;
	private String prodType;
	private int prodNum;
	private int prodVol;
	private int prodPrice;
	
	public int getProdNum() {
		return prodNum;
	}
	public void setProdNum(int prodNum) {
		this.prodNum = prodNum;
	}
	public String getProdName() {
		return ProdName;
	}
	public void setProdName(String prodName) {
		this.ProdName = prodName;
	}
	public int getProdVol() {
		return prodVol;
	}
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		if(prodPrice <= 0)
			prodPrice = 0;
		this.prodPrice = prodPrice;
	}
	public void setProdVol(int prodVol) {
		if(prodVol <= 0)
			prodVol = 0;
		this.prodVol = prodVol;
	}
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	@Override
	public String toString() {
		return "[상품번호]" + prodNum + " [상품이름]" + ProdName + " [상품수량]" + prodVol + " [상품종류]"
				+ prodType + " [상품가격]" + prodPrice;
	}
	
	
}
