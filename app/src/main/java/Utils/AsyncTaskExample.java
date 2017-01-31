package Utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.sushil.myapplication.HandlessFragment;

/**
 * Created by Sushil on 1/31/2017.
 */

public class AsyncTaskExample extends AsyncTask<Void,Integer,Void> {
    HandlessFragment.TaskStatusCallback mTaskListener;
    Context mContext;
    private ProgressDialog progressDialog;

    public AsyncTaskExample(HandlessFragment.TaskStatusCallback taskListener, Context context) {
        this.mTaskListener=taskListener;
        this.mContext=context;
    }

    @Override
    protected void onPreExecute() {
       if(mTaskListener!=null) {
           mTaskListener.onPreExecute();
         //  progressDialog = ProgressDialog.show(mContext, "Loading", "Please wait a moment!");

       }
    }

    @Override
    protected Void  doInBackground(Void... params) {
        for (int i = 1; !isCancelled() && i < 100; i++) {
            Log.d("GREC", "AsyncTask is working: " + i);
            try {
                Thread.sleep(1000);
                publishProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return  null;
    }
    @Override
    protected void onCancelled() {
        if (mTaskListener != null) {
            mTaskListener.onCancelled();
        }
    }

    @Override
    protected void onPostExecute(Void s) {
            if(mTaskListener!=null) {
                mTaskListener.onPostExecute();

            }
      //  progressDialog.dismiss();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
//        mTaskListener.onTaskFinished();
       if(mTaskListener!=null) {
        mTaskListener.onProgressUpdate(values[0]);

    }

    }
}
