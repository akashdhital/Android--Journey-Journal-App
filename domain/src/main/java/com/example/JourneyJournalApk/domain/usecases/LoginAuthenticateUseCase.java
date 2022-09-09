package com.example.JourneyJournalApk.domain.usecases;

import com.example.JourneyJournalApk.domain.models.LoginModel;
import com.example.JourneyJournalApk.domain.repositories.LoginRepository;

/**
 * Created on 02/03/2022.
 */
public class LoginAuthenticateUseCase {
    private final LoginRepository loginRepository;

    public LoginAuthenticateUseCase(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public LoginModel authenticateLogin(String email, String password) {
        return loginRepository.authenticateLogin(email, password);
    }
}
