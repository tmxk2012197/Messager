package com.macheng.messager.service;

import com.macheng.messager.database.DatabaseClass;
import com.macheng.messager.model.Comment;
import com.macheng.messager.model.Message;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentService {
    private Map<Long, Message> messages = DatabaseClass.getMessageMap();

    public List<Comment> getAllComments(long messageId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return new ArrayList<Comment>(comments.values());
    }

    public Comment getComment(long messageId, long commentId) {
        Message message = messages.get(messageId);
        if (message == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        Comment comment = comments.get(commentId);
        if (comment == null) {
            throw new NotFoundException();
        }
        return comment;
    }

    public Comment addComment(long messageId, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        comment.setId(comments.size() + 1);
        comments.put(comment.getId(), comment);
        return  comment;
    }

    public Comment updateComment(long messageId, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        if (comment.getId() <= 0) {
            return null;
        }
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment removeComment(long messageId, long commentId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return comments.remove(commentId);
    }
}
