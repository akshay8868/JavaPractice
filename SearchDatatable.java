package PhoneBook;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class SearchDatatable extends JFrame implements ActionListener
{
    String x[] ={"Id","name","nickname","mobile","email","address"};
    String y[][] = new String[20][6];
    int i = 0,j=0;
    JTable t;
    Font f;
    
    
    SearchDatatable()
    {

    }
    SearchDatatable( String name1)
    {
        super("Contact Info");
        setlocation(1,1);
        setSize(800,400);
        f = new Font("Arial",Font.BOLD,20);
        try
            {
            ConnectionClass obj = new ConnectionClass();
            String q = "select * from add_contact where name ='"+name1+"'";
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

            }
            t = new JTable(y,x);
            t.setFont(f);

            catch(Exeption ex)
            {
                ex.printStackTrace();
            }
        JScrollPane sp = new JScrollPane(t);
        add(sp);

    }
    public static void main(String[] args)
    {
        new SearchDatatable().setVisible(true);

    }
} 