import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.CardLayout;

/**
 * ツールの見た目を生成するクラス，gifのイメージとカードレイアウトで見た目を生成．
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
		// レイアウトは後からセットじゃないとダメ
		this.setLayout(clt);
		clt.first(this);
	}

	public void toggle(){
		clt.next(this);
	}

}
