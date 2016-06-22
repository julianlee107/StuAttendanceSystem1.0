package com.sjsrz.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class test extends JFrame{
	JFrame parentFrame;
	private JPanel contentPane;
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 450;
	
	public test(String title) { 
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize(); 
		int screenWidthpx = screenSize.width;
		int screenHeightpx = screenSize.height; 
		setBounds(screenWidthpx / 3, screenHeightpx / 3, DEFAULT_WIDTH, DEFAULT_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//���ô������
		setTitle(title); 
		//���ô�����С��ʱ��ʾ��ͼ�꣬��ѡ��
		//Image img = new ImageIcon(this.getClass(). getResource("/images/001.jpg")).getImage(); 
		//setIconImage(img);
		//���ô����������壬�������������е���ЧGUI�����Ϣ
		testPanel loginPanel = new testPanel(); 
		//setContentPane(loginPanel); 
		//���ô���������ʾ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
		setResizable(false);
	}

	private class testPanel extends JPanel{
		//�����½����Panel�еĿؼ�Ԫ�ء�
		JLabel picLabel,idLabel,wordT; 
		JButton lookPButton,upPButton,upPwdButton,lookTButton,lookLButton,searchButton; 
		JTextField lessonId;
		JTable rs;
		JPanel buttonPanel,infoPanel; 
		//��½����panel���죬�����пؼ�Ԫ��װ��������
		private class ButtonAction implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource().equals(lookPButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							StuPersonFrame frame = new StuPersonFrame("ѧ����½���");
						}
					});
					test.this.dispose();
				}else if(e.getSource().equals(upPwdButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							UpdateStuPwdFrame frame = new UpdateStuPwdFrame("�̹���½���");
						}
					});
					test.this.dispose();
					}else if(e.getSource().equals(upPButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							UpdateStuPerFrame frame = new UpdateStuPerFrame("�̹���½���");
						}
					});
					test.this.dispose();
					}else if(e.getSource().equals(lookTButton)){
						EventQueue.invokeLater(new Runnable(){
							public void run(){
								SearchTchFrame frame = new SearchTchFrame("�̹���½���");
							}
						});
						test.this.dispose();
						}else if(e.getSource().equals(lookLButton)){
							EventQueue.invokeLater(new Runnable(){
								public void run(){
									SearchLessonFrame frame = new SearchLessonFrame("�̹���½���");
								}
							});
							test.this.dispose();
							}else if(e.getSource().equals(searchButton)){
								EventQueue.invokeLater(new Runnable(){
									public void run(){
										
									}
								});
								}
			}
		}
		
		public testPanel() { 
			//�������пؼ�����
			picLabel = new JLabel();
			String t1 = "ee";
			idLabel = new JLabel(t1);
			String t2 = "������Ҫ��ѯ���ڼ�¼�Ŀγ̱��:";
			wordT = new JLabel(t2);
			lookPButton = new JButton("�鿴������Ϣ");
			upPButton = new JButton("�޸ĸ�����Ϣ");
			upPwdButton = new JButton("�޸ĸ�������");
			lookTButton = new JButton("�鿴��ʦ��Ϣ");
			lookLButton = new JButton("�鿴�γ���Ϣ");
			searchButton = new JButton("����");
			lessonId = new JTextField();
			rs = new JTable();
			
			
			idLabel.setBounds(20, 140, 120, 30);
			contentPane.add(idLabel);
			lookPButton.setBounds(20, 180, 100, 20);
			contentPane.add(lookPButton);			
			upPButton.setBounds(20, 210, 100, 20);
			contentPane.add(upPButton);
			upPwdButton.setBounds(20, 240, 100, 20);
			contentPane.add(upPwdButton);
			lookTButton.setBounds(20, 270, 100, 20);
			contentPane.add(lookTButton);
			lookLButton.setBounds(20, 300, 100, 20);
			contentPane.add(lookLButton);
			wordT.setBounds(150, 20, 100, 20);
			contentPane.add(wordT);
			lessonId.setBounds(150, 50, 100, 20);
			contentPane.add(lessonId);
			searchButton.setBounds(270, 50, 100, 20);
			contentPane.add(searchButton);	
			rs.setBounds(150, 80, 100, 20);
			contentPane.add(rs);
			
			ButtonAction buttonAction = new ButtonAction();
			lookPButton.addActionListener(buttonAction);
			upPButton.addActionListener(buttonAction);
			lookTButton.addActionListener(buttonAction);
			lookLButton.addActionListener(buttonAction);
			upPwdButton.addActionListener(buttonAction);
			searchButton.addActionListener(buttonAction);
		}
	}
		
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test frame = new test("ѧ������ϵͳ");
	}

}
