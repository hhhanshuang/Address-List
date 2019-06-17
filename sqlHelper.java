

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class sqlHelper {
	static PreparedStatement ps=null; //用于执行SQL查询语句的接口
    static Connection ct=null;
    static ResultSet rs=null;
    
    static String driver="com.mysql.jdbc.Driver";
    static String str="jdbc:mysql://127.0.0.1:3306/tongxunlu?useSSL=false&serverTimezone=GMT";
    static String user="root";
    static String passwd="123456";
    
    
    //查询
    public static ResultSet QueryExcute(String sql,String[] past){
    	try {
    		//加载JDBC驱动程序
    		Class.forName(driver);
    		Class.forName(driver);
    		Class.forName(driver);
			ct=DriverManager.getConnection(str,user,passwd);//获取与JDBC的连接
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
		//连接数据库
		try {
			Class.forName(driver);
			ct=DriverManager.getConnection(str,user,passwd);
			ps=ct.prepareStatement(sql);
			//给问号赋值
			for(int i=0;i<past.length;i++){
				ps.setString(i+1,past[i]);
			}
		
			//执行操作
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
