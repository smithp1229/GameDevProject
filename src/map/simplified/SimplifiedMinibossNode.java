package map.simplified;

public class SimplifiedMinibossNode extends SimplifiedMapNode {

    public SimplifiedMinibossNode(boolean branchLeft, boolean branchRight) {
        super(branchLeft, branchRight);
        this.sym = 'M';
        this.rep = createRep();
    }
}
