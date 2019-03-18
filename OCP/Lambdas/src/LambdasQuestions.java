import java.util.Arrays;
import java.util.List;

public class LambdasQuestions {
    public static int size(List<String> names) {
        return names.size() * 2;
    }

    public static void process(List<String> names, LambdasQuestions.Carnivore c) {
        c.eat(names);
    }

    interface Carnivore {
        default int calories(List<String> food) {
            return food.size() * 100;
        }

        int eat(List<String> foods);
    }


    public static void q1(){
        List<String> fnames = Arrays.asList("a", "b", "c");
        Tiger t = new Tiger();
        process(fnames, t::eat);
        process(fnames, t::calories);
        process(fnames, TestClassLambda::size);
      //  process(fnames, Carnivore::calories); // non-static method cannot be referenced from a static context
       // process(fnames, Tiger::eat) //  non-static method cannot be referenced from a static context

    }


    public static void main(String[] args) {

        q1();

    }
}

class Tiger implements LambdasQuestions.Carnivore {
    public int eat(List<String> foods) {
        System.out.println("Eating " + foods);
        return foods.size() * 200;
    }
}
 class TestClassLambda {
    public static int size(List<String> names){
        return names.size()*2;
    }
    public static void process(List<String> names, LambdasQuestions.Carnivore c){
        c.eat(names);
    }

}




