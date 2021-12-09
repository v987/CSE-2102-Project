import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DisplayAllProfile extends JFrame {
    private JTextField adminField;
    private JButton nextProfileButton;
    private JTextField fNameField;
    private JTextField incomeField;
    private JTextField useField;
    private JTextField statusField;
    private JTextField modelField;
    private JTextField yearField;
    private JTextField typeField;
    private JTextField phoneField;
    private JTextField addressField;
    private JTextField LnameField;
    private JTextField methodField;
    private JPanel Jpanel;
    private int index = 0;

    public DisplayAllProfile(CustomerProfDB db){
        setContentPane(Jpanel);
        setTitle("Display All Profile");
        setSize(150, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        ArrayList<CustomerProf> customerList = db.getCustomerList();

        nextProfileButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                adminField.setText(customerList.get(index).getAdminID());
                fNameField.setText(customerList.get(index).getFirstName());
                LnameField.setText(customerList.get(index).getLastName());
                addressField.setText(customerList.get(index).getAddress());
                phoneField.setText(customerList.get(index).getPhone());
                incomeField.setText(customerList.get(index).getIncome()+"");
                useField.setText(customerList.get(index).getUse());
                statusField.setText(customerList.get(index).getStatus());
                modelField.setText(customerList.get(index).getVehicleInfo().getModel());
                yearField.setText(customerList.get(index).getVehicleInfo().getYear());
                typeField.setText(customerList.get(index).getVehicleInfo().getType());
                methodField.setText(customerList.get(index).getVehicleInfo().getMethod());
                index++;
                if (index >= customerList.size()){return;}
            }
        });
    }
    public static void main(String []args){new DisplayAllProfile(new CustomerProfDB("Dbdata.txt"));}
}
