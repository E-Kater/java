import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestExample {

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        //q1(); //Exception in thread "main" AgeOutOfLimitException
        q2(); // Only a “Searching…” message is printed because the Predicate returns false when compares “green” with “red”.
        q3(); // \app\.\sys\log  \n \readme
        q4(); //Travel time is 4 hours
        Test.q5(); // compilation error
        //q6(); // The code prints the content of the employee.txt file and throws an exception.
        q7(); //prints 10 20 15 30
        //q8(); //Exception in thread "main" java.nio.file.NoSuchFileException: c:\temp\green.txt (yellow.txt includes the content of green file)
        q9();
        q10();
        q11();//The program prints files names concurrently.
        //q12(); //The program prints Call Call and does not terminate.
        q13(); //Exception in thread “main” java.lang.AssertionError: No interest for this account (if assertions are enabled)
        q14(); // A compilation error occurs at line n2
        q15(); // compilation error - bad return type in lambda : double cannot be converted to Integer
        q16(); // 2016-02-14
        q17(); // John Jim
        q18();
        q19(); //  there is no terminal operation for the stream. The program prints nothing.
        q20(); // DOC MPEG JPEG \nMPEGJPEG
        q21(); // 0
        q22(); //  ensure that the run methods of both the Worker and Master classes are executed
        q23(); // 4
        q24(); //  compilation error replaceAll UnaryOperator<Integer> cannot be applied to UnaryOperator<Double>
        q25(); // The program prints the content of data.txt file.
    }


    public static void q1() throws UserException {
        System.out.println("****q1****");
        App t = new App();
        t.doRegister("Mathew", 60);
    }

    public static void q2() {
        System.out.println("****q2****");
        List<String> colors = Arrays.asList("red", "green", "yellow");
        Predicate<String> test = n -> {
            System.out.println("Searching…");
            return n.contains("red");
        };
        colors.stream()
                .filter(c -> c.length() > 3) // [green, yellow]
                .allMatch(test); // check green -> false.

    }

    public static void q3() {
        System.out.println("****q3****");
        Path path1 = Paths.get("/app/./sys/");
        Path res1 = path1.resolve("log");
        Path path2 = Paths.get("/server/exe/");
        Path res2 = path2.resolve("/readme/");
        System.out.println(res1);
        System.out.println(res2); // because (“/readme/”) is absolute path therefore this path will not change with resolve method and result with same path /readme.
    }

    public static void q4() {
        System.out.println("****q4****");
        ZonedDateTime depart = ZonedDateTime.of(2015, 1, 15, 3, 0, 0, 0, ZoneId.of("UTC-7")); //  2015-01-15 03:00:00
        ZonedDateTime arrive = ZonedDateTime.of(2015, 1, 15, 9, 0, 0, 0, ZoneId.of("UTC-5")); // 2015-01-15 09:00:00
        long hrs = ChronoUnit.HOURS.between(depart, arrive); //line n1 9 - 3 = 6 - difference 2 hours = 4 hours
        System.out.println("Travel time is " + hrs + " hours");
    }

    public static void q6() throws IOException {
        System.out.println("****q6****");
        BufferedReader brCopy = null;
        try (BufferedReader br = new BufferedReader(new FileReader("c:\\temp\\employee.txt"))) { // line n1
            br.lines().forEach(System.out::println);
            brCopy = br; //line n2
        }
        brCopy.ready();  // Exception in thread "main" java.io.IOException: Stream closed
    }

    public static void q7() {
        System.out.println("****q7****");
        List<Integer> list1 = Arrays.asList(10, 20);
        List<Integer> list2 = Arrays.asList(15, 30);
        Stream.of(list1, list2) // Stream<List<Integer>>
                .flatMap(list -> list.stream()) // List<Integer>> -> Integer
                .forEach(s -> System.out.print(s + " "));
    }

    public static void q8() throws IOException {
        System.out.println("****q8****");
        Path source = Paths.get("c:\\temp\\green.txt");
        Path target = Paths.get("c:\\temp\\yellow.txt");
        //use the CopyOption StandardCopyOption.ATOMIC_MOVE, which will move the file’s actions to atomic,
        // that is, it will not be involved in other threads (such as the ability to grab write access to files)
        Files.move(source, target, StandardCopyOption.ATOMIC_MOVE); // yellow.txt includes the content of green file
        Files.delete(source);//Exception in thread "main" java.nio.file.NoSuchFileException: c:\temp\green.txt
    }

    public static void q9() {
        System.out.println("****q9****");
        List<TechName> tech = Arrays.asList(
                new TechName("Java-"),
                new TechName("Oracle DB-"),
                new TechName("J2EE-")
        );
        Stream<TechName> stre = tech.stream();
        // stre.forEach(System.out::print); //TechName@7cc355beTechName@6e8cf4c6TechName@12edcd21
        stre.map(a -> a.techName).forEach(System.out::print); //Java-Oracle DB-J2EE-
        //stre.map(a-> a).forEachOrdered(System.out::print); //TechName@6e8cf4c6TechName@12edcd21TechName@34c45dca
        // stre.forEachOrdered(System.out::print); //TechName@7cc355beTechName@6e8cf4c6TechName@12edcd21
    }

    public static void q10() {
        System.out.println("****q10****");
        String[] strArray = new String[]{"Tiger", "Rat", "Cat", "Lion"};
        Arrays.sort(strArray, CheckClass::checkValue); //Rat Cat Lion Tiger
        //Arrays.sort(strArray, (CheckClass::new)::checkValue); // method reference expression is not expected here (CheckClass::new)
        // Arrays.sort(strArray, (CheckClass::new).checkValue); //method reference expression is not expected here (CheckClass::new)
        // Arrays.sort(strArray, CheckClass::new::checkValue); cannot resolve CheckClass constructor
        for (String s : strArray) {
            System.out.print(s + " ");
        }
    }

    /*The Files method’s walk method can use depth-first to access incoming file paths.
    ExecutorService object’s execute method can use the new thread to execute the passed Runnable object.
    The shutdown method can close the ExecutorService object so that it no longer accepts new executable objects (Runnable or Callable),
    but does not wait for the currently executing and queuing work to complete.
    The awaitTermination method can specify an upper limit to wait for the ExecutorService object to complete all work processing.
    */
    public static void q11() throws IOException, InterruptedException {
        System.out.println("****q11****");
        ExecutorService executor = Executors.newCachedThreadPool();
        Stream<Path> listOfFiles = Files.walk(Paths.get("c:\\temp"));
        listOfFiles.forEach(line -> {
            executor.execute(new FileThread(line.getFileName().toString
                    ())); // line n1
        });
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.DAYS); // line n2
    }

    public static void q12() throws InterruptedException, ExecutionException {
        System.out.println("****q12****");
        ExecutorService es = Executors.newFixedThreadPool(4); //line n1
        Future f1 = es.submit(new CallerThread("Call"));
        String str = f1.get().toString();
        System.out.println(str);
        {
            System.out.println("****q12****");
            {
                ExecutorService es1 = Executors.newFixedThreadPool(4); //line n1
                Future future1 = es1.submit(new CallerThread("Call"));
                String str1 = future1.get().toString();
                System.out.println(str1);
            }
        }

        // Since there is no shutdown related method for calling the ExecutorService object, the program will not stop executing.
    }

    public static void q13(){
        System.out.println("****q13****");
            int rateOfInterest = 0;
            String accountType = "LOAN";
            switch (accountType) {
                case "RD": // warning - switch label is unreachable
                    rateOfInterest = 5;
                    break;
                case "FD": // warning - switch label is unreachable
                    rateOfInterest = 10;
                    break;
                default:
                    // assume that assertion were enabled java –ea RateOfInterest
                    assert false: "No interest for this account"; //line n1
                    //Exception in thread “main” java.lang.AssertionError: No interest for this account
            }
            System.out.println ("Rate of interest:" + rateOfInterest);
        }

    public static void q14() {
        System.out.println("****q14****");
        UnaryOperator<Integer> uo1 = s -> s*2; //line n1
        List<Double> loanDoubleValues = Arrays.asList(1000.0, 2000.0);
        List<Integer> loanIntegerValues = Arrays.asList(1000, 2000);
        loanDoubleValues.stream()
                .filter(lv -> lv >= 1500)
              //  .map(lv -> uo1.apply(lv)) //line 2  error - apply in Function cannot be applied to java.lang.Double
                .forEach(s -> System.out.print(s + " "));
        loanIntegerValues.stream()
                .filter(lv -> lv >= 1500)
                .map(lv -> uo1.apply(lv)) // all is ok
                .forEach(s -> System.out.print(s + " "));
    }

    public static void q15(){
        //BiFunction<Integer, Double, Integer> val = (t1, t2) -> t1 + t2; //line n1 compilation error - bad return type in lambda : double cannot be converted to Integer
        //System.out.println(val.apply(10, 10.5));
    }

    public static void q16(){
        System.out.println("****q16****");
        LocalDate valentinesDay =LocalDate.of(2015, Month.FEBRUARY, 14);
        LocalDate nextYear = valentinesDay.plusYears(1);
        nextYear.plusDays(15); //line n1 result is ignored
        System.out.println(nextYear); //2016-02-14
    }

    public static void q17(){
        System.out.println("****q17****");
        List<Emp>li = Arrays.asList(new Emp("Sam", 20), new Emp("John", 60), new Emp("Jim", 51));
        Predicate<Emp> agVal = s -> s.getEAge() > 50; //line n1
        li = li.stream().filter(agVal).collect(Collectors.toList());
        Stream<String> names = li.stream().map(Emp::getEName); //line n2
        names.forEach(n -> System.out.print(n + " ")); //John Jim
    }

    public static void q18(){
        System.out.println("****q18****");
        Moveable<Integer> animal = n -> System.out.println("Running" + n);
        animal.run(100);
        animal.walk(20);
       // Moveable<Integer> animal2 = n -> n + 10; // bad return type in lambda expression: int cannot be converted to void
        // Moveable animal3 = (Integer n) -> System.out.println(n); // incompatible parameter types in lambda: expected Object but found Integer


    }
    public static void q19(){
        System.out.println("****q19****");
        List<String> nL = Arrays.asList("Jim", "John", "Jeff");
        Function<String, String> funVal = s -> "Hello : ".concat(s);
        nL.stream()
                .map(funVal)
                .peek(System.out::print); // result of peek is ignored
    }

    public static void q20(){
        System.out.println("****q20****");
        List<String> codes = Arrays.asList ("DOC", "MPEG", "JPEG");
        codes.forEach (c -> System.out.print(c + " "));
        String fmt = codes.stream()
                .filter (s-> s.contains ("PEG"))
                .reduce((s, t) -> s + t).get(); // Optional get without ifPresent (warning)
        System.out.println("\\n" + fmt);
    }

    public static void q21() {
        System.out.println("****q21****");
        String str = "Java is a programming language";
        ToIntFunction<String> indexVal = str::indexOf; //line n1 find the index of substring "Java"
        int x = indexVal.applyAsInt("Java"); //line n2
        System.out.println(x);
    }


    public static void q22() {
        System.out.println("****q22****");
        Master master = new Master();
        CyclicBarrier cb = new CyclicBarrier(1, master);
        Worker worker = new Worker(cb);
        worker.start();
        // CyclicBarrier cb = new CyclicBarrier(master); -   the CyclicBarrier does not have this constructor.
        // CyclicBarrier cb = new CyclicBarrier(2, master);
        // After the CyclicBarrier object materialization method needs to call CyclicBarrier’s await method twice,
        // the program after the await method will be executed. However, in the given program, await is only called on the 11th line,
        // so forever It is not possible to execute line 12 and it is also impossible to execute the master Runnable object.
    }

    public static void q23() {
        System.out.println("****q23****");
        Customer c1 = new Customer("Larry", "Smith");
        Customer c2 = new Customer("Pedro", "Gonzales");
        Customer c3 = new Customer("Penny", "Jones");
        Customer c4 = new Customer("Lars", "Svenson");
        c4 = null;
        c3 = c2;
        System.out.println (Customer.getCount());
    }

    public static void q24() {
        System.out.println("****q24****");
        List<Integer> codes = Arrays.asList (10, 20);
        UnaryOperator<Double> uo = s -> s +10.0;
       // codes.replaceAll(uo); // compilation error replaceAll UnaryOperator<Integer> cannot be applied to UnaryOperator<Double>
        codes.forEach(c -> System.out.println(c));
    }

    public static void q25() {
        System.out.println("****q25****");
        Stream<Path> paths = Stream.of (Paths. get("c:\\temp\\data.doc"),
                Paths. get("c:\\temp\\data.txt"),
                Paths. get("c:\\temp\\data.xml"));
        paths.filter(s-> s.toString().endsWith("txt")).forEach(
                s -> {
                    try {
                        Files.readAllLines(s)
                                .stream()
                                .forEach(System.out::println); //line n1
                         } catch (IOException e) {
                        System.out.println("Exception");
                    }
                }
        );
    }



}


