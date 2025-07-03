package com.example.stokyonetim.controller;

import com.example.stokyonetim.model.Urun;
import com.example.stokyonetim.service.UrunService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/urunler")
@RequiredArgsConstructor
public class UrunController {
    private final UrunService urunService;

    @GetMapping
    public List<Urun> tumUrunler() {
        return urunService.tumUrunleriGetir();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Urun> urunGetir(@PathVariable Long id) {
        return urunService.urunGetir(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Urun urunEkle(@RequestBody Urun urun) {
        return urunService.urunEkle(urun);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Urun> urunGuncelle(@PathVariable Long id, @RequestBody Urun urun) {
        try {
            return ResponseEntity.ok(urunService.urunGuncelle(id, urun));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void urunSil(@PathVariable Long id) {
        urunService.urunSil(id);
    }

    @GetMapping("/fiyat/100den-buyuk")
    public List<Urun> fiyatiYuzdenBuyukler() {
        return urunService.fiyatiYuzdenBuyukler();
    }

    @GetMapping("/sirala/fiyata-gore")
    public List<Urun> fiyataGoreSirala() {
        return urunService.fiyataGoreSirala();
    }

    @GetMapping("/async")
    public List<Urun> tumUrunlerAsync() throws ExecutionException, InterruptedException {
        return urunService.tumUrunleriGetirAsync().get();
    }
} 