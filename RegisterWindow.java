import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;
import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class RegisterWindow extends JFrame implements ActionListener {
    JLabel lblname, lbladdress, lblmobile, lblemail, lblusername, lblpassword, lbltitle;
    JTextField txtname, txtaddress, txtmobile, txtemail, txtusername;
    JPasswordField txtpassword;
    JButton btnregister, btnexit;

    public RegisterWindow() {
        // Set background color
        getContentPane().setBackground(new Color(230, 240, 250)); // Light pastel blue
        setTitle("User Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Title label
        lbltitle = new JLabel("Register New Account");
        lbltitle.setFont(new Font("SansSerif", Font.BOLD, 20));
        lbltitle.setHorizontalAlignment(JLabel.CENTER);
        lbltitle.setForeground(new Color(51, 51, 255)); // Deep blue

        // Input labels and text fields
        lblname = new JLabel("Full Name:");
        lblname.setFont(new Font("SansSerif", Font.PLAIN, 14));
        txtname = new JTextField();
        txtname.setToolTipText("Enter your full name");

        lbladdress = new JLabel("Address:");
        lbladdress.setFont(new Font("SansSerif", Font.PLAIN, 14));
        txtaddress = new JTextField();
        txtaddress.setToolTipText("Enter your address");

        lblmobile = new JLabel("Mob. Number:");
        lblmobile.setFont(new Font("SansSerif", Font.PLAIN, 14));
        txtmobile = new JTextField();
        txtmobile.setToolTipText("Enter your mobile number");

        lblemail = new JLabel("Email:");
        lblemail.setFont(new Font("SansSerif", Font.PLAIN, 14));
        txtemail = new JTextField();
        txtemail.setToolTipText("Enter your email address");

        lblusername = new JLabel("Username:");
        lblusername.setFont(new Font("SansSerif", Font.PLAIN, 14));
        txtusername = new JTextField();
        txtusername.setToolTipText("Set a username");

        lblpassword = new JLabel("Password:");
        lblpassword.setFont(new Font("SansSerif", Font.PLAIN, 14));
        txtpassword = new JPasswordField();
        txtpassword.setToolTipText("Set a secure password");

        // Buttons
        btnregister = new JButton("Register");
        btnregister.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnregister.setBackground(new Color(51, 153, 255)); // Bright blue
        btnregister.setForeground(Color.WHITE);
        btnregister.setToolTipText("Click to register");

        btnexit = new JButton("Exit");
        btnexit.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnexit.setBackground(new Color(255, 51, 51)); // Bright red
        btnexit.setForeground(Color.WHITE);
        btnexit.setToolTipText("Click to exit");

        // Add action listeners
        btnregister.addActionListener(this);
        btnexit.addActionListener(this);

        // Layout
        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.CENTER)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(btnregister, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
        			.addGap(30)
        			.addComponent(btnexit, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(10)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createParallelGroup(Alignment.LEADING)
        					.addGroup(layout.createSequentialGroup()
        						.addGap(21)
        						.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        							.addComponent(lblname)
        							.addComponent(lbladdress)
        							.addComponent(lblpassword)
        							.addComponent(lblemail)))
        					.addGroup(layout.createSequentialGroup()
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addComponent(lblmobile)))
        				.addComponent(lblusername))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(lbltitle)
        				.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        					.addComponent(txtemail)
        					.addComponent(txtmobile)
        					.addComponent(txtaddress)
        					.addComponent(txtname, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
        					.addComponent(txtusername)
        					.addComponent(txtpassword)))
        			.addGap(42))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(22)
        			.addComponent(lbltitle)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblname)
        				.addComponent(txtname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(15)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lbladdress)
        				.addComponent(txtaddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(15)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtmobile, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblmobile))
        			.addGap(15)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtemail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblemail))
        			.addGap(15)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtusername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblusername))
        			.addGap(15)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblpassword)
        				.addComponent(txtpassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(20)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnregister)
        				.addComponent(btnexit))
        			.addGap(20))
        );
        getContentPane().setLayout(layout);

        // Frame properties
        setSize(450, 400);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnregister) {
            String name = txtname.getText();
            String address = txtaddress.getText();
            String mobile = txtmobile.getText();
            String email = txtemail.getText();
            String username = txtusername.getText();
            String password = new String(txtpassword.getPassword());

            try {
                // Database connection and insertion
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
                PreparedStatement pstmt = con.prepareStatement("INSERT INTO registration (name, address, mobile_no, email, username, password) VALUES (?, ?, ?, ?, ?, ?)");
                pstmt.setString(1, name);
                pstmt.setString(2, address);
                pstmt.setString(3, mobile);
                pstmt.setString(4, email);
                pstmt.setString(5, username);
                pstmt.setString(6, password);
                pstmt.executeUpdate();

                JOptionPane.showMessageDialog(this, "Registered Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                con.close();
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnexit) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new RegisterWindow();
    }
}
