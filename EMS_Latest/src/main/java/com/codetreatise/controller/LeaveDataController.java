package com.codetreatise.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import com.codetreatise.bean.Employee;
import com.codetreatise.bean.LeaveData;
import com.codetreatise.config.StageManager;
import com.codetreatise.service.EmployeeService;
import com.codetreatise.service.LeaveService;
import com.codetreatise.view.FxmlView;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
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
	private Label leaveId;

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
	private ComboBox<String> approverName;

	@FXML
	private DatePicker approvedDate;

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
	private Button searchTable;

	@FXML
	private BorderPane boarderPane;

	@FXML
	private TableView<LeaveData> leaveTable;

	@FXML
	private TableColumn<LeaveData, Boolean> colEdit;

	@FXML
	private TableColumn<LeaveData, String> colstaffID;

	@FXML
	private TableColumn<LeaveData, String> staffNameCol;

	@FXML
	private TableColumn<LeaveData, LocalDate> fromDateCol;

	@FXML
	private TableColumn<LeaveData, LocalDate> toDateCol;

	@FXML
	private TableColumn<LeaveData, String> shiftCol;

	@FXML
	private TableColumn<LeaveData, String> totalLeaveTakenCol;

	@FXML
	private TableColumn<LeaveData, String> balanceLeaveCol;

	@FXML
	private TableColumn<LeaveData, String> approverNameCol;

	@FXML
	private TableColumn<LeaveData, LocalDate> approvedDateCol;

	@FXML
	private TableColumn<LeaveData, String> leaveTypeCol;

	@FXML
	private TableColumn<LeaveData, String> leaveApprovedYNCol;

	@FXML
	private MenuItem deleteEmployees;

	@FXML
	void deleteLeaveData(ActionEvent event) {
		printAlert("Deleting Staff leave records is not possible");
	}

	@Lazy
	@Autowired
	private StageManager stageManager;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private LeaveService leaveService;

	private ObservableList<LeaveData> leaveList = FXCollections.observableArrayList();
	private ObservableList<String> TypeOfLeaveDropDown = FXCollections.observableArrayList("Annual Leave",
			"Emergency Leave", "Exam Leave", "Medical Leave", "Sick Leave", "University Leave");
	private ObservableList<String> ApprovalDropDown = FXCollections.observableArrayList("Approve", "Reject");
	private ObservableList<String> approverNameDropDown = FXCollections.observableArrayList(
			"Abdul Majeed Hassan Jeizan", "Amer Mohamed Banialnajjar", "Faisal Mohamed Al Mulla", "Hamad Al Ali",
			"Mahendra Lokug", "Mohammad Nour Aldin Saffi", "Mohammed Yousef", "Sameer Abdulkareem",
			"Selvakumar Murugadoss", "Others");

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
		loadLeaveDetails();
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
	private void searchLeaveData(ActionEvent event) {
		Employee employee = new Employee();
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Validation Error");
		alert.setHeaderText(null);

		if (!staffID.getText().isEmpty()) {
			employee = employeeService.findById(((staffID.getText())));
			if (staffID.getText().equalsIgnoreCase(employee.getStaffid())) {
				// loadBySearch(staffID.getText());
				staffName.setText(employee.getStaffName());
				totalLeaveTaken.setText(employee.getTotalLeaveTaken());
				balanceLeave.setText(employee.getBalLeave());
				shift.setText(employee.getWorkinghrs());
			}
		}

		else if (!staffName.getText().isEmpty()) {
			List<Employee> p = employeeService.findByName(((staffName.getText())));
			leaveList.clear();
			for (Employee n : p) {
				if (staffName.getText().equalsIgnoreCase(n.getStaffName())) {
					staffID.setText(n.getStaffid());
					totalLeaveTaken.setText(n.getTotalLeaveTaken());
					balanceLeave.setText(n.getBalLeave());
					shift.setText(n.getWorkinghrs());
				}
			}
		}

	}
	
	@FXML
	private void searchTable(ActionEvent event) {
		
	}

	private void loadBySearch(String string) {
		// employeeList.clear();
		// employeeList.addAll(employeeService.findById(string));
		// employeeTable.setItems(employeeList);
	}

	@FXML
	private void saveLeaveData(ActionEvent event) {
		LeaveData leaveData = new LeaveData();
		if (emptyValidation("Staff Id", staffID.getText().isEmpty())) {
			System.out.println("leaveId.getText():" + leaveId.getText());
			if (leaveId.getText() == null || leaveId.getText().isEmpty()) {
				LeaveData flag = updateDB(leaveData);
				if (flag.equals(null)) {
					return;
				} else {
					LeaveData newLeave = leaveService.save(leaveData);
					saveAlert(newLeave);
				}

			} else {
				// employee =
				// employeeService.find(Integer.parseInt((employeeId.getText())));
				// updateDB(employee);
				// Employee updatedemployee = employeeService.update(employee);
				// updateAlert(updatedemployee);
				printAlert("Update Functionality is disabled");
			}

			clearFields();
			loadLeaveDetails();
		}

	}

	@FXML
	void backButton(ActionEvent event) {
		stageManager.switchScene(FxmlView.EMPLOYEE);
	}

	private LeaveData updateDB(LeaveData leave) {
		leave.setStaffId(getStaffId());
		leave.setStaffName(getstaffName());
		leave.setApproverName(getApproverName());
		leave.setShift(getShift());
		leave.setApproverName(getApproverName());
		leave.setFromDate(getFromDate());
		leave.setToDate(getToDate());
		leave.setDateOfApproval(getApprovalDate());
		leave.setTypeOfLeave(getLeaveType());
		leave.setApproveReject(getApprove());
		if (Long.parseLong(getBalanceLeave()) > 0) {
			if (fromDate.getValue() != null && toDate.getValue() != null && approvedDate.getValue() != null) {
				long dateDifference = ChronoUnit.DAYS.between(getFromDate(), getToDate());
				if (ChronoUnit.DAYS.between(java.time.LocalDate.now(), getApprovalDate()) <= 0) {	
					if (dateDifference >= 0) {
						if (approveReject.getSelectionModel().getSelectedItem() != null) {
							if ((getApprove().equals("Approve"))) {
								dateDifference++;
								long total = Long.parseLong(getTotalLeaveTaken()) + dateDifference;
								long balance = Long.parseLong(getBalanceLeave()) - dateDifference;
								if (total > balance) {
									Boolean getFlag = true;
									getFlag = printAlert("Your leave exeeds the limit/Error Date Entered");
									if (!getFlag)
										leave = null;
								} else {
									leave.setTotalLeaveTaken(Long.toString(total));
									leave.setBalLeave(Long.toString(balance));
								}
							} else {
								leave.setTotalLeaveTaken(getTotalLeaveTaken());
								leave.setBalLeave(getBalanceLeave());
							}
						} else {
							Boolean getFlag = true;
							getFlag = printAlert("Please select Approve/Reject");
							if (!getFlag)
								leave = null;
						}
					} else {
						Boolean getFlag = true;
						getFlag = printAlert("To Date should be greater than From Date");
						if (!getFlag)
							leave = null;

					}
				} else {
					Boolean getFlag = true;
					getFlag = printAlert("Approval Date should not be greater than System Date");
					if (!getFlag)
						leave = null;
				}

			} else {
				Boolean getFlag = true;
				getFlag = printAlert("From,To Date and Approval Date is mandatory");
				if (!getFlag)
					leave = null;
			}
		} else {
			Boolean getFlag = true;
			getFlag = printAlert("Leave Balance reached 0 for current staff");
			if (!getFlag)
				leave = null;
		}
		return leave;

	}

	public String getStaffId() {
		return staffID.getText();
	}

	public String getstaffName() {
		return staffName.getText();
	}

	public String getApproverName() {
		return approverName.getSelectionModel().getSelectedItem();
	}

	public String getShift() {
		return shift.getText();
	}

	public LocalDate getFromDate() {
		return fromDate.getValue();
	}

	public LocalDate getToDate() {
		return toDate.getValue();
	}

	public LocalDate getApprovalDate() {
		return approvedDate.getValue();
	}

	public String getLeaveType() {
		return typeOfLeave.getSelectionModel().getSelectedItem();
	}

	public String getApprove() {
		return approveReject.getSelectionModel().getSelectedItem();
	}

	public String getTotalLeaveTaken() {
		return totalLeaveTaken.getText();
	}

	public String getBalanceLeave() {
		return balanceLeave.getText();
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
		leaveId.setText(null);
		staffID.clear();
		staffName.clear();
		fromDate.getEditor().clear();
		toDate.getEditor().clear();
		approvedDate.getEditor().clear();
		approveReject.getSelectionModel().clearSelection();
		typeOfLeave.getSelectionModel().clearSelection();
		approverName.getSelectionModel().clearSelection();
		shift.clear();
		totalLeaveTaken.clear();
		balanceLeave.clear();
	}

	private void saveAlert(LeaveData leave) {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Employee saved successfully.");
		alert.setHeaderText(null);
		alert.setContentText("The Leave Data " + leave.getStaffName() + " " + " has been created for \n" + " id "
				+ leave.getStaffId() + ".");
		alert.showAndWait();
	}

	private void updateAlert(Employee employee) {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("employee updated successfully.");
		alert.setHeaderText(null);
		alert.setContentText("The employee " + employee.getStaffName() + " " + " has been updated.");
		alert.showAndWait();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		approveReject.setItems(ApprovalDropDown);
		typeOfLeave.setItems(TypeOfLeaveDropDown);
		approverName.setItems(approverNameDropDown);
		setColumnProperties();
		// Add all employees into table
		loadLeaveDetails();
	}

	/*
	 * Set All employeeTable column properties
	 */
	private void setColumnProperties() {

		fromDateCol.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<LocalDate>() {
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

		toDateCol.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<LocalDate>() {
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

		approvedDateCol.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<LocalDate>() {
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
		sp.setContent(leaveTable);
		sp.setPrefSize(1050, 600);
		sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		boarderPane.setRight(sp);
		BorderPane.setMargin(sp, new Insets(0, 0, 10, 10));

		colstaffID.setCellValueFactory(new PropertyValueFactory<>("staffId"));
		staffNameCol.setCellValueFactory(new PropertyValueFactory<>("staffName"));
		fromDateCol.setCellValueFactory(new PropertyValueFactory<>("fromDate"));
		toDateCol.setCellValueFactory(new PropertyValueFactory<>("toDate"));
		shiftCol.setCellValueFactory(new PropertyValueFactory<>("shift"));
		totalLeaveTakenCol.setCellValueFactory(new PropertyValueFactory<>("totalLeaveTaken"));
		balanceLeaveCol.setCellValueFactory(new PropertyValueFactory<>("balLeave"));
		approverNameCol.setCellValueFactory(new PropertyValueFactory<>("approverName"));
		approvedDateCol.setCellValueFactory(new PropertyValueFactory<>("dateOfApproval"));
		leaveTypeCol.setCellValueFactory(new PropertyValueFactory<>("typeOfLeave"));
		leaveApprovedYNCol.setCellValueFactory(new PropertyValueFactory<>("approveReject"));

		colEdit.setCellFactory(cellFactory);
	}

	Callback<TableColumn<LeaveData, Boolean>, TableCell<LeaveData, Boolean>> cellFactory = new Callback<TableColumn<LeaveData, Boolean>, TableCell<LeaveData, Boolean>>() {
		@Override
		public TableCell<LeaveData, Boolean> call(final TableColumn<LeaveData, Boolean> param) {
			final TableCell<LeaveData, Boolean> cell = new TableCell<LeaveData, Boolean>() {
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
							LeaveData leave = getTableView().getItems().get(getIndex());
							updateLeaveData(leave);
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
						leaveId.setVisible(false);
					}
				}

				private void updateLeaveData(LeaveData leave) {
					leaveId.setText(Integer.toString(leave.getLeaveId()));
					staffID.setText((leave.getStaffId()));
					staffName.setText(leave.getStaffName());
					approverName.setValue(leave.getApproverName());
					approveReject.setValue(leave.getApproveReject());
					typeOfLeave.setValue(leave.getTypeOfLeave());
					shift.setText(leave.getShift());
					approvedDate.setValue(leave.getDateOfApproval());
					totalLeaveTaken.setText(leave.getTotalLeaveTaken());
					balanceLeave.setText(leave.getBalLeave());
				}
			};
			return cell;
		}
	};

	/*
	 * Add All employees to observable list and update table
	 */
	private void loadLeaveDetails() {
		leaveList.clear();
		leaveList.addAll(leaveService.findAll());

		leaveTable.setItems(leaveList);
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