class UserException extends Exception { }
class AgeOutOfLimitException extends UserException { }

class App {
    public void doRegister(String name, int age)
            throws UserException, AgeOutOfLimitException {
        if (name.length () < 6) { // length("Mathew") = 6
            throw new UserException ();
        } else if (age >= 60) { // age = 60
            throw new AgeOutOfLimitException ();
        } else {
            System.out.println("User is registered.");
        }
    }


}

//****** question **********
//Which two class definitions compile
interface Doable {
    public void doSomething (String s);
}
 abstract class Task implements Doable {
    public void doSomethingElse(String s) { } //ok
}
/*
public abstract class Work implements Doable {
     abstract void doSomething(String s) { }// abstract method cannot contain body, compilation error
    public void doYourThing(Boolean b) { }
}(/


 class Job implements Doable { //class Job must either be declared abstract or implement abstract method DoSomething
public void doSomething(Integer i) { }
}
 class Action implements Doable {
    public void doSomething(Integer i) { }
    public String doThis(Integer j) { } // missing return statement
*/
 class Do implements Doable {
    public void doSomething(Integer i) { }
    public void doSomething(String s) { }
    public void doThat (String s) { }
}
//********************************************


    class Book {
    private String read(String bname) { return "Read" + bname ;}
}

class EBook extends Book {
    public String read(String url) {
        return "View" + url;
    }
}

