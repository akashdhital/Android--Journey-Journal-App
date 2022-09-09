package com.example.JourneyJournalApk.data.repositories;

import com.example.JourneyJournalApk.data.sources.dashboard.DashboardLocalSource;
import com.example.JourneyJournalApk.data.sources.dashboard.DashboardRemoteSource;

import java.util.List;

import com.example.JourneyJournalApk.domain.models.Journey;
import com.example.JourneyJournalApk.domain.repositories.DashboardRepository;

public class DashboardRepositoryImpl implements DashboardRepository {
    private final DashboardLocalSource dashboardLocalSource;
    private final DashboardRemoteSource dashboardRemoteSource;

    public DashboardRepositoryImpl(
            DashboardLocalSource dashboardLocalSource,
            DashboardRemoteSource dashboardRemoteSource
    ) {
        this.dashboardLocalSource = dashboardLocalSource;
        this.dashboardRemoteSource = dashboardRemoteSource;
    }

    @Override
    public long addJourney(String title, String description, String date, String imagePath, long userId) {
        if (dashboardRemoteSource.isInternetWorking()) {
            return dashboardRemoteSource.addJourney(title, description, date, imagePath, userId);
        } else {
            return dashboardLocalSource.addJourney(title, description, date, imagePath, userId);
        }
    }

    @Override
    public List<Journey> getUserJourneys(long userId) {
        if (dashboardRemoteSource.isInternetWorking()) {
            return dashboardRemoteSource.getUserJourneys(userId);
        } else {
            return dashboardLocalSource.getUserJourneys(userId);
        }
    }

    @Override
    public void deleteJourney(Journey journey) {
        if (dashboardRemoteSource.isInternetWorking()) {
            dashboardRemoteSource.deleteJourney(journey);
        } else {
            dashboardLocalSource.deleteJourney(journey);
        }
    }

    @Override
    public int updateJourney(Journey journey) {
        if (dashboardRemoteSource.isInternetWorking()) {
            return dashboardRemoteSource.updateJourney(journey);
        } else {
            return dashboardLocalSource.updateJourney(journey);
        }
    }
}
