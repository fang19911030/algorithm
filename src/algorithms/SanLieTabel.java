package algorithms;

public class SanLieTabel {
	public class slot{
		private DoubleLinkedList link;
		
		public slot(){
			link = new DoubleLinkedList(Integer.MIN_VALUE);
		}
		
		public void add(int data){
			link.add(data);
		}
		
		public void delete(){
			link.delete();
		}
	}
	private slot[] tabel;
	
	public SanLieTabel(int size){
		tabel = new slot[size];
		for(int i=0;i<tabel.length;i++){
			tabel[i] = new slot();
		}
	}
	
	public SanLieTabel(){
		tabel = new slot[1];
		tabel[0] = new slot();
	}
	
	public void add(int numSlow, int data){
		if(numSlow>tabel.length){
			System.out.print("the index overflow");
			return;
		}
		tabel[numSlow].add(data);
	}
	
	
	public static void main(String[] args){
		SanLieTabel myTabel = new SanLieTabel();
		myTabel.add(5, 33);
		
	}
	

}
