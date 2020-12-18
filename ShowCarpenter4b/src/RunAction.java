import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerModel;

/**
 * 大工に作業を開始させるアクション
 */
public class RunAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private WorkPlace wp;
	
	/**
	 * @param p ダイヤログを出すための親コンテナ
	 * @param wp 他の部品が配置されている合成部品
	 */
	public RunAction(JPanel p, WorkPlace wp){
		panel=p;
		this.wp=wp;
		putValue(Action.NAME, "Run");
	}
	
	/**
	 * 選ばれたときの動作
	 */
	public void actionPerformed(ActionEvent e) {
		if(wp.isRunning()){
			JOptionPane.showMessageDialog(panel, "Already Running!");
			return;
		}
		SpinnerModel sm=new SpinnerNumberModel(wp.getNumber(), 2, 20, 1);
		int ans=JOptionPane.showConfirmDialog(panel, 
				new JSpinner(sm), "How many tools for each?", JOptionPane.YES_NO_OPTION);
		if(ans!=0) return; // NO
		int num=Integer.parseInt(sm.getValue().toString());
		
		wp.clear();
		wp.init(num);
		wp.run();
	}

}

