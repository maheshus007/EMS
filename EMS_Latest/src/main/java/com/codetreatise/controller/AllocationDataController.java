package com.codetreatise.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.codetreatise.bean.AllocationData;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.StringConverter;

@Controller
public class AllocationDataController implements Initializable {

	@Autowired
	private TrainingService trainingService;

	@FXML
	private Label allocId;

	String query;

	public static final String[] datesInWords = { "", "one", "two", "three", "four", "five", "six", "seven", "eight",
			"nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen", "twenty", "twentyone", "twentytwo", "twentythree", "twentyfour", "twentyfive", "twentysix",
			"twentyseven", "twentyeight", "twentynine", "thirty", "thirtyone" };

	@FXML
	private ComboBox<String> month;

	@FXML
	private ComboBox<String> year;

	@FXML
	private DatePicker dateSearch;

	@FXML
	private ComboBox<String> ddActivitySearch;

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

	boolean columnDataNeeded = true;

	@FXML
	private TextField Mobile;

	@FXML
	private Button reset;

	@FXML
	private Button saveAllocationData;

	@FXML
	private Button searchAllocationData;

	@FXML
	private BorderPane boarderPane;

	@FXML
	private TableView<AllocationData> allocationTable;

	@FXML
	private TableColumn<AllocationData, Boolean> colEdit;

	@FXML
	private TableColumn<AllocationData, String> colstaffID;

	@FXML
	private TableColumn<AllocationData, String> staffNameCol;

	@FXML
	private TableColumn<AllocationData, String> monthCol;

	@FXML
	private TableColumn<AllocationData, String> shiftCol;

	@FXML
	private TableColumn<AllocationData, String> batchNoCol;

	@FXML
	private TableColumn<AllocationData, String> postCol;

	@FXML
	private TableColumn<AllocationData, String> majorCol;

	@FXML
	private TableColumn<AllocationData, String> workingHrCol;

	@FXML
	private TableColumn<AllocationData, String> mobileCol;

	@FXML
	private TableColumn<AllocationData, String> yearCol;

	@FXML
	private TableColumn<AllocationData, String> Col1;

	@FXML
	private TableColumn<AllocationData, String> Week1;

	@FXML
	private TableColumn<AllocationData, String> Col2;

	@FXML
	private TableColumn<AllocationData, String> Col3;

	@FXML
	private TableColumn<AllocationData, String> Col4;

	@FXML
	private TableColumn<AllocationData, String> Col5;

	@FXML
	private TableColumn<AllocationData, String> Col6;

	@FXML
	private TableColumn<AllocationData, String> Col7;

	@FXML
	private TableColumn<AllocationData, String> Col8;

	@FXML
	private TableColumn<AllocationData, String> Col9;

	@FXML
	private TableColumn<AllocationData, String> Col10;

	@FXML
	private TableColumn<AllocationData, String> Col11;

	@FXML
	private TableColumn<AllocationData, String> Col12;

	@FXML
	private TableColumn<AllocationData, String> Col13;

	@FXML
	private TableColumn<AllocationData, String> Col14;

	@FXML
	private TableColumn<AllocationData, String> Col15;

	@FXML
	private TableColumn<AllocationData, String> Col16;

	@FXML
	private TableColumn<AllocationData, String> Col17;

	@FXML
	private TableColumn<AllocationData, String> Col18;

	@FXML
	private TableColumn<AllocationData, String> Col19;

	@FXML
	private TableColumn<AllocationData, String> Col20;

	@FXML
	private TableColumn<AllocationData, String> Col21;

	@FXML
	private TableColumn<AllocationData, String> Col22;

	@FXML
	private TableColumn<AllocationData, String> Col23;

	@FXML
	private TableColumn<AllocationData, String> Col24;

	@FXML
	private TableColumn<AllocationData, String> Col25;

	@FXML
	private TableColumn<AllocationData, String> Col26;

	@FXML
	private TableColumn<AllocationData, String> Col27;

	@FXML
	private TableColumn<AllocationData, String> Col28;

	@FXML
	private TableColumn<AllocationData, String> Col29;

	@FXML
	private TableColumn<AllocationData, String> Col30;

	@FXML
	private TableColumn<AllocationData, String> Col31;

	@FXML
	private MenuItem deleteEmployees;

	@FXML
	void deleteAllocationData(ActionEvent event) {
		List<AllocationData> allocData = allocationTable.getSelectionModel().getSelectedItems();

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Are you sure you want to delete selected?");
		Optional<ButtonType> action = alert.showAndWait();

		if (action.get() == ButtonType.OK)
			allocationService.deleteInBatch(allocData);
		loadAllAllocationDetails();

		// loadEmployeeDetails();
		// printAlert("Delete");
	}

