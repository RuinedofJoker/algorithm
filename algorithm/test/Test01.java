package test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test01 {
    public static void main(String[] args) throws Exception {
        Reader dir = new InputStreamReader(Runtime.getRuntime().exec("cmd /c C: && dir").getInputStream(), "GBK");

        StringBuilder builder = new StringBuilder();
        char[] readChar = new char[1024];
        int readLen;
        while ((readLen = dir.read(readChar)) != -1) {
            builder.append(readChar, 0, readLen);
        }
        dir.close();

        System.out.println(builder);
    }
}
