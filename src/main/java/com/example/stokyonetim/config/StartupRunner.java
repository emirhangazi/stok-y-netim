package com.example.stokyonetim.config;

import com.example.stokyonetim.model.Urun;
import com.example.stokyonetim.util.GenericPrinter;
import com.example.stokyonetim.algorithm.AramaAlgoritmalari;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class StartupRunner implements CommandLineRunner {
    @Override
    public void run(String... args) {
        // Temel Java: Döngü ve değişken
        int toplam = 0;
        for (int i = 1; i <= 5; i++) {
            toplam += i;
        }
        System.out.println("1'den 5'e kadar toplam: " + toplam);

        // Generic örneği
        GenericPrinter.print("GenericPrinter ile yazıldı!");
        GenericPrinter.print(123);

        // Java 8 fonksiyonel programlama (lambda, stream)
        List<Urun> urunler = Arrays.asList(
                Urun.builder().ad("Kalem").stokMiktari(10).fiyat(15).build(),
                Urun.builder().ad("Defter").stokMiktari(5).fiyat(25).build()
        );
        urunler.stream()
                .filter(u -> u.getFiyat() > 10)
                .forEach(u -> System.out.println("Stream ile: " + u.getAd()));

        // Arama algoritması örneği
        int index = AramaAlgoritmalari.dogrusalArama(Arrays.asList("a","b","c"), "b");
        System.out.println("'b' harfinin indexi: " + index);
    }
} 