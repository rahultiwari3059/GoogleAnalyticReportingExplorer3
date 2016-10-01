package com.bridgelab.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GaReportModel {
	private ArrayList dimension;
	private ArrayList metric;
	private ArrayList dimensionfilter1;
	private String GAID;
	private String GaDiscription;
	private String date;
	private String AndroidId;

	// setter and getter methods
	public void setDimensionfilter1(ArrayList dimensionfilter1) {
		this.dimensionfilter1 = dimensionfilter1;
	}
	public void setAndroidId(String androidId2) {
		AndroidId = androidId2;
	}
	public void setGAID(String gAID) {
		GAID = gAID;
	}

	public void setGaDiscription(String gaDiscription) {
		GaDiscription = gaDiscription;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public void setDimension(ArrayList dimension) {
		this.dimension = dimension;
	}

	public void setMetric(ArrayList metric) {
		this.metric = metric;
	}
	public String getDate() {
		return date;
	}
	public String getGAID() {
		return GAID;
	}

	public String getGaDiscription() {
		return GaDiscription;
	}

	


	
	public ArrayList getDimension() {
		return dimension;
	}

	

	public ArrayList getMetric() {
		return metric;
	}


	public ArrayList getDimensionfilter1() {
		return dimensionfilter1;
	}

	
	public String getAndroidId() {
		return AndroidId;
	}

}
