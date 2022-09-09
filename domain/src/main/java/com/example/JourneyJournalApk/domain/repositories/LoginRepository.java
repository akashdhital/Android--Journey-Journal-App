package com.example.JourneyJournalApk.domain.repositories;

import com.example.JourneyJournalApk.domain.models.LoginModel;

/**
 * Created on 02/03/2022.
 */
public interface LoginRepository {
    LoginModel authenticateLogin(String email, String password);
}
