package et.tst;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ModuloExample
{
    public static void main(String[] args)
    {
        calcModulo();
        new ModuloExample().cc();
    }

    private void cc()
    {

    }

    private static void calcModulo()
    {
        int num1 = 322;
        int num2 = 10;


        int acum = 0;
        int temp = num1;
        while (temp > 0)
        {

            acum = +temp % 10;
            System.out.println("Остаток от деления ( по модулю) " + temp + " на " + num2 + " равен " + acum);
            temp /= 10;


        }
    }

    @Test
    public void
    givenLambdaShortForm_whenSortingEntitiesByName_thenCorrectlySorted()
    {

        List<Human> humans = Lists.newArrayList(
                new Human("Sarah", 10),
                new Human("Jack", 12)
        );

        humans.sort(Comparator.comparing(Human::getName));

        assertThat(humans.get(0), equalTo(new Human("Jack", 12)));
    }

    @Test
    public void
    testFI()
    {
        SomeFunctionalInterface functionalInterface = new SomeFunctionalInterfaceImpl();
        SomeFunctionalInterface myLambda = (c, b) ->
        {
            String x = "Doing something with c: " + c + " and b: " + b;
            System.out.println(x);
            return x;
        };

        // Вызов метода через лямбда-выражение
        myLambda.doSomething(42, "Hello, world!");
        BiConsumer<Integer, String> doSomething = functionalInterface::doSomething;
        doSomething.accept(123, "adadad");
    }

    @Test
    void stColl()
    {
        List<String> strings = Arrays.asList("1234,,,,,,", "123456789","123456789", "123", "000000", "1", "2");
         Arrays.asList("1234,,,,,,", "123456789","123456789", "123", "000000", "1", "2");


        String s1 = new String();
        // Разделитель
        String delimiter = ", ";

        // Используем Java Stream API для объединения строк
        String result = strings.stream()
                .parallel()
                .distinct()
                .filter(s -> s.length() < 5)
                .map(s -> s.replaceAll(",",""))
                .collect(Collectors.joining(delimiter));

        // Вывод результата
        System.out.println(result);
        int t = Integer.MAX_VALUE +1;
        System.out.println(t);

    }

    @Test
    public void testMap()
    {
        List<User> users = Arrays.asList(
                new User("John", Arrays.asList("Order1", "Order2")),
                new User("Alice", Arrays.asList("Order3", "Order4", "Order5")),
                new User("Bob", Arrays.asList("Order6"))
        );

        // Используем flatMap для объединения списков заказов всех пользователей в единый поток
        List<String> allOrders = users.stream()
                .map(User::getOrders) // Получаем Stream<List<String>>
                .flatMap(List::stream) // Преобразуем в Stream<String>
                .collect(Collectors.toList());

        // Выводим результат
        System.out.println("All Orders: " + allOrders);
    }

    class User
    {
        private String name;
        private List<String> orders;

        public User(String name, List<String> orders)
        {
            this.name = name;
            this.orders = orders;
        }

        public String getName()
        {
            return name;
        }

        public List<String> getOrders()
        {
            return orders;
        }
    }

    private class Human
    {
        String name;
        int age;

        public Human(String name, int age)
        {

            this.name = name;
            this.age = age;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public int getAge()
        {
            return age;
        }

        public void setAge(int age)
        {
            this.age = age;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o)
            {
                return true;
            }
            if (!(o instanceof Human))
            {
                return false;
            }
            Human human = (Human) o;
            return getAge() == human.getAge() && getName().equals(human.getName());
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(getName(), getAge());
        }
    }
}