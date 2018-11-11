package com.codetreatise.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import com.codetreatise.config.StageManager;
import com.codetreatise.reports.GenerateReports;
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
import javafx.scene.control.ScrollBar;
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
import net.sf.jasperreports.engine.JRException;

@Controller
public class EmployeeController implements Initializable {

	@FXML
	private ScrollBar testScroll;

	@FXML
	private Label employeeId;

	@FXML
	private TextField staffID;

	@FXML
	private TextField staffName;

	@FXML
	private TextField uaeId;

//	@FXML
//	private BorderPane boarderPane;
	
    @FXML
    private ScrollPane scrollBar;

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
	private Button backArea;

	@FXML
	private MenuItem deleteEmployees;

	@FXML
	private Button saveEmployee;

	@FXML
	private Button searchEmployee;

	@FXML
	private Button btnLogout1;

	@FXML
	private Button trainingButton;

	@FXML
	private Button btnLogout12;

	@FXML
	private Button btnLogout13;

	@FXML
    private Button assessmentModuleButton;

	@FXML
	private Button btnLogout;

	@FXML
	private TableView<Employee> employeeTable;

	@FXML
	private TableView<AreaOfWork> areaOfWorkTable;

	@FXML
	private TableColumn<AreaOfWork, String> areaOfWorkTableCol;

	@FXML
	private TableColumn<AreaOfWork, Integer> noOfStaffCol;

	@FXML
	private TableColumn<Employee, Long> colEmployeeId;

	@FXML
	private TableColumn<Employee, String> colstaffID;

	@FXML
	private TableColumn<Employee, String> staffNameCol;

	@FXML
	private TableColumn<Employee, String> genderCol;

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
	private TableColumn<Employee, LocalDate> nsStartDateCol;

	@FXML
	private TableColumn<Employee, LocalDate> nsEndDateCol;

	@FXML
	private TableColumn<Employee, String> batchCol;

	@FXML
	private TableColumn<Employee, String> grade;

	@FXML
	private TableColumn<Employee, String> colEmail;

	@FXML
	private TableColumn<Employee, String> nationalityCol;

	@FXML
	private TableColumn<Employee, String> departmentCol;

	@FXML
	private TableColumn<Employee, String> contactCol;

	@FXML
	private TableColumn<Employee, String> designationCol;

	@FXML
	private TableColumn<Employee, String> areaOfWorkCol;

	@FXML
	private TableColumn<Employee, Boolean> colEdit;

	@FXML
	private ComboBox<String> gender;

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
	private ComboBox<String> post;

	@FXML
	private ComboBox<String> shift;

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

	@FXML
	private TableColumn<Employee, String> nsStatusCol;

	@FXML
	private TableColumn<Employee, String> placeOfBirthCol;

	@FXML
	private TableColumn<Employee, String> academicCol;

	@FXML
	private TableColumn<Employee, String> passportCol;

	@FXML
	private TableColumn<Employee, String> drivingLicenseCol;

	@FXML
	private TableColumn<Employee, LocalDate> ojtStartDateCol;

	@FXML
	private TableColumn<Employee, LocalDate> ojtEndDateCol;

	@FXML
	private TableColumn<Employee, String> threeHundredCol;

	@FXML
	private TableColumn<Employee, String> logBookCol;

	@FXML
	private TableColumn<Employee, String> majorCol;

	@FXML
	private TableColumn<Employee, String> lineOfManagerCol;

	@FXML
	private TableColumn<Employee, String> workingHrsCol;

	@FXML
	private TableColumn<Employee, String> collegeModulesCol;

	@FXML
	private TableColumn<Employee, String> specifyModulesCol;

	@FXML
	private TableColumn<Employee, String> historyCol;

	@FXML
	private TableColumn<Employee, String> basicLicenseCol;

	@FXML
	private TableColumn<Employee, String> l3CourseTypeCol;

	@FXML
	private TableColumn<Employee, String> A380ProjectCol;

	@FXML
	private TableColumn<Employee, String> rfidProjectMemberCol;

