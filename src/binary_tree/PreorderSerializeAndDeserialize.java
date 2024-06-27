package binary_tree;

// lc 297.二叉树的序列化和反序列化(前序遍历方式)
public class PreorderSerializeAndDeserialize {

    private static final String SPLIT = ",";

    private static final String NULL_NODE = "#";

    private static int index;

    // 序列化
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serialize(root, builder);
        return builder.toString();
    }

    private void serialize(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append(NULL_NODE).append(SPLIT);
            return;
        }
        builder.append(node.val).append(SPLIT);
        serialize(node.left, builder);
        serialize(node.right, builder);
    }

    // 反序列化
    public TreeNode deserialize(String data) {
        String[] array = data.split(SPLIT);
        index = 0;
        return deserialize(array);
    }

    private TreeNode deserialize(String[] array) {
        String val = array[index++];
        if (val.equals(NULL_NODE)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserialize(array);
        node.right = deserialize(array);
        return node;
    }
}
