public class Users {
    // Users Functions

    private String passportNumber;
    private String name;

    //------------------------------------------------------------------------------------------------------------------
    Users(String passportNumber, String name) {
        this.passportNumber = passportNumber;
        this.name = name;
    }
    //------------------------------------------------------------------------------------------------------------------
    public String getPassportNumber() {
        return passportNumber;
    }
    //------------------------------------------------------------------------------------------------------------------
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
    //------------------------------------------------------------------------------------------------------------------
    public String getName() {
        return name;
    }
    //------------------------------------------------------------------------------------------------------------------
    public void setName(String name) {
        this.name = name;
    }
    //------------------------------------------------------------------------------------------------------------------
    public void updateDetails(String newName) {
        name = newName;
    }
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Passenger{" + "passportNumber=" + passportNumber + ", name=" + name + '}';
    }

}


}