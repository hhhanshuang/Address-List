
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
public class TXLmain extends JFrame implements ActionListener{

	//����ؼ�
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
		//�ϲ�
		jp1=new JPanel();
		jp1.setBackground(Color.pink);
		jl1=new JLabel("��ϵ��������");
		jtf=new JTextField(10);
		jb1=new JButton("��ѯ");
		jb1.addActionListener(this);
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		//�²�
		jp2=new JPanel();
		jb2=new JButton("�½���ϵ��");
		jb2.addActionListener(this);
		jb3=new JButton("ɾ����ϵ��");
		jb3.addActionListener(this);
		jb4=new JButton("�޸���ϵ����Ϣ");
		jb4.addActionListener(this);
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.setBackground(Color.orange);

		//�������ݿ�ģ��ʵ����
	    sm=new sModel();
	    String[] past={"1"};
	    sm.checkTxl("select * from tongxunlu where 1=?  order by ����",past);
		jt=new JTable(sm);
		jsp=new JScrollPane(jt);
		//�������
		this.add(jsp);//?
		this.add(jp1, "North");
		this.add(jp2,"South");
		this.setTitle("ͨѶ¼");
		this.setSize(800,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//��������
		if(e.getSource()==jb1){
			String name=jtf.getText();
			if(name!=null){
				String sql="select * from tongxunlu where ����=?";
				String[] past={name};
			   
		    
			//����Jtable
		   sm=new sModel();
		   sm.checkTxl(sql, past);
		    
		    
			jt.setModel(sm);
			}
			
			}
		     //�������
		     else if(e.getSource()==jb2){
				tAdd add=new tAdd(this, "��Ӽ�¼", true);
				
				//����Jtable
				 sm=new sModel();
				 String[] past={"1"};
				 sm.checkTxl("select * from tongxunlu where 1=? order by ����", past);
				jt.setModel(sm);
				
		}
		     //ɾ������
		     else if(e.getSource()==jb3){
		    	 //�õ�ѡ�е���������
		    	 //���򷵻�-1
		    	 int rowNum=this.jt.getSelectedRow();
		    	 if(rowNum==-1){
		    		 JOptionPane.showMessageDialog(this, "��ѡ��һ��");
		    		 return ;
		    	 }else{
		    		 String idtongxunlu=sm.getValueAt(rowNum, 5).toString();
		    		 String sql="delete from tongxunlu where idtongxunlu=?";
		    		 String[] past={idtongxunlu};
//					 sModel temp=new sModel();	
					 if(!sModel.updStu(sql, past)){
						 JOptionPane.showMessageDialog(this, "ɾ��ʧ��");
						 
					 }
					
						//����Jtable
						 sm=new sModel();
						 String[] past2={"1"};
						 sm.checkTxl("select * from tongxunlu where 1=? order by ����", past2);
						jt.setModel(sm);
						
		     }
		     }
		    //��������
		     else  if(e.getSource()==jb4){
		    	 sm=new sModel();
		    	 int rowNum=this.jt.getSelectedRow();
		    	 if(rowNum==-1){
		    		 JOptionPane.showMessageDialog(this, "��ѡ��һ��");
		    		 return ;
		    	 }else{
		    		 tUpd add=new tUpd(this, "���¼�¼", true,sm,rowNum);
					
					//����Jtable
					
		    	    sm=new sModel();
		    	    String[] past={"1"};
		    	    sm.checkTxl("select * from tongxunlu where 1=? order by ����", past);
					jt.setModel(sm);
		     }
		     }
	
		
	}
	
}



