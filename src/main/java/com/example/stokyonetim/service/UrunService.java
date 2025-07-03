package com.example.stokyonetim.service;

import com.example.stokyonetim.model.Urun;
import com.example.stokyonetim.repository.UrunRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UrunService {
    private final UrunRepository urunRepository;

    public List<Urun> tumUrunleriGetir() {
        return urunRepository.findAll();
    }

    public Optional<Urun> urunGetir(Long id) {
        return urunRepository.findById(id);
    }

    public Urun urunEkle(Urun urun) {
        return urunRepository.save(urun);
    }

    public void urunSil(Long id) {
        urunRepository.deleteById(id);
    }

    public Urun urunGuncelle(Long id, Urun yeniUrun) {
        return urunRepository.findById(id)
                .map(u -> {
                    u.setAd(yeniUrun.getAd());
                    u.setStokMiktari(yeniUrun.getStokMiktari());
                    u.setFiyat(yeniUrun.getFiyat());
                    return urunRepository.save(u);
                }).orElseThrow();
    }

    // Java 8 Stream ile fiyatı 100'den büyük ürünleri getir
    public List<Urun> fiyatiYuzdenBuyukler() {
        return urunRepository.findAll().stream()
                .filter(u -> u.getFiyat() > 100)
                .collect(Collectors.toList());
    }

    // Sıralama algoritması örneği (fiyata göre artan)
    public List<Urun> fiyataGoreSirala() {
        return urunRepository.findAll().stream()
                .sorted(Comparator.comparingDouble(Urun::getFiyat))
                .collect(Collectors.toList());
    }

    // Multithread ile ürünleri asenkron getir
    public CompletableFuture<List<Urun>> tumUrunleriGetirAsync() {
        return CompletableFuture.supplyAsync(urunRepository::findAll);
    }
} 