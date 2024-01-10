import java.util.HashMap;
public class Tree
{
    char letter;
    int nameCounter;
    HashMap<Character, Tree> children;
    Tree parent;

    public Tree(char letter)
    {
        this.letter = letter;
        this.nameCounter = 0;
        this.children = new HashMap<>();
        this.parent = null;
    }

    public void addChild(char childLetter)
    {
        Tree childNode = children.getOrDefault(childLetter, new Tree(childLetter));
        childNode.parent = this;
        childNode.nameCounter++;
        children.put(childLetter, childNode);
    }

    public Tree getChild(char childLetter)
    {
        return children.get(childLetter);
    }
}