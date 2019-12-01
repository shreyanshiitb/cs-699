import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.List;
import java.nio.charset.StandardCharsets;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*; 

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.FileInputStream;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


public class q4{

    private static JFrame f=new JFrame();
    private static String fileName;
    private static JPanel panel = new JPanel();
    private static String stopWords = "";


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
      // and, the, is, in, at, of, his, her, him, ...
      stopWords = stopWords.replaceAll(" +","");
      ArrayList<String> newData = new ArrayList<String>() ;
      ArrayList<String> stopWordFinal = new ArrayList<String>(Arrays.asList((stopWords.split(","))));
      for(int i=0;i<data.length;i++) {
        if(!stopWordFinal.contains(data[i]))
          newData.add(data[i]);
      }
      return newData; 
    }
    public static List<Map.Entry<String, Integer>> sortMap(LinkedHashMap<String, Integer> map) 
    {
      List<Map.Entry<String, Integer>> sortedList = new LinkedList<>(map.entrySet());
  
      Collections.sort(sortedList, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
      return sortedList;
    }

    public static DefaultTableModel toJTable(List<Map.Entry<String, Integer>> sortedList) 
    {
        DefaultTableModel model = new DefaultTableModel(new Object[] { "Word", "Frequency" }, 0);
        for (Map.Entry<String, Integer> entry : sortedList)
            model.addRow(new Object[] { entry.getKey(), entry.getValue() });
        return model;
    }
    public static void getFilename(){
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(f);
        File file = fileChooser.getSelectedFile();

        if (result == JFileChooser.APPROVE_OPTION) {
          if(file.exists()){
            fileName = fileChooser.getSelectedFile().getAbsolutePath();
          } else{
            System.out.println("file does not exist");
          }
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("No file is selected");
        } else if (result == JFileChooser.ERROR_OPTION) {
            System.out.println("Error!");
        } else if (file == null) {
            System.out.println("No File is chosen");
        }
    }
     public static void processing(String fileName) {
        
        String fileExtension = getExtension(fileName);
        String data="";

        try {
          if(!fileExtension.equals(".txt"))
            data = fileExtension.equals(".pdf") ? readFromPdf(fileName):readFromDoc(fileName);
          else
            data = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
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
        List<Map.Entry<String, Integer>> sortedMap = sortMap(map);
        JPanel panel2 = new JPanel();
        DefaultTableModel tableModel = toJTable(sortedMap);
        JTable wordFreqTable = new JTable(tableModel);
        panel.setVisible(false);
        panel2.add(new JScrollPane(wordFreqTable));
        JScrollPane scrPanel = new JScrollPane(panel2);
        f.add(scrPanel);
        
     }

    public static void main(String args[]) throws IOException {

        JTextField stopwords = new JTextField("and, the, is, in, at, of, his, her, him, ..."); 
        JButton uploadFile = new JButton("Upload");  
        JButton processButton = new JButton("Process");  
        panel.add(stopwords);
        panel.add(uploadFile);
        panel.add(processButton);
        f.add(panel);
        f.setSize(600,300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        uploadFile.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){  
                getFilename();
            }  
        });  

        processButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                stopWords = stopwords.getText();
                processing(fileName);
            }  
        });  

  }

}