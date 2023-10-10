package pedro.ies.lab2_4;


import java.util.concurrent.atomic.AtomicLong;

import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {
    private ArrayList<Quote> quotes = new ArrayList<>();
    private ArrayList<Show> Shows = new ArrayList<>();
    
    /*@GetMapping("api/quote")
	public Quote randomQuote() {
        quotes = loadQuotes(Shows);
        return quotes.get(randInt(quotes.size()));
    }*/


	@GetMapping("api/quote")
	public Quote randomQuoteByShowId(@RequestParam(value = "show", defaultValue = "0") long show) {
        quotes.clear();
        quotes = loadQuotes(Shows);
        if(show != 0){
            ArrayList<Quote> FiltQuotes = new ArrayList<>();
            for(Quote q : quotes){
                Show sh = q.shows();
                if (sh.id() == show){
                    FiltQuotes.add(q);
                }    
            }

            if(FiltQuotes.size() != 0){
                return FiltQuotes.get(randInt(FiltQuotes.size()));
            }else{
                return FiltQuotes.get(0);
            }
            
        }else{
            return quotes.get(randInt(quotes.size()));
        }
		
	}

    @GetMapping("api/shows")
	public ArrayList<Show> shows() {
        quotes = loadQuotes(Shows);
		return Shows;
	}


    private ArrayList<Quote> loadQuotes(ArrayList<Show> shows) {

        ArrayList<Quote> quotes = new ArrayList<>();
        shows.clear();

         AtomicLong counterquote = new AtomicLong();
          AtomicLong countershow = new AtomicLong();

        Scanner filesc = null;
        try {
            filesc = new Scanner(new File("src\\main\\resources\\shows.txt"));

            while (filesc.hasNextLine()) {
                String[] data = filesc.nextLine().split("-");
                Show show = null;
                for(Show s : shows) {              
                    if(s.name().equals(data[1])) {
                        show = s;
                        break;
                    }
                }

                if(show == null) {
                    show = new Show(countershow.incrementAndGet(), data[1]);
                    shows.add(show);
                }

                Quote quote = new Quote(counterquote.incrementAndGet(),data[0], show);
                quotes.add(quote);
            }

            filesc.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: Quote file not found.");
            System.exit(1);
        }

        return quotes;
        
    }

    private int randInt(int max) {
        return ThreadLocalRandom.current().nextInt(0, max);
    }

}
