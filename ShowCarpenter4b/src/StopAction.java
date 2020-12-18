import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

/**
 * 大工作業を停止させるためのアクション，一応，確認のダイヤログが出る．
 */
public class StopAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private WorkPlace wp;
	
	public StopAction(JPanel p, WorkPlace wp){
		panel=p;
		this.wp=wp;
		putValue(Action.NAME, "Stop");
	}
	
	/**
	 * 選ばれたときの動作
	 */
	public void actionPerformed(ActionEvent e) {
		if(!wp.isRunning()){
			JOptionPane.showMessageDialog(panel, "Not Running!");
			return;
		}
		int ans=JOptionPane.showConfirmDialog(panel, "Really Stop?", "Stop", JOptionPane.YES_NO_OPTION);
		if(ans==0) wp.stop();
	}

}

