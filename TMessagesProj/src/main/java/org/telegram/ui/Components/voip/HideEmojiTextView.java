package org.telegram.ui.Components.voip;

import static com.blackbox.messenger.AndroidUtilities.dp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.view.View;
import android.widget.TextView;
import com.blackbox.messenger.R;

import com.blackbox.messenger.AndroidUtilities;
import com.blackbox.messenger.LocaleController;

@SuppressLint("ViewConstructor")
public class HideEmojiTextView extends TextView {

    private final RectF bgRect = new RectF();
    private final VoIPBackgroundProvider backgroundProvider;

    public HideEmojiTextView(Context context, VoIPBackgroundProvider backgroundProvider) {
        super(context);
        this.backgroundProvider = backgroundProvider;
        backgroundProvider.attach(this);
        setText(LocaleController.getString(R.string.VoipHideEmoji));
        setContentDescription(LocaleController.getString(R.string.VoipHideEmoji));
        setTextColor(Color.WHITE);
        setTypeface(AndroidUtilities.bold());
        setPadding(AndroidUtilities.dp(14), AndroidUtilities.dp(4), AndroidUtilities.dp(14), AndroidUtilities.dp(4));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        bgRect.set(0, 0, getWidth(), getHeight());
        backgroundProvider.setDarkTranslation(getX() + ((View) getParent()).getX(), getY() + ((View) getParent()).getY());
        canvas.drawRoundRect(bgRect, dp(16), dp(16), backgroundProvider.getDarkPaint());
        super.onDraw(canvas);
    }
}
