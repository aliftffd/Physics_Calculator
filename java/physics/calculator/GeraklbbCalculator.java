package physics.calculator;  

import java.util.Scanner; 
import physics.calculator.ConverseBesaran;  
import java.text.DecimalFormat; 

public class GeraklbbCalculator  { 
    private final Scanner scanner; 
    private final ConverseBesaran converseBesaran; 
    DecimalFormat df = new DecimalFormat("#.###"); //format angka yang di inginkan 

    public GeraklbbCalculator(Scanner scanner) { 
        this.scanner = scanner; 
        this.converseBesaran = new ConverseBesaran(); 
    }
    // public void calculateGLBB(){ 
    //     System.out.println()
    // }

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
        double v0 = applyKonversiBesaran(scanner.nextDouble()); 

        System.out.println("Input Waktu yang di tempuh (t) : "); 
        double t = applyKonversiBesaran(scanner.nextDouble()); 

        System.out.println("Input Nilai Percepatan (a) dalam m/s^2 : "); 
        double a = scanner.nextDouble();

        double finalPositionInmeters = v0 * t +  0.5 * a * Math.pow(t,2); 
       
        // Memilih konversi besaran jarak 

        System.out.println("Pilih Unit untuk posisi akhir"); 
        System.out.println("1. Meter (m)"); 
        System.out.println("2. Kilometer (km)");
        System.out.println("3. Centimeter (cm)");
        System.out.println("4. Mile (mi)");

        System.out.print("Masukkan Pilhan mu (1-4): \s"); 

        int unitChoice = scanner.nextInt(); 

        double finalPosition = finalPositionInmeters;
        String unit = "Meter (m)"; 

        switch(unitChoice){
            case 2:
                finalPosition = converseBesaran.meterToKm(finalPositionInmeters); 
                unit = "Kilometer (Km)"; 
                break; 
            case 3:
                finalPosition = converseBesaran.meterToCm(finalPositionInmeters);
                unit = "Centimeter (cm)"; 
                break; 
            case 4:
                finalPosition = converseBesaran.meterToMiles(finalPositionInmeters); 
                unit = "mile (mi)"; 
                break;  
        }
        System.out.println("Posisi terakhir adalah "+ "\s" + df.format(finalPosition) + "\s" + unit);          
    }

    private void calculateFinalVelocity(){ // Menghitung nilai Kecepatan Akhir
        System.out.println("Input Nilai Kecepatan Awal V0 dalam m/s : "); 
        double v0 = applyKonversiBesaran(scanner.nextDouble());

        System.out.println("Input Nilai percepatan (a) dalam m/s^2: "); 
        double a = scanner.nextDouble(); 

        System.out.println("Input Nilai waktu yang di tempuh : "); 
        double t = applyKonversiBesaran(scanner.nextDouble());

        double finalVelocity = v0 + a * t; 

        if (a<0){ // jika ingin mengetahui nilai perlambatan atau percepatan 
            System.out.println("Ini adalah perlambatan");
        }else{ 
            System.out.println("Ini adalah percepatan");
        }
        System.out.println("Kecepatan akhir adalah " +df.format(finalVelocity) + "\s meter per second (m/s)"); 
    }

    private void calculateTime(){ // Menghitung nilai jarak yang di tempuh 
        System.out.println("Input Nilai Kecepatan Awal V0 dalam m/s : "); 
        double v0 = applyKonversiBesaran(scanner.nextDouble());

        System.out.println("Input Nilai Kecepatan Akhir V dalam m/s : "); 
        double v = applyKonversiBesaran(scanner.nextDouble());

        System.out.println("Input Nilai Percepatan (a) dalam m/s^2 : "); 
        double a = scanner.nextDouble(); 

        if (a != 0){ 
            double time = (v-v0) / a; 
            System.out.println("waktu yang ditempu : " + df.format(time) + "\s second");
        }else{ 
            System.out.println("Percepatan tidak boleh sama dengan nol (0)"); 
        }
    }

    private double applyKonversiBesaran(double value){ // konversi besaran yang sudah di hitung 
        System.out.println("Apakah Anda ingin mengonversi satuan?");
        System.out.println("1. Tidak");
        System.out.println("2. Konversi km/jam ke m/s");
        System.out.println("3. Konversi m/s ke km/jam");
        System.out.println("4. Konversi menit ke detik");
        System.out.println("5. Konversi detik ke menit");

        System.out.print("Masukkan pilihan dari 1 - 5 : "); 
        int konversiPilihan = scanner.nextInt(); 

        return switch(konversiPilihan){ 
            case 2 -> converseBesaran.KmphToMeterps(value); 
            case 3 -> converseBesaran.MeterpsToKmph(value); 
            case 4 -> converseBesaran.MinutesToSecond(value); 
            case 5 -> converseBesaran.SecondToMinutes(value); 
            default -> value; // tidak ada yang perlu di konversi 
        };
    }
}