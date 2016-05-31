package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import entity.bookKinds;
import factory.factory;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;

public class changeBook extends JFrame implements ActionListener{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JFrame localjf;
	private JFrame zj;
	private JComboBox comboBox;
	private JButton button;
	private JButton button_1;
	private factory f = new factory();
	private serviceUI sui = new serviceUI();
	Vector<Object> data;
	public changeBook(JFrame jf,Vector<Object> book) {
		data = book;
		localjf = jf;
		zj = this;
		ArrayList<bookKinds> al = f.getBookBizImpl().bookKinds();
		Vector<Object> bk = new Vector<Object>();
		for (int i = 0; i < al.size(); i++) {
			bk.add(al.get(i).getBookKindsName());
		}
		setTitle("\u4E66\u7C4D\u4FEE\u6539\u754C\u9762");
		getContentPane().setBackground(new Color(240, 240, 240));
		getContentPane().setLayout(null);
		setResizable(false);
		setSize(260, 250);
		setLocationRelativeTo(jf);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		JLabel label = new JLabel("\u4E66\u7C4D\u540D\u79F0");
		label.setBounds(30, 22, 54, 15);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(94, 19, 142, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u4E66\u7C4D\u7C7B\u578B");
		label_1.setBounds(30, 46, 54, 15);
		getContentPane().add(label_1);
		
		comboBox = new JComboBox(bk);
		comboBox.setBounds(94, 43, 142, 21);
		getContentPane().add(comboBox);
		
		JLabel label_2 = new JLabel("\u51FA\u7248\u793E");
		label_2.setBounds(30, 71, 54, 15);
		getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 68, 142, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("\u4F5C\u8005");
		label_3.setBounds(30, 96, 54, 15);
		getContentPane().add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(94, 93, 142, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_4 = new JLabel("\u4E66\u7C4D\u4EF7\u683C");
		label_4.setBounds(30, 124, 54, 15);
		getContentPane().add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(94, 121, 142, 21);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		button = new JButton("\u63D0\u4EA4\u4FEE\u6539");
		button.setBounds(30, 152, 93, 23);
		button.addActionListener(this);
		getContentPane().add(button);
		
		button_1 = new JButton("\u91CD\u7F6E");
		button_1.setBounds(143, 152, 93, 23);
		getContentPane().add(button_1);
		
		textField.setText(book.get(1).toString());
		comboBox.setSelectedItem(book.get(6).toString());
		for (int i = 0; i < al.size(); i++) {
			if (book.get(6).toString().equals(bk.get(i).toString())) {
				comboBox.setSelectedIndex(i);;
			}
		}
		textField_1.setText(book.get(3).toString());
		textField_2.setText(book.get(4).toString());
		textField_3.setText(book.get(5).toString());
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		Object a = e.getSource();
		if (a.equals(button)) {
			Vector<Object> v = new Vector<Object>();
			v.add(data.get(0));
			v.add(textField.getText());
			v.add(comboBox.getSelectedIndex());
			v.add(textField_1.getText());
			v.add(textField_2.getText());
			v.add(textField_3.getText());
			switch (sui.changeBook(v)) {
			case 1:
				JOptionPane.showMessageDialog(this, "修改成功");
				zj.dispose();
				localjf.setVisible(true);
				break;

			default:
				JOptionPane.showMessageDialog(this, "修改失败");
				break;
			}
		}
	}

}
