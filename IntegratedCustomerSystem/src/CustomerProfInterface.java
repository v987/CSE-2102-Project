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

    }

    //Method to delete a user
    void deleteCustomerProf(String lastName, String adminID)
    {
        //Output if it was unsuccessful
        if (!customerdb.deleteProfile(lastName, adminID))
            System.out.println("Deletion failed!");
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
        }
    }
}
