package com.test.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.test.models.Student;
import com.test.services.Studentinterface;
import com.test.services.Studentservicesimpl;

import java.awt.Font;
import java.awt.Panel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Studentform extends JFrame {

	private JPanel contentPane;
	private JPanel inputpanel;
	private JLabel lblUsername;
	private JTextField nametxt;
	private JTextField addresstxt;
	private JLabel lblAddress;
	private JTextField phonetxt;
	private JLabel lblPhone;
	private JLabel lblFaculty;
	private JComboBox comboBox;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnView;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnExit;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Studentform frame = new Studentform();
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
	public Studentform() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "Studentform", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getInputpanel());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnView());
		contentPane.add(getBtnEdit());
		contentPane.add(getBtnDelete());
		contentPane.add(getBtnExit());
		contentPane.add(getBtnBack());
		populatedata();
		setVisible(true);
	}
	private JPanel getInputpanel() {
		if (inputpanel == null) {
			inputpanel = new JPanel();
			inputpanel.setForeground(new Color(51, 204, 51));
			inputpanel.setBorder(new TitledBorder(null, "input", TitledBorder.LEFT, TitledBorder.TOP, null, null));
			inputpanel.setBounds(10, 23, 725, 104);
			inputpanel.setLayout(null);
			inputpanel.add(getLblUsername());
			inputpanel.add(getNametxt());
			inputpanel.add(getAddresstxt());
			inputpanel.add(getLblAddress());
			inputpanel.add(getTextField_1());
			inputpanel.add(getLblPhone());
			inputpanel.add(getLblFaculty());
			inputpanel.add(getComboBox());
			inputpanel.add(getBtnNewButton());
		}
		return inputpanel;
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("username");
			lblUsername.setFont(new Font("Tahoma", Font.BOLD, 10));
			lblUsername.setBounds(10, 24, 56, 14);
		}
		return lblUsername;
	}
	private JTextField getNametxt() {
		if (nametxt == null) {
			nametxt = new JTextField();
			nametxt.setFont(new Font("Tahoma", Font.BOLD, 10));
			nametxt.setBounds(69, 21, 86, 20);
			nametxt.setColumns(10);
		}
		return nametxt;
	}
	private JTextField getAddresstxt() {
		if (addresstxt == null) {
			addresstxt = new JTextField();
			addresstxt.setFont(new Font("Tahoma", Font.BOLD, 10));
			addresstxt.setColumns(10);
			addresstxt.setBounds(225, 21, 86, 20);
		}
		return addresstxt;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address");
			lblAddress.setFont(new Font("Tahoma", Font.BOLD, 10));
			lblAddress.setBounds(166, 24, 56, 14);
		}
		return lblAddress;
	}
	private JTextField getTextField_1() {
		if (phonetxt == null) {
			phonetxt = new JTextField();
			phonetxt.setFont(new Font("Tahoma", Font.BOLD, 10));
			phonetxt.setColumns(10);
			phonetxt.setBounds(380, 21, 86, 20);
		}
		return phonetxt;
	}
	private JLabel getLblPhone() {
		if (lblPhone == null) {
			lblPhone = new JLabel("phone");
			lblPhone.setFont(new Font("Tahoma", Font.BOLD, 10));
			lblPhone.setBounds(321, 24, 56, 14);
		}
		return lblPhone;
	}
	private JLabel getLblFaculty() {
		if (lblFaculty == null) {
			lblFaculty = new JLabel("Faculty");
			lblFaculty.setFont(new Font("Tahoma", Font.BOLD, 10));
			lblFaculty.setBounds(484, 24, 56, 14);
		}
		return lblFaculty;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"1.science and technology", "2.Arts", "3.Medical", "4.Law"}));
			comboBox.setBounds(530, 21, 172, 20);
		}
		return comboBox;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Save");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Student s = new Student();
					s.setUsername(nametxt.getText());
					s.setAddress(addresstxt.getText());
				String faculty = comboBox.getSelectedItem().toString();
				s.setFaculty(faculty);
				s.setPhone(phonetxt.getText());
					
					Studentinterface ss = new Studentservicesimpl();
				boolean result =	ss.addstudent(s);
				if(result == true)
				{
					JOptionPane.showMessageDialog(null, "inserted successfully");
					populatedata();
				}
					
					nametxt.setText("");
					addresstxt.setText("");
					phonetxt.setText("");
					comboBox.setSelectedIndex(0);
					
					Component[] cmplist = inputpanel.getComponents();
					for(Component c :cmplist)
					{
						c.setEnabled(false);
					}
					
				}
				
				
				
				
				
			});
			btnNewButton.setBounds(636, 70, 89, 23);
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 138, 725, 161);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"id", "username", "Address", "Faculty", "phone"
				}
			));
			table.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		return table;
	}
	

	
	
	
	private JButton getBtnView() {
		if (btnView == null) {
			btnView = new JButton("View");
			btnView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (table.getSelectedRow() < 0) {
						JOptionPane.showMessageDialog(null,
								"please, select any row!!");
						return;
					}

					int row = table.getSelectedRow();
					int id = (int) table.getModel().getValueAt(row, 0);

					new Viewform().displaydata(id);
					dispose();
				}
			});
			btnView.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnView.setBounds(10, 333, 89, 23);
		}
		return btnView;
	}
	private JButton getBtnEdit() {
		if (btnEdit == null) {
			btnEdit = new JButton("Edit");
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (table.getSelectedRow() < 0) {
						JOptionPane.showMessageDialog(null,
								"please, select any row!!");
						return;
					}

					int row = table.getSelectedRow();
					int id = (int) table.getModel().getValueAt(row, 0);

					new Editform().displaydata(id);
					dispose();
					
				}
			});
			btnEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnEdit.setBounds(109, 333, 89, 23);
		}
		return btnEdit;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (table.getSelectedRow() < 0) {
						JOptionPane.showMessageDialog(null,
								"Please select any row!!");
						return;
					}

					int row = table.getSelectedRow();
					int id = (int) table.getModel().getValueAt(row, 0);
					Studentinterface ss = new Studentservicesimpl();
					boolean result = ss.deletestudent(id);

					if (result == true) {
						JOptionPane.showMessageDialog(null,
								"deleted successfully!!");
						populatedata();
					}
				}
			});
			btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnDelete.setBounds(211, 335, 89, 23);
		}
		return btnDelete;
	}
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("Exit");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnExit.setBounds(318, 335, 89, 23);
		}
		return btnExit;
	}
	private void populatedata() 
	{
		Studentinterface ss = new Studentservicesimpl();
		List<Student> sList = ss.getstudent();

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		for (Student s : sList) {
			model.addRow(new Object[] { s.getId(), s.getUsername(), s.getAddress() ,s.getFaculty(),
					s.getPhone() });
		}
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Component[] cmplist = inputpanel.getComponents();
					
					for(Component c:cmplist)
					{
						c.setEnabled(true);
					}
					
					
				}
			});
			btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnBack.setBounds(646, 333, 89, 23);
		}
		return btnBack;
	}
}
