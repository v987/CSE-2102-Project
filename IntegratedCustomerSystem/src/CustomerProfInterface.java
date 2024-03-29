import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerProfInterface
{
    //Variables
    private CustomerProfDB customerdb;
    private String filepath;
    private static Scanner in;

    //Class constructor
    public CustomerProfInterface(String thefilepath)
    {
        filepath = thefilepath;
        customerdb = new CustomerProfDB(filepath);
        //in = new Scanner(System.in);
        getUserChoice();
        //in.close();
    }

    //Method to accept user input for what to do
    public void getUserChoice()
    {
        //Create a scanner
        //Scanner input = new Scanner(System.in);
        //input.nextLine();
        //Loop to perpetually ask user what to do
        boolean keeplooping = true;
        boolean tryinput = true;
        String adminID;
        int choice = 0;
        //System.out.print("Input test: ");
        //in.nextLine();
        while (keeplooping)
        {
            //Ask for adminID
            System.out.print("Enter your adminID: ");
            //System.out.println(in.hasNextLine());
            adminID = in.nextLine();
            //Ask the user what to do
            System.out.println("\n1) Enter a new customer");
            System.out.println("2) Delete a customer");
            System.out.println("3) Display a customer profile");
            System.out.println("4) Modify a customer profile");
            System.out.println("5) Display all customer profiles");
            System.out.println("6) Exit interface");
            //Do what the user said to
            tryinput = true;
            while (tryinput)
            {
                try
                {
                    System.out.print("\nWhat would you like to do? (Enter corresponding integer): ");
                    choice = in.nextInt();
                    in.nextLine();
                    tryinput = false;
                }
                catch (InputMismatchException e)
                {
                    in.nextLine();
                    System.out.println("That isn't an integer!\n");
                }
            }

            switch (choice)
            {
                case 1: customerdb.insertNewProfile(createNewCustomerProf(adminID)); System.out.println("\nSuccess!"); break;
                case 2: deleteCustomerProf(adminID); break;
                case 3: findCustomerProf(adminID); break;
                case 4: updateCustomerProf(adminID); break;
                case 5: displayAllCustomerProf(adminID); break;
                default: keeplooping = false; writeToDB();
            }
        }
        //Close the scanner
        //input.close();
    }

    VehicleInfo createNewVehicleInfo() {
        //Scanner in = new Scanner(System.in);
        //Input info for their vehicle
        String numbers = "0123456789";
        ArrayList<String> allowedMethod = new ArrayList<>();
        allowedMethod.add("new");
        allowedMethod.add("certified pre-owned");
        allowedMethod.add("used");
        allowedMethod.add("other");

        System.out.print("Model: ");
        String model = in.nextLine();
        System.out.print("Year: ");
        String year;
        while(true){
            year = in.nextLine();
            if (year.length() == 4){
                for (int i = 0; i < year.length(); i++){
                    for (int j = 0; j < year.length(); j++){
                        if (year.charAt(i) == numbers.charAt(j)){
                            break;
                        }
                    }
                }
                break;
            }
            System.out.println("Not a valid phone number, please enter a valid year like 1234: ");
            year = in.nextLine();
        }
        boolean keeptrying = true;
        String type = "";
        while (keeptrying)
        {
            System.out.print("Type: ");
            type = in.nextLine();
            //Type of vehicle, must select from: sedan, hatchback, luxury, sport, other
            if (type.equals("sedan") || type.equals("hatchback") || type.equals("luxury") || type.equals("sport") || type.equals("other"))
                keeptrying = false;
            else
                System.out.println("That isn't a valid choice! Valid choices include hatchback, luxury, sport, and other.\n");
        }
        System.out.print("Method: ");
        String method = in.nextLine();
        while(!allowedMethod.contains(method)){
            System.out.println("Please select one of the following: [new, certified pre-owned, used, other]");
            method = in.nextLine();
        }
        //Close the scanner
        //in.close();
        //Return a VehicleInfo object with specified attributes
        return new VehicleInfo(model, year, type, method);
    }

    CustomerProf createNewCustomerProf(String adminID)
    {
        //Create scanner
        //Scanner in = new Scanner(System.in);
        //Input new info for customer
        //System.out.println("Input the updated info:\n");
        String numbers = "0123456789";
        System.out.print("First Name: ");
        String firstName = in.nextLine();
        System.out.print("Last Name: ");
        String lastName = in.nextLine();
        System.out.print("Address: ");
        String address = in.nextLine();
        System.out.print("Phone Number: ");
        String phone = in.nextLine();
        while(phone.length() != 10){
            System.out.println("Not a valid phone number, please enter a valid year like 1234567899: ");
            phone = in.nextLine();
            boolean state = false;
            for (int i = 0; i < phone.length(); i++){
                for (int j = 0; j < phone.length(); j++){
                    if (phone.charAt(i) == numbers.charAt(j)){
                        state = true;
                    } else{
                        state = false;
                        break;
                    }
                }
                if (!state){break;}
            }
        }
        float income = 0;
        boolean keeptrying = true;
        //Loop in case user does not enter a float
        while (keeptrying)
        {
            try
            {
                System.out.print("Income: $");
                income = in.nextFloat();
                keeptrying = false;
                in.nextLine();
            }
            catch (InputMismatchException e)
            {
                in.nextLine();
                System.out.println("That is not a number!\n");
            }
        }

        keeptrying = true;
        String status = "";
        while (keeptrying)
        {
            System.out.print("Status: ");
            status = in.nextLine();
            if (status.equals("Active") || status.equals("Inactive"))
                keeptrying = false;
            else
                System.out.println("That isn't a valid choice! Valid choices are Active and Inactive.\n");
        }

        keeptrying = true;
        String use = "";
        while (keeptrying)
        {
            System.out.print("Use: ");
            use = in.nextLine();
            if (use.equals("Business") || use.equals("Personal") || use.equals("Both"))
                keeptrying = false;
            else
                System.out.println("That isn't a valid choice! Valid choices are Business, Personal, and Both.\n");
        }
        //Close scanner
        //in.close();
        //Get vehicleinfo
        VehicleInfo thevehicle = createNewVehicleInfo();
        //Create and return the customer prof
        return new CustomerProf(adminID, firstName, lastName, address, phone, income, status, use, thevehicle);
    }

    //Method to delete a user
    void deleteCustomerProf(String adminID)
    {
        //Input the last name
        //Scanner in = new Scanner(System.in);
        System.out.print("\nEnter the last name: ");
        String lastName = in.nextLine();
        //Output if it was unsuccessful or successful
        if (!customerdb.deleteProfile(lastName, adminID))
            System.out.println("Deletion failed!");
        else
            System.out.println("Deletion complete!");
        //in.close();
        System.out.println();
    }

    //Method to find a customer
    void findCustomerProf(String adminID)
    {
        //Input the last name
        //Scanner in = new Scanner(System.in);
        System.out.print("\nEnter the last name: ");
        String lastName = in.nextLine();
        //Get the customer if it exists
        CustomerProf thecustomer = customerdb.findProfile(lastName, adminID);
        //Output
        if (thecustomer==null)
            System.out.println("That person does not exist or you are not authorized to find them!");
        else
            displayCustomerProf(thecustomer);
        System.out.println();
        //in.close();
    }

    void updateCustomerProf(String adminID)
    {
        //Input the last name
        System.out.print("\nEnter the last name: ");
        String lastName = in.nextLine();
        //Get the current CustomerProf
        CustomerProf thecustomer = customerdb.findProfile(lastName, adminID);
        //Ensure it isn't null
        if (thecustomer==null)
        {
            System.out.println("That customer profile does not exist or you are not authorized to modify it!\n");
            return;
        }
        //Ask user what attribute to update
        System.out.println("Which attribute would you like to update?\n\n1) Address\n2) Phone\n3) Use\n4) Status\n5) Model\n6) Year\n7) Type\n8) Method");
        boolean keepasking = true;
        int choice = 0;
        while (keepasking)
        {
            try
            {
                System.out.print("Enter corresponding integer: ");
                choice = in.nextInt();
                in.nextLine();
                if ((choice<1) || (choice>8))
                    System.out.println("Not a valid choice!\n");
                else
                    keepasking = false;
            }
            catch (InputMismatchException e)
            {
                in.nextLine();
                System.out.println("That isn't an integer!\n");
            }
        }
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
        System.out.println("\nUpdate Successful!\n");
    }

    void displayCustomerProf(CustomerProf thecustomer)
    {
        System.out.println("\nAdmin ID: " + thecustomer.getAdminID());
        System.out.println("First Name : " + thecustomer.getFirstName());
        System.out.println("Last Name: " + thecustomer.getLastName());
        System.out.println("Address: " + thecustomer.getAddress());
        System.out.println("Phone #: " + thecustomer.getPhone());
        System.out.println("Income: " + thecustomer.getIncome());
        System.out.println("Status: " + thecustomer.getStatus());
        System.out.println("Use: " + thecustomer.getUse());
        //System.out.println("Vehicle Info: " + thecustomer.getVehicleInfo());
        VehicleInfo thevehicleinfo = thecustomer.getVehicleInfo();
        System.out.println("Model: " + thevehicleinfo.getModel());
        System.out.println("Year: " + thevehicleinfo.getYear());
        System.out.println("Type: " + thevehicleinfo.getType());
        System.out.println("Method: " + thevehicleinfo.getMethod());
        System.out.println();
    }

    void displayAllCustomerProf(String adminID)
    {
        //Get the customer list
        ArrayList customerlist = customerdb.getCustomerList();
        //Traverse the list to print out all applicable customers
        CustomerProf currentcustomer;
        for (int i=0; i<customerlist.size(); i++)
        {
            //Ensure adminID matches
            currentcustomer = (CustomerProf) customerlist.get(i);
            if (currentcustomer.getAdminID().equals(adminID))
                displayCustomerProf(currentcustomer);
        }
        System.out.println("All relevant profiles displayed.\n");
    }

    void writeToDB()
    {
        customerdb.writeAllCustomerProf();
    }

    public static void main(String[] args)
    {
        //Get the filepath
        //Scanner in = new Scanner(System.in);
        in = new Scanner(System.in);
        System.out.print("Enter the path of the database file: ");
        String filepath = in.nextLine();
        //in.close();
        CustomerProfInterface theinterface = new CustomerProfInterface(filepath);
        in.close();
    }
}
