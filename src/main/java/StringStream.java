import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Extends PrintStream but intercepts all print methods and capture their results without any printing
 */
public class StringStream extends PrintStream {
    Queue<Object> results;
    public StringStream() {
        super(OutputStream.nullOutputStream()); //The equivalent of >/dev/null, to not send the result anywhere
        results = new ArrayDeque<>() ;
    }

    /**
     * Check if there is at least one object that was 'printed' (i.e. captured by the stream's overridden print* methods)
     * @return true if there are objects to be returned by allPrintedObjects, false otherwise
     */
    public boolean objectsAvailable() {
        return !results.isEmpty();
    }
    public String allPrintedObjects() {
        var res = new StringBuilder();
        for (var obj: results) {
            res.append(obj);
        }
        results.clear();
        return res.toString();
    }
    @Override
    public void println(String s) {
        results.add(s);
    }
    @Override
    public void println(int x) {
        results.add(x);
    }

    @Override
    public void print(boolean b) {
        results.add(b);
    }

    @Override
    public void print(char c) {
        results.add(c);
    }

    @Override
    public void print(int i) {
        results.add(i);
    }

    @Override
    public void print(long l) {
        results.add(l);
    }

    @Override
    public void print(float f) {
        results.add(f);
    }

    @Override
    public void print(double d) {
        results.add(d);
    }

    @Override
    public void print(char[] s) {
        results.add(s);
    }

    @Override
    public void print(String s) {
        results.add(s);
    }

    @Override
    public void print(Object obj) {
        results.add(obj);
    }

    @Override
    public void println() {
        results.add("\n");
    }

    @Override
    public void println(boolean x) {
        results.add(x);
    }

    @Override
    public void println(char x) {
        results.add(x);
    }

    @Override
    public void println(long x) {
        results.add(x);
    }

    @Override
    public void println(float x) {
        results.add(x);
    }

    @Override
    public void println(double x) {
        results.add(x);
    }

    @Override
    public void println(char[] x) {
        results.add(x);
    }

    @Override
    public void println(Object x) {
        results.add(x);
    }
}

