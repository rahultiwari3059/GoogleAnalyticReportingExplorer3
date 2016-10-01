package com.bridgelab.model;

public class ResponseAssigningModel {
private String mDate;
private String mAndroidId;
private String mConnectionType;
private String mTotalEvents;
private String mSessions;
private String mScreenViews;
private String mExit;
private String mExitRate;

public void setmSessions(String mSessions) {
	this.mSessions = mSessions;
}
public String getmSessions() {
	return mSessions;
}
public void setmExit(String mExit) {
	this.mExit = mExit;
}

public void setmExitRate(String mExitRate) {
	this.mExitRate = mExitRate;
}
public void setmScreenViews(String mScreenViews) {
	this.mScreenViews = mScreenViews;
}
public void setmTotalEvents(String mTotalEvents) {
	this.mTotalEvents = mTotalEvents;
}
public void setmConnectionType(String mConnectionType) {
	this.mConnectionType = mConnectionType;
}
public void setmAndroidId(String mAndroidId) {
	this.mAndroidId = mAndroidId;
}
public void setmDate(String mDate) {
	this.mDate = mDate;
}
public String getmScreenViews() {
	return mScreenViews;
}


public String getmExit() {
	return mExit;
}

public String getmExitRate() {
	return mExitRate;
}

public String getmTotalEvents() {
	return mTotalEvents;
}



public String getmConnectionType() {
	return mConnectionType;
}



public String getmAndroidId() 
{
	return mAndroidId;
}



public String getmDate() {
	return mDate;
}


}