	@FXML
	void editAllocationData(ActionEvent event) {
		printAlert("Editing Staff Allocation records is not possible");
	}

	@Lazy
	@Autowired
	private StageManager stageManager;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private AllocationService allocationService;

	private ObservableList<AllocationData> allocList = FXCollections.observableArrayList();

	private ObservableList<String> ddActivitySearchDrop = FXCollections.observableArrayList("8D", "8N", "12D", "12N",
			"A", "E", "S", "NS", "TR", "SP", "MS", "A380D", "A380N", "ASS", "SD", "PH", "TIL", "LT", "TTC", "TFC",
			"TTL", "TFL", "TTW", "TFW", "TTA", "PSL", "UNI", "EXD", "RFID", "RFIDn", "STB", "TTB");

	private List<String> ddActivityArrayList = new ArrayList<>(ddActivitySearchDrop);

	private ObservableList<String> monthDrop = FXCollections.observableArrayList("Jan", "Feb", "Mar", "Apr", "May",
			"Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "");

	private ObservableList<String> yearDrop = FXCollections.observableArrayList("2018", "2019", "2020", "2021", "2022",
			"2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "");

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
		setColumn();
		loadAllocDetails();
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

		if (dateSearch.getEditor().getText().isEmpty()) {
			List<AllocationData> p = allocationService.findByAllFields(staffID.getText(), staffName.getText(),
					month.getSelectionModel().getSelectedItem(), year.getSelectionModel().getSelectedItem(),
					shift.getText(), batchNo.getText(), post.getText(), Major.getText(), WorkingHr.getText(),
					Mobile.getText());
			allocList.clear();
			for (AllocationData n : p) {
				allocList.addAll(n);
				allocationTable.setItems(allocList);
				if (!month.getSelectionModel().getSelectedItem().isEmpty()
						&& !year.getSelectionModel().getSelectedItem().isEmpty()) {
					setColumn();
				} else {
					columnTextClear();
				}
			}
		} else {
			String date = dateSearch.getEditor().getText();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

			// convert String to LocalDate
			LocalDate date2 = LocalDate.parse(date, formatter);
			Month month2 = date2.getMonth();
			int year = date2.getYear();
			int day = date2.getDayOfMonth();
			String months = month2.toString();
			String formattedMonth = months.substring(0, 3);
			formattedMonth = formattedMonth.charAt(0) + formattedMonth.substring(1).toLowerCase();
			System.out.println(formattedMonth + " " + year + " " + day);

			List<AllocationData> p = allocationService.findbyDate(datesInWords[day],
					ddActivitySearch.getSelectionModel().getSelectedItem(), formattedMonth, year);
			allocList.clear();
//			TablePosition pos = allocationTable.getSelectionModel().getSelectedCells().get(0);
//            int row = pos.getRow();
//			String data = (String) Col1.getCellObservableValue(row).getValue();
//			System.out.println(data);
//			for ( int i = 8; i<allocationTable.getItems().size(); i++) {
//				allocationTable.getItems().clear();
//			}
			for (AllocationData n : p) {
				allocList.addAll(n);
				allocationTable.setItems(allocList);
				if (!formattedMonth.isEmpty()) {
					// setColumn();
				} else {
					columnTextClear();
				}
			}
		}
	}

	@FXML
	private void searchAllocationData(ActionEvent event) {
		Employee employee = new Employee();
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Validation Error");
		alert.setHeaderText(null);

		if (!staffID.getText().isEmpty()) {
			employee = employeeService.findById(((staffID.getText())));
			if (staffID.getText().equalsIgnoreCase(employee.getStaffid())) {
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

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	@FXML
	private void saveAllocationData(ActionEvent event) throws NullPointerException {
		AllocationData allocationData = new AllocationData();
		if (emptyValidation("Staff Id", staffID.getText().isEmpty())) {
			if (allocId.getText() == null || allocId.getText().isEmpty()) {
				AllocationData flag = updateDB(allocationData);
				if (flag.equals(null)) {
					return;
				} else {
					AllocationData newAllocData = allocationService.save(allocationData);
					saveAlert(newAllocData);
				}

			} else {
				allocationData = allocationService.find(Integer.parseInt((allocId.getText())));
				updateDB(allocationData);
				AllocationData updatedAllocData = allocationService.update(allocationData);
				updateAlert(updatedAllocData);
			}

			clearFields();
			loadAllAllocationDetails();
		}

	}

	private void loadAllAllocationDetails() {
		allocList.clear();
		month.getSelectionModel().clearSelection();
		year.getSelectionModel().clearSelection();
		allocList.addAll(allocationService.findAll());
		allocationTable.setItems(allocList);
		columnTextClear();
	}

	public void columnTextClear() {
		Col1.setText("01");
		Col2.setText("02");
		Col3.setText("03");
		Col4.setText("04");
		Col5.setText("05");
		Col6.setText("06");
		Col7.setText("07");
		Col8.setText("08");
		Col9.setText("09");
		Col10.setText("10");
		Col11.setText("11");
		Col12.setText("12");
		Col13.setText("13");
		Col14.setText("14");
		Col15.setText("15");
		Col16.setText("16");
		Col17.setText("17");
		Col18.setText("18");
		Col19.setText("19");
		Col20.setText("20");
		Col21.setText("21");
		Col22.setText("22");
		Col23.setText("23");
		Col24.setText("24");
		Col25.setText("25");
		Col26.setText("26");
		Col27.setText("27");
		Col28.setText("28");
		Col29.setText("29");
		Col30.setText("30");
		Col31.setText("31");

	}

	@FXML
	void backButton(ActionEvent event) {
		stageManager.switchScene(FxmlView.EMPLOYEE);
	}

	private AllocationData updateDB(AllocationData allocData) {
		allocData.setStaffId(getStaffId());
		allocData.setStaffName(getstaffName());
		allocData.setShift(getShift());
		allocData.setBatchNo(getBatchNo());
		// allocData.setDate(getDate());
		allocData.setMajor(getMajor());
		allocData.setMobile(getMobile());
		allocData.setPost(getPost());
		allocData.setWorkingHrs(getWorkingHrs());
		allocData.setMonth(getMonth());
		allocData.setYear(getYear());
		// if (!allocData.getDate().equals(null)) {
		// LocalDate a = allocData.getDate();
		// allocData.setWeek(a.getDayOfWeek().name());
		// }
		// allocData.setDdActivity(getDDActivity());
		return allocData;
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

	public String getMonth() {
		return month.getSelectionModel().getSelectedItem();
	}

	public String getYear() {
		return year.getSelectionModel().getSelectedItem();
	}

	public String getWorkingHrs() {
		return WorkingHr.getText();
	}

	public String getBatchNo() {
		return batchNo.getText();
	}

	private void clearFields() {
		allocId.setText(null);
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
		month.getSelectionModel().selectFirst();
		year.getSelectionModel().selectFirst();
		ddActivitySearch.getSelectionModel().clearSelection();

		staffID.setEditable(true);
		staffName.setEditable(true);
		shift.setEditable(true);
		batchNo.setEditable(true);
		Major.setEditable(true);
		Mobile.setEditable(true);
		post.setEditable(true);
		WorkingHr.setEditable(true);

	}

	private void saveAlert(AllocationData allocData) {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Employee saved successfully.");
		alert.setHeaderText(null);
		alert.setContentText("The Allocation Data " + allocData.getStaffName() + " " + " has been created for " + " id "
				+ allocData.getStaffId() + ".");
		alert.showAndWait();
	}

	private void updateAlert(AllocationData alloc) {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Employee allocation data updated successfully.");
		alert.setHeaderText(null);
		alert.setContentText("The employee " + alloc.getStaffName() + " " + " has been updated.");
		alert.showAndWait();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// allocationTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		ddActivitySearch.setItems(ddActivitySearchDrop);
		month.setItems(monthDrop);
		month.getSelectionModel().selectFirst();
		year.setItems(yearDrop);
		year.setValue(Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
		setColumnProperties();
		
		// Add all data into table
		loadAllocDetails();
	}

	public void setWeekInTable(TableColumn<AllocationData, String> col110) {
		col110.setEditable(true);
		col110.setText("  " + col110.getText().trim().substring(0, 2) + "\n"
				+ getWeek(col110.getText().trim().substring(0, 2)));
		col110.setCellFactory(TextFieldTableCell.forTableColumn());

		
	}

	public void setColumn() {
		setWeekInTable(Col1);
		setWeekInTable(Col2);
		setWeekInTable(Col3);
		setWeekInTable(Col4);
		setWeekInTable(Col5);
		setWeekInTable(Col6);
		setWeekInTable(Col7);
		setWeekInTable(Col8);
		setWeekInTable(Col9);
		setWeekInTable(Col10);
		setWeekInTable(Col11);
		setWeekInTable(Col12);
		setWeekInTable(Col13);
		setWeekInTable(Col14);
		setWeekInTable(Col15);
		setWeekInTable(Col16);
		setWeekInTable(Col17);
		setWeekInTable(Col18);
		setWeekInTable(Col19);
		setWeekInTable(Col20);
		setWeekInTable(Col21);
		setWeekInTable(Col22);
		setWeekInTable(Col23);
		setWeekInTable(Col24);
		setWeekInTable(Col25);
		setWeekInTable(Col26);
		setWeekInTable(Col27);
		setWeekInTable(Col28);
		setWeekInTable(Col29);
		setWeekInTable(Col30);
		setWeekInTable(Col31);
	}

	/*
	 * Set All employeeTable column properties
	 */
	private void setColumnProperties() {
		
		new TableCell<AllocationData, String>() {
		    private final Text newText;

		    {
		         newText = new Text();
		         newText.setWrappingWidth(140);
		    }

		    @Override
		    public void updateItem(String item, boolean empty) {
		        super.updateItem(item, empty);

		        if (empty) {
		            setGraphic(null);
		            setStyle("");
		        } else {
		            newText.setText(getString());
		            setGraphic(newText);

		            // adjust style depending on equality of item and specificValue
		            setStyle(Objects.equals(item, "TR") ? "-fx-background-color:#e50000 ;" : "");
		        }
		    }

		    private String getString() {
		        return getItem() == null ? "" : getItem().toString();
		    }
		};

		allocationTable.setEditable(true);
		setColumn();
		dateSearch.setConverter(new StringConverter<LocalDate>() {
			String pattern = "dd-MM-yyyy";
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

			{
				dateSearch.setPromptText(pattern.toLowerCase());
			}

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
		});

		// dateCol.setCellFactory(TextFieldTableCell.forTableColumn(new
		// StringConverter<LocalDate>() {
		// String pattern = "dd-MMM-yyyy";
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

		ScrollPane sp = new ScrollPane();
		sp.setContent(allocationTable);
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
		if (columnDataNeeded=true) {
			Col1.setCellValueFactory(new PropertyValueFactory<>("one"));
			Col2.setCellValueFactory(new PropertyValueFactory<>("two"));
			Col3.setCellValueFactory(new PropertyValueFactory<>("three"));
			Col4.setCellValueFactory(new PropertyValueFactory<>("four"));
			Col5.setCellValueFactory(new PropertyValueFactory<>("five"));
			Col6.setCellValueFactory(new PropertyValueFactory<>("six"));
			Col7.setCellValueFactory(new PropertyValueFactory<>("seven"));
			Col8.setCellValueFactory(new PropertyValueFactory<>("eight"));
			Col9.setCellValueFactory(new PropertyValueFactory<>("nine"));
			Col10.setCellValueFactory(new PropertyValueFactory<>("ten"));
			Col11.setCellValueFactory(new PropertyValueFactory<>("eleven"));
			Col12.setCellValueFactory(new PropertyValueFactory<>("twelve"));
			Col13.setCellValueFactory(new PropertyValueFactory<>("thirteen"));
			Col14.setCellValueFactory(new PropertyValueFactory<>("fourteen"));
			Col15.setCellValueFactory(new PropertyValueFactory<>("fifteen"));
			Col16.setCellValueFactory(new PropertyValueFactory<>("sixteen"));
			Col17.setCellValueFactory(new PropertyValueFactory<>("seventeen"));
			Col18.setCellValueFactory(new PropertyValueFactory<>("eighteen"));
			Col19.setCellValueFactory(new PropertyValueFactory<>("nineteen"));
			Col20.setCellValueFactory(new PropertyValueFactory<>("twenty"));
			Col21.setCellValueFactory(new PropertyValueFactory<>("twentyone"));
			Col22.setCellValueFactory(new PropertyValueFactory<>("twentytwo"));
			Col23.setCellValueFactory(new PropertyValueFactory<>("twentythree"));
			Col24.setCellValueFactory(new PropertyValueFactory<>("twentyfour"));
			Col25.setCellValueFactory(new PropertyValueFactory<>("twentyfive"));
			Col26.setCellValueFactory(new PropertyValueFactory<>("twentysix"));
			Col27.setCellValueFactory(new PropertyValueFactory<>("twentyseven"));
			Col28.setCellValueFactory(new PropertyValueFactory<>("twentyeight"));
			Col29.setCellValueFactory(new PropertyValueFactory<>("twentynine"));
			Col30.setCellValueFactory(new PropertyValueFactory<>("thirty"));
			Col31.setCellValueFactory(new PropertyValueFactory<>("thirtyone"));
		}
		// dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
		monthCol.setCellValueFactory(new PropertyValueFactory<>("month"));
		yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));
		colEdit.setCellFactory(cellFactory);
	}

	Callback<TableColumn<AllocationData, Boolean>, TableCell<AllocationData, Boolean>> cellFactory = new Callback<TableColumn<AllocationData, Boolean>, TableCell<AllocationData, Boolean>>() {
		@Override
		public TableCell<AllocationData, Boolean> call(final TableColumn<AllocationData, Boolean> param) {
			final TableCell<AllocationData, Boolean> cell = new TableCell<AllocationData, Boolean>() {
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
							AllocationData alloc = getTableView().getItems().get(getIndex());
							updateAllocData(alloc);
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
						allocId.setVisible(false);
					}
				}

				private void updateAllocData(AllocationData alloc) {
					allocId.setText(Integer.toString(alloc.getAllocationId()));
					staffID.setText((alloc.getStaffId()));
					staffName.setText(alloc.getStaffName());
					shift.setText(alloc.getShift());
					batchNo.setText(alloc.getBatchNo());
					// date.setValue(alloc.getDate());
					Major.setText(alloc.getMajor());
					Mobile.setText(alloc.getMobile());
					post.setText(alloc.getPost());
					WorkingHr.setText(alloc.getWorkingHrs());

					shift.setEditable(false);
					batchNo.setEditable(false);
					Major.setEditable(false);
					Mobile.setEditable(false);
					post.setEditable(false);
					WorkingHr.setEditable(false);
					staffID.setEditable(false);
					staffName.setEditable(false);
					// ddActivity.setValue(alloc.getDdActivity());

				}
			};
			return cell;
		}
	};

	/*
	 * Add All employees to observable list and update table
	 */
	private void loadAllocDetails() {
		allocList.clear();
		allocList.addAll(allocationService.findByMonthYear(month.getSelectionModel().getSelectedItem(),
				year.getSelectionModel().getSelectedItem()));

		allocationTable.setItems(allocList);
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

	public String getWeek(String dat) {
		String mon = month.getSelectionModel().getSelectedItem();
		String yr = year.getSelectionModel().getSelectedItem();
		String WeekName = null;
		if (!mon.equals(null)) {
			if (!yr.equals(null)) {
				String date = dat + "-" + mon + "-" + yr;
				DateTimeFormatter dTF = new DateTimeFormatterBuilder().parseCaseInsensitive()
						.appendPattern("dd-MMM-yyyy").toFormatter();
				LocalDate a = LocalDate.parse(date, dTF);
				WeekName = a.getDayOfWeek().name().substring(0, 3);
			}

		}
		return WeekName;
	}

	@FXML
	void oneColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event) {
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setOne(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void twoColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event) {
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setTwo(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void eightColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setEight(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void eighteenColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setEighteen(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void elevenColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setEleven(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void fifteenColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setFifteen(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void fiveColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setFive(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void fourColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setFour(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void fourteenumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setFourteen(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void nineColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setNine(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void nineteenColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setNineteen(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void sevenColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setSeven(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void seventeenColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setSeventeen(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void sixColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setSix(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void sixteentwoColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setSixteen(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void tenColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setTen(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void thirteenumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setThirteen(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void thirtyColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setThirty(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void thirtyOneColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setThirtyone(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void threeColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setThree(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void twelveColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setTwelve(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void twentyColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setTwenty(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void twentyEightColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setTwentyeight(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void twentyFiveColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setTwentyfive(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void twentyFourColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setTwentyfour(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void twentyNineColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setTwentynine(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void twentyOneColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setTwentyone(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void twentySevenColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setTwentyseven(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void twentySixColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setTwentysix(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void twentyThreeColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setTwentythree(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

	@FXML
	void twentyTwoColumnEdit(TableColumn.CellEditEvent<AllocationData, String> event)

	{
		AllocationData allocData = allocationTable.getSelectionModel().getSelectedItem();
		allocData.setTwentytwo(event.getNewValue());
		if (ddActivityArrayList.contains(event.getNewValue())) {
			allocationService.save(allocData);
		} else {
			printAlert("Invalid Activity code");
			loadAllocDetails();
		}
	}

}
