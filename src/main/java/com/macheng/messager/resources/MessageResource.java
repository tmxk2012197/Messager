package com.macheng.messager.resources;

import com.macheng.messager.model.Message;
import com.macheng.messager.resources.bean.MessageResourceBean;
import com.macheng.messager.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
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
    public Message getMessage(@PathParam("messageId") long id, @Context UriInfo uriInfo) {
        Message message = messageService.getMessage(id);
        message.addLink(getUrlForSelf(uriInfo, message), "self");
        message.addLink(getUriForProfile(uriInfo, message), "profile");
        message.addLink(getUriForComments(uriInfo, message), "comments");
        return message;
    }

    @POST
    public Response addMessage(Message message, @Context UriInfo uriInfo) {
       Message newMessage = messageService.addMessage(message);
        URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMessage.getId())).build();
        return Response.created(uri).entity(newMessage).build();
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

    private String getUrlForSelf(UriInfo uriInfo, Message message) {
        return uriInfo.getBaseUriBuilder().path(MessageResource.class).path(Long.toString(message.getId())).build().toString();
    }

    private String getUriForProfile(UriInfo uriInfo, Message message) {
       return uriInfo.getBaseUriBuilder().path(ProfileResource.class).path(message.getAuthor()).build().toString();
    }

    private String getUriForComments(UriInfo uriInfo, Message message) {
       return uriInfo.getBaseUriBuilder()
               .path(MessageResource.class).path(MessageResource.class, "getCommentResource").path(CommentResource.class)
               .resolveTemplate("messageId", message.getId())
               .build().toString();
    }
}
