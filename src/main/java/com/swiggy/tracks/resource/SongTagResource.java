package com.swiggy.tracks.resource;

import com.swiggy.tracks.request.GetSongsByTagsRequest;
import com.swiggy.tracks.request.Request;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by raghvendra.mishra on 28/08/19.
 */
//@ValidateRequest(ValidateRequest.ValidationType.ALL)
@Path("/explore")
@Produces(MediaType.APPLICATION_JSON)
public class SongTagResource extends AbstractResource {

//    http://localhost:8080/profile/get/13?userId=13
//    http://localhost:8080/explore/acoustic+john_mayer+Coldplay

    private static final Logger logger = LogManager.getLogger(SongTagResource.class);

    /**
     ** GET
     **/
//    public String getSongsByTags(@PathParam("tags") String tags) {
    @GET
    @Path("/test")
    public String getSongsByTags() {
        logger.info("control reached = ");
        System.out.println("control reached = ");
//        logger.info("tags = " + tags);
        Request request =  new GetSongsByTagsRequest.Builder().build();
        return processRequest(request);
    }
}
