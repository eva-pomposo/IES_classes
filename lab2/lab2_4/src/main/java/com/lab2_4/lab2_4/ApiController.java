package com.lab2_4.lab2_4;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.io.IOException;
import javax.servlet.ServletException;
import java.util.List;
import java.util.ArrayList;

@RestController
public class ApiController {
	private final AtomicLong counter = new AtomicLong();
	Random r = new Random();
	
	@GetMapping("/api/quote")
	public Quote quote(@RequestParam(value = "show", defaultValue = "0") String show) throws ServletException, IOException {
		
		Filme filme1 = new Filme(1 ,"The Wire", "the-wire", false, "Omar Little");
		Filme filme2 = new Filme(2, "The Office", "the-office", false, "Michael Scott");
		Filme filme3 = new Filme(3, "Lucifer", "lucifer", true, "Ella Lopez");
		Filme filme4 = new Filme(4, "The Silence Of The Lambs", "the-silence-of-the-lambs", false, "Hannibal Lecter");
		Filme filme5 = new Filme(5, "Space Force", "space-force", false, "F. Tony");
	
		filme3.addQuote("We can’t control what happens to us only how it affects us and the choices we make.");
		filme3.addQuote("No one expects you to change overnight. It’s hard to be one of the good guys. Look, I screw up, too. I’ve made plenty of mistakes believe me. But I don’t quit… and I know that counts for something. At least you’re trying, right?");
		
		filme5.addQuote("Scientists Are Weird. It's Why You're The Only Muppet That Speaks Nonsense. Even Animal Uses Words.");
		
		filme1.addQuote("There aint nothing you fear more than a bad headline, now, is there? You would rather live in shit than let the world see you work a shovel.");
		filme1.addQuote("Just like you man, I Got The Shotgun. You Got The Briefcase. It’s All In The Game, Though, Right?");
		
		filme4.addQuote("A census taker once tried to test me. I ate his liver with some fava beans and a nice Chianti.");
	
		filme2.addQuote("Would I rather be feared or loved? Easy. Both. I want people to be afraid of how much they love me.");
		filme2.addQuote("have you lost your mind cause i'll help you find it");
		
		Map<Integer, Filme> filmes = new HashMap<>();
		filmes.put(filme1.getId(), filme1);
		filmes.put(filme2.getId(), filme2);
		filmes.put(filme3.getId(), filme3);
		filmes.put(filme4.getId(), filme4);
		filmes.put(filme5.getId(), filme5);
		
		int id_show = Integer.parseInt(show);
		if (id_show == 0) {
			id_show = r.nextInt(5-1+1) + 1;

		}

		if (id_show <=0 || id_show >= 6) {
			throw new NullPointerException("O id do show deve estar entre 1 e 5!");

		}
		Filme movie = filmes.get(id_show);

		return new Quote(counter.incrementAndGet(),movie.getRandomQuote(), movie.getRole(), movie.getName(), movie.isContain_adult_lang());
	}

	@GetMapping("/api/shows")
	public List show() {

		Show show1 = new Show(1 ,"The Wire", "the-wire");
		Show show2 = new Show(2, "The Office", "the-offfice");
		Show show3 = new Show(3, "Lucifer", "lucifer");
		Show show4 = new Show(4, "The Silence Of The Lambs", "the-silence-of-the-lambs");
		Show show5 = new Show(5, "Space Force", "space-force");

		List<Show> filmes = new ArrayList<>();
		filmes.add(show1);
		filmes.add(show2);
		filmes.add(show3);
		filmes.add(show4);
		filmes.add(show5);
		
		return filmes;
	}
	

}
