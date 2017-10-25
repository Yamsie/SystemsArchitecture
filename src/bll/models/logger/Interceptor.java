package bll.models.logger;

/**
 * @author Lenovo
 * @version $Id Interceptor.java, v 0.1 2017-10-10 21:14 Lenovo Exp $$
 */
public interface Interceptor {
    void operation(Action action);
    void checkOperation(Action action);
    int getPriority();
}
