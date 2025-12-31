package headfirst.designpatterns.templatemethod;

import java.util.Locale;
import java.util.Scanner;

public class CoffeeWithHook extends Coffee {

    @Override
    protected boolean customerWantsCondiments() {
        String answer = getUserInput();
        return answer.toLowerCase(Locale.ROOT).startsWith("y") || answer.toLowerCase(Locale.ROOT).startsWith("o");
    }

    private String getUserInput() {
        System.out.print("Would you like milk and sugar with your coffee (y/n)? ");
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        if (answer == null) return "n";
        return answer.trim();
    }
}
