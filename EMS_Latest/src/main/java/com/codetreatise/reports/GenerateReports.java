package com.codetreatise.reports;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;

public class GenerateReports {
	
	public static void main(String[] args) {
		GenerateReports p = new GenerateReports();
		p.GenerateReport();
	}
	
	public void GenerateReport(){
	            Connection conn = null;
	            //https://bitbucket.org/xerial/sqlite-jdbc/downloads
	            try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
	            try {
					conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/javafx","root","root@123");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	     
	try {
//		JasperReport jasperReport = JasperCompileManager.compileReport("C:\\Users\\MaheshPC\\Desktop\\EMSReport.jrxml");
//		JRDataSource datasource = new JREmptyDataSource();
//		Map<String,Object> parameters = new HashMap<>();
//		parameters.put("Staff ID", "A12563");
//		parameters.put("Staff Name", "Mahesh");
//		parameters.put("Batch", "CSE");
//		parameters.put("Designation", "SSE");
//		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,datasource);
//		JasperExportManager.exportReportToPdfFile(jasperPrint,"C:\\Users\\MaheshPC\\Desktop\\Songs_Birthday\\1.pdf");
		 JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\MaheshPC\\Desktop\\EMSReport.jrxml");
         String query = "select * from employee order by staff_name";
         JRDesignQuery jrquery = new JRDesignQuery();
         jrquery.setText(query);
         jasperDesign.setQuery(jrquery);
         
         JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
         JasperPrint JasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);
         JasperExportManager.exportReportToPdfFile(JasperPrint,"C:\\Users\\MaheshPC\\Desktop\\Songs_Birthday\\1.pdf");
         JRViewer viewer = new JRViewer(JasperPrint);
         
         /*JasperReport jasperReport = JasperCompileManager.compileReport("C:\\Users\\RAM ALAPURE\\Documents\\NetBeansProjects\\User Info App\\src\\org\\ramalapure\\userinfoapp\\newReport.jrxml");
         JasperPrint JasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);
         JRViewer viewer = new JRViewer(JasperPrint);*/
         viewer.setOpaque(true);
         viewer.setVisible(true);
         
	} catch (JRException e) {
		e.printStackTrace();
	}
	}
}
