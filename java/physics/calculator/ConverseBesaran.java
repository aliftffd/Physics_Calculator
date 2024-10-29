package physics.calculator; 

public class ConverseBesaran{ 

    //Konversi km/jam ke m/s 
    public double KmphToMeterps(double speedInKmph){ 
        return speedInKmph * 1000 / 3600; 
    }

    //Konversi m/s ke Km/jam 
    public double MeterpsToKmph(double speedInMps){ 
        return speedInMps * 3.6; 
    }

    //Konversi menit ke detik 
    public double MinutesToSecond(double timeInMinutes){ 
        return timeInMinutes * 60; 
    }

    //Konversi detik ke menit 
    public double SecondToMinutes(double timeInSecond){ 
        return timeInSecond / 60; 
    }

    //Metode konversi jarak 
    public double meterToKm(double meters){
        return meters / 1000;
    }

    public double meterToCm(double meters){
        return meters * 1000 ;
    }

    public double meterToMiles(double meters){
        return meters/1609.34; 
    }

    
}
