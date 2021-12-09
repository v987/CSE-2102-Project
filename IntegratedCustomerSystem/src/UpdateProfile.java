import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateProfile extends JFrame{
    private JButton findButton;
    private JTextField adminField;
    private JTextField lastNameField;
    private JComboBox updateComboField;
    private CustomerProfDB db;
    private JPanel Jpanel;

    public UpdateProfile(CustomerProfDB db) {
        this.db = db;
        updateComboField.addItem("Address");
        updateComboField.addItem("Phone");
        updateComboField.addItem("Use");
        updateComboField.addItem("Status");
        updateComboField.addItem("Model");
        updateComboField.addItem("Year");
        updateComboField.addItem("Type");
        updateComboField.addItem("Method");

        setContentPane(Jpanel);
        setTitle("Update Profile");
        setSize(350, 550);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        findButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String admin = adminField.getText();
                String lastName = lastNameField.getText();
                String field = (String) updateComboField.getSelectedItem();
                new Update(db, admin, lastName, field);
                UpdateProfile.super.setVisible(false);
            }
        });
    }
    public static void main(String []args){
        UpdateProfile uf = new UpdateProfile(new CustomerProfDB("Dbdata.txt"));
    }
}
