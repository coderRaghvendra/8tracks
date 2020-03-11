package com.swiggy.tracks.resource;

import com.swiggy.tracks.request.GetSongsByTagsRequest;
import com.swiggy.tracks.request.Request;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by raghvendra.mishra on 28/08/19.
 */
@Path("/explore")
@Produces(MediaType.APPLICATION_JSON)
public class SongTagResource extends AbstractResource {

    private static final Logger logger = LogManager.getLogger(SongTagResource.class);

    /**
     ** GET
     **/
    @GET
    @Path("/{tags}")
    public String getSongsByTags(@PathParam("tags") String tags) {
        String[] tagArr = tags.trim().split("\\+");
        List<String> tagList = new ArrayList<>();
        for(String s : tagArr) {
            tagList.add(s);
        }
        Request request =  new GetSongsByTagsRequest.Builder().tags(tagList).build();
        return processRequest(request);
    }
}
