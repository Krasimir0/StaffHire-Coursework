import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RecruitmentSystemGUI {
    private JFrame frame;
    private JTextField vacancyNumberField, designationField, jobTypeField, staffNameField,
            joiningDateField, qualificationField, appointedByField, salaryField,
            weeklyHoursField, workingHoursField, wagesPerHourField, shiftsField, displayNumberField, terminated;
    private JCheckBox joinedCheckBox;
    private JCheckBox terminateCheckBox;
    private Database database;  

    public RecruitmentSystemGUI() {
        database = new Database(); // Initialize database
        
        frame = new JFrame("Recruitment System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(new GridLayout(10, 2));
        
        // Adding fields
        frame.add(new JLabel("Vacancy Number:"));
        vacancyNumberField = new JTextField();
        frame.add(vacancyNumberField);
        
        frame.add(new JLabel("Designation:"));
        designationField = new JTextField();
        frame.add(designationField);
        
        frame.add(new JLabel("Job Type:"));
        jobTypeField = new JTextField();
        frame.add(jobTypeField);
        
        frame.add(new JLabel("Staff Name:"));
        staffNameField = new JTextField();
        frame.add(staffNameField);
        
        frame.add(new JLabel("Joining Date:"));
        joiningDateField = new JTextField();
        frame.add(joiningDateField);
        
        frame.add(new JLabel("Qualification:"));
        qualificationField = new JTextField();
        frame.add(qualificationField);
        
        frame.add(new JLabel("Appointed By:"));
        appointedByField = new JTextField();
        frame.add(appointedByField);
        
        frame.add(new JLabel("Joined:"));
        joinedCheckBox = new JCheckBox();
        frame.add(joinedCheckBox);
        
        frame.add(new JLabel("Terminated:"));
        terminateCheckBox = new JCheckBox();
        frame.add(terminateCheckBox);
        
        frame.add(new JLabel("Salary:"));
        salaryField = new JTextField();
        frame.add(salaryField);
        
        frame.add(new JLabel("Weekly Fractional Hours:"));
        weeklyHoursField = new JTextField();
        frame.add(weeklyHoursField);
        
        frame.add(new JLabel("Working Hours:"));
        workingHoursField = new JTextField();
        frame.add(workingHoursField);
        
        frame.add(new JLabel("Wages per Hour:"));
        wagesPerHourField = new JTextField();
        frame.add(wagesPerHourField);
        
        frame.add(new JLabel("Shifts:"));
        shiftsField = new JTextField();
        frame.add(shiftsField);
        
        frame.add(new JLabel("Display Number:"));
        displayNumberField = new JTextField();
        frame.add(displayNumberField);
        
        // Buttons
        JButton addFullTimeButton = new JButton("Add Full Time Staff");
        addFullTimeButton.addActionListener(e -> addFullTimeStaff());
        frame.add(addFullTimeButton);
        
        JButton addPartTimeButton = new JButton("Add Part Time Staff");
        addPartTimeButton.addActionListener(e -> addPartTimeStaff());
        frame.add(addPartTimeButton);
        
        JButton setSalaryButton = new JButton("Set Salary");
        setSalaryButton.addActionListener(e -> setSalary());
        frame.add(setSalaryButton);
        
        JButton setShiftButton = new JButton("Set Working Shifts");
        setShiftButton.addActionListener(e -> setShifts());
        frame.add(setShiftButton);
        
        JButton terminateButton = new JButton("Terminate Part Time Staff");
        terminateButton.addActionListener(e -> terminateStaff());
        frame.add(terminateButton);
        
        JButton displayButton = new JButton("Display Staff Info");
        displayButton.addActionListener(e -> displayStaff());
        frame.add(displayButton);
        
        JButton clearButton = new JButton("Clear Fields");
        clearButton.addActionListener(e -> clearFields());
        frame.add(clearButton);
        
        frame.setVisible(true);
    }

    private void addFullTimeStaff() {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
            int designationType = Integer.parseInt(designationField.getText());
            String jobType = jobTypeField.getText();
            String staffName = staffNameField.getText();
            String joiningDate = joiningDateField.getText();
            String qualification = qualificationField.getText();
            String appointedBy = appointedByField.getText();
            boolean joined = joinedCheckBox.isSelected();
            double salary = Double.parseDouble(salaryField.getText());
            int weeklyHours = Integer.parseInt(weeklyHoursField.getText());

            FullTimeStaff fullTimeStaff = new FullTimeStaff(vacancyNumber, designationType, jobType, staffName, joiningDate, qualification, appointedBy, joined, salary, weeklyHours);
            database.addStaff(fullTimeStaff); // Adding to database
            JOptionPane.showMessageDialog(frame, "Full Time Staff Added Successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid input! Please enter correct values.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
      private void addPartTimeStaff() {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
            int designationType = Integer.parseInt(designationField.getText());
            String jobType = jobTypeField.getText();
            String staffName = staffNameField.getText();
            String joiningDate = joiningDateField.getText();
            String qualification = qualificationField.getText();
            String appointedBy = appointedByField.getText();
            boolean joined = joinedCheckBox.isSelected();
            int workingHours = Integer.parseInt(workingHoursField.getText());
            String shifts = shiftsField.getText();
            double wagesPerHour = Double.parseDouble(wagesPerHourField.getText());
            boolean terminated = terminateCheckBox.isSelected();
            
            PartTimeStaffHire partTimeStaff = new PartTimeStaffHire(vacancyNumber, designationType, jobType, staffName, joiningDate, qualification, appointedBy, joined, workingHours, wagesPerHour, shifts, terminated);
            database.addStaff(partTimeStaff); // Adding to database
            JOptionPane.showMessageDialog(frame, "Part Time Staff Added Successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid input! Please enter correct values.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void setSalary() {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
            double newSalary = Double.parseDouble(salaryField.getText());

            for (FullTimeStaff staff : database.getFullTimeStaffList()) {
                if (staff.getVacancyNumber() == vacancyNumber) {
                    if(staff.joined) {
                        staff.setSalary(newSalary);
                        JOptionPane.showMessageDialog(frame, "Salary Updated Successfully!");
                        return;
                    }
                    else{
                        JOptionPane.showMessageDialog(frame, "No staff appointed to set the salary.");
                        return;
                    }
                }
            }
            JOptionPane.showMessageDialog(frame, "Vacancy Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid input! Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void setShifts() {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
            String newShift = shiftsField.getText();

            for (PartTimeStaffHire staff : database.getPartTimeStaffList()) {
                if (staff.getVacancyNumber() == vacancyNumber) {
                     if(staff.joined) {
                          staff.setWorkingShifts(newShift);
                          JOptionPane.showMessageDialog(frame, "Shift Updated Successfully!");
                          return;
                    }
                    else{
                        JOptionPane.showMessageDialog(frame, "No staff appointed to set a shift.");
                        return;
                    }
                }
            }
            JOptionPane.showMessageDialog(frame, "Vacancy Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid input! Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void terminateStaff() {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());

            for (PartTimeStaffHire staff : database.getPartTimeStaffList()) {
                if (staff.getVacancyNumber() == vacancyNumber) {
                    if(staff.terminated)
                    {
                    staff.terminateStaff();
                    JOptionPane.showMessageDialog(frame, "Part Time Staff Terminated Successfully!");
                    return;
                    }
                    else
                    {
                     JOptionPane.showMessageDialog(frame, "Staff is already terminated");   
                     return;
                    }

                }
            }
            JOptionPane.showMessageDialog(frame, "Vacancy Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid input! Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
   private void displayStaff() {
    try {
        int vacancyNumber = Integer.parseInt(displayNumberField.getText());
        boolean found = false;
        
        for (FullTimeStaff staff : database.getFullTimeStaffList()) {
            if (staff.getVacancyNumber() == vacancyNumber) {
            if(staff.salary > 0.0)
            {
                staff.displayDetails(); 
                return;
            }
            else
            {
                ((StaffHire) staff).displayDetails();
                return;
            }
            }
        }
        
        for (PartTimeStaffHire staff : database.getPartTimeStaffList()) {
                if (staff.getVacancyNumber() == vacancyNumber) {
                    if(staff.workingHour > 0)
                    {
                        staff.displayDetails(); 
                        return;
                    }
                    else
                    {
                        ((StaffHire) staff).displayDetails();
                        return;
                    }
                }
            }
        JOptionPane.showMessageDialog(frame, "Vacancy Number Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(frame, "Invalid input! Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}



    private void clearFields() {
        vacancyNumberField.setText("");
        designationField.setText("");
        jobTypeField.setText("");
        staffNameField.setText("");
        joiningDateField.setText("");
        qualificationField.setText("");
        appointedByField.setText("");
        salaryField.setText("");
        weeklyHoursField.setText("");
        shiftsField.setText("");
        displayNumberField.setText("");
        wagesPerHourField.setText("");
        workingHoursField.setText("");
        joinedCheckBox.setSelected(false);
        terminateCheckBox.setSelected(false);   
    }

    public static void main(String[] args) {
        new RecruitmentSystemGUI();
    }
}
