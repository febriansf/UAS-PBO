/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roti;

import bahan.Bahan;
import java.util.HashMap;
import java.util.stream.DoubleStream;
import varian.BahanVarian;

/**
 *
 * @author BrxxN
 */
public abstract class Roti {
    
    // Attribute untuk menyimpan nama Jenis Roti
    protected String jenisRoti;
    
    // Bahan Yang diperlukan
    protected double tepungTerigu;
    protected double gulaPasir;
    protected double butter;
    protected double ragi;
    protected double susuBubuk;
    protected double susuCair;
    protected double telur;
    protected double esBatu;
    protected double totalDough;
    
    // Jumlah Pesananan
    protected int jumPesanan;
    
    // Banyaknya Beli Kemasan per Bahan
    protected double modalBahan[] = new double[8];
    
    // Harga Beli Total Kemasan per Bahan
    protected double modalHarga[] = new double[8];
    
    // Total modal yang diperlukan
    protected double totalModal;
    
    // Attribute untuk menyimpan pilihan varian
    protected int nomorVarian;
    
    // Attribute untuk menyimpan Filling, Topping, Varian
    protected HashMap<String, Integer> filling = new HashMap<String, Integer>();
    protected HashMap<String, Integer> topping = new HashMap<String, Integer>();
    protected HashMap<String, Integer> varian = new HashMap<String, Integer>();
    
    // Validasi Jumlah Pesanan supaya tidak minus
    public void inputPesanan(int jum){
        if (jum > 0){
            this.jumPesanan = jum;
        } else {
            System.out.println("Pesanan tidak boleh minus");
            System.exit(0);
        }
    };
    
    // Abstract Method untuk memilih varian sekaligus validasi
    public abstract void pilihVarian(int nomorVarian);
    
    // Absrtract Method untuk menghitung total bahan per varian
    protected abstract void hitungVarian();
    
    // Entahlah tapi ini abstract method untuk menghitung total BERAT bahan yang diperlukan sesuai komposisi dan jumlah pesanan
    protected abstract void hitungTotalBahan();
    
    // Method untuk menampilkan BERAT bahan yang diperlukan berdasarkan banyaknya pesanan dan komposisi
    public void tampilTotalBahan(){
        hitungVarian();
        hitungTotalBahan();
        System.out.println("");
        System.out.println("=============================================================================");
        System.out.println("=============================================================================");
        System.out.println("Total bahan yang diperlukan untuk membuat " + this.jumPesanan + " pcs " + this.jenisRoti);
        System.out.println("\nVarian : " + this.nomorVarian);
        
        // Menampilkan Bahan Filling dan Topping
        System.out.print("Filling = ");
        for (String k : this.filling.keySet()){
            System.out.print(k + "; ");
        }
        
        System.out.println("");
        
        System.out.print("Topping = ");
        for (String k : this.topping.keySet()){
            System.out.print(k + "; ");
        }
        
        System.out.println("");
        
        System.out.println("============================================================================");
        System.out.printf("Tepung Terigu = %.2f gr \n", this.tepungTerigu);
        System.out.printf("Gula Pasir    = %.2f gr \n", this.gulaPasir);
        System.out.printf("Butter        = %.2f gr \n", this.butter);
        System.out.printf("Ragi          = %.2f gr \n", this.ragi);
        System.out.printf("Susu Bubuk    = %.2f gr \n", this.susuBubuk);
        System.out.printf("Susu Cair     = %.2f gr \n", this.susuCair);
        System.out.printf("Telur         = %.2f gr \n", this.telur);
        System.out.printf("Es Batu       = %.2f gr \n", this.esBatu);
        System.out.println("============================================================================");
        
        System.out.println("Total Bahan Untuk Isian :\n");
        
        for (String k : this.varian.keySet()){
            System.out.println( k + " = " + this.varian.get(k) + " gr");
        }
        
        System.out.println("============================================================================");
        System.out.printf("Berat Total Bahan  Roti  = %.2f gr \n", this.totalDough);        
        System.out.println("============================================================================");
        System.out.println("============================================================================");
    };
    
