import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        LinkedList<Character> list = new LinkedList<>();
        for (char ch : str.toCharArray()) {
            list.add(ch);
        }

        ListIterator<Character> iter = list.listIterator(list.size());
        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            switch (command.charAt(0)) {
                case 'L':
                    if (iter.hasPrevious()) iter.previous();
                    break;
                case 'D':
                    if (iter.hasNext()) iter.next();
                    break;
                case 'B':
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    char ch = command.charAt(2);
                    iter.add(ch);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
