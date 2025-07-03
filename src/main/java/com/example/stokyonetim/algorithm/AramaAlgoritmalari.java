package com.example.stokyonetim.algorithm;

import java.util.List;

public class AramaAlgoritmalari {
    // Basit bir doğrusal arama algoritması
    public static <T> int dogrusalArama(List<T> list, T aranan) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(aranan)) {
                return i;
            }
        }
        return -1;
    }
} 