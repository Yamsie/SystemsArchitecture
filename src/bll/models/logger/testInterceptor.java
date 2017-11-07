//package bll.models.logger;
//
//public class testInterceptor {
//    I_Interceptor exptionInterceptor = new ExceptionInterceptor();
//    I_Interceptor i18nInterceptor = new I18NInterceptor();
//    I_Interceptor aroundInterceptor = new AroundInterceptor();
//
//    DefaultActionInvocation actionInvocation = new DefaultActionInvocation();
//        actionInvocation.addInterceptor(exptionInterceptor);
//        actionInvocation.addInterceptor(i18nInterceptor);
//        actionInvocation.addInterceptor(aroundInterceptor);
//
//
//    I_Action action = new HelloWorldAction();
//        actionInvocation.setAction(action);
//
//    String result = actionInvocation.invoke();
//        System.out.println("I_Action result:" + result);
//}