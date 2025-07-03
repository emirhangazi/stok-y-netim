# Stok Yönetimi - Java Spring Boot Projesi

Bu proje, Java ileri seviye konularını kapsayan, hızlıca deploy edilebilen basit bir stok yönetimi uygulamasıdır.

## Kapsanan Konular
- Temel Java Konuları
- Java 8 Fonksiyonel Programlama (Lambda, Stream)
- Koleksiyonlar ve OOP
- Sıralama ve Arama Algoritmaları
- Generic Programlama
- Multithread Programlama
- Veritabanı Bağlantısı (H2)
- J2EE Temelleri (Spring Boot Controller)
- Web Programlama (REST API)
- Popüler Java Kütüphaneleri (Spring Boot, Maven)

## Özellikler
- Ürün ekle, listele, güncelle, sil (CRUD)
- H2 veritabanı ile bağlantı
- Java 8 ve multithread örnekleri
- Docker ile deploy edilebilir
- (Opsiyonel) Basit HTML frontend

## Deploy
- Docker ile çalıştırılabilir.
- Railway, AWS gibi platformlara kolayca deploy edilebilir.

## Çalıştırmak için
```bash
mvn clean install
mvn spring-boot:run
```

Docker ile çalıştırmak için:
```bash
docker build -t stok-yonetim .
docker run -p 8080:8080 stok-yonetim
``` 