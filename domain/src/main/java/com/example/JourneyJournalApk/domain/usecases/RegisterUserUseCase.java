package com.example.JourneyJournalApk.domain.usecases;

import com.example.JourneyJournalApk.domain.models.RegistrationModel;
import com.example.JourneyJournalApk.domain.repositories.RegistrationRepository;

/**
 * Created on 28/03/2022.
 */
public class RegisterUserUseCase {
    private final RegistrationRepository registrationRepository;

    public RegisterUserUseCase(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public RegistrationModel registerUser(
            String fullName,
            String email,
            String address,
            String password
    ) {
        return registrationRepository.registerUser(fullName, email, address, password);
    }
}
