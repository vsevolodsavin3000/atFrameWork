package helper;

import com.codeborne.selenide.SelenideElement;
import helper.interfaces.ActionName;
import helper.interfaces.ElementName;
import helper.interfaces.PageName;
import org.openqa.selenium.WebElement;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.MethodAnnotationsScanner;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Selenide.page;
import static org.apache.commons.lang3.StringUtils.substringAfter;

public class Refl {
    private static String lastInitialized;
    private static Class lastInitializedClass;
    private static Object lastInitializedClassInstance;
    private static Set<Field> annotated = null;

    public static Object getLastInitializedClassInstance() {
        return lastInitializedClassInstance;
    }

    public static void initPage(String pageName) throws Exception {
        Set<Class<?>> annotated = new Reflections("pages").getTypesAnnotatedWith(PageName.class);
        for (Class classForInitialization : annotated) {
            PageName annotation = (PageName) classForInitialization.getAnnotation(PageName.class);
            if (annotation.name().equals(pageName)) {
                lastInitializedClassInstance = classForInitialization.newInstance();
                lastInitialized = substringAfter(classForInitialization.toString(), "class ");
                lastInitializedClass = classForInitialization;
                Refl.annotated = new Reflections(lastInitialized, new FieldAnnotationsScanner()).getFieldsAnnotatedWith(ElementName.class);
                return;
            }
        }
        throw new Exception("Page for initialization is not found: " + pageName);
    }

    public static SelenideElement findElementByName(String elementName) throws Exception {
        for (Field field : annotated) {
            ElementName annotation = field.getAnnotation(ElementName.class);
            if (annotation.name().equals(elementName)) {
                field.setAccessible(true);
                SelenideElement el = (SelenideElement) field.get(page(lastInitializedClass));
                return el;
            }
        }
        throw new Exception("Element is not found: " + elementName);
    }

    public static List<SelenideElement> findElementsByName(String elementsName) throws Exception {
            List<SelenideElement> list = new ArrayList<>();
            for (Field field : annotated) {
                ElementName annotation = field.getAnnotation(ElementName.class);
                if (annotation.name().equals(elementsName)) {
                    field.setAccessible(true);
                    list.addAll((List<SelenideElement>) field.get(page(lastInitializedClass)));
                    return list;
                }
            }
            throw new Exception("Elements is not found: " + elementsName);
    }

    public static Method runAnnotatedMethodFromTheCurrentPage(String methodName) throws Exception {
        Set<Method> annotated = new Reflections(lastInitialized, new MethodAnnotationsScanner()).getMethodsAnnotatedWith(ActionName.class);
        for (Method method : annotated) {
            ActionName annotation = method.getAnnotation(ActionName.class);
            if (annotation.name().equals(methodName)) {
                method.setAccessible(true);
                return method;
            }
        }
        throw new Exception("Method is not found: " + methodName);
    }

}
