public class VehicleInfo
{
    //Variables for this class
    String model;//Name of the vehicle model
    String year;//Year in which the vehicle was manufactured
    String type;//Type of vehicle, must select from: sedan, hatchback, luxury, sport, other
    String method;//How  the  vehicle  was  acquired  --  must  select  from:  new,  certified  pre-owned, used, other

    //Constructor for this class
    public VehicleInfo(String themodel, String theyear, String thetype, String themethod)
    {
        model = themodel;
        year = theyear;
        type = thetype;
        method = themethod;
    }

    //Method to return the model
    String getModel()
    {
        return model;
    }

    //Method to return the year
    String getYear()
    {
        return year;
    }

    //Method to return the type
    String getType()
    {
        return type;
    }

    //Method to return the method
    String getMethod()
    {
        return method;
    }

    //Method to change the model
    void updateModel(String newmodel)
    {
        model = newmodel;
    }

    //Method to change the year
    void updateYear(String newyear)
    {
        year = newyear;
    }

    //Method to change the type
    void updateType(String newtype)
    {
        type = newtype;
    }

    //Method to change the method
    void updateMethod(String newmethod)
    {
        method = newmethod;
    }


}
