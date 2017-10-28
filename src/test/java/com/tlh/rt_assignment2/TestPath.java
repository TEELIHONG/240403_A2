//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #240403
//Name: #Tee Li Hong

package com.tlh.rt_assignment2;

import com.tlh.rt_assignment2.RTasgmt2.Path;
import static com.tlh.rt_assignment2.RTasgmt2.Path.folderName;
import static com.tlh.rt_assignment2.RTasgmt2.RTasgmt2.PATH;
import java.io.File;
import java.nio.file.Paths;
import org.junit.Assert;
import org.junit.Test;

public class TestPath {
    
   @Test
   public void testSetPath(){
       
        Path pathName = new Path(PATH);
        pathName.setPath(folderName);
        
        String expectedPath = Paths.get("").toAbsolutePath().toString() + File.separator + folderName;
  
        Assert.assertEquals(expectedPath,pathName.getPath());
   }
}
