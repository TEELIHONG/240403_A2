//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #240403
//Name: #Tee Li Hong

package com.tlh.rt_assignment2.RTasgmt2;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RTasgmt2 {

    public static final String PATH = "Assignment2_TestFiles";

    public static final String KEYWORDS[] = {"abstract", "assert", "boolean",
        "break", "byte", "case", "catch", "char", "class", "const",
        "continue", "default", "do", "double", "else", "enum", "extends",
        "false", "final", "finally", "float", "for", "goto", "if", "implements",
        "import", "instanceof", "int ", "interface", "long", "native",
        "new", "null", "package", "private", "protected", "public",
        "return", "short", "static", "strictfp", "super", "switch",
        "synchronized", "this", "throw", "throws", "transient", "true",
        "try", "void", "volatile", "while"};

    public static String filename = "output.xls";
    public static XSSFWorkbook workbook = new XSSFWorkbook();
    public static XSSFSheet sheet = workbook.createSheet("RT Assignment 2");

    public static void main(String[] args) throws Exception {
        //Class Path
        Path pathName = new Path(PATH);
        Thread pth = new Thread(pathName);
        pth.start();
        pth.join();

        //*Delete comment to check path*
        //System.out.println("my path is " + pfolder);
        Details1 analyse1 = new Details1();
        analyse1.details1();
        
        Details2 analyse2 = new Details2();
        analyse2.details2();

        System.out.println("Complete!");

    }

    /*public void details1() throws IOException {
        int empty = 0;
        int commentsNo = 0;
        int actualLOC = 0;
        int linenumber = 0;
        int totalkeyword = 0;
        int total = 0;

        try {
            File file = new File(PATH + "\\MyThread1.java");

            BufferedReader b = new BufferedReader(new FileReader(file));
            String readLine = "";

            Row row1 = sheet.createRow(0);
            Row row2 = sheet.createRow(1);
            Row row3 = sheet.createRow(2);
            Row row4 = sheet.createRow(3);

            Row row6 = sheet.createRow(5);
            row6.createCell(5).setCellValue("java keyword");

            Row row7 = sheet.createRow(6);
            Row row8 = sheet.createRow(7);

            //System.out.println("Reading file...");
            try {
                while ((readLine = b.readLine()) != null) {

                    row1.createCell(0).setCellValue("Semester");
                    row2.createCell(0).setCellValue("Course");
                    row3.createCell(0).setCellValue("Group");
                    row4.createCell(0).setCellValue("Task");

                    //System.out.println(readLine); //print whole java file content
                    if (readLine.contains("//Semester: #")) {
                        row1.createCell(1).setCellValue(readLine.split("#")[1]);
                        //System.out.println(readLine.split("#")[1]);
                    } else if (readLine.contains("//Course: #")) {
                        row2.createCell(1).setCellValue(readLine.split("#")[1]);
                        //System.out.println(readLine.split("#")[1]);
                    } else if (readLine.contains("//Group: #")) {
                        row3.createCell(1).setCellValue(readLine.split("#")[1]);
                        //System.out.println(readLine.split("#")[1]);
                    } else if (readLine.contains("//Task: #")) {
                        row4.createCell(1).setCellValue(readLine.split("#")[1]);
                        //System.out.println(readLine.split("#")[1]);
                    } else if (readLine.contains("//Matrik: #")) {
                        row8.createCell(0).setCellValue(readLine.split("#")[1]);
                        //System.out.println(readLine.split("#")[1]);
                    }

                    if (readLine.isEmpty() || readLine.trim().length() == 0) {
                        empty++;
                    }

                    if (readLine.startsWith("//")) {
                        commentsNo++;
                    }

                    for (int i = 0; i < KEYWORDS.length; i++) {
                        if (readLine.contains(KEYWORDS[i])) {
                            //delete comments to show the list of all the keywords
                            //System.out.println(KEYWORDS[i]);
                            keywordcount[i]++;
                        }
                    }
                }

                for (int count = 0; count < KEYWORDS.length; count++) {
                    if (keywordcount[count] != 0) {
                        //System.out.println(KEYWORDS[count] + ":" + keywordcount[count]);
                    }
                    totalkeyword += keywordcount[count];
                }

                int x = 5;
                for (int index = 1; index < KEYWORDS.length; index++) {
                    if (keywordcount[index] != 0) {
                        row7.createCell(x).setCellValue(KEYWORDS[index]);
                        row8.createCell(x).setCellValue(keywordcount[index]);
                        x++;
                    }
                }
                
                row7.createCell(0).setCellValue("Matrik");
                row7.createCell(1).setCellValue("LOC");
                row7.createCell(2).setCellValue("Blank");
                row7.createCell(3).setCellValue("Comment");
                row7.createCell(4).setCellValue("ActualLOC");
                row7.createCell(12).setCellValue("Total");

                row8.createCell(2).setCellValue(empty);
                row8.createCell(3).setCellValue(commentsNo);
                //System.out.println("total:" + totalkeyword);
                //System.out.println("Total number of empty lines : " + empty);
                //System.out.println("Total number of comments : " + commentsNo);
                if (file.exists()) {

                    FileReader fr = new FileReader(file);
                    Reader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                    LineNumberReader lnr = new LineNumberReader(reader);

                    while (lnr.readLine() != null) {
                        linenumber++;
                    }
                    row8.createCell(1).setCellValue(linenumber);
                    //System.out.println("Total number of lines : " + linenumber);
                    actualLOC = linenumber - empty - commentsNo;
                    row8.createCell(4).setCellValue(actualLOC);
                    //System.out.println("Actual LOC = " + actualLOC);
                    total = totalkeyword + actualLOC;
                    row8.createCell(12).setCellValue(total);
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
    }

    public void details2() throws IOException {
        int empty = 0;
        int commentsNo = 0;
        int actualLOC = 0;
        int linenumber = 0;
        int totalkeyword = 0;
        int total = 0;

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
                        empty++;
                    }

                    if (readLine.startsWith("//")) {
                        commentsNo++;
                    }

                    for (int i = 0; i < KEYWORDS.length; i++) {
                        if (readLine.contains(KEYWORDS[i])) {
                            //delete comments to show the list of all the keywords
                            //System.out.println(KEYWORDS[i]);
                            keywordcount[i]++;
                        }
                    }

                }

                for (int count = 0; count < KEYWORDS.length; count++) {
                    if (keywordcount[count] != 0) {
                        //System.out.println(KEYWORDS[count] + ":" + keywordcount[count]);
                    }
                    totalkeyword += keywordcount[count];
                }
                int x = 5;
                for (int index = 1; index < KEYWORDS.length; index++) {
                    if (keywordcount[index] != 0) {
                        row9.createCell(x).setCellValue(keywordcount[index]);
                        x++;
                    }
                }

                row9.createCell(2).setCellValue(empty);
                row9.createCell(3).setCellValue(commentsNo);

                //System.out.println("total:" + totalkeyword);
                //System.out.println("Total number of empty lines : " + empty);
                //System.out.println("Total number of comments : " + commentsNo);
                if (file.exists()) {

                    FileReader fr = new FileReader(file);
                    Reader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                    LineNumberReader lnr = new LineNumberReader(reader);

                    while (lnr.readLine() != null) {
                        linenumber++;
                    }
                    row9.createCell(1).setCellValue(linenumber);
                    //System.out.println("Total number of lines : " + linenumber);
                    actualLOC = linenumber - empty - commentsNo;
                    row9.createCell(4).setCellValue(actualLOC);
                    //System.out.println("Actual LOC = " + actualLOC);
                    total = totalkeyword + actualLOC;
                    row9.createCell(12).setCellValue(total);
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
    }*/

}