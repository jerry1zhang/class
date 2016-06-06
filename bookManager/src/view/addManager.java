package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import factory.factory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class addManager extends JFrame {
	private factory f = new factory();
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JFrame JF;
	private JFrame ZJ;
	JComboBox comboBox = new JComboBox();

	/**
	 * Create the frame.
	 */
	public addManager(final JFrame JF) {
		this.JF = JF;
		ZJ = this;
		setTitle("\u65B0\u589E\u5458\u5DE5");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(300, 220);
		setResizable(false);
		setLocationRelativeTo(JF);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ZJ.dispose();
				JF.setVisible(true);
			}
		});
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("\u5458\u5DE5\u8D26\u53F7");
		label_1.setBounds(60, 44, 54, 15);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(124, 41, 107, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5458\u5DE5\u5BC6\u7801");
		label_2.setBounds(60, 69, 54, 15);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(124, 66, 107, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5458\u5DE5\u6743\u9650");
		label_3.setBounds(60, 94, 54, 15);
		contentPane.add(label_3);
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u5458\u5DE5\u6743\u9650", "\u6700\u9AD8\u6743\u9650"}));
		comboBox.setBounds(124, 91, 107, 21);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector<Object> v = new Vector<Object>();
				v.add(textField_1.getText());
				v.add(textField_2.getText());
				v.add(comboBox.getSelectedIndex()+1);
				if (f.getManagerActionImpl().addManager(v)) {
					JOptionPane.showMessageDialog(null, "提交成功");
					ZJ.dispose();
					JF.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "提交失败");
				}
			}
		});
		btnNewButton.setBounds(60, 132, 79, 23);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\u91CD\u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				textField_2.setText("");
				comboBox.setSelectedIndex(0);
			}
		});
		button.setBounds(149, 132, 82, 23);
		contentPane.add(button);
		
		JLabel label = new JLabel("\u65B0\u589E\u5458\u5DE5");
		label.setForeground(Color.RED);
		label.setFont(new Font("宋体", Font.PLAIN, 17));
		label.setBounds(114, 10, 79, 21);
		contentPane.add(label);
		this.setVisible(true);
	}
}
