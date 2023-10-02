package map.simplified;

public class SimplifiedMap {
    private int currentNumPaths;
    private int numPaths;
    private int pathLengths;

    private SimplifiedMapPath[] myMap;
    private String[][] myRepMap;

    public SimplifiedMap(int numPaths, int pathLength) {
        currentNumPaths = 0;
        this.numPaths = numPaths;
        this.pathLengths = pathLength;
        myMap = new SimplifiedMapPath[numPaths];
        myRepMap = new String[pathLength][numPaths];
    }

    public void addPathToMap(SimplifiedMapPath path) {
        String[] repPath = path.getRepPath();
        this.myMap[this.currentNumPaths] = path;
        for (int lcv = 0; lcv < repPath.length; lcv++) {
            this.myRepMap[lcv][this.currentNumPaths] = repPath[lcv];
        }
        this.currentNumPaths++;
    }

    public SimplifiedMapPath getPath(int index) {
        return myMap[index];
    }

    public void printMap() {
        for (int lcv1 = pathLengths - 1; lcv1 >= 0; lcv1--) {
            for (int lcv2 = 0; lcv2 < numPaths; lcv2++) {
                String currentRep = this.myRepMap[lcv1][lcv2];
                if(currentRep.contains("\\")) {
                    System.out.print(" ");
                } else {
                    System.out.print("  ");
                }
                System.out.print(currentRep);
                if(currentRep.contains("/")) {
                    System.out.print(" ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}