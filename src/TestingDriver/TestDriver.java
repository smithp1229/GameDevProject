package TestingDriver;

import map.simplified.*;

public class TestDriver {

    public static void main (String[] args) throws ImpossiblePathException, IllegalMapRequirementPairException, IllegalMapNodeTypeException {
        for(int lcv = 0; lcv < 5; lcv++) {
            System.out.println("Map #"+ (lcv+1)+":");
            testMapGeneration(5, 10);
            System.out.println();
        }
    }

    public static void testPathGeneration(int length) throws IllegalMapRequirementPairException, ImpossiblePathException, IllegalMapNodeTypeException {
        SimplifiedMapPathRequirements reqs = generateTestRequirements();
        SimplifiedMapPathGenerator gen = new SimplifiedMapPathGenerator(length, reqs);
        gen.generateInsidePath();
        gen.getPath().printPath();
    }

    public static void testMapGeneration(int numPaths, int pathLength) throws IllegalMapRequirementPairException, ImpossiblePathException, IllegalMapNodeTypeException {
        SimplifiedMapPathRequirements reqs = generateTestRequirements();
        SimplifiedMapGenerator gen = new SimplifiedMapGenerator(numPaths, pathLength, reqs);
        gen.generateMap();
        gen.getMap().printMap();

    }

    public static SimplifiedMapPathRequirements generateTestRequirements() throws IllegalMapRequirementPairException {
        SimplifiedMapPathRequirements req = new SimplifiedMapPathRequirements();
        req.setShopRequirement(2, 2);
        req.setMinibossRequirement(1, 3);
        req.setTreasureRequirement(1, 1);
        req.setRestRequirement(0, 2);
        req.setEnemyRequirement(0);
        req.setBossRequirement(1, 1);
        return req;
    }
}
