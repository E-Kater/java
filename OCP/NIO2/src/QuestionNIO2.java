import java.nio.file.Path;
import java.nio.file.Paths;

public class QuestionNIO2 {
    public static void q1(){

        Path p1 = Paths.get("photos/goa");
        Path p2 = Paths.get("index.html");
        Path p4 = Paths.get("/index.html");;
        Path p3 = p1.relativize(p2);
        System.out.println(p3); //..\..\index.html
        Path p5 = p1.relativize(p4);
        System.out.println(p5); // Exception in thread "main" java.lang.IllegalArgumentException: 'other' is different type of Path

    }


    public static void q2(){

        Path p1 = Paths.get("c:\\temp\\test.txt");
        Path p2 = Paths.get("report.pdf");
        System.out.println(p1.resolve(p2)); // c:\temp\test.txt\report.pdf
        Path p3 = Paths.get("\\report.pdf");
        System.out.println(p1.resolve(p3)); // c:\report.pdf

    }


    public static void q3(){

        Path p1 = Paths.get("\\personal\\readme.txt");
        Path p2 = Paths.get("\\index.html");
        Path p3 = p1.relativize(p2);
        System.out.println(p3);

    }

    public static void main(String[] args){
        //q1();
        q2();
        q3();

    }
}
