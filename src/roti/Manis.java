/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roti;


/**
 *
 * @author BrxxN
 */
public class Manis extends Roti {  
    
    // Constructor
    public Manis() {
        this.komposisi = new int[]{
            1000, //0.Tepung Terigu
            150, //1.Gula Pasir
            150, //2.Butter
            20, //3.Ragi
            300, //4.Susu Bubuk
            250, //5.Susu Cair
            80, //6.Telur
            400   //7.Es Batu
};
        this.jenisRoti = "Roti Manis";
        
        // Berat dough per pcs
        this.beratPerPcs = 50;  
    };

// Komposisi roti manis
        // Method untuk melakukan validasi input nomor Varian
    @Override
    public void pilihVarian(int nomorVarian) {
        if (nomorVarian < 0 || nomorVarian > 3){
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
                this.filling.put("Keju", 5 * this.jumPesanan);
                this.filling.put("Coklat", 5 * this.jumPesanan);
                
                this.topping.put("Coklat", 5 * this.jumPesanan);
                break;
            }
                
            case 2 -> {
                this.filling.put("Selai Red Bean", 10 * this.jumPesanan);
                
                this.topping.put("Krim Vanilla", 5 * this.jumPesanan);
                break;
            }
            
            case 3 -> {
                this.filling.put("Keju", 10 * this.jumPesanan);
                this.filling.put("Sosis", 10 * this.jumPesanan);
                break;
            }
            
            default -> {
                System.out.println("Varian Tidak Ada");
                System.exit(0);
            }
        }
        
        // Menambahkan bahan filling ke objek varian untuk perhitungan total bahan
        for (String k : this.filling.keySet()){
            this.varian.put(k, this.filling.get(k));
        }
        
        // Menambahkan bahan topping ke objek varian untuk perhitungan total bahan
        for (String k : this.topping.keySet()){
            if (this.varian.containsKey(k)){
                Integer sum = this.varian.get(k) + this.topping.get(k);
                this.varian.put(k, sum);
                continue;
            }
            this.varian.put(k, this.topping.get(k));
        }
    }

    // Method untuk menghitung BERAT per bahan yang diperlukan berdasarkan banyaknya pesanan dan komposisi
//    @Override
//    protected void hitungTotalBahan() {
//        double beratDough = IntStream.of(this.komposisi).sum();
//        
//        double beratTotal = this.beratPerPcs * this.jumPesanan;
//        
//        this.totalDough = beratTotal;
//        this.tepungTerigu = beratTotal / beratDough * this.komposisi[0];
//        this.gulaPasir = beratTotal / beratDough * this.komposisi[1];
//        this.butter = beratTotal / beratDough * this.komposisi[2];
//        this.ragi = beratTotal / beratDough * this.komposisi[3];
//        this.susuBubuk = beratTotal / beratDough * this.komposisi[4];
//        this.susuCair = beratTotal / beratDough * this.komposisi[5];
//        this.telur = beratTotal / beratDough * this.komposisi[6];
//        this.esBatu = beratTotal / beratDough * this.komposisi[7];
//    }
}
