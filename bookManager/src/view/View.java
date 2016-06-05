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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import entity.Book;
import entity.bookLibHistory;
import factory.factory;


public class View extends JFrame implements ActionListener,KeyListener,MouseListener,FocusListener{

	private factory factory = new factory();
	//ȫ�ֱ���
	int power = 0;
	serviceUI su = new serviceUI();
	private String[] error = new String[5];
	entity.Reader user = new entity.Reader();
	entity.Manager manager = new entity.Manager();
	Vector<Vector<Object>> DataBook;
	Vector<Vector<Object>> DataHistory;
	Vector<Vector<Object>> DataManagerLib;
	Vector<Vector<Object>> DataManagerReturn;
	Vector<Vector<Object>> DataRootBook;
	Vector<Vector<Object>> DataRootManager;
	ArrayList<Object> bList;
	ArrayList<Object> HList;
	ArrayList<Object> RMList;
	Vector<String> columnNames;
	Vector<String> HcolumnNames;
	Vector<String> RMcolumnNames;
	String time;
	TableModel tm_readerLib;
	TableModel tm_readerHistory;
	TableModel tm_rootBook;
	TableModel tm_rootManager;
	JScrollPane jsp1;
	//�ж�
	private JLabel judgment1 = new JLabel();
	private JLabel judgment2 = new JLabel();
	private JLabel judgment3 = new JLabel();
	private JLabel judgment4 = new JLabel();
	private JLabel judgment5 = new JLabel();
	private JLabel judgment6 = new JLabel();
	private JLabel judgment7 = new JLabel();
	private JLabel Message = new JLabel("��");
	//��������
	//ÿ�����ĵ����趨
	private int panelX = 0;
	private int panelY = 20;
	private int panelW = 1200;
	private int panelH = 600;
	//�������
	//JMenuItem
	private JMenuItem jmi1 = new JMenuItem("�ص���ҳ");
	private JMenuItem jmi2 = new JMenuItem("ע��");
	private JMenuItem jmi3 = new JMenuItem("�˳�");
	private JMenuItem jpmManagerBookDel = new JMenuItem("ɾ������Ŀ");
	private JMenuItem jpmManagerBookChange = new JMenuItem("�޸ĸ���Ŀ");
	private JMenuItem jpmManagerBookAdd = new JMenuItem("����һ����Ŀ");
	//JPopupMenu
	private JPopupMenu jpm = new JPopupMenu();
	private JPopupMenu jpmManagerBook = new JPopupMenu();
	private JComboBox jcb = new JComboBox();
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
	private JTextField jtfReaderMessageName = new JTextField();
	private JTextField jtfReaderMessageIDcard = new JTextField();
	private JTextField jtfManagerLib = new JTextField();
	private JTextField jtfManagerReturn = new JTextField();
	private JTextField jtfRootManagerMid = new JTextField();
	private JTextField jtfRootManagerMname = new JTextField();
	private JTextField jtfRootManagerMpwd = new JTextField();
	private JTextField jtfRootManagerpowerLevel = new JTextField();
	//JPasswordField
	private JPasswordField jpfLoginPwd = new JPasswordField();
	private JPasswordField jpfRegisterPwd1 = new JPasswordField();
	private JPasswordField jpfRegisterPwd2 = new JPasswordField();
	//JTable
	private JTable jtRootBook;
	private JTable jtReaderBook;
	private JTable jtReaderHistory;
	private JTable jtManagerLib;
	private JTable jtManagerReturn;
	private JTable jtRootManager;
	//JPanel
	private JPanel main = new JPanel();
	private JPanel Login = new JPanel();
	private JPanel Register = new JPanel();
	private JPanel NoPwd = new JPanel();
	private JPanel Root = new JPanel();
		private JPanel RootReader = new JPanel();
		private JPanel RootManager = new JPanel();
		private JPanel RootBook = new JPanel();
	private JPanel Manager = new JPanel();
		private JPanel ManagerLib  = new JPanel();
		private JPanel ManagerReturn = new JPanel();
	private JPanel Reader = new JPanel();
		private JPanel ReaderLib = new JPanel();
		private JPanel ReaderMessage = new JPanel();
		private JPanel ReaderHistory = new JPanel();
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
	private JButton bRootBookCreate = new JButton("�鼮��¼����");
//	private JButton bRootBookSelect = new JButton("�鼮��¼��ѯ");
//	private JButton bRootBookDelect = new JButton("�鼮��¼ɾ��");
//	private JButton bRootBookUpdate = new JButton("�鼮��¼�޸�");
	private JButton bRootBookSelectName = new JButton("�鼮���Ʋ�ѯ");
	private JButton bRootBookSelectNo = new JButton("�鼮��Ų�ѯ");
	private JButton bRootBookSelectAuthor = new JButton("�鼮���߲�ѯ");
	private JButton bRootBookSelectPress = new JButton("�鼮�������ѯ");
	private JButton bRootBookSelectKinds = new JButton("�鼮���Ͳ�ѯ");
//	private JButton bRootReaderCreate = new JButton("���߼�¼����");
//	private JButton bRootReaderSelect = new JButton("���߼�¼��ѯ");
//	private JButton bRootReaderDelect = new JButton("���߼�¼ɾ��");
//	private JButton bRootReaderUpdate = new JButton("���߼�¼�޸�");
//	private JButton bRootManagerCreate = new JButton("����Ա��¼����");
//	private JButton bRootManagerSelect = new JButton("����Ա��¼��ѯ");
//	private JButton bRootManagerDelect = new JButton("����Ա��¼ɾ��");
//	private JButton bRootManagerUpdate = new JButton("����Ա��¼�޸�");
	private JButton bRootManagerAdd = new JButton("������¼");
	private JButton bRootManagerUpdate = new JButton("�ύ�޸�");
	private JButton bRootManagerclear = new JButton("���");
	private JButton bRootManagerNew = new JButton("���±������");
	private JButton bManagerLib = new JButton("ͼ�����");
	private JButton bManagerReturn = new JButton("ͼ��黹");
	private JButton bManagerLibUpdate = new JButton("�ύ");
	private JButton bManagerLibY = new JButton("ȷ��");
	private JButton bManagerReturnUpdate = new JButton("�ύ");
	private JButton bManagerReturnY = new JButton("ȷ��");
	private JButton bReaderLib = new JButton("�鼮����");
	private JButton bReaderMessage = new JButton("�û���Ϣ����");
	private JButton bReaderHistory = new JButton("��ʷ��¼���");
	private JButton bReaderLibSelectName = new JButton("ͨ��������ѯ");
	private JButton bReaderLibSelectKinds = new JButton("ͨ���鼮���Ͳ�ѯ");
	private JButton bReaderLibAll = new JButton("ȫ���鼮");
	private JButton bReaderLibLib = new JButton("����ѡ�е��鼮");
	private JButton bReaderMessageUpdate = new JButton("�ύ");
	private TimerTask tt = new TimerTask() {
		@Override
		public void run() {
			java.util.Date date1 = new java.util.Date();
			Date date=new Date(date1.getTime());
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			time=format.format(date);
			jltime.setText("����ʱ�䣺"+time);
			
		}
	};
	private TimerTask table = new TimerTask() {
		
		@Override
		public void run() {
//			if (RootBook.isVisible()) {
//				addDataRootBookTable();
//				((DefaultTableModel)tm_rootBook).setRowCount(DataRootBook.size());
//				for (int i = 0; i < DataRootBook.size(); i++) {
//					for (int j = 0; j < DataRootBook.get(i).size(); j++) {
//						tm_rootBook.setValueAt(DataRootBook.get(i).get(j), i, j);
//					}
//				}
//				jtRootBook.updateUI();
//			}else if (RootManager.isVisible()) {
//				addDataRootManagerTable();
//				((DefaultTableModel)tm_rootManager).setRowCount(DataRootManager.size());
//				for (int i = 0; i < DataRootManager.size(); i++) {
//					for (int j = 0; j < DataRootManager.get(i).size(); j++) {
//						tm_rootManager.setValueAt(DataRootManager.get(i).get(j), i, j);
//					}
//				}
//				jtRootManager.updateUI();
//			}
		}
	};
	private Timer timer = new Timer();
	private Timer tableTimer = new Timer();
	
