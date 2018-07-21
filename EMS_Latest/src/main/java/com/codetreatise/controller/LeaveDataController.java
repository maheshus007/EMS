package com.codetreatise.controller;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import com.codetreatise.bean.AreaOfWork;
import com.codetreatise.bean.Employee;
import com.codetreatise.bean.LeaveData;
import com.codetreatise.config.StageManager;
import com.codetreatise.service.AreaOfWorkService;
import com.codetreatise.service.EmployeeService;
import com.codetreatise.view.FxmlView;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import javafx.util.StringConverter;

@Controller
public class LeaveDataController implements Initializable {

	@FXML
	private Label employeeId;

	@FXML
	private TextField staffID;

	@FXML
	private TextField staffName;

	@FXML
	private DatePicker fromDate;

	@FXML
	private DatePicker toDate;

	@FXML
	private TextField totalLeaveTaken;

	@FXML
	private TextField balanceLeave;

	@FXML
	private TextField approverName;

	@FXML
	private DatePicker fromDate1;

	@FXML
	private TextField shift;

	@FXML
	private ComboBox<String> typeOfLeave;

	@FXML
	private ComboBox<String> approveReject;

	@FXML
	private Button reset;

	@FXML
	private Button saveLeaveData;

	@FXML
	private Button searchLeaveData;

	@FXML
	private BorderPane boarderPane;

	@FXML
	private TableView<LeaveData> leaveTable;

	@FXML
	private TableColumn<LeaveData, String> colEdit;

	@FXML
	private TableColumn<LeaveData, String> colstaffID;

	@FXML
	private TableColumn<LeaveData, String> staffNameCol;

	@FXML
	private TableColumn<LeaveData, String> fromDateCol;

	@FXML
	private TableColumn<LeaveData, String> toDateCol;

	@FXML
	private TableColumn<LeaveData, String> shoftCol;

	@FXML
	private TableColumn<LeaveData, String> totalLeaveTakenCol;

	@FXML
	private TableColumn<LeaveData, String> balanceLeaveCol;

	@FXML
	private TableColumn<LeaveData, String> approverNameCol;

	@FXML
	private TableColumn<LeaveData, String> approvedDateCol;

	@FXML
	private TableColumn<LeaveData, String> leaveTypeCol;

	@FXML
	private TableColumn<LeaveData, String> leaveApprovedYNCol;

	@FXML
	private MenuItem deleteEmployees;

	@FXML
	void deleteLeaveData(ActionEvent event) {

	}

	@FXML
	void saveLeaveData(ActionEvent event) {

	}

	@FXML
	void searchLeaveData(ActionEvent event) {

	}

	@Lazy
	@Autowired
	private StageManager stageManager;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private AreaOfWorkService areaService;

	private ObservableList<LeaveData> leaveList = FXCollections.observableArrayList();
	private ObservableList<String> TypeOfLeaveDropDown = FXCollections.observableArrayList("Annual Leave",
			"Emergency Leave", "Exam Leave", "Medical Leave", "Sick Leave", "University Leave");
	private ObservableList<String> ApprovalDropDown = FXCollections.observableArrayList("Approve", "Reject");

	@FXML
	private void exit(ActionEvent event) {
		stageManager.switchScene(FxmlView.EMPLOYEE);
	}

	/**
	 * Logout and go to the login page
	 */
	@FXML
	private void logout(ActionEvent event) throws IOException {
		stageManager.switchScene(FxmlView.LOGIN);
	}

	@FXML
	void reset(ActionEvent event) {
		clearFields();
		loadEmployeeDetails();
	}

