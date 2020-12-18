/** 
 * �r���I�ɗ��p(��L)����铹��̃N���X
 * synchronized�u���b�N�𗘗p���Ӑ}���Ă��邽�߁C���\�b�h��synchronized����Ă��Ȃ��D
 * */
public class Tool{
/** ���p����Ă��邩�ۂ����̏��C���p����Ă�Ɛ^ */
private boolean used=false;
private ToolView tv;

	public Tool(ToolView tv){
		this.tv=tv;
	}
	
	public ToolView getView(){
		return tv;
	}

    /** ���p����Ă��邩�ۂ����`�F�b�N */
    public boolean isUsed(){ return used; }

    /* synchronized void use(){ used=true; } */

    /** ������� */
    public void release(){used=false;}

    /**
    ���łɗ��p����Ă��Ȃ��Ȃ�΁C���p���ɂ���D
    @return �{������m�ۂł���ΐ^�C���łɂ��ꂩ�g���Ă���΋U�D
    */
    public boolean testAndUse(){
        if(used) return false;
        used=true;
        return true;

    }
}
