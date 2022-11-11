package dto;

public class ProductDto {
	private String prcode;
	private String prbrand;
	private String prname;
	private int prprice;
	private String primg;
	
	public ProductDto() {}
	
	public ProductDto(String prcode, String prbrand, String prname, int prprice, String primg) {
		super();
		this.prcode = prcode;
		this.prbrand = prbrand;
		this.prname = prname;
		this.prprice = prprice;
		this.primg = primg;
	}

	public String getPrcode() {
		return prcode;
	}

	public void setPrcode(String prcode) {
		this.prcode = prcode;
	}

	public String getPrbrand() {
		return prbrand;
	}

	public void setPrbrand(String prbrand) {
		this.prbrand = prbrand;
	}

	public String getPrname() {
		return prname;
	}

	public void setPrname(String prname) {
		this.prname = prname;
	}

	public int getPrprice() {
		return prprice;
	}

	public void setPrprice(int prprice) {
		this.prprice = prprice;
	}

	public String getPrimg() {
		return primg;
	}

	public void setPrimg(String primg) {
		this.primg = primg;
	}

	@Override
	public String toString() {
		return "ProductDto [prcode=" + prcode + ", prbrand=" + prbrand + ", prname=" + prname + ", prprice=" + prprice
				+ ", primg=" + primg + "]";
	}
	
	
}
