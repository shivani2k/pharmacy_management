package pharma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.*;

public class billing extends JFrame {

	private JPanel contentPane;
	private JTextField price_t;
	private JTable table;
	private JLabel date_show ;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField qnty;
	private JTextField mname;
	int i;
	double price;
	private JTextArea billarea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					billing frame = new billing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public billing() {
		initialize();
		Connect();
		table_load();
		//showdate();
		
		

	}
	public void showdate()
	{
	
		//DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		//LocalDateTime now =LocalDateTime.now();
		//date_show.setText(dtf.format(now));
		
		
		
	}
	 public void Connect()
	    {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/pharmacy_management", "root","0909");
	        }
	        catch (ClassNotFoundException ex) 
	        {
	          ex.printStackTrace();
	        }
	        catch (SQLException ex) 
	        {
	        	   ex.printStackTrace();
	        }

	    }
	 
	 
	 
	 public void table_load()
	    {
	    	try 
	    	{
		    pst = con.prepareStatement("select *from medicine1");
		    rs = pst.executeQuery();
		    table.setModel(DbUtils.resultSetToTableModel(rs));
		} 
	    	catch (SQLException e) 
	    	 {
	    		e.printStackTrace();
		  } 
	    }
	
	
	private void initialize()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(5, 5, 1350, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(25, 11, 191, 172);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(homepage.class.getResource("/pharma/image/pharm.jpg")));
		
		JPanel panel_home = new JPanel();
		panel_home.setBackground(Color.WHITE);
		panel_home.setBounds(226, 27, 1071, 657);
		contentPane.add(panel_home);
		panel_home.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("BILLING ");
		lblNewLabel_2.setForeground(new Color(0, 153, 0));
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_2.setBounds(383, 11, 324, 47);
		panel_home.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("ID ");
		lblNewLabel_3_1.setForeground(new Color(0, 153, 0));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(56, 107, 122, 27);
		panel_home.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("MEDNAME");
		lblNewLabel_3_2.setForeground(new Color(0, 153, 0));
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_2.setBounds(56, 160, 107, 27);
		panel_home.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("PRICE");
		lblNewLabel_3_3.setForeground(new Color(0, 153, 0));
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_3.setBounds(56, 214, 122, 27);
		panel_home.add(lblNewLabel_3_3);
		
		JTextField search = new JTextField();
		search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
			          
		            String id = search.getText();

		                pst = con.prepareStatement("select medname, price from medicine1 where id = ?");
		                pst.setString(1, id);
		                ResultSet rs = pst.executeQuery();

		            if(rs.next()==true)
		            {
		              
		                String name = rs.getString(1);
		                String addr = rs.getString(2);
		                
		                
		                
		                
		                
		                
		                mname.setText(name);
		                price_t.setText(addr);
		                
		              
		               
		               
		               
		               
		               
		                
		                


		               
		                
		            }   
		            else
		            {
		            	
		                 
		            }
		            


		        } 
			
			 catch (SQLException ex) {
		           
		        }
			
			
				
				
				
			}
		});
		search.setFont(new Font("Segoe UI", Font.BOLD, 15));
		search.setColumns(10);
		search.setBounds(229, 108, 153, 27);
		panel_home.add(search);
		
		price_t = new JTextField();
		price_t.setFont(new Font("Segoe UI", Font.BOLD, 15));
		price_t.setColumns(10);
		price_t.setBounds(229, 221, 153, 27);
		panel_home.add(price_t);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new TitledBorder(null, "MEDICINE DETAILS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 153, 51)));
		scrollPane.setBounds(409, 84, 652, 221);
		panel_home.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2_1 = new JLabel("BILL");
		lblNewLabel_2_1.setForeground(new Color(0, 153, 0));
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_2_1.setBounds(229, 428, 122, 39);
		panel_home.add(lblNewLabel_2_1);
		
		JButton btnAddToBill = new JButton("ADD TO BILL");
		btnAddToBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a =Double.parseDouble(qnty.getText());
				 String check = qnty.getText();
				
				double b =Double.parseDouble(price_t.getText());
				price = a *b;
				
				i=0;
				i++;
				if(check.equals("") )
				{
					
					JOptionPane.showMessageDialog(null, "MISSING DATA");
					
					
				}
				else
				{
					if(i==1)
					{
						
						billarea.setText(billarea.getText()+" \n"  +  "medicine name  : " + mname.getText()+ "\n qnty: " +qnty.getText()+  "\n price: " + price+  "\n");
						
						
					}
				}
				
				
			}
		});
		btnAddToBill.setForeground(Color.WHITE);
		btnAddToBill.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddToBill.setBackground(new Color(0, 102, 0));
		btnAddToBill.setBounds(37, 341, 141, 30);
		panel_home.add(btnAddToBill);
		
		JButton btnDelete = new JButton("CLEAR");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search.setText(null);
				mname.setText(null);
				price_t.setText(null);
				qnty.setText(null);
				
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete.setBackground(new Color(0, 102, 0));
		btnDelete.setBounds(282, 341, 100, 30);
		panel_home.add(btnDelete);
		
		JButton btnPrint = new JButton("PRINT");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					billarea.print();
					
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
			}
		});
		btnPrint.setForeground(Color.WHITE);
		btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPrint.setBackground(new Color(0, 102, 0));
		btnPrint.setBounds(205, 518, 100, 30);
		panel_home.add(btnPrint);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(409, 382, 442, 253);
		panel_home.add(scrollPane_1);
		
		 billarea = new JTextArea();
		 billarea.setText("***********SHIVI PHARMA CENTER************");
		 billarea.setFont(new Font("Segoe UI", Font.BOLD, 20));
		 billarea.setForeground(new Color(0, 153, 51));
		scrollPane_1.setViewportView(billarea);
		
		JLabel date_show = new JLabel("");
		date_show.setBounds(842, 11, 116, 39);
		panel_home.add(date_show);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("QUANTITY");
		lblNewLabel_3_3_1.setForeground(new Color(0, 153, 0));
		lblNewLabel_3_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_3_1.setBounds(56, 267, 122, 27);
		panel_home.add(lblNewLabel_3_3_1);
		
		qnty = new JTextField();
		qnty.setFont(new Font("Segoe UI", Font.BOLD, 15));
		qnty.setColumns(10);
		qnty.setBounds(229, 274, 153, 27);
		panel_home.add(qnty);
		
		mname = new JTextField();
		mname.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mname.setColumns(10);
		mname.setBounds(229, 167, 153, 27);
		panel_home.add(mname);
		
		JLabel lblNewLabel_1_3 = new JLabel("HOME");
		lblNewLabel_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				homepage hm =new homepage();
				hm.setVisible(true);
			}
		});
		lblNewLabel_1_3.setToolTipText("");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(25, 228, 173, 38);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1 = new JLabel("COMPANY");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				company cm=new company();
				cm.setVisible(true);
				
			}
		});
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1.setBounds(25, 277, 173, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("AGENTS");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agent ah =new agent();
				ah.setVisible(true);
			}
		});
		lblNewLabel_1_1.setToolTipText("");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(25, 326, 173, 38);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("BILLING");
		lblNewLabel_1_2.setToolTipText("");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(25, 375, 173, 38);
		contentPane.add(lblNewLabel_1_2);
		
		
		
	}
}
	
	
