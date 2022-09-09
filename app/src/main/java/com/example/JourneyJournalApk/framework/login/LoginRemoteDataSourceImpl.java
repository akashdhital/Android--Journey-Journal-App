package com.example.JourneyJournalApk.framework.login;

import com.example.JourneyJournalApk.data.sources.login.LoginRemoteDataSource;
import com.example.JourneyJournalApk.domain.models.LoginModel;

/**
 * Created on 03/03/2022.
 */
public class LoginRemoteDataSourceImpl implements LoginRemoteDataSource {
    @Override
    public boolean isInternetWorking() {
        return false;
    }

    @Override
    public LoginModel authenticateLoginInRemoteServer(String email, String password) {
        return null;
    }
}
