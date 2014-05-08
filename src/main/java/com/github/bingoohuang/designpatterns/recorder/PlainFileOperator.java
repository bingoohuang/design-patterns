package com.github.bingoohuang.designpatterns.recorder;

import java.io.*;
import java.util.Scanner;

public class PlainFileOperator implements FileOperator {
    private final File file;

    public PlainFileOperator(File file) {
        this.file = file;
    }

    @Override
    public void appendFile(String history) {
        FileOutputStream fos = null;
        PrintStream ps = null;

        try {
            fos = new FileOutputStream(file, true);
            ps = new PrintStream(fos, false, "UTF-8");
            ps.print(history);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeFile(fos, ps);
        }
    }

    @Override
    public String readFile() {
        try {
            return new Scanner(file, "UTF-8").useDelimiter("\\A").next();
        } catch (FileNotFoundException e) {
            return "none history";
        }
    }


    private void closeFile(FileOutputStream fos, PrintStream ps) {
        try {
            fos.close();
            ps.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
