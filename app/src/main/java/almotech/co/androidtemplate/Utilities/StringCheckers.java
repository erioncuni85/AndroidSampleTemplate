package almotech.co.androidtemplate.Utilities;

import android.text.TextUtils;
import android.util.Patterns;

public class StringCheckers {

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}
