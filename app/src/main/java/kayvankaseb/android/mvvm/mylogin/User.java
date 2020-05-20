package kayvankaseb.android.mvvm.mylogin;


import android.util.Patterns;

public class User {

    private String mEmail;
    private String mPassword;


    User(String email, String password) {
        mEmail = email;
        mPassword = password;
    }

    String getEmail() {
        if (mEmail == null) {
            return "";
        }
        return mEmail;
    }


    String getPassword() {

        if (mPassword == null) {
            return "";
        }
        return mPassword;
    }

    boolean isEmailValid() {
        return Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches();
    }


    boolean isPasswordLengthGreaterThan5() {
        return getPassword().length() > 6;
    }

}

