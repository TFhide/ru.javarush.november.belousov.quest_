package controller.dispatcher;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RegisterForControllers {

    public Map<String, HandlerMethod> register(Object... controllerInstances) {
        Map<String, HandlerMethod> urlToHandler = new HashMap<>();
        for (Object controllerInstance : controllerInstances) {
            Class<?> clazz = controllerInstance.getClass();
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                method.setAccessible(true);
                if (method.isAnnotationPresent(RequestMapping.class)) {
                    RequestMapping annotation = method.getAnnotation(RequestMapping.class);
                    String url = annotation.url();
                    MethodType httpMethod = annotation.method();
                    urlToHandler.put(url, new HandlerMethod(controllerInstance, httpMethod, method));
                }
            }
        }
        return urlToHandler;
    }
}
