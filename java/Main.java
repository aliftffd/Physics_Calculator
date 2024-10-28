import java.util.Scanner;
import physics.calculator.FisikaCalculator;
import physics.calculator.ParaBolaCalculate;
import physics.calculator.GeraklbbCalculator; 


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih Jenis Hitungan:");
        System.out.println("1. Hitung Energi Kinetik");
        System.out.println("2. Hitung Gerak Parabola");
        System.out.println("3. Hitung Nilai GLBB")

        while (true) {
            System.out.print("Pilih 1 atau 2: ");
            String choice = scanner.next();

            // Memeriksa input agar hanya 1 atau 2 yang diterima
            if (choice.equals("1") || choice.equals("2")) {
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
                            System.out.println("Energi Kinetik: " + kineticEnergy + " Joule");
                            break;

                        case "2":
                            // Perhitungan gerak parabola
                            System.out.print("Input Nilai Kecepatan Awal (m/s): ");
                            double initialVelocity = scanner.nextDouble();

                            System.out.print("Input nilai sudut lemparan (derajat): ");
                            double angle = scanner.nextDouble();

                            ParaBolaCalculate parabolaCalculate = new ParaBolaCalculate();
                            double timeOfFlight = parabolaCalculate.calculateTimeOfflight(initialVelocity, angle);
                            double range = parabolaCalculate.calculateRange(initialVelocity, angle);

                            System.out.println("Waktu Tempuh: " + timeOfFlight + " detik (s)");
                            System.out.println("Jarak Tempuh: " + range + " meter (m)");
                            break;
                        case "3":
                            //di dalam case ini ada switch dalam switch diambil dari physics.calculator.GraklbbCalculator 
                            GeraklbbCalculator glbbCalculator = new GeraklbbCalculator(scanner); 
                            glbbCalculator.calculateGLBB(); 
                            break; 
                        // case "4":


                        default:
                            break;      
                    }
                    System.out.println("Konvirmasi Ya / Tidak : \s"); 
                    String next
                    // Mengakhiri loop setelah pilihan valid diproses
                    
                } catch (Exception e) {
                    System.out.println("Terjadi kesalahan: " + e.getMessage());
                    scanner.nextLine(); // Membersihkan buffer jika terjadi kesalahan input
                }
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi (1 atau 2).");
            }
        }

        scanner.close();
    }
}
