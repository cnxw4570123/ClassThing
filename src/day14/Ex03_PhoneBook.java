package day14;

public class Ex03_PhoneBook {
	private int number;
	private String name;
	private String tel;
	
	Ex03_PhoneBook(){}
	
	Ex03_PhoneBook(int number, String name,String tel){
		this.number = number;
		this.name = name;
		this.tel = tel;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "[단축번호=" + number + ", 이름=" + name + ", 전화번호=" + tel + "]";
	}

	
}
