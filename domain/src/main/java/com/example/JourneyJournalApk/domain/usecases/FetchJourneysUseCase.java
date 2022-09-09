package com.example.JourneyJournalApk.domain.usecases;

import java.util.List;

import com.example.JourneyJournalApk.domain.models.Journey;
import com.example.JourneyJournalApk.domain.repositories.DashboardRepository;

public class FetchJourneysUseCase {
    private final DashboardRepository dashboardRepository;

    public FetchJourneysUseCase(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }

    public List<Journey> getUserJourneys(long userId) {
        return dashboardRepository.getUserJourneys(userId);
    }
}