	@FXML
	private void searchEmployee(ActionEvent event) {
		Employee employee = new Employee();
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Validation Error");
		alert.setHeaderText(null);

		if (!staffID.getText().isEmpty()) {
			employee = employeeService.findById(((staffID.getText())));
			if (staffID.getText().equals(employee.getStaffid())) {
				loadBySearch(staffID.getText());

			}
		}

		else if (!staffName.getText().isEmpty()) {
			List<Employee> p = employeeService.findByName(((staffName.getText())));
			leaveList.clear();
			for (Employee n : p) {
				if (staffName.getText().equals(n.getStaffName())) {
					leaveList.addAll(n);
					leaveTable.setItems(employeeList);
				}
			}
		}
		//
		// else if (areaOfWork.getSelectionModel().getSelectedItem() != null) {
		// String text = areaOfWork.getSelectionModel().getSelectedItem();
		// List<Employee> p = employeeService.findByAreaOfWork(text);
		// employeeList.clear();
		// for (Employee n : p) {
		// if (text.equals(n.getAreaofwork())) {
		// employeeList.addAll(n);
		// employeeTable.setItems(employeeList);
		// }
		// }
		// } else if (!uaeId.getText().isEmpty()) {
		// String text = uaeId.getText();
		// List<Employee> p = employeeService.findByUAEID(text);
		// employeeList.clear();
		// for (Employee n : p) {
		// if (text.equals(n.getUaeid())) {
		// employeeList.addAll(n);
		// employeeTable.setItems(employeeList);
		// }
		// }
		// } else if (lineManager.getSelectionModel().getSelectedItem() != null)
		// {
		// String text = lineManager.getSelectionModel().getSelectedItem();
		// List<Employee> p = employeeService.findByLineManager(text);
		// employeeList.clear();
		// for (Employee n : p) {
		// if (text.equals(n.getLinemanager())) {
		// employeeList.addAll(n);
		// employeeTable.setItems(employeeList);
		// }
		// }
		// }else if (!email.getText().isEmpty()) {
		// List<Employee> p = employeeService.findByEmail(((email.getText())));
		// employeeList.clear();
		// for (Employee n : p) {
		// if (email.getText().equals(n.getEmail())) {
		// employeeList.addAll(n);
		// employeeTable.setItems(employeeList);
		// }
		// }
		// }else if (!contact.getText().isEmpty()) {
		// List<Employee> p =
		// employeeService.findByContact(((contact.getText())));
		// employeeList.clear();
		// for (Employee n : p) {
		// if (contact.getText().equals(n.getContact())) {
		// employeeList.addAll(n);
		// employeeTable.setItems(employeeList);
		// }
		// }
		// }else if (!batch.getText().isEmpty()) {
		// List<Employee> p = employeeService.findByBatch(((batch.getText())));
		// employeeList.clear();
		// for (Employee n : p) {
		// if (batch.getText().equals(n.getBatch())) {
		// employeeList.addAll(n);
		// employeeTable.setItems(employeeList);
		// }
		// }
		// }else if (!designation.getText().isEmpty()) {
		// List<Employee> p =
		// employeeService.findByDesignation(((designation.getText())));
		// employeeList.clear();
		// for (Employee n : p) {
		// if (designation.getText().equals(n.getDesignation())) {
		// employeeList.addAll(n);
		// employeeTable.setItems(employeeList);
		// }
		// }
		// }else if (!department.getText().isEmpty()) {
		// List<Employee> p =
		// employeeService.findByDepartment(((department.getText())));
		// employeeList.clear();
		// for (Employee n : p) {
		// if (department.getText().equals(n.getDepartment())) {
		// employeeList.addAll(n);
		// employeeTable.setItems(employeeList);
		// }
		// }
		// }else if (nsStatus.getSelectionModel().getSelectedItem() != null) {
		// String text = nsStatus.getSelectionModel().getSelectedItem();
		// List<Employee> p = employeeService.findByNsStatus(text);
		// employeeList.clear();
		// for (Employee n : p) {
		// if (text.equals(n.getNSstatus())) {
		// employeeList.addAll(n);
		// employeeTable.setItems(employeeList);
		// }
		// }
		// }else if (!ojtStartDate.getEditor().getText().isEmpty()) {
		// Date text = null;
		// try {
		// text = (Date) new
		// SimpleDateFormat("dd/MM/yyyy").parse(ojtStartDate.getEditor().getText());
		// } catch (ParseException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// List<Employee> p = employeeService.findByOjtStart(text);
		// employeeList.clear();
		// for (Employee n : p) {
		// if (text.equals(n.getOjtstartdate())) {
		// employeeList.addAll(n);
		// employeeTable.setItems(employeeList);
		// }
		// }
		// }

	}

	private void loadBySearch(String string) {
		// employeeList.clear();
		// employeeList.addAll(employeeService.findById(string));
		// employeeTable.setItems(employeeList);
	}

