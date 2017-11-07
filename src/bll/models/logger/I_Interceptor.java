package bll.models.logger;


public interface I_Interceptor {
    void operation(I_Action action);
    void checkOperation(I_Action action);
    int getPriority();
}