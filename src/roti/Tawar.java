/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roti;

import java.util.stream.IntStream;

/**
 *
 * @author BrxxN
 */
public class Tawar extends Roti {
    // Komposisi roti manis
    private final int[] komposisi = {
        1000, //0.Tepung Terigu
        125,  //1.Gula Pasir
        100,  //2.Butter
        20,   //3.Ragi
        250,  //4.Susu Bubuk
        200,  //5.Susu Cair
        70,   //6.Telur
        300   //7.Es Batu
    };
    
    // Berat dough per pcs
    private final int beratPerPcs = 400;    

    // Constructor
    public Tawar() {
        this.jenisRoti = "Roti Tawar";
    }

    // Method untuk melakukan validasi input nomor Varian
    @Override
    public void pilihVarian(int nomorVarian) {
        if (nomorVarian < 0 || nomorVarian > 2){
            System.out.println("Varian Tidak Valid!");
            System.exit(0);
        }
        
        this.nomorVarian = nomorVarian;
    }

    @Override
    protected void hitungVarian() {
        
        // Switch Case untuk menghitung total bahan berdasarkan pilihan Varian
        switch (this.nomorVarian){
            case 1 -> {
                this.filling.put("Coklat", 80 * this.jumPesanan);
                break;
                
            }
                
            case 2 -> {
                this.filling.put("Keju", 80 * this.jumPesanan);
                break;
            }
            
            default -> {
                System.out.println("Varian Tidak Valid");
                System.exit(0);
            }
        }
        
        // Menambahkan bahan filling ke objek varian untuk perhitungan total bahan
        for (String k : this.filling.keySet()){
            this.varian.put(k, this.filling.get(k));
        }
    }

    // Method untuk menghitung BERAT per bahan yang diperlukan berdasarkan banyaknya pesanan dan komposisi
    @Override
    protected void hitungTotalBahan() {
        double beratDough = IntStream.of(this.komposisi).sum();
        
        double beratTotal = this.beratPerPcs * this.jumPesanan;
        
        this.totalDough = beratTotal;
        this.tepungTerigu = beratTotal / beratDough * this.komposisi[0];
        this.gulaPasir = beratTotal / beratDough * this.komposisi[1];
        this.butter = beratTotal / beratDough * this.komposisi[2];
        this.ragi = beratTotal / beratDough * this.komposisi[3];
        this.susuBubuk = beratTotal / beratDough * this.komposisi[4];
        this.susuCair = beratTotal / beratDough * this.komposisi[5];
        this.telur = beratTotal / beratDough * this.komposisi[6];
        this.esBatu = beratTotal / beratDough * this.komposisi[7];
    }
}
