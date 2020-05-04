
public class HeightOfTree {
public int maxheight(Node n) {
	int h=0;
	if (n==null)
		return 0;
    int l=maxheight(n.left);
    int r=maxheight(n.right);
    if(l>r) {
    	h=l+1;
    }else {
    	h=r+1;
    }
	return h;
}
	public static void main(String[] args) {
		HeightOfTree t=new HeightOfTree();
		Node r1= new Node(20); 
        r1.left = new Node(10); 
        r1.right = new Node(30);
        System.out.println(t.maxheight(r1));
        

	}

}
