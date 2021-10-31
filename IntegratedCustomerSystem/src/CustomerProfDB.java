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


    /**
     *  This is a constructor method which accepts
     *  the name of the file in which the customer profiles will be stored.
     * @param Dbname
     */
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

    /**
     * This method accepts a CustomerProf as input and inserts it into the
     * array customerList.
     * @param customer
     */
    public void insertNewProfile(CustomerProf customer){
        customerList.add(customer);
        numCustomer += 1;
    }

    /**
     * This method accepts the adminID and lastName as inputs and deletes
     * the corresponding customer profile. It returns a Boolean value to
     * indicate whether the delete operation was successful.
     * @param lastName
     * @param adminID
     * @return
     */
    public boolean deleteProfile(String lastName, String adminID){
        if (customerList.removeIf(customer -> (customer.getAdminID().equals(adminID) && customer.getLastName().equals(lastName)))){
            numCustomer--;
            return true;
        } return false;
    }

    /**
     *  This method accepts the adminID and lastName as inputs and returns
     *  the corresponding customer profile as output.
     * @param lastName
     * @param adminID
     * @return
     */
    public CustomerProf findProfile(String lastName, String adminID){
        for (CustomerProf customer : customerList){
            if (customer.getAdminID().equals(adminID) && customer.getLastName().equals(lastName)){
                currentCustomerIndex = customerList.indexOf(customer);
                return customer;
            }
        }
        return null;
    }

    /**
     * This function returns the first customer in the customer list if it's
     * not empty. returns null if empty.
     * @return
     */
    public CustomerProf findFirstProfile(){
        if (customerList.isEmpty()){return null;}
        currentCustomerIndex = 0;
        return customerList.get(0);
    }

    /**
     * Using the currentCustomerIndex, this method returns the next customer in line.
     * @return
     */
    public CustomerProf findNextProfile(){
        if (currentCustomerIndex+1 < customerList.size()){
            currentCustomerIndex++;
            return customerList.get(currentCustomerIndex);
        }
        return null;
    }

    /**
     * returns the customer list.
     * @return
     */
    public ArrayList<CustomerProf> getCustomerList(){
        return customerList;
    }

    /**
     *  This method writes all CustomerProf stored in the array customerList to
     *  the database file, which is provided as input to the system at startup.
     */
    public void writeAllCustomerProf(){
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

    /**
     * This method is used upon startup to read in the existing customer profiles
     * that are currently in the database file.
     * @param fileName
     * @throws IOException
     */
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

    /**
     *  This method is used the second added constructor in CustomerProf to create
     *  the customers from the database.
     * @param db
     */
    private void initializeCustomerProf(ArrayList<String> db) {
        // create a new constructor in CustomerProf to handle this type of batch initialization.
        for (String customer : db){
            CustomerProf newCustomerProf = new CustomerProf(customer);
            customerList.add(newCustomerProf);
            numCustomer++;
        }
    }

    /**
     * On the go testing Area for this class.
     * @param args
     */
    public static void main(String []args){

        /*CustomerProfDB customerDB = new CustomerProfDB("Dbdata.txt");
        CustomerProf newCustomer = new CustomerProf(
                "Jeff16123", "Jude", "Remy", "77-Roxbury-Rd",
                "8603565957", (float) 10000000000.000, "Single", "No", new VehicleInfo("Toyota", "2021", "sport", "new"));
        customerDB.insertNewProfile(newCustomer);
        customerDB.writeAllCustomerProf();*/
        
    }
}
