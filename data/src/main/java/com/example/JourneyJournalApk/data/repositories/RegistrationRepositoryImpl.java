package com.example.JourneyJournalApk.data.repositories;

import com.example.JourneyJournalApk.data.sources.registration.RegistrationLocalDataSource;
import com.example.JourneyJournalApk.data.sources.registration.RegistrationRemoteDataSource;

import com.example.JourneyJournalApk.domain.models.RegistrationModel;
import com.example.JourneyJournalApk.domain.repositories.RegistrationRepository;

/**
 * Created on 28/03/2022.
 */
public class RegistrationRepositoryImpl implements RegistrationRepository {
    private RegistrationLocalDataSource registrationLocalDataSource;
    private RegistrationRemoteDataSource registrationRemoteDataSource;

    public RegistrationRepositoryImpl(
            RegistrationLocalDataSource registrationLocalDataSource,
            RegistrationRemoteDataSource registrationRemoteDataSource
    ) {
        this.registrationLocalDataSource = registrationLocalDataSource;
        this.registrationRemoteDataSource = registrationRemoteDataSource;
    }

    @Override
    public RegistrationModel registerUser(
            String fullName,
            String email,
            String address,
            String password
    ) {
        if (registrationRemoteDataSource.isInternetWorking()) {
            return registrationRemoteDataSource
                    .registerUserInRemoteServer(fullName, email, address, password);
        }
        return registrationLocalDataSource
                .registerUserInLocalDataBase(fullName, email, address, password);
    }
}
