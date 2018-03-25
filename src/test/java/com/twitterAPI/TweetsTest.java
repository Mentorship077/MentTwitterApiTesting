package com.twitterAPI;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.twitterAPI.api.TweetsApi;
import com.twitterAPI.payloads.HomeTimeLine;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static com.twitterAPI.constants.TwitterAPIConsts.HOME_TIMELINE_DEFAULT_TWEETS;
import static com.twitterAPI.constants.TwitterAPIConsts.SAMPLE_TWEET_DECRIPTION;

public class TweetsTest extends BaseTestClass {

    private TweetsApi tweetsApi = new TweetsApi();
    private ObjectMapper mapper = new ObjectMapper();
    private CollectionType javaType = mapper.getTypeFactory().constructCollectionType(List.class, HomeTimeLine.class);

    @Test
    public void testHomeTimeLineTweets() throws IOException {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<HomeTimeLine> asList = mapper.readValue(tweetsApi.getHomeTimeLine().asString(), javaType);

//        Assert.assertEquals(HOME_TIMELINE_DEFAULT_TWEETS,asList.size());

//        for (HomeTimeLine timeLine : asList) {
//            System.out.println(timeLine.getUser().getName());
//        }
    }

    @Test
    public void testUserTimeLineTweets() throws IOException {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        List<HomeTimeLine> asList = mapper.readValue(tweetsApi.getUserTimeLine().asString(), javaType);

        for (HomeTimeLine userTweet : asList) {
            System.out.println(userTweet);
        }
    }


    @Test
    public void testUserTweetCreating() throws IOException {
        int tweetsCount;
//         creating
        tweetsApi.createTweet(SAMPLE_TWEET_DECRIPTION);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<HomeTimeLine> listAfterCreating = mapper.readValue(tweetsApi.getUserTimeLine().asString(), javaType);

        Assert.assertEquals(listAfterCreating.get(0).getText(),SAMPLE_TWEET_DECRIPTION);

//        deleting
        tweetsCount = listAfterCreating.size();
        tweetsApi.deleteTweet(listAfterCreating.get(0).getId());
        List<HomeTimeLine> listAfterDeleting = mapper.readValue(tweetsApi.getUserTimeLine().asString(), javaType);

        Assert.assertEquals(tweetsCount,listAfterDeleting.size());
    }

}
