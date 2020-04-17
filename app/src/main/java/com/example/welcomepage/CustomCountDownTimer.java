package com.example.welcomepage;


import android.os.Handler;

/**
 * Created by Icon on 2020/4/15 0015.
 */
public class CustomCountDownTimer implements Runnable {
    private  int time;
    private  int countDowntime;
    private final  ICountDownHandler countDownHandler;
    private final Handler handler;
    private boolean isRun;

    //1.实时回调，这个时候是什么时间 倒计时几秒
    //2.支持动态传入总时间
    //3.每过一秒，总数减一
    //4.总时间为0时，要回调完成状态
    public CustomCountDownTimer(int time ,  ICountDownHandler countDownHandler) {
        handler = new Handler() ;
        this.time = time;
        this.countDowntime = time;
        this.countDownHandler = countDownHandler;

    }
    //实现具体逻辑
    @Override
    public void run() {
        if (isRun){
            if (countDownHandler != null){
                countDownHandler.onTicker(countDowntime);
            }
            if(countDowntime == 0){
                if(countDownHandler != null){
                    countDownHandler.onFinish();
                }
            }else {
                countDowntime = time --;
                handler.postDelayed(this,1000);
            }
        }
    }
    //开始计时
    public void start(){
        isRun = true;
        handler.post(this);
    }
    //
    public void  cancel(){
        isRun = false;
        handler.removeCallbacks(this);
    }
    //观察者回调接口
    public interface ICountDownHandler{
       //倒计时回调
        void onTicker(int time);

        //完成时回调
        void onFinish();
   }

}
