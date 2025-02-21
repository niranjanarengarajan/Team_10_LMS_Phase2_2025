
/************************************
Data driven testing is implemented by 
reading Test Data from Excel file and 
using Fillo library for excel reading.

 ************************************/

package com.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.constants.EnvironmentConstants;

public class ExcelReader {

	// 1.Fillo properties
	Fillo fillo = new Fillo();
	Connection connection = null;
	Recordset recordset = null;

	// 2.Excel Queries

	public static String LOGIN_POSITIVE_QUERY = "SELECT * FROM LOGIN WHERE TYPE='VALID'";
	public static String LOGIN_NEGATIVE_QUERY = "SELECT * FROM LOGIN WHERE TYPE='INVALID'";

	public static String PROGRAM_POSITIVE_QUERY = "SELECT * FROM PROGRAM WHERE TYPE='VALID'";
	public static String PROGRAM_NEGATIVE_QUERY = "SELECT * FROM  PROGRAM WHERE TYPE='INVALID'";

	public static String BATCH_POSITIVE_QUERY = "SELECT * FROM BATCH WHERE TYPE='VALID'";
	public static String BATCH_NEGATIVE_QUERY = "SELECT * FROM  BATCH WHERE TYPE='INVALID'";

	public static String CLASS_POSITIVE_QUERY = "SELECT * FROM CLASS WHERE TYPE='VALID'";
	public static String CLASS_NEGATIVE_QUERY = "SELECT * FROM  CLASS WHERE TYPE='INVALID'";

	// 3.Get test data from Excel file based on Module and TestCase type
	public Map<String, String> getData(String TestCase_Type, String Module) throws FileNotFoundException, IOException {

		Map<String, String> testData = new LinkedHashMap<>();
		try {
			connection = fillo.getConnection(EnvironmentConstants.EXCEL_FILE_PATH);

			switch (Module) {
			case "Login":
				if (TestCase_Type == "Positive") {
					recordset = connection.executeQuery(LOGIN_POSITIVE_QUERY);
				} else {
					recordset = connection.executeQuery(LOGIN_NEGATIVE_QUERY);
				}
				break;
			case "Program":
				if (TestCase_Type == "Positive") {

					recordset = connection.executeQuery(PROGRAM_POSITIVE_QUERY);

				} else {
					recordset = connection.executeQuery(PROGRAM_NEGATIVE_QUERY);
				}
				break;
			case "Batch":

				if (TestCase_Type == "Positive") {
					recordset = connection.executeQuery(BATCH_POSITIVE_QUERY);
				} else {
					recordset = connection.executeQuery(BATCH_NEGATIVE_QUERY);
				}
				break;
			case "Class":
				if (TestCase_Type == "Positive") {
					recordset = connection.executeQuery(CLASS_POSITIVE_QUERY);
				} else {
					recordset = connection.executeQuery(CLASS_NEGATIVE_QUERY);
				}
				break;

			}

			while (recordset.next()) {

				for (String field : recordset.getFieldNames()) {
					testData.put(field, recordset.getField(field));
				}

			}
		} catch (FilloException exception) {
			exception.printStackTrace();
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (recordset != null) {
				recordset.close();
			}

		}

		return testData;
	}

	@Test
	public void DataDrivenTesting() {

		Map<String, String> testData;
		try {
			testData = getData("Negative", "Program");

			// System.out.println("testdata is "+testData.get("USER"));
			// System.out.println("testdata is "+testData.get("PASSWORD"));
			System.out.println("testdata is " + testData.get("PROGRAM_NAME"));
			// System.out.println("testdata is " + testData.get("BPROGRAM_NAME"));

			// System.out.println("testdata is "+testData.get("CBATCH_NAME"));

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
