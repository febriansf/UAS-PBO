/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import roti.*;
import java.util.Scanner;

/**
 *
 * @author Aldy
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("");
            System.out.println("1. Roti Manis");
            System.out.println("2. Roti Tawar");
            System.out.println("3. Pizza");
            System.out.println("0. Exit");
            System.out.print("Pilih Jenis Roti : ");
            int pilihanRoti = input.nextInt();

            System.out.println("");
            switch (pilihanRoti) {
                case 1:
                    Manis rm = new Manis();

                    System.out.println("");
                    System.out.println("1. Varian 1");
                    System.out.println("2. Varian 2");
                    System.out.println("3. Varian 3");
                    System.out.print("Pilih Jenis varian : ");
                    rm.pilihVarian(input.nextInt());

                    System.out.print("Masukkan Banyak Pesanan (Pcs) : ");
                    rm.inputPesanan(input.nextInt());

                    rm.tampilTotalBahan();
                    rm.tampilModal();
                    rm.tampilHargaJual();
                    continue;

                case 2:
                    Tawar rt = new Tawar();

                    System.out.println("1. Varian 1");
                    System.out.println("2. Varian 2");
                    System.out.print("Pilih Jenis varian : ");
                    rt.pilihVarian(input.nextInt());

                    System.out.print("Masukkan Banyak Pesanan (Pcs) : ");
                    rt.inputPesanan(input.nextInt());

                    rt.tampilTotalBahan();
                    rt.tampilModal();
                    rt.tampilHargaJual();
                    continue;

                case 3:
                    Pizza pz = new Pizza();

                    System.out.println("1. Varian 1");
                    System.out.print("Pilih Jenis varian : ");
                    pz.pilihVarian(input.nextInt());

                    System.out.print("Masukkan Banyak Pesanan (Pcs) : ");
                    pz.inputPesanan(input.nextInt());

                    pz.tampilTotalBahan();
                    pz.tampilModal();
                    pz.tampilHargaJual();
                    continue;
                    
                case 0:
                    System.out.println("Terimakasih!!");
                    System.exit(0);

                default:
                    System.out.println("Input tidak Valid!");
                    System.exit(0);

            }
        }

    }

}