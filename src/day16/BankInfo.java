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
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "BankInfo [accountNumber=" + accountNumber + ", clientName=" + clientName + ", balance=" + balance + "]";
	}
	
	
}
