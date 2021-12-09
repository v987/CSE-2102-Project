import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Status extends JFrame{
    private JButton okButton;
    private JPanel Jpanel;
    private JLabel actionLabel;

    public Status(String action){
        setContentPane(Jpanel);
        setTitle("Action Status");
        setSize(250, 350);
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        actionLabel.setText(action);
        setVisible(true);

        okButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Status.super.setVisible(false);
                GUI.mainframe.setVisible(true);
            }
        });
    }
    public static void main(String args[]){
        new Status("Success on This!");
    }
}
