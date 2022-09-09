package com.example.JourneyJournalApk.presentation.login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.JourneyJournalApk.data.repositories.LoginRepositoryImpl;
import com.example.JourneyJournalApk.domain.models.LoginModel;
import com.example.JourneyJournalApk.domain.usecases.LoginAuthenticateUseCase;
import com.example.JourneyJournalApk.framework.login.LoginLocalDataSourceImpl;
import com.example.JourneyJournalApk.framework.login.LoginRemoteDataSourceImpl;


/**
 * Created on 28/02/2022.
 */
public class LoginViewModel extends AndroidViewModel {
    final MutableLiveData<Boolean> isEmailOrPasswordEmptyLiveData = new MutableLiveData<>();
    final MutableLiveData<Boolean> isEmailIncorrectLiveData = new MutableLiveData<>();
    final MutableLiveData<Boolean> isPasswordIncorrectLiveData = new MutableLiveData<>();
    final MutableLiveData<LoginModel> loginModelLiveData = new MutableLiveData<>();

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    private LoginAuthenticateUseCase loginAuthenticateUseCase = new LoginAuthenticateUseCase(
            new LoginRepositoryImpl(
                    new LoginRemoteDataSourceImpl(),
                    new LoginLocalDataSourceImpl(getApplication())
            )
    );

    public void validateLoginCredentials(String emailAddress, String password) {
        if (emailAddress.isEmpty() || password.isEmpty()) {
            isEmailOrPasswordEmptyLiveData.setValue(true);
            return;
        } else {
            isEmailOrPasswordEmptyLiveData.setValue(false);
        }

        if (!emailAddress.matches("[A-Z0-9._%+-]+@[A-Z0-9.-]+.[A-Z]{2,4}\n")) {
            isEmailIncorrectLiveData.setValue(true);
        } else {
            isEmailIncorrectLiveData.setValue(false);
        }
        LoginModel loginModel = loginAuthenticateUseCase.authenticateLogin(emailAddress, password);
        loginModelLiveData.setValue(loginModel);
    }
}
