package com.bridgelabz.inputReader;

import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.bridgelab.model.GaReportInputModel;
import com.bridgelab.model.SecretFileModel;
import com.bridgelabz.responseFetcher.InitializeAnalyticsReporting;

public class GaReprtInfoArrayList {

	// making ArrayList of GaReportInputInfo
	ArrayList<GaReportInputInfo> gaReportInputInfoArrayList = new ArrayList<GaReportInputInfo>();

	// ArrayList of model class
	ArrayList<GaReportInputModel> GaReportInputModelArrayList = new ArrayList<GaReportInputModel>();

	// method for reading JsonFile
	public ArrayList<GaReportInputModel> readInputJsonFile(String jsonfilepath) {

		try {
			// creating object of SecretFileModel to set data from JSON data
			SecretFileModel secretFileModelObject = new SecretFileModel();

			JSONParser parser = new JSONParser();
			// parsing and casting to Object
			Object obj = parser.parse(new FileReader(jsonfilepath));
			// casting object into JSONObject
			JSONObject jsonObject = (JSONObject) obj;

			// setting value in secretFileModelObject o
			secretFileModelObject.setStartDate((String) jsonObject.get("startDate"));

			secretFileModelObject.setEndDate((String) jsonObject.get("endDate"));

			secretFileModelObject.setAPPLICATION_NAME((String) jsonObject.get("APPLICATION_NAME"));

			secretFileModelObject.setKEY_FILE_LOCATION((String) jsonObject.get("KEY_FILE_LOCATION"));

			secretFileModelObject.setSERVICE_ACCOUNT_EMAIL((String) jsonObject.get("SERVICE_ACCOUNT_EMAIL"));

			secretFileModelObject.setVIEW_ID((String) jsonObject.get("VIEW_ID"));

			// passing secretFileModelObject to constructor to set all secret
			// credential

			InitializeAnalyticsReporting initializeAnalyticsReportingObject = new InitializeAnalyticsReporting(
					secretFileModelObject);

			// casting into jsonArray
			JSONArray gaReportInfoArray = (JSONArray) jsonObject.get("GAReportInfo");

			// reading one by one object
			for (int i = 0; i < gaReportInfoArray.size(); i++) {
				GaReportInputModel gaReportInputModelObject = new GaReportInputModel();

				// initializing all value
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
				gaReportInputModelObject.setmGaID((String) gaReportInfoObject.get("GAID"));

				// converting GAdiscription into string and printing same
				GaDiscription = (String) gaReportInfoObject.get("GAdiscription");
				gaReportInputModelObject.setmGaDiscription((String) gaReportInfoObject.get("GAdiscription"));

				// making metric array
				JSONArray metricJSONArray = (JSONArray) gaReportInfoObject.get("metric");
				// reading the metric array
				for (int k = 0; k < metricJSONArray.size(); k++) {
					// adding into metric ArrayList
					metricArraList.add((String) metricJSONArray.get(k));
				}
				gaReportInputModelObject.setmMetricArraList(metricArraList);

				// making dimension JSONArray
				JSONArray dimensionsJSONArray = (JSONArray) gaReportInfoObject.get("dimension");
				// reading the dimension array
				for (int j = 0; j < dimensionsJSONArray.size(); j++) {
					dimensionArraList.add((String) dimensionsJSONArray.get(j));
				}
				gaReportInputModelObject.setmDimensionArraList(dimensionArraList);

				// Casting DimensionFilter into JSONArray
				JSONArray dimensionFilterJSONArray = (JSONArray) gaReportInfoObject.get("dimensionfilter");

				for (int l = 0; l < dimensionFilterJSONArray.size(); l++) {
					// adding into DimensionFilter ArrayList
					dimensionFilterArraList.add((String) dimensionFilterJSONArray.get(l));
				}
				gaReportInputModelObject.setmDimensionFilterArraList(dimensionFilterArraList);
				// adding into arrayList after creating object by passing
				// argument to the constructor
				gaReportInputInfoArrayList.add(new GaReportInputInfo(GaId, GaDiscription, metricArraList,
						dimensionArraList, dimensionFilterArraList));

				GaReportInputModelArrayList.add(gaReportInputModelObject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// returning the ArrayList of reportinfo
		return GaReportInputModelArrayList;
	}

}