import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

/**
 * ��H��Ƃ��~�����邽�߂̃A�N�V�����C�ꉞ�C�m�F�̃_�C�����O���o��D
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
	 * �I�΂ꂽ�Ƃ��̓���
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

