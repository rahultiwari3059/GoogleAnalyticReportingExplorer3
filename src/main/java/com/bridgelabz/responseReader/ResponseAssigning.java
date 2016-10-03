package com.bridgelabz.responseReader;

import java.util.ArrayList;

import com.bridgelab.model.GaReportInputModel;
import com.bridgelab.model.ResponseAssigningModel;
import com.bridgelab.model.ResponseModel;

public class ResponseAssigning {
	ResponseModel responseModelObject = new ResponseModel();
	GaReportInputModel gaReportInputModelObject = new GaReportInputModel();
	ResponseAssigningModel responseAssigningModelObject = new ResponseAssigningModel();
	ArrayList <ResponseAssigningConstructor> responseAssigningConstructorArrayList= new ArrayList<ResponseAssigningConstructor>();
	ArrayList<String> metricArrayResponseList = responseModelObject.getMetricResponse();
	ArrayList<String> dimensionArrayResponseList = responseModelObject.getDimensionResponse();

	public ArrayList<ResponseAssigningConstructor> responseAssigning(ResponseReaderConstructor responseReaderConstructor) {
		int k = 0, p = 0, c = 0;
		//	// if response Json having 3 dimensionvalue and 1 metricvalue 
		
		if (responseReaderConstructor.dimensionResponseArraySize == 3) {
			for (int i = 0; i < responseReaderConstructor.rowResponseArraySize; i++) {
				String mDate=null;
				 String mAndroidId=null;
				 String mConnectionType=null;;
				 String mTotalEvents=null;
				 String mSessions=null;
				 String mScreenViews=null;
				 String mExit=null;
				 String mExitRate=null;
				
				for (int j = 0; j < responseReaderConstructor.dimensionResponseArraySize; j++) {
					if (k % 3 == 0) {
						mDate=responseReaderConstructor.dimensionResponseArraList.get(k);

					}
					if (k % 3 == 1) {
						mAndroidId=responseReaderConstructor.dimensionResponseArraList.get(k);
					}
					if (k % 3 == 2) {
						mConnectionType=responseReaderConstructor.dimensionResponseArraList.get(k);
					}
					k++;
				}
				for (int m = 0; m < responseReaderConstructor.metricResponseArraySize; m++) {

					mTotalEvents=responseReaderConstructor.metricResposeArrayList.get(p);

					p++;
				}
				responseAssigningConstructorArrayList.add(new ResponseAssigningConstructor( mDate, mAndroidId,  mConnectionType, mTotalEvents, mSessions, mScreenViews, mExit, mExitRate));

			}

		}
		// if response Json having 4 dimensionvalue and 2 metricvalue 
		else {
			if (responseReaderConstructor.metricResponseArraySize == 4 && responseReaderConstructor.dimensionResponseArraySize == 2) {
				
				for (int i = 0; i < responseReaderConstructor.rowResponseArraySize; i++) {
					String mDate=null;
					 String mAndroidId=null;
					 String mConnectionType=null;;
					 String mTotalEvents=null;
					 String mSessions=null;
					 String mScreenViews=null;
					 String mExit=null;
					 String mExitRate=null;
					
					for (int j = 0; j < responseReaderConstructor.dimensionResponseArraySize; j++) {
						if (k % 2 == 0) {
							mDate=responseReaderConstructor.dimensionResponseArraList.get(k);

						}
						if (k % 2 == 1) {
							mAndroidId=responseReaderConstructor.dimensionResponseArraList.get(k);
						}
						k++;
					}

					for (int m = 0; m < responseReaderConstructor.metricResponseArraySize; m++) {
						if (p % 4 == 0) {
							mSessions=responseReaderConstructor.metricResposeArrayList.get(p);

						}
						if (p % 4 == 1) {
							mScreenViews=responseReaderConstructor.metricResposeArrayList.get(p);
							

						}
						if (p % 4 == 2) {
							mExit=responseReaderConstructor.metricResposeArrayList.get(p);

						}
						if (p % 4 == 3) {
							mExitRate=responseReaderConstructor.metricResposeArrayList.get(p);

						}
						p++;
					}
					
					responseAssigningConstructorArrayList.add(new ResponseAssigningConstructor( mDate, mAndroidId,  mConnectionType, mTotalEvents, mSessions, mScreenViews, mExit, mExitRate));

				}

			} 
			// if response Json having 2 dimensionvalue and 1 metricvalue 
			else {
				if (responseReaderConstructor.dimensionResponseArraySize == 2) {
					for (int i = 0; i < responseReaderConstructor.rowResponseArraySize; i++) {
						String mDate=null;
						 String mAndroidId=null;
						 String mConnectionType=null;;
						 String mTotalEvents=null;
						 String mSessions=null;
						 String mScreenViews=null;
						 String mExit=null;
						 String mExitRate=null;
						for (int j = 0; j < responseReaderConstructor.dimensionResponseArraySize; j++) {
							if (k % 2 == 0) {
								mDate=responseReaderConstructor.dimensionResponseArraList.get(k);

							}
							if (k % 2 == 1) {
								mAndroidId=responseReaderConstructor.dimensionResponseArraList.get(k);
							}
							k++;
						}
						for (int m = 0; m < responseReaderConstructor.metricResponseArraySize; m++) {

							mTotalEvents=responseReaderConstructor.metricResposeArrayList.get(p);

							p++;
						}
						responseAssigningConstructorArrayList.add(new ResponseAssigningConstructor( mDate, mAndroidId,  mConnectionType, mTotalEvents, mSessions, mScreenViews, mExit, mExitRate));

					}

				}
			}

		}
		
		return responseAssigningConstructorArrayList;
	}

}
