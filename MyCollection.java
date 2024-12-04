import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
class MyCollection<T>
{
    boolean isVoicedConsonant(Character sound)
    {
        return switch (Character.toUpperCase(sound)) 
        {
            case 'Б', 'В', 'Г', 'Д', 'Ж', 'З', 'Л', 'М', 'Н', 'Р' -> true;
            default -> false;
        };
    }
    void myRemoveAll(ArrayList<T> list, T value)
    {
        ArrayList<T> temp = new ArrayList<>();
        temp.add(value);
        list.removeAll(temp);
    }
    void cheapSourCream(String filePath)
    {
        File inputFile = new File(filePath);
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(15, 0);
        int cost15 = Integer.MAX_VALUE;
        int cost20 = Integer.MAX_VALUE;
        int cost25 = Integer.MAX_VALUE;

        hm.put(20, 0);
        hm.put(25, 0);
        try
        {
        Scanner inputReader = new Scanner(inputFile);
        int N = Integer.parseInt(inputReader.nextLine());
        for (int i = 0; i < N; i++)
            {
                String line = inputReader.nextLine();
                String[] items = line.split("\\s");
                int fatContent = Integer.parseInt(items[2]);
                int cost = Integer.parseInt(items[3]);
                if (fatContent == 15 && cost < cost15)
                {
                    hm.put(fatContent, 1);
                    cost15 = cost;
                }
                
                else
                {

                }
            }
            System.out.println(hm.get(15) + " " + hm.get(20) + " " + hm.get(25));
            inputReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Файл не найден!");
        }
    }
    ArrayList<Character> printSounds(String filePath)
    {
        HashSet<Character> result = new HashSet<>();
        HashSet<Character> temp = new HashSet<>();
        ArrayList<Character> l = new ArrayList<>();
        try
        {
            File inputFile = new File(filePath);
            Scanner inputReader = new Scanner(inputFile);


            while (inputReader.hasNextLine())
            {
                String line = inputReader.nextLine();
                String[] words = line.split("\\s");

                for (String word: words)
                {
                    for (char c: word.toCharArray())
                    {
                        if (Character.isLetter(c) && isVoicedConsonant(c))
                        {
                            if (!temp.contains(c))
                                temp.add(c);
                            else
                                result.add(c);
                        }
                    }
                    
                }
            }
            l.addAll(result);
            Collections.sort(l);
            inputReader.close();
            
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Файл не найден!");
        }

        return l;
    }
    Deque<T> reverseQueue(Deque<T> q)
    {
        Deque<T> p = new ArrayDeque<>();
        for (T elem: q)
        {
            p.addFirst(elem);
        }
        return p;
    }
}