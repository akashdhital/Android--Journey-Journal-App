package com.example.JourneyJournalApk.domain.repositories;

import com.example.JourneyJournalApk.domain.models.RegistrationModel;

/**
 * Created on 28/03/2022.
 */
public interface RegistrationRepository {
    RegistrationModel registerUser(String fullName, String email, String address, String password);
}
