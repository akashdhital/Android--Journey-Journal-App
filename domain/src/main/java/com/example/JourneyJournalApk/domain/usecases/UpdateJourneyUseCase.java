package com.example.JourneyJournalApk.domain.usecases;

import com.example.JourneyJournalApk.domain.models.Journey;
import com.example.JourneyJournalApk.domain.repositories.DashboardRepository;

public class UpdateJourneyUseCase {
    private final DashboardRepository dashboardRepository;

    public UpdateJourneyUseCase(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }

    public int updateJourney(Journey journey) {
        return dashboardRepository.updateJourney(journey);
    }
}
