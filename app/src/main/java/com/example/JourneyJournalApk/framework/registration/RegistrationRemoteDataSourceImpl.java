package com.example.JourneyJournalApk.framework.registration;

import android.app.Application;

import com.example.JourneyJournalApk.data.sources.registration.RegistrationRemoteDataSource;
import com.example.JourneyJournalApk.domain.models.RegistrationModel;

/**
 * Created on 28/03/2022.
 */
public class RegistrationRemoteDataSourceImpl implements RegistrationRemoteDataSource {
    private Application application;

    public RegistrationRemoteDataSourceImpl(Application application) {
        this.application = application;
    }

    @Override
    public boolean isInternetWorking() {
        return false;
    }

    @Override
    public RegistrationModel registerUserInRemoteServer(
            String fullName,
            String email,
            String address,
            String password
    ) {
        return null;
    }
}
