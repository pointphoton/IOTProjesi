package tr.edu.sakarya.e195013028.proje.ui.watch;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import tr.edu.sakarya.e195013028.proje.R;
import tr.edu.sakarya.e195013028.proje.api.model.Feed;
import tr.edu.sakarya.e195013028.proje.databinding.ItemCustomBinding;
import tr.edu.sakarya.e195013028.proje.util.DebugLog;

public class WatchDataAdapter extends RecyclerView.Adapter<WatchDataAdapter.FeedHolder> {

    private ArrayList<Feed> feedList;


    @NonNull
    @Override
    public FeedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DebugLog.write();
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemCustomBinding binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.item_custom, parent, false);
        return new FeedHolder(binding);
    }


    @Override
    public int getItemCount() {
        DebugLog.write();
        return feedList != null ? feedList.size() : 0;
    }


    public void setFeedList(ArrayList<Feed> feedList) {
        this.feedList = feedList;
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(@NonNull FeedHolder holder, int position) {
        DebugLog.write();
        final Feed feed = feedList.get(position);
        holder.bind(feed);
    }

    public class FeedHolder extends RecyclerView.ViewHolder {
        private ItemCustomBinding mBinding;

        public FeedHolder(ItemCustomBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(Feed item) {
            mBinding.setFeed(item);
            mBinding.executePendingBindings();
        }
    }
}


