import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class LoginFrame extends JFrame implements ActionListener {
    JLabel lblusername, lblpassword, lblmessage, lblimage;
    JTextField txtusername;
    JPasswordField txtpassword;
    JButton btnlogin, btnlogout, btnregister;

    public LoginFrame() {
        // Set background color
        getContentPane().setBackground(new Color(240, 248, 255)); // Light blue

        // Image label at the top
        lblimage = new JLabel();
        lblimage.setHorizontalAlignment(JLabel.CENTER);
        lblimage.setIcon(resizeImageIcon("D:\\Unique Skills\\Corejava\\JDBC Library Mini Project\\login1.png", 300, 100));

        // Labels
        lblusername = new JLabel("Username:");
        lblusername.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblpassword = new JLabel("Password:");
        lblpassword.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblmessage = new JLabel(" ", SwingConstants.CENTER);
        lblmessage.setForeground(Color.RED);
        lblmessage.setFont(new Font("SansSerif", Font.PLAIN, 14));

        // Text fields
        txtusername = new JTextField(20);
        txtusername.setFont(new Font("SansSerif", Font.PLAIN, 14));
        txtpassword = new JPasswordField(20);
        txtpassword.setFont(new Font("SansSerif", Font.PLAIN, 14));

        // Buttons
        btnlogin = new JButton("Login");
        btnlogin.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnlogin.setBackground(new Color(0, 153, 76)); // Green
        btnlogin.setForeground(Color.WHITE);

        btnlogout = new JButton("Logout");
        btnlogout.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnlogout.setBackground(new Color(255, 69, 0)); // Red
        btnlogout.setForeground(Color.WHITE);

        btnregister = new JButton("Register");
        btnregister.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnregister.setBackground(new Color(30, 144, 255)); // Blue
        btnregister.setForeground(Color.WHITE);

        // Add action listeners
        btnlogin.addActionListener(this);
        btnlogout.addActionListener(this);
        btnregister.addActionListener(this);

        // Layout
        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.CENTER)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblmessage, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        					.addGroup(layout.createSequentialGroup()
        						.addContainerGap()
        						.addComponent(lblusername)
        						.addGap(18)
        						.addComponent(txtusername, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
        					.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        						.addGap(79)
        						.addComponent(lblpassword)
        						.addGap(18)
        						.addComponent(txtpassword, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap(86, Short.MAX_VALUE))
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap(110, Short.MAX_VALUE)
        			.addComponent(btnlogin, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        			.addGap(43)
        			.addComponent(btnlogout, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        			.addGap(133))
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addGap(158)
        			.addComponent(btnregister, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(178, Short.MAX_VALUE))
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addGap(89)
        			.addComponent(lblimage, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblimage, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtusername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblusername))
        			.addGap(10)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtpassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblpassword))
        			.addGap(10)
        			.addComponent(lblmessage)
        			.addGap(20)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnlogout)
        				.addComponent(btnlogin))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(btnregister)
        			.addGap(50))
        );
        getContentPane().setLayout(layout);

        // Frame properties
        setSize(500, 400);
        setTitle("Login Window");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Utility method to resize the image
    private ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnlogin) {
            String username = txtusername.getText();
            String password = new String(txtpassword.getPassword());
            try {
                // Database connection
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");

                // Query
                PreparedStatement pstmt = con.prepareStatement("SELECT * FROM registration WHERE username=? AND password=?");
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                ResultSet rs = pstmt.executeQuery();

                // Login validation
                if (rs.next()) {
                    lblmessage.setText("Login successful!");
                    lblmessage.setForeground(new Color(0, 128, 0)); // Green for success
                    this.dispose();
                    new EmployeesJDBC();
                } else {
                    lblmessage.setText("Invalid username or password!");
                }
            } catch (Exception ex) {
                lblmessage.setText("Database connection error!");
                ex.printStackTrace();
            }
        } else if (e.getSource() == btnregister) {
            this.dispose();
            new RegisterWindow();
        } else if (e.getSource() == btnlogout) {
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
