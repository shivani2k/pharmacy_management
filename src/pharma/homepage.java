package pharma;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import com.toedter.calendar.IDateEditor;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class homepage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField medname;
	private JTextField price;
	private JTextField quantity;
	//public String medn,prc,qnty,com;
	Date exdate;
	Date mdate;
	java.sql.Date myfabdate,myexpdate;

	/**
	 * Launch the application.
	 */
	
	
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTable table;
	private JTextField search;
	
 
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
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homepage frame = new homepage();
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
	public homepage() {
		initialize();
		Connect();
		table_load();
		
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
		lblNewLabel_1.setBounds(25, 265, 173, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("AGENTS");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				agent agent_page =new agent();
				agent_page.setVisible(true);
				setVisible(false);
				
				
			}
		});
		lblNewLabel_1_1.setToolTipText("");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(25, 314, 173, 38);
		contentPane.add(lblNewLabel_1_1);
		
		JPanel panel_home = new JPanel();
		panel_home.setBackground(Color.WHITE);
		panel_home.setBounds(226, 27, 1071, 657);
		contentPane.add(panel_home);
		panel_home.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("MANAGE MEDICINE");
		lblNewLabel_2.setForeground(new Color(0, 153, 0));
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_2.setBounds(383, 11, 324, 47);
		panel_home.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("MEDNAME");
		lblNewLabel_3_1.setForeground(new Color(0, 153, 0));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(56, 107, 122, 27);
		panel_home.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("PRICE");
		lblNewLabel_3_2.setForeground(new Color(0, 153, 0));
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_2.setBounds(69, 160, 94, 27);
		panel_home.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("QUANTITY");
		lblNewLabel_3_3.setForeground(new Color(0, 153, 0));
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_3.setBounds(56, 214, 122, 27);
		panel_home.add(lblNewLabel_3_3);
		
		medname = new JTextField();
		medname.setFont(new Font("Segoe UI", Font.BOLD, 15));
		medname.setColumns(10);
		medname.setBounds(229, 108, 153, 27);
		panel_home.add(medname);
		
		price = new JTextField();
		price.setFont(new Font("Segoe UI", Font.BOLD, 15));
		price.setColumns(10);
		price.setBounds(229, 161, 153, 27);
		panel_home.add(price);
		
		quantity = new JTextField();
		quantity.setFont(new Font("Segoe UI", Font.BOLD, 15));
		quantity.setColumns(10);
		quantity.setBounds(229, 215, 153, 27);
		panel_home.add(quantity);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("FABDATE");
		lblNewLabel_3_1_1.setForeground(new Color(0, 153, 0));
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1_1.setBounds(561, 107, 122, 27);
		panel_home.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("EXPDATE");
		lblNewLabel_3_1_2.setForeground(new Color(0, 153, 0));
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1_2.setBounds(561, 160, 122, 27);
		panel_home.add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_3_1_3 = new JLabel("COMPANY");
		lblNewLabel_3_1_3.setForeground(new Color(0, 153, 0));
		lblNewLabel_3_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1_3.setBounds(561, 214, 122, 27);
		panel_home.add(lblNewLabel_3_1_3);
		
		JDateChooser mfdate1 = new JDateChooser();
		mfdate1.setBounds(735, 107, 153, 27);
		panel_home.add(mfdate1);
		
		JDateChooser expdate = new JDateChooser();
		expdate.setBounds(735, 160, 153, 27);
		panel_home.add(expdate);
		
		JComboBox company_name = new JComboBox();
		company_name.setFont(new Font("Segoe UI", Font.BOLD, 15));
		company_name.setModel(new DefaultComboBoxModel(new String[] {"sunpharma", "pharmBBA", "pharmdd", "pharmc", "asb"}));
		company_name.setToolTipText("");
		company_name.setBounds(735, 208, 153, 27);
		panel_home.add(company_name);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			@SuppressWarnings("unlikely-arg-type")
			public void actionPerformed(ActionEvent e) {
				
				//saving data into database
				
				//mid = id.getText();
        		String medn = medname.getText();
        		String prc = price.getText();
        		String qnty = quantity.getText();
        		mdate=mfdate1.getDate();
        		myfabdate =new java.sql.Date(mdate.getTime());
        		exdate=expdate.getDate();
        		myexpdate=new java.sql.Date(exdate.getTime());
        		String com = company_name.getSelectedItem().toString();
        		
        		if(medn.equals(""))
        		{
        			JOptionPane.showMessageDialog(null, "please enter medicine name");
        		}
        		else if (prc.equals(""))
        		{
        			JOptionPane.showMessageDialog(null, "please enter price");
        		}
        		else if(qnty.equals(""))
        		{
        			JOptionPane.showMessageDialog(null, "quantity can't be empty");
        		}
        		else if(myfabdate.equals(""))
        		{
        			JOptionPane.showMessageDialog(null,"please select manufacturaing date");
        		}
        		else if(myexpdate.equals("")) {
        			JOptionPane.showMessageDialog(null, "please select exp date");
        			
        		}
        		else if(company_name.equals(""))
        		{
        			JOptionPane.showMessageDialog(null, "select company name");
        		
        		}
        		else
        		{
        		
		        		 try {
								pst = con.prepareStatement("insert into medicine1(medname,price,quantity,fabdate,expt,company)values(?,?,?,?,?,?)");
								pst.setString(1,medname.getText());
								pst.setString(2,price.getText());
								//pst.setInt(2,Integer.valueOf(price.getText()));
								pst.setInt(3,Integer.valueOf(quantity.getText()));
								pst.setDate(4, myfabdate);
								pst.setDate(5,myexpdate);
								pst.setString(6,company_name.getSelectedItem().toString());
								pst.executeUpdate();
								table_load();
								
								
								
								
							
								
								
		
		
								JOptionPane.showMessageDialog(null, "Record Addedddd!!!!!");
								
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
		btnAdd.setBounds(314, 303, 100, 30);
		panel_home.add(btnAdd);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String bid=search.getText();
				
				//updating records.....
				 try {
						pst = con.prepareStatement("update medicine1 set medname= ?,price=?,quantity=?,fabdate=?,expt=?,company=? where id =?");
						pst.setString(1,medname.getText());
						pst.setString(2,price.getText());
						//pst.setInt(2,Integer.valueOf(price.getText()));
						pst.setInt(3,Integer.valueOf(quantity.getText()));
						pst.setDate(4, myfabdate);
						pst.setDate(5,myexpdate);
						pst.setString(6,company_name.getSelectedItem().toString());
						pst.setString(7, bid);
			            pst.executeUpdate();
			            JOptionPane.showMessageDialog(null, "Record Update!!!!!");
			            table_load();
			           
			            //tname.setText("");
			          //  tedition.setText("");
			            //price.setText("");
			           // tname.requestFocus();
					}

		            catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				
				
				
				
			}
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdate.setBackground(new Color(0, 102, 0));
		btnUpdate.setBounds(465, 303, 100, 30);
		panel_home.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String bid;
                bid  = search.getText();
	
                try {
                	pst = con.prepareStatement("delete from medicine1 where id =?");
	
                	pst.setString(1, bid);
                	pst.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Record Delete!!!!!");
	            table_load();
	           
	           // tname.setText("");
	           // tedition.setText("");
	           // tprice.setText("");
	           // tname.requestFocus();
                }

	        catch (SQLException e1) {
				
				e1.printStackTrace();
			}
				
				
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete.setBackground(new Color(0, 102, 0));
		btnDelete.setBounds(600, 303, 100, 30);
		panel_home.add(btnDelete);
		
		JLabel id_display = new JLabel("");
		id_display.setBackground(new Color(192, 192, 192));
		id_display.setForeground(new Color(0, 153, 0));
		id_display.setFont(new Font("Tahoma", Font.BOLD, 20));
		id_display.setBounds(229, 107, 153, 27);
		panel_home.add(id_display);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//DefaultTableModel model1=(DefaultTableModel)scrollPane.getModel();
				//int
				//
				
				
				
				
			}
		});
		scrollPane.setViewportBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "MEDICINE DETAILS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 0)));
		scrollPane.setBounds(10, 397, 1051, 260);
		panel_home.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 153, 51));
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 0)));
		panel_1.setBounds(693, 344, 368, 50);
		panel_home.add(panel_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel(" ID");
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

			                pst = con.prepareStatement("select medname,price,quantity,fabdate, expt,company from medicine1 where id = ?");
			                pst.setString(1, id);
			                ResultSet rs = pst.executeQuery();

			            if(rs.next()==true)
			            {
			              
			                String name = rs.getString(1);
			                String price1 = rs.getString(2);
			                String qunty = rs.getString(3);
			                Date mdt=rs.getDate(4);
			                Date edt =rs.getDate(5);
			                String company_select =rs.getString(6);
			                
			                
			                
			                
			                
			                medname.setText(name);
			                price.setText(price1);
			                quantity.setText(qunty);
			               mfdate1.setDate(mdt);
			               expdate.setDate(edt);
			               company_name.setSelectedItem(company_select);
			               
			               
			               
			               
			               
			                
			                


			               
			                
			            }   
			            else
			            {
			            	medname.setText("");
			                price.setText("");
			                quantity.setText("");
			               //mfdate1.setDate("");
			              // expdate.setDate("");
			               company_name.setSelectedItem("");
			                 
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
		
		
		
		JPanel panel_home1 = new JPanel();
		panel_home1.setBackground(Color.WHITE);
		panel_home1.setBounds(226, 27, 1071, 657);
		contentPane.add(panel_home1);
		
		JPanel panel_home2 = new JPanel();
		panel_home2.setBackground(Color.WHITE);
		panel_home2.setBounds(226, 27, 1071, 657);
		contentPane.add(panel_home2);
		
		JLabel lblNewLabel_1_3 = new JLabel("HOME");
		lblNewLabel_1_3.setToolTipText("");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(25, 216, 173, 38);
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
		lblNewLabel_1_1_1.setBounds(25, 363, 173, 38);
		contentPane.add(lblNewLabel_1_1_1);
	}

	








	public JTextField getTextField() {
		return textField;
	}









	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
}