	@FXML
	private TableColumn<Employee, String> engineChangeProjectCol;

	@FXML
	private TableColumn<Employee, String> cORCertificateCol;

	@FXML
	private TableColumn<Employee, String> totalLeaveTakenCol;

	@FXML
	private TableColumn<Employee, String> balLeaveCol;

	@FXML
	private TableColumn<Employee, String> postCol;

	@FXML
	private TableColumn<Employee, String> shiftCol;

	String query;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	int count = 0;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	Employee employee1;

	@Lazy
	@Autowired
	private StageManager stageManager;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private AreaOfWorkService areaService;

	private ObservableList<Employee> employeeList = FXCollections.observableArrayList();
	private ObservableList<AreaOfWork> areaOfWorkList = FXCollections.observableArrayList();

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
	private ObservableList<String> genderDropDown = FXCollections.observableArrayList("Male", "Female");
	private ObservableList<String> shiftDropDown = FXCollections.observableArrayList("A", "B", "C", "D", "E", "F");
	private ObservableList<String> postDropDown = FXCollections.observableArrayList("TR", "A380", "RFID", "B777",
			"B787", "A320");

	@FXML
	private void exit(ActionEvent event) {
		Platform.exit();
	}

	@FXML
	void leaveModule(ActionEvent event) {
		stageManager.switchScene(FxmlView.LEAVE);
	}

	@FXML
	void allocationModule(ActionEvent event) {
		stageManager.switchScene(FxmlView.ALLOCATION);
	}

	@FXML
	void trainingButton(ActionEvent event) {
		stageManager.switchScene(FxmlView.TRAINING);
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
		count = 0;
	}

	@FXML
	void clickPrint(ActionEvent event) throws JRException, SQLException {
		GenerateReports pdf = new GenerateReports();
		if (count == 0) {
			query = "select * from employee";
			setQuery(query);
		}
		getQuery();
		int returnValue = pdf.GenerateReport(query, 1);
		if (returnValue == 0) {
			printAlert("Export Successfully");
		} else
			printAlert("Export not Successfully");
	}

