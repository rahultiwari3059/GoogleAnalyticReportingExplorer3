package com.bridgelabz.csvfileCreator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map.Entry;

import com.bridgelab.model.AppEventDataModel1;
import com.bridgelab.model.GaReportInputModel;
import com.bridgelabz.inputReader.GaReportInputInfo;

public class AppDataModelCsvCreator {
	public void appDataModelCsvCreator(ArrayList<AppEventDataModel1> appEventDataModel1ArrayList,
			GaReportInputModel gaReportInputModel) {
		
		try {
			// appopen csv creator    
			if (gaReportInputModel.mGaID.equals("1")) {
				boolean b3 = false;
				File file = new File("/home/bridgeit/Music/AppOpen.csv");
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
				for (int i = 0; i < appEventDataModel1ArrayList.size(); i++) {

					{
						bw3.append(gaReportInputModel.getmGaID());
						bw3.append("^");
						bw3.append(gaReportInputModel.getmGaDiscription());
						bw3.append("^");
						bw3.append(appEventDataModel1ArrayList.get(i).dateAppEvent1);
						bw3.append("^");
						bw3.append(appEventDataModel1ArrayList.get(i).androidIdAppEvent1);
						bw3.append("^");
						bw3.append(appEventDataModel1ArrayList.get(i).eventCategoryAppEvent1);
						bw3.append("^");
						bw3.append(" ");
						bw3.append("^");
						bw3.append(appEventDataModel1ArrayList.get(i).totalEventsAppEvent1);
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

			} else {
				boolean b3 = false;
				File file = new File("/home/bridgeit/Music/AppReOpen.csv");
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
				for (int i = 0; i < appEventDataModel1ArrayList.size(); i++) {

					{
						bw3.append(gaReportInputModel.getmGaID());
						bw3.append("^");
						bw3.append(gaReportInputModel.getmGaDiscription());
						bw3.append("^");
						bw3.append(appEventDataModel1ArrayList.get(i).dateAppEvent1);
						bw3.append("^");
						bw3.append(appEventDataModel1ArrayList.get(i).androidIdAppEvent1);
						bw3.append("^");
						bw3.append(appEventDataModel1ArrayList.get(i).eventCategoryAppEvent1);
						bw3.append("^");
						bw3.append(" ");
						bw3.append("^");
						bw3.append(appEventDataModel1ArrayList.get(i).totalEventsAppEvent1);
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

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
