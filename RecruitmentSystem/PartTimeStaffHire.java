public class PartTimeStaffHire extends StaffHire
{
    public int workingHour;
    public double wagesPerHour;
    public String shifts;
    public boolean terminated;
    
    public PartTimeStaffHire(int vacancyNumber, int designationType, String jobType, String staffName, String joiningDate, String qualification, String appointedBy, boolean joined, int workingHour, double wagesPerHour, String shifts, boolean terminated){
        super(vacancyNumber, designationType, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        this.workingHour = workingHour;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false;
    }
    
    public double getIncomePerDay() {
        return workingHour * wagesPerHour; 
    }
    
    public void checkWorkingHour() {
        if (workingHour > 0) {
            displayDetails();
        }
        else
        {
            super.displayDetails();
        }
    }
    
    public int getWorkingHour() {
        return workingHour;
    }
    
    public double getWagesPerHour() {
        return wagesPerHour;
    }
    
    public String getShifts() {
        return shifts;
    }
    
    public boolean getTerminated() {
        return terminated;
    }
    
    public void terminateStaff() {
        if (terminated)
        { 
            super.staffName = "";
            super.joiningDate = "";
            super.qualification = "";
            super.appointedBy = "";
            super.joined = false;
            this.terminated = true;
        }
    }
    
    public void setWorkingShifts(String newWorkingShifts) {
        if (super.joined)
        {
            this.shifts = newWorkingShifts;
        }
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
        System.out.println("Wages per hour: " + wagesPerHour);
        System.out.println("Working hours: " + workingHour);
        System.out.println("Working hours: " + workingHour);
        System.out.println("Shifts: " + shifts);
        System.out.println("Terminated: " + terminated);
        System.out.println("Income per day: " + getWorkingHour());
    }
}
