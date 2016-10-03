package com.bridgelabz.responseFetcher;

import java.util.ArrayList;
import java.util.List;

import com.bridgelab.model.GaReportInputModel;
import com.bridgelab.model.ResponseAssigningModel;
import com.bridgelab.model.ResponseModel;
import com.bridgelabz.csvfileCreator.DirectCsvFileCreator;
import com.bridgelabz.inputReader.GaReportInputInfo;
import com.bridgelabz.responseReader.ResponseAssigning;
import com.bridgelabz.responseReader.ResponseAssigningConstructor;
import com.bridgelabz.responseReader.ResponseReader;
import com.bridgelabz.responseReader.ResponseReaderConstructor;
import com.google.api.services.analyticsreporting.v4.AnalyticsReporting;
import com.google.api.services.analyticsreporting.v4.model.GetReportsResponse;

public class GaReportResponseFetcher {
	InitializeAnalyticsReporting initializeAnalyticsReportingObject = new InitializeAnalyticsReporting();
	ResponseReader responseReaderObject= new ResponseReader();
	GaReportInputModel gaReportInputModelObject= new GaReportInputModel();
	ResponseAssigning  responseAssigningObject = new ResponseAssigning();
	
	DirectCsvFileCreator directCsvFileCreatorObject = new DirectCsvFileCreator();
	//GaReportInputInfo gaReportInputInfoObject = new GaReportInputInfo();
	 String mGaID=gaReportInputModelObject.getmGaID();
	 String mGaDiscription=gaReportInputModelObject.getmGaDiscription();
	 ArrayList <String> mMetricArraList =gaReportInputModelObject.getmMetricArraList();
	 ArrayList <String> mDimensionArraList=gaReportInputModelObject.getmDimensionArraList() ;
	 ArrayList <String> mDimensionFilterArraList=gaReportInputModelObject.getmDimensionFilterArraList();
	 
	 public ArrayList<ResponseReaderConstructor> getResponse(GaReportInputInfo gaReportInputInfo)
	 {
		 ArrayList<ResponseReaderConstructor> responseReaderConstructorArrayList= new ArrayList<ResponseReaderConstructor>();
				// calling initializeAnalyticsReporting method of InitializeAnalyticsReporting class to initialize all credential
				try
				{
				AnalyticsReporting service = initializeAnalyticsReportingObject.initializeAnalyticsReporting();
				// calling getReport method to get response
				GetReportsResponse response = initializeAnalyticsReportingObject.getReport(service,gaReportInputInfo);
				// printing the response
				System.out.println(response);
				//gaReportInputInfo;responseAssigningModelObject,
				// assigning response into variable responsejson of
				// GetReportsResponse type
				GetReportsResponse responsejson = response;
				// reading response and placing it to responseReaderConstructorArrayList
				responseReaderConstructorArrayList=responseReaderObject.responseReader(responsejson.toString());
				}
				catch(Exception e)
				{
					e.printStackTrace();
					
				}
			
	return responseReaderConstructorArrayList;
	 }
}
