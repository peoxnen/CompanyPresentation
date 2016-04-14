package wsienski.iview.mycustomapp.ui.timeline;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.vipul.hp_hp.timelineview.TimelineView;

import wsienski.iview.mycustomapp.R;

public class TimeLineViewHolder extends RecyclerView.ViewHolder {
    public TextView name;
    public TextView year;
    public TimelineView mTimelineView;

    public TimeLineViewHolder(View itemView, int viewType) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.tx_name);
        year = (TextView) itemView.findViewById(R.id.year);
        mTimelineView = (TimelineView) itemView.findViewById(R.id.time_marker);
        mTimelineView.initLine(viewType);
    }

}