import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SplashWindow extends JFrame implements ActionListener {
    JLabel lblshow, lblheading;
    JButton btnnext;

    public SplashWindow() {
        // Set background color
        getContentPane().setBackground(new Color(240, 248, 255)); // Light blue background

        // Set layout manager
        getContentPane().setLayout(null);

        // JLabel for the image
        lblshow = new JLabel();
        lblshow.setHorizontalAlignment(SwingConstants.CENTER);
        lblshow.setBounds(0, 0, 550, 250); // Cover top area
        lblshow.setIcon(resizeImageIcon("D:\\Unique Skills\\Corejava\\JDBC Employee Mini Project\\welcome.jpg", 550, 250));

        // JLabel for the heading
        lblheading = new JLabel("Employee Management System");
        lblheading.setForeground(new Color(0, 102, 204)); // Vibrant blue text
        lblheading.setHorizontalAlignment(SwingConstants.CENTER);
        lblheading.setFont(new Font("Verdana", Font.BOLD, 28));
        lblheading.setBounds(0, 260, 550, 40); // Positioned below the image

        // JButton for "Next"
        btnnext = new JButton("Next");
        btnnext.setBackground(new Color(255, 165, 0)); // Vibrant orange button
        btnnext.setForeground(Color.WHITE); // White text on button
        btnnext.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 24));
        btnnext.setBounds(220, 320, 110, 40); // Centered below the heading

        // Add components to the frame
        getContentPane().add(lblshow);
        getContentPane().add(lblheading);
        getContentPane().add(btnnext);

        // Add action listener for the button
        btnnext.addActionListener(this);

        // Set JFrame properties
        setSize(550, 450); // Frame size to fit image, heading, and button
        setVisible(true);
        setTitle("Welcome to Employee Management System");
        setLocationRelativeTo(null); // Center the frame on the screen
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // Utility method to resize the image
    private ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    public static void main(String[] args) {
        new SplashWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Dispose the splash screen and open the next window (LoginFrame)
        this.dispose();
        new LoginFrame(); // Ensure LoginFrame is implemented elsewhere
    }
}
