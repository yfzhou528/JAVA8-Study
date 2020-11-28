package chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Apple {
    String color;
    double weight;

    public Apple(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    static List<Apple> filterApple(List<Apple> list, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();
        list.add(new Apple("green", 110));
        System.out.println(filterApple(list, Apple::isGreenApple));
        System.out.println(filterApple(list, Apple::isHeavyApple));
        System.out.println(filterApple(list, (Apple apple) -> "green".equals(apple.getColor())));
        List<Apple> collect = list.stream().filter((Apple apple) -> "green".equals(apple.getColor())).collect(Collectors.toList());
        System.out.println(collect);

        System.out.println("aa");
    }
}
