/*
 * ��������
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class tUpd extends Dialog implements ActionListener{
	JPanel jp1,jp2,jp3;
	JLabel jl6,jl1,jl2,jl3,jl4,jl5;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;
	JButton jb1,jb2;
	Connection ct=null;
	PreparedStatement ps=null;
	
	public tUpd(Frame owner,String title,boolean model,sModel sm,int rowcount){
		super(owner,title,model);
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		

		jl1=new JLabel("����");
		jl2=new JLabel("����");
		jl3=new JLabel("��ϵ�绰");
		jl4=new JLabel("����");
		jl5=new JLabel("����");
		
		jtf1=new JTextField(10);
		jtf2=new JTextField(10);
		jtf3=new JTextField(10);
		jtf4=new JTextField(10);
		jtf5=new JTextField(10);
		jtf6=new JTextField(10);
		
		
		jtf1.setText((String)sm.getValueAt(rowcount, 0));
		jtf2.setText(sm.getValueAt(rowcount, 1).toString());
		jtf3.setText((String)sm.getValueAt(rowcount, 2));
		jtf4.setText((String)sm.getValueAt(rowcount,3));
		jtf5.setText((String)sm.getValueAt(rowcount,4));
		jtf6.setText((String)sm.getValueAt(rowcount,5));

		
		jb1=new JButton("����");
		jb1.addActionListener(this);
		jb2=new JButton("ȡ��");
		jb2.addActionListener(this);
		
		//����
		jp1.setLayout(new GridLayout(5,1));
		jp2.setLayout(new GridLayout(5,1));
		

		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		
		this.setSize(300,200);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1){
			String sql="update tongxunlu set ����=?,����=?,��ϵ�绰=?,����=?,����=? where idtongxunlu=?";
			String[] past={jtf1.getText(),jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText(),jtf6.getText() };
		
			if(!sModel.updStu(sql, past)){
				JOptionPane.showMessageDialog(this,"����ʧ��");
			}
			this.dispose();
	}
		if(e.getSource()==jb2) {
			this.dispose();
		}
	}

	

}

