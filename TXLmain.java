
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
public class TXLmain extends JFrame implements ActionListener{

	//定义控件
	JPanel jp1,jp2;
	JLabel jl1;
	JButton jb1,jb2,jb3,jb4;
	JTextField jtf;
	 JTable jt=null;
     JScrollPane jsp=null;
     sModel sm;
     
     PreparedStatement ps=null;
	    Connection ct=null;
/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		TXLmain txl=new TXLmain();

	

	}*/
	
	public TXLmain(){
		//上部
		jp1=new JPanel();
		jp1.setBackground(Color.pink);
		jl1=new JLabel("联系人姓名：");
		jtf=new JTextField(10);
		jb1=new JButton("查询");
		jb1.addActionListener(this);
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		//下部
		jp2=new JPanel();
		jb2=new JButton("新建联系人");
		jb2.addActionListener(this);
		jb3=new JButton("删除联系人");
		jb3.addActionListener(this);
		jb4=new JButton("修改联系人信息");
		jb4.addActionListener(this);
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.setBackground(Color.orange);

		//创建数据库模型实例、
	    sm=new sModel();
	    String[] past={"1"};
	    sm.checkTxl("select * from tongxunlu where 1=?  order by 分类",past);
		jt=new JTable(sm);
		jsp=new JScrollPane(jt);
		//加入面板
		this.add(jsp);//?
		this.add(jp1, "North");
		this.add(jp2,"South");
		this.setTitle("通讯录");
		this.setSize(800,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//搜索数据
		if(e.getSource()==jb1){
			String name=jtf.getText();
			if(name!=null){
				String sql="select * from tongxunlu where 姓氏=?";
				String[] past={name};
			   
		    
			//更新Jtable
		   sm=new sModel();
		   sm.checkTxl(sql, past);
		    
		    
			jt.setModel(sm);
			}
			
			}
		     //添加数据
		     else if(e.getSource()==jb2){
				tAdd add=new tAdd(this, "添加记录", true);
				
				//更新Jtable
				 sm=new sModel();
				 String[] past={"1"};
				 sm.checkTxl("select * from tongxunlu where 1=? order by 分类", past);
				jt.setModel(sm);
				
		}
		     //删除数据
		     else if(e.getSource()==jb3){
		    	 //得到选中的那行数据
		    	 //否则返回-1
		    	 int rowNum=this.jt.getSelectedRow();
		    	 if(rowNum==-1){
		    		 JOptionPane.showMessageDialog(this, "请选择一行");
		    		 return ;
		    	 }else{
		    		 String idtongxunlu=sm.getValueAt(rowNum, 5).toString();
		    		 String sql="delete from tongxunlu where idtongxunlu=?";
		    		 String[] past={idtongxunlu};
//					 sModel temp=new sModel();	
					 if(!sModel.updStu(sql, past)){
						 JOptionPane.showMessageDialog(this, "删除失败");
						 
					 }
					
						//更新Jtable
						 sm=new sModel();
						 String[] past2={"1"};
						 sm.checkTxl("select * from tongxunlu where 1=? order by 分类", past2);
						jt.setModel(sm);
						
		     }
		     }
		    //更新数据
		     else  if(e.getSource()==jb4){
		    	 sm=new sModel();
		    	 int rowNum=this.jt.getSelectedRow();
		    	 if(rowNum==-1){
		    		 JOptionPane.showMessageDialog(this, "请选择一行");
		    		 return ;
		    	 }else{
		    		 tUpd add=new tUpd(this, "更新记录", true,sm,rowNum);
					
					//更新Jtable
					
		    	    sm=new sModel();
		    	    String[] past={"1"};
		    	    sm.checkTxl("select * from tongxunlu where 1=? order by 分类", past);
					jt.setModel(sm);
		     }
		     }
	
		
	}
	
}



