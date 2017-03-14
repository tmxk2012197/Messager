package com.macheng.messager.resources;

import com.macheng.messager.model.Message;
import com.macheng.messager.resources.bean.MessageResourceBean;
import com.macheng.messager.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
    private MessageService messageService = new MessageService();

   @GET
    public List<Message> getMessage(@BeanParam MessageResourceBean messageResourceBean) {
        if (messageResourceBean.getYear() > 0) {
            return messageService.getAllMessages(messageResourceBean.getYear());
        }
        if (messageResourceBean.getStart() >= 0 && messageResourceBean.getSize() >= 0) {
            return messageService.getAllMessage(messageResourceBean.getStart() , messageResourceBean.getSize());
        }
        return messageService.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long id) {
        return messageService.getMessage(id);
    }

    @POST
    public Message addMessage(Message message) {
      return   messageService.addMessage(message);
    }

    @PUT
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") long id, Message message) {
        message.setId(id);
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId") long id) {
        messageService.removeMessage(id);
    }

    @Path("/{messageId}/comments")
    public CommentResource getCommentResource() {
        return new CommentResource();
    }
}
