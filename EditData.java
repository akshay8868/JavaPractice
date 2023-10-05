package PhoneBook;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class EditData extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
    JButton bt1,bt2;
    JPanel p1,p2;
    Font f,f1;
    
    
    EditData(int idno)
    {
        super("Edit Contact");
        setLocation();
        setSize();

        f = new Font("Arial",Font.BOLD,20);
        f1 = new Font("Arial",Font.BOLD,15);

        l1 = new JLabel("Add Contact");
        l2 = new JLabel("Name");
        l3 = new JLabel("Nick Name");
        l4 = new JLabel("Mobile No.");
        l5 = new JLabel("Email");
        l6 = new JLabel("Address");

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();

        bt1 = new JButton("Add Contact");
        bt2 = new JButton("Back");

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);

        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        tf5.setFont(f1);

        bt1.setFont(f1);
        bt2.setFont(f1);

        p1 = new JPanel ();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(bt1);

        p1 = new JPanel ();
        p1.setLayout(new GridLayout(6,2,10,10));
        p1.add(l1);

        p2 = new JPanel ();
        p2.setLayout(new GridLayout(6,2,10,10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(tf2);
        p2.add(l4);
        p2.add(tf3);
        p2.add(l5);
        p2.add(tf4);
        p2.add(l6);
        p2.add(tf5);
        p2.add(bt1);
        p2.add(bt2);
        
        try
        {
            ConnectionClass obj = new ConnectionClass();
            String q1 = "select * from add_contact where Id ='"+idno+"'";
            ResultSet rest1 = obj1.stm.executeQuery(q1);
            while(rest.next())
            {
                tf6.setText(rest1.getString("Id"));
                tf1.setText(rest1.getString("name"));
                tf2.setText(rest1.getString("nickname"));
                tf3.setText(rest1.getString("mobile"));
                tf4.setText(rest1.getString("email"));
                tf5.setText(rest1.getString("address"));
                
            }

        }
        catch(Exception exxx)
        {
            exxx.printStackTrace();

        }

        tf6.setEditable(false);
        
        setLayout(new BorderLayout(10,20));
        add(p1,"North");
        add(p2,"Center");


    }
    EditData()
    {

    }

    public actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            int Cid = Integer.parseInt(tf6.getText());
            String name = tf1.getText();
            String nickname = tf2.getText();
            String mobile = tf3.getText();
            String email = tf4.getText();
            String address = tf5.getText();

            try
            {
                ConnectionClass obj3 = new ConnectionClass();
                String q1 = "update add_contact set name '"+name+"',nickname='"+nickname +"',mobile='"+mobile+"',email='"+email+"',address='"+address+"' where Id = '"+ Cid+"'";
                int aa = obj3.stm.executeUpdate(q1);

                if(aa==1)
                {
                    JOptionPane.showMessageDialog(null,"data updated succesfully");
                    this.setVisible(false);
                    new SearchDatatableForEdit(name).setVisible(true);


                }
                else
                {
                    JOptionPane.showMessageDialog(null,"fill the details");

                }

            }
            catch(Exception ee)
            {
                ee.printStackTrace();
            }

        }
        if(e.getSource()==bt2)
        {
            this.setVisible(false);
            new home().setVisible(true);

        }
    }
    public static void main()
    {
        new EditData().setVisible(true);

    }
}