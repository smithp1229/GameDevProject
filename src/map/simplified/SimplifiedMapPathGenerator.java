package map.simplified;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SimplifiedMapPathGenerator {

    private int lengthToGenerate;

    private HashSet<Integer> unfilledNodes;

    private HashMap<Character, Double> requiredNodes;
    private HashMap<Character, Double> availableNodes;
    private SimplifiedMapPath myPath;
    private SimplifiedMapPathRequirements reqs;


    public SimplifiedMapPathGenerator(int length, SimplifiedMapPathRequirements req) throws ImpossiblePathException {
        this.lengthToGenerate = length;
        this.myPath = new SimplifiedMapPath(length);
        this.reqs = req;
        this.requiredNodes = new HashMap<>();
        this.availableNodes = new HashMap<>();
        this.unfilledNodes = new HashSet<>();
        basicQuickCheck();
        createNodeMaps();
        populateUnfilledNodesSet();
    }

    private void createNodeMaps() {
        Set<Character> reqKeys = this.reqs.getReqKeyset();
        for(char reqKey: reqKeys) {
            SimplifiedMapPathRequirementPair newPair = this.reqs.getRequirementBySymbol(reqKey);
            if(newPair != null) {
                double min = newPair.getMinValue();
                double max = newPair.getMaxValue();
                if(min != 0) {
                    this.requiredNodes.put(reqKey, min);
                }
                if(max != 0) {
                    this.availableNodes.put(reqKey, max);
                }
            }
        }
    }

    private void basicQuickCheck() throws ImpossiblePathException {
        double minSum = 0;
        double maxSum = 0;
        Set<Character> reqKeys = this.reqs.getReqKeyset();
        for(char reqKey: reqKeys) {
            SimplifiedMapPathRequirementPair newPair = this.reqs.getRequirementBySymbol(reqKey);
            if(newPair != null) {
                minSum += newPair.getMinValue();
                maxSum += newPair.getMaxValue();
            }
        }
        if((maxSum < minSum) || (lengthToGenerate < minSum)) {
            throw new ImpossiblePathException();
        }
    }

    private void populateUnfilledNodesSet() {
        for(int lcv = 0; lcv < this.lengthToGenerate; lcv++) {
            this.unfilledNodes.add(lcv);
        }
    }

    public SimplifiedMapPath getPath() {
        return this.myPath;
    }

    private void useNode(char sym) {
        if(this.availableNodes.containsKey(sym)) {
            if(this.availableNodes.get(sym) == 1) {
                this.availableNodes.remove(sym);
            } else {
                this.availableNodes.put(sym, this.availableNodes.get(sym) - 1);
            }
        }
        if(this.requiredNodes.containsKey(sym)) {
            if(this.requiredNodes.get(sym) == 1) {
                this.requiredNodes.remove(sym);
            } else {
                this.requiredNodes.put(sym, this.requiredNodes.get(sym) - 1);
            }
        }
    }

    public void generateNonBranchingPath() throws IllegalMapNodeTypeException {
        this.generatePath(false, false);
    }

    public void generateLeftmostPath() throws IllegalMapNodeTypeException {
        this.generatePath(false, true);
    }

    public void generateRightmostPath() throws IllegalMapNodeTypeException {
        this.generatePath(true, false);
    }

    public void generateInsidePath() throws IllegalMapNodeTypeException {
        this.generatePath(true, true);
    }

    private void generatePath(boolean canBranchLeft, boolean canBranchRight) throws IllegalMapNodeTypeException {
        this.myPath.setNode(this.lengthToGenerate - 1, new SimplifiedBossNode(false, false));
        this.useNode('B');
        this.unfilledNodes.remove(this.lengthToGenerate - 1);
        while(!this.unfilledNodes.isEmpty()) {
            char nodeType = this.chooseNodeType();
            Pair<Boolean, Boolean> branchingPair = this.chooseBranching(canBranchLeft, canBranchRight);
            int position = this.chooseLocation();
            SimplifiedMapNode newNode = this.createNodeFromCharacter(nodeType, branchingPair);
            this.myPath.setNode(position, newNode);
            this.useNode(nodeType);
            this.unfilledNodes.remove(position);
        }
        if(!this.requiredNodes.isEmpty()) {
            this.myPath = new SimplifiedMapPath(this.lengthToGenerate);
            this.requiredNodes = new HashMap<>();
            this.availableNodes = new HashMap<>();
            this.unfilledNodes = new HashSet<>();
            createNodeMaps();
            populateUnfilledNodesSet();
        }
    }

    private char chooseNodeType() {
        Set<Character> options;
        ArrayList<Character> optionsList = new ArrayList<>();
        if(!this.requiredNodes.isEmpty()) {
            options = this.requiredNodes.keySet();
        } else {
            options = this.availableNodes.keySet();
        }
        optionsList.addAll(options);
        int choice = (int) (Math.random() * (optionsList.size() - 1));
        return optionsList.get(choice);
    }

    private Pair<Boolean, Boolean> chooseBranching(boolean canBranchLeft, boolean canBranchRight) {
        if(!canBranchLeft && !canBranchRight) {
            return new Pair<>(false, false);
        } else if(canBranchLeft && !canBranchRight) {
            int choice = (int) (Math.random() + 1);
            switch(choice) {
                case 2:
                    return new Pair<>(true, false);
                default:
                    return new Pair<>(false, false);
            }
        } else if(!canBranchLeft && canBranchRight) {
            int choice  = (int) (Math.random() + 1);
            switch(choice) {
                case 2:
                    return new Pair<>(false, true);
                default:
                    return new Pair<>(false, false);
            }
        } else {
            int choice = (int) ((Math.random() * 3) + 1);
            switch(choice) {
                case 4:
                    return new Pair<>(true, true);
                case 3:
                    return new Pair<>(false, true);
                case 2:
                    return new Pair<>(true, false);
                default:
                    return new Pair<>(false, false);
            }
        }
    }

    private int chooseLocation() {
        ArrayList<Integer> optionsList = new ArrayList<>();
        optionsList.addAll(this.unfilledNodes);
        int index = (int) (Math.random() * optionsList.size() - 1);
        return optionsList.get(index);
    }

    private SimplifiedMapNode createNodeFromCharacter(char sym, Pair<Boolean, Boolean> branching) throws IllegalMapNodeTypeException {
        switch(sym) {
            case 'S':
                return new SimplifiedShopNode(branching.getKey(), branching.getValue());
            case 'T':
                return new SimplifiedTreasureNode(branching.getKey(), branching.getValue());
            case 'R':
                return new SimplifiedRestNode(branching.getKey(), branching.getValue());
            case 'E':
                return new SimplifiedEnemyNode(branching.getKey(), branching.getValue());
            case 'M':
                return new SimplifiedMinibossNode(branching.getKey(), branching.getValue());
            default:
                throw new IllegalMapNodeTypeException();
        }
    }
    public void reset() {
        this.myPath = new SimplifiedMapPath(this.lengthToGenerate);
        this.requiredNodes = new HashMap<>();
        this.availableNodes = new HashMap<>();
        this.unfilledNodes = new HashSet<>();
        createNodeMaps();
        populateUnfilledNodesSet();
    }
}
