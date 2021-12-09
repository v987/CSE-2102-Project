import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;

public class GUI {

    //Variables
    private CustomerProfDB customerdb;
    private String filepath;
    private static Scanner in;
    static JFrame mainframe = new JFrame("Integrated Customer System");

    public GUI(String thefilepath)
    {
        filepath = thefilepath;
        customerdb = new CustomerProfDB(filepath);
        mainMenu();
    }

    void mainMenu()
    {
        //Create the frame
        //JFrame frame = new JFrame("Integrated Customer System");
        //Create the box
        Box thebox = Box.createVerticalBox();
        //Create the button group
        ButtonGroup rbg = new ButtonGroup();
        //Create profile radio button
        JRadioButton createprofilerb = new JRadioButton("Create Profile");
        createprofilerb.setFont(createprofilerb.getFont().deriveFont(24.0f));
        createprofilerb.setAlignmentX(Component.CENTER_ALIGNMENT);
        rbg.add(createprofilerb);
        thebox.add(createprofilerb);
        //Delete profile radio button
        JRadioButton deleteprofilerb = new JRadioButton("Delete Profile");
        deleteprofilerb.setFont(createprofilerb.getFont());
        deleteprofilerb.setAlignmentX(Component.CENTER_ALIGNMENT);
        rbg.add(deleteprofilerb);
        thebox.add(deleteprofilerb);
        //Update profile radio button
        JRadioButton updateprofilerb = new JRadioButton("Update Profile");
        updateprofilerb.setFont(createprofilerb.getFont());
        updateprofilerb.setAlignmentX(Component.CENTER_ALIGNMENT);
        rbg.add(updateprofilerb);
        thebox.add(updateprofilerb);
        //Find profile radio button
        JRadioButton findprofilerb = new JRadioButton("Find/Display Profile");
        findprofilerb.setFont(createprofilerb.getFont());
        findprofilerb.setAlignmentX(Component.CENTER_ALIGNMENT);
        rbg.add(findprofilerb);
        thebox.add(findprofilerb);
        //Display all profiles radio button
        JRadioButton displayallprofilerb = new JRadioButton("Display All Profiles");
        displayallprofilerb.setFont(createprofilerb.getFont());
        displayallprofilerb.setAlignmentX(Component.CENTER_ALIGNMENT);
        rbg.add(displayallprofilerb);
        thebox.add(displayallprofilerb);
        //Add invisible label to space things out
        JLabel invisiblelabel = new JLabel(" ");
        invisiblelabel.setFont(createprofilerb.getFont());
        invisiblelabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        thebox.add(invisiblelabel);
        //Select button
        JButton selectbutton = new JButton("Select");
        selectbutton.setFont(selectbutton.getFont().deriveFont(28f));
        selectbutton.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Action Listener for the button
        selectbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean shoulddispose = false;
                //Check each radio button to see which one is selected
                mainframe.setVisible(false);
                if (createprofilerb.isSelected()) {
                    createProfile();
                    shoulddispose = true;
                }
                else if (deleteprofilerb.isSelected()) {
                    deleteProfile();
                    customerdb.writeAllCustomerProf();
                    shoulddispose = true;
                }
                else if (updateprofilerb.isSelected()) {
                    updateProfile();
                    shoulddispose = true;
                }
                else if (findprofilerb.isSelected()) {
                    findProfile();
                    shoulddispose = true;
                }
                else if (displayallprofilerb.isSelected()) {
                    displayAllProfiles();
                    shoulddispose = true;
                }
                /*
                if (shoulddispose)
                    frame.dispose();

                 */
            }
        });
        thebox.add(selectbutton);
        //Add box to the frame
        mainframe.add(thebox);
        mainframe.setSize(500, 600);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setVisible(true);
    }


    void createProfile()
    {

        CreateProfile profile = new CreateProfile();
        customerdb = new CustomerProfDB(filepath);
    }

    void deleteProfile()
    {
        //Create the frame
        JFrame frame = new JFrame("Delete Profile");
        //Create the box
        Box thebox = Box.createVerticalBox();
        //Top panel - for admin id input
        JPanel toppanel = new JPanel(new FlowLayout());
        JLabel adminid = new JLabel("Admin ID:  ");
        adminid.setFont(adminid.getFont().deriveFont(24.0f));
        toppanel.add(adminid);
        JTextField adminidinput = new JTextField();
        adminidinput.setFont(adminidinput.getFont().deriveFont(24.0f));
        adminidinput.setPreferredSize(new Dimension(250,40));
        toppanel.add(adminidinput);
        thebox.add(toppanel);
        //Bottom panel - for last name input
        JPanel bottompanel = new JPanel(new FlowLayout());
        JLabel lastname = new JLabel("Last Name:  ");
        lastname.setFont(adminid.getFont());
        bottompanel.add(lastname);
        JTextField lastnameinput = new JTextField();
        lastnameinput.setFont(adminidinput.getFont());
        lastnameinput.setPreferredSize(new Dimension(250,40));
        bottompanel.add(lastnameinput);
        thebox.add(bottompanel);
        //Delete button
        JButton deletebutton = new JButton("Delete");
        deletebutton.setFont(deletebutton.getFont().deriveFont(28.0f));
        thebox.add(deletebutton);
        //Add invisible label to space things out
        JLabel invisiblelabel = new JLabel(" ");
        invisiblelabel.setFont(adminid.getFont());
        invisiblelabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        thebox.add(invisiblelabel);
        //Add box to the frame
        frame.add(thebox);
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //Delete button action listener
        deletebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean result = customerdb.deleteProfile(lastnameinput.getText(), adminidinput.getText());
                //Show result window
                deleteResult(result);
                //Dispose of this frame
                frame.dispose();
            }
        });
    }

    void deleteResult(boolean result)
    {
        //true = Success    false = Fail
        JFrame frame = new JFrame("Deletion Result");
        Box thebox = Box.createVerticalBox();
        //Label which tells result
        JLabel resultlabel = new JLabel();
        if (result==true)
            resultlabel.setText("Profile Deleted!");
        else
            resultlabel.setText("Deletion Failed!");
        resultlabel.setFont(resultlabel.getFont().deriveFont(24.0f));
        resultlabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        thebox.add(resultlabel);
        //Add invisible label to space things out
        JLabel invisiblelabel = new JLabel(" ");
        invisiblelabel.setFont(resultlabel.getFont());
        invisiblelabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        thebox.add(invisiblelabel);
        //Ok button
        JButton ok = new JButton("OK");
        ok.setFont(ok.getFont().deriveFont(28.0f));
        ok.setAlignmentX(Component.CENTER_ALIGNMENT);
        thebox.add(ok);
        frame.add(thebox);
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //Ok button action listener
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Go back to the main menu
                //mainMenu();
                mainframe.setVisible(true);
                //Dispose of this frame
                frame.dispose();
            }
        });
    }


    void updateProfile()
    {
        UpdateProfile uf = new UpdateProfile(customerdb);
        customerdb = new CustomerProfDB(filepath);
    }

    void findProfile()
    {
        JFrame frame = new JFrame("Find Profile");
        //Create the box
        Box thebox = Box.createVerticalBox();
        //Top panel - for admin id input
        JPanel toppanel = new JPanel(new FlowLayout());
        JLabel adminid = new JLabel("Admin ID:  ");
        adminid.setFont(adminid.getFont().deriveFont(24.0f));
        toppanel.add(adminid);
        JTextField adminidinput = new JTextField();
        adminidinput.setFont(adminidinput.getFont().deriveFont(24.0f));
        adminidinput.setPreferredSize(new Dimension(250,40));
        toppanel.add(adminidinput);
        thebox.add(toppanel);
        //Bottom panel - for last name input
        JPanel bottompanel = new JPanel(new FlowLayout());
        JLabel lastname = new JLabel("Last Name:  ");
        lastname.setFont(adminid.getFont());
        bottompanel.add(lastname);
        JTextField lastnameinput = new JTextField();
        lastnameinput.setFont(adminidinput.getFont());
        lastnameinput.setPreferredSize(new Dimension(250,40));
        bottompanel.add(lastnameinput);
        thebox.add(bottompanel);
        //Find button
        JButton findbutton = new JButton("Find");
        findbutton.setFont(findbutton.getFont().deriveFont(28.0f));
        thebox.add(findbutton);
        //Add invisible label to space things out
        JLabel invisiblelabel = new JLabel(" ");
        invisiblelabel.setFont(adminid.getFont());
        invisiblelabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        thebox.add(invisiblelabel);
        //Add box to the frame
        frame.add(thebox);
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //Find button action listener
        findbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerProf theprofile = customerdb.findProfile(lastnameinput.getText(), adminidinput.getText());
                //If it is null, then we could not find the profile
                if (theprofile==null)
                    couldNotFindProfile();
                else
                    displayOneProfile(theprofile);
                frame.dispose();
            }
        });
    }

    void couldNotFindProfile()
    {
        //true = Success    false = Fail
        JFrame frame = new JFrame("Profile Not Found");
        Box thebox = Box.createVerticalBox();
        //Label which tells result
        JLabel resultlabel = new JLabel();
        resultlabel.setText("Could not find that profile!");
        resultlabel.setFont(resultlabel.getFont().deriveFont(24.0f));
        resultlabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        thebox.add(resultlabel);
        //Add invisible label to space things out
        JLabel invisiblelabel = new JLabel(" ");
        invisiblelabel.setFont(resultlabel.getFont());
        invisiblelabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        thebox.add(invisiblelabel);
        //Ok button
        JButton ok = new JButton("OK");
        ok.setFont(ok.getFont().deriveFont(28.0f));
        ok.setAlignmentX(Component.CENTER_ALIGNMENT);
        thebox.add(ok);
        frame.add(thebox);
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //Ok button action listener
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Make the main menu visible
                mainframe.setVisible(true);
                //Dispose of this window
                frame.dispose();
            }
        });
    }

    void displayOneProfile(CustomerProf profile)
    {
        //Get the vehicle info from the profile
        VehicleInfo thevehicle = profile.getVehicleInfo();
        //Create frame
        JFrame frame = new JFrame("Customer Profile");
        JPanel data = new JPanel(new GridLayout(13, 2));
        //All of the labels and text fields
        //ADMIN ID
        JLabel adminid = new JLabel("Admin ID:");
        adminid.setFont(adminid.getFont().deriveFont(24.0f));
        data.add(adminid);
        JTextField adminidoutput = new JTextField(profile.getAdminID());
        adminidoutput.setFont(adminidoutput.getFont().deriveFont(24.0f));
        data.add(adminidoutput);
        //FIRST NAME
        JLabel firstname = new JLabel("First Name:");
        firstname.setFont(adminid.getFont());
        data.add(firstname);
        JTextField firstnameoutput = new JTextField(profile.getFirstName());
        firstnameoutput.setFont(adminidoutput.getFont());
        data.add(firstnameoutput);
        //LAST NAME
        JLabel lastname = new JLabel("Last Name:");
        lastname.setFont(adminid.getFont());
        data.add(lastname);
        JTextField lastnameoutput = new JTextField(profile.getLastName());
        lastnameoutput.setFont(adminidoutput.getFont());
        data.add(lastnameoutput);
        //ADDRESS
        JLabel address = new JLabel("Address:");
        address.setFont(adminid.getFont());
        data.add(address);
        JTextField addressoutput = new JTextField(profile.getAddress());
        addressoutput.setFont(adminidoutput.getFont());
        data.add(addressoutput);
        //PHONE
        JLabel phone = new JLabel("Phone:");
        phone.setFont(adminid.getFont());
        data.add(phone);
        JTextField phoneoutput = new JTextField(profile.getPhone());
        phoneoutput.setFont(adminidoutput.getFont());
        data.add(phoneoutput);
        //INCOME
        JLabel income = new JLabel("Income:");
        income.setFont(adminid.getFont());
        data.add(income);
        JTextField incomeoutput = new JTextField(String.valueOf(profile.getIncome()));
        incomeoutput.setFont(adminidoutput.getFont());
        data.add(incomeoutput);
        //USE
        JLabel use = new JLabel("Use:");
        use.setFont(adminid.getFont());
        data.add(use);
        JTextField useoutput = new JTextField(profile.getUse());
        useoutput.setFont(adminidoutput.getFont());
        data.add(useoutput);
        //STATUS
        JLabel status = new JLabel("Status:");
        status.setFont(adminid.getFont());
        data.add(status);
        JTextField statusoutput = new JTextField(profile.getStatus());
        statusoutput.setFont(adminidoutput.getFont());
        data.add(statusoutput);
        //MODEL
        JLabel model = new JLabel("Model:");
        model.setFont(adminid.getFont());
        data.add(model);
        JTextField modeloutput = new JTextField(thevehicle.getModel());
        modeloutput.setFont(adminidoutput.getFont());
        data.add(modeloutput);
        //YEAR
        JLabel year = new JLabel("Year:");
        year.setFont(adminid.getFont());
        data.add(year);
        JTextField yearoutput = new JTextField(thevehicle.getYear());
        yearoutput.setFont(adminidoutput.getFont());
        data.add(yearoutput);
        //TYPE
        JLabel type = new JLabel("Type:");
        type.setFont(adminid.getFont());
        data.add(type);
        JTextField typeoutput = new JTextField(thevehicle.getType());
        typeoutput.setFont(adminidoutput.getFont());
        data.add(typeoutput);
        //METHOD
        JLabel method = new JLabel("Method:");
        method.setFont(adminid.getFont());
        data.add(method);
        JTextField methodoutput = new JTextField(thevehicle.getMethod());
        methodoutput.setFont(adminidoutput.getFont());
        data.add(methodoutput);
        //Close button
        JButton close = new JButton("Close");
        close.setFont(close.getFont().deriveFont(28.0f));
        data.add(close);
        //Add the box to the frame
        frame.add(data);
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //Close button action listener
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Make the main menu visible
                mainframe.setVisible(true);
                //Dispose of this window
                frame.dispose();
            }
        });
    }

    void displayAllProfiles()
    {
        DisplayAllProfile uf = new DisplayAllProfile(customerdb);
    }

    public static void main(String s[]) {

        //Get the filepath
        in = new Scanner(System.in);
        //System.out.print("Enter the path of the database file: ");
        String filepath = "Dbdata.txt";//in.nextLine();
        //String filepath = "D:/db.txt";
        GUI thegui = new GUI(filepath);
        in.close();
        /*
        JFrame frame = new JFrame("JFrame Example");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel label = new JLabel("JFrame By Example");
        JButton button = new JButton();
        button.setText("Button");
        panel.add(label);
        panel.add(button);
        frame.add(panel);
        frame.setSize(200, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
         */
    }
} 