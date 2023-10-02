package map.simplified;

public class SimplifiedBossNode extends SimplifiedMapNode{

    public SimplifiedBossNode(boolean branchLeft, boolean branchRight) {
        super(branchLeft, branchRight);
        this.sym = 'B';
        this.rep = createRep();
    }
}
