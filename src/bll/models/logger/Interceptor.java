package bll.models.logger;


public interface Interceptor {
    void operation(Action action);
    void checkOperation(Action action);
    int getPriority();
}