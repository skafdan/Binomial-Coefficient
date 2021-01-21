import java.util.*;

public class test{
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        List<Long> denom = new ArrayList<Long>();
        List<Long> nemur = new ArrayList<Long>();
        for(int i = n; i > n-k; i--){
            nemur.add((long)i);
        }
        for(int i = k; i > 0; i--){
            denom.add((long)i);
        }
        System.out.println(nemur);
        System.out.println(denom);
        List<Long> primes = new ArrayList<Long>();
        for(Long x: denom){
            for(long i = 2; i <= x; i++){
                while(x % i == 0){
                    primes.add(i);
                    x /= i;
                }
            }
        }
        List<Long> primes2 = new ArrayList<Long>();
        List<Long> primes3 = new ArrayList<Long>();
        for(Long x: denom){
            for(long i = 1; i < x; i++){
                if(x % i == 0){
                    primes2.add(i);
                }
            }
        }
        for(Long x: denom){
           primes3.addAll(factors(x)); 
        }
        System.out.println(primes);
        //System.out.println(primes2);
        System.out.println(primes3);
    }
    public static List<Long> factors(long x){
        List<Long> factors = new ArrayList<Long>();
        while(x % 2 == 0) {
            factors.add(2L);
            x /= 2;
        }

        for(long i = 3; i <= Math.sqrt(x); i += 2){
            while(x % i == 0){
                factors.add(i);
                x /= i;
            }
        }

        if (x > 2){
            factors.add(x);
        }
        return factors;
    }
}