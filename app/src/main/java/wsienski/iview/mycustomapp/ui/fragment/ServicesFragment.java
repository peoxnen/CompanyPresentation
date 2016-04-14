package wsienski.iview.mycustomapp.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;
import wsienski.iview.mycustomapp.R;
import wsienski.iview.mycustomapp.ui.activity.MainActivity;
import wsienski.iview.mycustomapp.ui.cards.SuggestedCard;
import wsienski.iview.mycustomapp.ui.cards.SuggestedCardDataModel;

/**
 * Created by WSienski on 25/03/2016.
 */
public class ServicesFragment extends Fragment {

    @Bind(R.id.carddemo_list_gplaycard)
    CardListView cardListView;

    public static ServicesFragment newInstance() {
        return new ServicesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_services, container, false);
        ButterKnife.bind(this, v);

        SuggestedCardDataModel suggestedCardDataModel = new SuggestedCardDataModel(getString(R.string.services_card_cc_title),
                getString(R.string.services_card_cc_desc), "", R.drawable.callcenterworker, getOnClickListener(new ServicesFragment()));
        SuggestedCardDataModel suggestedCardDataModel2 = new SuggestedCardDataModel(getString(R.string.services_card_systems_title),
                getString(R.string.services_card_systems_desc), "", R.drawable.callcenterworker, null);
        SuggestedCardDataModel suggestedCardDataModel3 = new SuggestedCardDataModel(getString(R.string.services_card_bigdata_title),
                getString(R.string.services_card_bigdata_desc), "", R.drawable.callcenterworker, null);

        SuggestedCard card = new SuggestedCard(getActivity(), suggestedCardDataModel);
        SuggestedCard card2 = new SuggestedCard(getActivity(), suggestedCardDataModel2);
        SuggestedCard card3 = new SuggestedCard(getActivity(), suggestedCardDataModel3);


        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card);
        cards.add(card2);
        cards.add(card3);
        CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(getActivity(), cards);
        if (cardListView != null) {
            cardListView.setAdapter(mCardArrayAdapter);
        }

        return v;
    }

    Card.OnCardClickListener getOnClickListener(final Fragment fragment) {
        Card.OnCardClickListener onCardClickListener = new Card.OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                ((MainActivity) getActivity()).setContent(fragment);
            }
        };
        return onCardClickListener;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
