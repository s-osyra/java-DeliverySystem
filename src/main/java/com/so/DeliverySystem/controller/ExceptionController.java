package com.so.DeliverySystem.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.*;
import java.sql.Timestamp;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public void exception (Exception e) {
        e.printStackTrace();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String direction = System.getProperty("user.dir");
        String path = direction.replaceAll("\\\\", "/");
        String pathFolder = path + "/unhandledExceptionsLog";
        String pathFile = pathFolder + "/unhandledException_" + timestamp.getTime()+".txt";
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String data = sw.toString();
        System.out.print(data);

        try {
            File folder = new File(pathFolder);
            if (!folder.exists()){
                folder.mkdirs();
            }
            File f1 = new File(pathFile);

            if(!f1.exists()) {
                f1.createNewFile();
            }
            FileWriter fileWritter = new FileWriter(pathFile,true);
            BufferedWriter bw = new BufferedWriter(fileWritter);
            bw.write(data);
            bw.close();
        } catch(IOException error){
            error.printStackTrace();
        }
    }
}
