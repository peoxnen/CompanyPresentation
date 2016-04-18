package pl.osp.osptemplate.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;
import pl.osp.osptemplate.OspApp;
import pl.osp.osptemplate.R;
import pl.osp.osptemplate.data.model.Service;
import pl.osp.osptemplate.data.model.Services;
import pl.osp.osptemplate.di.component.ActivityComponent;
import pl.osp.osptemplate.di.component.DaggerActivityComponent;
import pl.osp.osptemplate.ui.activity.MainActivity;
import pl.osp.osptemplate.ui.model.SuggestedCardDataModel;
import pl.osp.osptemplate.ui.presentes.ServicesPresenter;
import pl.osp.osptemplate.ui.screen_contract.ServicesView;
import pl.osp.osptemplate.ui.widgets.SuggestedCard;

/**
 * Created by WSienski on 25/03/2016.
 */
public class ServicesFragment extends Fragment implements ServicesView {

    @Bind(R.id.carddemo_list_gplaycard)
    CardListView cardListView;

    @Inject
    ServicesPresenter servicesPresenter;

    private ActivityComponent mComponent;

    public static ServicesFragment newInstance() {
        return new ServicesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_services, container, false);
        ButterKnife.bind(this, v);

        mComponent = DaggerActivityComponent.builder().appComponent(getApp().getAppComponent()).build();
        mComponent.inject(this);

        return v;
    }

    Card.OnCardClickListener getOnClickListener(final Fragment fragment) {
        Card.OnCardClickListener onCardClickListener = (card, view) -> ((MainActivity) getActivity()).setContent(fragment);
        return onCardClickListener;
    }

    @Override
    public void onStart() {
        super.onStart();
        servicesPresenter.attachView(this);
        servicesPresenter.getServices();
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        servicesPresenter.detachView();
        super.onDestroyView();
    }

    @Override
    public void loadServices(Services services) {
//        SuggestedCardDataModel suggestedCardDataModel = new SuggestedCardDataModel(getString(R.string.services_card_cc_title),
//                getString(R.string.services_card_cc_desc), "", R.drawable.callcenterworker, getOnClickListener(new ServicesFragment()));
//        SuggestedCardDataModel suggestedCardDataModel2 = new SuggestedCardDataModel(getString(R.string.services_card_systems_title),
//                getString(R.string.services_card_systems_desc), "", R.drawable.callcenterworker, null);
//        SuggestedCardDataModel suggestedCardDataModel3 = new SuggestedCardDataModel(getString(R.string.services_card_bigdata_title),
//                getString(R.string.services_card_bigdata_desc), "", R.drawable.callcenterworker, null);

        ArrayList<Card> cards = new ArrayList<Card>();
        for (Service service : services.getServices()) {
            SuggestedCardDataModel suggestedCardDataModel = new SuggestedCardDataModel(service.getTitle(),
                    service.getDesc(), "", R.drawable.callcenterworker, getOnClickListener(new ServicesFragment()));
            SuggestedCard card = new SuggestedCard(getActivity(), suggestedCardDataModel);
            cards.add(card);
        }
        CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(getActivity(), cards);

        if (cardListView != null) {
            cardListView.setAdapter(mCardArrayAdapter);
        }
    }

    public OspApp getApp() {
        return ((OspApp) getActivity().getApplication());
    }
}
