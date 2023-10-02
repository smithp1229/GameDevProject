package map.simplified;

public class SimplifiedEnemyNode extends SimplifiedMapNode {

    public SimplifiedEnemyNode(boolean branchLeft, boolean branchRight) {
        super(branchLeft, branchRight);
        this.sym = 'E';
        this.rep = this.createRep();
    }
}
