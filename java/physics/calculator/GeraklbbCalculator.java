package physics.calculator; 

import java.util.Scanner; 

public class GeraklbbCalculator(){ 
    private final Scanner scanner; 

    public class GeraklbbCalculator(Scanner scanner){ 
        this.scanner = scanner; 
    }
    public void calculateGLBB(){ 
        System.out.println()
    }

    public void calculateGLBB(){ //Memilih tipe operasi yang di inginkan 
        System.out.println("Pilih Jenis Perhitungan GLBB"); 
        System.out.println("1. Hitung Posisi Akhir"); 
        System.out.println("2. Hitung Kecepatan Akhir"); 
        System.out.println("3.Hitung Waktu Tempuh");

        System.out.print("Masukkan pilihan dari 1 sampai 3 : "); 
        int choice = scanner.nextInt(); 

        switch(choice){ 
            case 1 -> calculateFinalPosition(); 
            case 2 -> calculateFinalVelocity(); 
            case 3 -> calculateTime(); 
            default -> System.out.println("Pilihan Tidak Valid"); 
        }
    }

    private void calculateFinalPosition(){ // Menghitung nilai jarak yang di tempuh 
        System.out.println("Input Nilai Kecepatan Awal V0 dalam m/s : "); 
        double v0 = scanner.nextDouble(); 

        System.out.println("Input Waktu yang di tempuh (s) : "); 
        double t = scanner.nextDouble(); 

        System.out.println("Input Nilai Percepatan (a) dalam m/s^2 : "); 
        double a = scanner.nextDouble(); 

        double finalPosition = v0 * t +  0.5 * a * math.pow(t,2); 
        System.out.println("Posisi akhir adalah " + finalPosition + "meter (m)"); 
    }

    private void calculateFinalVelocity(){ // Menghitung nilai Kecepatan Akhir
        System.out.println("Input Nilai Kecepatan Awal V0 dalam m/s : "); 
        double v0 = scanner.nextDouble(); 

        System.out.println("Input Nilai percepatan (a) dalam m/s^2: "); 
        double a = scanner.nextDouble(); 

        System.out.println("Input Nilai waktu yang di tempuh : "); 
        double t = scanner.nextDouble(); 

        double finalVelocity = v0 + a * t; 
        System.out.println("Kecepatan akhir adalah " + finalVelocity + "meter per second (m/s)"); 
    }

    private void calculateTime(){ // Menghitung nilai jarak yang di tempuh 
        System.out.println("Input Nilai Kecepatan Awal V0 dalam m/s : "); 
        double v0 = scanner.nextDouble(); 

        System.out.println("Input Nilai Kecepatan Akhir V dalam m/s : "); 
        double v = scanner.nextDouble(); 

        System.out.println("Input Nilai Percepatan (a) dalam m/s^2 : "); 
        double a = scanner.nextDouble(); 

        double finalPosition = v0 * t +  0.5 * a * math.pow(t,2); 
        System.out.println("Kecepatan akhir adalah " + finalPosition + "meter (m)"); 
    }

}