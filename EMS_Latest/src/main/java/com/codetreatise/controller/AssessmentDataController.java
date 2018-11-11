package com.codetreatise.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.codetreatise.bean.AssessmentData;
import com.codetreatise.bean.Employee;
import com.codetreatise.config.StageManager;
import com.codetreatise.service.AllocationService;
import com.codetreatise.service.AssessmentService;
import com.codetreatise.service.EmployeeService;
import com.codetreatise.view.FxmlView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import javafx.util.StringConverter;

@Controller
public class AssessmentDataController implements Initializable {
	
	public static final String[] datesInWords = { "", "one", "two", "three", "four", "five", "six", "seven", "eight",
			"nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen", "twenty", "twentyone", "twentytwo", "twentythree", "twentyfour", "twentyfive", "twentysix",
			"twentyseven", "twentyeight", "twentynine", "thirty", "thirtyone" };
	@FXML
	private Label assessmentId;

	@FXML
	private DatePicker dateSearch;

	@FXML
	private ComboBox<String> assessmentModule;
	
	@FXML
	private ComboBox<String> assessor;

	@FXML
	private TextField staffID;

	@FXML
	private TextField staffName;

	@FXML
	private TextField shift;

	@FXML
	private TextField batchNo;

	@FXML
	private TextField post;

	@FXML
	private TextField Major;

	@FXML
	private TextField WorkingHr;

	@FXML
	private TextField Mobile;

	@FXML
	private Button reset;

	@FXML
	private Button saveAssessmentData;

	@FXML
	private Button searchAssessmentData;

	@FXML
	private BorderPane boarderPane;

	@FXML
	private TableView<AssessmentData> assessmentTable;

	@FXML
	private TableColumn<AssessmentData, Boolean> colEdit;

	@FXML
	private TableColumn<AssessmentData, String> colstaffID;

	@FXML
	private TableColumn<AssessmentData, String> staffNameCol;

	@FXML
	private TableColumn<AssessmentData, String> shiftCol;

	@FXML
	private TableColumn<AssessmentData, String> batchNoCol;

	@FXML
	private TableColumn<AssessmentData, LocalDate> dateCol;

	@FXML
	private TableColumn<AssessmentData, String> postCol;

	@FXML
	private TableColumn<AssessmentData, String> majorCol;

	@FXML
	private TableColumn<AssessmentData, String> workingHrCol;

	@FXML
	private TableColumn<AssessmentData, String> mobileCol;

	@FXML
	private TableColumn<AssessmentData, String> assessmentCol;
	
    @FXML
    private TableColumn<AssessmentData, String> assessorCol;

	@FXML
	private MenuItem deleteEmployees;

	@FXML
	void deleteAssessmentData(ActionEvent event) {
		printAlert("Deleting Staff Assessment records is not possible");
	}
	
	@Autowired
	public AssessmentService assessmentService;
	
	@Autowired
	public AllocationService allocService;

	@FXML
	void editAssessmentData(ActionEvent event) {
		printAlert("Editing Staff Assessment records is not possible");
	}

	@FXML
	private MenuItem deleteAssessmentData;

	@FXML
	private MenuItem editAssessmentData;

	@Lazy
	@Autowired
	private StageManager stageManager;

	@Autowired
	private EmployeeService employeeService;

	private ObservableList<AssessmentData> assessmentList = FXCollections.observableArrayList();

	private ObservableList<String> assessmentDrop = FXCollections.observableArrayList("Assessment 1","Assessment 2",
			"Assessment 3","Assessment 4");
	
	private ObservableList<String> lineManagerDropDown = FXCollections.observableArrayList("Abdul Majeed Hassan Jeizan",
			"Amer Mohamed Banialnajjar", "Faisal Mohamed Al Mulla", "Hamad Al Ali", "Mahendra Lokug",
			"Mohammad Nour Aldin Saffi", "Mohammed Yousef", "Sameer Abdulkareem", "Selvakumar Murugadoss", "Others");

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
		loadAssessmentDetails();
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
	void searchTableData(ActionEvent event) {
		List<AssessmentData> p = assessmentService.findByAllFields(staffID.getText(), staffName.getText(),
				shift.getText(), batchNo.getText(), post.getText(), Major.getText(), WorkingHr.getText(),
				Mobile.getText(),dateSearch.getValue(),assessmentModule.getSelectionModel().getSelectedItem(),
				assessor.getSelectionModel().getSelectedItem());
		assessmentList.clear();
		for (AssessmentData n : p) {
			assessmentList.addAll(n);
			assessmentTable.setItems(assessmentList);
		}
	}

