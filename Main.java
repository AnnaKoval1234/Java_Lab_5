import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class Main
{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[1;32m";
    public static final String ANSI_CYAN = "\u001B[1;36m";

    public static Scanner in = new Scanner(System.in);
    private MyCollection mc = new MyCollection();

    private ArrayList<Integer> randomList()
    {
        ArrayList<Integer> arr = new ArrayList<>();
        int N = (int)(Math.random() * 9 + 1);
        for (int i = 0; i < N; i++)
        {
            int num = (int)(Math.random() * 10);
            num = num * (int)(Math.pow(-1, num % 2));
            arr.add(num);
        }
        return arr;
    }
    private Deque<Integer> randomQueue()
    {
        Deque<Integer> queue = new ArrayDeque<>();
        int N = (int)(Math.random() * 9 + 1);
        for (int i = 0; i < N; i++)
        {
            int num = (int)(Math.random() * 10);
            num = num * (int)(Math.pow(-1, num % 2));
            queue.add(num);
        }
        return queue;
    }

    public void Task_1()
    {
        System.out.println(ANSI_CYAN + "Задание 1. Шаблоны" + ANSI_RESET);
        System.out.println("Надо ввести три дроби.");
        FractionDecorator fd = new FractionDecorator(1, 1);
        for (int i = 0; i < 3; i++)
        {
            int num = Check.inputInteger("Введите числитель: ");
            int den = Check.inputNotNullInteger("Введите знаменатель: ");

            fd.setFraction(num, den);

            System.out.println("Запись числа в виде обыкновенной дроби: " + fd);
            System.out.println("Запись в виде десятичной дроби: " + fd.toDouble());
        }
    }
    public void Task_2()
    {
        System.out.println(ANSI_CYAN + "Задание 2. Структурные шаблоны" + ANSI_RESET);
        System.out.println("Дайте имя первому коту: ");
        String name_1 = in.nextLine();
        System.out.println("Дайте имя второму коту: ");
        String name_2 = in.nextLine();

        Cat cat_1 = new Cat(name_1);
        Cat cat_2 = new Cat(name_2);

        CatDecorator cd1 = new CatDecorator(cat_1);
        CatDecorator cd2 = new CatDecorator(cat_2);

        int N = (int)(Math.random() * 9 + 1);
        int M = (int)(Math.random() * 9 + 1);

        for (int i = 0; i < N; i++)
            cd1.meow();
        for (int i = 0; i < M; i++)
            cd2.meow();

        System.out.println("Количество мяуканий первого кота: " + cd1.getCountMeow());
        System.out.println("Количество мяуканий второго кота: " + cd2.getCountMeow());
    }
    public void Task_3()
    {
        System.out.println(ANSI_CYAN + "Задание 3. Список" + ANSI_RESET);
        ArrayList<Integer> list = randomList();
        System.out.println("Сгенерированный список: " + list);
        int value = Check.inputInteger("Введите значение, которое надо удалить: ");
        System.out.println("Список, из которого удалили значение: " + mc.myRemoveAll(list, value));
    }
    public void Task_4()
    {
        System.out.println(ANSI_CYAN + "Задание 4. Мап" + ANSI_RESET);
        try
        {
            File file = new File("task4.txt");
            Scanner scanner = new Scanner(file);
            System.out.println(mc.cheapSourCream(scanner));
            scanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Файл не найден!");
        }
    }
    public void Task_5()
    {
        System.out.println(ANSI_CYAN + "Задание 5. Сет" + ANSI_RESET);
        try
        {
            File file = new File("task5.txt");
            Scanner scanner = new Scanner(file);
            System.out.println(mc.VoicedConsonants2(scanner));
            scanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Файл не найден!");
        }
    }
    public void Task_6()
    {
        System.out.println(ANSI_CYAN + "Задание 6. Очередь" + ANSI_RESET);
        Deque<Integer> q1 = randomQueue();
        System.out.println("Сгенерированная очередь: " + q1);
        Deque<Integer> q2 = mc.reverseQueue(q1);
        System.out.println("Очередь в обратном порядке: " + q2);
    }

    public static void main(String args[])
    {   
        Main m = new Main();
        // m.Task_1();
        // m.Task_2();
        m.Task_3();
        // m.Task_4();
        // m.Task_5();
        // m.Task_6();
    }
}