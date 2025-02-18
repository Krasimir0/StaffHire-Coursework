 public class FullTimeStaff extends StaffHire
{
    public double salary;
    public int weeklyFractionalHours;
    
    public FullTimeStaff(int vacancyNumber, int designationType, String jobType, String staffName, String joiningDate, String qualification, String appointedBy, boolean joined){
        super(vacancyNumber, designationType, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
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
}
