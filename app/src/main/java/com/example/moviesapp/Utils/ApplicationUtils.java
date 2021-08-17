package com.example.moviesapp.Utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.RequiresApi;


public class ApplicationUtils {


        /***************
         * Data Members
         */
        private static final String DEBUG_TAG = "NetworkStatusExample";



        /*******************************
         * Method for network is in working state or not.
         ******************************/
        public static boolean isOnline(Context context) {
            ConnectivityManager cm = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnectedOrConnecting()
                    && cm.getActiveNetworkInfo().isAvailable()
                    && cm.getActiveNetworkInfo().isConnected()) {
                return true;
            }
            return false;
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public static boolean isNetworkAvailable(Context context) {

            ConnectivityManager connMgr =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            boolean isWifiConn = false;
            boolean isMobileConn = false;
            for (Network network : connMgr.getAllNetworks()) {
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

                if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                    isWifiConn |= networkInfo.isConnected() && networkInfo.isAvailable() && networkInfo.isConnectedOrConnecting();
                    return true;
                }
                if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                    isMobileConn |= networkInfo.isConnected() && networkInfo.isAvailable() && networkInfo.isConnectedOrConnecting();
                    return true;
                }
            }
            Log.d(DEBUG_TAG, "Wifi connected: " + isWifiConn);
            Log.d(DEBUG_TAG, "Mobile connected: " + isMobileConn);
            return true;
        }

        /*******************************
         * Hide keyboard from edit text
         ******************************/
        public static void hideKeyboard(Activity context) {
            InputMethodManager inputManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            View view = context.getCurrentFocus();
            if (view != null) {
                inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }


}
