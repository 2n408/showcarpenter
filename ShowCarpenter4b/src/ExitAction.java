import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

/**
 * �I���̂��߂̃A�N�V����
 */
public class ExitAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	
	public ExitAction(JPanel p){
		panel=p;
		putValue(Action.NAME, "Exit");
	}
	
	/**
	 * �I�΂ꂽ�Ƃ��̓���
	 */
	public void actionPerformed(ActionEvent e) {
		int ans=JOptionPane.showConfirmDialog(panel, "Really?", "EXIT", JOptionPane.YES_NO_OPTION);
		if(ans==0) System.exit(1);
	}

}

