package wsienski.iview.mycustomapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.jorgecastillo.FillableLoader;
import com.github.jorgecastillo.State;
import com.github.jorgecastillo.listener.OnStateChangeListener;

import butterknife.Bind;
import butterknife.ButterKnife;
import wsienski.iview.mycustomapp.R;
import wsienski.iview.mycustomapp.utils.SVGPaths;

/**
 * Created by WSienski on 25/03/2016.
 */
public class StartActivity extends AppCompatActivity {

    @Bind(R.id.fillableLoader)
    FillableLoader fillableLoader;
    @Bind(R.id.fillableLoader2)
    FillableLoader fillableLoader2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);

        fillableLoader.setSvgPath(SVGPaths.getOspIconPath());
        fillableLoader.setOnStateChangeListener(getOnStateListenerIcon());
        fillableLoader.start();

        fillableLoader2.setSvgPath(SVGPaths.getOspTextPathPath());
        fillableLoader2.start();
    }

    OnStateChangeListener getOnStateListenerIcon() {
        return new OnStateChangeListener() {
            @Override
            public void onStateChange(int state) {
                switch (state) {
                    case State.FINISHED:
                        Intent intent = new Intent(StartActivity.this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        StartActivity.this.startActivity(intent);
                        break;
                }
            }
        };
    }

}
