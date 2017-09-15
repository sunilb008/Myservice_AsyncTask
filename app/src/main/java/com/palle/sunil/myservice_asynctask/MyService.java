package com.palle.sunil.myservice_asynctask;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

public class MyService extends Service {
    public  class MyTask extends AsyncTask<Void,Integer,Integer>{

        @Override
        protected Integer doInBackground(Void... params) {
            int sum=0;
            for( int i=1;i<=10; i++){
                sum=sum + i;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);

            }
           Log.d("B37","DoingBackground");
            return sum;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("B37","Async-on Pre Exectue");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            MainActivity.pb.setProgress(values[0]*10);
            Log.d("B37","Async-onProgress"+values[0]);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            MainActivity.tv1.setText("Result:"+integer);

            super.onPostExecute(integer);
            Log.d("B37","Async-onpostExectue"+integer);
        }
    }
    public MyService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();//VOid means dont return Anything
        Log.d("B37","Async-oncreate");
    }

    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {
        MyTask myTask=new MyTask();
        myTask.execute();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy()
    {
        Log.d("B37","On--destory1");
        super.onDestroy();
        Log.d("B37","On--destory2");
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
