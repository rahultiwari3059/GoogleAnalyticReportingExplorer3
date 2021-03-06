package com.bridgelab;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bridgelab.model.ResponseModel;

public class ResponseReader {

	ResponseModel responseModelObject = new ResponseModel();
	ArrayList<String> metricResponseArrayList = new ArrayList<String>();
	ArrayList<String> dimensionResponseArrayList = new ArrayList<String>();

	public void responseReader(String response) {

		JSONParser parser = new JSONParser();
		try {
			// parsing and placing in Object class
			Object obj = parser.parse(response);
			// converting object into JSONObject
			JSONObject jsonObject = (JSONObject) obj;
			// covering report array into JSONArray
			JSONArray reportarray = (JSONArray) jsonObject.get("reports");
			// reading report JSONArray
			for (int j = 0; j < reportarray.size(); j++) {
				// getting first object and converting into JSONObject
				JSONObject obj3 = (JSONObject) reportarray.get(j);
				// making JSONObject of data
				JSONObject dataobject = (JSONObject) obj3.get("data");
				// making JSONArray of rows
				JSONArray rowarray = (JSONArray) dataobject.get("rows");
				// storing row JSONArray size into temp1
				rowarray.size();//

				// reading rows JSONArray
				for (int i = 0; i < rowarray.size(); i++) {
					// getting first object and converting into JSONObject
					JSONObject rowobject = (JSONObject) rowarray.get(i);

					// making metrics JSONArray
					JSONArray metricarray = (JSONArray) rowobject.get("metrics");
					// storing metric JSONArray size into temp2
					responseModelObject.setRowArraySize(metricarray.size());
					// iterating metric JSONArray
					for (int k = 0; k < metricarray.size(); k++) {
						// getting first object and converting into JSONObject
						JSONObject metricobject = (JSONObject) metricarray.get(k);
						// making values JSONArray
						JSONArray valuesarray = (JSONArray) metricobject.get("values");
						responseModelObject.setMetricArraySize(valuesarray.size()); //

						if (responseModelObject.getMetricArraySize() == 1) {
							// converting JSONArray into JSONString
							String valuestring = JSONArray.toJSONString(valuesarray);
							// making subString
							valuestring = valuestring.substring(valuestring.indexOf("[") + 2,
									valuestring.indexOf("]") - 1);
							// adding into value1 ArrayList
							metricResponseArrayList.add(valuestring);
						} else {
							for (int l1 = 0; l1 < valuesarray.size(); l1++) {
								// System.out.println( valuesarray.get(l1));
								metricResponseArrayList.add((String) valuesarray.get(l1));
							}
						}
					}
					responseModelObject.setMetricResponse(metricResponseArrayList);

					// casting into dimensions JSONArray
					JSONArray dimensionsarray = (JSONArray) rowobject.get("dimensions");
					// taking size of dimension array
					responseModelObject.setDimensionArraySize(dimensionsarray.size());

					for (int l = 0; l < dimensionsarray.size(); l++) {
						// adding into ArrayList
						dimensionResponseArrayList.add((String) dimensionsarray.get(l));
					}

					responseModelObject.setDimensionResponse(dimensionResponseArrayList);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}