	@FXML
	private void searchEmployee(ActionEvent event) {
		count = 1;
		employee1 = new Employee();
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Validation Error");
		alert.setHeaderText(null);
		String StaffId = staffID.getText();
		
		List<Employee> p = employeeService.findByAllFields(staffID.getText(),staffName.getText(),uaeId.getText(),batch.getText(),
				gender.getSelectionModel().getSelectedItem(),designation.getText(),staffGrade.getText(),nationality.getText(),
				department.getText(),contact.getText(),passport.getText(),placeOfBirth.getText(),academicQualification.getText(),
				drivingLicense.getText(),lineManager.getSelectionModel().getSelectedItem(),
				areaOfWork.getSelectionModel().getSelectedItem(),threeHundredHrs.getSelectionModel().getSelectedItem(),
				collegeModules.getSelectionModel().getSelectedItem(),logBook.getSelectionModel().getSelectedItem(),
				major.getSelectionModel().getSelectedItem(),workingHrs.getSelectionModel().getSelectedItem(),
				nsStatus.getSelectionModel().getSelectedItem(),specifyModulesNotCompleted.getText(),email.getText(),
				post.getSelectionModel().getSelectedItem(),shift.getSelectionModel().getSelectedItem(),
				ojtStartDate.getValue(),ojtEndDate.getValue(),doj.getValue(),nsEndDate.getValue(),
				nsStartDate.getValue(),dob.getValue());
				
		employeeList.clear();
		for (Employee n : p) {
			query = "select * from employee where staff_id like '%" + staffID.getText() + "%' AND Staff_name like '%" 
					+ staffName.getText() + "%' AND gender like '%" + gender.getSelectionModel().getSelectedItem() 
					+ "%' AND uae_id like '%" + uaeId.getText() + "%' AND batch like '%" + batch.getText() + "%' AND designation like '%" 
					+ designation.getText() + "%' AND staffgrade like '%" + staffGrade.getText() + "%' AND nationality like '%" 
					+ nationality.getText() + "%' AND department like '%" + department.getText() + "%' AND contact like '%" 
					+ contact.getText() + "%' AND passport like '%" + passport.getText() + "%' AND placeofbirth like '%" 
					+ placeOfBirth.getText() + "%' AND academicqualification like '%" + academicQualification.getText() 
					+ "%' AND driving_license like '%" + drivingLicense.getText() + "%' AND linemanager like '%" 
					+ lineManager.getSelectionModel().getSelectedItem() + "%' AND areaofwork like '%" 
					+ areaOfWork.getSelectionModel().getSelectedItem() + "%' AND _300hrs like '%" 
					+ threeHundredHrs.getSelectionModel().getSelectedItem() + "%' AND collegemodules like '%" 
					+ collegeModules.getSelectionModel().getSelectedItem() + "%' AND logbook like '%" 
					+ logBook.getSelectionModel().getSelectedItem() + "%' AND major like '%" 
					+ major.getSelectionModel().getSelectedItem() + "%' AND workinghrs like '%" 
					+ workingHrs.getSelectionModel().getSelectedItem() + "%' AND nsstatus like '%" 
					+ nsStatus.getSelectionModel().getSelectedItem() + "%' AND specifymodules like '%" 
					+ specifyModulesNotCompleted.getText() + "%' AND email like '%" + email.getText() + "%' AND post like '%" 
					+ post.getSelectionModel().getSelectedItem() + "%' AND shift like '%" 
					+ shift.getSelectionModel().getSelectedItem() + "%' AND ojtenddate like '%" + ojtEndDate.getValue() 
					+ "%' AND ojtstartdate like '%" + ojtStartDate.getValue() + "%' AND dob like '%" + dob.getValue() 
					+ "%' AND doj like '%" + doj.getValue() + "%' AND nsstartdate like '%" + nsStartDate.getValue() 
					+ "%' AND ns_end_date like '%" + nsEndDate.getValue() + "%'";
			setQuery(query);
			employeeList.addAll(n);
		employeeTable.setItems(employeeList);
		}
		// if (staffID.getText().isEmpty() && staffName.getText().isEmpty()
		// && (areaOfWork.getSelectionModel().getSelectedItem() == null)) {
		// clearFields();
		// loadEmployeeDetails();
		// } else
//		if (!staffID.getText().isEmpty()) {
//			employee1 = employeeService.findById(((staffID.getText())));
//			if (staffID.getText().equalsIgnoreCase((employee1.getStaffid()))) {
//				query = "select * from employee where staff_id='" + staffID.getText() + "'";
//				setQuery(query);
//				loadBySearch(staffID.getText());
//
//			}
//		}
//
//		else if (!staffName.getText().isEmpty()) {
//			List<Employee> p = employeeService.findByName(((staffName.getText())));
//			employeeList.clear();
//			for (Employee n : p) {
//				if (staffName.getText().equalsIgnoreCase(n.getStaffName())) {
//					query = "select * from employee where staff_name='" + staffName.getText() + "'";
//					setQuery(query);
//					employeeList.addAll(n);
//					employeeTable.setItems(employeeList);
//				}
//			}
//		}
//
//		else if (areaOfWork.getSelectionModel().getSelectedItem() != null) {
//			String text = areaOfWork.getSelectionModel().getSelectedItem();
//			List<Employee> p = employeeService.findByAreaOfWork(text);
//			employeeList.clear();
//			for (Employee n : p) {
//				if (text.equalsIgnoreCase(n.getAreaofwork())) {
//					query = "select * from employee where areaofwork='"
//							+ areaOfWork.getSelectionModel().getSelectedItem() + "'";
//					setQuery(query);
//					employeeList.addAll(n);
//					employeeTable.setItems(employeeList);
//				}
//			}
//		} else if (!uaeId.getText().isEmpty()) {
//			String text = uaeId.getText();
//			List<Employee> p = employeeService.findByUAEID(text);
//			employeeList.clear();
//			for (Employee n : p) {
//				if (text.equalsIgnoreCase(n.getUaeid())) {
//					query = "select * from employee where uae_id='" + text + "'";
//					setQuery(query);
//					employeeList.addAll(n);
//					employeeTable.setItems(employeeList);
//				}
//			}
//		} else if (lineManager.getSelectionModel().getSelectedItem() != null) {
//			String text = lineManager.getSelectionModel().getSelectedItem();
//			List<Employee> p = employeeService.findByLineManager(text);
//			employeeList.clear();
//			for (Employee n : p) {
//				if (text.equalsIgnoreCase(n.getLinemanager())) {
//					query = "select * from employee where linemanager='"
//							+ lineManager.getSelectionModel().getSelectedItem() + "'";
//					setQuery(query);
//					employeeList.addAll(n);
//					employeeTable.setItems(employeeList);
//				}
//			}
//		} else if (gender.getSelectionModel().getSelectedItem() != null) {
//			String text = gender.getSelectionModel().getSelectedItem();
//			List<Employee> p = employeeService.findByGender(text);
//			employeeList.clear();
//			for (Employee n : p) {
//				if (text.equalsIgnoreCase(n.getGender())) {
//					query = "select * from employee where gender='" + gender.getSelectionModel().getSelectedItem()
//							+ "'";
//					setQuery(query);
//					employeeList.addAll(n);
//					employeeTable.setItems(employeeList);
//				}
//			}
//		} else if (!email.getText().isEmpty()) {
//			List<Employee> p = employeeService.findByEmail(((email.getText())));
//			employeeList.clear();
//			for (Employee n : p) {
//				if (email.getText().equalsIgnoreCase(n.getEmail())) {
//					query = "select * from employee where email='" + email.getText() + "'";
//					setQuery(query);
//					employeeList.addAll(n);
//					employeeTable.setItems(employeeList);
//				}
//			}
//		} else if (!contact.getText().isEmpty()) {
//			List<Employee> p = employeeService.findByContact(((contact.getText())));
//			employeeList.clear();
//			for (Employee n : p) {
//				if (contact.getText().equalsIgnoreCase(n.getContact())) {
//					query = "select * from employee where contact='" + contact.getText() + "'";
//					setQuery(query);
//					employeeList.addAll(n);
//					employeeTable.setItems(employeeList);
//				}
//			}
//		} else if (!batch.getText().isEmpty()) {
//			List<Employee> p = employeeService.findByBatch(((batch.getText())));
//			employeeList.clear();
//			for (Employee n : p) {
//				if (batch.getText().equalsIgnoreCase(n.getBatch())) {
//					query = "select * from employee where batch='" + batch.getText() + "'";
//					setQuery(query);
//					employeeList.addAll(n);
//					employeeTable.setItems(employeeList);
//				}
//			}
//		} else if (!designation.getText().isEmpty()) {
//			List<Employee> p = employeeService.findByDesignation(((designation.getText())));
//			employeeList.clear();
//			for (Employee n : p) {
//				if (designation.getText().equalsIgnoreCase(n.getDesignation())) {
//					query = "select * from employee where designation='" + designation.getText() + "'";
//					setQuery(query);
//					employeeList.addAll(n);
//					employeeTable.setItems(employeeList);
//				}
//			}
//		} else if (!department.getText().isEmpty()) {
//			List<Employee> p = employeeService.findByDepartment(((department.getText())));
//			employeeList.clear();
//			for (Employee n : p) {
//				if (department.getText().equalsIgnoreCase(n.getDepartment())) {
//					query = "select * from employee where department='" + department.getText() + "'";
//					setQuery(query);
//					employeeList.addAll(n);
//					employeeTable.setItems(employeeList);
//				}
//			}
//		} else if (nsStatus.getSelectionModel().getSelectedItem() != null) {
//			String text = nsStatus.getSelectionModel().getSelectedItem();
//			List<Employee> p = employeeService.findByNsStatus(text);
//			employeeList.clear();
//			for (Employee n : p) {
//				if (text.equalsIgnoreCase(n.getNSstatus())) {
//					query = "select * from employee where nsStatus='" + text + "'";
//					setQuery(query);
//					employeeList.addAll(n);
//					employeeTable.setItems(employeeList);
//				}
//			}
//		} else if (!ojtStartDate.getEditor().getText().isEmpty()) {
//			Date text = null;
//			try {
//				text = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(ojtStartDate.getEditor().getText());
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			List<Employee> p = employeeService.findByOjtStart(text);
//			employeeList.clear();
//			for (Employee n : p) {
//				if (text.equals(n.getOjtstartdate())) {
//					employeeList.addAll(n);
//					employeeTable.setItems(employeeList);
//				}
//			}
//		} else {
//			query = "select * from employee";
//			setQuery(query);
//		}

	}

