package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.List;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import entity.Reader;
import factory.factory;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class findReader extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	JFrame zj = this;
	JFrame JF;
	Reader reader;
	public findReader(Reader reader,JFrame jf) {
		JF = jf;
		this.reader = reader;
		getContentPane().setLayout(null);
		setSize(500, 300);
		setResizable(false);
		setLocationRelativeTo(JF);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				zj.dispose();
				JF.setVisible(true);
			}
		});
		JLabel lblid = new JLabel("\u7528\u6237id");
		lblid.setBounds(40, 10, 54, 15);
		getContentPane().add(lblid);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(104, 7, 148, 21);
		textField.setText(""+reader.getRid());
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setBounds(40, 35, 54, 15);
		getContentPane().add(label);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(104, 32, 148, 21);
		textField_1.setText(""+reader.getAccounts());
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u5BC6\u7801");
		label_1.setBounds(40, 60, 54, 15);
		getContentPane().add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(104, 57, 148, 21);
		textField_2.setText(""+reader.getPwd());
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_2 = new JLabel("\u771F\u5B9E\u59D3\u540D");
		label_2.setBounds(40, 85, 54, 15);
		getContentPane().add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(104, 82, 148, 21);
		textField_3.setText(""+reader.getName());
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_3 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		label_3.setBounds(40, 110, 54, 15);
		getContentPane().add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(104, 107, 148, 21);
		textField_4.setText(""+reader.getIDcard());
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_4 = new JLabel("\u5BC6\u4FDD\u95EE\u9898");
		label_4.setBounds(40, 135, 54, 15);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u95EE\u9898\u7B54\u6848");
		label_5.setBounds(40, 160, 54, 15);
		getContentPane().add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(104, 132, 148, 21);
		textField_5.setText(""+reader.getQuestion());
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(104, 157, 148, 21);
		textField_6.setText(""+reader.getAnswer());
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JLabel label_6 = new JLabel("\u6CE8\u610F\u4E8B\u9879\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 18));
		label_6.setForeground(Color.RED);
		label_6.setBounds(279, 10, 90, 18);
		getContentPane().add(label_6);
		
		JLabel lblnbsp = new JLabel("<html>\r\n\t<body>\r\n\t\t1\u3001\u4FEE\u6539\u540E\u8BF7\u4ED4\u7EC6\u68C0\u67E5\uFF0C\u5185\u5BB9\u4E00\u7ECF\u4FEE\u6539\uFF0C\u5C06\u8981\u518D\u6B21\u9A8C\u8BC1\u5BC6\u4FDD\u95EE\u9898\u3002<br>\r\n\t\t2\u3001\u8BF7\u7262\u8BB0\u81EA\u5DF1\u7684\u5BC6\u7801\uFF0C\u4EE5\u9632\u518D\u6B21\u4E22\u5931\u3002\r\n\t</body>\r\n</html>");
		lblnbsp.setHorizontalAlignment(SwingConstants.LEFT);
		lblnbsp.setToolTipText("\u6CE8\u610F\u4E8B\u9879");
		lblnbsp.setVerticalAlignment(SwingConstants.TOP);
		lblnbsp.setBounds(279, 35, 192, 140);
		getContentPane().add(lblnbsp);
		
		JButton button = new JButton("\u786E\u8BA4\u63D0\u4EA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector<Object> v = new Vector<Object>();
				v.add(textField.getText());
				v.add(textField_1.getText());
				v.add(textField_2.getText());
				v.add(textField_3.getText());
				v.add(textField_4.getText());
				v.add(textField_5.getText());
				v.add(textField_6.getText());
				factory f = new factory();
				if (f.getReaderActionImpl().changeReader(v)) {
					JOptionPane.showMessageDialog(zj, "修改成功");
					JF.setVisible(true);
					zj.dispose();
				}else {
					JOptionPane.showMessageDialog(zj, "修改失败");
				}
			}
		});
		button.setBounds(40, 205, 93, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
			}
		});
		button_1.setBounds(159, 205, 93, 23);
		getContentPane().add(button_1);
		setVisible(true);
	}
}
