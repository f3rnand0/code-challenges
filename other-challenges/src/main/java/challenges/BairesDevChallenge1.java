package technical.challenges;

import java.util.HashMap;
import java.util.Map;

public class BairesDevChallenge1 {

  // silent, listen -> true
  // silent, listen -> false
  // ssilent, llisten -> false


  // O(n) where n os the lenght of any string
  public boolean isAnagram (String str1, String str2) {
    if ((str1.isEmpty() && str2.isEmpty()) || (str1.length() != str2.length())) {
      return false;
    }

    char[] chars1 = str1.toCharArray();
    char[] chars2 = str2.toCharArray();
    Map<Character, Integer> occurrences1 = new HashMap<>();
    Map<Character, Integer> occurrences2 = new HashMap<>();

    for (char c: chars1) {
      if (occurrences1.containsKey(c)) {
        occurrences1.put(c, occurrences1.get(c) + 1);
      } else {
        occurrences1.put(c, 1);
      }
    }

    for (char c: chars2) {
      if (occurrences2.containsKey(c)) {
        occurrences2.put(c, occurrences2.get(c) + 1);
      } else {
        occurrences2.put(c, 1);
      }
    }

    for (Map.Entry<Character,Integer> entry: occurrences1.entrySet()) {
      if (!occurrences2.containsKey(entry.getKey()) || !(occurrences2.get(entry.getKey()).equals(entry.getValue()))) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    BairesDevChallenge1 bairesDevChallenge1 = new BairesDevChallenge1();
    System.out.println(bairesDevChallenge1.isAnagram("silent", "listen"));
    System.out.println(bairesDevChallenge1.isAnagram("ssilent", "llisten"));
  }
}
