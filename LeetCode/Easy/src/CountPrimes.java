import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*204
* Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
*/
public class CountPrimes {
    static IntPredicate predicate = x -> true;

    public   static int countPrimes(int n) {
         /* IntStream primes = IntStream.range(2, n)
                .filter(i -> predicate.test(i))
                .peek(i -> predicate = predicate.and(v -> v % i != 0));
        return (int) primes.count();*/
        return (int) IntStream.range(2,n).filter(CountPrimes::isPrime).count();  /*a few seconds ago	Accepted	599 ms	34.9 MB	java*/

    }
    public static boolean isPrime(int n){
        for(int i = 2; i*i <= n; i++){
            if(n%i == 0) return false;
        }
        return true;
    }

    public  void main(String[] args){

     System.out.println(countPrimes(3));

       /* System.out.println(CountPrimes.isPrime(5));
        System.out.println(CountPrimes.isPrime(15));
        System.out.println(CountPrimes.isPrime(2));*/
              /*int s = IntStream.of(1, 2, 3, 4)
                        .filter(e -> e > 2)
                        .peek(e -> System.out.println("Filtered value: " + e))
                        .map(e -> e * e)
                        .peek(e -> System.out.println("Mapped value: " + e))
                       .sum();
        System.out.println("sum = "+s);*/
    }
}
