package com.twilio.contextualcommunicationsdemo.ViewHolder;

import android.view.View;
import android.widget.TextView;

import com.twilio.contextualcommunicationsdemo.DTO.Entry;
import com.twilio.contextualcommunicationsdemo.R;

import uk.co.ribot.easyadapter.ItemViewHolder;
import uk.co.ribot.easyadapter.PositionInfo;
import uk.co.ribot.easyadapter.annotations.LayoutId;
import uk.co.ribot.easyadapter.annotations.ViewId;

/**
 * Created by mplacona on 08/02/2016.
 */
//Annotate the class with the layout ID of the item.
@LayoutId(R.layout.entry_item)
public class EntryViewHolder extends ItemViewHolder<Entry> {

    //Annotate every field with the ID of the view in the layout.
    //The views will automatically be assigned to the fields.

    @ViewId(R.id.text_view_label)
    TextView textViewLabel;

    @ViewId(R.id.text_view_value)
    TextView textViewValue;

    //Extend ItemViewHolder and call super(view)
    public EntryViewHolder(View view) {
        super(view);
    }

    //Override onSetValues() to set the values of the items in the views.
    @Override
    public void onSetValues(Entry entry, PositionInfo positionInfo) {
        textViewLabel.setText(entry.getLabel());
        textViewValue.setText(entry.getValue());
    }
}