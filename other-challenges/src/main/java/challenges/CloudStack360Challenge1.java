package technical.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CloudStack360Challenge1 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(11);
        list.add(25);
        list.add(4);
        System.out.println(averageList(list));
    }

    public static List<Integer> averageList(List<Integer> list) {
        List<Integer>filteredList = list.stream().map(i -> i * i).filter(e -> e >= 100).collect(Collectors.toList());
        return list;
    }
}
