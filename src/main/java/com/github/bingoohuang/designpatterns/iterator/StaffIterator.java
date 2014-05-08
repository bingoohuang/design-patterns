package com.github.bingoohuang.designpatterns.iterator;

import com.github.bingoohuang.designpatterns.Staff;
import com.github.bingoohuang.designpatterns.UserBuilder;

import java.io.*;
import java.util.Iterator;

public class StaffIterator implements Iterator<Staff> {
    private final FileInputStream fis;
    private final BufferedReader br;

    public StaffIterator() {
        try {
            this.fis = new FileInputStream(new File("users.txt"));
            this.br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Staff staff;

    @Override
    public boolean hasNext() {
        try {
            String line = br.readLine();

            if (line != null) {
                staff = parseLine(line);
            } else {
                staff = null;
            }

            return line != null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Staff parseLine(String line) {
        String[] fields = line.split("\\s+");

        return UserBuilder.newBuilder(fields[0], fields[1])
                .age(Integer.parseInt(indexInt(fields, 2)))
                .phone(indexStr(fields, 3))
                .city(indexStr(fields, 4))
                .buildStaff();
    }

    private String indexStr(String[] fields, int ind) {
        return fields.length > ind ? fields[ind] : "";
    }

    private String indexInt(String[] fields, int ind) {
        return fields.length > ind ? fields[ind] : "0";
    }

    @Override
    public Staff next() {
        return staff;
    }

    @Override
    public void remove() {
        // ignore
    }
}
