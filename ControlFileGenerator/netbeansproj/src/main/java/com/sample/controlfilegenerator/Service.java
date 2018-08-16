package com.sample.controlfilegenerator;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.misc.BASE64Decoder;

public class Service {

    private static Logger logger = LogManager.getLogger(Service.class);
    private AppDAO appDAO = null;

    public Service() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        appDAO = applicationContext.getBean("appDAO", AppDAO.class);
    }

    public int generateControlFiles(int size, List<ItemType> caseList, String folder) throws IOException {
        int numberOfGroup = caseList.size() / size;
        if (caseList.size() % size > 0) {
            numberOfGroup++;
        }

        for (int i = 0; i < numberOfGroup; i++) {
            List<ItemType> subList = null;
            //last loop
            if(i==numberOfGroup-1){
                subList = caseList.subList(i * size, caseList.size());
            }else{
                subList = caseList.subList(i * size, i * size + size);
            }
            writeListToControlFile(folder + "\\control_group" + (i + 1) + ".txt", subList);
        }

        
        return numberOfGroup;
    }

    public void clearResultFile(String resultPath) {
        Arrays.stream(new File(resultPath).listFiles()).forEach(File::delete);
    }

    public void writeStringToFile(String filename, String str) throws IOException {
        Files.write(Paths.get(filename), str.getBytes());
    }

    public void writeListToControlFile(String filename, List<ItemType> itemList) throws IOException {
        StringBuffer sb = new StringBuffer();
        sb.append("<control-file>\n");
        for (ItemType it : itemList) {
            sb.append("<case>\n");
            sb.append("  <number-id>\n");
            sb.append("    " + it.getMemberId() + "\n");
            sb.append("  </number-id>\n");
            sb.append("  <file-name>\n");
            sb.append("    " + it.getFileName() + "\n");
            sb.append("  </file-name>\n");
            sb.append("  <ssn>\n");
            sb.append("    123-45-****\n");
            sb.append("  </ssn>\n");
            sb.append("</case>\n");
        }
        sb.append("</control-file>");
        Files.write(Paths.get(filename), sb.toString().getBytes());
    }

    public void writeSetToFile(String filename, Set<ItemType> itSet) throws IOException {
        StringBuffer sb = new StringBuffer();
        for (ItemType it: itSet){
            sb.append(it.toString()+"\n");
        }
        Files.write(Paths.get(filename), sb.toString().getBytes());
    }

    public void writeStringSetToFile(String filename, Set<String> strSet) throws IOException {
          Files.write(Paths.get(filename), strSet);
      /*
        StringBuffer sb = new StringBuffer();
        for (String str: strSet){
            sb.append(str+"\n");
        }
        Files.write(Paths.get(filename), sb.toString().getBytes());
*/
    }

    
    public void writeListToFile(String filename, List<ItemType> itList) throws IOException {
        StringBuffer sb = new StringBuffer();
        for (ItemType it: itList){
            sb.append(it.toString()+"\n");
        }
        Files.write(Paths.get(filename), sb.toString().getBytes());
    }

    public List<ItemType> getDuplicatedRecords(List<ItemType> itemTypeList) {
        List<ItemType> duplicatedList = itemTypeList.stream().filter(i -> Collections.frequency(itemTypeList, i) > 1)
                .collect(Collectors.toList());
        return duplicatedList;
    }

    public String getCaseNumberFromFileName(String fileName, String startsWith) {
        String caseNumber = null;
        int beginning = startsWith.length();

        if (fileName.charAt(beginning + 8) == '_' || fileName.charAt(beginning + 8) == '-' || fileName.charAt(beginning + 8) == '.' || fileName.charAt(beginning + 8) == ' ') {
            caseNumber = fileName.substring(beginning, beginning + 8);
        } else if (fileName.charAt(beginning + 7) == '_' || fileName.charAt(beginning + 7) == '-' || fileName.charAt(beginning + 7) == '.' || fileName.charAt(beginning + 7) == ' ') {
            caseNumber = fileName.substring(beginning, beginning + 7);
        } else if (fileName.charAt(beginning + 6) == '_' || fileName.charAt(beginning + 6) == '-' || fileName.charAt(beginning + 6) == '.' || fileName.charAt(beginning + 6) == ' ') {
            caseNumber = fileName.substring(beginning, beginning + 6);
        } else if (fileName.charAt(beginning + 9) == '_' || fileName.charAt(beginning + 9) == '-' || fileName.charAt(beginning + 9) == '.' || fileName.charAt(beginning + 9) == ' ') {
            caseNumber = fileName.substring(beginning, beginning + 9);
        }

        return caseNumber;
    }
    
    
}
