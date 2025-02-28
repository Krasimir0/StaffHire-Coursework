 public class FullTimeStaff extends StaffHire
{
    public double salary;
    public int weeklyFractionalHours;
    
    public FullTimeStaff(int vacancyNumber, int designationType, String jobType, String staffName, String joiningDate, String qualification, String appointedBy, boolean joined, double salary, int weeklyFractionalHours){
        super(vacancyNumber, designationType, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    }
    
    public void checkSalary() { 
        if(salary > 0.0)
        {
            displayDetails();
        }
        else
        {
            super.displayDetails();
        }
    }
    
    public double getSalary() {
        return salary;
    }

    public int getWeeklyFractionalHours() {
        return weeklyFractionalHours;
    }
    
    public void setSalary(double newSalary) {
        if (super.joined) {
            this.salary = newSalary;
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
