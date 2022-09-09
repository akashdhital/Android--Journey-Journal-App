package com.example.JourneyJournalApk.data.sources.dashboard;

import java.util.List;

import com.example.JourneyJournalApk.domain.models.Journey;

public interface DashboardRemoteSource {
    boolean isInternetWorking();

    long addJourney(String title, String description, String date, String imagePath, long userId);

    List<Journey> getUserJourneys(long userId);

    void deleteJourney(Journey journey);

    int updateJourney(Journey journey);
}
