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

import com.codetreatise.bean.Employee;
import com.codetreatise.bean.TrainingData;
import com.codetreatise.config.StageManager;
import com.codetreatise.service.AllocationService;
import com.codetreatise.service.EmployeeService;
import com.codetreatise.service.TrainingService;
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
public class TrainingDataController implements Initializable {
	
	public static final String[] datesInWords = { "", "one", "two", "three", "four", "five", "six", "seven", "eight",
			"nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen", "twenty", "twentyone", "twentytwo", "twentythree", "twentyfour", "twentyfive", "twentysix",
			"twentyseven", "twentyeight", "twentynine", "thirty", "thirtyone" };
	@FXML
	private Label trainingId;

	@FXML
	private DatePicker dateSearch;

	@FXML
	private ComboBox<String> course;

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
	private Button saveTrainingData;

	@FXML
	private Button searchTrainingData;

	@FXML
	private BorderPane boarderPane;

	@FXML
	private TableView<TrainingData> trainingTable;

	@FXML
	private TableColumn<TrainingData, Boolean> colEdit;

	@FXML
	private TableColumn<TrainingData, String> colstaffID;

	@FXML
	private TableColumn<TrainingData, String> staffNameCol;

	@FXML
	private TableColumn<TrainingData, String> shiftCol;

	@FXML
	private TableColumn<TrainingData, String> batchNoCol;

	@FXML
	private TableColumn<TrainingData, LocalDate> dateCol;

	@FXML
	private TableColumn<TrainingData, String> postCol;

	@FXML
	private TableColumn<TrainingData, String> majorCol;

	@FXML
	private TableColumn<TrainingData, String> workingHrCol;

	@FXML
	private TableColumn<TrainingData, String> mobileCol;

	@FXML
	private TableColumn<TrainingData, String> courseCol;

	@FXML
	private MenuItem deleteEmployees;

	@FXML
	void deleteTrainingData(ActionEvent event) {
		printAlert("Deleting Staff Training records is not possible");
	}
	
	@Autowired
	public AllocationService allocationService;

	@FXML
	void editTrainingData(ActionEvent event) {
		printAlert("Editing Staff Training records is not possible");
	}

	@FXML
	private MenuItem deleteTrainingData;

	@FXML
	private MenuItem editTrainingData;

	@Lazy
	@Autowired
	private StageManager stageManager;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private TrainingService trainingService;

	private ObservableList<TrainingData> trainingList = FXCollections.observableArrayList();

