import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

/**
 * Created by WL-PC on 2017/8/30.
 */
public class Test {
    public static void main(String[] args) {
        String str,key,val;
        Scanner scanner =new Scanner(System.in);
        radix_tree T =new radix_tree();
        while(true){
            System.out.println("str:");
            str = scanner.next();
            if(str.equals("I"))
            {
                System.out.println("key:");
                key = scanner.next();
                System.out.println("value:");
                val = scanner.next();
                radixDao.radix_tree_insert(T,key,val);
            }else if(str.equals("P")) {
                radixDao.radix_print(T.root);
                System.out.println();
                break;
            }
        }
        radixDao.radix_tree_insert(T,"000","6");
        radixDao.radix_tree_insert(T,"00","7");
        radixDao.radix_print(T.root);
        String s_key ;
        s_key = scanner.next();
        System.out.println( "insert the key you want to search : key = " +s_key);
        System.out.println( "result : " + radixDao.radix_tree_find(T,s_key));
        System.out.println("delete the key;"+ s_key);
        if(radixDao.radix_tree_delete(T,s_key) == 0){
            System.out.println("delete ok!");
        }else {
            System.out.println("null delete");
        }
        //test search after delete
        System.out.println("search after delete ,result : "+radixDao.radix_tree_find(T,s_key));
    }
}
