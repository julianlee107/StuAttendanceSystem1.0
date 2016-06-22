package com.sjsrz.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SearchStuFrame extends JFrame{
	JFrame parentFrame;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	
	public SearchStuFrame(String title) { 
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
		SearchStuPanel loginPanel = new SearchStuPanel(); 
		setContentPane(loginPanel); 
		//���ô���������ʾ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
		setResizable(false);
	}
	
	private class SearchStuPanel extends JPanel {
		//�����½����Panel�еĿؼ�Ԫ�ء�
		JLabel titleOLabel,titleTLabel;
		JButton searchButton,backButton,reButton;
		JTextField keyword;
		JComboBox<String> styleBox;
		JPanel buttonPanel,infoPanel; 
		//��½����panel���죬�����пؼ�Ԫ��װ��������
		private class ButtonAction implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource().equals(backButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							TchFuncPortalFrame frame = new TchFuncPortalFrame("ѧ����½���");
						}
					});
					SearchStuFrame.this.dispose();
				}else if(e.getSource().equals(reButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							keyword.setText("");
						}
					});
				}
			}
		}
		
		public SearchStuPanel() { 
			//�������пؼ�����
			String t1 = "��ѡ���ѯ��ʽ";
			titleOLabel = new JLabel(t1);
			styleBox = new JComboBox<>();
			styleBox.addItem("��������ѯ");
			styleBox.addItem("��ѧ�Ų�ѯ");
			String t2 = "�������ѯ�ؼ���";
			titleTLabel = new JLabel(t2);
			keyword = new JTextField();
			searchButton = new JButton("��ѯ");
			reButton = new JButton("���¿�ʼ��ѯ");
			backButton = new JButton("�����ϼ�"); 
			buttonPanel = new JPanel();
			infoPanel = new JPanel();
			
			//����StuLoginPanel����ΪBorderLayout��
			setLayout(new BorderLayout()); 
			//�������pic��login��Ϣ�ؼ������������ 
			//������infoPanel���ֹ�����ΪFlowLayout��
			infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
			infoPanel.add(titleOLabel); 
			infoPanel.add(styleBox); 
			infoPanel.add(titleTLabel); 
			infoPanel.add(keyword); 
			infoPanel.add(searchButton); 
			infoPanel.add(reButton); 
			infoPanel.add(backButton); 
			add(infoPanel,BorderLayout.CENTER);
			
			ButtonAction buttonAction = new ButtonAction();
			backButton.addActionListener(buttonAction);
			searchButton.addActionListener(buttonAction);
			reButton.addActionListener(buttonAction);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchStuFrame frame = new SearchStuFrame("��½������");
	}
}
