package dto;

public class BoardDto {
	private int bNo;
	private String bTitle;
	private String bWriter;
	private String bContent;
	private String bDate;
	private int bHits;
	private String bFileName;
	private String bState;
	
	public BoardDto() {}

	public BoardDto(int bNo, String bTitle, String bWriter, String bContent, String bDate, int bHits, String bFileName,
			String bState) {
		super();
		this.bNo = bNo;
		this.bTitle = bTitle;
		this.bWriter = bWriter;
		this.bContent = bContent;
		this.bDate = bDate;
		this.bHits = bHits;
		this.bFileName = bFileName;
		this.bState = bState;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbWriter() {
		return bWriter;
	}

	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public String getbDate() {
		return bDate;
	}

	public void setbDate(String bDate) {
		this.bDate = bDate;
	}

	public int getbHits() {
		return bHits;
	}

	public void setbHits(int bHits) {
		this.bHits = bHits;
	}

	public String getbFileName() {
		return bFileName;
	}

	public void setbFileName(String bFileName) {
		this.bFileName = bFileName;
	}

	public String getbState() {
		return bState;
	}

	public void setbState(String bState) {
		this.bState = bState;
	}

}
