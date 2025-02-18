 public class FullTimeStaff extends StaffHire
{
    public double salary;
    public int weeklyFractionalHours;
    
    public FullTimeStaff(int vacancyNumber, int designationType, String jobType, String staffName, String joiningDate, String qualification, String appointedBy, boolean joined){
        super(vacancyNumber, designationType, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    }
    
    public void CheackSalary() {
        boolean validSalary; 
        if(salary > 0.0)
        {
            super.displayDetails();
        }
        else
        {
            displayDetails();
        }
    }
    
    public double getSalary() {
        return salary;
    }

    public int getDesignationType() {
        return weeklyFractionalHours;
    }
    
    public void setSalary(double newSalary) {
        if (super.joined) { // Checking if the staff has joined
            this.salary = newSalary;
        } else {
            System.out.println("No staff appointed to set the salary.");
        }
    }
    
    public void setWeeklyFractionalHours(int newWeeklyFractionalHours) {
        this.weeklyFractionalHours = newWeeklyFractionalHours;
    }
    
    @Override
    public void displayDetails() {
        System.out.println("Vacancy Number: " + vacancyNumber);
        System.out.println("Designation: " + designationType);
        System.out.println("Job Type: " + jobType);
        System.out.println("Staff Name: " + staffName);
        System.out.println("Joining Date: " + (joiningDate.isEmpty() ? "Not Assigned" : joiningDate));
        System.out.println("Qualification: " + qualification);
        System.out.println("Appointed By: " + appointedBy);
        System.out.println("Joined: " + joined);
        System.out.println("Salary: " + salary);
        System.out.println("Weekly hours: " + weeklyFractionalHours);
    }
}
