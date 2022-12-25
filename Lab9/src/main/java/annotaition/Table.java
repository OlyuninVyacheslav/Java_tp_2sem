package annotaition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//используется
@Target(ElementType.TYPE)//подключается
public @interface Table {
    String name();
}
