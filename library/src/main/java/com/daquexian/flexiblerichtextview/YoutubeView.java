package com.daquexian.flexiblerichtextview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeView extends LinearLayout implements YouTubePlayer.OnInitializedListener {

    private static final String TAG = "YoutubeView";
    private static final String DEVELOPER_KEY = "AIzaSyDi-SKCkU5c5CzSek1g8pFp4ruOKt8vlNE";
    private String mId;
    private YouTubePlayerView mYouTubePlayerView;

    public YoutubeView(Context context, String id) {
        super(context);
        init(this);
        this.mId = id;
    }

    public YoutubeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        init(this);
    }

    public YoutubeView(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(context, attributeSet, defStyleAttr);
        init(this);
    }

    private void init(ViewGroup parent) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.default_youtube_view, parent, false);
        mYouTubePlayerView = (YouTubePlayerView) view.findViewById(R.id.youtube_view);
        mYouTubePlayerView.initialize(DEVELOPER_KEY, this);
        addView(view);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        if (!wasRestored) {
            youTubePlayer.cueVideo(mId);
            youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.MINIMAL);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