	public void init(){
		this.setTitle("ͼ��ݹ���ϵͳ");
		setSize(1200, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (main.isVisible()||Login.isVisible()||Register.isVisible()||NoPwd.isVisible()) {
					int a = 0;
					a = JOptionPane.showConfirmDialog(null, "���Ƿ�Ҫ�˳���ϵͳ��");
					switch (a) {
					case 0:
						System.exit(0);
						break;

					default:
						break;
					}
				}else {
					int a = 0;
					a = JOptionPane.showConfirmDialog(null, "���Ƿ�Ҫ�˳���ϵͳ��");
					switch (a) {
					case 0:
						System.exit(0);
						break;
							
					default:
						a = JOptionPane.showConfirmDialog(null, "���Ƿ�Ҫע����������ҳ��");
						switch (a) {
						case 0:
							Root.setVisible(false);
							Reader.setVisible(false);
							Manager.setVisible(false);
							main.setVisible(true);
							break;

						default:
							break;
						}
						break;
					}
				}
			}
		});
		getContentPane().setLayout(null);
		addMouseListener(this);
		
		join_JPopupMenu();
		join_main();
		join_Login();
		join_Register();
		join_NoPwd();
		join_root();
		join_reader();
		join_manager();
		
		
		timer.schedule(tt, 0, 1000);
		jltime.setBounds(0, 0, 200, 30);
		tableTimer.schedule(table, 0,10000);
		getContentPane().add(jltime);
		this.setVisible(true);
	}
	//�Ҽ��˵�
	private void join_JPopupMenu(){
		jmi1.addActionListener(this);
		jmi2.addActionListener(this);
		jmi3.addActionListener(this);
		jpm.add(jmi1);
		jpm.add(jmi2);
		jpm.add(jmi3);
		addMouseListener(this);
		add(jpm);
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
		getContentPane().add(main);
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
		getContentPane().add(Login);
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
		getContentPane().add(Register);
		
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
		getContentPane().add(NoPwd);
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
		getContentPane().add(Root);
	}
	//manager����
	private void join_manager(){
		int x = 10;
		int y = 10;
		int width = 150;
		int height = 30;
		Manager.setLayout(null);
		Manager.setBounds(panelX, panelY, panelW, panelH);
		
		Manager.add(addJLabel("֪ͨ����", x, y, width-50, height));
		Message.setBounds(x+50, y, width+500, height);
		Manager.add(Message);
		bManagerLib.setBounds(x, y=y+30, width, height);
		bManagerLib.addActionListener(this);
		Manager.add(bManagerLib);
		bManagerReturn.setBounds(x, y=y+30, width, height);
		bManagerReturn.addActionListener(this);
		Manager.add(bManagerReturn);
		
		join_Manager_lib();
		join_Manager_return();
		
		Manager.setVisible(false);
		add(Manager);
	}
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
		bReaderHistory.setBounds(x, y=y+30, width, height);
		bReaderHistory.addActionListener(this);
		Reader.add(bReaderHistory);
		bReaderMessage.setBounds(x, y=y+30, width, height);
		bReaderMessage.addActionListener(this);
		Reader.add(bReaderMessage);
		
		join_reader_lib();
		join_reader_history();
		join_reader_message();
		
		Reader.setVisible(false);
		getContentPane().add(Reader);
	}
	//book����
	private void join_root_book(){
		int x = 10;
		int y = 10;
		int width = 200;
		int height = 30;
		RootBook.setLayout(null);
//		RootBook.setBounds(panelX+100, panelY+150, panelW-400, panelH-100);
		RootBook.setBounds(panelX+150, panelY-20, panelW-200, panelH-100);
		
		
//		bRootBookDelect.setBounds(x, y=y+30, width-50, height);
//		bRootBookDelect.addActionListener(this);
//		RootBook.add(bRootBookDelect);
//		bRootBookUpdate.setBounds(x, y=y+30, width-50, height);
//		bRootBookUpdate.addActionListener(this);
//		RootBook.add(bRootBookUpdate);
//		bRootBookSelect.setBounds(x, y=y+30, width-50, height);
//		bRootBookSelect.addActionListener(this);
//		RootBook.add(bRootBookSelect);
		
		
		
		
		
		bRootBookSelectName.setBounds(x+800, y=y+30, width-50, height);
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
		
		bRootBookCreate.setBounds(x+800, y=y+60, width-50, height);
		bRootBookCreate.addActionListener(this);
		RootBook.add(bRootBookCreate);
		
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
		RootReader.setBounds(panelX+100, panelY+100, panelW-400, panelH-100);
		
//		bRootReaderCreate.setBounds(x, y, width-50, height);
//		bRootReaderCreate.addActionListener(this);
//		RootReader.add(bRootReaderCreate);
//		bRootReaderDelect.setBounds(x, y=y+30, width-50, height);
//		bRootReaderDelect.addActionListener(this);
//		RootReader.add(bRootReaderDelect);
//		bRootReaderUpdate.setBounds(x, y=y+30, width-50, height);
//		bRootReaderUpdate.addActionListener(this);
//		RootReader.add(bRootReaderUpdate);
//		bRootReaderSelect.setBounds(x, y=y+30, width-50, height);
//		bRootReaderSelect.addActionListener(this);
//		RootReader.add(bRootReaderSelect);
		
		
		
		RootReader.setVisible(false);
		Root.add(RootReader);
	}
	//manager����
	private void join_root_manager(){
		int x = 10;
		int y = 10;
		int width = 150;
		int height = 30;
		RootManager.setLayout(null);
		RootManager.setBounds(panelX+100, panelY+70, panelW-400, panelH-100);
		
//		bRootManagerCreate.setBounds(x, y, width-50, height);
//		bRootManagerCreate.addActionListener(this);
//		RootManager.add(bRootManagerCreate);
//		bRootManagerDelect.setBounds(x, y=y+30, width-50, height);
//		bRootManagerDelect.addActionListener(this);
//		RootManager.add(bRootManagerDelect);
//		bRootManagerUpdate.setBounds(x, y=y+30, width-50, height);
//		bRootManagerUpdate.addActionListener(this);
//		RootManager.add(bRootManagerUpdate);
//		bRootManagerSelect.setBounds(x, y=y+30, width-50, height);
//		bRootManagerSelect.addActionListener(this);
//		RootManager.add(bRootManagerSelect);
//		
//		join_root_1_1();
//		join_root_1_2();
//		join_root_1_3();
//		join_root_1_4();
		
		RootManager.add(addJLabel("Ա��id", x=x+350, y, width, height));
		jtfRootManagerMid.setBounds(x+150, y, width, height);
		jtfRootManagerMid.setEditable(false);
		RootManager.add(jtfRootManagerMid);
		RootManager.add(addJLabel("Ա���˺�", x, y=y+30, width, height));
		jtfRootManagerMname.setBounds(x+150, y, width, height);
		RootManager.add(jtfRootManagerMname);
		RootManager.add(addJLabel("Ա������", x, y=y+30, width, height));
		jtfRootManagerMpwd.setBounds(x+150, y, width, height);
		RootManager.add(jtfRootManagerMpwd);
		//TODO Ա��Ȩ�޵ȼ�������
		RootManager.add(addJLabel("Ա��Ȩ�޵ȼ�", x, y=y+30, width, height));
		jcb.setModel(new DefaultComboBoxModel(new String[] {"\u5458\u5DE5\u6743\u9650", "\u6700\u9AD8\u6743\u9650"}));
		jcb.setBounds(x+150, y, width, height);
		RootManager.add(jcb);
		
		bRootManagerAdd.setBounds(x, y=y+30, 100, height);
		bRootManagerAdd.addActionListener(this);
		bRootManagerUpdate.setBounds(x+150, y, 100, height);
		bRootManagerUpdate.addActionListener(this);
		bRootManagerclear.setBounds(x+300, y, 100, height);
		bRootManagerclear.addActionListener(this);
		RootManager.add(bRootManagerAdd);
		RootManager.add(bRootManagerUpdate);
		RootManager.add(bRootManagerclear);
		
		bRootManagerNew.setBounds(x-20, y=y+60, 100, height);
		bRootManagerNew.addActionListener(this);
		RootManager.add(bRootManagerNew);
		
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
		
		ReaderLib.add(addJLabel("ע���ϵͳֻ�ṩͼ�����Ԥ���������û���ͼ����Լ���ȡ", x, y, width+400, height, Color.red));
		
		
		
		bReaderLibSelectName.setBounds(x=x+800, y=y+30, width, height);
		bReaderLibSelectKinds.setBounds(x, y=y+30, width, height);
		bReaderLibAll.setBounds(x, y=y+30, width, height);
		bReaderLibLib.setBounds(x, y+100, width, height);
		bReaderLibSelectName.addActionListener(this);
		bReaderLibSelectKinds.addActionListener(this);
		bReaderLibAll.addActionListener(this);
		bReaderLibLib.addActionListener(this);
		ReaderLib.add(bReaderLibSelectName);
		ReaderLib.add(bReaderLibSelectKinds);
		ReaderLib.add(bReaderLibAll);
		ReaderLib.add(bReaderLibLib);
		
		
		ReaderLib.setVisible(false);
		Reader.add(ReaderLib);
	}
	//�û���ʷ��¼
	private void join_reader_history(){
		int x = 10;
		int y = 10;
		int width = 150;
		int height = 30;
		ReaderHistory.setLayout(null);
		ReaderHistory.setBounds(panelX+150, panelY+30, panelW-200, panelH-100);
		
		
		
		ReaderHistory.setVisible(false);
		Reader.add(ReaderHistory);
	}
	//�û���Ϣ����
	private void join_reader_message(){
		int x = 10;
		int y = 10;
		int width = 150;
		int height = 30;
		ReaderMessage.setLayout(null);
		ReaderMessage.setBounds(panelX+150, panelY+30, panelW-200, panelH-100);
		
		ReaderMessage.add(addJLabel("��ʵ������", x, y, width, height));
		jtfReaderMessageName.setBounds(x+100, y, width, height);
		ReaderMessage.add(jtfReaderMessageName);
		ReaderMessage.add(addJLabel("���֤�ţ�", x, y=y+30, width, height));
		jtfReaderMessageIDcard.setBounds(x+100, y, width, height);
		ReaderMessage.add(jtfReaderMessageIDcard);
		bReaderMessageUpdate.setBounds(x, y=y+30, width, height);
		bReaderMessageUpdate.addActionListener(this);
		ReaderMessage.add(bReaderMessageUpdate);
		
		
		ReaderMessage.setVisible(false);
		Reader.add(ReaderMessage);
	}
	//ͼ����Ĺ���Աȷ������
	private void join_Manager_lib(){
		int x = 10;
		int y = 10;
		int width = 150;
		int height = 30;
		ManagerLib.setLayout(null);
		ManagerLib.setBounds(panelX+150, panelY+30, panelW-200, panelH-100);
		
		ManagerLib.add(addJLabel("   ͼ�����", x, y, width, height,Color.red));
		ManagerLib.add(addJLabel("�û���:", x=x+150, y, width, height));
		jtfManagerLib.setBounds(x=x+50, y, width, height);
		jtfManagerLib.setText("��������˺�");
		jtfManagerLib.addFocusListener(this);
		ManagerLib.add(jtfManagerLib);
		bManagerLibUpdate.setBounds(x+150, y, width, height);
		bManagerLibUpdate.addActionListener(this);
		ManagerLib.add(bManagerLibUpdate);
		
		
		ManagerLib.setVisible(false);
		Manager.add(ManagerLib);
	}
	//ͼ��黹����Աȷ�Ͻ���
	private void join_Manager_return(){
		int x = 10;
		int y = 10;
		int width = 150;
		int height = 30;
		ManagerReturn.setLayout(null);
		ManagerReturn.setBounds(panelX+150, panelY+30, panelW-200, panelH-100);
		
		ManagerReturn.add(addJLabel("   ͼ��黹", x, y, width, height,Color.red));
		ManagerReturn.add(addJLabel("�û���:", x=x+150, y, width, height));
		jtfManagerReturn.setBounds(x=x+50, y, width, height);
		jtfManagerReturn.setText("��������˺�");
		jtfManagerReturn.addFocusListener(this);
		ManagerReturn.add(jtfManagerReturn);
		bManagerReturnUpdate.setBounds(x+150, y, width, height);
		bManagerReturnUpdate.addActionListener(this);
		ManagerReturn.add(bManagerReturnUpdate);
		
		ManagerReturn.setVisible(false);
		Manager.add(ManagerReturn);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object a =  e.getSource();
		if (a.equals(bTest)) {
			main.setVisible(false);
			Root.setVisible(true);
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
			String name = user.getAccounts();
			name = jtfLoginName.getText();
			String pwd =  new String(jpfLoginPwd.getPassword());
			int n = -1;
			n = factory.getReaderActionImpl().Login(name, pwd);
			switch (n) {
			case 0:
				user = factory.getReaderActionImpl().Login(name);
			case 1:
			case 2:
				JOptionPane.showMessageDialog(this, "��½�ɹ�");
				if (user.getRid()==0) {
					manager = factory.getManagerActionImpl().selectManager(name);
					power = manager.getPowerLevel();
				}
				break;
			default:
				JOptionPane.showMessageDialog(this, "�û������������");
				break;
			}
			if (n==0) {
				Reader.add(addJLabel(user.getAccounts(), 100, 10, 200, 30));
				Login.setVisible(false);
				Reader.setVisible(true);
			}else if (n==1) {
				Root.add(addJLabel(manager.getMname(), 50, 10, 200, 30));
				Login.setVisible(false);
				Manager.setVisible(true);
			}else if (n==2) {
				Root.add(addJLabel(manager.getMname(), 50, 10, 200, 30));
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
			//TODO bNoPwdFind
		}else if (a.equals(bNoPwdBack)) {
			NoPwd.setVisible(false);
			main.setVisible(true);
		}else if (a.equals(bRootBook)) {
//			addBookTable();
			addDataRootBookTable();
			tm_rootBook  =new DefaultTableModel(DataRootBook, columnNames);
			jtRootBook = new mytable(tm_rootBook);
			jtRootBook.setBounds(10, 10, 800, 400);
			jtRootBook.getTableHeader().setReorderingAllowed(false);
			jtRootBook.getTableHeader().setResizingAllowed(false);
			jtRootBook.addMouseListener(this);
			jpmManagerBookDel.addActionListener(this);
			jpmManagerBookAdd.addActionListener(this);
			jpmManagerBookChange.addActionListener(this);
			jpmManagerBook.add(jpmManagerBookDel);
			jpmManagerBook.add(jpmManagerBookChange);
			jpmManagerBook.add(jpmManagerBookAdd);
			jpmManagerBook.addMouseListener(this);
			jtRootBook.add(jpmManagerBook);
			JScrollPane JSP= new JScrollPane(jtRootBook);
			JSP.setBounds(10, 40, 800, 400);
			RootBook.add(JSP);
			bRootBook.setBackground(Color.LIGHT_GRAY);
			bRootManager.setBackground(null);
			bRootReader.setBackground(null);
			RootBook.setVisible(true);
			RootManager.setVisible(false);
			RootReader.setVisible(false);
		}else if (a.equals(bRootManager)) {
			addDataRootManagerTable();
			if (tm_rootManager!=null) {
				((DefaultTableModel) tm_rootManager).setRowCount(DataRootManager.size());
			}
			System.out.println(DataRootManager.get(0).get(0));
			tm_rootManager = new DefaultTableModel(DataRootManager,RMcolumnNames);
			jtRootManager = new mytable(tm_rootManager);
			jtRootManager.addMouseListener(this);
			JScrollPane JSP = new JScrollPane(jtRootManager);
			JSP.setBounds(10, 10, 300, 400);
			RootManager.add(JSP);
			jtRootManager.updateUI();
			bRootBook.setBackground(null);
			bRootManager.setBackground(Color.LIGHT_GRAY);
			bRootReader.setBackground(null);
			RootBook.setVisible(false);
			RootManager.setVisible(true);
			RootReader.setVisible(false);
		}else if (a.equals(bRootReader)) {
			bRootBook.setBackground(null);
			bRootManager.setBackground(null);
			bRootReader.setBackground(Color.LIGHT_GRAY);
			RootBook.setVisible(false);
			RootManager.setVisible(false);
			RootReader.setVisible(true);
		}
//		else if (a.equals(bRootManagerCreate)) {
//			RootManagerAdd.setVisible(true);
//			RootManagerDel.setVisible(false);
//			RootManagerChange.setVisible(false);
//			RootManagerSelect.setVisible(false);
//		}else if (a.equals(bRootManagerDelect)) {
//			RootManagerAdd.setVisible(false);
//			RootManagerDel.setVisible(true);
//			RootManagerChange.setVisible(false);
//			RootManagerSelect.setVisible(false);
//		}else if (a.equals(bRootManagerUpdate)) {
//			RootManagerAdd.setVisible(false);
//			RootManagerDel.setVisible(false);
//			RootManagerChange.setVisible(true);
//			RootManagerSelect.setVisible(false);
//		}else if (a.equals(bRootManagerSelect)) {
//			RootManagerAdd.setVisible(false);
//			RootManagerDel.setVisible(false);
//			RootManagerChange.setVisible(false);
//			RootManagerSelect.setVisible(true);
//		}
		else if (a.equals(bRootBookCreate)) {
			addBook addBook = new addBook();
			addBook.init(this);
//			TaddBook tb = new TaddBook(addBook);
//			Thread t = new Thread(tb);
//			try {
//				t.join();
//				
//			} catch (InterruptedException e1) {
//				e1.printStackTrace();
//			};
//			
//			System.out.println(1);
//			addDataRootBookTable();
//			((DefaultTableModel)tm_rootBook).setRowCount(DataRootBook.size());
//			for (int i = 0; i < DataRootBook.size(); i++) {
//				for (int j = 0; j < DataRootBook.get(i).size(); j++) {
//					tm_rootBook.setValueAt(DataRootBook.get(i).get(j), i, j);
//				}
//			}
//			jtRootBook.updateUI();
			
		}
//			else if (a.equals(bRootBookDelect)) {
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
//		else if (a.equals(bRootReaderCreate)) {
//			//TODO bRootReaderCreate
//		}else if (a.equals(bRootReaderDelect)) {
//			//TODO bRootReaderDelect
//		}else if (a.equals(bRootReaderUpdate)) {
//			
//		}else if (a.equals(bRootReaderSelect)) {
//			
//		}
		else if (a.equals(bRootManagerAdd)) {
			this.dispose();
			new addManager(this);
			
		}else if (a.equals(bRootManagerUpdate)) {
			//TODO bRootManagerUpdate
			Vector<Object> v = new Vector<Object>();
			v.add(jtfRootManagerMid.getText());
			v.add(jtfRootManagerMname.getText());
			v.add(jtfRootManagerMpwd.getText());
			v.add(jcb.getItemCount()+1);
			if (factory.getManagerActionImpl().changeManager(v)) {
				JOptionPane.showMessageDialog(this, "�޸ĳɹ�");
				((DefaultTableModel)tm_rootManager).setRowCount(DataRootManager.size());
				for (int i = 0; i < DataRootManager.size(); i++) {
					for (int j = 0; j < DataRootManager.get(i).size(); j++) {
						tm_rootManager.setValueAt(DataRootManager.get(i).get(j), i, j);
					}
				}
				jtRootManager.updateUI();
			}else {
				JOptionPane.showMessageDialog(this, "�޸�ʧ��");
			}
			
		}else if (a.equals(bRootManagerclear)) {
			jtfRootManagerMid.setText("");
			jtfRootManagerMname.setText("");
			jtfRootManagerMpwd.setText("");
			jcb.setSelectedIndex(0);
			jtRootManager.setSelectionMode(0);
		}else if (a.equals(bRootManagerNew)) {
			addDataRootManagerTable();
			((DefaultTableModel)tm_rootManager).setRowCount(DataRootManager.size());
			for (int i = 0; i < DataRootManager.size(); i++) {
				for (int j = 0; j < DataRootManager.get(i).size(); j++) {
					tm_rootManager.setValueAt(DataRootManager.get(i).get(j), i, j);
				}
			}
			jtRootManager.updateUI();
		}
//		else if (a.equals(bRootManagerCreate)) {
//			
//		}else if (a.equals(bRootManagerDelect)) {
//			
//		}else if (a.equals(bRootManagerUpdate)) {
//			
//		}else if (a.equals(bRootManagerSelect)) {
//			
//		}
		else if (a.equals(bReaderLib)) {
//			addBookTable();
//			tm_readerLib = new DefaultTableModel(DataBook, columnNames);
//			tm_readerLib.addTableModelListener(new TableModelListener() {
//				
//				public void tableChanged(TableModelEvent e) {
////					jtReaderBook = new mytable(tm);
////					jtReaderBook.repaint(10, 10, 800, 400);
////					jtReaderBook.updateUI();
////					jtReaderBook.validate();
//					tm_readerLib = new DefaultTableModel(DataBook, columnNames);
//					tm_readerLib.addTableModelListener(this);
//					jtReaderBook = new mytable(tm_readerLib);
////					jtReaderBook.repaint();
//					jtReaderBook.updateUI();
//				}
//			});
//			jtReaderBook = new mytable(tm_readerLib);
//			jtReaderBook.setBounds(10, 10, 800, 400);
//			jtReaderBook.getTableHeader().setReorderingAllowed(false);
//			jtReaderBook.addMouseListener(this);
//			jsp1= new JScrollPane(jtReaderBook);
//			jsp1.setBounds(10, 40, 800, 400);
//			ReaderLib.add(jsp1);
			addBookTable();
			tm_readerLib = new DefaultTableModel(DataBook, columnNames);
			jtReaderBook = new mytable();
			jtReaderBook.setModel(tm_readerLib);
			jtReaderBook.setBounds(10, 10, 800, 400);
			jtReaderBook.getTableHeader().setReorderingAllowed(false);
			jtReaderBook.addMouseListener(this);
			jsp1= new JScrollPane(jtReaderBook);
			jsp1.setBounds(10, 40, 800, 400);
			ReaderLib.add(jsp1);
			bReaderLib.setBackground(Color.LIGHT_GRAY);
			bReaderMessage.setBackground(null);
			bReaderHistory.setBackground(null);
			ReaderLib.setVisible(true);
			ReaderMessage.setVisible(false);
			ReaderHistory.setVisible(false);
		}else if (a.equals(bReaderMessage)) {
			bReaderMessage.setBackground(Color.LIGHT_GRAY);
			bReaderLib.setBackground(null);
			bReaderHistory.setBackground(null);
			ReaderLib.setVisible(false);
			ReaderMessage.setVisible(true);
			ReaderHistory.setVisible(false);
		}else if (a.equals(bReaderHistory)) {
			bReaderHistory.setBackground(Color.LIGHT_GRAY);
			bReaderMessage.setBackground(null);
			bReaderLib.setBackground(null);
			addBookHistory(user.getRid());
			tm_readerHistory = new DefaultTableModel(DataHistory, HcolumnNames);
			jtReaderHistory = new mytable(tm_readerHistory);
			jtReaderHistory.setBounds(10, 10, 800, 400);
			JScrollPane jsp = new JScrollPane(jtReaderHistory);
			jsp.setBounds(10, 10, 800, 400);
			ReaderHistory.add(jsp);
			ReaderLib.setVisible(false);
			ReaderMessage.setVisible(false);
			ReaderHistory.setVisible(true);
		}else if (a.equals(bReaderLibLib)) {
			int[] Rows = jtReaderBook.getSelectedRows();//��
			String input = "";
			ArrayList<Object>b2List = new ArrayList<Object>();
			if (Rows.length!=0&&Rows.length<=15) {
				for (int i = 0; i < Rows.length; i++) {
					if (i==Rows.length-2) {
						input = input +"��"+DataBook.get(Rows[i]).get(1)+"��"+"��";
					}else if (i==Rows.length-1) {
						input = input+"��" +DataBook.get(Rows[i]).get(1)+"��"+"";
					}else {
						input = input +"��"+DataBook.get(Rows[i]).get(1)+"��"+"��";
					}
					Book b = factory.getBook();
					b.setBid(Integer.valueOf(DataBook.get(Rows[i]).get(0).toString()));
					b2List.add(i, b);
				}
				int answer = JOptionPane.showConfirmDialog(this, "��ȷ��Ҫ����"+input+"��");
				switch (answer) {
				case 0:
					System.out.println(((Book)b2List.get(0)).getbAuthor());
					if (factory.getBookActionImpl().LibBook(b2List,user)) {
						JOptionPane.showMessageDialog(this, "��ϲ��Ԥ���ɹ���");
						addBookTable();
						((DefaultTableModel) tm_readerLib).setRowCount(DataBook.size());
						for (int i = 0; i < DataBook.size(); i++) {
							for (int j = 0; j < DataBook.get(i).size(); j++) {
								tm_readerLib.setValueAt(DataBook.get(i).get(j), i, j);
							}
						}
						jtReaderBook.updateUI();
					}else {
						JOptionPane.showMessageDialog(this, "Ԥ��ʧ�ܣ����Ժ�����");
					}
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
			((DefaultTableModel) tm_readerLib).setRowCount(DataBook.size());
			for (int i = 0; i < DataBook.size(); i++) {
				for (int j = 0; j < DataBook.get(i).size(); j++) {
					tm_readerLib.setValueAt(DataBook.get(i).get(j), i, j);
				}
			}
			jtReaderBook.updateUI();
		}else if (a.equals(bReaderLibSelectKinds)) {
			
		}else if (a.equals(bReaderLibAll)) {
			addBookTable();
			((DefaultTableModel) tm_readerLib).setRowCount(DataBook.size());
			for (int i = 0; i < DataBook.size(); i++) {
				for (int j = 0; j < DataBook.get(i).size(); j++) {
					tm_readerLib.setValueAt(DataBook.get(i).get(j), i, j);
				}
			}
			jtReaderBook.updateUI();
			
		}else if (a.equals(bReaderMessageUpdate)) {
			String uname = jtfReaderMessageName.getText();
			String IDcard = jtfReaderMessageIDcard.getText();
			Pattern p = Pattern.compile("^(\\d{18,18}|\\d{15,15}|\\d{17,17}x)$");
			Matcher m = p.matcher(IDcard);
			if (m.find()) {
				if (factory.getReaderActionImpl().information(user)) {
					JOptionPane.showMessageDialog(this, "�޸ĳɹ�");
				}else {
					JOptionPane.showMessageDialog(this, "�޸�ʧ��");
				}
			}else {
				JOptionPane.showMessageDialog(this, "���֤�Ų��Ϸ�");
			}
			user.setName(uname);
			user.setIDcard(IDcard);
		}else if (a.equals(bManagerLib)) {
			ManagerLib.setVisible(true);
			ManagerReturn.setVisible(false);
		}else if (a.equals(bManagerReturn)) {
			ManagerLib.setVisible(false);
			ManagerReturn.setVisible(true);
		}else if (a.equals(bManagerLibUpdate)) {
			addManagerLibBook(jtfManagerLib.getText());
			if (HList==null) {
				JOptionPane.showMessageDialog(this, "�û�������");
			}else {
				TableModel tm = new DefaultTableModel(DataManagerLib, HcolumnNames);
				jtManagerLib = new mytable(tm);
				jtManagerLib.setBounds(0, 0, 800, 400);
				jtManagerLib.getTableHeader().setReorderingAllowed(false);
				jtManagerLib.addMouseListener(this);
				JScrollPane JSP = new JScrollPane(jtManagerLib);
				JSP.setBounds(50, 50, 800, 400);
				ManagerLib.add(JSP);
				bManagerLibY.setBounds(850, 300, 100, 30);
				bManagerLibY.addActionListener(this);
				ManagerLib.add(bManagerLibY);
				Manager.repaint();
				
			}
			HList=null;
		}else if (a.equals(bManagerLibY)) {
			int[] row = jtManagerLib.getSelectedRows();
			int answer = -1;
			for (int i = 0; i < row.length; i++) {
				//TODO ���Կ�������ʶ������ı������
				answer = su.double_bManagerLib(DataManagerLib, row[i]);
				switch (answer) {
				case 1:
					JOptionPane.showMessageDialog(this, "��¼�ɹ�");
					break;
				default:
					JOptionPane.showMessageDialog(this, "��¼ʧ��");
					break;
				}
			}
		}else if (a.equals(bManagerReturnUpdate)) {
			addManagerReturnBook(jtfManagerReturn.getText());
			if (HList==null) {
				JOptionPane.showMessageDialog(this, "�û�������");
			}else {
				TableModel tm = new DefaultTableModel(DataManagerReturn, HcolumnNames);
				jtManagerReturn = new mytable(tm);
				jtManagerReturn.setBounds(0, 0, 800, 400);
				jtManagerReturn.getTableHeader().setReorderingAllowed(false);
				jtManagerReturn.addMouseListener(this);
				JScrollPane JSP = new JScrollPane(jtManagerReturn);
				JSP.setBounds(50, 50, 800, 400);
				ManagerReturn.add(JSP);
				bManagerReturnY.setBounds(850, 300, 100, 30);
				bManagerReturnY.addActionListener(this);
				ManagerReturn.add(bManagerReturnY);
				Manager.repaint();
				
			}
			HList=null;
		}else if (a.equals(bManagerReturnY)) {
			int[] row = jtManagerReturn.getSelectedRows();
			int answer = -1;
			for (int i = 0; i < row.length; i++) {
				//TODO ���Կ�������ʶ������ı������
				answer = su.double_bManagerReturn(DataManagerReturn, row[i]);
				switch (answer) {
				case 1:
					JOptionPane.showMessageDialog(this, "��¼�ɹ�");
					break;
				default:
					JOptionPane.showMessageDialog(this, "��¼ʧ��");
					break;
				}
			}
		}else if (a.equals(jpmManagerBookAdd)) {
			//TODO addbook
		}else if (a.equals(jpmManagerBookChange)) {
			//TODO changerBook
		}else if (a.equals(jpmManagerBookDel)) {
			//TODO delBook
		}
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object a = e.getSource();
		if (e.getClickCount()==1) {
			if (e.getSource().equals(jtReaderBook)) {
				int row = jtReaderBook.getSelectedRow();
			}else if (e.getButton() == MouseEvent.BUTTON3) {
				if (!main.isVisible()&&!RootBook.isVisible()) 
					jpm.show(this, e.getX(), e.getY());
				else if (RootBook.isVisible()) {
					jpmManagerBook.show(this, e.getX()+170, e.getY()+120);
				}
			}else if (a.equals(jtManagerLib)) {
				
			}else if (a.equals(jtRootManager)) {
				int row = jtRootManager.getSelectedRow();
				entity.Manager m = (entity.Manager)RMList.get(row);
				jtfRootManagerMid.setText(String.valueOf(m.getMid()));
				jtfRootManagerMname.setText(m.getMname());
				jtfRootManagerMpwd.setText(m.getMpwd());
				jcb.setSelectedIndex(m.getPowerLevel()-1);
			}
		}else if (e.getClickCount()==2) {
			if (a.equals(jtManagerLib)) {
				int row = jtManagerLib.getSelectedRow();
				int answer = JOptionPane.showConfirmDialog(this, "��ȷ��Ҫ����"+DataManagerLib.get(row).get(2)+"�����")	;
				if (answer == 0) {
					answer = su.double_bManagerLib(DataManagerLib, row);
					//TODO ���ش���ԭ��
					switch (answer) {
					case 0:
						JOptionPane.showMessageDialog(this, "��¼�ɹ�");
						break;
					case 1:
						break;
					case 2:
						break;
					default:
						JOptionPane.showMessageDialog(this, "��¼ʧ��");
						break;
					}
				}
			}else if (a.equals(jtManagerReturn)) {
				int row = jtManagerReturn.getSelectedRow();
				int answer = JOptionPane.showConfirmDialog(this, "���Ƿ�ȷ����"+DataManagerReturn.get(row).get(2)+"���ѹ黹")	;
				if (answer == 0) {
					answer = su.double_bManagerReturn(DataManagerReturn, row);
					//TODO ���ش���ԭ��
					switch (answer) {
					case 0:
						JOptionPane.showMessageDialog(this, "��¼�ɹ�");
						break;
					case 1:
						break;
					case 2:
						break;
					default:
						JOptionPane.showMessageDialog(this, "��¼ʧ��");
						break;
					}
				}
			}else if (a.equals(jtRootBook)) {
				int row =  jtRootBook.getSelectedRow();
				new changeBook(this, DataRootBook.get(row));
			}
		}
	}
	public void mousePressed(MouseEvent e) {
		
	}
	public void mouseReleased(MouseEvent e) {
//		if (e.getSource().equals(jtRootBook)) {
//			jpm.show(null,e.getX(),e.getY());
//			jpmManagerBook.show(jtRootBook, e.getX(), e.getY());
//		}
	}
	public void mouseEntered(MouseEvent e) {
//		if (e.getSource().equals(jtRootBook)) {
//			jpmManagerBook.show(null,e.getX(),e.getY());
//			jpm.show(jtRootBook, e.getX(), e.getY());
//		}
	}
	public void mouseExited(MouseEvent e) {
//		if (e.getSource().equals(jtRootBook)) {
//			jpm.show(null,e.getX(),e.getY());
//			jpmManagerBook.show(jtRootBook, e.getX(), e.getY());
//		}
	}
	public void keyTyped(KeyEvent e) {
		
	}
	public void keyPressed(KeyEvent e) {
		
	}
	public void keyReleased(KeyEvent e) {
		
	}
	public void focusGained(FocusEvent e) {
		Object a = e.getSource();
		if (a.equals(jtfManagerLib)) {
			if (jtfManagerLib.getText().equals("��������˺�")) {
				jtfManagerLib.setText("");
			}
		}else if (a.equals(jtfManagerReturn)) {
			if (jtfManagerReturn.getText().equals("��������˺�")) {
				jtfManagerReturn.setText("");
			}
		}
		
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
					judgment3.setForeground(Color.green);
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
				judgment4.setForeground(Color.green);
			}else {
				error[1] = "";
				judgment4.setText("���벻��Ϊ��");
				judgment4.setForeground(Color.red);
				error[1] = "���벻��Ϊ��";
			}
		}else if (a.equals(jpfRegisterPwd2)) {
			if (!String.valueOf(jpfRegisterPwd2.getPassword()).equals("")) {
				if (String.valueOf(jpfRegisterPwd1.getPassword()).equals(String.valueOf(jpfRegisterPwd2.getPassword()))) {
					error[2]="";
					judgment5.setText("��");
					judgment5.setForeground(Color.green);
				}else {
					error[2]="";
					judgment5.setText("��������֤���벻һ��");
					judgment5.setForeground(Color.red);
					error[2]="��������֤���벻һ��";
				}
			}else {
				error[2]="";
				judgment5.setText("��֤���벻��Ϊ��");
				judgment5.setForeground(Color.red);
				error[2]="��֤���벻��Ϊ��";
			}
		}else if (a.equals(jtfRegisterQuestion)) {
			if (!jtfRegisterQuestion.getText().toString().equals("")) {
				error[3]="";
				judgment6.setText("��");
				judgment6.setForeground(Color.green);
			}else {
				error[3]="";
				judgment6.setText("��֤���ⲻ��Ϊ��");
				judgment6.setForeground(Color.red);
				error[3]="��֤���ⲻ��Ϊ��";
			}
		}else if (a.equals(jtfRegisterAnswer)) {
			if (!jtfRegisterAnswer.getText().toString().equals("")) {
				error[4]="";
				judgment7.setText("��");
				judgment7.setForeground(Color.green);
			}else {
				error[4]="";
				judgment7.setText("��֤�𰸲���Ϊ��");
				judgment7.setForeground(Color.red);
				error[4]="��֤�𰸲���Ϊ��";
			}
		}else if (a.equals(jtfManagerLib)) {
			if (jtfManagerLib.getText().equals("")) {
				jtfManagerLib.setText("��������˺�");
			}
		}else if (a.equals(jtfManagerReturn)) {
			if (jtfManagerReturn.getText().equals("")) {
				jtfManagerReturn.setText("��������˺�");
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
		Book B;
		while (n<bList.size()) {
			B = (Book) bList.get(n);
			if (B.getStatus()==1||power!=0) {
				b = new Vector<Object>();
				b.add(B.getBid());
				System.out.println(B.getBid());
				b.add(B.getName());
				b.add(B.getbDate());
				b.add(B.getbPress());
				b.add(B.getbAuthor());
				b.add(B.getbValue());
				b.add(B.getBookKindsName());
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
	private void addBookTable(String name){
		DataBook = new Vector<Vector<Object>>();
		Vector<Object> b ;
		int n = 0;
		Book B;
		while (n<bList.size()) {
			B = (Book) bList.get(n);
			if (B.getStatus()==1)
			if (B.getName().equals(name)) {
				b = new Vector<Object>();
				b.add(B.getBid());
				b.add(B.getName());
				b.add(B.getbDate());
				b.add(B.getbPress());
				b.add(B.getbAuthor());
				b.add(B.getbValue());
				b.add(B.getBookKindsName());
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
	private void addBookHistory(int rid){
		DataHistory = new Vector<Vector<Object>>();
		if (HList==null) {
			entity.Reader reader = new entity.Reader();
			reader.setRid(rid);
			HList = factory.getBookActionImpl().readerBookHistory(reader);
		}
		Vector<Object> h = null;
		int n = 0;
		bookLibHistory H;
//		 blh.bookLibHistoryNo,b.bid,b.name,r.rid,r.accounts,blh.hdate,blh.libDate
		while (n<HList.size()) {
			H = (bookLibHistory)HList.get(n);
			h = new Vector<Object>();
			h.add(H.getBookLibHistory());
			h.add(H.getBook().getBid());
			h.add(H.getBook().getName());
			h.add(H.getReader().getRid());
			h.add(H.getReader().getAccounts());
			h.add(H.getLibDate());
			h.add(H.getReturnDate());
			DataHistory.add(h);
			n++;
		}
		HcolumnNames = new Vector<String>();
		HcolumnNames.add("��ʷ���");
		HcolumnNames.add("�鼮���");
		HcolumnNames.add("�鼮����");
		HcolumnNames.add("���߱��");
		HcolumnNames.add("�����û���");
		HcolumnNames.add("����ʱ��");
		HcolumnNames.add("�黹ʱ��");
	}
	private void addManagerLibBook(String name){
		DataManagerLib = new Vector<Vector<Object>>();
		entity.Reader reader = new entity.Reader();
		reader.setAccounts(name);
		HList = factory.getManagerActionImpl().ManagerLibHistory(name);
		Vector<Object> h = null;
		int n = 0;
		bookLibHistory H;
		if (HList==null) {
			return;
		}
		while (n<HList.size()) {
			H = (bookLibHistory)HList.get(n);
			if (H.getStatus()==1&&H.getLibDate()==null) {
				h = new Vector<Object>();
				h.add(H.getBookLibHistory());
				h.add(H.getBook().getBid());
				h.add(H.getBook().getName());
				h.add(H.getReader().getRid());
				h.add(H.getReader().getAccounts());
				h.add(H.getLibDate());
				h.add(H.getReturnDate());
				DataManagerLib.add(h);
			}
			n++;
		}
		HcolumnNames = new Vector<String>();
		HcolumnNames.add("��ʷ���");
		HcolumnNames.add("�鼮���");
		HcolumnNames.add("�鼮����");
		HcolumnNames.add("���߱��");
		HcolumnNames.add("�����û���");
		HcolumnNames.add("����ʱ��");
		HcolumnNames.add("�黹ʱ��");
	}
	private void addManagerReturnBook(String name){
		DataManagerReturn = new Vector<Vector<Object>>();
		entity.Reader reader = new entity.Reader();
		reader.setAccounts(name);
		HList = factory.getManagerActionImpl().ManagerLibHistory(name);
		Vector<Object> h = null;
		int n = 0;
		bookLibHistory H;
		if (HList==null) {
			return;
		}
		while (n<HList.size()) {
			H = (bookLibHistory)HList.get(n);
			if (H.getStatus()==1&&H.getLibDate()!=null) {
				h = new Vector<Object>();
				h.add(H.getBookLibHistory());
				h.add(H.getBook().getBid());
				h.add(H.getBook().getName());
				h.add(H.getReader().getRid());
				h.add(H.getReader().getAccounts());
				h.add(H.getLibDate());
				h.add(H.getReturnDate());
				DataManagerReturn.add(h);
			}
			n++;
		}
		HcolumnNames = new Vector<String>();
		HcolumnNames.add("��ʷ���");
		HcolumnNames.add("�鼮���");
		HcolumnNames.add("�鼮����");
		HcolumnNames.add("���߱��");
		HcolumnNames.add("�����û���");
		HcolumnNames.add("����ʱ��");
		HcolumnNames.add("�黹ʱ��");
	}
	private void addDataRootBookTable(){
		DataRootBook = new Vector<Vector<Object>>();
		bList = factory.getBookActionImpl().allBook();
		Vector<Object> b ;
		int n = 0;
		Book B;
		while (n<bList.size()) {
			B = (Book) bList.get(n);
			if (B.getStatus()==1||power!=0) {
				b = new Vector<Object>();
				b.add(B.getBid());
				b.add(B.getName());
				b.add(B.getbDate());
				b.add(B.getbPress());
				b.add(B.getbAuthor());
				b.add(B.getbValue());
				b.add(B.getBookKindsName());
				DataRootBook.add(b);
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
	private void addDataRootManagerTable(){
		DataRootManager = new Vector<Vector<Object>>();
		RMList = factory.getManagerActionImpl().selectAllManager();
		Vector<Object> rm;
		int n = 0;
		entity.Manager RM;
		while (n<RMList.size()) {
			RM = (entity.Manager)RMList.get(n);
			rm = new Vector<Object>();
			rm.add(RM.getMname());
			if (RM.getPowerLevel()==2) {
				rm.add("���Ȩ��");
			}else {
				rm.add("Ա��Ȩ��");
			}
			rm.add(RM.getLastLoginTime());
			DataRootManager.add(rm);
			n++;
		}
		RMcolumnNames = new Vector<String>();
		RMcolumnNames.add("Ա���˺�");
		RMcolumnNames.add("Ȩ�޵ȼ�");
		RMcolumnNames.add("����¼ʱ��");
	}
}

