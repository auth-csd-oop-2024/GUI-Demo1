import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is a simple frame that contains one text field, one button and two radio buttons. When the button is clicked,
 * the value of the text field increases or decreases (starting from 0), according to the radio button that is selected
 * (see @see <a href="https://drive.google.com/file/d/1M-c7cI9jhNSqfO99SKfevYi6Svz8vOO_/view?usp=sharing">here</a> for a
 * screenshot).
 * <p>
 * Version that defines the ActionListener inline
 * <p>
 * See @see <a href="https://docs.oracle.com/javase/tutorial/uiswing/index.html">here</a> for more details on Swing.
 */
public class DemoGUI1 extends JFrame {

    JButton button;
    JTextField jTextField;
    JRadioButton radioUp, radioDown;

    ActionListener buttonListener;

    Api api = new Api();

    public void buildFrame() {
        this.setTitle("Demo GUI App");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(300, 130));
        this.setResizable(false);

        // The default layout of JFrames is BorderLayout. Change it to FlowLayout
        // See https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html for more details
        this.setLayout(new FlowLayout());

        // button
        button = new JButton("Click me!");
        //button.setActionCommand("button1");
        this.add(button);

        // radio buttons
        radioUp = new JRadioButton("increase");
        radioUp.setSelected(true);
        radioDown = new JRadioButton("decrease");
        this.add(radioUp);
        this.add(radioDown);
        ButtonGroup group = new ButtonGroup();
        group.add(radioUp);
        group.add(radioDown);

        //text field
        jTextField = new JTextField();
        jTextField.setText("0");
        jTextField.setPreferredSize(new Dimension(100, 30));
        this.add(jTextField);

        //listeners
        buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(e.getActionCommand());
                int text = Integer.parseInt(jTextField.getText());
                if (radioUp.isSelected()) {
                    jTextField.setText(api.increase(text) + "");
                } else {
                    jTextField.setText(api.decrease(text) + "");
                }
            }
        };
        button.addActionListener(buttonListener);

        /*
        Just to show that other components may share the same listener
        radioUp.addActionListener(buttonListener);
        radioDown.addActionListener(buttonListener);
        */

        this.setVisible(true);
    }

    /*
    Main method: It creates an instance of the demo class and calls the buildFrame method
     */
    public static void main(String[] args) {
        new DemoGUI1().buildFrame();
    }


}
