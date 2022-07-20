package com.reports;

	import java.io.File;
	import java.util.ArrayList;
	import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;



	/**
	 * 
	 * @author Mei
	 *@Crat
	 */

	public class Reporting {
		public static void generateJVMReport(String jsonFile) {

			File file=new File(System.getProperty("user.dir")+"\\target");
			
			Configuration config= new Configuration(file, "OMRBranchAPIAutomation");
			
			config.addClassifications("OS", "Windows10");
			config.addClassifications("Browser", "Chrome");
			config.addClassifications("Version", "10");
			config.addClassifications("Sprint", "33");
			
			List<String> jsonfiles= new ArrayList<String>();
			jsonfiles.add(jsonFile);
			
			ReportBuilder builder= new ReportBuilder(jsonfiles, config);
			
			builder.generateReports();
			
			
		}

	}

