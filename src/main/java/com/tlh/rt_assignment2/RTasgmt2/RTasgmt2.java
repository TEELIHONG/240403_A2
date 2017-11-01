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

    static final String KEYWORDS[] = {"abstract", "assert", "boolean",
        "break", "byte", "case", "catch", "char", "class", "const",
        "continue", "default", "do", "double", "else", "enum", "extends",
        "false", "final", "finally", "float", "for", "goto", "if", "implements",
        "import", "instanceof", "int ", "interface", "long", "native",
        "new", "null", "package", "private", "protected", "public",
        "return", "short", "static", "strictfp", "super", "switch",
        "synchronized", "this", "throw", "throws", "transient", "true",
        "try", "void", "volatile", "while"};

    public static final String filename = "output.xls";
    public static final XSSFWorkbook workbook = new XSSFWorkbook();
    public static final XSSFSheet sheet = workbook.createSheet("RT Assignment 2");

    public static void main(String[] args) throws Exception {
        //Class Path
        Path pathName = new Path(PATH);
        Thread pth = new Thread(pathName);
        pth.start();
        pth.join();

        Details1 analyse1 = new Details1();
        analyse1.details1();

        Details2 analyse2 = new Details2();
        analyse2.details2();

        System.out.println("Complete!");

    }
}
