package com.bridgelab;

import java.util.Scanner;

import com.bridgelab.model.GaReportInputModel;

public class GoogleAnalyticReporting {


	public static void main(String[] args) {
		GaReportInputModel gaReportInputModel = new GaReportInputModel();

		// creating object of InputJsonReader
		System.out.println("enter the Json file path");
		Scanner sc = new Scanner(System.in);
		// Taking path of input JSON
		String jsonfilepath = sc.next();
		GaReportResponseFetcher gaReportResponseFetcherObject = new GaReportResponseFetcher();
		
		GaReportInputInfo gaReportInputInfoObject = new GaReportInputInfo();
		gaReportInputInfoObject.readInputJsonFile(jsonfilepath,gaReportInputModel);
		// calling gaReportSummary method of GaReportSummaryReader class and
		// passing JSON path location
		gaReportResponseFetcherObject.getResponse(gaReportInputModel);
	}

}