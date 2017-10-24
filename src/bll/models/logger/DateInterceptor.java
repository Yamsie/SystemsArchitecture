package bll.models.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateInterceptor implements Interceptor{
    boolean statement = false;
    int priority = 3;

    @Override
    public void operation(Action action) {
        System.out.println("before : Create Date");
        action.setDate(CurrentTime());
        statement = true;
    }

    @Override
    public void checkOperation(Action action) {
        // TODO Auto-generated method stub
        if(action.getDate() != null){
            System.out.println("Create current date succeed!");
        }
        else{
            System.out.println("Create current date failed!");
        }
    }

    @Override
    public int getPriority(){
        return this.priority;
    }

    public String CurrentTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss,");
        return df.format(new Date());
    }
}