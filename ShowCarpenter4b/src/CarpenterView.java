import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Graphics;

/**
 * 大工のSwing上の表現，基本的にJPanelで，CardLayoutをつかって，保持する部品の有無をトグルする．
 * @author kaiya
 *
 */
public class CarpenterView extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel counter=new JLabel();
	private ToolView chi=new ToolView("chisel.gif");
	private ToolView ham=new ToolView("hammer.gif");
	private JLabel image;
	
	public CarpenterView(){
		super();
		this.setLayout(new BorderLayout());
		counter.setText(0+"");
		this.add(counter, BorderLayout.NORTH);
		chi.toggle();
		this.add(chi, BorderLayout.WEST);
		ham.toggle();
		this.add(ham, BorderLayout.EAST);
		image=new CLabel(new ImageIcon(getClass().getResource("carpenter.gif")));
		this.add(image, BorderLayout.SOUTH);
	}
	
	public void setCounter(int i){
		counter.setText(i+"");
		image.repaint();
	}
	
	public void toggleChisel(){
		chi.toggle();
	}
	
	public void toggleHammer(){
		ham.toggle();
	}
	class CLabel extends JLabel{
		private static final long serialVersionUID = 1L;

		public CLabel(Icon image) {
			super(image);
		}

		public void paint(Graphics g) {
			super.paint(g);
			g.drawString(counter.getText(), 10, 20);
		}
		
	}

}
