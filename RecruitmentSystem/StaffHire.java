public class StaffHire
{
    public int vacancyNumber;
    public int designationType;
    public String jobType;
    public String staffName;
    public String joiningDate;
    public String qualification;
    public String appointedBy;
    public boolean joined;
    
    public StaffHire(int vacancyNumber, int designationType, String jobType, String staffName, String joiningDate, String qualification, String appointedBy, boolean joined) {
        this.vacancyNumber = vacancyNumber;
        this.designationType = designationType;
        this.jobType = jobType;
        this.staffName = staffName;
        this.joiningDate = joiningDate;
        this.qualification = qualification;
        this.appointedBy = appointedBy;
        this.joined = joined;
    }
    
       public int getVacancyNumber() {
        return vacancyNumber;
    }

    public int getDesignationType() {
        return designationType;
    }

    public String getJobType() {
        return jobType;
    }

    public String getStaffName() {
        return staffName;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public String getQualification() {
        return qualification;
    }

    public String getAppointedBy() {
        return appointedBy;
    }

    public boolean isJoined() {
        return joined;
    }


    public void setVacancyNumber(int vacancyNumber) {
        this.vacancyNumber = vacancyNumber;
    }

    public void setDesignationType(int designationType) {
        this.designationType = designationType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setAppointedBy(String appointedBy) {
        this.appointedBy = appointedBy;
    }

    public void setJoined(boolean joined) {
        this.joined = joined;
    }
    
    public void displayDetails() {
        System.out.println("Vacancy Number: " + vacancyNumber);
        System.out.println("Designation: " + designationType);
        System.out.println("Job Type: " + jobType);
        System.out.println("Staff Name: " + staffName);
        System.out.println("Joining Date: " + (joiningDate.isEmpty() ? "Not Assigned" : joiningDate));
        System.out.println("Qualification: " + qualification);
        System.out.println("Appointed By: " + appointedBy);
        System.out.println("Joined: " + joined);
    }
}
