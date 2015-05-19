UnHellify
=========

Free yourself from some of the most common hells in Java.


Design
------

All custom `Exception` and `Error` resides on package `exceptions`. Any class that extends `Error` are used to get _unchecked exceptions_ (the ones that don't need try/catch blocks), as they are throwned when contract is not followed. Any class that extends `Exception` must be caught or throwned again, as they represent errors that **MUST** be handled outside the library by contratct.

Each other package has one `hell` in mind.

Features and Usage
------------------

For usage, you can take a look at test files. Some examples are described bellow.


### UnNullify

This API is usefull to get rid of _null pointers_ on your code.

- Option:
	+ this is a implementation where there are 3 classes:
		* `Option`: abstract class with static helper and static constant
		* `None`: final class
		* `Some`: final class
	+ `Option` is the contratct, with has 2 methods:
		* `hasValue`: returns a boolean `true` when it has a value not `null`
		* `getValue`: return the non `null` value
	+ `None` is the `null` replacement
		* `hasValue` returns `false`, `getValue` throws `NoValueError` and it has no associated value
		* this is a constant on `Option` class and **MUST** not be instantiated
		* it has a protected constructor to avoid instantiation other than the constant in `Option`
		* using the constant in `Option` allows `==` conparator, as only one instance will be used along all code
	+ `Some` is the wrapper for any value other than `null`
		* its constructor does not allow `null`, throwing `NullValueError` in such case
		* `hasValue` returns true
		* `getValue` return the value
		* can be instantiated directly
		* there is a helper function in `Option` class to generate `Some` objects
		* two `Some` are equals if `equals` of their values return `true`

Note that `Option` make use of generics, allowing any class on `Some` instances

Note 2: you **MUST** chacke if it `hasValue` before `getValue`. This is the contract.

#### Usage

```java
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
```