	private ObservableList<String> courseDrop = FXCollections.observableArrayList("EY Induction for Technical",
			"Aircraft Towing & Radio Telephony", "EWIS", "Policy and Procedures Training - Maintenance",
			"Fuel Tank safety Phase 1 & Phase 2", "Store Inspection (SI)", "ETOPS", "Ramp Safety ( RS)",
			"A319/320/321 Level 2 Ramp & Transit Theory", "A319/320/321 Level 2 Ramp & Transit Practical",
			"Human Factors ( HF)", "Human Factors Continuation Training", "A380 Cat c Course Level 1",
			"A320 level 2 course shld be given in 1 year", "Level 3", "A320 refresher course ", "AMOS Course",
			"CMRO Course");

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
		loadTrainingDetails();
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
		List<TrainingData> p = trainingService.findByAllFields(staffID.getText(), staffName.getText(),
				shift.getText(), batchNo.getText(), post.getText(), Major.getText(), WorkingHr.getText(),
				Mobile.getText(),dateSearch.getValue(),course.getSelectionModel().getSelectedItem());
		trainingList.clear();
		for (TrainingData n : p) {
			trainingList.addAll(n);
			trainingTable.setItems(trainingList);
		}
	}

	@FXML
	private void searchTrainingData(ActionEvent event) {
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
	
	public void setTrainingDateToAllocation(LocalDate date, String id){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		// convert String to LocalDate
		LocalDate date2 = LocalDate.parse(formatter.format(date), formatter);
		Month month2 = date2.getMonth();
		int year = date2.getYear();
		int day = date2.getDayOfMonth();
		String months = month2.toString();
		String formattedMonth = months.substring(0, 3);
		formattedMonth = formattedMonth.charAt(0) + formattedMonth.substring(1).toLowerCase();
		allocationService.updateByDate(datesInWords[day],id,
				"TR", formattedMonth, year);
	}

	@FXML
	private void saveTrainingData(ActionEvent event) throws NullPointerException {
		TrainingData trainingData = new TrainingData();
		if (emptyValidation("Staff Id", staffID.getText().isEmpty())) {
			// System.out.println("allocId.getText():" + allocId.getText());
			if (trainingId.getText() == null || trainingId.getText().isEmpty()) {
				TrainingData flag = updateDB(trainingData);
				setTrainingDateToAllocation(getDate(),staffID.getText());
				if (flag.equals(null)) {
					return;
				} else {
					List<TrainingData> p = trainingService.findByItem(staffID.getText(),dateSearch.getValue(),getCourse());
					if(p.isEmpty()){
					trainingService.save(trainingData);
					saveAlert(trainingData);
					clearFields();
					loadAllTrainingDetails();
					}
					else{
						printAlert("Training record already found in the same id,date and Course");
					}
				}

			} else {
				trainingData = trainingService.find(Integer.parseInt((trainingId.getText())));
				updateDB(trainingData);
				setTrainingDateToAllocation(getDate(),staffID.getText());
				TrainingData updatetrainingData = trainingService.update(trainingData);
				updateAlert(updatetrainingData);
				clearFields();
				loadAllTrainingDetails();
			}
		}

	}

	private void loadAllTrainingDetails() {
		trainingList.clear();
		// year.getSelectionModel().clearSelection();
		trainingList.addAll(trainingService.findAll());
		trainingTable.setItems(trainingList);
	}

	@FXML
	void backButton(ActionEvent event) {
		stageManager.switchScene(FxmlView.EMPLOYEE);
	}

	private TrainingData updateDB(TrainingData trainingData) {
		trainingData.setStaffId(getStaffId());
		trainingData.setStaffName(getstaffName());
		trainingData.setShift(getShift());
		trainingData.setBatchNo(getBatchNo());
		trainingData.setMajor(getMajor());
		trainingData.setMobile(getMobile());
		trainingData.setPost(getPost());
		trainingData.setWorkingHrs(getWorkingHrs());
		trainingData.setCourse(getCourse());
		trainingData.setDate(getDate());
		return trainingData;
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

	public String getWorkingHrs() {
		return WorkingHr.getText();
	}

	public String getBatchNo() {
		return batchNo.getText();
	}

	public String getCourse() {
		return course.getSelectionModel().getSelectedItem();
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
		trainingId.setText(null);
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
		course.getSelectionModel().clearSelection();
		
		staffID.setEditable(true);
		staffName.setEditable(true);
		shift.setEditable(true);
		batchNo.setEditable(true);
		Major.setEditable(true);
		Mobile.setEditable(true);
		post.setEditable(true);
		WorkingHr.setEditable(true);

	}

	private void saveAlert(TrainingData trainingData) {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Training data saved successfully.");
		alert.setHeaderText(null);
		alert.setContentText("The Training Data " + trainingData.getStaffName() + " " + " has been created for "
				+ " id " + trainingData.getStaffId() + ".");
		alert.showAndWait();
	}

	private void updateAlert(TrainingData training) {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Employee tranining data updated successfully.");
		alert.setHeaderText(null);
		alert.setContentText("The employee " + training.getStaffName() + " " + " has been updated.");
		alert.showAndWait();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// allocationTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		course.setItems(courseDrop);
		// year.setItems(yearDrop);
		setColumnProperties();

		// Add all data into table
		loadAllTrainingDetails();
	}

	/*
	 * Set All employeeTable column properties
	 */
	private void setColumnProperties() {

		// trainingTable.setEditable(true);
		
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
		sp.setContent(trainingTable);
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
		courseCol.setCellValueFactory(new PropertyValueFactory<>("course"));
		dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
		colEdit.setCellFactory(cellFactory);
	}

	Callback<TableColumn<TrainingData, Boolean>, TableCell<TrainingData, Boolean>> cellFactory = new Callback<TableColumn<TrainingData, Boolean>, TableCell<TrainingData, Boolean>>() {
		@Override
		public TableCell<TrainingData, Boolean> call(final TableColumn<TrainingData, Boolean> param) {
			final TableCell<TrainingData, Boolean> cell = new TableCell<TrainingData, Boolean>() {
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
							TrainingData train = getTableView().getItems().get(getIndex());
							updateTrainingData(train);
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
						trainingId.setVisible(false);
					}
				}

				private void updateTrainingData(TrainingData training) {
					trainingId.setText(Integer.toString(training.getTrainingId()));
					staffID.setText((training.getStaffId()));
					staffName.setText(training.getStaffName());
					shift.setText(training.getShift());
					batchNo.setText(training.getBatchNo());
					Major.setText(training.getMajor());
					Mobile.setText(training.getMobile());
					post.setText(training.getPost());
					WorkingHr.setText(training.getWorkingHrs());
					course.setValue(training.getCourse());
					dateSearch.getEditor().clear();
					dateSearch.setValue(null);
					dateSearch.setValue(training.getDate());
					
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
	private void loadTrainingDetails() {
		trainingList.clear();
		trainingList.addAll(trainingService.findAll());

		trainingTable.setItems(trainingList);
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