	@FXML
	private void saveEmployee(ActionEvent event) {
		// Employee employee = new Employee();
		// if (emptyValidation("Staff Id", staffID.getText().isEmpty())
		// && validate("Staff Name", getstaffName(), "^[\\p{L} .'-]+$")
		// && emptyValidation("Nationality",
		// nationality.getText().isEmpty())
		// && emptyValidation("Email", email.getText().isEmpty())
		// && emptyValidation("DOB",
		// dob.getEditor().getText().isEmpty())
		// && emptyValidation("OJT Start Date",
		// ojtStartDate.getEditor().getText().isEmpty())
		// && emptyValidation("OJT End Date",
		// ojtEndDate.getEditor().getText().isEmpty())
		// && emptyValidation("Line Manager", getLineManager() == null)
		// && emptyValidation("Major", getmajor() == null)
		// && emptyValidation("Batch", batch.getText().isEmpty())
		// ) {
		// System.out.println("employeeId.getText():" + employeeId.getText());
		// // Employee employee2 = employeeService.find2((staffID.getText()));
		// if (employeeId.getText() == null || employeeId.getText().isEmpty()) {
		// if (validate("Email", getEmail(),
		// "[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+")) {
		// updateDB(employee);
		// Employee newEmployee = employeeService.save(employee);
		// saveAlert(newEmployee);
		// }
		//
		// } else {
		// employee =
		// employeeService.find(Integer.parseInt((employeeId.getText())));
		// updateDB(employee);
		// Employee updatedemployee = employeeService.update(employee);
		// updateAlert(updatedemployee);
		// }
		//
		// clearFields();
		// loadEmployeeDetails();
		// }
		//
		// }
		//
		// @FXML
		// void clickAreaOfWork(ActionEvent event) {
		// areaOfWorkList.clear();
		// stageManager.switchScene(FxmlView.AOW);
		// areaOfWorkList.addAll(areaService.findAll());
		// try {
		// areaOfWorkTable.setItems(areaOfWorkList);
		// } catch (Exception e) {
		// System.out.println(e + "Empty Data in AreaOfWork table");
		// }
		// areaOfWorkTableCol.setCellValueFactory(new
		// PropertyValueFactory<>("areaOfWork"));
		// noOfStaffCol.setCellValueFactory(new
		// PropertyValueFactory<>("count"));

	}

	@FXML
	private void backArea(ActionEvent event) throws IOException {
		stageManager.switchScene(FxmlView.EMPLOYEE);
	}

	private Employee updateDB(Employee employee) {
		// employee.setStaffid(getStaffId());
		// employee.setStaffName(getstaffName());
		// employee.setUaeid(getUaeid());
		// employee.setBatch(getBatch());
		// employee.setPlaceofbirth(getPlaceofbirth());
		// employee.setDesignation(getDesignation());
		// employee.setStaffgrade(getStaffgrade());
		// employee.setNationality(getNationality());
		// employee.setDepartment(getDepartment());
		// employee.setContact(getContact());
		// employee.setAcademicqualification(getAcademicqualification());
		// employee.setPassport(getPassport());
		// employee.setPlaceofbirth(getPlaceofbirth());
		// employee.setStaffgrade(getStaffgrade());
		// employee.setAcademicqualification(getAcademicqualification());
		// employee.setDrivinglicense(getDrivinglicense());
		// employee.setLinemanager(getLineManager());
		// employee.setAreaofwork(getAreaOfWork());
		// employee.set_300hrs(getThreeHundredHrs());
		// employee.setCollegemodules(getCollegeModules());
		// employee.setLogbook(getLogBook());
		// employee.setMajor(getmajor());
		// employee.setWorkinghrs(getworkingHrs());
		// employee.setNSstatus(getNsStatus());
		// employee.setSpecifymodules(getSpecifyModules());
		// employee.setDob(getDob());
		// employee.setDoj(getDoj());
		// employee.setOjtstartdate(getOjtStartDate());
		// employee.setOjtenddate(getOjtEndDate());
		// employee.setNSstartdate(getNsStartDate());
		// employee.setNSenddate(getNsEndDate());
		// employee.setEmail(getEmail());
		// if (basicLicense.isSelected()) {
		// employee.setBasicLicense("Yes");
		// } else {
		// employee.setBasicLicense("No");
		// }
		// if (l3CourseType.isSelected()) {
		// employee.setL3CourseType("Yes");
		// } else {
		// employee.setL3CourseType("No");
		// }
		// if (a380Project.isSelected()) {
		// employee.setA380Project("Yes");
		// } else {
		// employee.setA380Project("No");
		// }
		// if (rfidProjectMember.isSelected()) {
		// employee.setRfidProjectMember("Yes");
		// } else {
		// employee.setRfidProjectMember("No");
		// }
		// if (engineChangeProject.isSelected()) {
		// employee.setEngineChangeProject("Yes");
		// } else {
		// employee.setEngineChangeProject("No");
		// }
		// if (corCertificate.isSelected()) {
		// employee.setCorCertificate("Yes");
		// } else {
		// employee.setCorCertificate("No");
		// }
		return null;

	}

