package org.cjh.javabasic.syntax.foreach;

public class Page {

	private int pageNo;
	private String content;
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Page {pageNo=" + pageNo + ", content=" + content + "}";
	}
}
