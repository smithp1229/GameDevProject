package map.simplified;

public class SimplifiedShopNode extends SimplifiedMapNode{

    public SimplifiedShopNode(boolean branchLeft, boolean branchRight) {
        super(branchLeft, branchRight);
        this.sym = 'S';
        this.rep = createRep();
    }
}
