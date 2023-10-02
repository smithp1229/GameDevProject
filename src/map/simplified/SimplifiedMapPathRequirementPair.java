package map.simplified;

import javafx.util.Pair;

public class SimplifiedMapPathRequirementPair {

    private Pair<Integer, Integer> myPair;

    public SimplifiedMapPathRequirementPair(int min, int max) throws IllegalMapRequirementPairException {
        this.myPair = new Pair<>(min, max);
        if((this.getMinValue() < 0) || this.getMaxValue() < this.getMinValue()) {
            throw new IllegalMapRequirementPairException();
        }
    }

    public SimplifiedMapPathRequirementPair(int min) throws IllegalMapRequirementPairException {
        this(min, -1);
    }

    public static SimplifiedMapPathRequirementPair createDefaultRequirementPair() throws IllegalMapRequirementPairException {
        return new SimplifiedMapPathRequirementPair(0, -1);
    }


    public double getMinValue() {
        return this.myPair.getKey();
    }

    public double getMaxValue() {
        if(this.myPair.getValue() == -1) {
            return Double.POSITIVE_INFINITY;
        } else  {
            return myPair.getValue();
        }
    }
}
