import java.util.Scanner;

public class CustomerProfInterface
{
    //Variables
    CustomerProfDB customerdb;
    String filepath;

    //Class constructor************************************HAVE TO FINISH IMPLEMENTING THIS?
    public CustomerProfInterface(String thefilepath)
    {
        filepath = thefilepath;
        customerdb = new CustomerProfDB(filepath);
    }

    //Method to accept user input for what to do*******************STILL HAVE TO IMPLEMENT THIS
    void getUserChoice()
    {
        //Create a scanner
        Scanner in = new Scanner(System.in);
        //Loop to perpetually ask user what to do
        boolean keeplooping = true;
        String adminID;
        while (keeplooping)
        {
            //Ask for adminID
            System.out.print("Enter your adminID: ");
            adminID = in.nextLine();
            //Ask the user what to do

        }
        //Close the scanner
        in.close();
    }

    VehicleInfo createNewVehicleInfo()
    {
        Scanner in = new Scanner(System.in);
        //Input info for their vehicle
        System.out.print("Model: ");
        String model = in.nextLine();
        System.out.print("Year: ");
        String year = in.nextLine();
        System.out.print("Type: ");
        String type = in.nextLine();
        System.out.print("Method: ");
        String method = in.nextLine();
        //Close the scanner
        in.close();
        //Return a VehicleInfo object with specified attributes
        return new VehicleInfo(model, year, type, method);
    }

    CustomerProf createNewCustomerProf(String adminID)
    {
        //Create scanner
        Scanner in = new Scanner(System.in);
        //Input new info for customer
        System.out.println("Input the updated info:\n");
        System.out.print("First Name: ");
        String firstName = in.nextLine();
        System.out.print("Last Name: ");
        String lastName = in.nextLine();
        System.out.print("Address: ");
        String address = in.nextLine();
        System.out.print("Phone Number: ");
        String phone = in.nextLine();
        System.out.print("Income: $");
        float income = in.nextFloat();
        System.out.print("Status: ");
        String status = in.nextLine();
        System.out.print("Use: ");
        String use = in.nextLine();
        //Close scanner
        in.close();
        //Get vehicleinfo
        VehicleInfo thevehicle = createNewVehicleInfo();
        //Create and return the customer prof
        return new CustomerProf(adminID, firstName, lastName, address, phone, income, status, use, thevehicle);
    }

    //Method to delete a user
    void deleteCustomerProf(String lastName, String adminID)
    {
        //Output if it was unsuccessful or successful
        if (!customerdb.deleteProfile(lastName, adminID))
            System.out.println("Deletion failed!");
        else
            System.out.println("Deletion complete!");
    }

    //Method to find a customer
    void findCustomerProf(String lastName, String adminID)
    {
        //Get the customer if it exists
        CustomerProf thecustomer = customerdb.findProfile(lastName, adminID);
        //Output
        if (thecustomer==null)
            System.out.println("That person does not exist or you are not authorized to find them!");
        else
            displayCustomerProf(thecustomer);
    }

    void updateCustomerProf(String adminID)
    {
        //Get the new customer prof
        CustomerProf newprof = createNewCustomerProf(adminID);
        //Delete the customer if it exists
        customerdb.deleteProfile(newprof.getLastName(), adminID);
        //Input the new profile
        customerdb.insertNewProfile(newprof);
    }

    void displayCustomerProf(CustomerProf thecustomer)
    {
        System.out.println("Admin ID: " + thecustomer.getAdminID());
        System.out.println("First Name : " + thecustomer.getFirstName());
        System.out.println("Last Name: " + thecustomer.getLastName());
        System.out.println("Address: " + thecustomer.getAddress());
        System.out.println("Phone #: " + thecustomer.getPhone());
        System.out.println("Income: " + thecustomer.getIncome());
        System.out.println("Status: " + thecustomer.getStatus());
        System.out.println("Use: " + thecustomer.getUse());
        System.out.println("Vehicle Info: " + thecustomer.getVehicleInfo());
        System.out.println();
    }

    void displayAllCustomerProf(String adminID)
    {

    }

    void writeToDB()
    {
        customerdb.writeAllCustomerProf();
    }
}