	@FXML
	private void deleteEmployees(ActionEvent event) {
		// List<Employee> employees =
		// employeeTable.getSelectionModel().getSelectedItems();
		//
		// Alert alert = new Alert(AlertType.CONFIRMATION);
		// alert.setTitle("Confirmation Dialog");
		// alert.setHeaderText(null);
		// alert.setContentText("Are you sure you want to delete selected?");
		// Optional<ButtonType> action = alert.showAndWait();
		//
		// if (action.get() == ButtonType.OK)
		// employeeService.deleteInBatch(employees);
		//
		// loadEmployeeDetails();
	}

	private void clearFields() {
		// employeeId.setText(null);
		// staffID.clear();
		// staffName.clear();
		// dob.getEditor().clear();
		// doj.getEditor().clear();
		// ojtStartDate.getEditor().clear();
		// ojtEndDate.getEditor().clear();
		// nsStartDate.getEditor().clear();
		// nsEndDate.getEditor().clear();
		// uaeId.clear();
		// batch.clear();
		// placeOfBirth.clear();
		// designation.clear();
		// staffGrade.clear();
		// nationality.clear();
		// department.clear();
		// academicQualification.clear();
		// passport.clear();
		// drivingLicense.clear();
		// contact.clear();
		// noOfLeavesTaken.clear();
		// balanceNoOfLeaves.clear();
		// areaOfWork.getSelectionModel().clearSelection();
		// email.clear();
		// nsStatus.getSelectionModel().clearSelection();
		// threeHundredHrs.getSelectionModel().clearSelection();
		// logBook.getSelectionModel().clearSelection();
		// major.getSelectionModel().clearSelection();
		// lineManager.getSelectionModel().clearSelection();
		// workingHrs.getSelectionModel().clearSelection();
		// collegeModules.getSelectionModel().clearSelection();
		// specifyModulesNotCompleted.clear();
		// basicLicense.setSelected(false);
		// l3CourseType.setSelected(false);
		// a380Project.setSelected(false);
		// rfidProjectMember.setSelected(false);
		// engineChangeProject.setSelected(false);
		// corCertificate.setSelected(false);
	}

	private void saveAlert(Employee employee) {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Employee saved successfully.");
		alert.setHeaderText(null);
		alert.setContentText("The employee " + employee.getStaffName() + " " + " has been created and \n" + " id is "
				+ employee.getStaffid() + ".");
		alert.showAndWait();
	}

	private void updateAlert(Employee employee) {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("employee updated successfully.");
		alert.setHeaderText(null);
		alert.setContentText("The employee " + employee.getStaffName() + " " + " has been updated.");
		alert.showAndWait();
	}

