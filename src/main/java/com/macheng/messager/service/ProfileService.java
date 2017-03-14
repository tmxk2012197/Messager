package com.macheng.messager.service;

import com.macheng.messager.database.DatabaseClass;
import com.macheng.messager.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ProfileService {
    private static Map<String, Profile> profileMap = DatabaseClass.getProfileMap();

    public ProfileService() {
        profileMap.put("Cheng Mark", new Profile(1L, "cheng", "mark", "Cheng Mark"));
    }

    public List<Profile> getAllProfile() {
        return new ArrayList<Profile>(profileMap.values());
    }

    public Profile getProfile(String profileName) {
        return profileMap.get(profileName);
    }

    public Profile addProfile(Profile profile) {
        profile.setId(profileMap.size() + 1);
        profileMap.put(profile.getProfileName(), profile);
        return  profile;
    }

    public Profile updateProfile(Profile profile) {
        if (profile.getProfileName().length() == 0) {
            return null;
        }
        profileMap.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile removeProfile(String profileName) {
        return profileMap.remove(profileName);
    }
}
