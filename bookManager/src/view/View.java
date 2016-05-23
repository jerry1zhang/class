package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import entity.Book;
import factory.factory;


public class View extends JFrame implements ActionListener,KeyListener,MouseListener,FocusListener{
	private factory factory = new factory();
	//ȫ�ֱ���
	private String uname = "jerry";
	private String[] error = new String[5];
	private int power = -1;
	Vector<Vector<Object>> DataBook;
	ArrayList<Book> bList;
	Vector<String> columnNames;
	String time;
	TableModel tm;
	JScrollPane JSP1;
	//�ж�
	private JLabel judgment1 = new JLabel();
	private JLabel judgment2 = new JLabel();
	private JLabel judgment3 = new JLabel();
	private JLabel judgment4 = new JLabel();
	private JLabel judgment5 = new JLabel();
	private JLabel judgment6 = new JLabel();
	private JLabel judgment7 = new JLabel();
	//��������
	//ÿ�����ĵ����趨
	private int panelX = 0;
	private int panelY = 20;
	private int panelW = 1200;
	private int panelH = 600;
	//�������
	//JLabel
	private JLabel jl;
	private JLabel jltime = new JLabel();
	//JTextField
	private JTextField jtfLoginName = new JTextField();
	private JTextField jtfRegisterName = new JTextField();
	private JTextField jtfRegisterQuestion = new JTextField();
	private JTextField jtfRegisterAnswer = new JTextField();
	private JTextField jtfNoPwdName = new JTextField();
	private JTextField jtfNoPwdQuestion = new JTextField();
	private JTextField jtfNoPwdAnswer = new JTextField();
	//JPasswordField
	private JPasswordField jpfLoginPwd = new JPasswordField();
	private JPasswordField jpfRegisterPwd1 = new JPasswordField();
	private JPasswordField jpfRegisterPwd2 = new JPasswordField();
	//JTable
	private JTable jtRootBook;
	private JTable jtReaderBook;
	//JPanel
	private JPanel main = new JPanel();
	private JPanel Login = new JPanel();
	private JPanel Register = new JPanel();
	private JPanel NoPwd = new JPanel();
	private JPanel Root = new JPanel();
		private JPanel RootReader = new JPanel();
		private JPanel RootManager = new JPanel();
		private JPanel RootBook = new JPanel();
	private JPanel Reader = new JPanel();
		private JPanel ReaderLib = new JPanel();
		private JPanel ReaderMessage = new JPanel();
	//JButton
	private JButton bTest = new JButton("test");
	private JButton bRegister = new JButton("ע��");
	private JButton bLogin = new JButton("��½");
	private JButton bNoPwd = new JButton("��������");
	private JButton bLoginLogin = new JButton("��½");
	private JButton bLoginBack = new JButton("����");
	private JButton bRegisterRegister = new JButton("ע��");
	private JButton bRegisterBack = new JButton("����");
	private JButton bNoPwdFind = new JButton("�һ�");
	private JButton bNoPwdBack = new JButton("����");
	private JButton bRootReader = new JButton("���߹���");
	private JButton bRootManager = new JButton("����Ա����");
	private JButton bRootBook = new JButton("�鼮����");
//	private JButton bRootBookCreate = new JButton("�鼮��¼����");
//	private JButton bRootBookSelect = new JButton("�鼮��¼��ѯ");
//	private JButton bRootBookDelect = new JButton("�鼮��¼ɾ��");
//	private JButton bRootBookUpdate = new JButton("�鼮��¼�޸�");
	private JButton bRootBookSelectName = new JButton("�鼮���Ʋ�ѯ");
	private JButton bRootBookSelectNo = new JButton("�鼮��Ų�ѯ");
	private JButton bRootBookSelectAuthor = new JButton("�鼮���߲�ѯ");
	private JButton bRootBookSelectPress = new JButton("�鼮�������ѯ");
	private JButton bRootBookSelectKinds = new JButton("�鼮���Ͳ�ѯ");
	private JButton bRootReaderCreate = new JButton("���߼�¼����");
	private JButton bRootReaderSelect = new JButton("���߼�¼��ѯ");
	private JButton bRootReaderDelect = new JButton("���߼�¼ɾ��");
	private JButton bRootReaderUpdate = new JButton("���߼�¼�޸�");
	private JButton bRootManagerCreate = new JButton("����Ա��¼����");
	private JButton bRootManagerSelect = new JButton("����Ա��¼��ѯ");
	private JButton bRootManagerDelect = new JButton("����Ա��¼ɾ��");
	private JButton bRootManagerUpdate = new JButton("����Ա��¼�޸�");
	private JButton bReaderLib = new JButton("�鼮����");
	private JButton bReaderMessage = new JButton("�û���Ϣ����");
	private JButton bReaderLibSelectName = new JButton("ͨ��������ѯ");
	private JButton bReaderLibSelectKinds = new JButton("ͨ���鼮���Ͳ�ѯ");
	private JButton bReaderLibLib = new JButton("����ѡ�е��鼮");
	private TimerTask tt = new TimerTask() {
		
		
		
		@Override
		public void run() {
			java.util.Date date1 = new java.util.Date();
			Date date=new Date(date1.getTime());
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			time=format.format(date);
			jltime.setText(time);
		}
	};
	private Timer timer = new Timer();
	