    // Method untuk menghitung banyaknya bahan yang perlu di beli serta total harga per bahan
    protected void hitungModal() {
        Bahan bahan = new Bahan();
        modalBahan[0] = Math.ceil(this.tepungTerigu / bahan.getBerat("tepungTerigu"));
        modalBahan[1] = Math.ceil(this.gulaPasir / bahan.getBerat("gulaPasir"));
        modalBahan[2] = Math.ceil(this.butter / bahan.getBerat("butter"));
        modalBahan[3] = Math.ceil(this.ragi / bahan.getBerat("ragi"));
        modalBahan[4] = Math.ceil(this.susuBubuk / bahan.getBerat("susuBubuk"));
        modalBahan[5] = Math.ceil(this.susuCair / bahan.getBerat("susuCair"));
        modalBahan[6] = Math.ceil(this.telur / bahan.getBerat("telur"));
        modalBahan[7] = Math.ceil(this.esBatu / bahan.getBerat("esBatu"));
        
        // Looping untuk menghitung total harga bahan yang perlu dibeli.
        for (int i = 0; i < modalBahan.length; i++){
            modalHarga[i] = modalBahan[i] * bahan.getHarga(i);
        }
        
        // Menghitung Total Modal
        this.totalModal += DoubleStream.of(modalHarga).sum();
        
    };
    
    // Method untuk menampilkan banyaknya bahan yang perlu dibeli , total harga per bahan, dan total modal.
    public void tampilModal() {
        hitungModal();
        //System.out.println("=======================================================");
        //System.out.println("=======================================================");
        System.out.println("Bahan yang perlu dibeli untuk Roti: ");
        System.out.println("");
        System.out.printf("Tepung terigu %.0f kemasan dengan total harga Rp.%.0f \n", this.modalBahan[0], this.modalHarga[0]);
        System.out.printf("Gula Pasir    %.0f kemasan dengan total harga Rp.%.0f \n", this.modalBahan[1], this.modalHarga[1]);
        System.out.printf("Butter        %.0f kemasan dengan total harga Rp.%.0f \n", this.modalBahan[2], this.modalHarga[2]);
        System.out.printf("Ragi          %.0f kemasan dengan total harga Rp.%.0f \n", this.modalBahan[3], this.modalHarga[3]);
        System.out.printf("Susu Bubuk    %.0f kemasan dengan total harga Rp.%.0f \n", this.modalBahan[4], this.modalHarga[4]);
        System.out.printf("Susu Cair     %.0f kemasan dengan total harga Rp.%.0f \n", this.modalBahan[5], this.modalHarga[5]);
        System.out.printf("Telur         %.0f kemasan dengan total harga Rp.%.0f \n", this.modalBahan[6], this.modalHarga[6]);
        System.out.printf("Es Batu       %.0f kemasan dengan total harga Rp.%.0f \n", this.modalBahan[7], this.modalHarga[7]);
        System.out.println("=======================================================");
        System.out.println("Bahan yang perlu dibeli untuk Isian: ");
        System.out.println("");
        
        double totalHargaIsian = 0;
        // Looping untuk menampilkan Varian
        for (String k : this.varian.keySet()){
            BahanVarian bahan = new BahanVarian();
            double jumKemasan = Math.ceil(Double.valueOf(this.varian.get(k)) / Double.valueOf(bahan.getBeratKemasan(k)));
            double hargaBahan = jumKemasan * bahan.getHargaKemasan(k);
            
            // Menghitung total harga bahan isian.
            totalHargaIsian += hargaBahan;

            System.out.printf(k + " %.0f kemasan dengan total harga Rp.%.0f \n", jumKemasan, hargaBahan);
        }
        
        // Menambahkan Total Modal dengan Total Harga Isian
        this.totalModal += totalHargaIsian;
        
        System.out.println("=======================================================");
        System.out.println("Total Modal Untuk Bahan Roti Saja = Rp." + DoubleStream.of(modalHarga).sum());
        System.out.println("Total Modal Untuk Bahan Isian Saja = Rp." + totalHargaIsian);
        System.out.println("=======================================================");
        System.out.println("Total Modal Semua Bahan = Rp." + this.totalModal);
        System.out.println("=======================================================");
    }
    
    // Method untuk Menampilkan harga Jual per Pcs apabila ingin Profit 50% dari total modal
    public void tampilHargaJual(){
        // Menghitung profit sebesar 50% dari total Modal
        double profit = (this.totalModal * 50 / 100);
        
        System.out.println("Profit yang diharapkan = Rp." + profit);
        System.out.println("Rekomendasi Harga Jual " + this.jumPesanan + " pcs " + this.jenisRoti);
        System.out.print("Dengan Margin Profit 50% dari total modal adalah : ");
        System.out.printf("Rp.%.0f per pcs \n", ((this.totalModal + profit) / this.jumPesanan));
        System.out.println("============================================================================");
        System.out.println("============================================================================");

    };

}
