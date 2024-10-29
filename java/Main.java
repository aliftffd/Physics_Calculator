import java.util.Scanner;
import physics.calculator.FisikaCalculator;
import physics.calculator.ParaBolaCalculate;
import physics.calculator.GeraklbbCalculator; 
import physics.calculator.ConverseBesaran; 

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih Jenis Hitungan:");
        System.out.println("1. Hitung Energi Kinetik");
        System.out.println("2. Hitung Gerak Parabola");
        System.out.println("3. Hitung Nilai GLBB");

        while (true) {
            System.out.print("Pilih 1, 2, atau 3 (atau ketik 'exit' untuk keluar): ");
            String choice = scanner.next();

            // Memeriksa input agar hanya 1, 2, 3, atau 'exit' yang diterima
            if (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equalsIgnoreCase("exit")) {
                if (choice.equalsIgnoreCase("exit")) {
                    System.out.println("Terima kasih! Program selesai.");
                    break;
                }

                try {
                    switch (choice) {
                        case "1":
                            // Perhitungan energi kinetik
                            System.out.print("Input Nilai Massa (Kg): ");
                            double mass = scanner.nextDouble();

                            System.out.print("Input Nilai Kecepatan (m/s): ");
                            double velocity = scanner.nextDouble();

                            FisikaCalculator fisikaCalculator = new FisikaCalculator();
                            double kineticEnergy = fisikaCalculator.calculateKineticEnergy(mass, velocity);
                            System.out.printf("Energi Kinetik: %.3f Joule \n", kineticEnergy);
                            break;

                        case "2":
                            // Perhitungan gerak parabola
                            System.out.print("Input Nilai Kecepatan Awal (m/s): ");
                            double initialVelocity = scanner.nextDouble();

                            System.out.print("Input nilai sudut lemparan (derajat): ");
                            double angle = scanner.nextDouble();

                            ParaBolaCalculate parabolaCalculate = new ParaBolaCalculate();
                            double timeOfFlight = parabolaCalculate.calculateTimeOfflight(initialVelocity, angle);
                            double rangeInMeter = parabolaCalculate.calculateRange(initialVelocity, angle);
                            
                            ConverseBesaran converseBesaran = new ConverseBesaran(); // Deklarasi converseBesaran terlebih dahulu

                            System.out.println("Waktu Tempuh: " + String.format("%.3f", timeOfFlight) + " detik (s)"); // waktu tempuh dalam second atau detik 

                            System.out.println("Pilih Unit Untuk jarak");
                            System.out.println("1. Meter (m)"); 
                            System.out.println("2. Kilometer (km)");
                            System.out.println("3. Centimeter (cm)");
                            System.out.println("4. Mile (mi)");

                            System.out.print("Masukkan pilihan mu (1-4) : "); 

                            int distanceUnitCHoice = scanner.nextInt(); 
                            
                            double range = rangeInMeter; 

                            String distanceUnit = "Meter (m)"; 

                            switch(distanceUnitCHoice){
                                case 2:
                                    range = converseBesaran.meterToKm(rangeInMeter);
                                    distanceUnit = "Kilometer (km)"; 
                                    break; 
                                case 3:
                                    range = converseBesaran.meterToCm(rangeInMeter); 
                                    distanceUnit = "Centimeter (cm)"; 
                                    break; 
                                case 4:
                                    range = converseBesaran.meterToMiles(rangeInMeter); 
                                    distanceUnit = "mile (mi)"; 
                                    break; 
                                default:
                                    break; // tidak ada yang di konversi
                            }
                            System.out.printf("Jarak Tempuh: %.3f %s%n", range, distanceUnit);
                            break;

                        case "3":
                            // Menggunakan GeraklbbCalculator untuk perhitungan GLBB
                            GeraklbbCalculator glbbCalculator = new GeraklbbCalculator(scanner); 
                            glbbCalculator.calculateGLBB(); 
                            break;
                        
                        default:
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Terjadi kesalahan: " + e.getMessage());
                    scanner.nextLine(); // Membersihkan buffer jika terjadi kesalahan input
                }
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi (1, 2, 3, atau 'exit').");
            }
        }

        scanner.close();
    }
}
