/**
 * ��H����̎��́C�R�����A�N�e�B�u�ȗv�f(�X���b�h)�Ƃ��Đ���D
 * �݂Ă���́Cview �N���X�ɋÏk�D
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
	 * ���̃N���X��\�����邽�߂̃N���X
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
			if(mychi!=null && myham!=null){ // �o���̓���������Ă�����C��Ƃ��Ď����
				counter++;
				try{ sleep(ram.nextInt(1200)); }catch(Exception e){}  // ����������
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
			if(mychi==null){ // �����C�m�~���Ȃ�������C�����Ă�m�~���������Ď擾���߂���
				try{ sleep(ram.nextInt(800)); }catch(Exception e){} // �m�~��T������
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
			// else // �� �R�R���R�����g�A�E�g����Ă���ƃf�b�h���b�N����D
			if(myham==null){ // �����C�g���J�`���Ȃ�������E�E�E����
				try{ sleep(ram.nextInt(1000)); }catch(Exception e){} // �g���J�`��T������
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
	 * �X���b�h���I��点�邽�߂̃X�C�b�`
	 */
	synchronized void quit(){
		quit=true;
	}
}
