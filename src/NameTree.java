public class NameTree
{
    public TreeNode root;

    public NameTree()
    {
        this.root = new TreeNode('\0'); // Root's value is null
    }

    public void addName(String name)
    {
        TreeNode current = root;
        char[] nameArray = toUpperCaseCharArray(name);
        for (char a : nameArray)
        {
            current.addChild(a);
            current = current.getChild(a);
        }
    }

    public void removeName(String name)
    {
        TreeNode current = root;
        char[] nameArray = toUpperCaseCharArray(name);

        for (char a : nameArray)
        {
            if (!current.childrenList.containsKey(a))
            {
                System.out.println("Name " + name + " not in tree.");
                return;
            }
            current = current.getChild(a); // current = current.next until it's the last letter of the name.
        }

        for (int i = name.length() - 1; i >= 0; i--) //Iterating backwards from the last letter's node of the name to first letter.
        {
            char a = Character.toUpperCase(name.charAt(i));

            current.nameCounter--;

            if (current.nameCounter == 0 && current.parent != null)
                current.parent.childrenList.remove(a);

            current = current.parent;
        }
    }

    public void updateName(String nameToDelete, String nameToAdd)
    {
        if (nameToDelete.equalsIgnoreCase(nameToAdd))
        {
            System.out.println("You cannot update the same name.");
            return;
        }

        removeName(nameToDelete);
        addName(nameToAdd);
    }

    private char[] toUpperCaseCharArray(String name)
    {
        char[] result = new char[name.length()];
        for (int i = 0; i < name.length(); i++)
            result[i] = Character.toUpperCase(name.charAt(i));
        return result;
    }
}