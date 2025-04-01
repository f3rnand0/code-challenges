package technical.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestsExpressions {
    public static void main(String[] args) {
        List<Integer[]> list = new ArrayList();
        list.add(new Integer[]{1, 2});
        list.add(new Integer[]{3, 4});
        list.remove(0);
        list.set(0, new Integer[]{1, 2});
        list.add(1, new Integer[]{1, 2});
        List<Integer> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        Arrays.asList("".split(",")).stream().skip(1).collect(Collectors.toList());
        Collections.sort(list1);
        list1.indexOf(1);
        Set<Integer> set = new HashSet<>();
        int[][] array = new int[2][2];
        int a = array.length;
        int b = array[1].length;
        Set<Integer> membersSet = new HashSet<>();
        list2.add(a + "" + b);
        Queue q1 = new LinkedList();
        int[] array1 = {1, 2};
        Arrays.copyOf(array1, 1);
        Arrays.sort(array, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(array1);
        Map<String, Integer> map = new HashMap<>();
        list2.get(0).split(",", 4);
        Queue<Integer> queue = new LinkedList<>();
        queue.poll();
        Collections.sort(list2);
        String str = "abc";
        map.get("a");
        str += 'd';
        System.out.println(str);
        List<String> list3 = new ArrayList<>();
        list3.add("abc");
        for (String c : list3) {
            c += "cde";
        }
        System.out.println(list3);
        Stack<Integer> stack = new Stack<>();
        char ch = '{';
        List<Character> list4 = new ArrayList<>();
        list4.add(ch);
        char c = str.charAt(0);
        List<Integer> linkedList = new LinkedList();
        System.out.println((5/2));
        int[] arr1 = new int[100000];
        Arrays.fill(arr1, 2);
        //System.out.println(Arrays.toString(arr));

        // Generate random integer array
        Random rd = new Random();
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt();
        }
        System.out.println(Arrays.toString(arr));

        List<Integer> list5 = Arrays.stream(arr).boxed().collect(Collectors.toList());
        str = "abc";
        System.out.println(str.indexOf('d'));

        final String ab = "";
        Stream stream = Stream.iterate("", (s) -> s + "1");
        System.out.println(stream.limit(2).map(x -> x+ "2" ));
        StringBuilder sb = new StringBuilder();
    }


}