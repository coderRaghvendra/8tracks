package com.swiggy.tracks.resource;

import com.swiggy.tracks.request.GetSongsByTagsRequest;
import com.swiggy.tracks.request.Request;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by raghvendra.mishra on 28/08/19.
 */
@ValidateRequest(ValidateRequest.ValidationType.ALL)
@Path("explore")
@Produces(MediaType.APPLICATION_JSON)
public class SongTagResource extends AbstractResource {

    private static final Logger logger = LogManager.getLogger(SongTagResource.class);

    /**
     ** GET
     **/
    @GET
    @Path("songs")
    public String getSongsByTags(@QueryParam("tag") String email, @QueryParam(EMAIL_KEY) String emailKey) {
        Request request =  new GetSongsByTagsRequest.Builder().email(email).emailKey(emailKey).build();
        return processRequest(request);
    }
}
