public class CustomerProf
{
    private String adminID;
    private String firstName;
    private String lastName;
    private String address;
    private String  phone;
    private float income;
    private String status;
    private String use;
    private VehicleInfo vehicleInfo;

    public CustomerProf(String adminID, String firstName, String lastName, String address, String phone, float income, String status, String use, VehicleInfo vehicleInfo){
        this.adminID =  adminID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.income = income;
        this.status =  status;
        this.use = use;
        this.vehicleInfo = vehicleInfo;
    }
    public CustomerProf(String customer){
        String[] cust = customer.split(" ");
        System.out.println(cust+ " : " + customer);
        adminID = cust[0];
        firstName = cust[1];
        lastName = cust[2];
        address = cust[3];
        phone = cust[4];
        income = Float.valueOf(cust[5]);
        status = cust[6];
        use = cust[7];
        vehicleInfo = new VehicleInfo(cust[8], cust[9], cust[10], cust[11]);
    }
    public String getAdminID(){return adminID;}
    public float getIncome() {return income;}
    public String getAddress() {return address;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getPhone() {return phone;}
    public String getStatus() {return status;}
    public String getUse() {return use;}
    public VehicleInfo getVehicleInfo() {return vehicleInfo;}

    public void updateAddress(String address) {this.address = address;}
    public void updateAdminID(String adminID) {this.adminID = adminID;}
    public void updateFirstName(String firstName) {this.firstName = firstName;}
    public void updateLastName(String lastName) {this.lastName = lastName;}
    public void updateIncome(float income) {this.income = income;}
    public void updatePhone(String phone) {this.phone = phone;}
    public void updateStatus(String status) {this.status = status;}
    public void updateUse(String use) {this.use = use;}
    public void updateVehicleInfo(VehicleInfo vehicleInfo) {this.vehicleInfo = vehicleInfo;}

    public static void main(String[] args){
        System.out.println("Hello, It's Jeff.");
    }
}
