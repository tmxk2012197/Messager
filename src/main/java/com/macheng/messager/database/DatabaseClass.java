package com.macheng.messager.database;

import com.macheng.messager.model.Message;
import com.macheng.messager.model.Profile;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {
    private static Map<Long, Message> messageMap = new HashMap<Long, Message>();
    private static Map<String, Profile> profileMap = new HashMap<String, Profile>();

    public static Map<Long, Message> getMessageMap() {
        return messageMap;
    }

    public static Map<String, Profile> getProfileMap() {
        return profileMap;
    }
}
