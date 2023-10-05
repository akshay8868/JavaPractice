package PhoneBook;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class DeleteContact extends JFrame implements ActionListener
{
    String x[] = {"Id","name","nickname","mobile","email","address"};
    JButton bt;
    int i = 0, j= 0;
    Jtable t;
    Font f, f1;
    JLabel l1;
    JTextField tf;
    JPanel p1,p2;
    
    
    DeleteContact()
    {
        super("Contact Info");
        setSize(800,400);
        setLocation(1,1);
        f = new Font("MS UI Gothic",Font.BOLD,15);
        try
        {
            ConnectionClass obj = new ConnectionClass();
            String q = "select * from add_contact";
            ResultSet rest = obj.stm.executeQuery(q);
            while(rest.next())
            {
                y[i][j++] = rest.getString("Id");
                y[i][j++] = rest.getString("name");
                y[i][j++] = rest.getString("nickname");
                y[i][j++] = rest.getString("mobile");
                y[i][j++] = rest.getString("email");
                y[i][j++] = rest.getString("address");
                i++;
                j = 0;

                t = new JTable(y,x);
                t.setFont(f);


            }

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(t);
        bt.setBackground(Color.Black);
        bt.setForeground(Color.Red);
        bt.addActionListener(this);
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,3,10,10));
        p1.add(l1);
        p1.add(tf);
        p1.add(bt);

        setLayout(new BorderLayout(10,10));
        add(p1,"south");
        add(sp,"center");



    }
    public class actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt)
        {
            int idno = Integer.parseint(tf.gettext());
            try
            {
                ConnectionClass obj1 = new ConnectionClass();
                String q0 = "delete from add_contact where Id='"+idno+"'";
                int res = obj1.stm.executeUpdate(q0);

                if(res==1)
                {
                    JOptionPane.showMessageDialog(null,"Contact Successfully deleted");
                    this.setVisible(false);
                    new DeleteContact().setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog("Contact not deleted");
                    this.setVisible(false);
                    new DeleteContact().setVisible(true);

                }


            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }

    }

    public static void main(String args[])
    {
        new DeleteContact().setVisible(true);
    }
}