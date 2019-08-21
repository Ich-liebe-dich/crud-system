package org.test.entity;

import org.test.constant.Constant;

public class PageModel {
	
	/*总记录数*/
	private int recordCount; 
	
	/*页面索引*/
	private int pageIndex ; 
	
	/*每页默认4条数据*/
	private int pageSize = Constant.PAGE_DEFAULT_SIZE = 4;
	
	/*总页数*/
	private int totalSize; 

	public int getRecordCount() {
		//记录数不能小于0
		this.recordCount = this.recordCount <= 0 ? 0:this.recordCount;
		return recordCount;
	}
	
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	
	public int getPageIndex() {
		//页数最小值为1
		this.pageIndex = this.pageIndex <= 0?1:this.pageIndex;
		//页数不能大于最大页数
		this.pageIndex = this.pageIndex>=this.getTotalSize()?this.getTotalSize():this.pageIndex;
		return pageIndex;
		
	}
	
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	public int getPageSize() {
		this.pageSize = this.pageSize <= Constant.PAGE_DEFAULT_SIZE?Constant.PAGE_DEFAULT_SIZE:this.pageSize;
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getTotalSize() {
		if(this.getRecordCount() <=0){
			totalSize = 0 ;
		}else{
			totalSize = (this.getRecordCount() -1)/this.getPageSize() + 1;
		}
		return totalSize;
	}
	
	
	public int getFirstLimitParam(){
		if((this.getPageIndex()-1)*this.getPageSize()<=0) {
			return 0;
		}
		return (this.getPageIndex()-1)*this.getPageSize() ;
	}
	
}
