package map.simplified;

public class SimplifiedTreasureNode extends SimplifiedMapNode{

    public SimplifiedTreasureNode(boolean branchLeft, boolean branchRight) {
        super(branchLeft, branchRight);
        this.sym = 'T';
        this.rep = createRep();
    }
}
