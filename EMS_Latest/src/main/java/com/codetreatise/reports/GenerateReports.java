package com.codetreatise.reports;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import com.mysql.jdbc.Connection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.FileResolver;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class GenerateReports {
	String pathOfFiles;

	public int GenerateReport(String query, int i) throws JRException, SQLException {
		Connection connect = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		try {
			connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/javafx", "root", "root@123");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		FileResolver fileResolver = new FileResolver() {
			
			@Override
			public File resolveFile(String fileName) {
				URI uri;
				try {
					uri = new URI(this.getClass().getResource("Etihad_Airways_logo.jpg").getPath());
					return new File(uri.getPath());
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
		};
		InputStream imgImage = this.getClass().getResourceAsStream("Etihad_Airways_logo.jpg");
		HashMap<String,Object> params = new HashMap<>();
		params.put("logo", imgImage);
		
		

		pathOfFiles = System.getProperty("user.dir");
		String ReportEmployeeStructurePathOfFile = pathOfFiles + "\\src\\main\\resources\\jrmxl\\EMSReport.jrxml";
		String ReportAreaOFWorkStructurePathOfFile = pathOfFiles + "\\src\\main\\resources\\jrmxl\\EMSAreaOfWork.jrxml";
		String ReportEmployeePathOfFile = pathOfFiles + "\\src\\main\\resources\\Reports\\StaffDetails.pdf";
		String ReportAreaofWorkPathOfFile = pathOfFiles + "\\src\\main\\resources\\Reports\\AreaOFWorkDetails.pdf";
//		String logo = pathOfFiles + "\\src\\main\\resources\\jrmxl\\Etihad_Airways_logo.jpg";
		if (i == 1) {
			try {
				JasperDesign jasperDesign = JRXmlLoader.load(ReportEmployeeStructurePathOfFile);
				JRDesignQuery jrquery = new JRDesignQuery();
				jrquery.setText(query);
				jasperDesign.setQuery(jrquery);
				JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
				JasperPrint JasperPrint = JasperFillManager.fillReport(jasperReport, null, connect);
				Path fileToDeletePath = Paths.get(ReportEmployeePathOfFile);
				try {
					Files.delete(fileToDeletePath);
				} catch (IOException e) {
					e.printStackTrace();
				}
				JasperExportManager.exportReportToPdfFile(JasperPrint, ReportEmployeePathOfFile);
			} catch (JRException e) {
				e.printStackTrace();
			}
		} else if (i == 2) {
			JasperDesign jasperDesign = JRXmlLoader.load(ReportAreaOFWorkStructurePathOfFile);
			JRDesignQuery jrquery = new JRDesignQuery();
			jrquery.setText(query);
			jasperDesign.setQuery(jrquery);
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			JasperPrint JasperPrint = JasperFillManager.fillReport(jasperReport, null, connect);
			Path fileToDeletePath = Paths.get(ReportAreaofWorkPathOfFile);
			try {
				Files.delete(fileToDeletePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
			JasperExportManager.exportReportToPdfFile(JasperPrint, ReportAreaofWorkPathOfFile);
		}
		return 0;
	}
}
