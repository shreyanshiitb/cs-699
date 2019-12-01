import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*; 

public class q5 
{ 
  public static String readAsString(String fileName)throws Exception 
  { 
    String data = ""; 
    data = new String(Files.readAllBytes(Paths.get(fileName))); 
    return data; 
  } 
  public static String removePunctuations(String data)throws Exception 
  { 
    data = data.replaceAll("[^A-Za-z0-9']"," ");
    data = data.replaceAll("\n"," ");
    data = data.trim().replaceAll(" +", " ");
    return data; 
  }
  public static ArrayList<String> removeStopWords(String[] data)throws Exception 
  { 
    // String[] stopWords = {"and", "the", "is", "in", "at", "of","his","her","him"};
    ArrayList<String> newData = new ArrayList<String>() ;
    ArrayList<String> stopWords = new ArrayList<String>(Arrays.asList("and", "the", "is", "in", "at", "of","his","her","him")) ;
    for(int i=0;i<data.length;i++) {
      if(!stopWords.contains(data[i]))
        newData.add(data[i]);
    }
    return newData; 
  }
  public static void sortMapAndPrint(LinkedHashMap<String, Integer> map)throws Exception 
  {
    List<Map.Entry<String, Integer>> sortedList = new LinkedList<>(map.entrySet());

    Collections.sort(sortedList, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

    for (Map.Entry<String, Integer> entry : sortedList)
      System.out.println(entry.getKey()+"\t"+entry.getValue());
  }

  public static void main(String[] args) throws Exception 
  { 
    String data = readAsString(args[0]); 
    data = removePunctuations(data);
    String[] stringValues = data.split(" ");
    ArrayList<String> list = removeStopWords(stringValues);

    LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
    for (String s : list) {
      if (map.containsKey(s))
        map.put(s, map.get(s) + 1);
      else
        map.put(s, 1);
    }
    sortMapAndPrint(map);
  }
} 
