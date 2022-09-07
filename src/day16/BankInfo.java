package day16;

public class BankInfo {
	private String accountNumber;
	private String clientName;
	private int balance;
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		if(balance < 0)
			balance = 0;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "[계좌번호=" + accountNumber + "] [고객이름=" + clientName + "] [잔액=" + balance + "]\n";
	}
	
	
}
