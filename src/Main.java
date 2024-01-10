import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        NameTree nameTree = new NameTree();

        int ans;
        do
        {
            System.out.print("1 - Add a name.\n2 - Remove a name.\n3 - Update a name.\n4 - Display Tree.\n5 - Quit.\n");
            System.out.print("Select an action: ");
            ans = new Scanner(System.in).nextInt();
            String name;

            switch (ans)
            {
                case 1:
                    System.out.print("Enter a name to add : ");
                     name = new Scanner(System.in).nextLine();
                    nameTree.addName(name);
                    break;
                case 2:
                    System.out.print("Enter a name to remove : ");
                    name = new Scanner(System.in).nextLine();
                    nameTree.removeName(name);
                    break;
                case 3:
                    System.out.print("Enter the existing name : ");
                    name = new Scanner(System.in).nextLine();
                    System.out.print("Enter the new name : ");
                    String newName = new Scanner(System.in).nextLine();
                    nameTree.updateName(name,newName);
                        break;
                case 4:
                    //DisplayNameTree(nameTree.root,""); // This is my own display method
                    DisplayNameTree(nameTree.root, "", true); //This method is not fully mine. But it looks way better than mine.
                    break;
                case 5:
                    System.out.println("Thanks for using.");
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }
        while(ans != 5);
    }

    private static void DisplayNameTree(TreeNode node, String space)
    {
        System.out.printf("%s %s:%d\n",space,node.letter,node.nameCounter);

        for (TreeNode child : node.childrenList.values())
            DisplayNameTree(child, space + "  "); //2 spaces for each child (line). // Each 2-space means height/depth of the node.
    }


    //I got help from ChatGPT for this DisplayNameTree method.Because it looks better. It is not fully mine. My method is the upper one.
    private static void DisplayNameTree(TreeNode node, String prefix, boolean isTail)
    {
        if (node != null)
        {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + node.letter + ":" + node.nameCounter);

            List<TreeNode> children = new ArrayList<>(node.childrenList.values());
            for (int i = 0; i < children.size(); i++)
            {
                boolean isLast = (i == children.size() - 1);
                DisplayNameTree(children.get(i), prefix + (isTail ? "    " : "│   "), isLast);
            }
        }
    }
}