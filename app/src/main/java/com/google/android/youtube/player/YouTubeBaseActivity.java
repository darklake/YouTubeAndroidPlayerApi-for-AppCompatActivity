//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.google.android.youtube.player;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayerView.b;

public class YouTubeBaseActivity extends AppCompatActivity {
    private a mAObject;
    private YouTubePlayerView b;
    private int c;
    private Bundle d;

    public YouTubeBaseActivity() {
    }

    final b a() {
        return this.mAObject;
    }

    protected void onCreate(Bundle var1) {
        super.onCreate(var1);
        this.mAObject = new a();
        this.d = var1 != null ? var1.getBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE") : null;
    }

    protected void onStart() {
        super.onStart();
        this.c = 1;
        if (this.b != null) {
            this.b.a();
        }

    }

    protected void onResume() {
        super.onResume();
        this.c = 2;
        if (this.b != null) {
            this.b.b();
        }

    }

    protected void onPause() {
        this.c = 1;
        if (this.b != null) {
            this.b.c();
        }

        super.onPause();
    }

    protected void onSaveInstanceState(Bundle var1) {
        super.onSaveInstanceState(var1);
        Bundle var2 = this.b != null ? this.b.e() : this.d;
        var1.putBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE", var2);
    }

    protected void onStop() {
        this.c = 0;
        if (this.b != null) {
            this.b.d();
        }

        super.onStop();
    }

    protected void onDestroy() {
        if (this.b != null) {
            this.b.b(this.isFinishing());
        }

        super.onDestroy();
    }

    private final class a implements b {
        private a() {
        }

        public final void a(YouTubePlayerView var1, String var2, OnInitializedListener var3) {
            var1.a(YouTubeBaseActivity.this, var1, var2, var3, YouTubeBaseActivity.this.d);
            YouTubeBaseActivity.this.b = var1;
        }

        public final void a(YouTubePlayerView var1) {
            if (YouTubeBaseActivity.this.b != null && YouTubeBaseActivity.this.b != var1) {
                YouTubeBaseActivity.this.b.c(true);
            }

            YouTubeBaseActivity.this.b = var1;
            if (YouTubeBaseActivity.this.c > 0) {
                var1.a();
            }

            if (YouTubeBaseActivity.this.c >= 2) {
                var1.b();
            }

        }
    }
}
