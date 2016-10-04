package com.bridgelabz.csvfileCreator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import com.bridgelab.model.GaReportInputModel;
import com.bridgelab.model.ResponseElementModel;

public class AppOpenCsvCreator {
	
	public void appOpenCsvCreator(ResponseElementModel responseElementModel, GaReportInputModel gaReportInputModel)
	{
	try {
		
		// appopen csv creator    
		if (gaReportInputModel.mGaID.equals("1")) {
			boolean b3 = false;
			File file = new File("/home/bridgeit/Music/testing.csv");
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
	
			{
					bw3.append(gaReportInputModel.getmGaID());
					bw3.append("^");
					bw3.append(gaReportInputModel.getmGaDiscription());
					bw3.append("^");
					bw3.append(responseElementModel.getmDate());
					bw3.append("^");
					bw3.append(responseElementModel.getmAndroidId());
					bw3.append("^");
					bw3.append(responseElementModel.getmEventCategory());
					bw3.append("^");
					bw3.append(" ");
					bw3.append("^");
					bw3.append(responseElementModel.getmTotalEvents());
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
			bw3.close();
			}
			

	
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}