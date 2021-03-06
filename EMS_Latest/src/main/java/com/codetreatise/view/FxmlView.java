package com.codetreatise.view;

import java.util.ResourceBundle;

public enum FxmlView {

    USER {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("user.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/User.fxml";
        }
    }, 
    LOGIN {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("login.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/Login.fxml";
        }
    },
    EMPLOYEE {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("employee.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/Employee.fxml";
        }
    },
    LEAVE {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("leave.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/LeaveScene.fxml";
        }
    },
    ALLOCATION {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("allocation.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/Allocation.fxml";
        }
    },
    TRAINING {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("training.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/Training.fxml";
        }
    },
    ASSESSMENT {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("assessment.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/Assessment.fxml";
        }
    },
    AOW {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("areaOfWork.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/Work.fxml";
        }
    };
    
    public abstract String getTitle();
    public abstract String getFxmlFile();
    
       
    String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("Bundle").getString(key);
    }

}
