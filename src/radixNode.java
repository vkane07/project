/**
 * Created by WL-PC on 2017/8/30.
 */
public class radixNode {
    public radixNode left;
    public radixNode right;
    public radixNode parent;
    public String key;
    public String value;


    public radixNode(){
        this.left = null;
        this.right = null;
        this.parent = null;
        this.key = "";
        this.value = "";
    }
}