	private void loadBySearch(String string) {
		employeeList.clear();
		employeeList.addAll(employeeService.findById(string));
		employeeTable.setItems(employeeList);
	}

	@FXML
	private void saveEmployee(ActionEvent event) {
		Employee employee = new Employee();
		employee1 = new Employee();
		employee1 = employeeService.findById(((staffID.getText())));
		if (employee1 == null || !(employeeId.getText().isEmpty())) {
			if (emptyValidation("Staff Id", staffID.getText().isEmpty())
					&& validate("Staff Name", getstaffName(), "^[\\p{L} .'-]+$")
					&& emptyValidation("Gender", getGender() == null)
					&& emptyValidation("Email", email.getText().isEmpty())
					&& validate("Email", getEmail(), "[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+")
					&& emptyValidation("Batch", batch.getText().isEmpty())
					&& emptyValidation("Nationality", nationality.getText().isEmpty())
					&& emptyValidation("DOB", dob.getEditor().getText().isEmpty())
					&& emptyValidation("OJT Start Date", ojtStartDate.getEditor().getText().isEmpty())
					&& emptyValidation("OJT End Date", ojtEndDate.getEditor().getText().isEmpty())
					&& emptyValidation("Line Manager", getLineManager() == null)
					&& emptyValidation("Major", getmajor() == null)
					&& emptyValidation("Working Hrs", getworkingHrs() == null)) {

				if (employeeId.getText() == null || employeeId.getText().isEmpty()) {
					updateDB(employee);
					if (employee.getWorkinghrs().equals("12Hrs")) {
						employee.setBalLeave("15");
					} else {
						employee.setBalLeave("22");
					}
					employee.setTotalLeaveTaken("0");
					Employee newEmployee = employeeService.save(employee);
					saveAlert(newEmployee);
				} else {
					employee = employeeService.find(Integer.parseInt((employeeId.getText())));
					updateDB(employee);
					Employee updatedemployee = employeeService.update(employee);
					updateAlert(updatedemployee);
					staffID.setEditable(true);
				}

				clearFields();
				loadEmployeeDetails();
			}
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Employee Id already Present");
			alert.setHeaderText(null);
			alert.setContentText("Employee Id already Present and Currently Owned by " + employee1.getStaffName());
			alert.showAndWait();
		}
	}

