//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #240403
//Name: #Tee Li Hong

package com.tlh.rt_assignment2.RTasgmt2;

import static com.tlh.rt_assignment2.RTasgmt2.RTasgmt2.KEYWORDS;
import static com.tlh.rt_assignment2.RTasgmt2.RTasgmt2.PATH;
import static com.tlh.rt_assignment2.RTasgmt2.RTasgmt2.filename;
import static com.tlh.rt_assignment2.RTasgmt2.RTasgmt2.sheet;
import static com.tlh.rt_assignment2.RTasgmt2.RTasgmt2.workbook;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import org.apache.poi.ss.usermodel.Row;


public class Details2 {
    
    public static int[] keywordcount1 = new int[55];
    
public void details2() throws IOException {
        int empty1 = 0;
        int commentsNo1 = 0;
        int actualLOC1 = 0;
        int linenumber1 = 0;
        int totalkeyword1 = 0;
        int total1 = 0;

        try {
            File file = new File(PATH + "\\MyThread2.java");

            BufferedReader b = new BufferedReader(new FileReader(file));
            String readLine = "";

            Row row9 = sheet.createRow(8);

            try {
                while ((readLine = b.readLine()) != null) {

                    //System.out.println(readLine); //print whole java file content
                    if (readLine.contains("//Semester: #")) {
                        //row1.createCell(1).setCellValue(readLine.split("#")[1]);
                        //System.out.println(readLine.split("#")[1]);
                    } else if (readLine.contains("//Course: #")) {
                        //row2.createCell(1).setCellValue(readLine.split("#")[1]);
                        //System.out.println(readLine.split("#")[1]);
                    } else if (readLine.contains("//Group: #")) {
                        //row3.createCell(1).setCellValue(readLine.split("#")[1]);
                        //System.out.println(readLine.split("#")[1]);
                    } else if (readLine.contains("//Task: #")) {
                        //row4.createCell(1).setCellValue(readLine.split("#")[1]);
                        //System.out.println(readLine.split("#")[1]);
                    } else if (readLine.contains("//Matrik: #")) {
                        row9.createCell(0).setCellValue(readLine.split("#")[1]);
                        //System.out.println(readLine.split("#")[1]);
                    }

                    if (readLine.isEmpty() || readLine.trim().length() == 0) {
                        empty1++;
                    }

                    if (readLine.startsWith("//")) {
                        commentsNo1++;
                    }

                    for (int i = 0; i < KEYWORDS.length; i++) {
                        if (readLine.contains(KEYWORDS[i])) {
                            //delete comments to show the list of all the keywords
                            //System.out.println(KEYWORDS[i]);
                            keywordcount1[i]++;
                        }
                    }

                }

                for (int count = 0; count < KEYWORDS.length; count++) {
                    if (keywordcount1[count] != 0) {
                        //System.out.println(KEYWORDS[count] + ":" + keywordcount[count]);
                    }
                    totalkeyword1 += keywordcount1[count];
                }
                int x = 5;
                for (int index = 1; index < KEYWORDS.length; index++) {
                    if (keywordcount1[index] != 0) {
                        row9.createCell(x).setCellValue(keywordcount1[index]);
                        x++;
                    }
                }

                row9.createCell(2).setCellValue(empty1);
                row9.createCell(3).setCellValue(commentsNo1);

                //System.out.println("total:" + totalkeyword);
                //System.out.println("Total number of empty lines : " + empty);
                //System.out.println("Total number of comments : " + commentsNo);
                if (file.exists()) {

                    FileReader fr = new FileReader(file);
                    Reader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                    LineNumberReader lnr = new LineNumberReader(reader);

                    while (lnr.readLine() != null) {
                        linenumber1++;
                    }
                    row9.createCell(1).setCellValue(linenumber1);
                    //System.out.println("Total number of lines : " + linenumber);
                    actualLOC1 = linenumber1 - empty1 - commentsNo1;
                    row9.createCell(4).setCellValue(actualLOC1);
                    //System.out.println("Actual LOC = " + actualLOC);
                    total1 = totalkeyword1 + actualLOC1;
                    row9.createCell(12).setCellValue(total1);
                    lnr.close();

                } else {
                    //System.out.println("File does not exists!");
                }

            } catch (IOException e) {
            }

        } catch (IOException e) {
        }
        FileOutputStream fileOut = new FileOutputStream(filename);
        workbook.write(fileOut);
        fileOut.close();
    }
}