package com.codetreatise.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.codetreatise.bean.Employee;
import com.codetreatise.config.StageManager;
import com.codetreatise.service.EmployeeService;
import com.codetreatise.view.FxmlView;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.util.StringConverter;

@Controller
public class EmployeeController implements Initializable {
	
	@FXML
	private TextField staffID;

	@FXML
	private TextField staffName;

	@FXML
	private TextField uaeId;

	@FXML
	private TextField batch;

	@FXML
	private TextField placeOfBirth;

	@FXML
	private TextField designation;

	@FXML
	private TextField staffGrade;

	@FXML
	private TextField nationality;

	@FXML
	private TextField department;

	@FXML
	private TextField academicQualification;

	@FXML
	private TextField email;

	@FXML
	private TextField passport;

	@FXML
	private TextField drivingLicense;

	@FXML
	private TextField contact;

	@FXML
	private TextField noOfLeavesTaken;

	@FXML
	private TextField balanceNoOfLeaves;

	@FXML
	private DatePicker dob;

	@FXML
	private DatePicker doj;

	@FXML
	private DatePicker ojtStartDate;

	@FXML
	private DatePicker ojtEndDate;

	@FXML
	private Button reset;

	@FXML
	private MenuItem deleteEmployees;

	@FXML
	private Button saveEmployee;

	@FXML
	private Button searchEmployee;

	@FXML
	private Button btnLogout1;

	@FXML
	private Button btnLogout11;

	@FXML
	private Button btnLogout12;

	@FXML
	private Button btnLogout13;

	@FXML
	private Button btnLogout131;

	@FXML
	private Button btnLogout;

	@FXML
	private TableView<Employee> employeeTable;
	
	@FXML
	private TableColumn<Employee, Long> colEmployeeId;

	@FXML
	private TableColumn<Employee, String> colstaffID;

	@FXML
	private TableColumn<Employee, String> staffNameCol;

	@FXML
	private TableColumn<Employee, String> uaeIdCol;

	@FXML
	private TableColumn<Employee, LocalDate> colDOB;
	
	@FXML
	private TableColumn<Employee, LocalDate> colDOJ;
	
	@FXML
	private TableColumn<Employee, LocalDate> colOjtStartDate;
	
	@FXML
	private TableColumn<Employee, LocalDate> colOjtEndDate;
	
	@FXML
	private TableColumn<Employee, LocalDate> colNsStartDate;
	
	@FXML
	private TableColumn<Employee, LocalDate> colNsEndDate;

	@FXML
	private TableColumn<Employee, String> batchCol;

	@FXML
	private TableColumn<Employee, String> grade;

	@FXML
	private TableColumn<Employee, String> colEmail;

	@FXML
	private TableColumn<Employee, String> nationalityCol;

	@FXML
	private TableColumn<Employee, Boolean> colEdit;

	@FXML
	private MenuItem deleteemployees;

	@FXML
	private ComboBox<String> areaOfWork;

	@FXML
	private ComboBox<String> nsStatus;

	@FXML
	private ComboBox<String> threeHundredHrs;

	@FXML
	private ComboBox<String> logBook;

	@FXML
	private ComboBox<String> major;

	@FXML
	private ComboBox<String> lineManager;

	@FXML
	private DatePicker nsStartDate;

	@FXML
	private DatePicker nsEndDate;

	@FXML
	private ComboBox<String> workingHrs;

	@FXML
	private ComboBox<String> collegeModules;

	@FXML
	private TextField specifyModulesNotCompleted;

	@FXML
	private CheckBox basicLicense;

	@FXML
	private CheckBox l3CourseType;

	@FXML
	private CheckBox a380Project;

	@FXML
	private CheckBox rfidProjectMember;

	@FXML
	private CheckBox engineChangeProject;

	@FXML
	private CheckBox corCertificate;

	@Lazy
	@Autowired
	private StageManager stageManager;

	@Autowired
	private EmployeeService employeeService;

	private ObservableList<Employee> employeeList = FXCollections.observableArrayList();
	private ObservableList<String> areaOfWorkDropDown = FXCollections.observableArrayList("Light Maintenance",
			"Heavy Maintenance", "Line Maintenance", "On National Service", "Seconded to Business", "Others");
	private ObservableList<String> lineManagerDropDown = FXCollections.observableArrayList("Abdul Majeed Hassan Jeizan",
			"Amer Mohamed Banialnajjar", "Faisal Mohamed Al Mulla", "Hamad Al Ali", "Mahendra Lokug",
			"Mohammad Nour Aldin Saffi", "Mohammed Yousef", "Sameer Abdulkareem", "Selvakumar Murugadoss", "Others");
	private ObservableList<String> nsStatusDropDown = FXCollections.observableArrayList("Completed", "Not Completed");
	private ObservableList<String> threeHundredHrsDropDown = FXCollections.observableArrayList("Completed",
			"Not Completed");
	private ObservableList<String> collegeModulesDropDown = FXCollections.observableArrayList("Completed",
			"Not Completed");
	private ObservableList<String> workingHrsDropDown = FXCollections.observableArrayList("8Hrs", "12Hrs");
	private ObservableList<String> majorDropDown = FXCollections.observableArrayList("B1", "B2");
	private ObservableList<String> logBookDropDown = FXCollections.observableArrayList("Completed", "Not Completed");

