

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class sqlHelper {
	static PreparedStatement ps=null; //����ִ��SQL��ѯ���Ľӿ�
    static Connection ct=null;
    static ResultSet rs=null;
    
    static String driver="com.mysql.jdbc.Driver";
    static String str="jdbc:mysql://127.0.0.1:3306/tongxunlu?useSSL=false&serverTimezone=GMT";
    static String user="root";
    static String passwd="123456";
    
    
    //��ѯ
    public static ResultSet QueryExcute(String sql,String[] past){
    	try {
    		//����JDBC��������
    		Class.forName(driver);
    		Class.forName(driver);
    		Class.forName(driver);
			ct=DriverManager.getConnection(str,user,passwd);//��ȡ��JDBC������
			ps=ct.prepareStatement(sql);
			
			for(int i=0;i<past.length;i++){
				ps.setString(i+1,past[i]);
			}
			rs=ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rs;
    }
  
    public static  boolean UpdExcute(String sql,String[] past){
    	boolean b=true;
		//�������ݿ�
		try {
			Class.forName(driver);
			ct=DriverManager.getConnection(str,user,passwd);
			ps=ct.prepareStatement(sql);
			//���ʺŸ�ֵ
			for(int i=0;i<past.length;i++){
				ps.setString(i+1,past[i]);
			}
		
			//ִ�в���
			if(ps.executeUpdate()!=1){
				b=false;
				
			}
			
			
		} 
		catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
			b=false;
		}finally{
			try {
				if(ps!=null) ps.close();
				if(ct!=null) ct.close();
				} catch (Exception e3) {
				// TODO: handle exception
				e3.printStackTrace();
			}
		}
		
	
		return b;
		
    }

}
