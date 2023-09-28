package pedro.ies.lab1_5;

import java.awt.Toolkit;
import java.util.Timer; 
import java.util.TimerTask;

public class AnyCityForecast {

    Toolkit toolkit;

    Timer timer;

    private static IpmaApiClt client = new IpmaApiClt();

    public AnyCityForecast() {
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.scheduleAtFixedRate(new RemindTask(), 0, //initial delay
            10 * 1000); //subsequent rate
    }

    class RemindTask extends TimerTask {
        int numWarningBeeps = 3;

        public void run() {
            long time = System.currentTimeMillis();
            if (time - scheduledExecutionTime() > 5) {
                return;
            }
            client.displayCityForecast();
        
        }
    }

    public static void  main(String[] args ) {
        new AnyCityForecast();

        /*if(args.length != 1){
            System.out.print("[ERROR] didn't introduce an argument for the city ID");
            System.exit(1);
        }

         
        int city = 0;
        try {
            city = Integer.parseInt(args[0]);  
        } catch(NumberFormatException e) {
            System.err.println("Argument error! Expected and integer value.");
            System.exit(1);
        }
                
       */

    }
}