	// public String getEmployeeId() {
	// return employeeId.getText();
	// }
	//
	// public String getStaffId() {
	// return staffID.getText();
	// }
	//
	// public String getstaffName() {
	// return staffName.getText();
	// }
	//
	// public String getUaeid() {
	// return uaeId.getText();
	// }
	//
	// public String getBatch() {
	// return batch.getText();
	// }
	//
	// public String getContact() {
	// return contact.getText();
	// }
	//
	// public String getPlaceofbirth() {
	// return placeOfBirth.getText();
	// }
	//
	// public String getDesignation() {
	// return designation.getText();
	// }
	//
	// public String getStaffgrade() {
	// return staffGrade.getText();
	// }
	//
	// public String getNationality() {
	// return nationality.getText();
	// }
	//
	// public String getDepartment() {
	// return department.getText();
	// }
	//
	// public String getAcademicqualification() {
	// return academicQualification.getText();
	// }
	//
	// public String getPassport() {
	// return passport.getText();
	// }
	//
	// public String getDrivinglicense() {
	// return drivingLicense.getText();
	// }
	//
	// public LocalDate getDob() {
	// return dob.getValue();
	// }
	//
	// public LocalDate getDoj() {
	// return doj.getValue();
	// }
	//
	// public LocalDate getOjtStartDate() {
	// return ojtStartDate.getValue();
	// }
	//
	// public LocalDate getOjtEndDate() {
	// return ojtEndDate.getValue();
	// }
	//
	// public LocalDate getNsStartDate() {
	// return nsStartDate.getValue();
	// }
	//
	// public LocalDate getNsEndDate() {
	// return nsEndDate.getValue();
	// }
	//
	// public String getEmail() {
	// return email.getText();
	// }
	//
	// public String getLineManager() {
	// return lineManager.getSelectionModel().getSelectedItem();
	// }
	//
	// public String getAreaOfWork() {
	// return areaOfWork.getSelectionModel().getSelectedItem();
	// }
	//
	// public String getNsStatus() {
	// return nsStatus.getSelectionModel().getSelectedItem();
	// }
	//
	// public String getThreeHundredHrs() {
	// return threeHundredHrs.getSelectionModel().getSelectedItem();
	// }
	//
	// public String getCollegeModules() {
	// return collegeModules.getSelectionModel().getSelectedItem();
	// }
	//
	// public String getworkingHrs() {
	// return workingHrs.getSelectionModel().getSelectedItem();
	// }
	//
	// public String getmajor() {
	// return major.getSelectionModel().getSelectedItem();
	// }
	//
	// public String getLogBook() {
	// return logBook.getSelectionModel().getSelectedItem();
	// }
	//
	// public String getSpecifyModules() {
	// return specifyModulesNotCompleted.getText();
	// }
	//
	// public String getL3CourseType() {
	// return l3CourseType.getText();
	// }
	//
	// public String getA830Project() {
	// return a380Project.getText();
	// }
	//
	// public String getRfidProjectMember() {
	// return rfidProjectMember.getText();
	// }
	//
	// public String getEngineChangeProject() {
	// return engineChangeProject.getText();
	// }
	//
	// public String getCorCertificate() {
	// return corCertificate.getText();
	// }

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		approveReject.setItems(ApprovalDropDown);
		typeOfLeave.setItems(TypeOfLeaveDropDown);

		// employeeTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		//
		// setColumnProperties();
		//
		// // Add all employees into table
		// loadEmployeeDetails();
	}

	/*
	 * Set All employeeTable column properties
	 */
	private void setColumnProperties() {
		// // Override date format in table
		// colDOB.setCellFactory(TextFieldTableCell.forTableColumn(new
		// StringConverter<LocalDate>() {
		// String pattern = "dd/MM/yyyy";
		// DateTimeFormatter dateFormatter =
		// DateTimeFormatter.ofPattern(pattern);
		//
		// @Override
		// public String toString(LocalDate date) {
		// if (date != null) {
		// return dateFormatter.format(date);
		// } else {
		// return "";
		// }
		// }
		//
		// @Override
		// public LocalDate fromString(String string) {
		// if (string != null && !string.isEmpty()) {
		// return LocalDate.parse(string, dateFormatter);
		// } else {
		// return null;
		// }
		// }
		// }));
		//
		// ScrollPane sp = new ScrollPane();
		// sp.setContent(employeeTable);
		// sp.setPrefSize(1050, 600);
		// sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		// sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		// boarderPane.setRight(sp);
		// BorderPane.setMargin(sp, new Insets(0, 0, 10, 10));
		//
		// colstaffID.setCellValueFactory(new
		// PropertyValueFactory<>("staffid"));
		// staffNameCol.setCellValueFactory(new
		// PropertyValueFactory<>("staffName"));
		// uaeIdCol.setCellValueFactory(new PropertyValueFactory<>("uaeid"));
		// colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
		// batchCol.setCellValueFactory(new PropertyValueFactory<>("batch"));
		// grade.setCellValueFactory(new PropertyValueFactory<>("staffgrade"));
		// nationalityCol.setCellValueFactory(new
		// PropertyValueFactory<>("nationality"));
		// colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		// colDOJ.setCellValueFactory(new PropertyValueFactory<>("doj"));
		// departmentCol.setCellValueFactory(new
		// PropertyValueFactory<>("department"));
		// contactCol.setCellValueFactory(new
		// PropertyValueFactory<>("contact"));
		// designationCol.setCellValueFactory(new
		// PropertyValueFactory<>("designation"));
		// nsStatusCol.setCellValueFactory(new
		// PropertyValueFactory<>("NSstatus"));
		// nsEndDateCol.setCellValueFactory(new
		// PropertyValueFactory<>("NS_end_date"));
		// nsStartDateCol.setCellValueFactory(new
		// PropertyValueFactory<>("NSstartdate"));
		// areaOfWorkCol.setCellValueFactory(new
		// PropertyValueFactory<>("areaofwork"));
		// placeOfBirthCol.setCellValueFactory(new
		// PropertyValueFactory<>("placeofbirth"));
		// academicCol.setCellValueFactory(new
		// PropertyValueFactory<>("academicqualification"));
		// passportCol.setCellValueFactory(new
		// PropertyValueFactory<>("passport"));
		// drivingLicenseCol.setCellValueFactory(new
		// PropertyValueFactory<>("drivinglicense"));
		// ojtStartDateCol.setCellValueFactory(new
		// PropertyValueFactory<>("ojtstartdate"));
		// ojtEndDateCol.setCellValueFactory(new
		// PropertyValueFactory<>("ojtenddate"));
		// threeHundredCol.setCellValueFactory(new
		// PropertyValueFactory<>("_300hrs"));
		// logBookCol.setCellValueFactory(new
		// PropertyValueFactory<>("logbook"));
		// majorCol.setCellValueFactory(new PropertyValueFactory<>("major"));
		// lineOfManagerCol.setCellValueFactory(new
		// PropertyValueFactory<>("linemanager"));
		// workingHrsCol.setCellValueFactory(new
		// PropertyValueFactory<>("workinghrs"));
		// collegeModulesCol.setCellValueFactory(new
		// PropertyValueFactory<>("collegemodules"));
		// specifyModulesCol.setCellValueFactory(new
		// PropertyValueFactory<>("specifymodules"));
		// basicLicenseCol.setCellValueFactory(new
		// PropertyValueFactory<>("basicLicense"));
		// l3CourseTypeCol.setCellValueFactory(new
		// PropertyValueFactory<>("l3CourseType"));
		// A380ProjectCol.setCellValueFactory(new
		// PropertyValueFactory<>("a380Project"));
		// rfidProjectMemberCol.setCellValueFactory(new
		// PropertyValueFactory<>("rfidProjectMember"));
		// engineChangeProjectCol.setCellValueFactory(new
		// PropertyValueFactory<>("engineChangeProject"));
		// cORCertificateCol.setCellValueFactory(new
		// PropertyValueFactory<>("corCertificate"));
		//
		// colEdit.setCellFactory(cellFactory);
	}

	// Callback<TableColumn<Employee, Boolean>, TableCell<Employee, Boolean>>
	// cellFactory = new Callback<TableColumn<Employee, Boolean>,
	// TableCell<Employee, Boolean>>() {
	// @Override
	// public TableCell<Employee, Boolean> call(final TableColumn<Employee,
	// Boolean> param) {
	// final TableCell<Employee, Boolean> cell = new TableCell<Employee,
	// Boolean>() {
	// Image imgEdit = new
	// Image(getClass().getResourceAsStream("/images/edit.png"));
	// final Button btnEdit = new Button();
	//
	// @Override
	// public void updateItem(Boolean check, boolean empty) {
	// super.updateItem(check, empty);
	// if (empty) {
	// setGraphic(null);
	// setText(null);
	// } else {
	// btnEdit.setOnAction(e -> {
	// Employee employee = getTableView().getItems().get(getIndex());
	// updateEmployee(employee);
	// });
	//
	// btnEdit.setStyle("-fx-background-color: transparent;");
	// ImageView iv = new ImageView();
	// iv.setImage(imgEdit);
	// iv.setPreserveRatio(true);
	// iv.setSmooth(true);
	// iv.setCache(true);
	// btnEdit.setGraphic(iv);
	//
	// setGraphic(btnEdit);
	// setAlignment(Pos.CENTER);
	// setText(null);
	// employeeId.setVisible(false);
	// }
	// }
	//
	// private void updateEmployee(Employee employee) {
	// employeeId.setText(Integer.toString(employee.getId()));
	// staffID.setText((employee.getStaffid()));
	// staffName.setText(employee.getStaffName());
	// uaeId.setText(employee.getUaeid());
	// dob.setValue(employee.getDob());
	// batch.setText(employee.getBatch());
	// doj.setValue(employee.getDoj());
	// ojtStartDate.setValue(employee.getOjtstartdate());
	// ojtEndDate.setValue(employee.getOjtenddate());
	// nsStartDate.setValue(employee.getNSstartdate());
	// nsEndDate.setValue(employee.getNS_end_date());
	// placeOfBirth.setText(employee.getPlaceofbirth());
	// designation.setText(employee.getDesignation());
	// staffGrade.setText(employee.getStaffgrade());
	// nationality.setText(employee.getNationality());
	// department.setText(employee.getDepartment());
	// academicQualification.setText(employee.getAcademicqualification());
	// passport.setText(employee.getPassport());
	// drivingLicense.setText(employee.getDrivinglicense());
	// contact.setText(employee.getContact());
	// email.setText(employee.getEmail());
	// // noOfLeavesTaken.setText(employee.get);
	// // balanceNoOfLeaves.setText(employee.get);
	// areaOfWork.setValue(employee.getAreaofwork());
	// nsStatus.setValue(employee.getNSstatus());
	// threeHundredHrs.setValue(employee.get_300hrs());
	// logBook.setValue(employee.getLogbook());
	// major.setValue(employee.getMajor());
	// lineManager.setValue(employee.getLinemanager());
	// workingHrs.setValue(employee.getWorkinghrs());
	// collegeModules.setValue(employee.getCollegemodules());
	// specifyModulesNotCompleted.setText(employee.getSpecifymodules());
	// basicLicense.setSelected(Boolean.parseBoolean(employee.getBasicLicense1()));
	// l3CourseType.setSelected(Boolean.parseBoolean(employee.getL3CourseType1()));
	// a380Project.setSelected(Boolean.parseBoolean(employee.getA380Project1()));
	// rfidProjectMember.setSelected(Boolean.parseBoolean(employee.getRfidProjectMember1()));
	// engineChangeProject.setSelected(Boolean.parseBoolean(employee.getEngineChangeProject1()));
	// corCertificate.setSelected(Boolean.parseBoolean(employee.getCorCertificate1()));
	//
	// }
	// };
	// return cell;
	// }
	// };

	/*
	 * Add All employees to observable list and update table
	 */
	private void loadEmployeeDetails() {
		// employeeList.clear();
		// employeeList.addAll(employeeService.findAll());
		//
		// employeeTable.setItems(employeeList);
	}

	/*
	 * Validations
	 */
	private boolean validate(String field, String value, String pattern) {
		if (!value.isEmpty()) {
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(value);
			if (m.find() && m.group().equals(value)) {
				return true;
			} else {
				validationAlert(field, false);
				return false;
			}
		} else {
			validationAlert(field, true);
			return false;
		}
	}

	private boolean emptyValidation(String field, boolean empty) {
		if (!empty) {
			return true;
		} else {
			validationAlert(field, true);
			return false;
		}
	}

	private void validationAlert(String field, boolean empty) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Validation Error");
		alert.setHeaderText(null);
		if (field.equals("lineManager"))
			alert.setContentText("Please Select " + field);
		else if (field.equals("major"))
			alert.setContentText("Please Select " + field);
		else {
			if (empty)
				alert.setContentText("Please Enter " + field);
			else
				alert.setContentText("Please Enter Valid " + field);
		}
		alert.showAndWait();
	}
}
