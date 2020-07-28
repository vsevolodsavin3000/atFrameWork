package helper.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD) 
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ElementName {
    String name();
}
/*
@Target — указывает виды элементов программы, к которым применим тип аннотации. 
Возможные значения: TYPE, METHOD, CONSTRUCTOR, FIELD и т.д. 

@Retention — указывает, как долго сохранять аннотации с аннотированными типами. 
Этим занимается аргумент RetentionPolicy, для которого можно использовать 
значения SOURCE, CLASS или RUNTIME.

Методы в пользовательской аннотации могут возвращать лишь примитивы, 
String, Перечисления (Enums), аннотации.
*/