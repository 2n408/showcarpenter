import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.CardLayout;

/**
 * �c�[���̌����ڂ𐶐�����N���X�Cgif�̃C���[�W�ƃJ�[�h���C�A�E�g�Ō����ڂ𐶐��D
 * @author kaiya
 *
 */
public class ToolView extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel label;
	private CardLayout clt=new CardLayout();
	
	public ToolView(String giffile){
		super();
		label=new JLabel(new ImageIcon(getClass().getResource(giffile)));
		this.add(label);
		this.add(new JLabel(""));
		// ���C�A�E�g�͌ォ��Z�b�g����Ȃ��ƃ_��
		this.setLayout(clt);
		clt.first(this);
	}

	public void toggle(){
		clt.next(this);
	}

}
