/**
 * Created by A.Srimanth on 26-Mar-18.
 */

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.asrimanth.collegeapp.CollegeDbMetadata;
import com.example.asrimanth.collegeapp.R;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    // COMPLETED (1) Replace the mCount with a new Cursor field called mCursor
    // Holds on to the cursor to display the waitlist
    private Cursor sCursor,cCursor;
    private Context mContext;

    // COMPLETED (2) Modify the constructor to accept a cursor rather than an integer
    /**
     * Constructor using the context and the db cursor
     * @param context the calling context/activity
     * @param sCursor,cCursor the db cursor with waitlist data to display
     */
    public MainAdapter(Context context, Cursor sCursor, Cursor cCursor) {
        this.mContext = context;
        // COMPLETED (3) Set the local mCursor to be equal to cursor
        this.sCursor = sCursor;
        this.cCursor = cCursor;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Get the RecyclerView item layout
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.main_row_layout, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {

        // Move the sCursor to the position of the item to be displayed
        if (!sCursor.moveToPosition(position))
            return; // bail if returned null

        String sName = sCursor.getString(sCursor.getColumnIndex(CollegeDbMetadata.Enrolled.COLUMN_STUDENT_FIRST_NAME));

        String cName = cCursor.getString(cCursor.getColumnIndex(CollegeDbMetadata.Enrolled.COLUMN_COURSE_ID));

        holder.studentTextView.setText(sName);

        holder.courseTextView.setText(cName);
    }

    @Override
    public int getItemCount() {
        // COMPLETED (4) Update the getItemCount to return the getCount of the cursor
        return sCursor.getCount();
    }

    /**
     * Inner class to hold the views needed to display a single item in the recycler-view
     */
    class MainViewHolder extends RecyclerView.ViewHolder {

        // Will display the guest name
        TextView studentTextView;
        // Will display the party size number
        TextView courseTextView;

        /**
         * Constructor for our ViewHolder. Within this constructor, we get a reference to our
         * TextViews
         *
         * @param itemView The View that you inflated in
         *                 {@link MainAdapter#onCreateViewHolder(ViewGroup, int)}
         */
        public MainViewHolder(View itemView) {
            super(itemView);
            studentTextView = (TextView) itemView.findViewById(R.id.studentText);
            courseTextView = (TextView) itemView.findViewById(R.id.courseText);
        }

    }
}
