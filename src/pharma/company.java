package pharma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class company extends JFrame {

	private JPanel contentPane;

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField phn;
	private JTable table;
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					company frame = new company();
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
		    pst = con.prepareStatement("select *from company_manage");
		    rs = pst.executeQuery();
		    table.setModel(DbUtils.resultSetToTableModel(rs));
		} 
	    	catch (SQLException e) 
	    	 {
	    		e.printStackTrace();
		  } 
	    }
	 
	 
	 
	
	
	
	
	public company() {
		
		
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
				
				
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1.setBounds(25, 271, 173, 38);
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
		lblNewLabel_1_1.setBounds(25, 320, 173, 38);
		contentPane.add(lblNewLabel_1_1);
		
		JPanel panel_home = new JPanel();
		panel_home.setBackground(Color.WHITE);
		panel_home.setBounds(226, 27, 1071, 657);
		contentPane.add(panel_home);
		panel_home.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("MANAGE COMPANY");
		lblNewLabel_2.setForeground(new Color(0, 153, 0));
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_2.setBounds(383, 11, 324, 47);
		panel_home.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("NAME");
		lblNewLabel_3_1.setForeground(new Color(0, 153, 0));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(56, 107, 122, 27);
		panel_home.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("ADDRESS");
		lblNewLabel_3_2.setForeground(new Color(0, 153, 0));
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_2.setBounds(56, 160, 107, 27);
		panel_home.add(lblNewLabel_3_2);
		
		JTextField cname = new JTextField();
		cname.setFont(new Font("Segoe UI", Font.BOLD, 15));
		cname.setColumns(10);
		cname.setBounds(229, 108, 202, 27);
		cname.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_home.add(cname);
		
		
		
		JLabel lblNewLabel_3_1_1 = new JLabel("\r\nEXPERIENCE");
		lblNewLabel_3_1_1.setForeground(new Color(0, 153, 0));
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1_1.setBounds(546, 107, 137, 27);
		panel_home.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("PHONE");
		lblNewLabel_3_1_2.setForeground(new Color(0, 153, 0));
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1_2.setBounds(561, 160, 122, 27);
		panel_home.add(lblNewLabel_3_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(229, 165, 276, 97);
		panel_home.add(scrollPane);
		
		JTextArea add = new JTextArea();
		scrollPane.setViewportView(add);
		add.setFont(new Font("Segoe UI", Font.BOLD, 15));
		add.setBackground(Color.WHITE);
		add.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JTextField exprnc = new JTextField();
		exprnc.setFont(new Font("Segoe UI", Font.BOLD, 15));
		exprnc.setColumns(10);
		exprnc.setBorder(new LineBorder(new Color(0, 0, 0)));
		exprnc.setBounds(746, 108, 202, 27);
		panel_home.add(exprnc);
		
		phn = new JTextField();
		phn.setFont(new Font("Segoe UI", Font.BOLD, 15));
		phn.setColumns(10);
		phn.setBorder(new LineBorder(new Color(0, 0, 0)));
		phn.setBounds(746, 167, 202, 27);
		panel_home.add(phn);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 426, 1051, 229);
		scrollPane_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "COMPANY DETAILS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 51)));
		panel_home.add(scrollPane_1);
		
		table = new JTable();
		table.setBorder(null);
		scrollPane_1.setViewportView(table);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				String name = cname.getText();
        		String address = add.getText();
        		
        		String exprn =exprnc.getText();
        		String phone =phn.getText();
        		
        		
        		
        		
        		if(name.equals(""))
        		{
        			JOptionPane.showMessageDialog(null, "please enter company name");
        		}
        		else if (address.equals(""))
        		{
        			JOptionPane.showMessageDialog(null, "please enter age");
        		}
        		else if(exprn.equals(""))
        		{
        			JOptionPane.showMessageDialog(null, "please enter experience");
        		}
        		
        		else if(phone.equals("")) {
        			JOptionPane.showMessageDialog(null, "please enter phone number");
        			
        		}
        		
        		else
        		{
        		
		        		 try {
								pst = con.prepareStatement("insert into company_manage(name,address, experience,phone)values(?,?,?,?)");
								pst.setString(1, cname.getText());
								pst.setString(2,add.getText());
							
								
								pst.setString(3, exprnc.getText());
								
								pst.setString(4, phn.getText());
								
								pst.executeUpdate();
								table_load();
								
								
								
									cname.setText("");
					               
					                add.setText("");
					                
					               exprnc.setText("");
					                phn.setText("");
								
								
								
								
							
								
								
		
		
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
		btnAdd.setBounds(433, 303, 100, 30);
		panel_home.add(btnAdd);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String bid=search.getText();
				
				//updating records.....
				 try {
						pst = con.prepareStatement("update company_manage set name= ?,address=?,experience=?,phone=? where id =?");
						pst.setString(1,cname.getText());
						pst.setString(2,add.getText());
						//pst.setInt(2,Integer.valueOf(price.getText()));
						pst.setInt(3,Integer.valueOf(exprnc.getText()));
						pst.setString(4,phn.getText());
					
						pst.setString(5, bid);
			            pst.executeUpdate();
			            JOptionPane.showMessageDialog(null, "Record Update!!!!!");
			            table_load();

						cname.setText("");
		               
		                add.setText("");
		                
		               exprnc.setText("");
		                phn.setText("");
			           
					}

		            catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				
				
				
				
			}
				
			
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdate.setBackground(new Color(0, 102, 0));
		btnUpdate.setBounds(584, 303, 100, 30);
		panel_home.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String bid;
               bid  = search.getText();
	
                try {
                	pst = con.prepareStatement("delete from company_manage where id =?");
	
                	pst.setString(1, bid);
                	pst.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Record Delete!!!!!");
	            table_load();
	            
	            
	            cname.setText("");
	               
                add.setText("");
                
               exprnc.setText("");
                phn.setText("");
			
	           
	          
                }

	        catch (SQLException e1) {
				
				e1.printStackTrace();
			}
				
				
			}
				
			
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete.setBackground(new Color(0, 102, 0));
		btnDelete.setBounds(719, 303, 100, 30);
		panel_home.add(btnDelete);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(new Color(0, 153, 51));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 0)));
		panel_1.setBounds(693, 365, 368, 50);
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

			                pst = con.prepareStatement("select name,address,experience,phone from company_manage where id = ?");
			                pst.setString(1, id);
			                ResultSet rs = pst.executeQuery();

			            if(rs.next()==true)
			            {
			              
			                String name = rs.getString(1);
			                String addr = rs.getString(2);
			                String expr = rs.getString(3);
			               
			                String phone =rs.getString(4);
			                
			                
			                
			                
			                
			                cname.setText(name);
			                add.setText(addr);
			                exprnc.setText(expr);
			              phn.setText(phone);
			              
			               
			               
			               
			               
			               
			                
			                


			               
			                
			            }   
			            else
			            {
			            	cname.setText("");
			                add.setText("");
			                exprnc.setText("");
			              phn.setText("");
			                 
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
		lblNewLabel_1_3.setBounds(25, 222, 173, 38);
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
		lblNewLabel_1_1_1.setBounds(25, 369, 173, 38);
		contentPane.add(lblNewLabel_1_1_1);

}
}