	public void init(){
		this.setTitle("ͼ��ݹ���ϵͳ");
		this.setBounds(10, 10, 1200, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		
		join_main();
		join_Login();
		join_Register();
		join_NoPwd();
		join_root();
		join_reader();
		
		
		timer.schedule(tt, 0, 1000);
		jltime.setBounds(0, 0, 200, 30);
		add(jltime);
		this.setVisible(true);
	}
	// ������
	private void join_main(){
		int x = 200;
		int y = 10;
		int width = 900;
		int height = 30;
		main.add(addJLabel("��ӭ����ͼ��ݹ���ϵͳ��", x, y, width, height));
		main.add(addJLabel("��ͼ��ݹ���", x, y=y+30, width, height));
		main.add(addJLabel("1�����û�����ע���˺š�", x,y=y+30 , width, height));
		main.add(addJLabel("2�������˺ŵ��û���ֱ�ӵ����¼��ť��", x,y=y+30 , width, height));
		main.add(addJLabel("3������������û���ѡ���������루��ע��ʱ��¼���ܱ��������һ����룩��", x,y=y+30 , width, height));
		main.add(addJLabel("4��ÿλ�û�һ��ֻ�ܽ����屾�飬�ܹ�ֻ�ܽ���15���顣", x,y=y+30 , width, height));
		main.add(addJLabel("5������ʱ�䳬��60�죬����������ÿ��0.1Ԫ������á�", x,y=y+30 , width, height));
		main.add(addJLabel("6����ʧͼ�鰴�г���15���⳥�������鰴�����������á�", x,y=y+30 , width, height));
		bRegister.setBounds(400, 400, 100, 30);
		bRegister.addActionListener(this);
		bLogin.setBounds(500, 400, 100, 30);
		bLogin.addActionListener(this);
		bNoPwd.setBounds(600, 400, 100, 30);
		bNoPwd.addActionListener(this);
		bTest.setBounds(700, 400, 100, 30);
		bTest.addActionListener(this);
		main.add(bTest);
		main.add(bNoPwd);
		main.add(bRegister);
		main.add(bLogin);
		main.setLayout(null);
		main.setBounds(panelX, panelY, panelW, panelH);
		this.add(main);
	}
	//��½
	private void join_Login(){
		int x = 300;
		int y = 60;
		int width = 900;
		int height = 30;
		Login.setLayout(null);
		Login.setBounds(panelX, panelY, panelW, panelH);
		
		Login.add(addJLabel("�𾴵��û�����ӭ��������ͼ��ݣ�",x,y,width,height));
		Login.add(addJLabel("�밴��ʾ����������Ϣ��",x,y = y+height,width,height));
		Login.add(addJLabel("�û�����",x,y = y+height,100,height));
		jtfLoginName.setBounds(x+100, y, 200, height);
		Login.add(jtfLoginName);
		//�ж�1
		judgment1.setBounds(x+300, y, 200, height);
		Login.add(judgment1);
		Login.add(addJLabel("����:",x,y = y+height,width,height));
		jpfLoginPwd.setBounds(x+100, y, 200, height);
		Login.add(jpfLoginPwd);
		//�ж�2
		judgment2.setBounds(x+300, y, 200, height);
		Login.add(judgment2);
		bLoginLogin.setBounds(x, y = y+height, 100, height);
		bLoginLogin.addActionListener(this);
		Login.add(bLoginLogin);
		bLoginBack.setBounds(x+100, y, 100, height);
		bLoginBack.addActionListener(this);
		Login.add(bLoginBack);
		
		Login.setVisible(false);
		this.add(Login);
	}
	//ע��
	private void join_Register(){
		int x = 300;
		int y = 60;
		int width = 900;
		int height = 30;
		Register.setLayout(null);
		Register.setBounds(panelX, panelY, panelW, panelH);
		
		Register.add(addJLabel("�𾴵��û���ӭ���״�������ͼ���", x, y, width, height));
		Register.add(addJLabel("��ͼ��ݲ��鳬��300��ᣬ�Ǻ���ʡ������ȫ��������һ������ͼ���", x, y = y+height, width, height));
		Register.add(addJLabel("������һ�����������ҵ���ϲ������Ҫ���鼮", x, y = y+height, width, height));
		Register.add(addJLabel("�ύ��Ϣǰ����ϸУ����Ϣ��ע��󽫲��ܸ���������Ϣ�ˣ�", x, y = y+height, width, height));
		Register.add(addJLabel("�û�����", x, y = y+height, 100, height));
		jtfRegisterName.setBounds(x+100, y, 200, height);
		jtfRegisterName.addFocusListener(this);
		Register.add(jtfRegisterName);
		//�ж�3
		judgment3.setBounds(x+300, y, 200, height);
		Register.add(judgment3);
		Register.add(addJLabel("���룺", x, y = y+height, 100, height));
		jpfRegisterPwd1.setBounds(x+100, y, 200, height);
		jpfRegisterPwd1.addFocusListener(this);
		Register.add(jpfRegisterPwd1);
		//�ж�4
		judgment4.setBounds(x+300, y, 200, height);
		Register.add(judgment4);
		Register.add(addJLabel("�����������룺", x, y = y+height, 100, height));
		jpfRegisterPwd2.setBounds(x+100, y, 200, height);
		jpfRegisterPwd2.addFocusListener(this);
		Register.add(jpfRegisterPwd2);
		//�ж�5
		judgment5.setBounds(x+300, y, 200, height);
		Register.add(judgment5);
		Register.add(addJLabel("��֤���⣺", x, y = y+height, 100, height));
		jtfRegisterQuestion.setBounds(x+100, y, 200, height);
		jtfRegisterQuestion.addFocusListener(this);
		Register.add(jtfRegisterQuestion);
		//�ж�6
		judgment6.setBounds(x+300, y, 200, height);
		Register.add(judgment6);
		Register.add(addJLabel("��֤����𰸣�", x, y = y+height, 100, height));
		jtfRegisterAnswer.setBounds(x+100, y, 200, height);
		jtfRegisterAnswer.addFocusListener(this);
		Register.add(jtfRegisterAnswer);
		//�ж�7
		judgment7.setBounds(x+300, y, 200, height);
		Register.add(judgment7);
		bRegisterRegister.setBounds(x, y = y+height, 100, height);
		bRegisterRegister.addActionListener(this);
		bRegisterBack.setBounds(x+100, y, 100, height);
		bRegisterBack.addActionListener(this);
		Register.add(bRegisterRegister);
		Register.add(bRegisterBack);
		
		
		Register.setVisible(false);
		this.add(Register);
		
	}
	//��������
	private void join_NoPwd(){
		int x = 300;
		int y = 60;
		int width = 200;
		int height = 30;
		NoPwd.setLayout(null);
		NoPwd.setBounds(panelX, panelY, panelW, panelH);
		
		NoPwd.add(addJLabel("ʹ��ע��ʱʹ�õ���֤�������һ�����", x, y, 600, height));
		NoPwd.add(addJLabel("�û�����", x, y=y+height, width, height));
		jtfNoPwdName.setBounds(x+width, y, width, height);
		NoPwd.add(jtfNoPwdName);
		NoPwd.add(addJLabel("��֤���⣺", x, y=y+height, width, height));
		jtfNoPwdQuestion.setBounds(x+width, y, width, height);
		NoPwd.add(jtfNoPwdQuestion);
		NoPwd.add(addJLabel("��֤����𰸣�", x, y=y+height, width, height));
		jtfNoPwdAnswer.setBounds(x+width, y, width, height);
		NoPwd.add(jtfNoPwdAnswer);
		bNoPwdFind.setBounds(x, y=y+height, 100, height);
		bNoPwdFind.addActionListener(this);
		NoPwd.add(bNoPwdFind);
		bNoPwdBack.setBounds(x+100, y, 100, height);
		bNoPwdBack.addActionListener(this);
		NoPwd.add(bNoPwdBack);
		
		NoPwd.setVisible(false);
		this.add(NoPwd);
	}
	//root����
	private void join_root(){
		int x = 10;
		int y = 10;
		int width = 200;
		int height = 30;
		Root.setLayout(null);
		Root.setBounds(panelX, panelY, panelW, panelH);
		
		Root.add(addJLabel("�𾴵�", x, y, width-100, height));
		Root.add(addJLabel("����ӭ����root�������", x+90, y, width+100, height));
		Root.add(addJLabel("��������ӵ�����Ȩ��", x, y=y+height, width, height));
		Root.add(addJLabel("�ܹ�����������£�", x, y=y+height, width, height));
		bRootManager.setBounds(x, y=y+height, 100, height);
		bRootReader.setBounds(x, y=y+height, 100, height);
		bRootBook.setBounds(x, y=y+height, 100, height);
		bRootBook.addActionListener(this);
		bRootManager.addActionListener(this);
		bRootReader.addActionListener(this);
		Root.add(bRootBook);
		Root.add(bRootManager);
		Root.add(bRootReader);
		
		join_root_book();
		join_root_manager();
		join_root_reader();
		
		Root.setVisible(false);
		this.add(Root);
	}
	//manager����
	private void join_manager(){}
	//reader����
	private void join_reader(){
		int x = 10;
		int y = 10;
		int width = 150;
		int height = 30;
		Reader.setBounds(panelX, panelY, panelW, panelH);
		Reader.setLayout(null);
		
		Reader.add(addJLabel("�𾴵�", x, y, width, height));
		Reader.add(addJLabel("��ӭ������ͼ���", x+150, y, width+50, height));
		bReaderLib.setBounds(x, y=y+30, width, height);
		bReaderLib.addActionListener(this);
		Reader.add(bReaderLib);
		bReaderMessage.setBounds(x, y=y+30, width, height);
		bReaderMessage.addActionListener(this);
		Reader.add(bReaderMessage);
		
		join_reader_lib();
		
		Reader.setVisible(false);
		add(Reader);
	}
	//book����
	private void join_root_book(){
		int x = 10;
		int y = 10;
		int width = 200;
		int height = 30;
		RootBook.setLayout(null);
//		RootBook.setBounds(panelX+100, panelY+150, panelW-400, panelH-100);
		RootBook.setBounds(panelX+150, panelY, panelW-200, panelH-100);
		
//		bRootBookCreate.setBounds(x, y, width-50, height);
//		bRootBookCreate.addActionListener(this);
//		RootBook.add(bRootBookCreate);
//		bRootBookDelect.setBounds(x, y=y+30, width-50, height);
//		bRootBookDelect.addActionListener(this);
//		RootBook.add(bRootBookDelect);
//		bRootBookUpdate.setBounds(x, y=y+30, width-50, height);
//		bRootBookUpdate.addActionListener(this);
//		RootBook.add(bRootBookUpdate);
//		bRootBookSelect.setBounds(x, y=y+30, width-50, height);
//		bRootBookSelect.addActionListener(this);
//		RootBook.add(bRootBookSelect);
		
		addBookTable();
		jtRootBook = new mytable(DataBook, columnNames);
		jtRootBook.setBounds(x, y, 800, 400);
		jtRootBook.getTableHeader().setReorderingAllowed(false);
		jtRootBook.getTableHeader().setResizingAllowed(false); 
		JScrollPane JSP= new JScrollPane(jtRootBook);
		JSP.setBounds(x, y=y+30, 800, 400);
		RootBook.add(JSP);
		
		
		
		bRootBookSelectName.setBounds(x+800, y, width-50, height);
		bRootBookSelectName.addActionListener(this);
		RootBook.add(bRootBookSelectName);
		bRootBookSelectNo.setBounds(x+800, y=y+30, width-50, height);
		bRootBookSelectNo.addActionListener(this);
		RootBook.add(bRootBookSelectNo);
		bRootBookSelectAuthor.setBounds(x+800, y=y+30, width-50, height);
		bRootBookSelectAuthor.addActionListener(this);
		RootBook.add(bRootBookSelectAuthor);
		bRootBookSelectPress.setBounds(x+800, y=y+30, width-50, height);
		bRootBookSelectPress.addActionListener(this);
		RootBook.add(bRootBookSelectPress);
		bRootBookSelectKinds.setBounds(x+800, y=y+30, width-50, height);
		bRootBookSelectKinds.addActionListener(this);
		RootBook.add(bRootBookSelectKinds);
		
		
		RootBook.setVisible(false);
		Root.add(RootBook);
	}
	//reader����
	private void join_root_reader(){
		int x = 10;
		int y = 10;
		int width = 200;
		int height = 30;
		RootReader.setLayout(null);
		RootReader.setBounds(panelX+100, panelY+120, panelW-400, panelH-100);
		
		bRootReaderCreate.setBounds(x, y, width-50, height);
		bRootReaderCreate.addActionListener(this);
		RootReader.add(bRootReaderCreate);
		bRootReaderDelect.setBounds(x, y=y+30, width-50, height);
		bRootReaderDelect.addActionListener(this);
		RootReader.add(bRootReaderDelect);
		bRootReaderUpdate.setBounds(x, y=y+30, width-50, height);
		bRootReaderUpdate.addActionListener(this);
		RootReader.add(bRootReaderUpdate);
		bRootReaderSelect.setBounds(x, y=y+30, width-50, height);
		bRootReaderSelect.addActionListener(this);
		RootReader.add(bRootReaderSelect);
		
		RootReader.setVisible(false);
		Root.add(RootReader);
	}
	//manager����
	private void join_root_manager(){
		int x = 10;
		int y = 10;
		int width = 200;
		int height = 30;
		RootManager.setLayout(null);
		RootManager.setBounds(panelX+100, panelY+90, panelW-400, panelH-100);
		
		bRootManagerCreate.setBounds(x, y, width-50, height);
		bRootManagerCreate.addActionListener(this);
		RootManager.add(bRootManagerCreate);
		bRootManagerDelect.setBounds(x, y=y+30, width-50, height);
		bRootManagerDelect.addActionListener(this);
		RootManager.add(bRootManagerDelect);
		bRootManagerUpdate.setBounds(x, y=y+30, width-50, height);
		bRootManagerUpdate.addActionListener(this);
		RootManager.add(bRootManagerUpdate);
		bRootManagerSelect.setBounds(x, y=y+30, width-50, height);
		bRootManagerSelect.addActionListener(this);
		RootManager.add(bRootManagerSelect);
		
		RootManager.setVisible(false);
		Root.add(RootManager);
	}
	//ͼ�����Ԥ��
	private void join_reader_lib(){
		int x = 10;
		int y = 10;
		int width = 150;
		int height = 30;
		ReaderLib.setLayout(null);
		ReaderLib.setBounds(panelX+150, panelY+30, panelW-200, panelH-100);
		
		ReaderLib.add(addJLabel("ע���ϵͳֻ�ṩͼ�����Ԥ���������û���ͼ����Լ���ȡ", x, y=y+30, width+400, height, Color.red));
		addBookTable();
		tm = new DefaultTableModel(DataBook, columnNames);
		tm.addTableModelListener(new TableModelListener() {
			
			public void tableChanged(TableModelEvent e) {
//				jtReaderBook = new mytable(tm);
//				jtReaderBook.repaint(10, 10, 800, 400);
//				jtReaderBook.updateUI();
//				jtReaderBook.validate();
				tm = new DefaultTableModel(DataBook, columnNames);
				jtReaderBook.setModel(tm);
//				jtReaderBook.repaint();
				jtReaderBook.updateUI();
			}
		});
		jtReaderBook = new mytable(tm);
		jtReaderBook.setBounds(x, y, 800, 400);
		jtReaderBook.getTableHeader().setReorderingAllowed(false);
		jtReaderBook.addMouseListener(this);
		JSP1= new JScrollPane(jtReaderBook);
		JSP1.setBounds(x, y=y+30, 800, 400);
		ReaderLib.add(JSP1);
		bReaderLibSelectName.setBounds(x=x+800, y, width, height);
		bReaderLibSelectKinds.setBounds(x, y=y+30, width, height);
		bReaderLibLib.setBounds(x, y+100, width, height);
		bReaderLibSelectName.addActionListener(this);
		bReaderLibSelectKinds.addActionListener(this);
		bReaderLibLib.addActionListener(this);
		ReaderLib.add(bReaderLibSelectName);
		ReaderLib.add(bReaderLibSelectKinds);
		ReaderLib.add(bReaderLibLib);
		
		
		ReaderLib.setVisible(false);
		Reader.add(ReaderLib);
	}
	//�û���Ϣ����
	private void join_reader_message(){}
	//ͼ����Ĺ���Աȷ������
	//rootͼ�����
		//ͼ���¼����
	private void join_root_book_create(){
		
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		Object a =  e.getSource();
		if (a.equals(bTest)) {
			main.setVisible(false);
			Reader.setVisible(true);
		}else if(a.equals(bRegister)){
			main.setVisible(false);
			Register.setVisible(true);
		}else if (a.equals(bLogin)) {
			main.setVisible(false);
			Login.setVisible(true);
		}else if (a.equals(bNoPwd)) {
			main.setVisible(false);
			NoPwd.setVisible(true);
		}else if (a.equals(bLoginLogin)) {
			String name = uname;
			name = jtfLoginName.getText();
			String pwd =  new String(jpfLoginPwd.getPassword());
			int n = 0;
			n = factory.getReaderActionImpl().Login(name, pwd);
			power = n;
			switch (n) {
			case 0:
			case 1:
			case 2:
				JOptionPane.showMessageDialog(this, "��½�ɹ�");
				break;
			default:
				JOptionPane.showMessageDialog(this, "�û������������");
				break;
			}
			if (n==0) {
				uname = name;
				Reader.add(addJLabel(uname, 100, 10, 200, 30));
				Login.setVisible(false);
				Reader.setVisible(true);
			}else if (n==1) {
				
			}else if (n==2) {
				uname = name;
				Root.add(addJLabel(uname, 50, 10, 200, 30));
				Login.setVisible(false);
				Root.setVisible(true);
			}
		}else if (a.equals(bLoginBack)) {
			Login.setVisible(false);
			main.setVisible(true);
		}else if (a.equals(bRegisterRegister)) {
			String name = jtfRegisterName.getText();
			String pwd = new String(jpfRegisterPwd1.getPassword());
			String Question = jtfRegisterQuestion.getText();
			String Answer = jtfRegisterAnswer.getText();
			java.util.Date date1 = new java.util.Date();
			Date date=new Date(date1.getTime());
//			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			String time=format.format(date);
			String er = "";
			int r = 0;
			for (int i = 0; i < error.length; i++) {
				if (!error[i].equals("")) {
					er = er+error[i]+"\n";
				}
			}
			if (er.equals("")) {
				r = factory.getReaderActionImpl().Register(name, pwd, Question, Answer,date);
				switch (r) {
				case 1:
					JOptionPane.showMessageDialog(this, "ע��ɹ�");
					break;
				case 2:
					JOptionPane.showMessageDialog(this, "�û����ظ�");
					break;
				default:
					JOptionPane.showMessageDialog(this, "δ֪ԭ���µĴ�����鿴�����Ƿ�����");
					break;
				}
			}else {
				JOptionPane.showMessageDialog(this, er);
			}
		}else if (a.equals(bRegisterBack)) {
			Register.setVisible(false);
			main.setVisible(true);
		}else if (a.equals(bNoPwdFind)) {
			
		}else if (a.equals(bNoPwdBack)) {
			NoPwd.setVisible(false);
			main.setVisible(true);
		}else if (a.equals(bRootBook)) {
			
			RootBook.setVisible(true);
			RootManager.setVisible(false);
			RootReader.setVisible(false);
		}else if (a.equals(bRootManager)) {
			RootBook.setVisible(false);
			RootManager.setVisible(true);
			RootReader.setVisible(false);
		}else if (a.equals(bRootReader)) {
			RootBook.setVisible(false);
			RootManager.setVisible(false);
			RootReader.setVisible(true);
		}
//		else if (a.equals(bRootBookCreate)) {
//			
//		}else if (a.equals(bRootBookDelect)) {
//			
//		}else if (a.equals(bRootBookUpdate)) {
//			
//		}else if (a.equals(bRootBookSelect)) {
//			
//		}
		else if (a.equals(bRootBookSelectName)) {
			JOptionPane.showInputDialog(this, "��������Ҫ��ѯ������");
		}else if (a.equals(bRootBookSelectNo)) {
			JOptionPane.showInputDialog(this, "��������Ҫ��ѯ���鼮���");
		}else if (a.equals(bRootBookSelectAuthor)) {
			JOptionPane.showInputDialog(this, "��������Ҫ��ѯ���鼮����");
		}else if (a.equals(bRootBookSelectPress)) {
			JOptionPane.showInputDialog(this, "��������Ҫ��ѯ�ĳ�����");
		}else if (a.equals(bRootBookSelectKinds)) {
			JOptionPane.showInputDialog(this, "��������Ҫ��ѯ���鼮����");
		}
		else if (a.equals(bRootReaderCreate)) {
			
		}else if (a.equals(bRootReaderDelect)) {
			
		}else if (a.equals(bRootReaderUpdate)) {
			
		}else if (a.equals(bRootReaderSelect)) {
			
		}else if (a.equals(bRootManagerCreate)) {
			
		}else if (a.equals(bRootManagerDelect)) {
			
		}else if (a.equals(bRootManagerUpdate)) {
			
		}else if (a.equals(bRootManagerSelect)) {
			
		}else if (a.equals(bReaderLib)) {
			ReaderLib.setVisible(true);
			ReaderMessage.setVisible(false);
		}else if (a.equals(bReaderMessage)) {
			ReaderLib.setVisible(false);
			ReaderMessage.setVisible(true);
		}else if (a.equals(bReaderLibLib)) {
			int[] Rows = jtReaderBook.getSelectedRows();//��
			String input = "";
			if (Rows.length!=0&&Rows.length<=15) {
				for (int i = 0; i < Rows.length; i++) {
					if (i==Rows.length-2) {
						input = input +"��"+DataBook.get(i).get(1)+"��"+"��";
					}else if (i==Rows.length-1) {
						input = input+"��" +DataBook.get(i).get(1)+"��"+"";
					}else {
						input = input +"��"+DataBook.get(i).get(1)+"��"+"��";
					}
				}
				int answer = JOptionPane.showConfirmDialog(this, "��ȷ��Ҫ����"+input+"��");
				switch (answer) {
				case 0:
					
					break;
				case 1:
				case 2:
					break;
				default:
					break;
				}
			}else if(Rows.length==0){
				JOptionPane.showMessageDialog(this, "������ѡ��һ����");
			}else {
				JOptionPane.showMessageDialog(this, "ѡ�񳬹���"+(Rows.length-15)+"��");
			}
		}else if (a.equals(bReaderLibSelectName)) {
			String input = JOptionPane.showInputDialog(this, "123");
			addBookTable(input);
			for (int i = 0; i < DataBook.size(); i++) {
				for (int j = 0; j < DataBook.get(i).size(); j++) {
					tm.setValueAt(DataBook.get(i).get(j), i, j);
				}
			}
		}
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(jtReaderBook)) {
			int row = jtReaderBook.getSelectedRow();
			System.out.println(row);
		}
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void focusGained(FocusEvent e) {
		
		
	}
	public void focusLost(FocusEvent e) {
		Object a = e.getSource();
		if (a.equals(jtfRegisterName)) {
			if (!jtfRegisterName.getText().toString().equals("")) {
				Pattern p=Pattern.compile("[\u4e00-\u9fa5]"); 
		        Matcher m=p.matcher(jtfRegisterName.getText()); 
				if (!m.find()) {
					error[0] = "";
					judgment3.setText("��");
				}else {
					error[0] = "";
					judgment3.setText("�˺Ų���Ϊ����");
					judgment3.setForeground(Color.RED);
					error[0] = "�˺Ų���Ϊ����";
				}
			}else {
				error[0] = "";
				judgment3.setText("�û���Ϊ��");
				judgment3.setForeground(Color.red);
				error[0] = "�û���Ϊ��";
			}
		}else if (a.equals(jpfRegisterPwd1)) {
			if (!String.valueOf(jpfRegisterPwd1.getPassword()).equals("")) {
				error[1] = "";
				judgment4.setText("��");
			}else {
				error[1] = "";
				judgment4.setText("���벻��Ϊ��");
				error[1] = "���벻��Ϊ��";
			}
		}else if (a.equals(jpfRegisterPwd2)) {
			if (!String.valueOf(jpfRegisterPwd2.getPassword()).equals("")) {
				if (String.valueOf(jpfRegisterPwd1.getPassword()).equals(String.valueOf(jpfRegisterPwd2.getPassword()))) {
					error[2]="";
					judgment5.setText("��");
				}else {
					error[2]="";
					judgment5.setText("��������֤���벻һ��");
					error[2]="��������֤���벻һ��";
				}
			}else {
				error[2]="";
				judgment5.setText("��֤���벻��Ϊ��");
				error[2]="��֤���벻��Ϊ��";
			}
		}else if (a.equals(jtfRegisterQuestion)) {
			if (!jtfRegisterQuestion.getText().toString().equals("")) {
				error[3]="";
				judgment6.setText("��");
			}else {
				error[3]="";
				judgment6.setText("��֤���ⲻ��Ϊ��");
				error[3]="��֤���ⲻ��Ϊ��";
			}
		}else if (a.equals(jtfRegisterAnswer)) {
			if (!jtfRegisterAnswer.getText().toString().equals("")) {
				error[4]="";
				judgment7.setText("��");
			}else {
				error[4]="";
				judgment7.setText("��֤�𰸲���Ϊ��");
				error[4]="��֤�𰸲���Ϊ��";
			}
		}
	}
	private JLabel addJLabel(String name,int x,int y,int width,int height){
		jl = new JLabel(name);
		jl.setBounds(x, y, width, height);
		return jl;
	}
	private JLabel addJLabel(String name,int x,int y,int width,int height,Color color){
		jl = new JLabel(name);
		jl.setBounds(x, y, width, height);
		jl.setForeground(color);
		return jl;
	}
	private void addBookTable(){
		DataBook = new Vector<Vector<Object>>();
		bList = factory.getBookActionImpl().allBook();
		Vector<Object> b ;
		int n = 0;
		while (n<bList.size()) {
			b = new Vector<Object>();
			b.add(bList.get(n).getBid());
			b.add(bList.get(n).getName());
			b.add(bList.get(n).getbDate());
			b.add(bList.get(n).getbPress());
			b.add(bList.get(n).getbAuthor());
			b.add(bList.get(n).getbValue());
			b.add(bList.get(n).getBookKindsName());
			DataBook.add(b);
			n++;
		}
		columnNames = new Vector<String>();
		columnNames.add("�鼮���");
		columnNames.add( "����");
		columnNames.add("���ʱ��");
		columnNames.add("������");
		columnNames.add("����");
		columnNames.add("�г���");
		columnNames.add("�鼮����");
	}
	private void addBookTable(String name){
		DataBook = new Vector<Vector<Object>>();
		Vector<Object> b ;
		int n = 0;
		while (n<bList.size()) {
			if (bList.get(n).getName().equals(name)) {
				b = new Vector<Object>();
				b.add(bList.get(n).getBid());
				b.add(bList.get(n).getName());
				System.out.println(bList.get(n).getName());
				b.add(bList.get(n).getbDate());
				b.add(bList.get(n).getbPress());
				b.add(bList.get(n).getbAuthor());
				b.add(bList.get(n).getbValue());
				b.add(bList.get(n).getBookKindsName());
				DataBook.add(b);
			}
			n++;
		}
		columnNames = new Vector<String>();
		columnNames.add("�鼮���");
		columnNames.add( "����");
		columnNames.add("���ʱ��");
		columnNames.add("������");
		columnNames.add("����");
		columnNames.add("�г���");
		columnNames.add("�鼮����");
	}
	private void addBookTable(int kindno){
		DataBook = new Vector<Vector<Object>>();
		bList = factory.getBookActionImpl().allBook();
		Vector<Object> b ;
		int n = 0;
		while (n<bList.size()) {
			b = new Vector<Object>();
			b.add(bList.get(n).getBid());
			b.add(bList.get(n).getName());
			b.add(bList.get(n).getbDate());
			b.add(bList.get(n).getbPress());
			b.add(bList.get(n).getbAuthor());
			b.add(bList.get(n).getbValue());
			b.add(bList.get(n).getBookKindsName());
			DataBook.add(b);
			n++;
		}
		columnNames = new Vector<String>();
		columnNames.add("�鼮���");
		columnNames.add( "����");
		columnNames.add("���ʱ��");
		columnNames.add("������");
		columnNames.add("����");
		columnNames.add("�г���");
		columnNames.add("�鼮����");
	}
}
