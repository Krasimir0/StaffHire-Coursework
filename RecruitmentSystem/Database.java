import java.util.ArrayList;
public class Database
{
     private ArrayList<StaffHire> staffList;
     private ArrayList<FullTimeStaff> fullTimeStaffList;
     private ArrayList<PartTimeStaffHire> partTimeStaffList;


    public Database() {
        staffList = new ArrayList<>();
        fullTimeStaffList = new ArrayList<>();
        partTimeStaffList = new ArrayList<>();
    }

   public void addStaff(StaffHire staff) {
    staffList.add(staff);
    
    if (staff instanceof FullTimeStaff) {
        fullTimeStaffList.add((FullTimeStaff) staff);
    } else if (staff instanceof PartTimeStaffHire) {
        partTimeStaffList.add((PartTimeStaffHire) staff);
    }
}
public ArrayList<StaffHire> getStaffList() {
    return staffList;
}

public ArrayList<FullTimeStaff> getFullTimeStaffList() {
    return fullTimeStaffList;
}

public ArrayList<PartTimeStaffHire> getPartTimeStaffList() {
    return partTimeStaffList;
}




}
