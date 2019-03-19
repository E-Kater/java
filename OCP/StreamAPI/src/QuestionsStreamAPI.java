import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionsStreamAPI {
    public static void main(String[] args){
        q1(); //Java [OCAJP Java, OCPJP Java, OCEJPA Java]

    }

    public static void q1(){
        List<Course> s1 = Arrays.asList(
                new Course("OCAJP", "Java"),
                new Course("OCPJP", "Java"),
                new Course("C#", "C#"),
                new Course("OCEJPA", "Java")
        );

        s1.stream()
                .collect(Collectors.groupingBy(c->c.getCategory()))
                .forEach((m, n)->System.out.println(n));
    }

}


 class Course{
    private String id;
    private String category;

    public Course(String id, String category){
        this.id = id; this.category = category;
    }

    public String toString(){
        return id+" "+category;
    }

     public String getCategory() {
         return category;
     }
 }





