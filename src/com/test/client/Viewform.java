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
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Viewform extends JFrame {

	private JPanel contentPane;
	private JLabel label;
	private JTextField namtxt;
	private JLabel label_1;
	private JTextField addtxt;
	private JLabel label_2;
	private JTextField factxt;
	private JLabel label_3;
	private JTextField phntxt;
	private JButton btnBack;

	
	public Viewform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLabel());
		contentPane.add(getNamtxt());
		contentPane.add(getLabel_1());
		contentPane.add(getAddtxt());
		contentPane.add(getLabel_2());
		contentPane.add(getFactxt());
		contentPane.add(getLabel_3());
		contentPane.add(getPhntxt());
		contentPane.add(getBtnBack());
		
		setVisible(true);
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("username");
			label.setFont(new Font("Tahoma", Font.BOLD, 14));
			label.setBounds(35, 26, 76, 14);
		}
		return label;
	}
	private JTextField getNamtxt() {
		if (namtxt == null) {
			namtxt = new JTextField();
			namtxt.setFont(new Font("Tahoma", Font.BOLD, 14));
			namtxt.setEditable(false);
			namtxt.setColumns(10);
			namtxt.setBounds(121, 25, 113, 20);
		}
		return namtxt;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("Address");
			label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			label_1.setBounds(35, 74, 76, 14);
		}
		return label_1;
	}
	private JTextField getAddtxt() {
		if (addtxt == null) {
			addtxt = new JTextField();
			addtxt.setFont(new Font("Tahoma", Font.BOLD, 14));
			addtxt.setEditable(false);
			addtxt.setColumns(10);
			addtxt.setBounds(121, 73, 113, 20);
		}
		return addtxt;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("Faculty");
			label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			label_2.setBounds(35, 128, 76, 14);
		}
		return label_2;
	}
	private JTextField getFactxt() {
		if (factxt == null) {
			factxt = new JTextField();
			factxt.setFont(new Font("Tahoma", Font.BOLD, 14));
			factxt.setEditable(false);
			factxt.setColumns(10);
			factxt.setBounds(121, 127, 113, 20);
		}
		return factxt;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("phone");
			label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
			label_3.setBounds(35, 176, 76, 14);
		}
		return label_3;
	}
	private JTextField getPhntxt() {
		if (phntxt == null) {
			phntxt = new JTextField();
			phntxt.setFont(new Font("Tahoma", Font.BOLD, 14));
			phntxt.setEditable(false);
			phntxt.setColumns(10);
			phntxt.setBounds(121, 175, 113, 20);
		}
		return phntxt;
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
			btnBack.setBounds(145, 220, 89, 23);
		}
		return btnBack;
	}
	public void displaydata(int id)
	{
		
		Studentinterface ss = new Studentservicesimpl();
		Student s = ss.getbyid(id);
		namtxt.setText(s.getUsername());
		addtxt.setText(s.getAddress());
		factxt.setText(s.getFaculty());
		phntxt.setText(s.getPhone());
		
	}
	
}
