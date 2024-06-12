package tree.binary;

// lc 297.二叉树的序列化和反序列化(层序遍历方式)
public class LevelorderSerializeAndDeserialize {

    private static final String SPLIT = ",";

    private static final String NULL_NODE = "#";

    private static final TreeNode[] array = new TreeNode[10000];

    // 序列化
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        build(root, builder);
        int l = 0, r = 0;
        if (root != null) {
            array[r++] = root;
        }
        while (l < r) {
            int size = r - l;
            for (int i = 0; i < size; i++) {
                TreeNode node = array[l++];
                build(node.left, builder);
                build(node.right, builder);
                if (node.left != null) {
                    array[r++] = node.left;
                }
                if (node.right != null) {
                    array[r++] = node.right;
                }
            }
        }
        return builder.toString();
    }

    private void build(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append(NULL_NODE);
        } else {
            builder.append(node.val);
        }
        builder.append(SPLIT);
    }

    // 反序列化
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(SPLIT);
        int l = 0, r = 0, index = 0;
        TreeNode root = generate(dataArray[index++]);
        if (root != null) {
            array[r++] = root;
        }
        while (l < r) {
            int size = r - l;
            for (int i = 0; i < size; i++) {
                TreeNode node = array[l++];
                node.left = generate(dataArray[index++]);
                node.right = generate(dataArray[index++]);
                if (node.left != null) {
                    array[r++] = node.left;
                }
                if (node.right != null) {
                    array[r++] = node.right;
                }
            }
        }
        return root;
    }

    private TreeNode generate(String val) {
        return val.equals(NULL_NODE) ? null : new TreeNode(Integer.parseInt(val));
    }
}
