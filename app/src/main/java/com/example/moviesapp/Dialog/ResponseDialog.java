/********************************
 * Developed By: Codesses
 * Developer Name: Saad Iftikhar
 * @param
 */

package com.example.moviesapp.Dialog;

import android.app.Activity;
import android.content.Context;

import com.example.moviesapp.R;
import com.tapadoo.alerter.Alerter;

public class ResponseDialog {

    /******************
     * Data Members
     */

//    TODO: Constants
    public static final int NOTIFICATION_DURATION = 2000;

    private static Context context;
    private static android.app.ProgressDialog progressDialog;


    /*************************************
     * Member Functions Of Progress Dialog
     * Initialize Progress Dialog
     * Show Progress Dialog
     * Dismiss Dialog
     * @param
     */

    //        TODO: Initialize Progress Dialog
    public static void getInstance(Context ctx) {
        context = ctx;
        progressDialog = new android.app.ProgressDialog(context);
    }


    //    TODO: Show Progress Dialog
    public static void showProgressDialog(Context ctx, int title, int msg) {

        ResponseDialog.getInstance(ctx);

        progressDialog.setTitle(context.getString(title));
        progressDialog.setMessage(context.getString(msg));
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }


    //        TODO: Dismiss Progress Dialog
    public static void dismissProgressDialog() {
        progressDialog.dismiss();
    }

    /*********************
     * Progress Dialog End
     */


    /******************************
     * Notification Dialog Start
     */

    public static void showSuccessNotification(Activity mContext, String title, String message) {
        Alerter.create(mContext)
                .setTitle(title)
                .setText(message)
                .setBackgroundColorRes(R.color.success_color) // or setBackgroundColorInt(Color.CYAN) // setBackgroundColorRes(R.color.colorAccent)
                .setIcon(R.drawable.ic_success)
                .setIconColorFilter(0)
                .setDuration(NOTIFICATION_DURATION)
                .show();
    }

    public static void showFailedNotification(Activity mContext, String title, String message) {
        Alerter.create(mContext)
                .setTitle(title)
                .setText(message)
                .setBackgroundColorRes(R.color.error_color) // or setBackgroundColorInt(Color.CYAN) // setBackgroundColorRes(R.color.colorAccent)
                .setIcon(R.drawable.ic_warning)
                .setIconColorFilter(0)
                .setDuration(NOTIFICATION_DURATION)
                .show();
    }

}
