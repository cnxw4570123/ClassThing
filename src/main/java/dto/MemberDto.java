package dto;

public class MemberDto {
	private String mid;
	private String mpw;
	private String mname;
	private String mbirth;
	private String maddr;
	private String memail;
	private String mstate;
	
	public MemberDto(){
	}
	
	public MemberDto(String mid, String mpw, String mname, String mbirth, String maddr, String memail, String mstate) {
		super();
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mbirth = mbirth;
		this.maddr = maddr;
		this.memail = memail;
		this.mstate = mstate;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMbirth() {
		return mbirth;
	}
	public void setMbirth(String mbirth) {
		this.mbirth = mbirth;
	}
	public String getMaddr() {
		return maddr;
	}
	public void setMaddr(String maddr) {
		this.maddr = maddr;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMstate() {
		return mstate;
	}
	public void setMstate(String mstate) {
		this.mstate = mstate;
	}
	
	
}
