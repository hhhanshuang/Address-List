/*
 * �����ݿ�Ĳ�����װ��ģ��
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.*;
public class sModel extends AbstractTableModel{//�����������
	   
        static Vector columnName=null;
	    static Vector rowData=null;
	    static PreparedStatement ps=null;//������� ��preparedStatement ������statement
	    static Connection connect=null;//�����������ݿ�
	    static ResultSet result=null;//��ѯ����з��ض���
	    //���ݿ������
	    static String driver="com.mysql.jdbc.Driver";
	    static String str="jdbc:mysql://127.0.0.1:3306/tongxunlu?useSSL=false&serverTimezone=GMT";
	    static String user="root";
	    static String passwd="123456";
	    public void checkTxl(String sql,String[] past){
	    	
	    	 columnName=new Vector();
	    	 
	     	 columnName.add("����");
	     	 columnName.add("����");
	     	 columnName.add("��ϵ�绰");
	     	 columnName.add("����");
	     	 columnName.add("����");
	     	 //�γ�һ���������Ķ�̬����
	     	
	     	try {
				result=sqlHelper.QueryExcute(sql, past);
				rowData=new Vector();
			
				while(result.next()){
					Vector hang=new Vector();
					hang.add(result.getString(1));
					hang.add(result.getString(2));
					hang.add(result.getString(3));
					hang.add(result.getString(4));
					hang.add(result.getString(5));
					hang.add(result.getString(6));
					
					
					rowData.add(hang);
					
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				try {
					if(result!=null) result.close();
					if(result!=null) result.close();
					if(ps!=null) ps.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();           //��¼�쳣
				}
				
			}
	     	
	    }

	 
	  
	 
	  //��������
	  
	public static boolean updStu(String sql,String[] past){
		return sqlHelper.UpdExcute(sql, past);
	}
	@Override
	//����
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnName.size();
	}

	@Override
	//����
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	//ĳ��ĳ�е�����
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)this.columnName.get(column);
	}

}
