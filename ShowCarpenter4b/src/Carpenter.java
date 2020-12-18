/**
 * 大工さんの実体，コレがアクティブな要素(スレッド)として制御．
 * みてくれは，view クラスに凝縮．
 * @author kaiya
 *
 */
public class Carpenter extends Thread{
	private boolean quit=false;
	private java.util.Random ram=new java.util.Random();
	private int counter=0;
	private Tool mychi=null;
	private Tool myham=null;
	/**
	 * このクラスを表示するためのクラス
	 */
	private CarpenterView view;
	private Tool[] chi;
	private Tool[] ham;

	public Carpenter(CarpenterView v, Tool[] chi, Tool[] ham){
		super();
		view=v; this.chi=chi; this.ham=ham;
	}
	
	public void run(){
		while(!quit){
			if(mychi!=null && myham!=null){ // 双方の道具をもっていたら，作業して手放す
				counter++;
				try{ sleep(ram.nextInt(1200)); }catch(Exception e){}  // たたく時間
				view.setCounter(counter);
				synchronized(mychi){
					mychi.release();
					mychi.getView().toggle();
					view.toggleChisel();
					mychi=null;
				}
				synchronized(myham){
					myham.release();
					myham.getView().toggle();
					view.toggleHammer();
					myham=null;
				}
				continue;
			}
			if(mychi==null){ // もし，ノミがなかったら，あいてるノミを検索して取得をめざす
				try{ sleep(ram.nextInt(800)); }catch(Exception e){} // ノミを探す時間
				for(int i=0; i<chi.length; i++){
					synchronized(chi[i]){
						if(chi[i].testAndUse()) {
							mychi=chi[i];
							mychi.getView().toggle();
							view.toggleChisel();
							break;
						}
					}
				}
			}
			// else // ★ ココがコメントアウトされているとデッドロックする．
			if(myham==null){ // もし，トンカチがなかったら・・・同上
				try{ sleep(ram.nextInt(1000)); }catch(Exception e){} // トンカチを探す時間
				for(int i=0; i<ham.length; i++){
					synchronized(ham[i]){
						if(ham[i].testAndUse()) {
							myham=ham[i];
							myham.getView().toggle();
							view.toggleHammer();
							break;
						}
					}
				}
			}
			// System.out.println(mychi+" "+myham);
		}
		
	}
	
	/**
	 * スレッドを終わらせるためのスイッチ
	 */
	synchronized void quit(){
		quit=true;
	}
}