class Test {
    public static void q5(){
        Book b1 = new Book();
     //   b1.read("Java Programing");
        Book b2 = new EBook();
     //   b2.read("http://ebook.com/ebook");
    }
    // The Test.java file fails to compile. Method read has private access modifier in class Book.java and both b1 and b2 are of reference type Book so compiler checks there first.
}


class TechName {
    String techName;
    TechName (String techName) {
        this.techName=techName;
    }
}

class CheckClass {
    public static int checkValue (String s1, String s2) {
        return s1.length()- s2.length();
    }
}


 class FileThread implements Runnable {
    String fName;
    public FileThread(String fName) { this.fName = fName; }
    public void run () {System.out.println(fName+ " " + Thread.currentThread().getName());}

}

        class CallerThread implements Callable<String> {
            String str;
            public CallerThread(String s) {this.str=s;}
            public String call() throws Exception {
                return str.concat("Call");
            }
        }


 class Emp{
        private String eName;
        private Integer eAge;
        Emp(String eN, Integer eA) {
            this.eName = eN;
            this.eAge = eA;
        }
        public Integer getEAge () {return eAge;}
        public String getEName () {return eName;}
}


/*
class FuelNotAvailException extends Exception { }
class Vehicle {
    void ride() throws FuelNotAvailException { //line n1
        System.out.println("Happy Journey!");
    }
}
class SolarVehicle extends Vehicle {
    public void ride () throws Exception { //line n2 compilation error ride overridden does not throw java.lang.Exception
        super.ride ();
    }
}
*/

 interface Moveable<Integer> {
    public default void walk (Integer distance) {
        System.out.println("Walking");
    }
        public void run(Integer distance);
    }

class Worker extends Thread {
    CyclicBarrier cb;
    //CyclicBarrier is a Java built-in class, located in the java.util.concurrent suite,
    // that allows a thread to wait until a specified number of threads call the CyclicBarrier await method before continuing.
    public Worker(CyclicBarrier cb) { this.cb = cb; }
    public void run () {try {
        cb.await();
        System.out.println("Worker…");
    } catch (Exception ex) { }
    }
}
class Master implements Runnable { //line n1
    public void run () {
        System.out.println("Master…");
    }
}

 class Customer {
    private String fName;
    private String lName;
    private static int count;
    public Customer (String first, String last) {fName = first; lName = last;
        ++count;}
    static { count = 0; }
    public static int getCount() {return count; }
}