package controller.dispatcher;

import injector.ApplicationContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static injector.ApplicationContext.URL_TO_HANDLER;


@WebServlet("/dispatcher/*")
public class DispatcherServlet extends HttpServlet {

    @Override
    public void init() {
        Class<ApplicationContext> clazz = ApplicationContext.class;
        try {
            Constructor<ApplicationContext> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            ApplicationContext applicationContext = constructor.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        String httpMethod = req.getMethod();
        String uri = req.getRequestURI();

        String url = uri.replace(req.getContextPath(), "").replace(req.getServletPath(), "");
        HandlerMethod handler = URL_TO_HANDLER.get(url);

        Method method = handler.getMethod();
        Object controller = handler.getControllerInstance();
        MethodType methodType = handler.getMethodType();

        if (httpMethod.equalsIgnoreCase(methodType.name())) {
            try {
                method.invoke(controller, req, resp);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
