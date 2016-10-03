package com.bridgelabz.inputReader;

import java.util.ArrayList;
import com.bridgelab.model.GaReportInputModel;

public class GaReportInputInfo {
	
	// initializing value 
	public String GaId = null;
	public String GaDiscription = null;
	// // creating arraylist of metric dimension and dimensionFilter
	public ArrayList<String> metricArraList = new ArrayList<String>();
	public ArrayList<String> dimensionArraList = new ArrayList<String>();
	public ArrayList<String> dimensionFilterArraList = new ArrayList<String>();
	ArrayList<GaReportInputModel> GaReportInputModelArrayList = new ArrayList<GaReportInputModel>();

	// constructor 
	public GaReportInputInfo(String GaId, String GaDiscription, ArrayList<String> metricArraList,
			ArrayList<String> dimensionArraList, ArrayList<String> dimensionFilterArraList) {
		this.GaId = GaId;
		this.GaDiscription = GaDiscription;
		this.metricArraList = metricArraList;
		this.dimensionArraList = dimensionArraList;
		this.dimensionFilterArraList = dimensionFilterArraList;
	}

}
