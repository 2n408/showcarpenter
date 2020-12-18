import javax.swing.JPanel;

/**
 * モデルおよびビューを統合管理する合成クラス
 * @author kaiya
 *
 */
public class WorkPlace {
	// ノミ，トンカチ，大工を見せるパネル群
	private JPanel chipanel;
	private JPanel hampanel;
	private JPanel carpanel;

	private boolean isRun=false;
	
	// 道具の数，この倍の数が大工の人数になる
	private int number=3;
	
	// 以下は主にモデル
	private Carpenter[] cars;
	private Tool[] chi;
	private Tool[] ham;

	public WorkPlace(JPanel chi, JPanel ham, JPanel car) {
		super();
		chipanel=chi;
		hampanel=ham;
		carpanel=car;
	}
	
	public int getNumber(){
		return number;
	}
	
	/**
	 * パネルをクリアするメソッド，数を変更して再実行する場合，画面をクリアにする必要があるため．
	 *
	 */
	public void clear(){
		chipanel.removeAll();
		hampanel.removeAll();
		carpanel.removeAll();
		
		validate();
		
		chipanel.repaint();
		hampanel.repaint();
		carpanel.repaint();
	}
	
	public void validate(){
		chipanel.validate();
		hampanel.validate();
		carpanel.validate();
	}
	
	/**
	 * 画面とモデルの初期化を行う．モデルが表示インスタンスが知っている．
	 * @param n 道具の数，大工はこの数の二倍
	 */
	public void init(int n){
		number=n;
		cars=new Carpenter[number*2];
		chi=new Tool[number];
		ham=new Tool[number];
		for(int i=0; i<number; i++){
			ToolView v=new ToolView("chisel.gif");
			chi[i]=new Tool(v);
			chipanel.add(v);
			v=new ToolView("hammer.gif");
			ham[i]=new Tool(v);
			hampanel.add(v);
		}
		//chipanel.validate();
		//hampanel.validate();
		for(int i=0; i<cars.length; i++){
			CarpenterView v=new CarpenterView();
			cars[i]=new Carpenter(v, chi, ham);
			carpanel.add(v);
		}
		//carpanel.validate();
		validate();
	}

	/**
	 * スレッドである大工をスタートさせる，これによって作業がはじまる．
	 *
	 */
	public void run(){
		if(cars==null) return;
		for(int i=0; i<cars.length; i++) cars[i].start();
		isRun=true;
	}
	
	/**
	 * 大工をストップさせる
	 *
	 */
	public void stop(){
		if(cars==null) return;
		for(int i=0; i<cars.length; i++) cars[i].quit();
		isRun=false;
		// 実は全スレッドが停止していることを保障できないのでマズい
		validate();
	}
	
	/**
	 * 動作中か否かを確認するメソッド，二重実行を避けるため．
	 * @return
	 */
	public boolean isRunning(){
		return isRun;
	}

}
