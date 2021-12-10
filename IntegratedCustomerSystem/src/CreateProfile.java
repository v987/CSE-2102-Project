import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateProfile extends JFrame{
    private JTextField addressField;
    private JTextField phoneField;
    private JTextField incomeField;
    private JTextField LnameField;
    private JTextField modelField;
    private JTextField yearField;
    private JButton submitButton;
    private JComboBox methodField;
    private JComboBox typeField;
    private JComboBox statusField;
    private JComboBox useField;
    private JTextField FnameField;
    private JTextField AdminField;
    private JPanel Jpanel;


    public CreateProfile() {
        //this.addressField = addressField;
        typeField.addItem("Sedan");
        typeField.addItem("Hatchback");
        typeField.addItem("Luxury");
        typeField.addItem("Sport");
        typeField.addItem("Other");

        useField.addItem("Business");
        useField.addItem("Personal");
        useField.addItem("Both");

        statusField.addItem("Active");
        statusField.addItem("Inactive");

        methodField.addItem("New");
        methodField.addItem("Certified Pre-owned");
        methodField.addItem("Used");
        methodField.addItem("Other");

        setContentPane(Jpanel);
        setTitle("Creating Profile");
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
                String admin = AdminField.getText();
                String fName = FnameField.getText();
                String lName = LnameField.getText();
                String address = addressField.getText();
                String phone = phoneField.getText();
                String use = (String) useField.getSelectedItem();
                String status = (String)statusField.getSelectedItem();
                String model = modelField.getText();
                String year = yearField.getText();
                float income = Float.valueOf(incomeField.getText());
                String type = (String)typeField.getSelectedItem();
                String method = (String) methodField.getSelectedItem();

                System.out.println(method);
                //pushData(data);
                //CustomerProfDB cdb = new CustomerProfDB(GUI.filepath);
                GUI.customerdb.insertNewProfile(new CustomerProf(admin, fName, lName, address, phone, income, status, use, new VehicleInfo(model, year, type, method)));
                GUI.customerdb.writeAllCustomerProf();
                CreateProfile.super.setVisible(false);
                new Status("Profile Created!");
            }
        });
        //
    }

    public static void main(String[] args){
        CreateProfile profile = new CreateProfile();
    }
}
