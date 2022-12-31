/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bahan;

/**
 *
 * @author Zefanya A.N
 */
public class Bahan {

//    public int getHarga(String nama){
//        return switch (nama) {
//            case "tepungTerigu" -> 40000;
//            case "gulaPasir" -> 25000;
//            case "butter" -> 23000;
//            case "ragi" -> 5000;
//            case "susuBubuk" -> 39000;
//            case "susuCair" -> 24000;
//            case "telur" -> 23000;
//            case "esBatu" -> 2000;
//            default -> 0;
//        };
//    };
    
    // Method getter untuk mengambil nilai harga Bahan.. kenapa pakai angka ? supaya bisa saya looping :v
    public int getHarga(int nama){
        switch (nama) {
            case 0:
                return 40000; //Tepung Terigu
            case 1:
                return 25000; //Gula Pasir
            case 2:
                return 23000; //Butter
            case 3:
                return 5000;  //Ragi
            case 4:
                return 39000; //Susu Bubuk
            case 5:
                return 24000; //Susu Cair
            case 6:
                return 23000; //Telur
            case 7:
                return 2000;  //Es Batu
            default:
                return 0;
        }
    }
    
    // Method untuk mengambil nilai berat kemasan bahan.. kenapa pakai nama ? biar agak laen saja :v
    public int getBerat(String nama){
        switch (nama) {
            case "tepungTerigu":
                return 1000;
            case "gulaPasir":
                return 1000;
            case "butter":
                return 500;
            case "ragi":
                return 11;
            case "susuBubuk":
                return 1000;
            case "susuCair":
                return 1000;
            case "telur":
                return 1000;
            case "esBatu":
                return 1000;
            default:
                return 0;
        }
    }
}
