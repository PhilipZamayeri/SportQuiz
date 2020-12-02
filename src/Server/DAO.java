package Server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Philip Zamayeri
 * Date: 2020-11-25
 * Time: 14:27
 * Project: SportQuiz
 * Copyright: MIT
 */

public class DAO {

    public final List<Question> mathematics = new ArrayList<>();
    public final List<Question> geopgraphy = new ArrayList<>();
    public final List<Question> pleasure = new ArrayList<>();
    public final List<Question> sport = new ArrayList<>();

    Question m1 = new Question("2+2=?", "4", List.of("6","3","4","8"));
    Question m2 = new Question("10 + 10 * 10 / 10 = ?", "20", List.of("100","20","2","1"));
    Question m3 = new Question("Maria köpte 10 böcker och 5 pennor för 2kr var, hur mycket kostade allting?", "30", List.of("30","25","17","35"));
    Question m4 = new Question("1... 3... 5... ?", "7", List.of("7","9","12","6"));

    Question g1 = new Question("Hur många kontinenter finns det?", "7", List.of("7","5","12","4"));
    Question g2 = new Question("Vad heter Sveriges huvudstad?", "Stockholm", List.of("Köpenhamn", "Göteborg", "Stockholm", "Malmö"));
    Question g3 = new Question("Hur många stjärnor finns i EU-flagga?", "12", List.of("13","20","15","12"));
    Question g4 = new Question("I vilket land ligger Machu Picchu?", "Peru", List.of("Peru", "USA", "Brazil", "Madagascar"
    ));

    Question p1 = new Question("Hur många filmer har Sagan om ringen?", "3", List.of("2", "5", "3", "4"));
    Question p2 = new Question("Hur många säsonger har The Simpsons?", "32", List.of("32", "33", "12", "47"));
    Question p3 = new Question("Vem vann \"Best Actor 2020\"?", "Joaquin Phoenix", List.of("Joaquin Phoenix", "Leonardo DiCaprio", "Nicole Kidman", "Audrey Tautou"));
    Question p4 = new Question("Vilken artist ville bli USAs president?", "Kanye West", List.of("Lil Wayne", "Kanye West", "Will Smith", "Madonna"));

    Question s1 = new Question("Vilket år spelade Sverige mot Brazil i VM?","1958", List.of("1958", "1598", "2000", "1956"));
    Question s2 = new Question("I vilket lag började Zlatan spela?", "Malmö", List.of("Brommapojkarna", "Malmö", "AIK", "Falkonberg"));
    Question s3 = new Question("Vilken svensk man spelade för Arsenal för första gången?", "Fredrik Ljungberg", List.of("Fredrik Ljungberg", "Kalle", "Zlatan", "Karl Gustaf"));
    Question s4 = new Question("Vad är ett annat namn för \"pingis\"?", "Bord Tennis", List.of("Bord Tennis", "Biljard", "Tennis", "Handboll"));

    public DAO() {

        mathematics.add(m1);
        mathematics.add(m2);
        mathematics.add(m3);
        mathematics.add(m4);

        geopgraphy.add(g1);
        geopgraphy.add(g2);
        geopgraphy.add(g3);
        geopgraphy.add(g4);

        pleasure.add(p1);
        pleasure.add(p2);
        pleasure.add(p3);
        pleasure.add(p4);

        sport.add(s1);
        sport.add(s2);
        sport.add(s3);
        sport.add(s4);

        Collections.shuffle(mathematics);
        Collections.shuffle(geopgraphy);
        Collections.shuffle(pleasure);
        Collections.shuffle(sport);

    }

    public static void main(String[] args) {
        DAO dao = new DAO();
    }
}
