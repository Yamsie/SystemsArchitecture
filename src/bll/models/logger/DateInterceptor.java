package bll.models.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateInterceptor implements I_Interceptor {
    boolean statement = false;
    int priority = 3;

    @Override
    public void operation(I_Action action) {
        if(action.getDate().equals("null")){
            action.setDate(CurrentTime());
        }
        statement = true;
    }

    @Override
    public void checkOperation(I_Action action) {
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
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
        return df.format(new Date());
    }
}