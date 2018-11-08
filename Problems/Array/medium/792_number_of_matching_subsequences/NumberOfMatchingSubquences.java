//
// Created by Joshua.Cao, 2018/10/29
// 
// https://leetcode.com/problems/number-of-matching-subsequences/
//
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * Given string S and a dictionary of words words, find the number of words[i] 
 * that is a subsequence of S.
 * 
 * Example :
 *   Input: S = "abcde", words = ["a", "bb", "acd", "ace"]
 *   Output: 3
 *   Explanation: There are three words in words that are a subsequence 
 *   of S: "a", "acd", "ace".
 * 
 * Note:
 *   1. All words in words and S will only consists of lowercase letters.
 *   2. The length of S will be in the range of [1, 50000].
 *   3. The length of words will be in the range of [1, 5000].
 *   4. The length of words[i] will be in the range of [1, 50].
 */
public class NumberOfMatchingSubquences {
  public int numMatchingSubque(String S, String[] words) {
    Set<String> yesSet = new HashSet<String>();
    Set<String> noSet = new HashSet<String>();
    int count = 0;
    for(String word: words){
      if(yesSet.contains(word)){
        count++;
        continue;
      }
      if(noSet.contains(word)) continue;
      boolean isSub = isSubseq(S, word);
      if(isSub) {
        yesSet.add(word);
        count++;
      } else {
        noSet.add(word);
      }
    }
    return count;
  }
  
  public boolean isSubseq(String S,String w){
    int index = -1;
    for(char a: w.toCharArray()){
      index = S.indexOf(a, index + 1);
      if(index == -1) return false;
    }
    return true;
  }

  // Accepted, beats 80.78%
  public int numMatchingSubque_2(String S, String[] words) {
    int counter = 0;
    Map<Character, Deque<String>> map = new HashMap<>();
    for (char c = 'a'; c <= 'z'; c++) {
      map.putIfAbsent(c, new LinkedList<String>());
    }
    for (String word: words) {
      map.get(word.charAt(0)).addLast(word);
    }
    for (char c: S.toCharArray()) {
      Deque<String> queue = map.get(c);
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String word = queue.removeFirst();
        if (word.length() == 1) {
          counter++;
        } else {
          map.get(word.charAt(1)).addLast(word.substring(1));
        }
      }
    }
    return counter;
  }

  // Accepted, beats 31.23%
  public int numMatchingSubque_3(String S, String[] words) {
    int counter = 0;
    Map<Character, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < S.length(); i++) {
      char c = S.charAt(i);
      List<Integer> list = map.getOrDefault(c, new ArrayList<>());
      list.add(i);
      map.put(c, list);
    }

    for (String word: words) {
      int index = 0, lastIndex = -1;
      boolean match = true;
      do {
        List<Integer> list = map.get(word.charAt(index));
        if (list == null) {
          match = false;
          break;
        }
        boolean found = false;
        for (Integer i: list) {
          if (i > lastIndex) {
            lastIndex = i;
            found = true;
            break;
          }
        }
        if (!found) {
          match = false;
          break;
        }
        index++;
      } while (index < word.length());
      if (match) counter++;
    }
    return counter;
  }

  // Accepted, beats 20.02%
  public int numMatchingSubque_4(String S, String[] words) {
    int counter = 0;
    for (int i = 0; i < words.length; i++) {
      int lastIndex = -1;
      boolean match = true;
      for (int j = 0; j < words[i].length(); j++) {
        int index = S.indexOf(words[i].charAt(j), lastIndex + 1);
        if (index == -1) {
          match = false;
          break;
        };
        lastIndex = index;
      }
      if (match) counter++;
    }
    return counter;
  }

  public static void main(String[] args) {
    NumberOfMatchingSubquences obj = new NumberOfMatchingSubquences();
    String S = "abcde";
    String[] words = {"a", "bb", "acd", "ace"};
    System.out.println(obj.numMatchingSubque(S, words));
  }
}