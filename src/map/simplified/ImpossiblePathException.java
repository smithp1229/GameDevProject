package map.simplified;

public class ImpossiblePathException extends Exception{

    public ImpossiblePathException() {
        super("No path can be created with provided requirements.");
    }
}