	private boolean printAlert(String issue) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Warning");
		alert.setHeaderText(null);
		alert.setContentText(issue);
		alert.showAndWait();
		return false;
	}

	@FXML
	void printActionForWorkArea(ActionEvent event) throws JRException, SQLException {
		GenerateReports pdf = new GenerateReports();
		query = "select * from areaofwork";
		setQuery(query);
		getQuery();
		int returnValue = pdf.GenerateReport(query, 2);
		if (returnValue == 0) {
			printAlert("Export Successfully");
		} else
			printAlert("Export not Successfully");
	}

	@FXML
	void clickAreaOfWork(ActionEvent event) {
		areaOfWorkList.clear();
		stageManager.switchScene(FxmlView.AOW);
		areaOfWorkList.addAll(areaService.findAll());
		try {
			areaOfWorkTable.setItems(areaOfWorkList);
		} catch (Exception e) {
			System.out.println(e + "Empty Data in AreaOfWork table");
		}
		areaOfWorkTableCol.setCellValueFactory(new PropertyValueFactory<>("areaOfWork"));
		noOfStaffCol.setCellValueFactory(new PropertyValueFactory<>("count"));

	}
	
	@FXML
	void assessmentModuleButton(ActionEvent event) {
		stageManager.switchScene(FxmlView.ASSESSMENT);
	}

	@FXML
	private void backArea(ActionEvent event) throws IOException {
		stageManager.switchScene(FxmlView.EMPLOYEE);
	}

	private Employee updateDB(Employee employee) {
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
		employee.setPassport(getPassport());
		employee.setAcademicqualification(getAcademicqualification());
		employee.setDrivinglicense(getDrivinglicense());
		employee.setLinemanager(getLineManager());
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		try {
			if (!areaOfWork.getSelectionModel().getSelectedItem().equals(employee.getAreaofwork())) {
				employee.setHistory("Area of Work changed from " + employee.getAreaofwork() + " to "
						+ areaOfWork.getSelectionModel().getSelectedItem() + " on " + df.format(dateobj));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
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
		employee.setGender(getGender());
		employee.setPost(getPost());
		employee.setShift(getShift());
		if (basicLicense.isSelected()) {
			employee.setBasicLicense("Yes");
		} else {
			employee.setBasicLicense("No");
		}
		if (l3CourseType.isSelected()) {
			employee.setL3CourseType("Yes");
		} else {
			employee.setL3CourseType("No");
		}
		if (a380Project.isSelected()) {
			employee.setA380Project("Yes");
		} else {
			employee.setA380Project("No");
		}
		if (rfidProjectMember.isSelected()) {
			employee.setRfidProjectMember("Yes");
		} else {
			employee.setRfidProjectMember("No");
		}
		if (engineChangeProject.isSelected()) {
			employee.setEngineChangeProject("Yes");
		} else {
			employee.setEngineChangeProject("No");
		}
		if (corCertificate.isSelected()) {
			employee.setCorCertificate("Yes");
		} else {
			employee.setCorCertificate("No");
		}

		return employee;

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
		employeeId.setText(null);
		staffID.clear();
		staffName.clear();
		dob.getEditor().clear();
		dob.setValue(null);
		doj.getEditor().clear();
		doj.setValue(null);
		ojtStartDate.getEditor().clear();
		ojtStartDate.setValue(null);
		ojtEndDate.getEditor().clear();
		ojtEndDate.setValue(null);
		nsStartDate.getEditor().clear();
		nsStartDate.setValue(null);
		nsEndDate.getEditor().clear();
		nsEndDate.setValue(null);
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
		gender.getSelectionModel().clearSelection();
		workingHrs.getSelectionModel().clearSelection();
		collegeModules.getSelectionModel().clearSelection();
		specifyModulesNotCompleted.clear();
		basicLicense.setSelected(false);
		l3CourseType.setSelected(false);
		a380Project.setSelected(false);
		rfidProjectMember.setSelected(false);
		engineChangeProject.setSelected(false);
		corCertificate.setSelected(false);
		shift.getSelectionModel().clearSelection();
		post.getSelectionModel().clearSelection();
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

	public String getEmployeeId() {
		return employeeId.getText();
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

	public String getGender() {
		return gender.getSelectionModel().getSelectedItem();
	}

	public String getPost() {
		return post.getSelectionModel().getSelectedItem();
	}

	public String getShift() {
		return shift.getSelectionModel().getSelectedItem();
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
		gender.setItems(genderDropDown);
		post.setItems(postDropDown);
		shift.setItems(shiftDropDown);

		employeeTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		setColumnProperties();

		// Add all employees into table
		loadEmployeeDetails();
	}
	
	public void setDateFormat(DatePicker date){
		date.setConverter(new StringConverter<LocalDate>() {
			 String pattern = "dd-MM-yyyy";
			 DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

			 {
				 date.setPromptText(pattern.toLowerCase());
			 }

			 @Override public String toString(LocalDate date) {
			     if (date != null) {
			         return dateFormatter.format(date);
			     } else {
			         return "";
			     }
			 }

			 @Override public LocalDate fromString(String string) {
			     if (string != null && !string.isEmpty()) {
			         return LocalDate.parse(string, dateFormatter);
			     } else {
			         return null;
			     }
			 }
			});
	}

	/*
	 * Set All employeeTable column properties
	 */
	private void setColumnProperties() {
		
		setDateFormat(dob);
		setDateFormat(doj);
		setDateFormat(ojtStartDate);
		setDateFormat(ojtEndDate);
		setDateFormat(nsStartDate);
		setDateFormat(nsEndDate);

		DatePicker datePicker = new DatePicker();
		datePicker.setShowWeekNumbers(true);
		StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

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
		};
		datePicker.setConverter(converter);
		datePicker.setPromptText("dd-MM-yyyy");

		// Override date format in table
		colDOB.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<LocalDate>() {
			String pattern = "dd-MMM-yyyy";
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

		colDOJ.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<LocalDate>() {
			String pattern = "dd-MMM-yyyy";
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

		ojtStartDateCol.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<LocalDate>() {
			String pattern = "dd-MMM-yyyy";
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

		ojtEndDateCol.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<LocalDate>() {
			String pattern = "dd-MMM-yyyy";
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

		nsStartDateCol.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<LocalDate>() {
			String pattern = "dd-MMM-yyyy";
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

		nsEndDateCol.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<LocalDate>() {
			String pattern = "dd-MMM-yyyy";
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

//		ScrollPane sp = new ScrollPane();
//		scrollBar.setContent(employeeTable);
//		sp.setPrefSize(980, 700);
		// sp.setPrefHeight(10);
		scrollBar.setFitToHeight(true);
		scrollBar.setFitToWidth(true);
//		scrollBar.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		// testScroll.setContextMenu(value);
//		scrollBar.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
//		boarderPane.setRight(sp);
//		BorderPane.setMargin(sp, new Insets(0, 0, 10, 10));

		colstaffID.setCellValueFactory(new PropertyValueFactory<>("staffid"));
		staffNameCol.setCellValueFactory(new PropertyValueFactory<>("staffName"));
		uaeIdCol.setCellValueFactory(new PropertyValueFactory<>("uaeid"));
		colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
		genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
		batchCol.setCellValueFactory(new PropertyValueFactory<>("batch"));
		grade.setCellValueFactory(new PropertyValueFactory<>("staffgrade"));
		nationalityCol.setCellValueFactory(new PropertyValueFactory<>("nationality"));
		colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		colDOJ.setCellValueFactory(new PropertyValueFactory<>("doj"));
		departmentCol.setCellValueFactory(new PropertyValueFactory<>("department"));
		contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
		designationCol.setCellValueFactory(new PropertyValueFactory<>("designation"));
		nsStatusCol.setCellValueFactory(new PropertyValueFactory<>("NSstatus"));
		nsEndDateCol.setCellValueFactory(new PropertyValueFactory<>("NS_end_date"));
		nsStartDateCol.setCellValueFactory(new PropertyValueFactory<>("NSstartdate"));
		areaOfWorkCol.setCellValueFactory(new PropertyValueFactory<>("areaofwork"));
		placeOfBirthCol.setCellValueFactory(new PropertyValueFactory<>("placeofbirth"));
		academicCol.setCellValueFactory(new PropertyValueFactory<>("academicqualification"));
		passportCol.setCellValueFactory(new PropertyValueFactory<>("passport"));
		drivingLicenseCol.setCellValueFactory(new PropertyValueFactory<>("drivinglicense"));
		ojtStartDateCol.setCellValueFactory(new PropertyValueFactory<>("ojtstartdate"));
		ojtEndDateCol.setCellValueFactory(new PropertyValueFactory<>("ojtenddate"));
		threeHundredCol.setCellValueFactory(new PropertyValueFactory<>("_300hrs"));
		logBookCol.setCellValueFactory(new PropertyValueFactory<>("logbook"));
		majorCol.setCellValueFactory(new PropertyValueFactory<>("major"));
		lineOfManagerCol.setCellValueFactory(new PropertyValueFactory<>("linemanager"));
		workingHrsCol.setCellValueFactory(new PropertyValueFactory<>("workinghrs"));
		collegeModulesCol.setCellValueFactory(new PropertyValueFactory<>("collegemodules"));
		specifyModulesCol.setCellValueFactory(new PropertyValueFactory<>("specifymodules"));
		basicLicenseCol.setCellValueFactory(new PropertyValueFactory<>("basicLicense"));
		l3CourseTypeCol.setCellValueFactory(new PropertyValueFactory<>("l3CourseType"));
		A380ProjectCol.setCellValueFactory(new PropertyValueFactory<>("a380Project"));
		rfidProjectMemberCol.setCellValueFactory(new PropertyValueFactory<>("rfidProjectMember"));
		engineChangeProjectCol.setCellValueFactory(new PropertyValueFactory<>("engineChangeProject"));
		cORCertificateCol.setCellValueFactory(new PropertyValueFactory<>("corCertificate"));
		totalLeaveTakenCol.setCellValueFactory(new PropertyValueFactory<>("totalLeaveTaken"));
		balLeaveCol.setCellValueFactory(new PropertyValueFactory<>("balLeave"));
		postCol.setCellValueFactory(new PropertyValueFactory<>("post"));
		shiftCol.setCellValueFactory(new PropertyValueFactory<>("shift"));
		historyCol.setCellValueFactory(new PropertyValueFactory<>("history"));

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
						employeeId.setVisible(false);
					}
				}

				private void updateEmployee(Employee employee) {
					employeeId.setText(Integer.toString(employee.getId()));
					staffID.setText((employee.getStaffid()));
					staffName.setText(employee.getStaffName());
					uaeId.setText(employee.getUaeid());
					
					dob.getEditor().clear();
					dob.setValue(null);
					dob.setValue(employee.getDob());
					
					batch.setText(employee.getBatch());
					
					doj.getEditor().clear();
					doj.setValue(null);
					doj.setValue(employee.getDoj());
					
					ojtStartDate.getEditor().clear();
					ojtStartDate.setValue(null);
					ojtStartDate.setValue(employee.getOjtstartdate());
					
					ojtEndDate.getEditor().clear();
					ojtEndDate.setValue(null);
					ojtEndDate.setValue(employee.getOjtenddate());
					
					nsStartDate.getEditor().clear();
					nsStartDate.setValue(null);
					nsStartDate.setValue(employee.getNSstartdate());
					
					nsEndDate.getEditor().clear();
					nsEndDate.setValue(null);
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
					areaOfWork.setValue(employee.getAreaofwork());
					nsStatus.setValue(employee.getNSstatus());
					threeHundredHrs.setValue(employee.get_300hrs());
					logBook.setValue(employee.getLogbook());
					major.setValue(employee.getMajor());
					lineManager.setValue(employee.getLinemanager());
					workingHrs.setValue(employee.getWorkinghrs());
					collegeModules.setValue(employee.getCollegemodules());
					specifyModulesNotCompleted.setText(employee.getSpecifymodules());
					basicLicense.setSelected(Boolean.parseBoolean(employee.getBasicLicense1()));
					l3CourseType.setSelected(Boolean.parseBoolean(employee.getL3CourseType1()));
					a380Project.setSelected(Boolean.parseBoolean(employee.getA380Project1()));
					rfidProjectMember.setSelected(Boolean.parseBoolean(employee.getRfidProjectMember1()));
					engineChangeProject.setSelected(Boolean.parseBoolean(employee.getEngineChangeProject1()));
					corCertificate.setSelected(Boolean.parseBoolean(employee.getCorCertificate1()));
					noOfLeavesTaken.setText(employee.getTotalLeaveTaken());
					balanceNoOfLeaves.setText(employee.getBalLeave());
					gender.setValue(employee.getGender());
					post.setValue(employee.getPost());
					shift.setValue(employee.getShift());
					staffID.setEditable(false);
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
