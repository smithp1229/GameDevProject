package map.simplified;

public class SimplifiedMapPath {
    private SimplifiedMapNode[] myPath;

    private String[] myRepPath;
    private int myLength;

    public SimplifiedMapPath(int length) {
        this.myLength = length;
        this.myPath = new SimplifiedMapNode[this.myLength];
        this.myRepPath = new String[this.myLength];
    }

    public SimplifiedMapPath(SimplifiedMapNode[] path) {
        this.myPath = path;
        this.myLength = path.length;
        generateRepPath();
    }

    public void setNode(int index, SimplifiedMapNode node) {
        this.myPath[index] = node;
        this.myRepPath[index] = node.getRep();
    }

    private void generateRepPath() {
        this.myRepPath = new String[this.myLength];
        for(int lcv = 0; lcv < this.myLength; lcv++) {
            this.myRepPath[lcv] = this.myPath[lcv].getRep();
        }
    }

    public SimplifiedMapNode getNode(int index) {
        return this.myPath[index];
    }

    public String[] getRepPath() {
        return this.myRepPath;
    }

    public void clearPath() {
        this.myPath = new SimplifiedMapNode[this.myLength];
        this.myRepPath = new String[this.myLength];
    }

    public void printPath() {
        for(int lcv = this.myRepPath.length - 1; lcv >= 0; lcv--) {
            System.out.println(this.myRepPath[lcv]);
        }
        System.out.println();
    }
}