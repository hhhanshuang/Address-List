
 
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
 

public class login {
	
	//主函数入口
	public static void main(String args[]) {
		login l=new login();
		l.showUI();
	}
	
	public void showUI() {
		javax.swing.JFrame jf=new javax.swing.JFrame();
	
		jf.setTitle("欢迎使用通讯录");
		jf.setSize(340,500);
		jf.setDefaultCloseOperation(3);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
 
		
		java.awt.FlowLayout fl=new java.awt.FlowLayout(FlowLayout.CENTER,5,5);
		jf.setLayout(fl);
		java.awt.Dimension dim1=new java.awt.Dimension(340,300);
		java.awt.Dimension dim2=new java.awt.Dimension(50, 50);
		java.awt.Dimension dim3=new java.awt.Dimension(250, 30);		
		java.awt.Dimension dim4=new java.awt.Dimension(100, 40);	
		
		
		javax.swing.ImageIcon icon=new javax.swing.ImageIcon("D:\\Q.png");
		JLabel labpic=new JLabel(icon);
		jf.add(labpic);
		jf.getContentPane().setBackground(Color.yellow);
	
		JLabel labname=new JLabel();
		labname.setText("账号：");
		labname.setPreferredSize(dim2);
		jf.add(labname);
		
		
		JTextField textname=new JTextField();
		textname.setPreferredSize(dim3);
		jf.add(textname);
		
		
		JLabel labpassword=new JLabel();
		labpassword.setText("密码：");
		labpassword.setPreferredSize(dim2);
		jf.add(labpassword);
		
		
		JPasswordField jp=new JPasswordField();
		jp.setPreferredSize(dim3);
		jf.add(jp);
		
	
		javax.swing.JButton button=new javax.swing.JButton();
		button.setText("登录");
		button.setPreferredSize(dim4);
		jf.add(button);
		
		jf.setVisible(true);
		
		
		LoginListener ll=new LoginListener(jf,textname,jp);
	
		button.addActionListener(ll);
	}
}
