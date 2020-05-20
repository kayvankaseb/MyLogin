package kayvankaseb.android.mvvm.mylogin;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;


public class LoginViewModel extends ViewModel {


    public MutableLiveData<String> errorPassword = new MutableLiveData<>();
    public MutableLiveData<String> errorEmail = new MutableLiveData<>();
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    private MutableLiveData<Integer> busyProcess;

    public MutableLiveData<Integer> getBusy() {

        if (busyProcess == null) {
            busyProcess = new MutableLiveData<>();
            busyProcess.setValue(8);
        }

        return busyProcess;
    }


    private MutableLiveData<User> userMutableLiveData;

    LiveData<User> getUser() {
        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }

        return userMutableLiveData;
    }


    public void onLoginClicked() {

        getBusy().setValue(0);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                User user = new User(email.getValue(), password.getValue());

                if (!user.isEmailValid()) {
                    errorEmail.setValue("Pleas enter a valid email address!");
                } else {
                    errorEmail.setValue(null);
                }

                if (!user.isPasswordLengthGreaterThan5())
                    errorPassword.setValue("The minimum Password Length must be greater than 6!");
                else {
                    errorPassword.setValue(null);
                }

                userMutableLiveData.setValue(user);
                busyProcess.setValue(8);

            }
        }, 4000);
    }
}