	@FXML
	private void exit(ActionEvent event) {
		Platform.exit();
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
	}

	@FXML
	private void searchEmployee(ActionEvent event) {
	}

	@FXML
	private void saveEmployee(ActionEvent event) {


			if (staffID.getText() != null || staffID.getText() != "" || staffName.getText() == ""
					|| batch.getText() == "" || nationality.getText() == "" || email.getText() == "") {
				if (validate("Email", getEmail(), "[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+")) {

					Employee employee = new Employee();
					employee.setStaffid(getStaffId());
					employee.setStaffName(getstaffName());
					employee.setUaeid(getUaeid());
					employee.setBatch(getBatch());
					employee.setPlaceofbirth(getPlaceofbirth());
					employee.setDesignation(getDesignation());
					employee.setStaffgrade(getStaffgrade());
					employee.setNationality(getNationality());
					employee.setDepartment(getDepartment());
					employee.setContact(getContact());
					employee.setAcademicqualification(getAcademicqualification());
					employee.setPassport(getPassport());
					employee.setPlaceofbirth(getPlaceofbirth());
					employee.setStaffgrade(getStaffgrade());
					employee.setAcademicqualification(getAcademicqualification());
					employee.setDrivinglicense(getDrivinglicense());
					employee.setLinemanager(getLineManager());
					employee.setAreaofwork(getAreaOfWork());
					employee.set_300hrs(getThreeHundredHrs());
					employee.setCollegemodules(getCollegeModules());
					employee.setLogbook(getLogBook());
					employee.setMajor(getmajor());
					employee.setWorkinghrs(getworkingHrs());
					employee.setNSstatus(getNsStatus());
					employee.setSpecifymodules(getSpecifyModules());
					employee.setDob(getDob());
					employee.setDoj(getDoj());
					employee.setOjtstartdate(getOjtStartDate());
					employee.setOjtenddate(getOjtEndDate());
					employee.setNSstartdate(getNsStartDate());
					employee.setNSenddate(getNsEndDate());
					employee.setEmail(getEmail());
					if (basicLicense.isSelected()) {
						employee.setBasicLicense("true");
					} else {
						employee.setBasicLicense("F");
					}
					if (l3CourseType.isSelected()) {
						employee.setL3CourseType("true");
					} else {
						employee.setL3CourseType("F");
					}
					if (a380Project.isSelected()) {
						employee.setA380Project("true");
					} else {
						employee.setA380Project("F");
					}
					if (rfidProjectMember.isSelected()) {
						employee.setRfidProjectMember("true");
					} else {
						employee.setRfidProjectMember("F");
					}
					if (engineChangeProject.isSelected()) {
						employee.setEngineChangeProject("true");
					} else {
						employee.setEngineChangeProject("true");
					}
					if (corCertificate.isSelected()) {
						employee.setCorCertificate("true");
					} else {
						employee.setCorCertificate("F");
					}
					Employee newEmployee = employeeService.save(employee);

					saveAlert(newEmployee);
				}

			} else {
				Employee employee = employeeService.find(Long.parseLong(staffID.getText()));
				employee.setStaffName(getstaffName());
				employee.setDob(getDob());
				Employee updatedemployee = employeeService.update(employee);
				updateAlert(updatedemployee);
			}

			 clearFields();
			 loadEmployeeDetails();

	}

	@FXML
	private void deleteEmployees(ActionEvent event) {
		List<Employee> employees = employeeTable.getSelectionModel().getSelectedItems();

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Are you sure you want to delete selected?");
		Optional<ButtonType> action = alert.showAndWait();

		if (action.get() == ButtonType.OK)
			employeeService.deleteInBatch(employees);

		loadEmployeeDetails();
	}

