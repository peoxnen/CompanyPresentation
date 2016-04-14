package wsienski.iview.mycustomapp.ui.cards;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import wsienski.iview.mycustomapp.R;

/**
 * @author Gabriele Mariotti (gabri.mariotti@gmail.com)
 */
public class SuggestedCard extends Card {

    @Bind(R.id.carddemo_suggested_title)
    TextView title;
    @Bind(R.id.carddemo_suggested_memeber)
    TextView member;
    SuggestedCardDataModel suggestedCardDataModel;

    public SuggestedCard(Context context, SuggestedCardDataModel suggestedCardDataModel) {
        this(context, R.layout.carddemo_suggested_inner_content, suggestedCardDataModel);
    }

    public SuggestedCard(Context context, int innerLayout, SuggestedCardDataModel suggestedCardDataModel) {
        super(context, innerLayout);
        this.suggestedCardDataModel = suggestedCardDataModel;
        init();
    }

    private void init() {

        //Add a header
        SuggestedCardHeader header = new SuggestedCardHeader(getContext(), suggestedCardDataModel);
        addCardHeader(header);

        //Set click listener
        OnCardClickListener onCardClickListener = suggestedCardDataModel.getOnCardClickListener();
        if (onCardClickListener != null)
            this.setOnClickListener(suggestedCardDataModel.getOnCardClickListener());

        //Add thumbnail
        CardThumbnail thumb = new SuggestedCardThumb(getContext());
        //thumb.setUrlResource("https://lh5.googleusercontent.com/-N8bz9q4Kz0I/AAAAAAAAAAI/AAAAAAAAAAs/Icl2bQMyK7c/s265-c-k-no/photo.jpg");
        //thumb.setErrorResource(R.drawable.btn_negative);
        thumb.setDrawableResource(suggestedCardDataModel.getImageResId());
        addCardThumbnail(thumb);
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {

        if (view != null) {
            ButterKnife.bind(this, view);

            if (title != null)
                title.setText(suggestedCardDataModel.getContentTitle());

            if (member != null)
                member.setText(suggestedCardDataModel.getContentDesc());
        }
    }


}

class SuggestedCardHeader extends CardHeader {

    SuggestedCardDataModel suggestedCardDataModel;

    public SuggestedCardHeader(Context context, SuggestedCardDataModel suggestedCardDataModel) {
        this(context, R.layout.carddemo_suggested_header_inner, suggestedCardDataModel);
    }

    public SuggestedCardHeader(Context context, int innerLayout, SuggestedCardDataModel suggestedCardDataModel) {
        super(context, innerLayout);
        this.suggestedCardDataModel = suggestedCardDataModel;
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {

        if (view != null) {
            TextView textView = (TextView) view.findViewById(R.id.text_suggested_card1);

            if (textView != null) {
                textView.setText(suggestedCardDataModel.getHeader());
            }
        }
    }
}

class SuggestedCardThumb extends CardThumbnail {

    public SuggestedCardThumb(Context context) {
        super(context);
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View viewImage) {
        if (viewImage != null) {

            if (parent != null && parent.getResources() != null) {
                DisplayMetrics metrics = parent.getResources().getDisplayMetrics();

                int base = 100;

                if (metrics != null) {
                    viewImage.getLayoutParams().width = (int) (base * metrics.density);
                    viewImage.getLayoutParams().height = (int) (base * metrics.density);
                } else {
                    viewImage.getLayoutParams().width = 200;
                    viewImage.getLayoutParams().height = 200;
                }
            }
        }
    }
}
