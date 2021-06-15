package pharma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class agent extends JFrame {

	private JPanel contentPane;
	
	private JTextField textField;
	private JTextField gntname;
	private JTextField age_user;
	private JPasswordField phone_number;
	
	//public String medn,prc,qnty,com;
	
	
	private JTextField search;
	private JTextField textField_2;
	

	/**
	 * Launch the application.
	 */
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTable table;
	private JTextField number1;
	private JPasswordField pass1;
	private JTable table_1;
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
	
	
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					agent frame = new agent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void table_load()
    {
    	try 
    	{
	    pst = con.prepareStatement("select *from agent_data");
	    rs = pst.executeQuery();
	    table_1.setModel(DbUtils.resultSetToTableModel(rs));
	} 
    	catch (SQLException e) 
    	 {
    		e.printStackTrace();
	  } 
    }
	
	
	
	

	/**
	 * Create the frame.
	 */
	
	public agent()
	{
		initialize();
		Connect();
		table_load();
	}
	public void initialize() {
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
		
		JLabel lblNewLabel_1 = new JLabel("COMPANY");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				company cmp =new company();
				cmp.setVisible(true);
				setVisible(false);
						
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1.setBounds(25, 262, 173, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("AGENTS");
		lblNewLabel_1_1.setToolTipText("");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(25, 311, 173, 38);
		contentPane.add(lblNewLabel_1_1);
		
		JPanel panel_home = new JPanel();
		panel_home.setBackground(Color.WHITE);
		panel_home.setBounds(226, 27, 1071, 657);
		contentPane.add(panel_home);
		panel_home.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("MANAGE AGENT");
		lblNewLabel_2.setForeground(new Color(0, 153, 0));
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_2.setBounds(383, 11, 324, 47);
		panel_home.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("AGENT NAME");
		lblNewLabel_3_1.setForeground(new Color(0, 153, 0));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(45, 107, 143, 27);
		panel_home.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("AGE");
		lblNewLabel_3_2.setForeground(new Color(0, 153, 0));
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_2.setBounds(69, 160, 94, 27);
		panel_home.add(lblNewLabel_3_2);
		
		gntname = new JTextField();
		gntname.setFont(new Font("Segoe UI", Font.BOLD, 15));
		gntname.setColumns(10);
		gntname.setBounds(229, 108, 153, 27);
		panel_home.add(gntname);
		
		age_user = new JTextField();
		age_user.setFont(new Font("Segoe UI", Font.BOLD, 15));
		age_user.setColumns(10);
		age_user.setBounds(229, 161, 153, 27);
		panel_home.add(age_user);
		
		JLabel lblNewLabel_3_1_3 = new JLabel("GENDER");
		lblNewLabel_3_1_3.setForeground(new Color(0, 153, 0));
		lblNewLabel_3_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1_3.setBounds(45, 219, 122, 27);
		panel_home.add(lblNewLabel_3_1_3);
		
		JComboBox gender_user = new JComboBox();
		gender_user.setFont(new Font("Segoe UI", Font.BOLD, 15));
		gender_user.setModel(new DefaultComboBoxModel(new String[] {"MALE", "FEMALE"}));
		gender_user.setToolTipText("");
		gender_user.setBounds(229, 220, 153, 27);
		panel_home.add(gender_user);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String agnt = gntname.getText();
        		String age1 = age_user.getText();
        		String gender1=gender_user.getSelectedItem().toString();
        		//int number1 = number.
        		String pass =pass1.getText();
        		
        		
        		
        		
        		if(agnt.equals(""))
        		{
        			JOptionPane.showMessageDialog(null, "please enter agent name");
        		}
        		else if (age1.equals(""))
        		{
        			JOptionPane.showMessageDialog(null, "please enter age");
        		}
        		else if(gender1.equals(""))
        		{
        			JOptionPane.showMessageDialog(null, "please select gender");
        		}
        		//else if(number1.equals(""))
        		//{
        			//JOptionPane.showMessageDialog(null,"please enter number");
        		//}
        		else if(pass.equals("")) {
        			JOptionPane.showMessageDialog(null, "please enter password");
        			
        		}
        		
        		else
        		{
        		
		        		 try {
								pst = con.prepareStatement("insert into agent_data(agent,age,gender,phone,password)values(?,?,?,?,?)");
								pst.setString(1, gntname.getText());
								pst.setString(2,age_user.getText());
							
								pst.setString(3,gender_user.getSelectedItem().toString());
								pst.setString(4, number1.getText());
								//pst.setInt(4,Integer.valueOf(number.getText()));
								//pst.setInt(4,Integer.valueOf(number1.getText()));
								pst.setString(5, pass1.getText());
								
								pst.executeUpdate();
								table_load();
								
								
								
								 gntname.setText("");
					               
					                age_user.setText("");
					                gender_user.setSelectedItem("");
					                number1.setText("");
					                pass1.setText("");
								
								
								
								
							
								
								
		
		
								JOptionPane.showMessageDialog(null, "Record Added!!!!!");
								
							   }
		
							catch (SQLException e1) 
						        {
												
							e1.printStackTrace();
							
							
						        }
        		}
				
				
				
			}
		});
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setBackground(new Color(0, 102, 0));
		btnAdd.setBounds(321, 287, 100, 30);
		panel_home.add(btnAdd);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String bid=search.getText();
				
				
				 try {
						pst = con.prepareStatement("update agent_data set agent= ?,age=?,gender=?,phone=?,password=? where id =?");
						pst.setString(1,gntname.getText());
						pst.setString(2,age_user.getText());
						
						
						pst.setString(3,gender_user.getSelectedItem().toString());
						pst.setString(4,number1.getText());
						pst.setString(5, pass1.getText());
						pst.setString(6, bid);
			            pst.executeUpdate();
			            JOptionPane.showMessageDialog(null, "Record Update!!!!!");
			            table_load();
			            
			            
			            
			            
			            gntname.setText("");
			               
		                age_user.setText("");
		                gender_user.setSelectedItem("");
		                number1.setText("");
		                pass1.setText("");
			           
			           
					}

		            catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				
				
				
				
				
			}
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdate.setBackground(new Color(0, 102, 0));
		btnUpdate.setBounds(472, 287, 100, 30);
		panel_home.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String bid;
                bid  = search.getText();
	
                try {
                	pst = con.prepareStatement("delete from agent_data where id =?");
	
                	pst.setString(1, bid);
                	pst.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Record Delete!!!!!");
	            table_load();
	           
	            
	            //for not displaying records after deleting....
	            gntname.setText("");
	               
                age_user.setText("");
                gender_user.setSelectedItem("");
                number1.setText("");
                pass1.setText("");
	           
                }

	        catch (SQLException e1) {
				
				e1.printStackTrace();
			}
				
				
				
				
				
			}
			
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete.setBackground(new Color(0, 102, 0));
		btnDelete.setBounds(607, 287, 100, 30);
		panel_home.add(btnDelete);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(new Color(0, 153, 51));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 0)));
		panel_1.setBounds(693, 338, 368, 50);
		panel_home.add(panel_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("ID");
		lblNewLabel_1_1_1_1.setForeground(new Color(0, 153, 0));
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(10, 11, 106, 27);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		search = new JTextField();
		search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				
				
				 try {
			          
			            String id = search.getText();

			                pst = con.prepareStatement("select agent,age,gender,phone,password from agent_data where id = ?");
			                pst.setString(1, id);
			                ResultSet rs = pst.executeQuery();

			            if(rs.next()==true)
			            {
			              
			                String name = rs.getString(1);
			                String age = rs.getString(2);
			                String gender1 = rs.getString(3);
			                String phone = rs.getString(4);
			                
			                String password = rs.getString(5);
			                
			                
			                
			                
			                
			              
			                gntname.setText(name);
			               
			                age_user.setText(age);
			                gender_user.setSelectedItem(gender1);
			                number1.setText(phone);
			                pass1.setText(password);
			                
			                
			              
			              
			               
			               
			               
			               
			                
			                


			               
			                
			            }   
			            else
			            {  // search.setText("");
			            
			                gntname.setText("");
			               
			                age_user.setText("");
			                gender_user.setSelectedItem("");
			                number1.setText("");
			                pass1.setText("");
			                 
			            }
			            


			        } 
				
				 catch (SQLException ex) {
			           
			        }
				
				
				
				
			}
		});
		search.setFont(new Font("Tahoma", Font.PLAIN, 15));
		search.setColumns(10);
		search.setBounds(126, 13, 213, 22);
		panel_1.add(search);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("PHONE");
		lblNewLabel_3_2_1.setForeground(new Color(0, 153, 0));
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_2_1.setBounds(575, 107, 94, 27);
		panel_home.add(lblNewLabel_3_2_1);
		
		
		
		JLabel lblNewLabel_3_3_1 = new JLabel("PASSWORD");
		lblNewLabel_3_3_1.setForeground(new Color(0, 153, 0));
		lblNewLabel_3_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_3_1.setBounds(561, 160, 122, 27);
		panel_home.add(lblNewLabel_3_3_1);
		
		number1 = new JTextField();
		number1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		number1.setColumns(10);
		number1.setBounds(735, 94, 153, 27);
		panel_home.add(number1);
		
		pass1 = new JPasswordField();
		pass1.setBounds(735, 164, 153, 27);
		panel_home.add(pass1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "MANAGE AGEENT", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 153, 0)));
		scrollPane.setBounds(10, 390, 1051, 256);
		panel_home.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("HOME");
		lblNewLabel_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				homepage home =new homepage();
				home.setVisible(true);
				setVisible(false);
			}
		});
		lblNewLabel_1_3.setToolTipText("");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(25, 221, 173, 38);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("BILLING");
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				billing bl =new billing();
				bl.setVisible(true);
				
			}
		});
		lblNewLabel_1_1_1.setToolTipText("");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(35, 360, 153, 38);
		contentPane.add(lblNewLabel_1_1_1);
	}
}
