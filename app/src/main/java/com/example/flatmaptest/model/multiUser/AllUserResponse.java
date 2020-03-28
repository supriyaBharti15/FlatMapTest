package com.example.flatmaptest.model.multiUser;

import java.util.List;

import com.example.flatmaptest.model.Ad;
import com.example.flatmaptest.model.Data;
import com.google.gson.annotations.SerializedName;

public class AllUserResponse{

	@SerializedName("per_page")
	private int perPage;

	@SerializedName("total")
	private int total;

	@SerializedName("ad")
	private Ad ad;

	@SerializedName("data")
	private List<Data> data;

	@SerializedName("page")
	private int page;

	@SerializedName("total_pages")
	private int totalPages;

	public void setPerPage(int perPage){
		this.perPage = perPage;
	}

	public int getPerPage(){
		return perPage;
	}

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setAd(Ad ad){
		this.ad = ad;
	}

	public Ad getAd(){
		return ad;
	}

	public void setData(List<Data> data){
		this.data = data;
	}

	public List<Data> getData(){
		return data;
	}

	public void setPage(int page){
		this.page = page;
	}

	public int getPage(){
		return page;
	}

	public void setTotalPages(int totalPages){
		this.totalPages = totalPages;
	}

	public int getTotalPages(){
		return totalPages;
	}

	@Override
 	public String toString(){
		return 
			"AllUserResponse{" + 
			"per_page = '" + perPage + '\'' + 
			",total = '" + total + '\'' + 
			",ad = '" + ad + '\'' + 
			",data = '" + data + '\'' + 
			",page = '" + page + '\'' + 
			",total_pages = '" + totalPages + '\'' + 
			"}";
		}
}