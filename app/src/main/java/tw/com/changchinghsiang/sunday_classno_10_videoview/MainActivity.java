package tw.com.changchinghsiang.sunday_classno_10_videoview;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findviewer();
    }

    private void findviewer() {
        videoView = (VideoView) findViewById(R.id.videoView);
    }

    //播放
    public void StartOnClick(View view) {
        //宣告控制物件
        MediaController controller = new MediaController(this);
        //控制物件與播放物件相交勾機
        controller.setAnchorView(videoView);
        videoView.setMediaController(controller);
        //設定螢幕保持開啟狀態
        videoView.setKeepScreenOn(true);
        //設定影片來源
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.wgperformance));
        //播放
        videoView.start();
        //影片物件取得焦點
        videoView.requestFocus();
    }

    //停止
    public void StopOnClick(View view) {
        //停止播放
        videoView.stopPlayback();
        //影片物件取得焦點
        videoView.requestFocus();
    }
}
