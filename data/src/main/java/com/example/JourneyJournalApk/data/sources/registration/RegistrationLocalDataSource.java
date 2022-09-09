package com.example.JourneyJournalApk.data.sources.registration;

import com.example.JourneyJournalApk.domain.models.RegistrationModel;

/**
 * Created on 28/03/2022.
 */
public interface RegistrationLocalDataSource {
    RegistrationModel registerUserInLocalDataBase(
            String fullName,
            String email,
            String address,
            String password
    );
}
