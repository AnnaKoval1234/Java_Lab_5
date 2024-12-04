
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class MyCollection<T>
{
    public ArrayList<T> myRemoveAll(ArrayList<T> list, T value)
    {
        ArrayList<T> tempList = new ArrayList<>();
        tempList.add(value);
        list.removeAll(tempList);
        return list;
    }
    public String cheapSourCream(Scanner scanner)
    {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(15, Integer.MAX_VALUE);
        hm.put(20, Integer.MAX_VALUE);
        hm.put(25, Integer.MAX_VALUE);
        int cnt15 = 0;
        int cnt20 = 0;
        int cnt25 = 0;

        int N = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < N; i++)
        {
            String line = scanner.nextLine();
            String[] items = line.split("\\s");

            int fatContent = Integer.parseInt(items[2]);
            int cost = Integer.parseInt(items[3]);
            if (hm.get(fatContent) < cost)
            {
                hm.put(fatContent, cost);
                if (fatContent == 15) cnt15 = 1;
                if (fatContent == 20) cnt20 = 1;
                if (fatContent == 25) cnt25 = 1;
            }
            else if (hm.get(fatContent) == cost)
            {
                if (fatContent == 15) cnt15++;
                if (fatContent == 20) cnt20++;
                if (fatContent == 25) cnt25++;
            }
        }
        return hm.get(15) + " " + hm.get(20) + " " + hm.get(25);
    }
    private boolean isVoicedConsonant(Character sound)
    {
        return switch (Character.toUpperCase(sound)) 
        {
            case 'Б', 'В', 'Г', 'Д', 'Ж', 'З', 'Л', 'М', 'Н', 'Р' -> true;
            default -> false;
        };
    }
    public ArrayList<Character> VoicedConsonants2(Scanner scanner)
    {
        ArrayList<Character> result = new ArrayList<>();
        HashSet<Character> sounds1 = new HashSet<>();
        HashSet<Character> sounds2 = new HashSet<>();
        
        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            String[] words = line.split("\\s");

            for (String word: words)
                for (char c: word.toCharArray())
                    if (Character.isLetter(c) && isVoicedConsonant(c))
                        if (!sounds1.contains(c))
                            sounds1.add(c);
                        else
                            sounds2.add(c);
        }

        result.addAll(sounds2);
        Collections.sort(result);
        return result;
    }
    public Deque<T> reverseQueue(Deque<T> queue)
    {
        Deque<T> result = new ArrayDeque<>();
        for (T elem: queue)
            result.addFirst(elem);
        return result;
    }
}