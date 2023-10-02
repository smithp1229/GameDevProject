package map.simplified;

public class SimplifiedRestNode extends SimplifiedMapNode{

    public SimplifiedRestNode(boolean branchLeft, boolean branchRight) {
        super(branchLeft, branchRight);
        this.sym = 'R';
        this.rep = createRep();
    }
}
