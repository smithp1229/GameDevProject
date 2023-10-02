package map.simplified;

public abstract class SimplifiedMapNode {
    char sym;
    boolean branchesLeft;
    boolean branchesRight;
    String rep;

    public SimplifiedMapNode(boolean branchLeft, boolean branchRight) {
        this.branchesLeft = branchLeft;
        this.branchesRight = branchRight;
        createRep();
    }

    public boolean doesBranchLeft() {
        return branchesLeft;
    }
    public boolean doesBranchRight() {
        return branchesRight;
    }
    public String getRep() {
        return rep;
    }
    protected String createRep() {
        StringBuilder sb = new StringBuilder();
        if(this.branchesLeft && this.branchesRight) {
            sb.append('\\');
            sb.append(this.sym);
            sb.append('/');
        } else if(this.branchesLeft) {
            sb.append('\\');
            sb.append(this.sym);
        } else if(this.branchesRight) {
            sb.append(this.sym);
            sb.append('/');
        } else {
            sb.append(this.sym);
        }
        return sb.toString();
    }
}
