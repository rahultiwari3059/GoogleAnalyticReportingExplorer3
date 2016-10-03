package com.bridgelabz.responseReader;

import java.util.ArrayList;

public class ResponseReaderConstructor {
	public int metricResponseArraySize = 0;
	public int dimensionResponseArraySize = 0;
	public int rowResponseArraySize=0;
	// // creating arraylist of metric dimension and dimensionFilter
	public ArrayList<String> metricResposeArrayList = new ArrayList<String>();
	public ArrayList<String> dimensionResponseArraList = new ArrayList<String>();
	
	
	public ResponseReaderConstructor(int metricArraySize,int dimensionArraySize,int rowResponseArraySize,ArrayList<String> metricArraList,ArrayList<String> dimensionArraList)
	{
		this.metricResponseArraySize = metricArraySize;
		this.dimensionResponseArraySize = dimensionArraySize;
		this.rowResponseArraySize=rowResponseArraySize;
		this.metricResposeArrayList = metricArraList;
		this.dimensionResponseArraList = dimensionArraList;
		
		
	}
}
