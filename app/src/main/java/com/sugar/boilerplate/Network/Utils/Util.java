package com.sugar.boilerplate.Network.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Toast;


public class Util  {
    private static final String TAG = Util.class.getName();



    public static Boolean isValidURL(String URL) {
        return Patterns.WEB_URL.matcher(URL).matches();
    }

    public static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
    public static boolean isValidMobile(CharSequence target) {
        return !TextUtils.isEmpty(target) && Patterns.PHONE.matcher(target).matches();
    }
    public static void showToastMsg( Context context, String msg) {
        try {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

        }
    }


    public static boolean isConnectingToInternet(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null)
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
        }
        return false;
    }

//    public static Dialog loadingDialog( Context mContext) {
//        Dialog pd = new Dialog(mContext, android.R.style.Theme_Black_NoTitleBar);
//        View view = LayoutInflater.from(mContext).inflate(R.layout.progress_dialog, null);
//        pd.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        pd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        pd.setContentView(view);
//        return pd;
//    }



//    public static SpotsDialog progressDialog( Context context) {
//        SpotsDialog dialog = new SpotsDialog(context, R.style.dialog_style);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        return dialog;
//    }


}
