import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.Locale;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
/**
 * 大工問題のメインクラス，基本的には外枠のWindowと内部フレーム3個を作成しているだけ．
 * @author kaiya
 *
 */
public class Main {
	/**
	 * 内部フレームを作成する補助メソッド
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
		
		// メニューバーを生成してframeにはりつける
		javax.swing.JMenuBar bar=new javax.swing.JMenuBar();
		frame.setJMenuBar(bar);
		// メニューを生成してバーにつける
		JMenu menu=new JMenu("File");
		bar.add(menu);
		menu.add(new RunAction(panel, wp));
		menu.add(new StopAction(panel, wp));
		menu.add(new ExitAction(panel));
		
		frame.setVisible(true);
		//frame.setResizable(false);
	}

}
