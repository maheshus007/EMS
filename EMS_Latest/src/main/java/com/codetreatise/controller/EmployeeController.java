package com.codetreatise.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;


@Controller
public class EmployeeController implements Initializable{

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
    private TableColumn<Employee, Long> colstaffID;

    @FXML
    private TableColumn<Employee, String> staffNameCol;

    @FXML
    private TableColumn<Employee, String> uaeIdCol;

    @FXML
    private TableColumn<Employee, String> colDOB;

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
    private ComboBox<Employee> areaOfWork;

    @FXML
    private ComboBox<Employee> nsStatus;

    @FXML
    private ComboBox<Employee> threeHundredHrs;

    @FXML
    private ComboBox<Employee> logBook;

    @FXML
    private ComboBox<Employee> major;

    @FXML
    private ComboBox<Employee> lineManager;

    @FXML
    private DatePicker nsStartDate;

    @FXML
    private DatePicker nsEndDate;

    @FXML
    private ComboBox<Employee> workingHrs;

    @FXML
    private ComboBox<Employee> collegeModules;

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
    private void searchEmployee(ActionEvent event){
    }
    
    @FXML
    private void saveEmployee(ActionEvent event){
    	
    	if(validate("Staff Name", getstaffName(), "[a-zA-Z]+") 
    	    ){
    		
    		if(staffID.getText() != null || staffID.getText() != "" || staffName.getText() == "" ||
    				batch.getText() == "" || nationality.getText() == "" || 
    				email.getText() == "" ){
    			if(validate("Email", getEmail(), "[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+")
    				){
    				
    				Employee employee = new Employee();
//    				employee.setStaffid(getStaffId());
        			employee.setStaffName(getstaffName());
        			employee.setUaeid(getUaeid());
        			employee.setBatch(getBatch());
        			employee.setPlaceofbirth(getPlaceofbirth());
        			employee.setDesignation(getDesignation());
        			employee.setStaffgrade(getStaffgrade());
        			employee.setNationality(getNationality());
        			employee.setDepartment(getDepartment());
        			employee.setAcademicqualification(getAcademicqualification());
//        			employee.setPassport(getPassport());
//        			employee.setDrivinglicense(getDrivinglicense());
//        			employee.setDob(getDob());
        			employee.setEmail(getEmail());
        			
        			Employee newEmployee = employeeService.save(employee);
        			
        			saveAlert(newEmployee);
    			}
    			
    		}else{
    			Employee employee = employeeService.find(Long.parseLong(staffID.getText()));
    			employee.setStaffName(getstaffName());
//    			employee.setDob(getDob());
    			Employee updatedemployee =  employeeService.update(employee);
    			updateAlert(updatedemployee);
    		}
    		
    		clearFields();
    		loadEmployeeDetails();
    	}
    	
    	
    }
    
    @FXML
    private void deleteEmployees(ActionEvent event){
    	List<Employee> employees = employeeTable.getSelectionModel().getSelectedItems();
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Are you sure you want to delete selected?");
		Optional<ButtonType> action = alert.showAndWait();
		
		if(action.get() == ButtonType.OK) employeeService.deleteInBatch(employees);
    	
    	loadEmployeeDetails();
    }
    
   	private void clearFields() {
		staffID.setText(null);
		staffName.clear();
		dob.getEditor().clear();
		email.clear();
	}
	
	private void saveAlert(Employee employee){
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Employee saved successfully.");
		alert.setHeaderText(null);
		alert.setContentText("The employee "+employee.getStaffName()+" " +" has been created and \n"+" id is "+ employee.getStaffid() +".");
		alert.showAndWait();
	}
	
	private void updateAlert(Employee employee){
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("employee updated successfully.");
		alert.setHeaderText(null);
		alert.setContentText("The employee "+employee.getStaffName()+" "+" has been updated.");
		alert.showAndWait();
	}
//	
//	public long getStaffId() {
//		return staffID.get;
//	}
	
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


	public String getEmail() {
		return email.getText();
	}
  

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
//		employeeTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		setColumnProperties();
		
		// Add all employees into table
//		loadEmployeeDetails();
	}
	
	
	
	/*
	 *  Set All employeeTable column properties
	 */
	private void setColumnProperties(){
		/* Override date format in table
		 * colDOB.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<LocalDate>() {
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
		 }));*/
		
//		colstaffID.setCellValueFactory(new PropertyValueFactory<>("staffID"));
//		staffNameCol.setCellValueFactory(new PropertyValueFactory<>("staff_Name"));
//		uaeIdCol.setCellValueFactory(new PropertyValueFactory<>("uae_id"));
//		colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
//		batchCol.setCellValueFactory(new PropertyValueFactory<>("batch"));
//		grade.setCellValueFactory(new PropertyValueFactory<>("staff_grade"));
//		colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		colEdit.setCellFactory(cellFactory);
	}
	
	Callback<TableColumn<Employee, Boolean>, TableCell<Employee, Boolean>> cellFactory = 
			new Callback<TableColumn<Employee, Boolean>, TableCell<Employee, Boolean>>()
	{
		@Override
		public TableCell<Employee, Boolean> call( final TableColumn<Employee, Boolean> param)
		{
			final TableCell<Employee, Boolean> cell = new TableCell<Employee, Boolean>()
			{
				Image imgEdit = new Image(getClass().getResourceAsStream("/images/edit.png"));
				final Button btnEdit = new Button();
				
				@Override
				public void updateItem(Boolean check, boolean empty)
				{
					super.updateItem(check, empty);
					if(empty)
					{
						setGraphic(null);
						setText(null);
					}
					else{
						btnEdit.setOnAction(e ->{
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
					}
				}

				private void updateEmployee(Employee employee) {
//					staffID.setText((employee.getStaffid()));
					staffName.setText(employee.getStaffName());
//					lastName.setText(employee.getLastName());
//					dob.setValue(employee.getDob());
					
				}
			};
			return cell;
		}
	};

	
	
	/*
	 *  Add All employees to observable list and update table
	 */
	private void loadEmployeeDetails(){
		employeeList.clear();
		employeeList.addAll(employeeService.findAll());

		employeeTable.setItems(employeeList);
	}
	
	/*
	 * Validations
	 */
	private boolean validate(String field, String value, String pattern){
		if(!value.isEmpty()){
			Pattern p = Pattern.compile(pattern);
	        Matcher m = p.matcher(value);
	        if(m.find() && m.group().equals(value)){
	            return true;
	        }else{
	        	validationAlert(field, false);            
	            return false;            
	        }
		}else{
			validationAlert(field, true);            
            return false;
		}        
    }
	
	private void validationAlert(String field, boolean empty){
		Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Validation Error");
        alert.setHeaderText(null);
        if(field.equals("Role")) alert.setContentText("Please Select "+ field);
        else{
        	if(empty) alert.setContentText("Please Enter "+ field);
        	else alert.setContentText("Please Enter Valid "+ field);
        }
        alert.showAndWait();
	}
}