	private void clearFields() {
		staffID.setText(null);
		staffName.clear();
		dob.getEditor().clear();
		doj.getEditor().clear();
		ojtStartDate.getEditor().clear();
		ojtEndDate.getEditor().clear();
		nsStartDate.getEditor().clear();
		nsEndDate.getEditor().clear();
		uaeId.clear();
		batch.clear();
		placeOfBirth.clear();
		designation.clear();
		staffGrade.clear();
		nationality.clear();
		department.clear();
		academicQualification.clear();
		passport.clear();
		drivingLicense.clear();
		contact.clear();
		noOfLeavesTaken.clear();
		balanceNoOfLeaves.clear();
		areaOfWork.getSelectionModel().clearSelection();
		email.clear();
		nsStatus.getSelectionModel().clearSelection();
		threeHundredHrs.getSelectionModel().clearSelection();
		logBook.getSelectionModel().clearSelection();
		major.getSelectionModel().clearSelection();
		lineManager.getSelectionModel().clearSelection();
		workingHrs.getSelectionModel().clearSelection();
		collegeModules.getSelectionModel().clearSelection();
		specifyModulesNotCompleted.clear();
		basicLicense.setSelected(false);
		l3CourseType.setSelected(false);
		a380Project.setSelected(false);
		rfidProjectMember.setSelected(false);
		engineChangeProject.setSelected(false);
		corCertificate.setSelected(false);
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

	public String getStaffId() {
		return staffID.getText();
	}

	public String getstaffName() {
		return staffName.getText();
	}

	public String getUaeid() {
		return uaeId.getText();
	}

	public String getBatch() {
		return batch.getText();
	}

	public String getContact() {
		return contact.getText();
	}

	public String getPlaceofbirth() {
		return placeOfBirth.getText();
	}

	public String getDesignation() {
		return designation.getText();
	}

	public String getStaffgrade() {
		return staffGrade.getText();
	}

	public String getNationality() {
		return nationality.getText();
	}

	public String getDepartment() {
		return department.getText();
	}

	public String getAcademicqualification() {
		return academicQualification.getText();
	}

	public String getPassport() {
		return passport.getText();
	}

	public String getDrivinglicense() {
		return drivingLicense.getText();
	}

	public LocalDate getDob() {
		return dob.getValue();
	}
	
	public LocalDate getDoj() {
		return doj.getValue();
	}
	
	public LocalDate getOjtStartDate() {
		return ojtStartDate.getValue();
	}
	
	public LocalDate getOjtEndDate() {
		return ojtEndDate.getValue();
	}
	
	public LocalDate getNsStartDate() {
		return nsStartDate.getValue();
	}
	
	public LocalDate getNsEndDate() {
		return nsEndDate.getValue();
	}

	public String getEmail() {
		return email.getText();
	}

	public String getLineManager() {
		return lineManager.getSelectionModel().getSelectedItem();
	}

	public String getAreaOfWork() {
		return areaOfWork.getSelectionModel().getSelectedItem();
	}

	public String getNsStatus() {
		return nsStatus.getSelectionModel().getSelectedItem();
	}

	public String getThreeHundredHrs() {
		return threeHundredHrs.getSelectionModel().getSelectedItem();
	}

	public String getCollegeModules() {
		return collegeModules.getSelectionModel().getSelectedItem();
	}

	public String getworkingHrs() {
		return workingHrs.getSelectionModel().getSelectedItem();
	}

	public String getmajor() {
		return major.getSelectionModel().getSelectedItem();
	}

	public String getLogBook() {
		return logBook.getSelectionModel().getSelectedItem();
	}

	public String getSpecifyModules() {
		return specifyModulesNotCompleted.getText();
	}

	public String getL3CourseType() {
		return l3CourseType.getText();
	}

	public String getA830Project() {
		return a380Project.getText();
	}

	public String getRfidProjectMember() {
		return rfidProjectMember.getText();
	}

	public String getEngineChangeProject() {
		return engineChangeProject.getText();
	}

	public String getCorCertificate() {
		return corCertificate.getText();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		areaOfWork.setItems(areaOfWorkDropDown);
		lineManager.setItems(lineManagerDropDown);
		nsStatus.setItems(nsStatusDropDown);
		threeHundredHrs.setItems(threeHundredHrsDropDown);
		collegeModules.setItems(collegeModulesDropDown);
		workingHrs.setItems(workingHrsDropDown);
		major.setItems(majorDropDown);
		logBook.setItems(logBookDropDown);

		employeeTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		setColumnProperties();

		// Add all employees into table
		 loadEmployeeDetails();
	}

	/*
	 * Set All employeeTable column properties
	 */
	private void setColumnProperties() {
//		Override date format in table
		 colDOB.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<LocalDate>() {
			 String pattern = "dd/MM/yyyy";
			 DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
		     @Override 
		     public String toString(LocalDate date) {
		         if (date != null) {
		             return dateFormatter.format(date);
		         } else {
		             return "";
		         }
		     }

		     @Override 
		     public LocalDate fromString(String string) {
		         if (string != null && !string.isEmpty()) {
		             return LocalDate.parse(string, dateFormatter);
		         } else {
		             return null;
		         }
		     }
		 }));
		
