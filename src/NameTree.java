public class NameTree
{
    public Tree root;

    public NameTree()
    {
        this.root = new Tree('\0');
    }

    public void addName(String name)
    {
        Tree current = root;
        for (char a : toUpperCaseCharArray(name))
        {
            current.addChild(a);
            current = current.getChild(a);
        }
    }

    public void removeName(String name)
    {
        Tree current = root;

        for (char a : toUpperCaseCharArray(name))
        {
            if (!current.children.containsKey(a))
            {
                System.out.println("Name " + name + " not in tree.");
                return;
            }
            current = current.getChild(a);
        }

        for (int i = name.length() - 1; i >= 0; i--)
        {
            char a = Character.toUpperCase(name.charAt(i));

            current.nameCounter--;

            if (current.nameCounter == 0 && current.parent != null)
                current.parent.children.remove(a);

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

    private char[] toUpperCaseCharArray(String input)
    {
        char[] result = new char[input.length()];
        for (int i = 0; i < input.length(); i++)
            result[i] = Character.toUpperCase(input.charAt(i));
        return result;
    }
}