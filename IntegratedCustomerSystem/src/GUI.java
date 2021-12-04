import java.awt.FlowLayout;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

    }

    CustomerProf createProfile()
    {
        return null;//****REPLACE THIS
    }

    void deleteProfile()
    {

    }

    void updateProfile()
    {

    }

    void findProfile()
    {

    }

    void displayAllProfiles()
    {

    }

    public static void main(String s[]) {

        //Get the filepath
        in = new Scanner(System.in);
        System.out.print("Enter the path of the database file: ");
        String filepath = in.nextLine();
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