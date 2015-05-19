package examples.unnullify;

import com.itquasar.unhellify.unnullify.Result;
import static com.itquasar.unhellify.unnullify.Result.Err;
import static com.itquasar.unhellify.unnullify.Result.Ok;

public class ResultExample {

    public static void main(String[] args) {
        System.out.println("UnNullify::Result Example");
        Result<String, Integer> res;

        System.out.println("unsing Ok");
        res = returnAnything();
        System.out.println("\t" + res);
        showValue(res);

        System.out.println("unsing Err");
        res = returnError();
        System.out.println("\t" + res);
        showValue(res);
    }

    private static void showValue(Result opt) {
        if (opt.hasValue()) {
            System.out.println("\tvalue: " + opt.getValue());
        } else {
            System.out.println("\terror: " + opt.getError());
        }
    }

    private static Result<String, Integer> returnError() {
        return Err(-1);
    }

    private static Result<String, Integer> returnAnything() {
        return Ok("Thats all folks!");
    }
}
