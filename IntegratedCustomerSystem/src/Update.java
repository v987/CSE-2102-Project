import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Update extends JFrame{
    private JButton submitButton;
    private JLabel adminLabel;
    private JLabel lnameLabel;
    private JTextField valueField;
    private JLabel editLabel;
    private JPanel Jpanel;

    public Update(CustomerProfDB db, String admin, String lastName, String field) {
        /* TODO : complete the update features to allow the admin user to modify the database.*/
        adminLabel.setText(admin);
        lnameLabel.setText(lastName);
        editLabel.setText(field);

        setContentPane(Jpanel);
        setTitle("Update Profile");
        setSize(350, 550);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        submitButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = valueField.getText();
                CustomerProf customer = db.findProfile(lastName, admin);
                if (customer == null){new Status("Customer Does not Exist!"); return;}
                switch(field){
                    case "Address":
                        customer.updateAddress(value);
                        break;
                    case "Phone":
                        customer.updatePhone(value);
                        break;
                    case "Use":
                        customer.updateUse(value);
                        break;
                    case "Status":
                        customer.updateStatus(value);
                        break;
                    case "Model":
                        customer.getVehicleInfo().updateModel(value);
                        break;
                    case "Year":
                        customer.getVehicleInfo().updateYear(value);
                        break;
                    case "Type":
                        customer.getVehicleInfo().updateType(value);
                        break;
                    case "Method":
                        customer.getVehicleInfo().updateMethod(value);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + field);
                }
                db.writeAllCustomerProf();
                new Status("Update Completed!");
                GUI.customerdb.writeAllCustomerProf();
                Update.super.setVisible(false);
            }
        });
    }
}
