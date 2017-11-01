//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #240403
//Name: #Tee Li Hong

package com.tlh.rt_assignment2;

import com.tlh.rt_assignment2.RTasgmt2.Details2;
import com.tlh.rt_assignment2.RTasgmt2.Path;
import static com.tlh.rt_assignment2.RTasgmt2.Path.folderName;
import static com.tlh.rt_assignment2.RTasgmt2.RTasgmt2.sheet;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Assert;
import org.junit.Test;

public class TestDetails2 {
    
    @Test
    public void testdetails2() throws IOException {
        
        //Test Path
        Path.setPath(folderName);

        String expectedFile = Paths.get("").toAbsolutePath().toString() + File.separator + folderName + File.separator + "MyThread2.java";
        String actualFile = Path.getPath() + File.separator + "MyThread2.java";
        Assert.assertEquals(expectedFile, actualFile);
        //finish Test Path
        
        //Test content
        Details2 analyse2 = new Details2();
        analyse2.details2();

        //Row Bank
        Row row9 = sheet.getRow(8);

        //TestMatricNo2
        Assert.assertEquals("123456", row9.getCell(0).getStringCellValue());

        //Display number of keywords1 
        int n0 = (int) row9.getCell(5).getNumericCellValue();
        int n1 = (int) row9.getCell(6).getNumericCellValue();
        int n2 = (int) row9.getCell(7).getNumericCellValue();
        int n3 = (int) row9.getCell(8).getNumericCellValue();
        int n4 = (int) row9.getCell(9).getNumericCellValue();
        int n5 = (int) row9.getCell(10).getNumericCellValue();
        int n6 = (int) row9.getCell(11).getNumericCellValue();

        int[] n = {n0, n1, n2, n3, n4, n5, n6};
        int[] expectedkeywordNo1 = {1, 1, 2, 1, 2, 1, 2};
        Assert.assertArrayEquals(expectedkeywordNo1, n);
        
        //Display result1 **about line of file**
        int p7 = (int) row9.getCell(1).getNumericCellValue(); //test line number(LOC)
        int p8 = (int) row9.getCell(2).getNumericCellValue(); //test empty line
        int p9 = (int) row9.getCell(3).getNumericCellValue(); //test comment no
        int p10 = (int) row9.getCell(4).getNumericCellValue(); //test actual LOC
        int p11 = (int) row9.getCell(12).getNumericCellValue(); //test total

        int[] p = {p7, p8, p9, p10, p11};
        int[] expectedresult2 = {30, 6, 7, 17, 27};
        Assert.assertArrayEquals(expectedresult2, p);

    }
}
