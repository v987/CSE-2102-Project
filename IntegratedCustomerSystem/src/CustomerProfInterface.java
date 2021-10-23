import java.util.Scanner;

public class CustomerProfInterface
{
    //Variables
    private CustomerProfDB customerdb;
    private String filepath;

    //Class constructor
    public CustomerProfInterface(String thefilepath)
    {
        filepath = thefilepath;
        customerdb = new CustomerProfDB(filepath);
    }

    //Method to accept user input for what to do
    void getUserChoice()
    {
        //Create a scanner
        Scanner in = new Scanner(System.in);
        //Loop to perpetually ask user what to do
        boolean keeplooping = true;
        String adminID;
        int choice;
        while (keeplooping)
        {
            //Ask for adminID
            System.out.print("Enter your adminID: ");
            adminID = in.nextLine();
            //Ask the user what to do
            System.out.println("1) Enter a new customer");
            System.out.println("2) Delete a customer");
            System.out.println("3) Display a customer profile");
            System.out.println("4) Modify a customer profile");
            System.out.println("5) Display all customer profiles");
            System.out.println("6) Exit interface");
            //Do what the user said to
            System.out.println("\n What would you like to do? (Enter corresponding integer): ");
            choice = in.nextInt();
            switch (choice)
            {
                case 1: customerdb.insertNewProfile(createNewCustomerProf(adminID)); break;
                case 2: deleteCustomerProf(adminID); break;
                case 3: findCustomerProf(adminID); break;
                case 4: updateCustomerProf(adminID); break;
                case 5: displayAllCustomerProf(adminID); break;
                default: keeplooping = false; writeToDB();
            }
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
    void deleteCustomerProf(String adminID)
    {
        //Input the last name
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the last name: ");
        String lastName = in.nextLine();
        //Output if it was unsuccessful or successful
        if (!customerdb.deleteProfile(lastName, adminID))
            System.out.println("Deletion failed!");
        else
            System.out.println("Deletion complete!");
        in.close();
    }

    //Method to find a customer
    void findCustomerProf(String adminID)
    {
        //Input the last name
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the last name: ");
        String lastName = in.nextLine();
        //Get the customer if it exists
        CustomerProf thecustomer = customerdb.findProfile(lastName, adminID);
        //Output
        if (thecustomer==null)
            System.out.println("That person does not exist or you are not authorized to find them!");
        else
            displayCustomerProf(thecustomer);
        in.close();
    }

    void updateCustomerProf(String adminID)
    {
        //Input the last name
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the last name: ");
        String lastName = in.nextLine();
        //Get the current CustomerProf
        CustomerProf thecustomer = customerdb.findProfile(lastName, adminID);
        //Ensure it isn't null
        if (thecustomer==null)
        {
            System.out.println("That customer profile does not exist or you are not authorized to modify it!");
            return;
        }
        //Ask user what attribute to update
        System.out.println("Which attribute would you like to update?\n\n1) Address\n2) Phone\n3) Use\n4) Status\n5) Model\n6) Year\n7) Type\n8) Method");
        System.out.print("Enter corresponding integer: ");
        int choice = in.nextInt();
        //Update what the user said to update
        VehicleInfo thevehicleinfo = thecustomer.getVehicleInfo();
        System.out.print("Enter the new attribute: ");
        switch (choice)
        {
            case 1: thecustomer.updateAddress(in.nextLine()); break;
            case 2: thecustomer.updatePhone(in.nextLine()); break;
            case 3: thecustomer.updateUse(in.nextLine()); break;
            case 4: thecustomer.updateStatus(in.nextLine()); break;
            case 5: thevehicleinfo.updateModel(in.nextLine()); break;
            case 6: thevehicleinfo.updateYear(in.nextLine()); break;
            case 7: thevehicleinfo.updateType(in.nextLine()); break;
            case 8: thevehicleinfo.updateMethod(in.nextLine());
        }
        //Reinsert the updated vehicle info into the customer profile
        thecustomer.updateVehicleInfo(thevehicleinfo);
        //Delete the old profile and insert the new one
        customerdb.deleteProfile(lastName, adminID);
        customerdb.insertNewProfile(thecustomer);
        in.close();
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
