package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import entity.Book;
import entity.bookKinds;
import factory.factory;
import javax.swing.JTextField;

import com.sun.java.swing.plaf.windows.resources.windows;

import javax.swing.JComboBox;import java.awt.Button;
import java.awt.Label;

public class addBook extends JFrame implements ActionListener{
	private factory f = new factory();
	private Book b = f.getBook();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JButton button;
	JButton button_1;
	JComboBox comboBox;
	JFrame localJF;
	JFrame zj;
	serviceUI sui = new serviceUI();
	Vector<Object> v = new Vector<Object>();
	public Vector<Object> init(JFrame jf){
		localJF = jf;
		zj = this;
		ArrayList<bookKinds> al = f.getBookBizImpl().bookKinds();
		Vector<Object> bk = new Vector<Object>();
		getContentPane().setLayout(null);
		setSize(500, 300);
		setResizable(false);
		setLocationRelativeTo(jf);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				zj.dispose();
				localJF.setVisible(true);
			}
		});
		for (int i = 0; i < al.size(); i++) {
			bk.add(al.get(i).getBookKindsName());
		}
		
		
		JLabel label = new JLabel("\u4E66\u7C4D\u540D\u79F0");
		label.setBounds(10, 10, 54, 15);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(68, 7, 108, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u4E66\u7C4D\u7C7B\u522B");
		label_1.setBounds(10, 35, 54, 15);
		getContentPane().add(label_1);
		
		comboBox = new JComboBox(bk);
		comboBox.setBounds(68, 32, 108, 21);
		getContentPane().add(comboBox);
		
		JLabel label_2 = new JLabel("\u51FA\u7248\u793E");
		label_2.setBounds(10, 60, 46, 15);
		getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(68, 57, 108, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("\u4F5C\u8005");
		label_3.setBounds(10, 85, 54, 15);
		getContentPane().add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(68, 82, 108, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_4 = new JLabel("\u4E66\u7C4D\u4EF7\u503C");
		label_4.setBounds(10, 110, 54, 15);
		getContentPane().add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(68, 107, 108, 21);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		button = new JButton("\u786E\u8BA4");
		button.setBounds(20, 135, 69, 23);
		button.addActionListener(this);
		getContentPane().add(button);
		
		button_1 = new JButton("\u91CD\u7F6E");
		button_1.setBounds(101, 135, 75, 23);
		button_1.addActionListener(this);
		getContentPane().add(button_1);
		
		Label label_5 = new Label("\u4E66\u7C4D\u5F55\u5165\u6CE8\u610F\u4E8B\u9879\uFF1A\r\n");
		label_5.setBounds(206, 7, 109, 18);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("1\u3001\u6240\u6709\u9879\u76EE\u6700\u597D\u90FD\u4E0D\u8981\u4E3A\u7A7A");
		label_6.setBounds(207, 30, 170, 16);
		getContentPane().add(label_6);
		
		JLabel lblNewLabel = new JLabel("2\u3001\u5F55\u5165\u4FE1\u606F\u65F6\u8BF7\u4ED4\u7EC6\u8BA4\u771F");
		lblNewLabel.setBounds(206, 55, 157, 15);
		getContentPane().add(lblNewLabel);
		
		setVisible(true);
		
		return v;
	}
	public void actionPerformed(ActionEvent e) {
		Object a = e.getSource();
		if (a.equals(button)) {
			v.add(textField.getText());
			v.add(comboBox.getSelectedIndex());
			v.add(textField_1.getText());
			v.add(textField_2.getText());
			v.add(textField_3.getText());
			switch (sui.addBook(v)) {
			case 1:
				JOptionPane.showMessageDialog(this, "录入成功");
				this.dispose();
				localJF.setVisible(true);
				break;

			default:
				JOptionPane.showMessageDialog(this, "录入失败");
				break;
			}
		}
	}
}
