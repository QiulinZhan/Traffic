package com.example.qiulin.traffic.utils;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;

import com.example.qiulin.traffic.R;
import com.example.qiulin.traffic.beans.GridViewItem;
import com.nispok.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mikepenz on 18.10.14.
 */
public class UploadHelper {
    private static UploadHelper instance = null;


    private UploadHelper(ActionBarActivity act, List<GridViewItem> applicationList) {
        this.act = act;

        if (applicationList != null) {
            this.applicationList = applicationList;
        } else {
            this.applicationList = new ArrayList<>();
        }
    }

    private ActionBarActivity act;
    private List<GridViewItem> applicationList = new ArrayList<GridViewItem>();

    public static UploadHelper getInstance(ActionBarActivity act, List<GridViewItem> applicationList) {
        if (instance == null) {
            instance = new UploadHelper(act, applicationList);
        } else if (act != null) {
            instance.act = act;
        }
        return instance;
    }

    public UploadComponentInfoTask upload(GridViewItem GridViewItem) {
        UploadComponentInfoTask ucit = new UploadComponentInfoTask();
        ucit.execute(GridViewItem);
        return ucit;
    }

    public UploadComponentInfoTask uploadAll() {
        UploadComponentInfoTask ucit = new UploadComponentInfoTask();
        ucit.execute();
        return ucit;
    }

    public class UploadComponentInfoTask extends AsyncTask<GridViewItem, Integer, Boolean> {
        ProgressDialog mProgressDialog;

        public boolean isRunning = false;

        public void showProgress(Activity act) {
            mProgressDialog = new ProgressDialog(act);
            mProgressDialog.setTitle("UPLOAD");
            mProgressDialog.setMessage("成功");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setMax(applicationList.size());
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

            mProgressDialog.show();
        }

        @Override
        protected void onPreExecute() {
            if (!Network.isAvailiable(act)) {
                this.cancel(true);
                Snackbar.with(act).text("").show(act);
            } else {
                showProgress(act);
            }

            isRunning = true;

            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(GridViewItem... params) {
            boolean updateRequired = false;
            if (params == null || params.length == 0) {
                mProgressDialog.setMax(applicationList.size());

                int i = 0;
                for (GridViewItem ai : applicationList) {
                    updateRequired = postData();
                    publishProgress(i);
                    if (updateRequired) {
                        break;
                    }
                    i++;
                }
            } else if (params.length == 1) {
                updateRequired = postData();
                publishProgress(applicationList.size());
            }

            return updateRequired;
        }

        @Override
        protected void onPostExecute(Boolean updateRequired) {
            isRunning = false;

            if (mProgressDialog != null) {
                mProgressDialog.dismiss();
            }
            super.onPostExecute(updateRequired);
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            if (values.length > 0 && mProgressDialog != null) {
                mProgressDialog.setProgress(values[0]);
            }
            super.onProgressUpdate(values);
        }

    }

    public boolean postData() {

        try {
            Thread.sleep(100);
        } catch (Exception ex) {

        }

        return false;
    }
}
