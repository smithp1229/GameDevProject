package map.simplified;

import java.util.Arrays;
import java.util.Collections;

public class SimplifiedMapGenerator {
    private int numPaths;
    private int pathLength;
    private SimplifiedMapPathRequirements req;
    private SimplifiedMapPathGenerator gen;
    private SimplifiedMap myMap;

    public SimplifiedMapGenerator(int numPaths, int pathLength, SimplifiedMapPathRequirements path_req) throws ImpossiblePathException {
        this.numPaths = numPaths;
        this.pathLength = pathLength;
        this.req = path_req;
        this.gen = new SimplifiedMapPathGenerator(pathLength, path_req);
        myMap = new SimplifiedMap(numPaths, pathLength);
    }

    public void generateMap() throws IllegalMapNodeTypeException, ImpossiblePathException {
        if(this.numPaths == 1) {
            this.gen.generateNonBranchingPath();
            this.myMap.addPathToMap(this.gen.getPath());
            this.gen.reset();
        } else {
            this.gen.generateLeftmostPath();
            this.myMap.addPathToMap(this.gen.getPath());
            this.gen.reset();
            for(int lcv = 1; lcv < this.numPaths - 1; lcv++) {
                this.gen.generateInsidePath();
                this.myMap.addPathToMap(this.gen.getPath());
                this.gen.reset();
            }
            this.gen.generateRightmostPath();
            this.myMap.addPathToMap(this.gen.getPath());
            this.gen.reset();
        }
    }

    public SimplifiedMap getMap() {
        return this.myMap;
    }
}

