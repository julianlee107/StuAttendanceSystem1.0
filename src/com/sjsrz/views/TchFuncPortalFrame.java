package com.sjsrz.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class TchFuncPortalFrame extends JFrame {
	JFrame parentFrame;
	private JPanel contentPane;
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 450;
	
	public TchFuncPortalFrame(String title) { 
		//���ô����С
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT); 
		//���ô������
		setTitle(title); 
		//��ʾλ������Ļ���ȺͿ�ȵ�1/3����
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize(); 
		int screenWidthpx = screenSize.width;
		int screenHeightpx = screenSize.height; 
		setLocation(screenWidthpx / 3, screenHeightpx / 3); 
		setLocationByPlatform(false); 
		//���ô�����С��ʱ��ʾ��ͼ�꣬��ѡ��
		Image img = new ImageIcon(this.getClass(). getResource("/images/001.jpg")).getImage(); 
		setIconImage(img);
		//���ô����������壬�������������е���ЧGUI�����Ϣ
		TchFuncPortalPanel loginPanel = new TchFuncPortalPanel(); 
		setContentPane(loginPanel); 
		//���ô���������ʾ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
		setResizable(false);
	}
	
	private class TchFuncPortalPanel extends JPanel {
		//�����½����Panel�еĿؼ�Ԫ�ء�
		JLabel picLabel,idLabel,wordT; 
		JButton lookPButton,upPButton,upPwdButton,lookSButton,searchCheckButton,checkInButton,upCheckButton,searchButton; 
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
							TchPersonFrame frame = new TchPersonFrame("ѧ����½���");
						}
					});
					TchFuncPortalFrame.this.dispose();
				}else if(e.getSource().equals(upPButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							UpdateTchPerFrame frame = new UpdateTchPerFrame("ѧ����½���");
						}
					});
					TchFuncPortalFrame.this.dispose();
				}else if(e.getSource().equals(upPwdButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							UpdateTchPwdFrame frame = new UpdateTchPwdFrame("ѧ����½���");
						}
					});
					TchFuncPortalFrame.this.dispose();
				}else if(e.getSource().equals(lookSButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							SearchStuFrame frame = new SearchStuFrame("ѧ����½���");
						}
					});
					TchFuncPortalFrame.this.dispose();
				}else if(e.getSource().equals(searchCheckButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							SearchCheckFrame frame = new SearchCheckFrame("ѧ����½���");
						}
					});
					TchFuncPortalFrame.this.dispose();
				}else if(e.getSource().equals(checkInButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							CheckInFrame frame = new CheckInFrame("ѧ����½���");
						}
					});
					TchFuncPortalFrame.this.dispose();
				}else if(e.getSource().equals(upCheckButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							UpdateCheckFrame frame = new UpdateCheckFrame("ѧ����½���");
						}
					});
					TchFuncPortalFrame.this.dispose();
				}else if(e.getSource().equals(searchButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							
						}
					});
				}
			}
		}
		
		public TchFuncPortalPanel() { 
			//�������пؼ�����
			picLabel = new JLabel();
			String t1 = "ee";
			idLabel = new JLabel(t1);
			String t2 = "������Ҫ��ѯ���ڼ�¼�Ŀγ̱��:";
			wordT = new JLabel(t2);
			lookPButton = new JButton("�鿴������Ϣ");
			upPButton = new JButton("�޸ĸ�����Ϣ");
			upPwdButton = new JButton("�޸ĸ�������");
			lookSButton = new JButton("�鿴ѧ����Ϣ");
			searchCheckButton = new JButton("�鿴������Ϣ");
			checkInButton = new JButton("¼�뿼����Ϣ");
			upCheckButton = new JButton("�޸Ŀ�����Ϣ");
			searchButton = new JButton("����");
			lessonId = new JTextField();
			rs = new JTable();
			
			buttonPanel = new JPanel();
			infoPanel = new JPanel();
			
			//����StuLoginPanel����ΪBorderLayout��
			setLayout(new BorderLayout()); 
			//�������pic��login��Ϣ�ؼ������������ 
			//������infoPanel���ֹ�����ΪFlowLayout��
			infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			picLabel.setSize(100, 100); 
			ImageIcon image = new ImageIcon(this.getClass().getResource("/images/top2.jpg")); 
			image.setImage(image.getImage().getScaledInstance( picLabel.getWidth(),picLabel.getHeight(), Image.SCALE_DEFAULT)); 
			picLabel.setIcon(image);
			picLabel.setBounds(150, 20, 100, 100);
			infoPanel.add(picLabel);
			idLabel.setBounds(150, 140, 120, 30);
			infoPanel.add(idLabel);
			lookPButton.setBounds(150, 160, 120, 30);
			infoPanel.add(lookPButton);			
			upPButton.setBounds(150, 80, 120, 30);
			infoPanel.add(upPButton);
			upPwdButton.setBounds(150, 100, 120, 30);
			infoPanel.add(upPwdButton);
			lookSButton.setBounds(150, 120, 120, 30);
			infoPanel.add(lookSButton);
			searchCheckButton.setBounds(150, 140, 120, 30);
			infoPanel.add(searchCheckButton);
			checkInButton.setBounds(150, 140, 120, 30);
			infoPanel.add(checkInButton);
			upCheckButton.setBounds(150, 140, 120, 30);
			infoPanel.add(upCheckButton);
			wordT.setBounds(150, 160, 120, 30);
			infoPanel.add(wordT);
			lessonId.setBounds(150, 180, 120, 30);
			infoPanel.add(lessonId);
			searchButton.setBounds(150, 200, 120, 30);
			infoPanel.add(searchButton);	
			rs.setBounds(150, 220, 120, 30);
			infoPanel.add(rs);
			add(infoPanel,BorderLayout.CENTER);
			
	
			
			ButtonAction buttonAction = new ButtonAction();
			lookPButton.addActionListener(buttonAction);
			upPButton.addActionListener(buttonAction);
			lookSButton.addActionListener(buttonAction);
			searchCheckButton.addActionListener(buttonAction);
			checkInButton.addActionListener(buttonAction);
			upCheckButton.addActionListener(buttonAction);
			upPwdButton.addActionListener(buttonAction);
			searchButton.addActionListener(buttonAction);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TchFuncPortalFrame frame = new TchFuncPortalFrame("ѧ������ϵͳ");
	}
}

