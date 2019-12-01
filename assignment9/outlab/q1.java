import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*; 
import java.nio.charset.StandardCharsets;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.FileInputStream;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


public class q1 {

    public static String getExtension(String filename){
      return filename.substring(filename.lastIndexOf('.'));
    }
    public static String readFromDoc(String fileName)
    {
      String text = "";
      try{
        XWPFDocument docx = new XWPFDocument(new FileInputStream(fileName));
        XWPFWordExtractor wordExtractor = new XWPFWordExtractor(docx);
        text = wordExtractor.getText();
      }
      catch(Exception e){
        System.out.println(e);
        System.exit(0);
      }
      return text;
    }
    public static String readFromPdf(String fileName) 
    { 
        String text = "";
        try{
            PDDocument document = PDDocument.load(new File(fileName));       
            PDFTextStripper pdfExtractor = new PDFTextStripper();
            text = pdfExtractor.getText(document);
            document.close();
        }
        catch(Exception e){
            System.out.println(e);
            System.exit(0);
        }
        return text;
      } 
    public static String removePunctuations(String data) 
    { 
      data = data.replaceAll("[^A-Za-z0-9']"," ");
      data = data.replaceAll("\n"," ");
      data = data.trim().replaceAll(" +", " ");
      return data; 
    }
    public static ArrayList<String> removeStopWords(String[] data) 
    { 
      // String[] stopWords = {"and", "the", "is", "in", "at", "of","his","her","him"};
      ArrayList<String> newData = new ArrayList<String>() ;
      ArrayList<String> stopWords = new ArrayList<String>(Arrays.asList("and", "the", "is", "in", "at", "of","his","her","him","...")) ;
      for(int i=0;i<data.length;i++) {
        if(!stopWords.contains(data[i]))
          newData.add(data[i]);
      }
      return newData; 
    }
    public static void sortMapAndPrint(LinkedHashMap<String, Integer> map) 
    {
      List<Map.Entry<String, Integer>> sortedList = new LinkedList<>(map.entrySet());
  
      Collections.sort(sortedList, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
  
      for (Map.Entry<String, Integer> entry : sortedList)
        System.out.println(entry.getKey()+"\t"+entry.getValue());
    }
    public static void main(String args[]) throws IOException {
    String fileExtension = getExtension(args[0]);
    String data="";
    try {
      if(!fileExtension.equals(".txt"))
        data = fileExtension.equals(".pdf") ? readFromPdf(args[0]):readFromDoc(args[0]);
      else
        data = new String(Files.readAllBytes(Paths.get(args[0])), StandardCharsets.UTF_8);
    }
    catch(Exception e){
      System.exit(0);
    }

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
