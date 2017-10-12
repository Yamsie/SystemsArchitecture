package bll.models.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateInterceptor implements Interceptor{
    boolean statement = false;

    @Override
    public void before(Action action) {
        System.out.println("before : Create Date");
        action.setDate(CurrentTime());
        statement = true;
    }

    @Override
    public String intercept(ActionInvocation invocation, Action action) {
        before(action);
        String result = invocation.invoke();
        after(action);
        return result;
    }

    @Override
    public void after(Action action) {
        // TODO Auto-generated method stub
        if(action.getDate() != null){
            System.out.println("Create current date succeed!");
        }
        else{
            System.out.println("Create current date failed!");
        }
    }

    public String CurrentTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss,");
        return df.format(new Date());
    }
}