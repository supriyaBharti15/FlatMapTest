package com.example.flatmaptest.model;

import com.google.gson.annotations.SerializedName;

public class SingleUserResponse{

	@SerializedName("ad")
	private Ad ad;

	@SerializedName("data")
	private Data data;

	public void setAd(Ad ad){
		this.ad = ad;
	}

	public Ad getAd(){
		return ad;
	}

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"SingleUserResponse{" + 
			"ad = '" + ad + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}