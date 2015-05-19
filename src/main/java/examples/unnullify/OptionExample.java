package examples.unnullify;

import com.itquasar.unhellify.unnullify.Option;
import static com.itquasar.unhellify.unnullify.Option.None;
import static com.itquasar.unhellify.unnullify.Option.Some;

public class OptionExample {

    public static void main(String[] args) {
        System.out.println("UnNullify::Option Example");
        Option<String> opt;

        System.out.println("unsing Some");
        opt = returnAnything();
        System.out.println("\t" + opt);
        showValue(opt);

        System.out.println("unsing None");
        opt = returnNull();
        System.out.println("\t" + opt);
        showValue(opt);
    }

    private static void showValue(Option opt) {
        if (opt.hasValue()) {
            System.out.println("\tvalue: " + opt.getValue());
        } else {
            System.out.println("\tvalue: No value returned. It replaces null");
        }
    }

    private static Option<String> returnNull() {
        return None;
    }

    private static Option<String> returnAnything() {
        return Some("Anything");
    }
}
