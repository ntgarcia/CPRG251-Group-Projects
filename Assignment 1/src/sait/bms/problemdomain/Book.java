package sait.bms.problemdomain;

import java.io.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class Book {
    String ISBN;
    String callNumber;
    int available;
    int total;
    String title;

    // No-arg constructor
    public Book() {
    }

    public Book(String ISBN, String callNumber, int available, int total, String title) {
        this.ISBN = ISBN;
        this.callNumber = callNumber;
        this.available = available;
        this.total = total;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book [ISBN=" + ISBN + ", callNumber=" + callNumber + ", available=" + available + ", total=" + total
                + ", title=" + title + "]";
    }
}