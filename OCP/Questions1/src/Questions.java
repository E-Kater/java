import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;

public class Questions {

    public static void main(String[] args) {
        Questions questions = new Questions();
        questions.q1();
       // questions.q2();
        questions.q3();
        questions.q4();
       // questions.wait(); // throws IllegalMonitorStateException and InterruptedException


    }

    public void q1() {
        TestClass.q1();

    }

    /*public void q2(){
        List<Item> l = Arrays.asList(
                new Item(1, "Screw"),
                new Item(2, "Nail"),
                new Item(3, "Bolt")
        );

       // l.stream().forEach(System.out::print);
    }
*/
    public void q3(){

        AtomicInteger ai = new AtomicInteger(5);
        int x = ai.getAndSet(6);
        x = ai.getAndIncrement();
        //2 INSERT CODE HERE
        System.out.println(x);

    }

    public void q4(){
        Map<String, Account> myAccts = new HashMap<>();
        myAccts.put("111", new Account("111"));
        myAccts.put("222", new BankAccount("111", 200.0));

        BiFunction<String, Account, Account> bif =
                (a1, a2)-> a2 instanceof BankAccount?new BankAccount(a1, 300.0):new Account(a1); //1

        myAccts.computeIfPresent("222", bif);//2
        BankAccount ba = (BankAccount) myAccts.get("222");
        System.out.println(ba.getBalance());
    }

    public void q5() {
        List<Movie> movies = Arrays.asList(
                new Movie("Titanic", Movie.Genre.DRAMA, 'U'),
                new Movie("Psycho", Movie.Genre.THRILLER, 'U'),
                new Movie("Oldboy", Movie.Genre.THRILLER, 'R'),
                new Movie("Shining", Movie.Genre.HORROR, 'U'));

        movies.stream()
                .filter(mov->mov.getRating()=='R')
                .peek(mov->System.out.println(mov.getName()))
                .map(Movie::getName);
    }

    }


/*
* Note that when you create and start a new Thread (at line 1) there are two threads running.
* (The main() thread and the thread that you just started!). Both the threads are trying to use the same variable.
 * Now, which thread will run first cannot be determined so whether
* the main() thread reads 'x' first or the new thread changes 'x' first is not known.
* So the output of the program cannot be determined.
* */
class TestClass implements Runnable {
    volatile int x;

    public static void q1() {
        TestClass tc = new TestClass();
        tc.x = 10;
        new Thread(tc).start();
        System.out.println(tc.x); // 10
    }

    public void run() {
        x = 5;
    }

}


class Item {
    private int id;
    private String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}



class Account {
    private String id;
    public Account(String id){ this.id = id; }
    //accessors not shown
}
 class BankAccount extends Account{
    private double balance;
    public BankAccount(String id, double balance){ super(id); this.balance = balance;}
    public double getBalance(){return balance;}

}




//imports not shown
class Movie{
    static enum Genre  {DRAMA, THRILLER, HORROR, ACTION };
    private Genre genre;
    private String name;
    private char rating = 'R';
    Movie(String name, Genre genre, char rating) {
        this.name = name;
        this.genre = genre;
        this.rating = rating;
    }

    public char getRating(){
        return rating;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getName() {
        return name;
    }
}
