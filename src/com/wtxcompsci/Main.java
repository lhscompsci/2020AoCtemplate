package com.wtxcompsci;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner inf = new Scanner(new File(("input.dat")));

        long prod = 1L;

        ArrayList<String> map = new ArrayList<>();

        while(inf.hasNext()){
            map.add(inf.nextLine());
        }
        int[] xs = {1,3,5,7,1};
        int[] ys = {1,1,1,1,2};
        for (int i=0; i<xs.length; i++) {

            int treeCount = 0;

            int x = 0;
            for (int y = ys[i]; y < map.size(); y+=ys[i]) {
                x = ((x + xs[i]) < map.get(y).length()) ? x + xs[i] : (x + xs[i]) % map.get(y).length();
                if (map.get(y).charAt(x) == '#')
                    treeCount++;
            }
            System.out.println(treeCount);
            prod = prod * (long)treeCount;
        }
        System.out.println(prod);
    }
}
