package com.example.JourneyJournalApk.data.sources.login;

import com.example.JourneyJournalApk.domain.models.LoginModel;

/**
 * Created on 02/03/2022.
 */
public interface LoginLocalDataSource {
    LoginModel authenticateLoginInLocalDatabase(String email, String password);
}
