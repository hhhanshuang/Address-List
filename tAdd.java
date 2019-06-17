
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class tAdd extends Dialog implements ActionListener{
	JPanel jp1,jp2,jp3;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5;
	JButton jb1,jb2;
	Connection ct=null;
	PreparedStatement ps=null;
	
	public tAdd(Frame owner,String title,boolean model){
		super(owner,title,model);
		this.setBackground(Color.blue);
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jl1=new JLabel("姓氏");
		jl2=new JLabel("名字");
		jl3=new JLabel("电话");
		jl4=new JLabel("邮箱");
		jl5=new JLabel("类别");
		
		
		
		jtf1=new JTextField(10);
		jtf2=new JTextField(10);
		jtf3=new JTextField(10);
		jtf4=new JTextField(10);
		jtf5=new JTextField(10);

		
		
		jb1=new JButton("新建联系人");
		jb1.addActionListener(this);
		jb2=new JButton("取消");
		jb2.addActionListener(this);
		
		//布局
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
		this.setLocationRelativeTo(null); 
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1)
		{//添加按钮
			String sql="insert into tongxunlu (姓氏,名字,邮箱,联系电话,分类) values (?,?,?,?,?)";
			String[] packet={jtf1.getText(),jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText()};
			
			if(!sModel.updStu(sql, packet)){
				JOptionPane.showMessageDialog(this,"添加失败");
			}
			this.dispose();
	}
		if(e.getSource()==jb2) {
			this.dispose();
		}
	
	}

	

}
