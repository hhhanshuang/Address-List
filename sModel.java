/*
 * 对数据库的操作封装成模型
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
public class sModel extends AbstractTableModel{//处理表格的能力
	   
        static Vector columnName=null;
	    static Vector rowData=null;
	    static PreparedStatement ps=null;//提高性能 用preparedStatement 而不是statement
	    static Connection connect=null;//用于连接数据库
	    static ResultSet result=null;//查询结果中返回对象
	    //数据库的连接
	    static String driver="com.mysql.jdbc.Driver";
	    static String str="jdbc:mysql://127.0.0.1:3306/tongxunlu?useSSL=false&serverTimezone=GMT";
	    static String user="root";
	    static String passwd="123456";
	    public void checkTxl(String sql,String[] past){
	    	
	    	 columnName=new Vector();
	    	 
	     	 columnName.add("姓氏");
	     	 columnName.add("名字");
	     	 columnName.add("联系电话");
	     	 columnName.add("邮箱");
	     	 columnName.add("分类");
	     	 //形成一个可增长的动态数组
	     	
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
					e2.printStackTrace();           //记录异常
				}
				
			}
	     	
	    }

	 
	  
	 
	  //更新数据
	  
	public static boolean updStu(String sql,String[] past){
		return sqlHelper.UpdExcute(sql, past);
	}
	@Override
	//列数
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnName.size();
	}

	@Override
	//行数
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	//某列某行的数据
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
