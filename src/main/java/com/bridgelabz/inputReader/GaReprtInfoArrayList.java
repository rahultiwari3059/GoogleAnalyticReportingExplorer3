package com.bridgelabz.inputReader;

import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.bridgelab.model.GaReportInputModel;

public class GaReprtInfoArrayList {

	// making ArrayList of GaReportInputInfo
	ArrayList<GaReportInputInfo> gaReportInputInfoArrayList = new ArrayList<GaReportInputInfo>();

	// for reading JsonFile
	public ArrayList<GaReportInputInfo> readInputJsonFile(String jsonfilepath) {
		
		try {
			JSONParser parser = new JSONParser();
			// parsing and casting to Object
			Object obj = parser.parse(new FileReader(jsonfilepath));
			// casting object into JSONObject
			JSONObject jsonObject = (JSONObject) obj;
			// casting into jsonArray
			JSONArray gaReportInfoArray = (JSONArray) jsonObject.get("GAReportInfo");
			// reading one by one object
			for (int i = 0; i < gaReportInfoArray.size(); i++) {
				String GaId = null;
				String GaDiscription = null;
				
				ArrayList<String> metricArraList = new ArrayList<String>();
				ArrayList<String> dimensionArraList = new ArrayList<String>();
				ArrayList<String> dimensionFilterArraList = new ArrayList<String>();

				JSONObject gaReportInfoObject = (JSONObject) gaReportInfoArray.get(i);
				metricArraList.clear();
				dimensionArraList.clear();
				dimensionFilterArraList.clear();

				// converting GAID into string and adding into GaIdArraList
				GaId = (String) gaReportInfoObject.get("GAID");

				// converting GAdiscription into string and printing same
				GaDiscription = (String) gaReportInfoObject.get("GAdiscription");

				// making metric array
				JSONArray metricJSONArray = (JSONArray) gaReportInfoObject.get("metric");
				// reading the metric array
				for (int k = 0; k < metricJSONArray.size(); k++) {
					// adding into metric ArrayList
					metricArraList.add((String) metricJSONArray.get(k));
				}

				// making dimension JSONArray
				JSONArray dimensionsJSONArray = (JSONArray) gaReportInfoObject.get("dimension");
				// reading the dimension array
				for (int j = 0; j < dimensionsJSONArray.size(); j++) {
					dimensionArraList.add((String) dimensionsJSONArray.get(j));
				}

				// Casting DimensionFilter into JSONArray
				JSONArray dimensionFilterJSONArray = (JSONArray) gaReportInfoObject.get("dimensionfilter");

				for (int l = 0; l < dimensionFilterJSONArray.size(); l++) {
					// adding into DimensionFilter ArrayList
					dimensionFilterArraList.add((String) dimensionFilterJSONArray.get(l));
				}

				// adding into arrayList after creating object by passing
				// argument to the constructor
				gaReportInputInfoArrayList.add(new GaReportInputInfo(GaId, GaDiscription, metricArraList,
						dimensionArraList, dimensionFilterArraList));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// returning the value 
		return gaReportInputInfoArrayList;
	}

}