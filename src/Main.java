import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("app", "apple", "application", "ape", "banana", "band", "bandana", "bandit", "bar");
        AutocompleteSystem sys = new AutocompleteSystem(words);

        // test keywords
        System.out.println("Suggestions for 'ap': " + sys.getSuggestions("ap"));
        System.out.println("Suggestions for 'ban': " + sys.getSuggestions("ban"));
    }
}
