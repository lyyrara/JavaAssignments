import java.util.Comparator;
import java.util.Objects;

class Record implements Comparable<Record>{
    private String userId;
    private String firstName;
    private String lastName;
    private int version;
    private String insuranceCompany;

    public Record(String userId, String firstName, String lastName, int version, String insuranceCompany) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.version = version;
        this.insuranceCompany = insuranceCompany;
    }

    @Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Record r = (Record)obj;
		return this.userId.equals(r.userId);
	}

    
    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public int compareTo(Record r) {
        int status = this.lastName.compareTo(r.lastName);
        if(status == 0){
            status = this.firstName.compareTo(r.firstName);
        }
        return status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    @Override
    public String toString() {
        return "Record [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", version="
                + version + ", insuranceCompany=" + insuranceCompany + "]";
    }



}