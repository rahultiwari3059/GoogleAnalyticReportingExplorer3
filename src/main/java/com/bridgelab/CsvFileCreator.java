package com.bridgelab;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import com.bridgelab.model.GaReportInputModel;
import com.bridgelab.model.ResponseAssigningModel;
import com.bridgelab.model.ResponseModel;

public class CsvFileCreator {
	ResponseAssigningModel responseAssigningModelObject = new ResponseAssigningModel();
	ResponseModel responseModelObject = new ResponseModel();
	GaReportInputModel gaReportInputModelObject = new GaReportInputModel();

	public void createCsv() {
		try {
			boolean b1 = false;
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
				bufferedwritterobject.append("AndroisId");
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
			if (responseModelObject.getDimensionArraySize() == 3) {
				bufferedwritterobject.append(gaReportInputModelObject.getmGaID());
				bufferedwritterobject.append("^");
				bufferedwritterobject.append(gaReportInputModelObject.getmGaDiscription());
				bufferedwritterobject.append("^");
				bufferedwritterobject.append(responseAssigningModelObject.getmDate());
				bufferedwritterobject.append("^");
				bufferedwritterobject.append(responseAssigningModelObject.getmAndroidId());
				bufferedwritterobject.append("^");
				bufferedwritterobject.append(responseAssigningModelObject.getmTotalEvents());
				bufferedwritterobject.append("^");
				bufferedwritterobject.append(" ");
				bufferedwritterobject.append("^");
				bufferedwritterobject.append(" ");
				bufferedwritterobject.append("^");
				bufferedwritterobject.append(" ");
				bufferedwritterobject.append("^");
				bufferedwritterobject.append(" ");
				bufferedwritterobject.append("^");
				bufferedwritterobject.append(" ");
				bufferedwritterobject.append("^");
				bufferedwritterobject.newLine();

			} else {
				if (responseModelObject.getMetricArraySize() == 4 && responseModelObject.getDimensionArraySize() == 2) {
					bufferedwritterobject.append(gaReportInputModelObject.getmGaID());
					bufferedwritterobject.append("^");
					bufferedwritterobject.append(gaReportInputModelObject.getmGaDiscription());
					bufferedwritterobject.append("^");
					bufferedwritterobject.append(responseAssigningModelObject.getmDate());
					bufferedwritterobject.append("^");
					bufferedwritterobject.append(responseAssigningModelObject.getmAndroidId());
					bufferedwritterobject.append("^");
					bufferedwritterobject.append(" ");
					bufferedwritterobject.append("^");
					bufferedwritterobject.append(" ");
					bufferedwritterobject.append("^");
					bufferedwritterobject.append(" ");
					bufferedwritterobject.append("^");
					bufferedwritterobject.append(responseAssigningModelObject.getmSessions());
					bufferedwritterobject.append("^");
					bufferedwritterobject.append(responseAssigningModelObject.getmScreenViews());
					bufferedwritterobject.append("^");
					bufferedwritterobject.append(responseAssigningModelObject.getmExit());
					bufferedwritterobject.append("^");
					bufferedwritterobject.append(responseAssigningModelObject.getmExitRate());
					bufferedwritterobject.newLine();
				} else {
					if (responseModelObject.getDimensionArraySize() == 2) {
						bufferedwritterobject.append(gaReportInputModelObject.getmGaID());
						bufferedwritterobject.append("^");
						bufferedwritterobject.append(gaReportInputModelObject.getmGaDiscription());
						bufferedwritterobject.append("^");
						bufferedwritterobject.append(responseAssigningModelObject.getmDate());
						bufferedwritterobject.append("^");
						bufferedwritterobject.append(responseAssigningModelObject.getmAndroidId());
						bufferedwritterobject.append("^");
						bufferedwritterobject.append(" ");
						bufferedwritterobject.append("^");
						bufferedwritterobject.append(" ");
						bufferedwritterobject.append("^");
						bufferedwritterobject.append(responseAssigningModelObject.getmTotalEvents());
						bufferedwritterobject.append("^");
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
				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
