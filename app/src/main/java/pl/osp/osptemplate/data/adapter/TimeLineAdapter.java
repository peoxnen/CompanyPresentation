package pl.osp.osptemplate.data.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


import com.vipul.hp_hp.timelineview.TimelineView;

import java.util.ArrayList;
import java.util.List;

import pl.osp.osptemplate.R;
import pl.osp.osptemplate.data.model.TimeLineModel;
import pl.osp.osptemplate.ui.widgets.TimeLineViewHolder;

/**
 * Created by HP-HP on 05-12-2015.
 */
public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineViewHolder> {

    private List<TimeLineModel> mFeedList;

    public TimeLineAdapter(List<TimeLineModel> feedList) {
        mFeedList = feedList;
    }

    @Override
    public int getItemViewType(int position) {
        return TimelineView.getTimeLineViewType(position, getItemCount());
    }

    @Override
    public TimeLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_timeline, null);
        return new TimeLineViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(TimeLineViewHolder holder, int position) {

        TimeLineModel timeLineModel = mFeedList.get(position);

        String finalText = "";
        ArrayList array = timeLineModel.getEvents();
        for (int i = 0; i < array.size(); i++) {
            finalText = finalText + array.get(i);
            if (i < array.size() - 1) {
                finalText = finalText + "\n\n";
            }
        }
        holder.name.setText(finalText);
        holder.year.setText(String.valueOf(timeLineModel.getYear()));

    }

    @Override
    public int getItemCount() {
        return (mFeedList != null ? mFeedList.size() : 0);
    }

}
