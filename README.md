# 🌳 Name Tree Manager
A tree-based data structure implementation for efficient name storage and management in Java.

## 📖 Overview
Name Tree Manager is a specialized tree data structure where each node represents a letter, and paths from root to leaf form names. This implementation provides efficient storage and retrieval of names while maintaining a hierarchical structure.

```
Example Tree Structure:
└── :0
    ├── J:2
    │   ├── O:2
    │   │   ├── H:1
    │   │   │   └── N:1
    │   │   └── E:1
    ├── M:1
    │   └── A:1
    │       └── X:1
```

## ✨ Features
- **Add Names**: Efficiently insert new names into the tree
- **Remove Names**: Delete existing names while maintaining tree structure
- **Update Names**: Modify existing names in the tree
- **Visual Display**: Beautiful tree visualization with depth indicators
- **Case Insensitive**: Automatically handles case sensitivity
- **Memory Efficient**: Shares common prefixes among names

## 🛠️ Implementation Details

### TreeNode Class
```java
public class TreeNode {
    char letter;           // Letter stored in this node
    int nameCounter;       // Number of names using this node
    HashMap<Character, TreeNode> childrenList;  // Child nodes
    TreeNode parent;       // Reference to parent node
}
```

### NameTree Class
```java
public class NameTree {
    public TreeNode root;  // Root node of the tree
    
    // Main operations:
    public void addName(String name)
    public void removeName(String name)
    public void updateName(String nameToDelete, String nameToAdd)
}
```

## 🎯 How It Works

### Adding Names
When adding a name (e.g., "JOHN"):
1. Start at root node
2. For each letter: J → O → H → N
3. Create new nodes if they don't exist
4. Increment nameCounter for each node in the path

### Visual Example
Adding "JOHN" and "JOE":
```
Initial:
└── :0

After adding "JOHN":
└── :0
    └── J:1
        └── O:1
            └── H:1
                └── N:1

After adding "JOE":
└── :0
    └── J:2
        └── O:2
            ├── H:1
            │   └── N:1
            └── E:1
```

## 💡 Usage Example
```java
public static void main(String[] args) {
    NameTree nameTree = new NameTree();
    
    // Add names
    nameTree.addName("John");
    nameTree.addName("Joe");
    
    // Display tree
    DisplayNameTree(nameTree.root, "", true);
    
    // Update name
    nameTree.updateName("John", "Jane");
    
    // Remove name
    nameTree.removeName("Joe");
}
```

## 🔍 Key Features Explained

### Name Counter
- Each node maintains a counter showing how many names pass through it
- Helps in efficient removal and updates
- Used for cleaning up unused branches

### Tree Display
- Uses ASCII characters to create visual tree structure
- Shows letter and name counter at each node
- Indentation indicates depth level
- Uses └── for last child and ├── for other children

### Memory Efficiency
Names sharing common prefixes share nodes:
- "John" and "Joe" share "J" and "O" nodes
- Reduces memory usage for similar names
- Efficient for large datasets with common prefixes

## ⚙️ Menu Options
1. **Add a name**: Insert new name into the tree
2. **Remove a name**: Delete existing name
3. **Update a name**: Change existing name to new name
4. **Display Tree**: Show current tree structure
5. **Quit**: Exit program

## 🎨 Implementation Notes
- Uses HashMap for efficient child node lookup
- Maintains parent references for easy tree traversal
- Automatically converts names to uppercase
- Preserves tree structure during deletions

## 🌟 Best Practices
- Always check if name exists before removal
- Use display function to verify tree structure
- Keep track of name counter for accurate representation
- Handle empty strings and null cases

## 🚀 Possible Enhancements
- Name search functionality
- Prefix-based name suggestions
- Case-sensitive mode option
- Name statistics and analytics
- Export/Import tree structure
- Pattern matching and wildcards

This implementation provides an efficient and elegant solution for managing names in a hierarchical structure while maintaining visual representation and easy manipulation capabilities.
