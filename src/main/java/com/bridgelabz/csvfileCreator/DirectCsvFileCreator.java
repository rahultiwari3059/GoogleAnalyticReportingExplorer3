package com.bridgelabz.csvfileCreator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;


import com.bridgelab.model.AppEventDataModel1;
import com.bridgelab.model.GaReportInputModel;
import com.bridgelab.model.ResponseElementModel;
import com.bridgelab.model.ResponseModel;



public class DirectCsvFileCreator {
			
	public ArrayList<ResponseElementModel> directCsvFileCreator(GaReportInputModel gaReportInputModel,
			ResponseModel responseModel) {

		// creating object of ResponseElementModel ArrayList
		ArrayList<ResponseElementModel> responseElementModelArrayList= new ArrayList<ResponseElementModel>();
	
		// creating object of AppEventDataModel1
		ArrayList<AppEventDataModel1> appEventDataModel1ArrayList = new ArrayList<AppEventDataModel1>();
		
		//creating object of AppDataModelCsvCreator
		AppDataModelCsvCreator appDataModelCsvCreatorObject= new AppDataModelCsvCreator();

		// creating HashMap to find number of user on particular day
		HashMap<String, Integer> dateHashMap = new HashMap<String, Integer>();
		// creating HashMap to find out number of unique android id
		HashMap<String, Integer> androidIdHashMap = new HashMap<String, Integer>();
		// creating HashMap for finding out number of number of unique user on
		// particular day
		HashMap<String, String> uniqueUserPerDay = new HashMap<String, String>();

		// initializing value to the count
		int dateHashMapCount = 1;
		int androidIdHashMapCount = 1;

		// creating uniqueAndroidId ArrayList object and unique date and total
		ArrayList<String> uniqueAndroidId = new ArrayList<String>();
		ArrayList<String> Uniquedate = new ArrayList<String>();
		ArrayList<String> total = new ArrayList<String>();

		// assigning the value of particular response
		int metricResponseArraySize = responseModel.getMetricArraySize();
		int dimensionResponseArraySize = responseModel.getDimensionArraySize();
		int rowResponseArraySize = responseModel.getRowArraySize();
		ArrayList<String> metricResposeArrayList = responseModel.getMetricResponse();
		ArrayList<String> dimensionResponseArraList = responseModel.getDimensionResponse();
		try {
			// initializing values
			int dimensionCount = 0, metricCount = 0;
			boolean b1 = false;
			boolean b = false;
			
			// creating csv file for all gaid
			File file1 = new File("/home/bridgeit/Music/allcsv.csv");
			if (!file1.exists()) {
				b1 = true;
			}

			FileWriter filewriterobject1 = new FileWriter(file1.getAbsoluteFile(), true);
			BufferedWriter bufferedwritterobject = new BufferedWriter(filewriterobject1);

			if (b1) {
				file1.createNewFile();
				// appending column names
				bufferedwritterobject.append(
						"gaid^gadiscription^Date^AndroidId^Eventcategory^connectiontype^Totalevents^Sessions^Screenviews^Exit^ExitRate^");
				bufferedwritterobject.newLine();
			}
			// if there is no value in response 
			if (metricResponseArraySize == 0) {
				
				bufferedwritterobject.append(gaReportInputModel.getmGaID());
				bufferedwritterobject.append("^");
				bufferedwritterobject.append(gaReportInputModel.getmGaDiscription());
				bufferedwritterobject.append("^");
				bufferedwritterobject.newLine();
				bufferedwritterobject.close();
			}
			
			//if dimension having 3 value 
			if (dimensionResponseArraySize == 3) {
				
				for (int r = 0; r < rowResponseArraySize; r++) {
					ResponseElementModel responseElementModelObject = new ResponseElementModel();
					responseElementModelObject.setMrowArraySize(rowResponseArraySize);
					
					String androidIdAppEvent1 = null;
					String dateAppEvent1 = null;
					String eventCategoryAppEvent1 = null;
					String totalEventsAppEvent1=null;
					// appending gaid and gadiscription and setting in
					// responseElementModelObject
					bufferedwritterobject.append(gaReportInputModel.getmGaID());
					bufferedwritterobject.append("^");
					responseElementModelObject.setmGaId(gaReportInputModel.getmGaID());
					

					bufferedwritterobject.append(gaReportInputModel.getmGaDiscription());
					bufferedwritterobject.append("^");
					//responseElementModelObject.setmGAdiscription(gaReportInputModel.GaDiscription);

					// appending date,android id and event category and setting in
					// model class
					for (int d = 0; d < dimensionResponseArraySize; d++) {
						if (dimensionCount % 3 == 0) {
							//
							responseElementModelObject.setmDate(dimensionResponseArraList.get(dimensionCount));

							//putting into dataHashMap
							dateHashMap.put(responseElementModelObject.getmDate(), dateHashMapCount++);
							// assigning into dateAppEvent1
							dateAppEvent1 = dimensionResponseArraList.get(dimensionCount);
						}
						if (dimensionCount % 3 == 1) {
							responseElementModelObject.setmAndroidId(dimensionResponseArraList.get(dimensionCount));

							//putting into androidIdHashMap
							androidIdHashMap.put(responseElementModelObject.getmAndroidId(), androidIdHashMapCount++);
							// assigning into androidIdAppEvent1
							 androidIdAppEvent1 = dimensionResponseArraList.get(dimensionCount);
						}
						if (dimensionCount % 3 == 2) {
							responseElementModelObject.setmEventCategory(dimensionResponseArraList.get(dimensionCount));
							// assigning into eventCategoryAppEvent1
							eventCategoryAppEvent1 = dimensionResponseArraList.get(dimensionCount);
						}
						if (gaReportInputModel.getmDimensionArraList().contains("ga:dimension8")) {
							if (dimensionCount % 3 == 2) {
								bufferedwritterobject.append(" ");
								bufferedwritterobject.append("^");
							}
						}
						// to fetch unique user on particular day
						uniqueUserPerDay.put(responseElementModelObject.getmDate(),
								responseElementModelObject.getmAndroidId());

						bufferedwritterobject.append(dimensionResponseArraList.get(dimensionCount));
						bufferedwritterobject.append("^");

						dimensionCount++;
					}
					bufferedwritterobject.append(" ");
					bufferedwritterobject.append("^");
					// appending metric value and setting into model
					for (int m = 0; m < metricResponseArraySize; m++) {
						
						bufferedwritterobject.append(metricResposeArrayList.get(metricCount));
						bufferedwritterobject.append("^");
						//setting metric value into responseElementModel
						responseElementModelObject.setmTotalEvents(metricResposeArrayList.get(metricCount));
						//assigning value 
						totalEventsAppEvent1=metricResposeArrayList.get(metricCount);
						metricCount++;
					}

					bufferedwritterobject.append(" ");
					bufferedwritterobject.append("^");
					bufferedwritterobject.append(" ");
					bufferedwritterobject.append("^");
					bufferedwritterobject.append(" ");
					bufferedwritterobject.append("^");
					bufferedwritterobject.append(" ");
					bufferedwritterobject.append("^");

					bufferedwritterobject.newLine();
					
					appEventDataModel1ArrayList
							.add(new AppEventDataModel1(dateAppEvent1, androidIdAppEvent1, eventCategoryAppEvent1,totalEventsAppEvent1));
					responseElementModelArrayList.add(responseElementModelObject);
				}
				bufferedwritterobject.close();
				
				// // now iterating HashMap value and adding unique androidId into ArrayList
				for (Entry<String, Integer> m1 : androidIdHashMap.entrySet()) {
					// taking value
					uniqueAndroidId.add(m1.getKey());
					// System.out.println(m1.getKey() + " " + m1.getValue());
				}
				
				// adding into date ArrayList
				for (Entry<String, Integer> m1 : dateHashMap.entrySet()) {
					// taking value
					Uniquedate.add(m1.getKey());
					total.add(String.valueOf(m1.getValue()));
				}

			}

			else {
				// if metric having 4 value and dimension having 2 value 
				if (metricResponseArraySize == 4 && dimensionResponseArraySize == 2) {
					for (int r = 0; r < rowResponseArraySize; r++) {
						
						ResponseElementModel responseElementModelObject = new ResponseElementModel();
						// appending gaid and gadiscription and setting in
						bufferedwritterobject.append(gaReportInputModel.getmGaID());
						bufferedwritterobject.append("^");
						responseElementModelObject.setmGaId(gaReportInputModel.getmGaID());

						bufferedwritterobject.append(gaReportInputModel.getmGaDiscription());
						bufferedwritterobject.append("^");
						responseElementModelObject.setmGAdiscription(gaReportInputModel.getmGaDiscription());

						for (int d = 0; d < dimensionResponseArraySize; d++) {

							if (dimensionCount % 2 == 0) {
								responseElementModelObject.setmDate(dimensionResponseArraList.get(dimensionCount));
								dateHashMap.put(responseElementModelObject.getmDate(), dateHashMapCount++);

							}
							if (dimensionCount % 2 == 1) {
								responseElementModelObject.setmAndroidId(dimensionResponseArraList.get(dimensionCount));
								androidIdHashMap.put(responseElementModelObject.getmAndroidId(),
										androidIdHashMapCount++);

							}
							bufferedwritterobject.append(dimensionResponseArraList.get(dimensionCount));
							bufferedwritterobject.append("^");
							dimensionCount++;
						}
						bufferedwritterobject.append(" ");
						bufferedwritterobject.append("^");
						bufferedwritterobject.append(" ");
						bufferedwritterobject.append("^");
						bufferedwritterobject.append(" ");
						bufferedwritterobject.append("^");

						// appending and setting value into model class
						for (int m = 0; m < metricResponseArraySize; m++) {
							if (metricCount % 4 == 0) {
								responseElementModelObject.setmSessions(metricResposeArrayList.get(metricCount));

							}
							if (metricCount % 4 == 1) {
								responseElementModelObject.setmScreenViews(metricResposeArrayList.get(metricCount));

							}
							if (metricCount % 4 == 2) {
								responseElementModelObject.setmExit(metricResposeArrayList.get(metricCount));

							}
							if (metricCount % 4 == 3) {
								responseElementModelObject.setmSessions(metricResposeArrayList.get(metricCount));

							}

							bufferedwritterobject.append(metricResposeArrayList.get(metricCount));
							bufferedwritterobject.append("^");

							metricCount++;
						}
						bufferedwritterobject.newLine();
					}
					bufferedwritterobject.close();
					
					// now iterating HashMap value and
					// adding unique androidId into ArrayList
					for (Entry<String, Integer> m1 : androidIdHashMap.entrySet()) {
						// taking value
						uniqueAndroidId.add(m1.getKey());
						// System.out.println(m1.getKey() + " " +
						// m1.getValue());
					}
					System.out.println(dateHashMap.size());
					// adding into date ArrayList
					for (Entry<String, Integer> m1 : dateHashMap.entrySet()) {
						// taking value
						Uniquedate.add(m1.getKey());
						total.add(String.valueOf(m1.getValue()));

						System.out.println(m1.getKey() + " " + m1.getValue());
					}
				}
				// if dimension is having 2 value and metric is having 1 value 
				else {
					if (dimensionResponseArraySize == 2 && metricResponseArraySize == 1) {
						// appending value and setting into model class
						for (int r = 0; r < rowResponseArraySize; r++) {
							ResponseElementModel responseElementModelObject = new ResponseElementModel();
							// appending gaid and gadiscription 
							bufferedwritterobject.append(gaReportInputModel.getmGaID());
							bufferedwritterobject.append("^");
							responseElementModelObject.setmGaId(gaReportInputModel.getmGaID());

							bufferedwritterobject.append(gaReportInputModel.getmGaDiscription());
							bufferedwritterobject.append("^");
							responseElementModelObject.setmGAdiscription(gaReportInputModel.getmGaDiscription());
							
							// appending dimension value 
							for (int d = 0; d < dimensionResponseArraySize; d++) {
								if (dimensionCount % 2 == 0) {
									responseElementModelObject.setmDate(dimensionResponseArraList.get(dimensionCount));
									dateHashMap.put(responseElementModelObject.getmDate(), dateHashMapCount++);

								}
								if (dimensionCount % 2 == 1) {
									responseElementModelObject.setmAndroidId(dimensionResponseArraList.get(dimensionCount));
									androidIdHashMap.put(responseElementModelObject.getmAndroidId(),
											androidIdHashMapCount++);

								}
								bufferedwritterobject.append(dimensionResponseArraList.get(dimensionCount));
								bufferedwritterobject.append("^");
								dimensionCount++;
							}
							bufferedwritterobject.append(" ");
							bufferedwritterobject.append("^");
							bufferedwritterobject.append(" ");
							bufferedwritterobject.append("^");
							
							// appending metric value 
							for (int m = 0; m < metricResponseArraySize; m++) {

								responseElementModelObject.setmTotalEvents(metricResposeArrayList.get(metricCount));

								bufferedwritterobject.append(metricResposeArrayList.get(metricCount));
								bufferedwritterobject.append("^");
								metricCount++;
							}
							bufferedwritterobject.append(" ");
							bufferedwritterobject.append("^");
							bufferedwritterobject.append(" ");
							bufferedwritterobject.append("^");
							bufferedwritterobject.append(" ");
							bufferedwritterobject.append("^");
							bufferedwritterobject.append(" ");
							bufferedwritterobject.append("^");
							bufferedwritterobject.newLine();

						}
						bufferedwritterobject.close();
						// now iterating hashmap value
						System.out.println(androidIdHashMap.size());
					
						// adding unique androidId into ArrayList
						for (Entry<String, Integer> m1 : androidIdHashMap.entrySet()) {
							// taking value
							uniqueAndroidId.add(m1.getKey());
							// System.out.println(m1.getKey() + " " +
							// m1.getValue());
						}
						System.out.println(dateHashMap.size());
						// adding into date arraylist
						for (Entry<String, Integer> m1 : dateHashMap.entrySet()) {
							// taking value
							Uniquedate.add(m1.getKey());
							total.add(String.valueOf(m1.getValue()));

							System.out.println(m1.getKey() + " " + m1.getValue());
						}

					}
				}

			}
			
//CSV creator for number of summary Report
			File file = new File("/home/bridgeit/Music/summaryreport.csv");
			if (!file.exists()) {
				b = true;
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			if (b) {
				file.createNewFile();
				// appending id and gadiscription
				bw.append("gaid");
				bw.append("^");
				bw.append("gadiscription");
				bw.append("^");
				// appending date in summary response
				for (int j1 = 0; j1 < Uniquedate.size(); j1++) {
					bw.append(Uniquedate.get(j1));
					bw.append("^");
				}
				bw.newLine();
			}
			if (true) {
				bw.append(gaReportInputModel.getmGaID());
				bw.append("^");
				bw.append(gaReportInputModel.getmGaDiscription());
				bw.append("^");
				// appending total values
				for (int j2 = 0; j2 < Uniquedate.size(); j2++) {
					bw.append(total.get(j2).toString());
					bw.append("^");
				}
				bw.newLine();
			}
			bw.close();
			
			// calling AppDataModelCsvCreator 
			appDataModelCsvCreatorObject.appDataModelCsvCreator(appEventDataModel1ArrayList,gaReportInputModel);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	return	responseElementModelArrayList;
	}

}
