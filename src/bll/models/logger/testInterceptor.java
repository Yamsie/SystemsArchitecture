//package bll.models.logger;
//
//public class testInterceptor {
//    Interceptor exptionInterceptor = new ExceptionInterceptor();
//    Interceptor i18nInterceptor = new I18NInterceptor();
//    Interceptor aroundInterceptor = new AroundInterceptor();
//
//    DefaultActionInvocation actionInvocation = new DefaultActionInvocation();
//        actionInvocation.addInterceptor(exptionInterceptor);
//        actionInvocation.addInterceptor(i18nInterceptor);
//        actionInvocation.addInterceptor(aroundInterceptor);
//
//
//    Action action = new HelloWorldAction();
//        actionInvocation.setAction(action);
//
//    String result = actionInvocation.invoke();
//        System.out.println("Action result:" + result);
//}