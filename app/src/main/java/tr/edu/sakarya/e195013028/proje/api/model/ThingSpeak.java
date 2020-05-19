package tr.edu.sakarya.e195013028.proje.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ThingSpeak {



        @SerializedName("channel")
        @Expose
        private Channel channel;
        @SerializedName("feeds")
        @Expose
        private ArrayList<Feed> feeds = null;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public ArrayList<Feed> getFeeds() {
        return feeds;
    }

    public void setFeeds(ArrayList<Feed> feeds) {
        this.feeds = feeds;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ThingSpeak{");
        sb.append("channel=").append(channel);
        sb.append(", feeds=").append(feeds);
        sb.append('}');
        return sb.toString();
    }
}
