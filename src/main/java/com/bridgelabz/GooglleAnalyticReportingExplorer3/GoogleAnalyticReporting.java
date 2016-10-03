package com.bridgelabz.GooglleAnalyticReportingExplorer3;

import java.util.ArrayList;
import java.util.Scanner;

import com.bridgelabz.csvfileCreator.DirectCsvFileCreator;
import com.bridgelabz.inputReader.GaReportInputInfo;
import com.bridgelabz.inputReader.GaReprtInfoArrayList;
import com.bridgelabz.responseFetcher.GaReportResponseFetcher;
import com.bridgelabz.responseReader.ResponseReaderConstructor;

public class GoogleAnalyticReporting {

	public static void main(String[] args) {

	
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
		ArrayList<GaReportInputInfo> gaReportInputInfoArrayList = GaReprtInfoArrayListObject
				.readInputJsonFile(jsonfilepath);

		for (int i = 0; i < gaReportInputInfoArrayList.size(); i++) {
			//  making ArrayList of response after passing jsoninputinfo  
			ArrayList<ResponseReaderConstructor> responseReaderConstructorArrayList=gaReportResponseFetcherObject.getResponse(gaReportInputInfoArrayList.get(i));
	
			// creating csvfile by passing inputinfo and response
			directCsvFileCreatorObject.directCsvFileCreator(gaReportInputInfoArrayList.get(i),responseReaderConstructorArrayList.get(i));

				
			
		}

	}

}