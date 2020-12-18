import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.Locale;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
/**
 * ��H���̃��C���N���X�C��{�I�ɂ͊O�g��Window�Ɠ����t���[��3���쐬���Ă��邾���D
 * @author kaiya
 *
 */
public class Main {
	/**
	 * �����t���[�����쐬����⏕���\�b�h
	 */
	public static JPanel genInternalFrame(JDesktopPane desk, String name, int w, int h, int x, int y){
		JInternalFrame iframe=new JInternalFrame(name);
		iframe.setSize(w,h);
		iframe.setLocation(x,y);
		iframe.setVisible(true);
		iframe.setClosable(false);
		iframe.setResizable(true);
		JPanel cpanel=new JPanel();
		iframe.setContentPane(cpanel);
		desk.add(iframe);
		return cpanel;
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);
		
		JFrame frame=new JFrame("Working Carpenters (Swing Version 4)");
		JPanel panel=(JPanel)frame.getContentPane();
		frame.setSize(1010,660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JDesktopPane desk=new JDesktopPane();
		panel.add(desk, BorderLayout.CENTER);
		
		JPanel cpanel=genInternalFrame(desk, "chisel", 500, 300, 0, 0);
		JPanel hpanel=genInternalFrame(desk, "hammer", 500, 300, 500, 0);
		JPanel mpanel=genInternalFrame(desk, "carpenters", 1000, 300, 0, 300);
		
		WorkPlace wp=new WorkPlace(cpanel, hpanel, mpanel);
		
		// ���j���[�o�[�𐶐�����frame�ɂ͂����
		javax.swing.JMenuBar bar=new javax.swing.JMenuBar();
		frame.setJMenuBar(bar);
		// ���j���[�𐶐����ăo�[�ɂ���
		JMenu menu=new JMenu("File");
		bar.add(menu);
		menu.add(new RunAction(panel, wp));
		menu.add(new StopAction(panel, wp));
		menu.add(new ExitAction(panel));
		
		frame.setVisible(true);
		//frame.setResizable(false);
	}

}
