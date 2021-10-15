import java.util.ArrayList;

public class CustomerProfDB {
    private int numCustomer;
    private int currentCustomerIndex;
    private String fileName;
    private ArrayList<CustomerProf> customerList;

    public CustomerProfDB(String name){
        fileName = name;
    }

    public void insertNewProfile(CustomerProf customer){
        customerList.add(customer);
        numCustomer++;
    }
    public boolean deleteProfile(String lastName, String adminID){
        if (customerList.removeIf(customer -> (customer.getAdminID().equals(adminID) && customer.getLastName().equals(lastName)))){
            numCustomer--;
            return true;
        } return false;
    }
    public CustomerProf findProfile(String lastName, String adminID){
        for (CustomerProf customer : customerList){
            if (customer.getAdminID().equals(adminID) && customer.getLastName().equals(lastName)){
                return customer;
            }
        }
        return null;
    }
    public CustomerProf findFirstProfile(){
        if (customerList.isEmpty()){return null;}
        return customerList.get(0);
    }
    public CustomerProf findNextProfile(){
        if (currentCustomerIndex+1 < customerList.size()){
            return customerList.get(currentCustomerIndex+1);
        }
        return null;
    }
    public void writeAllCustomerProf(){
        /**
         * Need to open file and append all of the customer information into it.
         */
        for (CustomerProf customer : customerList){
            String result = customer.getAdminID()+customer.getFirstName()+customer.getLastName()+
                    customer.getAddress()+customer.getPhone()+String.valueOf(customer.getIncome())+
                    customer.getStatus()+customer.getUse();

        }
    }
    public static void main(String []args){
        System.out.println("Hello, Jeff.");
    }
}
