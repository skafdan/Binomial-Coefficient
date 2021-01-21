import java.util.*;

public class countingApp{
    public static void main(String[] args){
        long n;
        long k; 
        Scanner sc = new Scanner(System.in);
        Scanner sc2;
        while(sc.hasNext()){
            try{
                String inputedLine = sc.nextLine();
                sc2 = new Scanner(inputedLine).useDelimiter(",| ");
                while(sc2.hasNext()){
                        n = sc2.nextLong();
                        k = sc2.nextLong();
                        countingUp c = new countingUp(n,k);
                        System.out.println(c.getSolution());
                }
            }catch (Exception e){
                if(e instanceof InputMismatchException){
                    System.err.println("Error: Input non-natural number");
                }
            }
        }
    }
}