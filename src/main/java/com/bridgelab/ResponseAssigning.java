package com.bridgelab;

import java.util.ArrayList;

import com.bridgelab.model.GaReportInputModel;
import com.bridgelab.model.ResponseAssigningModel;
import com.bridgelab.model.ResponseModel;

public class ResponseAssigning {
	ResponseModel responseModelObject = new ResponseModel();
	GaReportInputModel gaReportInputModelObject = new GaReportInputModel();
	ResponseAssigningModel responseAssigningModelObject = new ResponseAssigningModel();
	String GaId = gaReportInputModelObject.getmGaID();
	String GaDiscription = gaReportInputModelObject.getmGaDiscription();
	int rowArraySize = responseModelObject.getRowArraySize();
	int dimensionArraySize = responseModelObject.getDimensionArraySize();
	int metricArraySize = responseModelObject.getMetricArraySize();
	ArrayList<String> metricArrayResponseList = responseModelObject.getMetricResponse();
	ArrayList<String> dimensionArrayResponseList = responseModelObject.getDimensionResponse();

	public void responseAssigning() {
		int k = 0, p = 0, c = 0;
		//	// if response Json having 3 dimensionvalue and 1 metricvalue 
		if (dimensionArraySize == 3) {
			for (int i = 0; i < rowArraySize; i++) {
				for (int j = 0; j < dimensionArraySize; j++) {
					if (k % 3 == 0) {
						responseAssigningModelObject.setmDate(dimensionArrayResponseList.get(k));

					}
					if (k % 3 == 1) {
						responseAssigningModelObject.setmAndroidId(dimensionArrayResponseList.get(k));
					}
					if (k % 3 == 2) {
						responseAssigningModelObject.setmConnectionType(dimensionArrayResponseList.get(k));
					}
					k++;
				}
				for (int m = 0; m < metricArraySize; m++) {

					responseAssigningModelObject.setmTotalEvents(metricArrayResponseList.get(p));

					p++;
				}

			}

		}
		// if response Json having 4 dimensionvalue and 2 metricvalue 
		else {
			if (metricArraySize == 4 && dimensionArraySize == 2) {
				for (int i = 0; i < rowArraySize; i++) {
					for (int j = 0; j < dimensionArraySize; j++) {
						if (k % 2 == 0) {
							responseAssigningModelObject.setmDate(dimensionArrayResponseList.get(k));

						}
						if (k % 2 == 1) {
							responseAssigningModelObject.setmAndroidId(dimensionArrayResponseList.get(k));
						}
						k++;
					}

					for (int m = 0; m < metricArraySize; m++) {
						if (p % 4 == 0) {
							responseAssigningModelObject.setmSessions(dimensionArrayResponseList.get(p));

						}
						if (p % 4 == 1) {
							responseAssigningModelObject.setmScreenViews(dimensionArrayResponseList.get(p));
							;

						}
						if (p % 4 == 2) {
							responseAssigningModelObject.setmExit(dimensionArrayResponseList.get(p));

						}
						if (p % 4 == 3) {
							responseAssigningModelObject.setmExitRate(dimensionArrayResponseList.get(p));

						}

					}
					p++;
				}

			} 
			// if response Json having 2 dimensionvalue and 1 metricvalue 
			else {
				if (dimensionArraySize == 2) {
					for (int i = 0; i < rowArraySize; i++) {
						for (int j = 0; j < dimensionArraySize; j++) {
							if (k % 2 == 0) {
								responseAssigningModelObject.setmDate(dimensionArrayResponseList.get(k));

							}
							if (k % 2 == 1) {
								responseAssigningModelObject.setmAndroidId(dimensionArrayResponseList.get(k));
							}
							k++;
						}
						for (int m = 0; m < metricArraySize; m++) {

							responseAssigningModelObject.setmTotalEvents(metricArrayResponseList.get(p));

							p++;
						}

					}

				}
			}

		}
	}

}
