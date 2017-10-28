//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #240403
//Name: #Tee Li Hong

package com.tlh.rt_assignment2.RTasgmt2;

import java.io.File;
import java.nio.file.Paths;

public class Path implements Runnable{
    public static String absolutePath, folderName;
    
    public Path(String pfolder){
        folderName = pfolder;
    }
    
    public void run(){
        setPath(folderName);
    }
    
    public static void setPath(String folderName){
    String currentPath = Paths.get("").toAbsolutePath().toString();
    absolutePath = currentPath + File.separator + folderName;        
    }
    
    public static String getPath(){
        return absolutePath;
    }
}

