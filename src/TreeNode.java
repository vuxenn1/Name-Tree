import java.util.HashMap;
public class TreeNode
{
    char letter;
    int nameCounter;
    HashMap<Character, TreeNode> childrenList;
    TreeNode parent;

    public TreeNode(char letter)
    {
        this.letter = letter;
        this.nameCounter = 0;
        this.childrenList = new HashMap<>();
        this.parent = null;
    }

    public void addChild(char childLetter)
    {
        TreeNode childNode = childrenList.getOrDefault(childLetter, new TreeNode(childLetter));
        childNode.parent = this;
        childNode.nameCounter++;
        childrenList.put(childLetter, childNode);
    }

    public TreeNode getChild(char childLetter)
    {
        return childrenList.get(childLetter);
    }
}