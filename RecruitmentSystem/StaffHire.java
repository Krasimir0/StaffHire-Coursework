
/**
 * Write a description of class StaffHire here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StaffHire
{
    private int vacancyNumber;
    private int designationType;
    private String jobType;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private boolean joined;
    
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

    // Setters
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
    
}
