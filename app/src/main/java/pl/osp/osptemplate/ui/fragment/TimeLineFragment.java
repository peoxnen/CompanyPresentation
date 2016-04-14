package pl.osp.osptemplate.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import pl.osp.osptemplate.R;
import pl.osp.osptemplate.data.adapter.TimeLineAdapter;
import pl.osp.osptemplate.data.model.TimeLineModel;

/**
 * Created by WSienski on 06/04/2016.
 */
public class TimeLineFragment extends Fragment {

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private TimeLineAdapter mTimeLineAdapter;
    private List<TimeLineModel> mDataList = new ArrayList<>();

    public static TimeLineFragment newInstance() {
        return new TimeLineFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_timeline, container, false);
        ButterKnife.bind(this, v);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        initView();

        return v;
    }

    private void initView() {

        addEvents(2015, R.array.events_2015);
        addEvents(2014, R.array.events_2014);
        addEvents(2013, R.array.events_2013);
        addEvents(2012, R.array.events_2012);
        addEvents(2009, R.array.events_2009);
        addEvents(2006, R.array.events_2006);
        addEvents(2005, R.array.events_2005);
        addEvents(2003, R.array.events_2003);

        mTimeLineAdapter = new TimeLineAdapter(mDataList);
        mRecyclerView.setAdapter(mTimeLineAdapter);
    }

    private void addEvents(int year, int array) {
        try {
            String[] ev = getResources().getStringArray(array);
            ArrayList<String> events = new ArrayList<String>(Arrays.asList(ev));

            TimeLineModel model = new TimeLineModel();
            model.setEvents(events);
            model.setYear(year);
            mDataList.add(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}