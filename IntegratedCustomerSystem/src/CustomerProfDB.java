import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class CustomerProfDB {
    private int numCustomer;
    private int currentCustomerIndex;
    private String fileName;
    private ArrayList<CustomerProf> customerList;

    public CustomerProfDB(String Dbname){
        fileName = Dbname;
        customerList = new ArrayList<>();
        numCustomer = 0;
        currentCustomerIndex = 0;
        try{
            initializeDatabase(fileName);
        }catch (Exception e){
            System.out.println("Could not create File: " + fileName);
        }
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
    public ArrayList<CustomerProf> getCustomerList(){
        return customerList;
    }
    public void writeAllCustomerProf(){
        //File myFile = new File(fileName);
        try{
            FileWriter myFileWriter = new FileWriter(fileName);
            for (CustomerProf customer : customerList){
                String result = customer.getAdminID()+" "+customer.getFirstName()+" "+customer.getLastName()+" "+
                        customer.getAddress()+" "+customer.getPhone()+" "+String.valueOf(customer.getIncome())+" "+
                        customer.getStatus()+" "+customer.getUse() + " "+ customer.getVehicleInfo().getModel() + " " +
                        customer.getVehicleInfo().getYear() + " " + customer.getVehicleInfo().getType() + " " +
                        customer.getVehicleInfo().getMethod() + "\n";
                myFileWriter.append(result);
            }
            myFileWriter.close();
        }catch (Exception e){
            System.out.println("Error: could not write to file : "+fileName+ " With Error: "+ e.toString());
        }
    }
    public void initializeDatabase(String fileName) throws IOException {
        File myFile = new File(fileName);
        if (myFile.createNewFile()){return;}

        ArrayList<String> db = new ArrayList<>();
        try{
            FileInputStream FIS = new FileInputStream(fileName);
            Scanner scan = new Scanner(FIS);
            while(scan.hasNextLine()){
                db.add(scan.nextLine());
            }
            scan.close();
        }catch(Exception e){
            System.out.println("Error while reading the file: "+ e);
        }
        initializeCustomerProf(db);
    }
    private void initializeCustomerProf(ArrayList<String> db) {
        // create a new constructor in CustomerProf to handle this type of batch initialization.
        for (String customer : db){
            CustomerProf newCustomerProf = new CustomerProf(customer);
            customerList.add(newCustomerProf);
            numCustomer++;
        }
    }

    public static void main(String []args){
        /*System.out.println("Hello, Jeff.");
        CustomerProfDB customerDB = new CustomerProfDB("Dbdata.txt");
        CustomerProf newCustomer = new CustomerProf(
                "Jeff16123", "Jude", "Remy", "77-Roxbury-Rd",
                "8603565957", (float) 10000000000.000, "Single", "No", new VehicleInfo("Toyota", "2021", "sport", "new"));
        customerDB.insertNewProfile(newCustomer);
        customerDB.writeAllCustomerProf();*/
    }
}
