//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #240403
//Name: #Tee Li Hong

package com.tlh.rt_assignment2;

import com.tlh.rt_assignment2.RTasgmt2.Details1;
import com.tlh.rt_assignment2.RTasgmt2.Path;
import static com.tlh.rt_assignment2.RTasgmt2.Path.folderName;
import com.tlh.rt_assignment2.RTasgmt2.RTasgmt2;
import static com.tlh.rt_assignment2.RTasgmt2.RTasgmt2.PATH;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Assert;
import org.junit.Test;

public class TestDetails1 extends RTasgmt2 {
    
    @Test
    public void testdetails1() throws IOException {

        //Test Path
        Path pathName = new Path(PATH);
        pathName.setPath(folderName);

        String expectedFile = Paths.get("").toAbsolutePath().toString() + "\\" + folderName + "\\MyThread1.java";
        String actualFile = pathName.getPath() + "\\MyThread1.java";
        Assert.assertEquals(expectedFile, actualFile);
        //finish Test Path

        //Test Content
        Details1 analyse1 = new Details1();
        analyse1.details1();

        //Row bank
        Row row1 = sheet.getRow(0);
        Row row2 = sheet.getRow(1);
        Row row3 = sheet.getRow(2);
        Row row4 = sheet.getRow(3);
        Row row6 = sheet.getRow(5);
        Row row7 = sheet.getRow(6);
        Row row8 = sheet.getRow(7);

        //Test Course Info
        String a = row1.getCell(0).getStringCellValue();
        String b = row2.getCell(0).getStringCellValue();
        String c = row3.getCell(0).getStringCellValue();
        String d = row4.getCell(0).getStringCellValue();

        ArrayList<String> actualInfo = new ArrayList(Arrays.asList(a, b, c, d));
        ArrayList<String> expectedInfo = new ArrayList(Arrays.asList("Semester", "Course", "Group", "Task"));
        Assert.assertEquals(expectedInfo, actualInfo);

        String e = row1.getCell(1).getStringCellValue();
        String f = row2.getCell(1).getStringCellValue();
        String g = row3.getCell(1).getStringCellValue();
        String h = row4.getCell(1).getStringCellValue();

        ArrayList<String> actualInfo1 = new ArrayList(Arrays.asList(e, f, g, h));
        ArrayList<String> expectedInfo1 = new ArrayList(Arrays.asList("A171", "STIW3054", "A", "Assignment1"));
        Assert.assertEquals(expectedInfo1, actualInfo1);
        //finish Test Course Info

        //Display title "java keyword"
        String i = row6.getCell(5).getStringCellValue();
        Assert.assertEquals("java keyword", i);
        
        //TestMatricNo1
        Assert.assertEquals("898989", row8.getCell(0).getStringCellValue());
                        
        //Display keywords
        String j0 = row7.getCell(5).getStringCellValue();
        String j1 = row7.getCell(6).getStringCellValue();
        String j2 = row7.getCell(7).getStringCellValue();
        String j3 = row7.getCell(8).getStringCellValue();
        String j4 = row7.getCell(9).getStringCellValue();
        String j5 = row7.getCell(10).getStringCellValue();
        String j6 = row7.getCell(11).getStringCellValue();

        ArrayList<String> j = new ArrayList(Arrays.asList(j0, j1, j2, j3, j4, j5, j6));
        ArrayList<String> expectedkeyword = new ArrayList(Arrays.asList("class", "extends", "new", "package", "public", "static", "void"));
        Assert.assertEquals(expectedkeyword, j);
               
        //Display number of keywords 
        int k0 = (int) row8.getCell(5).getNumericCellValue();
        int k1 = (int) row8.getCell(6).getNumericCellValue();
        int k2 = (int) row8.getCell(7).getNumericCellValue();
        int k3 = (int) row8.getCell(8).getNumericCellValue();
        int k4 = (int) row8.getCell(9).getNumericCellValue();
        int k5 = (int) row8.getCell(10).getNumericCellValue();
        int k6 = (int) row8.getCell(11).getNumericCellValue();

        int[] k = {k0, k1, k2, k3, k4, k5, k6};
        int[] expectedkeywordNo = {1,1,1,1,2,1,2};
        Assert.assertArrayEquals(expectedkeywordNo, k);
        
        //Test field name
        String l1 = row7.getCell(0).getStringCellValue();
        String l2 = row7.getCell(1).getStringCellValue();
        String l3 = row7.getCell(2).getStringCellValue();
        String l4 = row7.getCell(3).getStringCellValue();
        String l5 = row7.getCell(4).getStringCellValue();
        String l6 = row7.getCell(12).getStringCellValue();

        ArrayList<String> l = new ArrayList(Arrays.asList(l1, l2, l3, l4, l5, l6));
        ArrayList<String> expectedFieldName = new ArrayList(Arrays.asList("Matrik", "LOC", "Blank", "Comment", "ActualLOC", "Total"));
        Assert.assertEquals(expectedFieldName, l);
        //finish display field name
        
        //Display result **about line of file**
        int m1 = (int) row8.getCell(1).getNumericCellValue(); //test line number(LOC)
        int m2 = (int) row8.getCell(2).getNumericCellValue(); //test empty line
        int m3 = (int) row8.getCell(3).getNumericCellValue(); //test comment no
        int m4 = (int) row8.getCell(4).getNumericCellValue(); //test actual LOC
        int m5 = (int) row8.getCell(12).getNumericCellValue(); //test total
        
        int[] m = {m1, m2, m3, m4, m5};
        int[] expectedresult = {24,4,6,14,23};
        Assert.assertArrayEquals(expectedresult, m);

    }
  
}
