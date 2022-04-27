
package tugaslogin;

/**
 *
 * @author HP
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Datatampilan extends JFrame{
    
    JLabel LabJudul = new JLabel(" - TUGAS LOGIN - ");
    // OPSI untuk LOGIN 
    JLabel LabUsername = new JLabel("Username  : ");
    JTextField FldUsername = new JTextField (25);
    JLabel LabPassword = new JLabel ("Password  : ");
    JPasswordField FldPassword = new JPasswordField(25);
    JButton ButLogin = new JButton("Login");
    
    //OPSI untuk REGISTER
    JLabel LabRegister = new JLabel ("Username : ");
    JTextField FldRegister = new JTextField (25);
    JLabel LabRegPassword = new JLabel ("Password : ");
    JPasswordField FldRegPassword = new JPasswordField (25);
    JButton ButRegister = new JButton ("Register");
    
    public Datatampilan(){
        setVisible(true);
        setTitle("");
        setSize(700,300);
        setLayout(null);
        
        add(LabJudul);
        //LOGIN
        add(LabUsername);
        add(FldUsername);
        add(LabPassword);
        add(FldPassword);
        add(ButLogin);
       
        //REGISTER  
        add(LabRegister);
        add(FldRegister);
        add(LabRegPassword);
        add(FldRegPassword);
        add(ButRegister);
        
        LabJudul.setBounds(300,0,120,70);
        //LOGIN
        LabUsername.setBounds(50, 80,100,30);
        FldUsername.setBounds(140,80,150,30);
        LabPassword.setBounds(50,120,100,30);
        FldPassword.setBounds(140,120,150,30);
        ButLogin.setBounds(165,180,100,20);
        
        //REGISTER
        LabRegister.setBounds(370,80,100,30);
        FldRegister.setBounds(460,80,150,30);
        LabRegPassword.setBounds(370,120,100,30);
        FldRegPassword.setBounds(460,120,150,30);
        ButRegister.setBounds(490,180,90,20);
        
        ButLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Connector koneksi = new Connector();
                String user = FldUsername.getText();
                System.out.println(user);
                
              if (koneksi.checkUsername(user) && user != "" && koneksi.checkLogin(user, String.valueOf(FldPassword.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                }
                else if (user.isEmpty() || String.valueOf(FldPassword.getPassword()).isEmpty()) { //error handling
                    JOptionPane.showMessageDialog(null, "Please Fill Username / Password!");
                }
                else if (!koneksi.checkUsername(user)) {
                    JOptionPane.showMessageDialog(null, "Username Not Available!");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Password!");
                }
                
            }
        
        });
        
        ButRegister.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Connector koneksi = new Connector();
                String reguser = FldRegister.getText();
                String regpass = String.valueOf(FldRegPassword.getPassword());
                if (!reguser.isEmpty() && !regpass.isEmpty()) {
                    koneksi.Data(reguser,regpass);
                   JOptionPane.showMessageDialog(null, "Register Successful!");
                }
                else if(reguser.isEmpty() || regpass.isEmpty()) { 
                    JOptionPane.showMessageDialog(null, "Please Fill Username / Password!");
                }
               
            }
        
        });
        
    }
    
}
