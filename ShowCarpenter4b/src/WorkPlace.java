import javax.swing.JPanel;

/**
 * ���f������уr���[�𓝍��Ǘ����鍇���N���X
 * @author kaiya
 *
 */
public class WorkPlace {
	// �m�~�C�g���J�`�C��H��������p�l���Q
	private JPanel chipanel;
	private JPanel hampanel;
	private JPanel carpanel;

	private boolean isRun=false;
	
	// ����̐��C���̔{�̐�����H�̐l���ɂȂ�
	private int number=3;
	
	// �ȉ��͎�Ƀ��f��
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
	 * �p�l�����N���A���郁�\�b�h�C����ύX���čĎ��s����ꍇ�C��ʂ��N���A�ɂ���K�v�����邽�߁D
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
	 * ��ʂƃ��f���̏��������s���D���f�����\���C���X�^���X���m���Ă���D
	 * @param n ����̐��C��H�͂��̐��̓�{
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
	 * �X���b�h�ł����H���X�^�[�g������C����ɂ���č�Ƃ��͂��܂�D
	 *
	 */
	public void run(){
		if(cars==null) return;
		for(int i=0; i<cars.length; i++) cars[i].start();
		isRun=true;
	}
	
	/**
	 * ��H���X�g�b�v������
	 *
	 */
	public void stop(){
		if(cars==null) return;
		for(int i=0; i<cars.length; i++) cars[i].quit();
		isRun=false;
		// ���͑S�X���b�h����~���Ă��邱�Ƃ�ۏ�ł��Ȃ��̂Ń}�Y��
		validate();
	}
	
	/**
	 * ���쒆���ۂ����m�F���郁�\�b�h�C��d���s������邽�߁D
	 * @return
	 */
	public boolean isRunning(){
		return isRun;
	}

}
