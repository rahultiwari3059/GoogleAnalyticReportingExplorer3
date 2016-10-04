package com.bridgelabz.GooglleAnalyticReportingExplorer3;

import java.util.ArrayList;
import java.util.Scanner;

import com.bridgelab.model.GaReportInputModel;
import com.bridgelab.model.ResponseElementModel;
import com.bridgelab.model.ResponseModel;
import com.bridgelabz.csvfileCreator.AppOpenCsvCreator;
import com.bridgelabz.csvfileCreator.DirectCsvFileCreator;
import com.bridgelabz.inputReader.GaReprtInfoArrayList;
import com.bridgelabz.responseFetcher.GaReportResponseFetcher;

public class GoogleAnalyticReporting {

	public static void main(String[] args) {

		
	
		AppOpenCsvCreator appOpenCsvCreatorObject=new AppOpenCsvCreator();
		try
		{
			
		// creating object of GaReportResponseFetcher
		GaReportResponseFetcher gaReportResponseFetcherObject = new GaReportResponseFetcher();

		DirectCsvFileCreator directCsvFileCreatorObject = new DirectCsvFileCreator();
		System.out.println("enter the Json file path");
		Scanner sc = new Scanner(System.in);
		// taking json filepath
		String jsonfilepath = sc.next();
		
		// creating object GaReprtInfoArrayList
		GaReprtInfoArrayList GaReprtInfoArrayListObject = new GaReprtInfoArrayList();
		
		// passing JSONpath and getting ArrayList of GaInputInfo
		ArrayList<GaReportInputModel> gaReportInputInfoArrayList = GaReprtInfoArrayListObject
				.readInputJsonFile(jsonfilepath);
		
	
		
		
		for (int i = 0; i < gaReportInputInfoArrayList.size(); i++) {
			//  making ArrayList of response after passing jsoninputinfo  
			ArrayList<ResponseModel> responseModelArrayList=gaReportResponseFetcherObject.getResponse(gaReportInputInfoArrayList.get(i));
	
			// creating csvfile by passing inputinfo and response
			ArrayList<ResponseElementModel> responseElementModelArrayList=directCsvFileCreatorObject.directCsvFileCreator(gaReportInputInfoArrayList.get(i),responseModelArrayList.get(i));
			appOpenCsvCreatorObject.appOpenCsvCreator(responseElementModelArrayList.get(i),gaReportInputInfoArrayList.get(i));
		}
		}
		catch(Exception e)
		{
			
		e.printStackTrace();
			
		}

	}

}