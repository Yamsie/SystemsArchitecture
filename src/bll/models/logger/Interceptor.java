package bll.models.logger;

/**
 * @author Lenovo
 * @version $Id Interceptor.java, v 0.1 2017-10-10 21:14 Lenovo Exp $$
 */
public interface Interceptor {
    void before(Action action);
    String intercept(ActionInvocation invocation, Action action);
    void after(Action action);
}