		 colstaffID.setCellValueFactory(new PropertyValueFactory<>("id"));
		 staffNameCol.setCellValueFactory(new PropertyValueFactory<>("staffName"));
		 uaeIdCol.setCellValueFactory(new PropertyValueFactory<>("uae_id"));
		 colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
		 batchCol.setCellValueFactory(new PropertyValueFactory<>("batch"));
		 grade.setCellValueFactory(new PropertyValueFactory<>("staffgrade"));
		 nationalityCol.setCellValueFactory(new PropertyValueFactory<>("nationality"));
		 colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		 colDOJ.setCellValueFactory(new PropertyValueFactory<>("doj"));
		 colEdit.setCellFactory(cellFactory);
	}

	Callback<TableColumn<Employee, Boolean>, TableCell<Employee, Boolean>> cellFactory = new Callback<TableColumn<Employee, Boolean>, TableCell<Employee, Boolean>>() {
		@Override
		public TableCell<Employee, Boolean> call(final TableColumn<Employee, Boolean> param) {
			final TableCell<Employee, Boolean> cell = new TableCell<Employee, Boolean>() {
				Image imgEdit = new Image(getClass().getResourceAsStream("/images/edit.png"));
				final Button btnEdit = new Button();

				@Override
				public void updateItem(Boolean check, boolean empty) {
					super.updateItem(check, empty);
					if (empty) {
						setGraphic(null);
						setText(null);
					} else {
						btnEdit.setOnAction(e -> {
							Employee employee = getTableView().getItems().get(getIndex());
							updateEmployee(employee);
						});

						btnEdit.setStyle("-fx-background-color: transparent;");
						ImageView iv = new ImageView();
						iv.setImage(imgEdit);
						iv.setPreserveRatio(true);
						iv.setSmooth(true);
						iv.setCache(true);
						btnEdit.setGraphic(iv);

						setGraphic(btnEdit);
						setAlignment(Pos.CENTER);
						setText(null);
						staffID.setEditable(false);
					}
				}

				private void updateEmployee(Employee employee) {
					 staffID.setText((employee.getStaffid()));
					 staffName.setText(employee.getStaffName());
					 uaeId.setText(employee.getUaeid());
					 dob.setValue(employee.getDob());
					 batch.setText(employee.getBatch());
					 doj.setValue(employee.getDoj());
					 ojtStartDate.setValue(employee.getOjtstartdate());
					 ojtEndDate.setValue(employee.getOjtenddate());
					 nsStartDate.setValue(employee.getNSstartdate());
					 nsEndDate.setValue(employee.getNS_end_date());
					 placeOfBirth.setText(employee.getPlaceofbirth());
					 designation.setText(employee.getDesignation());
					 staffGrade.setText(employee.getStaffgrade());
					 nationality.setText(employee.getNationality());
					 department.setText(employee.getDepartment());
					 academicQualification.setText(employee.getAcademicqualification());
					 passport.setText(employee.getPassport());
					 drivingLicense.setText(employee.getDrivinglicense());
					 contact.setText(employee.getContact());
					 email.setText(employee.getEmail());
//					 noOfLeavesTaken.setText(employee.get);
//					 balanceNoOfLeaves.setText(employee.get);
					 areaOfWork.setValue(employee.getAreaofwork());
					 nsStatus.setValue(employee.getNSstatus());
					 threeHundredHrs.setValue(employee.get_300hrs());
					 logBook.setValue(employee.getLogbook());
					 major.setValue(employee.getMajor());
					 lineManager.setValue(employee.getLinemanager());
					 workingHrs.setValue(employee.getWorkinghrs());
					 collegeModules.setValue(employee.getCollegemodules());
					 specifyModulesNotCompleted.setText(employee.getSpecifymodules());
					 basicLicense.setSelected(Boolean.parseBoolean(employee.getBasicLicense()));
					 l3CourseType.setSelected(Boolean.parseBoolean(employee.getL3CourseType()));
					 a380Project.setSelected(Boolean.parseBoolean(employee.getA380Project()));
					 rfidProjectMember.setSelected(Boolean.parseBoolean(employee.getRfidProjectMember()));
					 engineChangeProject.setSelected(Boolean.parseBoolean(employee.getEngineChangeProject()));
					 corCertificate.setSelected(Boolean.parseBoolean(employee.getCorCertificate()));
					 

				}
			};
			return cell;
		}
	};

	/*
	 * Add All employees to observable list and update table
	 */
	private void loadEmployeeDetails() {
		employeeList.clear();
		employeeList.addAll(employeeService.findAll());

		employeeTable.setItems(employeeList);
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

	private void validationAlert(String field, boolean empty) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Validation Error");
		alert.setHeaderText(null);
		if (field.equals("Role"))
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
