/** 
 * 排他的に利用(占有)される道具のクラス
 * synchronizedブロックを利用を意図しているため，メソッドはsynchronizedされていない．
 * */
public class Tool{
/** 利用されているか否かをの情報，利用されてると真 */
private boolean used=false;
private ToolView tv;

	public Tool(ToolView tv){
		this.tv=tv;
	}
	
	public ToolView getView(){
		return tv;
	}

    /** 利用されているか否かをチェック */
    public boolean isUsed(){ return used; }

    /* synchronized void use(){ used=true; } */

    /** 解放する */
    public void release(){used=false;}

    /**
    すでに利用されていないならば，利用情報にする．
    @return 本道具を確保できれば真，すでにだれか使っていれば偽．
    */
    public boolean testAndUse(){
        if(used) return false;
        used=true;
        return true;

    }
}
