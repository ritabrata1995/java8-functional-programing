import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

interface Test{
    double calculate(int i);
}
public class ExamplePreDefinedFunctionalInterface {

    static Predicate<Double> greaterThan5 = d -> d>5;
    static Supplier<Double>  getRandomNumber = () -> {return Math.random();};
    static Consumer<Double> printDouble = i -> System.out.println("Generated Number " + i);
    static Function<List<Double>,List<Double>> modify = list -> {
        return list.stream().map(i -> i*10 ).collect(Collectors.toList());
    };

    public static void main(String[] args){

        List<Double> l = new ArrayList<>();
        int  i = 5;
        while (i>0){
            l.add(getRandomNumber.get());
            i--;
        }

        List<Double> mod = modify.apply(l);
        for (Double num : mod) {
            if(greaterThan5.test(num)){
                printDouble.accept(num);
            }
        }

        Test t =  n -> Math.pow(n,5);
        printDouble.accept(t.calculate(2));
    }
}
