package wsienski.iview.mycustomapp.ui.cards;

import android.widget.TextView;

import it.gmariotti.cardslib.library.internal.Card;
import wsienski.iview.mycustomapp.R;

/**
 * Created by WSienski on 06/04/2016.
 */
public class SuggestedCardDataModel {

    private String header;
    private String contentTitle;
    private String contentDesc;
    private int imageResId;
    private Card.OnCardClickListener onCardClickListener;

    public SuggestedCardDataModel(String header, String title, String desc, int imageResId, Card.OnCardClickListener onCardClickListener) {
        this.header = header;
        this.contentTitle = title;
        this.contentDesc = desc;
        this.imageResId = imageResId;
        this.onCardClickListener = onCardClickListener;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContentDesc() {
        return contentDesc;
    }

    public void setContentDesc(String contentDesc) {
        this.contentDesc = contentDesc;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public Card.OnCardClickListener getOnCardClickListener() {
        return onCardClickListener;
    }

    public void setOnCardClickListener(Card.OnCardClickListener onCardClickListener) {
        this.onCardClickListener = onCardClickListener;
    }
}
