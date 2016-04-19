package mp07;

public class test {
	public static void main(String args[]){
		TwoDTree DTree = new TwoDTree();
		DTree.add(30,40);
		DTree.add(5,25);
		DTree.add(10,12);
		DTree.add(70,70);
		DTree.add(50,30);
		DTree.add(35,45);
		
		System.out.println("Level Order Traversal");
		DTree.levelOrderPrint();
		
		System.out.println("DTree contaion 30,40: "+DTree.contains(30, 40));
		System.out.println("DTree contaion 0,0: "+DTree.contains(0, 0));
	}
}
