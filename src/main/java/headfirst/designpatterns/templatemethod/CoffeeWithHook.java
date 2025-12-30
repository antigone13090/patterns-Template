package headfirst.designpatterns.templatemethod;

import java.util.Locale;
import java.util.Scanner;

public class CoffeeWithHook extends Coffee {

    @Override
    protected boolean customerWantsCondiments() {
        String answer = getUserInput();
        String a = answer.toLowerCase(Locale.ROOT);
        return a.startsWith("y") || a.startsWith("o"); // yes/oui
    }

    private String getUserInput() {
        try {
            // exécution non-interactive (ex: Gradle/IDE) -> pas d'entrée -> "n"
            if (System.in.available() == 0) return "n";

            Scanner in = new Scanner(System.in);
            if (!in.hasNextLine()) return "n";
            String answer = in.nextLine();
            if (answer == null) return "n";
            return answer.trim();
        } catch (Exception e) {
            return "n";
        }
    }
}
