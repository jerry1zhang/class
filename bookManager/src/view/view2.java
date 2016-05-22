package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;

public class view2 extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view2 frame = new view2();
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
	public view2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel main = new JPanel();
		main.setBounds(0, 0, 894, 498);
		contentPane.add(main);
		main.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5C0A\u656C\u7684\u7528\u6237\u6B22\u8FCE\u60A8\u9996\u6B21\u6765\u5230\u672C\u56FE\u4E66\u9986");
		lblNewLabel.setBounds(27, 25, 456, 44);
		main.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u672C\u56FE\u4E66\u9986\u85CF\u4E66\u8D85\u8FC7300\u4E07\u518C\uFF0C\u662F\u6E56\u5357\u7701\u4E43\u81F3\u4E8E\u5168\u56FD\u90FD\u662F\u6570\u4E00\u6570\u4E8C\u7684\u56FE\u4E66\u9986");
		lblNewLabel_1.setBounds(27, 79, 456, 44);
		main.add(lblNewLabel_1);
		
		JLabel label = new JLabel("\u76F8\u4FE1\u60A8\u4E00\u5B9A\u80FD\u5728\u8FD9\u91CC\u627E\u5230\u60A8\u559C\u7231\u6216\u60F3\u8981\u7684\u4E66\u7C4D");
		label.setBounds(27, 133, 456, 44);
		main.add(label);
		
		JLabel label_1 = new JLabel("\u63D0\u4EA4\u4FE1\u606F\u524D\u8BF7\u4ED4\u7EC6\u6821\u5BF9\u4FE1\u606F\uFF0C\u6CE8\u518C\u540E\u5C06\u4E0D\u80FD\u66F4\u6539\u60A8\u7684\u4FE1\u606F\u4E86\uFF01");
		label_1.setBounds(27, 187, 456, 44);
		main.add(label_1);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.setBounds(27, 282, 93, 23);
		main.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u767B\u9646");
		btnNewButton_1.setForeground(Color.YELLOW);
		btnNewButton_1.setBounds(116, 282, 93, 23);
		main.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 894, 498);
		contentPane.add(panel);
	}
	public JPanel getContentPane() {
		return contentPane;
	}

	public void actionPerformed(ActionEvent e) {
		Object a = e.getSource();
		if (e.) {
			
		}
	}
}
