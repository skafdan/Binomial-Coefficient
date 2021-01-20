import java.util.*;

public class test{
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        for(int i = n; i > n-k; i--){
            System.out.println(i);
        }
    }
}