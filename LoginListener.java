import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
 
public class LoginListener implements ActionListener{
 
	private javax.swing.JTextField jt;
	private javax.swing.JPasswordField jp;
	
	
	
	private javax.swing.JFrame login;
	public LoginListener(javax.swing.JFrame login,javax.swing.JTextField jt,javax.swing.JPasswordField jp) {
		this.login=login;
		this.jt=jt;
		this.jp=jp;
	}
 
	public void actionPerformed(ActionEvent e) {
		
		if(jt.getText().equals("HZF")&&jp.getText().equals("123")) {
			TXLmain txl=new TXLmain();
			login.dispose();
		}
		else {
			JOptionPane.showMessageDialog(login,"用户名或密码错误,请重新输入"); 
			
		}
	}
}