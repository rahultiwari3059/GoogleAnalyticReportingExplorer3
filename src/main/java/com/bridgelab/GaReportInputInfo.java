package com.bridgelab;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bridgelab.model.GaReportInputModel;

public class GaReportInputInfo {
	// creating object of GaReportInputModel
	// initializing 
	String GaId = null;
	String GaDiscription = null;
	ArrayList<String> metricArraList = new ArrayList<String>();
	ArrayList<String> dimensionArraList = new ArrayList<String>();
	ArrayList<String> dimensionFilterArraList = new ArrayList<String>();
	//method to set input JSON in model class
	public void readInputJsonFile(String jsonfilepath,GaReportInputModel gaReportInputModel) {
		try {
			JSONParser parser = new JSONParser();
			// parsing and casting to Object
			Object obj = parser.parse(new FileReader(jsonfilepath));
			// casting object into JSONObject
			JSONObject jsonObject = (JSONObject) obj;
			// casting into JSONObject
			JSONArray gaReportInfoArray = (JSONArray) jsonObject.get("GAReportInfo");

			for (int i = 0; i < gaReportInfoArray.size(); i++) {

				JSONObject gaReportInfoObject = (JSONObject) gaReportInfoArray.get(i);
				// converting GAID into string and adding into GaIdArraList
				GaId = (String) gaReportInfoObject.get("GAID");
				gaReportInputModel.setmGaID(GaId);

				// converting GAdiscription into string and printing same
				GaDiscription = (String) gaReportInfoObject.get("GAdiscription");
				gaReportInputModel.setmGaDiscription(GaDiscription);

				// making metric array
				JSONArray metricJSONArray = (JSONArray) gaReportInfoObject.get("metric");
				// reading the metric array
				for (int k = 0; k < metricJSONArray.size(); k++) {
					// adding into metric ArrayList
					metricArraList.add((String) metricJSONArray.get(k));
				}
				gaReportInputModel.setmMetricArraList(metricArraList);

				// making dimension JSONArray
				JSONArray dimensionsJSONArray = (JSONArray) gaReportInfoObject.get("dimension");
				// reading the dimension array
				for (int j = 0; j < dimensionsJSONArray.size(); j++) {
					dimensionArraList.add((String) dimensionsJSONArray.get(j));
				}
				gaReportInputModel.setmDimensionArraList(dimensionArraList);

				// Casting DimensionFilter into JSONArray
				JSONArray dimensionFilterJSONArray = (JSONArray) gaReportInfoObject.get("dimensionfilter");

				for (int l = 0; l < dimensionFilterJSONArray.size(); l++) {
					// adding into DimensionFilter ArrayList
					dimensionFilterArraList.add((String) dimensionFilterJSONArray.get(l));
				}
				gaReportInputModel.setmDimensionFilterArraList(dimensionFilterArraList);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
