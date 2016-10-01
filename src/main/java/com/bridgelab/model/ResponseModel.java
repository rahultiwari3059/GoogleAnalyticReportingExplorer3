package com.bridgelab.model;

import java.util.ArrayList;

public class ResponseModel {
private int mrowArraySize;
private int mMetricArraySize;
private int mdimensionArraySize;
private ArrayList<String> mDimensionResponseArrayList;
private ArrayList<String> mMetricResponseArrayList;

public void setRowArraySize(int rowArraySize) {
	this.mrowArraySize = rowArraySize;
}
public void setMetricArraySize(int metricArraySize) {
	this.mMetricArraySize = metricArraySize;
}
public void setDimensionArraySize(int dimensionArraySize) {
	this.mdimensionArraySize = dimensionArraySize;
}
public void setMetricResponse(ArrayList<String> metricResponse) {
	this.mMetricResponseArrayList = metricResponse;
}
public void setDimensionResponse(ArrayList<String> dimensionResponse) {
	this.mDimensionResponseArrayList = dimensionResponse;
}
public int getDimensionArraySize() {
	return mdimensionArraySize;
}
public int getMetricArraySize() {
	return mMetricArraySize;
}

public int getRowArraySize() {
	return mrowArraySize;
}

public ArrayList<String> getMetricResponse() {
	return mMetricResponseArrayList;
}

public ArrayList<String> getDimensionResponse() {
	return mDimensionResponseArrayList;
}


}
