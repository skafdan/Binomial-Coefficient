import java.util.*;

public class countingUp{
    private List<Long> numer = new ArrayList<Long>();
    private List<Long> denom = new ArrayList<Long>();     
    private List<Long> f_denom = new ArrayList<Long>();
    private long n;
    private long k;
    private long solution;

    public countingUp(long n, long k){
        this.n = n;
        this.k = k;
        fragment();
        primeFactorization();
        simplify();
        this.solution = calcSolution();
    }
    private void fragment(){
        long delta;
        long numerator;
        if(k < n/2){
            delta = n-k;
            numerator = k;
        } else {
            delta = k;
            numerator = n-k;
        }
        for(long i = n; i > delta; i--){
            numer.add(i);
        }
        for(long i = numerator; i > 0; i--){
            denom.add(i);
        }
    }

    private void primeFactorization(){
        for(Long x: denom){
            f_denom.addAll(factors(x));
        }
    }

    private void simplify(){
        for(int i = 0; i < numer.size(); i++){
            for(int j = 0; j < f_denom.size(); j++){
                if(numer.get(i) % f_denom.get(j) == 0){
                    numer.set(i, numer.get(i) / f_denom.get(j));
                    f_denom.set(j, (long)1);
                }
            }
        }
    }

    private List<Long> factors(long x){
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

    private Long calcSolution(){
        long productNumer = 1;
        long productDenom = 1;
        for(int i = 0; i < numer.size(); i++){
            productNumer = Math.multiplyExact(productNumer, numer.get(i));
        }
        for(int i = 0; i < f_denom.size(); i++){
            productDenom = Math.multiplyExact(productDenom, f_denom.get(i));
        }
        return productNumer/productDenom;
    }
    public List<Long> getNumer(){
        return numer;
    }
    public List<Long> getDenom(){
        return denom;
    }
    public List<Long> getF_Denom(){
        return f_denom;
    }
    public Long getF_DenomElement(int i){
        return f_denom.get(i);
    }
    public Long getNumerElement(int i){
        return numer.get(i);
    }
    public Long getSolution(){
        return solution;
    }
}