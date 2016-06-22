package com.sjsrz.views;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SearchCheckFrame extends JFrame {
	JFrame parentFrame;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	
	public SearchCheckFrame(String title) { 
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
		Image img = new ImageIcon(this.getClass(). getResource("/images/001.jpg")).getImage(); setIconImage(img);
		//���ô����������壬�������������е���ЧGUI�����Ϣ
		SearchCheckPanel loginPanel = new SearchCheckPanel(); 
		setContentPane(loginPanel); 
		//���ô���������ʾ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
		setResizable(false);
	}
	
	private class SearchCheckPanel extends JPanel {
		//�����½����Panel�еĿؼ�Ԫ�ء�
		
		JButton backButton; 
		JPanel buttonPanel,infoPanel; 
		//��½����panel���죬�����пؼ�Ԫ��װ��������
		private class ButtonAction implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource().equals(backButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							TchFuncPortalFrame frame = new TchFuncPortalFrame("�̹���½���");
						}
					});
					SearchCheckFrame.this.dispose();
				}
			}
		}
		
		public SearchCheckPanel() { 
			//�������пؼ�����
			
			
			backButton = new JButton("�����ϼ�"); 
			buttonPanel = new JPanel();
			infoPanel = new JPanel();
			
			//����StuLoginPanel����ΪBorderLayout��
			setLayout(new BorderLayout()); 
			//�������pic��login��Ϣ�ؼ������������ 
			//������infoPanel���ֹ�����ΪFlowLayout��
			infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
			infoPanel.add(backButton); 
			add(infoPanel,BorderLayout.CENTER);
			
			ButtonAction buttonAction = new ButtonAction();
			backButton.addActionListener(buttonAction);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchCheckFrame frame = new SearchCheckFrame("��½������");
	}
}