	@FXML
	private void searchAssessmentData(ActionEvent event) {
		Employee employee = new Employee();
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Validation Error");
		alert.setHeaderText(null);

		if (!staffID.getText().isEmpty()) {
			employee = employeeService.findById(((staffID.getText())));
			if (staffID.getText().equalsIgnoreCase(employee.getStaffid())) {
				// loadBySearch(staffID.getText());
				staffName.setText(employee.getStaffName());
				shift.setText(employee.getShift());
				batchNo.setText(employee.getBatch());
				post.setText(employee.getPost());
				Major.setText(employee.getMajor());
				WorkingHr.setText(employee.getWorkinghrs());
				Mobile.setText(employee.getContact());
			}
		}

		else if (!staffName.getText().isEmpty()) {
			List<Employee> p = employeeService.findByName(((staffName.getText())));
			// allocList.clear();
			for (Employee n : p) {
				if (staffName.getText().equalsIgnoreCase(n.getStaffName())) {
					staffID.setText(n.getStaffid());
					shift.setText(n.getShift());
					batchNo.setText(n.getBatch());
					post.setText(n.getPost());
					Major.setText(n.getMajor());
					WorkingHr.setText(n.getWorkinghrs());
					Mobile.setText(n.getContact());
				}
			}
		}

		else {
			if (staffID.getText().isEmpty() || staffName.getText().isEmpty()) {
				printAlert("Search with Id or Staff Name");
			} else {
				printAlert("This Functionality is disabled");
			}
		}

	}
	
	public void setAssessmentDateToAllocation(LocalDate date, String id){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		// convert String to LocalDate
		LocalDate date2 = LocalDate.parse(formatter.format(date), formatter);
		Month month2 = date2.getMonth();
		int year = date2.getYear();
		int day = date2.getDayOfMonth();
		String months = month2.toString();
		String formattedMonth = months.substring(0, 3);
		formattedMonth = formattedMonth.charAt(0) + formattedMonth.substring(1).toLowerCase();
		allocService.updateByDate(datesInWords[day],id,
				"ASS", formattedMonth, year);
	}

	@FXML
	private void saveAssessmentData(ActionEvent event) throws NullPointerException {
		AssessmentData assessmentData = new AssessmentData();
		if (emptyValidation("Staff Id", staffID.getText().isEmpty())) {
			// System.out.println("allocId.getText():" + allocId.getText());
			if (assessmentId.getText() == null || assessmentId.getText().isEmpty()) {
				AssessmentData flag = updateDB(assessmentData);
				setAssessmentDateToAllocation(getDate(),staffID.getText());
				if (flag.equals(null)) {
					return;
				} else {
					List<AssessmentData> p = assessmentService.findByItem(staffID.getText(),dateSearch.getValue(),getAssessmentModule());
					if(p.isEmpty()){
					assessmentService.save(assessmentData);
					saveAlert(assessmentData);
					clearFields();
					loadAllAssessmentDetails();
					}
					else{
						printAlert("Assessment record already found in the same id,date and Course");
					}
				}

			} else {
				assessmentData = assessmentService.find(Integer.parseInt((assessmentId.getText())));
				updateDB(assessmentData);
				setAssessmentDateToAllocation(getDate(),staffID.getText());
				AssessmentData updateassessmentData = assessmentService.update(assessmentData);
				updateAlert(updateassessmentData);
				clearFields();
				loadAllAssessmentDetails();
			}
		}

	}

	private void loadAllAssessmentDetails() {
		assessmentList.clear();
		// year.getSelectionModel().clearSelection();
		assessmentList.addAll(assessmentService.findAll());
		assessmentTable.setItems(assessmentList);
	}

	@FXML
	void backButton(ActionEvent event) {
		stageManager.switchScene(FxmlView.EMPLOYEE);
	}

	private AssessmentData updateDB(AssessmentData assessmentData) {
		assessmentData.setStaffId(getStaffId());
		assessmentData.setStaffName(getstaffName());
		assessmentData.setShift(getShift());
		assessmentData.setBatchNo(getBatchNo());
		assessmentData.setMajor(getMajor());
		assessmentData.setMobile(getMobile());
		assessmentData.setPost(getPost());
		assessmentData.setWorkingHrs(getWorkingHrs());
		assessmentData.setAssessmentModule(getAssessmentModule());
		assessmentData.setDate(getDate());
		assessmentData.setAssessor(getAssessor());
		return assessmentData;
	}

	public LocalDate getDate() {
		return dateSearch.getValue();
	}

	public String getStaffId() {
		return staffID.getText();
	}

	public String getstaffName() {
		return staffName.getText();
	}

	public String getShift() {
		return shift.getText();
	}

	public String getMobile() {
		return Mobile.getText();
	}

	public String getMajor() {
		return Major.getText();
	}

	public String getPost() {
		return post.getText();
	}
	
	public String getAssessor() {
		return assessor.getSelectionModel().getSelectedItem();
	}

	public String getWorkingHrs() {
		return WorkingHr.getText();
	}

	public String getBatchNo() {
		return batchNo.getText();
	}

