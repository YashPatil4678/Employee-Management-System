import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class EmployeesJDBC extends JFrame implements ActionListener {
    JLabel lblid, lblname, lblemail, lblposition, lblsalary, lblmobile, lbladdress, lblmessage, lblheader;
    JTextField txtid, txtname, txtemail, txtposition, txtsalary, txtmobile, txtaddress;
    JButton btninsert, btndelete, btnshow, btnupdate, btnexit;
    JPanel p1, p2, headerPanel;

    public EmployeesJDBC() {
        // Setting the main container
        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(230, 240, 250));

        // Header Panel
        headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, 700, 70);
        headerPanel.setBackground(new Color(0, 102, 204));
        headerPanel.setLayout(new FlowLayout());
        lblheader = new JLabel("Employee Management System");
        lblheader.setVerticalAlignment(SwingConstants.BOTTOM);
        lblheader.setFont(new Font("Verdana", Font.BOLD, 30));
        lblheader.setForeground(Color.WHITE);
        headerPanel.add(lblheader);

        // Form Panel
        p1 = new JPanel();
        p1.setBounds(20, 90, 400, 350);
        p1.setBackground(Color.WHITE);
        p1.setLayout(null);
        p1.setBorder(BorderFactory.createTitledBorder("Employee Details"));

        lblid = new JLabel("Employee ID:");
        lblid.setBounds(20, 30, 120, 30);
        txtid = new JTextField();
        txtid.setBounds(150, 30, 200, 30);

        lblname = new JLabel("Name:");
        lblname.setBounds(20, 70, 120, 30);
        txtname = new JTextField();
        txtname.setBounds(150, 70, 200, 30);

        lblemail = new JLabel("Email:");
        lblemail.setBounds(20, 110, 120, 30);
        txtemail = new JTextField();
        txtemail.setBounds(150, 110, 200, 30);

        lblposition = new JLabel("Position:");
        lblposition.setBounds(20, 150, 120, 30);
        txtposition = new JTextField();
        txtposition.setBounds(150, 150, 200, 30);

        lblsalary = new JLabel("Salary:");
        lblsalary.setBounds(20, 190, 120, 30);
        txtsalary = new JTextField();
        txtsalary.setBounds(150, 190, 200, 30);

        lblmobile = new JLabel("Mobile:");
        lblmobile.setBounds(20, 230, 120, 30);
        txtmobile = new JTextField();
        txtmobile.setBounds(150, 230, 200, 30);

        lbladdress = new JLabel("Address:");
        lbladdress.setBounds(20, 270, 120, 30);
        txtaddress = new JTextField();
        txtaddress.setBounds(150, 270, 200, 30);

        p1.add(lblid);
        p1.add(txtid);
        p1.add(lblname);
        p1.add(txtname);
        p1.add(lblemail);
        p1.add(txtemail);
        p1.add(lblposition);
        p1.add(txtposition);
        p1.add(lblsalary);
        p1.add(txtsalary);
        p1.add(lblmobile);
        p1.add(txtmobile);
        p1.add(lbladdress);
        p1.add(txtaddress);

        // Button Panel
        p2 = new JPanel();
        p2.setBounds(450, 90, 201, 350);
        p2.setBackground(Color.WHITE);
        p2.setLayout(new GridLayout(5, 1, 10, 10));
        p2.setBorder(BorderFactory.createTitledBorder("Actions"));

        btninsert = new JButton("Insert");
        btninsert.setBackground(new Color(51, 204, 51));
        btninsert.setForeground(Color.WHITE);
        btninsert.setFont(new Font("Arial", Font.BOLD, 15));
        btninsert.addActionListener(this);

        btnupdate = new JButton("Update");
        btnupdate.setBackground(new Color(255, 153, 51));
        btnupdate.setForeground(Color.WHITE);
        btnupdate.setFont(new Font("Arial", Font.BOLD, 15));
        btnupdate.addActionListener(this);

        btndelete = new JButton("Delete");
        btndelete.setBackground(new Color(255, 51, 51));
        btndelete.setForeground(Color.WHITE);
        btndelete.setFont(new Font("Arial", Font.BOLD, 15));
        btndelete.addActionListener(this);

        btnshow = new JButton("Show");
        btnshow.setBackground(new Color(51, 102, 255));
        btnshow.setForeground(Color.WHITE);
        btnshow.setFont(new Font("Arial", Font.BOLD, 15));
        btnshow.addActionListener(this);

        btnexit = new JButton("Exit");
        btnexit.setBackground(new Color(102, 102, 102));
        btnexit.setForeground(Color.WHITE);
        btnexit.setFont(new Font("Arial", Font.BOLD, 15));
        btnexit.addActionListener(this);

        p2.add(btninsert);
        p2.add(btnupdate);
        p2.add(btndelete);
        p2.add(btnshow);
        p2.add(btnexit);

        // Message Label
        lblmessage = new JLabel("");
        lblmessage.setBounds(20, 450, 650, 30);
        lblmessage.setFont(new Font("Arial", Font.ITALIC, 15));
        lblmessage.setHorizontalAlignment(SwingConstants.CENTER);

        // Adding panels to container
        c.add(headerPanel);
        c.add(p1);
        c.add(p2);
        c.add(lblmessage);

        // Frame settings
        setSize(700, 550);
        setTitle("Employee Management System");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");

            if (e.getSource() == btninsert) {
                PreparedStatement pstmt = con.prepareStatement("INSERT INTO employees (name, email, position, salary, mobile, address) VALUES (?, ?, ?, ?, ?, ?)");
                pstmt.setString(1, txtname.getText());
                pstmt.setString(2, txtemail.getText());
                pstmt.setString(3, txtposition.getText());
                pstmt.setDouble(4, Double.parseDouble(txtsalary.getText()));
                pstmt.setString(5, txtmobile.getText());
                pstmt.setString(6, txtaddress.getText());
                pstmt.executeUpdate();
                lblmessage.setText("Record Inserted Successfully!");
                lblmessage.setForeground(new Color(0, 153, 0));
            } else if (e.getSource() == btnupdate) {
                PreparedStatement pstmt = con.prepareStatement("UPDATE employees SET name=?, email=?, position=?, salary=?, mobile=?, address=? WHERE id=?");
                pstmt.setString(1, txtname.getText());
                pstmt.setString(2, txtemail.getText());
                pstmt.setString(3, txtposition.getText());
                pstmt.setDouble(4, Double.parseDouble(txtsalary.getText()));
                pstmt.setString(5, txtmobile.getText());
                pstmt.setString(6, txtaddress.getText());
                pstmt.setInt(7, Integer.parseInt(txtid.getText()));
                pstmt.executeUpdate();
                lblmessage.setText("Record Updated Successfully!");
                lblmessage.setForeground(new Color(0, 153, 0));
            } else if (e.getSource() == btndelete) {
                PreparedStatement pstmt = con.prepareStatement("DELETE FROM employees WHERE id=?");
                pstmt.setInt(1, Integer.parseInt(txtid.getText()));
                int rows = pstmt.executeUpdate();
                if (rows > 0) {
                    lblmessage.setText("Record Deleted Successfully!");
                    lblmessage.setForeground(new Color(204, 0, 0));
                } else {
                    lblmessage.setText("Record Not Found!");
                    lblmessage.setForeground(Color.RED);
                }
            } else if (e.getSource() == btnshow) {
                PreparedStatement pstmt = con.prepareStatement("SELECT * FROM employees WHERE id=?");
                pstmt.setInt(1, Integer.parseInt(txtid.getText()));
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    txtname.setText(rs.getString("name"));
                    txtemail.setText(rs.getString("email"));
                    txtposition.setText(rs.getString("position"));
                    txtsalary.setText(String.valueOf(rs.getDouble("salary")));
                    txtmobile.setText(rs.getString("mobile"));
                    txtaddress.setText(rs.getString("address"));
                    lblmessage.setText("Record Found!");
                    lblmessage.setForeground(new Color(0, 153, 0));
                } else {
                    lblmessage.setText("Record Not Found!");
                    lblmessage.setForeground(Color.RED);
                }
            } else if (e.getSource() == btnexit) {
                System.exit(0);
            }
        } catch (Exception ex) {
            lblmessage.setText("Error: " + ex.getMessage());
            lblmessage.setForeground(Color.RED);
        }
    }

    public static void main(String[] args) {
        new EmployeesJDBC();
    }
}
