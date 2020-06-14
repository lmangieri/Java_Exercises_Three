package leandromangieri.java8exercises3;

import leandromangieri.java8exercises3.Model.Fruit;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class LambdaExercises
{
    public void creatingThreadsJava7vsJava8() {
        System.out.println("No java 7 era muito comum criar classes anônimas com implementação de 1 único método para dentro de classes");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Esta é a forma antiga de criar um Runnable no java 7.");
            }
        }).run();

        System.out.println("No java 8 temos o conceito de Single Method Interface... esses são os casos onde podemos utilizar lambda.");

        new Thread(() -> System.out.println("Nova forma de criar thread usando lambda no java 8")).run();
        System.out.println("O caso acima funciona porque existe um único construtor dentro de Thread que recebe um parâmetro Runnable");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
    }

    public void comparingObjectsJava7AndJava8() {
        System.out.println("Mostrando abaixo uma possível forma de ordenar uma lista no java 7");
        List<Fruit> fruits = this.createFruitList();
        Collections.sort(fruits, new Comparator<Fruit>() {
            @Override
            public int compare(Fruit f1, Fruit f2) {
                return f1.getSize().compareTo(f2.getSize());
            }
        });
        System.out.println(fruits);

        System.out.println("Mostrando abaixo uma possível forma de ordenar uma lista no java 8");
        List<Fruit> fruits2 = this.createFruitList();
        System.out.println("Na forma abaixo eu estou passando a implementação implicita do Comparator para dentro do Collections.sort");
        Collections.sort(fruits2,(e1, e2) -> e2.getSize().compareTo(e1.getSize()));

        System.out.println("Se eu colocar {} na implementação... eu preciso adicionar o retorno");
        Collections.sort(fruits2,(e1, e2) -> {
            return e2.getSize().compareTo(e1.getSize());
        });

        System.out.println("Se eu quiser, também posso definir os parâmetros");
        Collections.sort(fruits2,(Fruit e1,Fruit e2) -> {
            return e2.getSize().compareTo(e1.getSize());
        });

        System.out.println(fruits2);

        System.out.println("A proveitando o exemplo... vamos ver como fica a ordenação com streams");
        List<Fruit> fruits3 = this.createFruitList();
        fruits3.stream().sorted((e1, e2) -> {
                    return e2.getSize().compareTo(e1.getSize());
                }).forEach(System.out::println);

        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
    }

    public static void main( String[] args ) {
        LambdaExercises lambdaExercises = new LambdaExercises();
        lambdaExercises.creatingThreadsJava7vsJava8();
        lambdaExercises.comparingObjectsJava7AndJava8();
    }

    private List<Fruit> createFruitList() {
        Fruit f1 = Fruit.builder().name("apple1").size(4).build();
        Fruit f2 = Fruit.builder().name("apple2").size(1).build();
        Fruit f3 = Fruit.builder().name("apple3").size(9).build();
        Fruit watermelon = Fruit.builder().name("watermelon").size(250).build();
        Fruit f4 = Fruit.builder().name("orange1").size(12).build();
        Fruit f5 = Fruit.builder().name("orange2").size(0).build();
        Fruit f6 = Fruit.builder().name("orange3").size(98).build();
        return Arrays.asList(f1,f2,f3,watermelon,f4,f5,f6);
    }
}
