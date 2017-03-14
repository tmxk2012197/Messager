package com.macheng.messager.service;

import com.macheng.messager.database.DatabaseClass;
import com.macheng.messager.model.Message;
import com.macheng.messager.model.Profile;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class MessageService {
    private Map<Long, Message> messageMap = DatabaseClass.getMessageMap();

    public MessageService() {
        messageMap.put(1L, new Message(1, "Hello World", "Cheng"));
        messageMap.put(2L, new Message(2, "Hello Jersey", "Cheng"));
    }

    public List<Message> getAllMessages() {
        return new ArrayList<Message>(messageMap.values());
    }

    public List<Message> getAllMessages(int year) {
        List<Message> messageList = new ArrayList<Message>();
        Calendar calendar = Calendar.getInstance();
        for (Message message : messageMap.values()) {
            calendar.setTime(message.getCreatedDate());
            if (calendar.get(Calendar.YEAR) == year) {
                messageList.add(message);
            }
        }
        return messageList;
    }

    public List<Message> getAllMessage(int start, int size) {
        List<Message> messageList = new ArrayList<Message>(messageMap.values());
        if (start > messageList.size()) {
            return new ArrayList<Message>();
        }
        if (start + size > messageList.size()) {
            return messageList.subList(start, messageList.size());
        }
        return messageList.subList(start, start + size);
    }

    public Message getMessage(long id) {
        return messageMap.get(id);
    }

    public Message addMessage(Message message) {
        message.setId(messageMap.size() + 1);
        messageMap.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message) {
        if (message.getId() <= 0) {
            return null;
        }
        messageMap.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(long id) {
        return  messageMap.remove(id);
    }
}
