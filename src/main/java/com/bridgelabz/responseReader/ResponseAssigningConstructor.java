package com.bridgelabz.responseReader;

public class ResponseAssigningConstructor {
	public String mDate=null;
	public String mAndroidId=null;
	public String mConnectionType=null;;
	public String mTotalEvents=null;
	public String mSessions=null;
	public String mScreenViews=null;
	public String mExit=null;
	public String mExitRate=null;
	public ResponseAssigningConstructor(String mDate,String mAndroidId,String mConnectionType,String mTotalEvents,String mSessions,String mScreenViews, String mExit,String mExitRate)
	{
		this.mDate=mDate;
		this.mAndroidId=mAndroidId;
		this.mConnectionType=mConnectionType;
		this.mTotalEvents=mTotalEvents;
		this.mSessions=mSessions;
		this.mScreenViews=mScreenViews;
		this.mExit=mExit;
		this.mExitRate=mExitRate;
	}

}
