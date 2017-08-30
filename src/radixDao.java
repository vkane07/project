public class radixDao {
    public static void radix_tree_insert(radix_tree T,String key,String value){
        int i = 0;
        radixNode node,child;
        node = T.root;
        for (i = 0; i <key.length() ; i++) {
            if(key.charAt(i) == '0'){
                if(node.left == null){
                    child = new radixNode();
                    child.parent = node;
                    node.left = child;
                    node = node.left;
                }
                else {
                    node = node.left;
                }
            }
            else{
               if(node.right == null){
                   child = new radixNode();
                   child.parent = node;
                   node.right = child;
                   node = node.right;
               }
               else {
                   node = node.right;
               }
            }
        }
        node.value = value;
        System.out.println("insert ok!");
    }
    public static void radix_print(radixNode T){
        //先序遍历
        if(T == null){
            return;
        }
        if(T.value !=""){
            System.out.println(T.value);
        }
        radix_print(T.left);
        radix_print(T.right);
    }
    public static String radix_tree_find(radix_tree T,String key){
        radixNode node;
        String radix_value = "radix_null_value";
        node = T.root;
        int i = 0;
        while(node!=null){
            if(key.charAt(i) == '0'){
                node = node.left;
            }else{
                node = node.right;
            }
            i++;
            if(i == key.length())
                break;
        }
        if(node == null){
            return radix_value;
        }
        if(node.value != ""){
            radix_value = node.value;
        }
        return radix_value;
    }
    public static int radix_tree_delete(radix_tree T,String key) {
        radixNode node;
        node = T.root;
        String radix_value = "";
        int i = 0;
        while (node != null) {
            if (key.charAt(i) == '0')
                node = node.left;
            else
                node = node.right;
            i++;
            if (i == key.length())
                break;
        }
        if (node == null)
            return -1;
        if (node.left != null || node.right != null) {
            if (node.value != "") {
                node.value = radix_value;
                return 0;
            }
            return -1;
        }
        for (; ; ) {
            if (node.parent.right == node) {
                node.parent.right = null;
            } else {
                node.parent.left = null;
            }
            node = node.parent;
            if (node.left != null || node.right != null) {
                break;
            }
            if (node.value != "") {
                break;
            }
        }
        return 0;
    }
}
