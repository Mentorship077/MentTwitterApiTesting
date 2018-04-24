package com.twitterAPI;

import com.twitterAPI.api.TweetsApi;
import com.twitterAPI.payloads.tweets.HomeTimeLine;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static com.twitterAPI.constants.TwitterAPIConsts.SAMPLE_TWEET_DECRIPTION;

public class TweetsTest extends BaseTestClass {

    private TweetsApi tweetsApi = new TweetsApi();

    @Test
    public void testHomeTimeLineTweets() throws IOException {
        List<HomeTimeLine> homeTimeLine = tweetsApi.getHomeTimeLineModel();

        for (HomeTimeLine timeLine : homeTimeLine) {
            System.out.println(timeLine.getUser().getName());
        }
        Assert.assertTrue(homeTimeLine.size() > 1, "Size of homeTimeLine " + homeTimeLine.size());

    }

    @Test
    public void testUserTweetCreating() throws IOException {
        int tweetsCount;
//         creating
        tweetsApi.createTweet(SAMPLE_TWEET_DECRIPTION);
        List<HomeTimeLine> listAfterCreating = tweetsApi.getUserTimeLineModel();
        Assert.assertEquals(listAfterCreating.get(0).getText(), SAMPLE_TWEET_DECRIPTION);

//        deleting
        tweetsCount = listAfterCreating.size();
        tweetsApi.deleteTweet(listAfterCreating.get(0).getId());
        List<HomeTimeLine> listAfterDeleting = tweetsApi.getUserTimeLineModel();
        Assert.assertEquals(tweetsCount, listAfterDeleting.size(),"Asserting tweets after deleting and getting actual result");
    }

//    @Test
//    public void shouldReturnPersonForTheId() {
//        given().
//                accept(ContentType.JSON).
//                pathParam("id", 1).
//                when().
//                get("/people/{id}").
//                then().
//                statusCode(200).
//                body(
//                        "id", is(1),
//                        "name", is("Praveer")
//                );
//    }

}
