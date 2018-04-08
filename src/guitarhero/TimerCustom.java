/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitarhero;

import java.util.TimerTask;
import java.util.Timer;

/**
 *
 * @author newadmin
 */
public class TimerCustom {
    Timer timer;
    TimerTask task;
    long delay;
    public TimerCustom(long delay, TimerTask task){
        this.delay = delay;
        this.task = task;
        timer = new Timer();
    }
    public void run(){
        timer.schedule(task, delay);
    }
    public void destroy(){
        timer.cancel();
    }
}
