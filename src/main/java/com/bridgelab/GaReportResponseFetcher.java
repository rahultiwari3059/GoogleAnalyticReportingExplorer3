package com.bridgelab;

import java.util.ArrayList;
import java.util.List;

import com.bridgelab.model.GaReportInputModel;
import com.google.api.services.analyticsreporting.v4.AnalyticsReporting;
import com.google.api.services.analyticsreporting.v4.model.GetReportsResponse;

public class GaReportResponseFetcher {
	InitializeAnalyticsReporting initializeAnalyticsReportingObject = new InitializeAnalyticsReporting();
	ResponseReader responseReaderObject= new ResponseReader();
	GaReportInputModel gaReportInputModelObject= new GaReportInputModel();
	ResponseAssigning  responseAssigningObject = new ResponseAssigning();
	GaReportInputInfo gaReportInputInfoObject = new GaReportInputInfo();
	 String mGaID=gaReportInputModelObject.getmGaID();
	 String mGaDiscription=gaReportInputModelObject.getmGaDiscription();
	 ArrayList <String> mMetricArraList =gaReportInputModelObject.getmMetricArraList();
	 ArrayList <String> mDimensionArraList=gaReportInputModelObject.getmDimensionArraList() ;
	 ArrayList <String> mDimensionFilterArraList=gaReportInputModelObject.getmDimensionFilterArraList();
	 
	 public void getResponse(GaReportInputModel gaReportInputModel)
	 {
		 try {
				// calling initializeAnalyticsReporting method of InitializeAnalyticsReporting class to initialize all credential
				
				AnalyticsReporting service = initializeAnalyticsReportingObject.initializeAnalyticsReporting();
				// calling getReport method to get response
				GetReportsResponse response = initializeAnalyticsReportingObject.getReport(service,gaReportInputModel);
				// printing the response
				System.out.println(response);
				// assigning response into variable responsejson of
				// GetReportsResponse type
				GetReportsResponse responsejson = response;

				// calling csvFileCreator to create CSv file by passing
				// response and id and dimension
				responseReaderObject.responseReader(responsejson.toString());
				//to assign value  
				responseAssigningObject.responseAssigning();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	
	 }
}
