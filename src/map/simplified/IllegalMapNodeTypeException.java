package map.simplified;

public class IllegalMapNodeTypeException extends Exception{

    public IllegalMapNodeTypeException() {
        super("Attempted to create a map node of a non-existent type");
    }
}
