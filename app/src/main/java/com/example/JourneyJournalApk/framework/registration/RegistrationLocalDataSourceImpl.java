package com.example.JourneyJournalApk.framework.registration;

import android.app.Application;

import com.example.JourneyJournalApk.data.sources.registration.RegistrationLocalDataSource;
import com.example.JourneyJournalApk.domain.models.RegistrationModel;
import com.example.JourneyJournalApk.domain.models.User;
import com.example.JourneyJournalApk.framework.database.JourneyJournalDatabase;
import com.example.JourneyJournalApk.framework.database.RegistrationDao;
import com.example.JourneyJournalApk.framework.database.UserEntity;

/**
 * Created on 28/03/2022.
 */
public class RegistrationLocalDataSourceImpl implements RegistrationLocalDataSource {
    private final Application application;
    private RegistrationDao registrationDao;

    public RegistrationLocalDataSourceImpl(Application application) {
        this.application = application;
    }

    @Override
    public RegistrationModel registerUserInLocalDataBase(
            String fullName,
            String email,
            String address,
            String password
    ) {
        registrationDao = JourneyJournalDatabase.getInstance(application).getRegistrationDao();
        if (registrationDao.isUserAlreadyPresent(email.toLowerCase())) {
            return new RegistrationModel(false, "User Already Registered");
        }
        return insertUserDataInTable(fullName, email, address, password, registrationDao);
    }

    private RegistrationModel insertUserDataInTable(
            String fullName,
            String email,
            String address,
            String password,
            RegistrationDao registrationDao
    ) {
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.emailAddress = email.toLowerCase();
            userEntity.fullName = fullName;
            userEntity.address = address;
            userEntity.password = password;
            long rowId = registrationDao.insertUser(userEntity);
            if (rowId > 0) {
                return onSuccessRegistrationModel(email);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new RegistrationModel(false, "User Registration Failed");
    }

    private RegistrationModel onSuccessRegistrationModel(String email) {
        UserEntity userEntity = registrationDao.getRegisteredUser(email);
        User user = new User(
                userEntity.userId,
                userEntity.fullName,
                userEntity.emailAddress,
                userEntity.address
        );
        RegistrationModel registrationModel = new RegistrationModel(
                true,
                "User Registered"
        );
        registrationModel.setUser(user);
        return registrationModel;
    }
}
