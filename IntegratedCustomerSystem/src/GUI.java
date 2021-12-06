import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

public class GUI {

    //Variables
    private CustomerProfDB customerdb;
    private String filepath;
    private static Scanner in;

    public GUI(String thefilepath)
    {
        filepath = thefilepath;
        customerdb = new CustomerProfDB(filepath);
        mainMenu();
    }

    void mainMenu()
    {
        //Create the frame
        JFrame frame = new JFrame("Integrated Customer System");
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
        thebox.add(selectbutton);
        //Add box to the frame
        frame.add(thebox);
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    CustomerProf createProfile()
    {
        return null;//****REPLACE THIS
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
    }


    void updateProfile()
    {

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
    }

    void displayAllProfiles()
    {

    }

    public static void main(String s[]) {

        //Get the filepath
        in = new Scanner(System.in);
        System.out.print("Enter the path of the database file: ");
        String filepath = in.nextLine();
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