	public String getAssessmentModule() {
		return assessmentModule.getSelectionModel().getSelectedItem();
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
		assessmentId.setText(null);
		staffID.clear();
		staffName.clear();
		dateSearch.getEditor().clear();
		dateSearch.setValue(null);
		shift.clear();
		batchNo.clear();
		post.clear();
		Major.clear();
		WorkingHr.clear();
		Mobile.clear();
		assessmentModule.getSelectionModel().clearSelection();
		assessor.getSelectionModel().clearSelection();
		
		staffID.setEditable(true);
		staffName.setEditable(true);
		shift.setEditable(true);
		batchNo.setEditable(true);
		Major.setEditable(true);
		Mobile.setEditable(true);
		post.setEditable(true);
		WorkingHr.setEditable(true);

	}

	private void saveAlert(AssessmentData assessmentData) {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Assessment data saved successfully.");
		alert.setHeaderText(null);
		alert.setContentText("The Assessment Data " + assessmentData.getStaffName() + " " + " has been created for "
				+ " id " + assessmentData.getStaffId() + ".");
		alert.showAndWait();
	}

	private void updateAlert(AssessmentData assessment) {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Employee assessment data updated successfully.");
		alert.setHeaderText(null);
		alert.setContentText("The employee " + assessment.getStaffName() + " " + " has been updated.");
		alert.showAndWait();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// allocationTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		assessmentModule.setItems(assessmentDrop);
		assessor.setItems(lineManagerDropDown);
		// year.setItems(yearDrop);
		setColumnProperties();

		// Add all data into table
		loadAllAssessmentDetails();
	}

	/*
	 * Set All assessment column properties
	 */
	private void setColumnProperties() {

		dateSearch.setConverter(new StringConverter<LocalDate>() {
			 String pattern = "dd-MM-yyyy";
			 DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

			 {
				 dateSearch.setPromptText(pattern.toLowerCase());
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

		dateCol.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<LocalDate>() {
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

		ScrollPane sp = new ScrollPane();
		sp.setContent(assessmentTable);
		sp.setPrefSize(1050, 600);
		sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		boarderPane.setRight(sp);
		BorderPane.setMargin(sp, new Insets(0, 0, 10, 10));

		colstaffID.setCellValueFactory(new PropertyValueFactory<>("staffId"));
		staffNameCol.setCellValueFactory(new PropertyValueFactory<>("staffName"));
		shiftCol.setCellValueFactory(new PropertyValueFactory<>("shift"));
		batchNoCol.setCellValueFactory(new PropertyValueFactory<>("batchNo"));
		postCol.setCellValueFactory(new PropertyValueFactory<>("post"));
		majorCol.setCellValueFactory(new PropertyValueFactory<>("major"));
		workingHrCol.setCellValueFactory(new PropertyValueFactory<>("workingHrs"));
		mobileCol.setCellValueFactory(new PropertyValueFactory<>("mobile"));
		assessmentCol.setCellValueFactory(new PropertyValueFactory<>("assessmentModule"));
		assessorCol.setCellValueFactory(new PropertyValueFactory<>("assessor"));
		dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
		colEdit.setCellFactory(cellFactory);
	}

	Callback<TableColumn<AssessmentData, Boolean>, TableCell<AssessmentData, Boolean>> cellFactory = new Callback<TableColumn<AssessmentData, Boolean>, TableCell<AssessmentData, Boolean>>() {
		@Override
		public TableCell<AssessmentData, Boolean> call(final TableColumn<AssessmentData, Boolean> param) {
			final TableCell<AssessmentData, Boolean> cell = new TableCell<AssessmentData, Boolean>() {
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
							AssessmentData assessment = getTableView().getItems().get(getIndex());
							updateAssessmentData(assessment);
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
						assessmentId.setVisible(false);
					}
				}

				private void updateAssessmentData(AssessmentData assessment) {
					assessmentId.setText(Integer.toString(assessment.getAssessmentId()));
					staffID.setText((assessment.getStaffId()));
					staffName.setText(assessment.getStaffName());
					shift.setText(assessment.getShift());
					batchNo.setText(assessment.getBatchNo());
					Major.setText(assessment.getMajor());
					Mobile.setText(assessment.getMobile());
					post.setText(assessment.getPost());
					WorkingHr.setText(assessment.getWorkingHrs());
					assessmentModule.setValue(assessment.getAssessmentModule());
					assessor.setValue(assessment.getAssessor());
					dateSearch.getEditor().clear();
					dateSearch.setValue(null);
					dateSearch.setValue(assessment.getDate());
					
					staffID.setEditable(false);
					staffName.setEditable(false);
					shift.setEditable(false);
					batchNo.setEditable(false);
					Major.setEditable(false);
					Mobile.setEditable(false);
					post.setEditable(false);
					WorkingHr.setEditable(false);
				}
			};
			return cell;
		}
	};

	/*
	 * Add All employees to observable list and update table
	 */
	private void loadAssessmentDetails() {
		assessmentList.clear();
		assessmentList.addAll(assessmentService.findAll());

		assessmentTable.setItems(assessmentList);
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
