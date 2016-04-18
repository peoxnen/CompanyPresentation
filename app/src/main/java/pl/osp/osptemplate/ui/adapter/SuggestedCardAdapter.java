package pl.osp.osptemplate.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.base.CardViewWrapper;

/**
 * Created by WSienski on 06/04/2016.
 */
public class SuggestedCardAdapter extends CardArrayAdapter {

    /**
     * Constructor
     *
     * @param context The current context.
     * @param cards   The cards to represent in the ListView.
     */
    public SuggestedCardAdapter(Context context, List<Card> cards) {
        super(context, cards);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        CardViewWrapper mCardView;
        Card mCard;

        mCard = (Card) getItem(position);

        mCard.setTitle("lol");

        return view;
    }

    @Override
    public int getItemViewType(int position) {
        if (position >= 0 && position < getCount()) {
            return super.getItemViewType(position);
        } else {
            return position;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }
}