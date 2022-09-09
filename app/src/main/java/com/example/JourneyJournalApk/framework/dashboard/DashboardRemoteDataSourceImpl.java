package com.example.JourneyJournalApk.framework.dashboard;

import android.app.Application;

import java.util.List;

import com.example.JourneyJournalApk.data.sources.dashboard.DashboardRemoteSource;
import com.example.JourneyJournalApk.domain.models.Journey;

public class DashboardRemoteDataSourceImpl implements DashboardRemoteSource {
    private Application application;

    public DashboardRemoteDataSourceImpl(Application application) {
        this.application = application;
    }

    @Override
    public boolean isInternetWorking() {
        return false;
    }

    @Override
    public long addJourney(String title, String description, String date, String imagePath, long userId) {
        return 0;
    }

    @Override
    public List<Journey> getUserJourneys(long userId) {
        return null;
    }

    @Override
    public void deleteJourney(Journey journey) {

    }

    @Override
    public int updateJourney(Journey journey) {
        return 0;
    }
}