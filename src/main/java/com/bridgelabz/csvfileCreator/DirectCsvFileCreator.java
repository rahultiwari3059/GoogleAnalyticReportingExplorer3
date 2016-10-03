package com.bridgelabz.csvfileCreator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.json.simple.parser.JSONParser;

import com.bridgelab.model.AppEventDataModel;
import com.bridgelab.model.AppEventDataModel1;
import com.bridgelab.model.ResponseAssigningModel;
import com.bridgelab.model.ResponseElementModel;
import com.bridgelabz.inputReader.GaReportInputInfo;
import com.bridgelabz.responseReader.ResponseAssigningConstructor;
import com.bridgelabz.responseReader.ResponseReaderConstructor;

public class DirectCsvFileCreator {
	public void directCsvFileCreator(GaReportInputInfo gaReportInputInfo,
			ResponseReaderConstructor responseReaderConstructor) {

		// creating object of ResponseElementModelclass
		ResponseElementModel responseElementModelObject = new ResponseElementModel();
		// creating object of AppEventDataModelclass
		AppEventDataModel appEventDataModelObject = new AppEventDataModel();
		// creating object of AppEventDataModel1
		ArrayList<AppEventDataModel1> appEventDataModel1ArrayList = new ArrayList<AppEventDataModel1>();
		//
		AppDataModelCsvCreator appDataModelCsvCreatorObject= new AppDataModelCsvCreator();

		// creating HashMap to find number of user on particular day
		HashMap<String, Integer> dateHashMap = new HashMap<String, Integer>();
		// creating HashMap to find out number of unique android id
		HashMap<String, Integer> androidIdHashMap = new HashMap<String, Integer>();
		// creating HashMap for finding out number of number of unique user on
		// particular day
		HashMap<String, String> uniqueUserPerDay = new HashMap<String, String>();
		//
		HashMap<String, AppEventDataModel1> appEventDataModel1HashMap = new HashMap<String, AppEventDataModel1>();

		// initializing value to the count
		int dateHashMapCount = 1;
		int androidIdHashMapCount = 1;

		// creating uniqueAndroidId ArrayList object and uniquedate and total
		ArrayList<String> uniqueAndroidId = new ArrayList<String>();
		ArrayList<String> Uniquedate = new ArrayList<String>();
		ArrayList<String> total = new ArrayList<String>();

		// assigning the value of perticular response
		int metricResponseArraySize = responseReaderConstructor.metricResponseArraySize;
		int dimensionResponseArraySize = responseReaderConstructor.dimensionResponseArraySize;
		int rowResponseArraySize = responseReaderConstructor.rowResponseArraySize;
		ArrayList<String> metricResposeArrayList = responseReaderConstructor.metricResposeArrayList;
		ArrayList<String> dimensionResponseArraList = responseReaderConstructor.dimensionResponseArraList;
		try {
			int k = 0, p = 0;
			int androidIdTotal = 0;
			boolean b1 = false;
			boolean b = false;
			boolean b3 = false;
			File file1 = new File("/home/bridgeit/Music/allcsv.csv");
			if (!file1.exists()) {
				b1 = true;
			}

			FileWriter filewriterobject1 = new FileWriter(file1.getAbsoluteFile(), true);
			BufferedWriter bufferedwritterobject = new BufferedWriter(filewriterobject1);

			if (b1) {
				file1.createNewFile();
				// appending column names
				bufferedwritterobject.append("gaid");
				bufferedwritterobject.append("^");
				bufferedwritterobject.append("gadiscription");
				bufferedwritterobject.append("^");
				bufferedwritterobject.append("Date");
				bufferedwritterobject.append("^");
				bufferedwritterobject.append("AndroidId");
				bufferedwritterobject.append("^");
				bufferedwritterobject.append("Eventcategory");
				bufferedwritterobject.append("^");
				bufferedwritterobject.append("connectiontype");
				bufferedwritterobject.append("^");
				bufferedwritterobject.append("Totalevents");
				bufferedwritterobject.append("^");
				bufferedwritterobject.append("Sessions");
				bufferedwritterobject.append("^");
				bufferedwritterobject.append("Screenviews");
				bufferedwritterobject.append("^");
				bufferedwritterobject.append("Exit");
				bufferedwritterobject.append("^");
				bufferedwritterobject.append("ExitRate");
				bufferedwritterobject.append("^");
				bufferedwritterobject.newLine();
			}
			if (metricResponseArraySize == 0) {

				bufferedwritterobject.append(gaReportInputInfo.GaId);
				bufferedwritterobject.append("^");
				bufferedwritterobject.append(gaReportInputInfo.GaDiscription);
				bufferedwritterobject.append("^");
				bufferedwritterobject.newLine();
				bufferedwritterobject.close();
			}

			if (dimensionResponseArraySize == 3) {
				for (int r = 0; r < rowResponseArraySize; r++) {
					String androidIdAppEvent1 = null;
					String dateAppEvent1 = null;
					String eventCategoryAppEvent1 = null;
					// appending gaid and gadiscription and setting in
					// responseElementModelObject
					bufferedwritterobject.append(gaReportInputInfo.GaId);
					bufferedwritterobject.append("^");
					responseElementModelObject.setmGaId(gaReportInputInfo.GaId);

					bufferedwritterobject.append(gaReportInputInfo.GaDiscription);
					bufferedwritterobject.append("^");
					responseElementModelObject.setmGAdiscription(gaReportInputInfo.GaDiscription);

					// appending date,androidid and eventcategory and setting in
					// model class
					for (int d = 0; d < dimensionResponseArraySize; d++) {
						if (k % 3 == 0) {
							//
							responseElementModelObject.setmDate(dimensionResponseArraList.get(k));
							appEventDataModelObject.setmAppEventDate(dimensionResponseArraList.get(k));
							dateHashMap.put(responseElementModelObject.getmDate(), dateHashMapCount++);

							dateAppEvent1 = dimensionResponseArraList.get(k);
						}
						if (k % 3 == 1) {
							responseElementModelObject.setmAndroidId(dimensionResponseArraList.get(k));
							appEventDataModelObject.setmAppEventAndroidId(dimensionResponseArraList.get(k));
							androidIdHashMap.put(responseElementModelObject.getmAndroidId(), androidIdHashMapCount++);

							 androidIdAppEvent1 = dimensionResponseArraList.get(k);
						}
						if (k % 3 == 2) {
							responseElementModelObject.setmEventCategory(dimensionResponseArraList.get(k));
							appEventDataModelObject.setmAppEventCategory(dimensionResponseArraList.get(k));

							 eventCategoryAppEvent1 = dimensionResponseArraList.get(k);
						}
						if (gaReportInputInfo.dimensionArraList.contains("ga:dimension8")) {
							if (k % 3 == 2) {
								bufferedwritterobject.append(" ");
								bufferedwritterobject.append("^");
							}
						}
						// to fetch unique user on particular day
						uniqueUserPerDay.put(responseElementModelObject.getmDate(),
								responseElementModelObject.getmAndroidId());

						bufferedwritterobject.append(dimensionResponseArraList.get(k));
						bufferedwritterobject.append("^");

						k++;
					}
					bufferedwritterobject.append(" ");
					bufferedwritterobject.append("^");
					// appending metric value and setting into model
					for (int m = 0; m < metricResponseArraySize; m++) {

						bufferedwritterobject.append(metricResposeArrayList.get(p));
						bufferedwritterobject.append("^");
						responseElementModelObject.setmTotalEvents(metricResposeArrayList.get(p));
						p++;
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
							.add(new AppEventDataModel1(dateAppEvent1, androidIdAppEvent1, eventCategoryAppEvent1));
					appEventDataModel1HashMap.put(responseElementModelObject.getmAndroidId(),
							new AppEventDataModel1(dateAppEvent1, androidIdAppEvent1, eventCategoryAppEvent1));
				}

				bufferedwritterobject.close();
				System.out.println(appEventDataModel1HashMap.size());
				File file = new File("/home/bridgeit/Music/AppEventDataModel.csv");
				if (!file.exists()) {
					b3 = true;
				}
				FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
				BufferedWriter bw3 = new BufferedWriter(fw);
				if (b3) {
					file.createNewFile();
					// appending id and gadiscription
					bw3.append(
							"gaid^gadiscription^Date^AndroidId^Eventcategory^connectiontype^Totalevents^Sessions^Screenviews^Exit^ExitRate^");
					bw3.newLine();
				}

				for (Entry<String, AppEventDataModel1> m1 : appEventDataModel1HashMap.entrySet()) {

					System.out.println(m1.getKey() + " " + m1.getValue());

				
					
					{
						bw3.append(gaReportInputInfo.GaId);
						bw3.append("^");
						bw3.append(gaReportInputInfo.GaDiscription);
						bw3.append("^");
						bw3.append(appEventDataModelObject.getmAppEventDate());
						bw3.append("^");
						bw3.append(appEventDataModelObject.getmAppEventAndroidId());
						bw3.append("^");
						bw3.append(appEventDataModelObject.getmAppEventCategory());
						bw3.append("^");
						bw3.append(" ");
						bw3.append("^");
						bw3.append(" ");
						bw3.append("^");
						bw3.append(" ");
						bw3.append("^");
						bw3.append(" ");
						bw3.append("^");
						bw3.append(" ");
						bw3.append("^");
						bw3.append(" ");
						bw3.append("^");
						bw3.newLine();
						
						
					}
					
				}
				bw3.close();
				// now iterating hashmap value
				System.out.println(androidIdHashMap.size());
				androidIdTotal = androidIdHashMap.size();
				// adding unique androidId into ArrayList
				for (Entry<String, Integer> m1 : androidIdHashMap.entrySet()) {
					// taking value
					uniqueAndroidId.add(m1.getKey());
					// System.out.println(m1.getKey() + " " + m1.getValue());
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

			else {

				if (metricResponseArraySize == 4 && dimensionResponseArraySize == 2) {
					for (int r = 0; r < rowResponseArraySize; r++) {

						// appending gaid and gadiscription and setting in
						// responseElementModelObject

						bufferedwritterobject.append(gaReportInputInfo.GaId);
						bufferedwritterobject.append("^");
						responseElementModelObject.setmGaId(gaReportInputInfo.GaId);

						bufferedwritterobject.append(gaReportInputInfo.GaDiscription);
						bufferedwritterobject.append("^");
						responseElementModelObject.setmGAdiscription(gaReportInputInfo.GaDiscription);

						for (int d = 0; d < dimensionResponseArraySize; d++) {

							if (k % 2 == 0) {
								responseElementModelObject.setmDate(dimensionResponseArraList.get(k));
								dateHashMap.put(responseElementModelObject.getmDate(), dateHashMapCount++);

							}
							if (k % 2 == 1) {
								responseElementModelObject.setmAndroidId(dimensionResponseArraList.get(k));
								androidIdHashMap.put(responseElementModelObject.getmAndroidId(),
										androidIdHashMapCount++);

							}
							bufferedwritterobject.append(dimensionResponseArraList.get(k));
							bufferedwritterobject.append("^");
							k++;
						}
						bufferedwritterobject.append(" ");
						bufferedwritterobject.append("^");
						bufferedwritterobject.append(" ");
						bufferedwritterobject.append("^");
						bufferedwritterobject.append(" ");
						bufferedwritterobject.append("^");

						// appending and setting value into model class
						for (int m = 0; m < metricResponseArraySize; m++) {
							if (p % 4 == 0) {
								responseElementModelObject.setmSessions(metricResposeArrayList.get(p));

							}
							if (p % 4 == 1) {
								responseElementModelObject.setmScreenViews(metricResposeArrayList.get(p));

							}
							if (p % 4 == 2) {
								responseElementModelObject.setmExit(metricResposeArrayList.get(p));

							}
							if (p % 4 == 3) {
								responseElementModelObject.setmSessions(metricResposeArrayList.get(p));

							}

							bufferedwritterobject.append(metricResposeArrayList.get(p));
							bufferedwritterobject.append("^");

							p++;
						}
						bufferedwritterobject.newLine();
					}
					bufferedwritterobject.close();
					// now iterating hashmap value
					System.out.println(androidIdHashMap.size());
					androidIdTotal = androidIdHashMap.size();
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

				else {
					if (dimensionResponseArraySize == 2 && metricResponseArraySize == 1) {
						// appending value and setting into model class
						for (int r = 0; r < rowResponseArraySize; r++) {

							bufferedwritterobject.append(gaReportInputInfo.GaId);
							bufferedwritterobject.append("^");
							responseElementModelObject.setmGaId(gaReportInputInfo.GaId);

							bufferedwritterobject.append(gaReportInputInfo.GaDiscription);
							bufferedwritterobject.append("^");
							responseElementModelObject.setmGAdiscription(gaReportInputInfo.GaDiscription);
							for (int d = 0; d < dimensionResponseArraySize; d++) {
								if (k % 2 == 0) {
									responseElementModelObject.setmDate(dimensionResponseArraList.get(k));
									dateHashMap.put(responseElementModelObject.getmDate(), dateHashMapCount++);

								}
								if (k % 2 == 1) {
									responseElementModelObject.setmAndroidId(dimensionResponseArraList.get(k));
									androidIdHashMap.put(responseElementModelObject.getmAndroidId(),
											androidIdHashMapCount++);

								}
								bufferedwritterobject.append(dimensionResponseArraList.get(k));
								bufferedwritterobject.append("^");
								k++;
							}
							bufferedwritterobject.append(" ");
							bufferedwritterobject.append("^");
							bufferedwritterobject.append(" ");
							bufferedwritterobject.append("^");
							for (int m = 0; m < metricResponseArraySize; m++) {

								responseElementModelObject.setmTotalEvents(metricResposeArrayList.get(p));

								bufferedwritterobject.append(metricResposeArrayList.get(p));
								bufferedwritterobject.append("^");
								p++;
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
						androidIdTotal = androidIdHashMap.size();
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
				bw.append("totaluniqueandroidid");
				bw.append("^");
				// appending date in summary response
				for (int j1 = 0; j1 < Uniquedate.size(); j1++) {
					bw.append(Uniquedate.get(j1));
					bw.append("^");
				}
				bw.newLine();
			}
			if (true) {
				bw.append(responseElementModelObject.getmGaId());
				bw.append("^");
				bw.append(responseElementModelObject.getmGAdiscription());
				bw.append("^");
				// appending unique user total value
				bw.append(String.valueOf(androidIdTotal));
				bw.append("^");
				// appending total values
				for (int j2 = 0; j2 < Uniquedate.size(); j2++) {
					bw.append(Uniquedate.get(j2).toString());
					bw.append("^");
				}
				bw.newLine();

			}
			bw.close();
			appDataModelCsvCreatorObject.AppDataModelCsvCreator(appEventDataModel1ArrayList,gaReportInputInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
