/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package varian;

/**
 *
 * @author Annisa
 */
public class BahanVarian {
    
    public int getBeratKemasan(String nama){
        switch (nama){
            case "Keju":
                return 250;
            case "Coklat":
                return 500;
            case "Krim Vanilla":
                return 500;
            case "Selai Red Bean":
                return 500;
            case "Sosis":
                return 1000;
            case "Smoked Beef":
                return 1000;
            case "Bawang Bombay":
                return 500;
            default:
                return 0;
        }
    }
    
    public int getHargaKemasan(String nama){
        switch (nama){
            case "Keju":
                return 31000;
            case "Coklat":
                return 29000;
            case "Krim Vanilla":
                return 30000;
            case "Selai Red Bean":
                return 25000;
            case "Sosis":
                return 80000;
            case "Smoked Beef":
                return 90000;
            case "Bawang Bombay":
                return 40000;
            default:
                return 1;
        }
    }
}
