package org.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JvmReports {

	public static void generateJvmReport(String jsonpath) {

		// 1.Mention the target folder location
		File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Reports\\JvmReport");

		// 2.Add details to report ----configuration

		Configuration con = new Configuration(f, " Facebook web app");
		con.addClassifications("paltform name", "Windows 10");
		con.addClassifications("Browser name", "Chrome");
		con.addClassifications("Browser Version", "91.0");
		con.addClassifications("sprint number", "23");
		
		//3.String to List<string>
		List<String> list = new ArrayList<String>();
		list.add(jsonpath);
		
		
		
		//4.Create object for ReportBuilder class --- using which call generateReports
		ReportBuilder r = new ReportBuilder(list, con );
		r.generateReports();

	}

}
