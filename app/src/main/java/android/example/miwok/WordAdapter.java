package android.example.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    //Resource ID for the background color of the list of words
    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.

        super(context, 0, words);
        mColorResourceId = colorResourceId;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the miwok_text_view
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the miwok translation from the current Word object and
        // set this text on the miwok TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the default text view
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the default translation from the current word object and
        // set this text on the default TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());


        //Find the ImageView in the list_item.xml layout with the ID list_item_image
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            // Get the image resource ID from the current Word object and
            // set the image to image resource specified in the current word
            imageView.setImageResource(currentWord.getImageResourceId());

            //make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            //otherwise hide the image view(set visibility as gone)
            imageView.setVisibility(View.GONE);
        }


        //set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //find the color the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        //set the background color of the text container view
        textContainer.setBackgroundColor(color);


        // Return the whole list item layout (containing 2 TextViews and an image view)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
