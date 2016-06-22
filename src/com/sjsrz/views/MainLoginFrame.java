package com.sjsrz.views;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainLoginFrame extends JFrame {
	JFrame parentFrame;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	
	/**
	 * @param title
	 */
	public MainLoginFrame(String title) { 
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
		MainLoginPanel loginPanel = new MainLoginPanel(); setContentPane(loginPanel); 
		//���ô���������ʾ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
		setResizable(false);
	}
	
	private class MainLoginPanel extends JPanel {
		//�����½����Panel�еĿؼ�Ԫ�ء�
		JLabel picLabel; 
		JButton stuLoginButton,tchLoginButton; 
		JPanel buttonPanel,infoPanel; 
		//��½����panel���죬�����пؼ�Ԫ��װ��������
		private class ButtonAction implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource().equals(stuLoginButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							StuLoginFrame frame = new StuLoginFrame("ѧ����½���");
						}
					});
					MainLoginFrame.this.dispose();
				}else{
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							TchLoginFrame frame = new TchLoginFrame("�̹���½���");
						}
					});
					MainLoginFrame.this.dispose();
				}
			}
		}
		
		public MainLoginPanel() { 
			//�������пؼ�����
			picLabel = new JLabel();
			stuLoginButton = new JButton("ѧ����½");
			tchLoginButton = new JButton("��ʦ��½"); 
			buttonPanel = new JPanel();
			infoPanel = new JPanel();
			
			//����StuLoginPanel����ΪBorderLayout��
			setLayout(new BorderLayout()); 
			//�������pic��login��Ϣ�ؼ������������ 
			//������infoPanel���ֹ�����ΪFlowLayout��
			infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
			picLabel.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT/2); 
			ImageIcon image = new ImageIcon(this.getClass().getResource("/images/top2.jpg")); 
			image.setImage(image.getImage().getScaledInstance( picLabel.getWidth(),picLabel.getHeight(), Image.SCALE_DEFAULT)); 
			picLabel.setIcon(image);
			infoPanel.add(picLabel);
			infoPanel.add(stuLoginButton); 
			infoPanel.add(tchLoginButton); 
			add(infoPanel,BorderLayout.CENTER);
			
			ButtonAction buttonAction = new ButtonAction();
			stuLoginButton.addActionListener(buttonAction);
			tchLoginButton.addActionListener(buttonAction);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainLoginFrame frame = new MainLoginFrame("��½������");
	}

}
