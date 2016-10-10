package kosta.model;

public class BoardListModel {	
	private int totalPage;
	private int startPage;
	private int endPage;
	private int currentPage;
	private boolean needBefore;
	private boolean needAfter;
	
	public BoardListModel(){}
	
	public BoardListModel(int totalPage, int startPage, int endPage,
			int currentPage, boolean needBefore, boolean needAfter) {
		super();
		this.totalPage = totalPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.currentPage = currentPage;
		this.needBefore = needBefore;
		this.needAfter = needAfter;
	}




	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public boolean isNeedBefore() {
		return needBefore;
	}

	public void setNeedBefore(boolean needBefore) {
		this.needBefore = needBefore;
	}

	public boolean isNeedAfter() {
		return needAfter;
	}

	public void setNeedAfter(boolean needAfter) {
		this.needAfter = needAfter;
	}
	
}
