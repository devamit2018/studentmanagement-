package com.test.client;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.test.models.Student;
import com.test.services.Studentinterface;
import com.test.services.Studentservicesimpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Editform extends JFrame {

	private JPanel contentPane;
	private JLabel lblUsername;
	private JTextField namtxt;
	private JLabel lblAddress;
	private JTextField adtxt;
	private JLabel lblPhone;
	private JTextField phntxt;
	private JButton btnUpdate;
	private JButton btnBack;
	private int uid = 0;

	
	public Editform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 268, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblUsername());
		contentPane.add(getNamtxt());
		contentPane.add(getLblAddress());
		contentPane.add(getAdtxt());
		contentPane.add(getLblPhone());
		contentPane.add(getPhntxt());
		contentPane.add(getBtnUpdate());
		contentPane.add(getBtnBack());
		
		setVisible(true);

	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("username");
			lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblUsername.setBounds(27, 31, 76, 14);
		}
		return lblUsername;
	}
	private JTextField getNamtxt() {
		if (namtxt == null) {
			namtxt = new JTextField();
			namtxt.setBounds(113, 30, 113, 20);
			namtxt.setColumns(10);
		}
		return namtxt;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address");
			lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblAddress.setBounds(27, 79, 76, 14);
		}
		return lblAddress;
	}
	private JTextField getAdtxt() {
		if (adtxt == null) {
			adtxt = new JTextField();
			adtxt.setColumns(10);
			adtxt.setBounds(113, 78, 113, 20);
		}
		return adtxt;
	}
	private JLabel getLblPhone() {
		if (lblPhone == null) {
			lblPhone = new JLabel("phone");
			lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblPhone.setBounds(27, 181, 76, 14);
		}
		return lblPhone;
	}
	private JTextField getPhntxt() {
		if (phntxt == null) {
			phntxt = new JTextField();
			phntxt.setColumns(10);
			phntxt.setBounds(113, 180, 113, 20);
		}
		return phntxt;
	}
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					Student s = new Student();
					s.setId(uid);
					s.setUsername(namtxt.getText());
					s.setAddress(adtxt.getText());
					s.setPhone(phntxt.getText());
					
					Studentinterface ss = new Studentservicesimpl();
					
					if(ss.updateStudent(s))
					{
						JOptionPane.showMessageDialog(null,"updated successfully");
						new Studentform();
						dispose();
					}
					
					
				}
			});
			btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnUpdate.setBounds(137, 227, 89, 23);
		}
		return btnUpdate;
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new Studentform();
					dispose();
				}
			});
			btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnBack.setBounds(137, 272, 89, 23);
		}
		return btnBack;
	}
	public void displaydata(int id)
	{
		uid = id;
		Studentinterface ss = new Studentservicesimpl();
		Student s = ss.getbyid(id);
		
		
		namtxt.setText(s.getUsername());
		adtxt.setText(s.getAddress());
		
		phntxt.setText(s.getPhone());
		
	}
}
