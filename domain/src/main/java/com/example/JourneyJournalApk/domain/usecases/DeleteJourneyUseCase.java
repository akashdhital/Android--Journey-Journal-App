package com.example.JourneyJournalApk.domain.usecases;

import com.example.JourneyJournalApk.domain.models.Journey;
import com.example.JourneyJournalApk.domain.repositories.DashboardRepository;

public class DeleteJourneyUseCase {
    private DashboardRepository dashboardRepository;

    public DeleteJourneyUseCase(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }

    public void deleteJourney(Journey journey) {
        dashboardRepository.deleteJourney(journey);
    }
}
