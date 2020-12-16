package martinamagdalenajukic.ferit.hr.myapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.NameViewHolder> {

    private List<String> dataList;
    private NameClickListener nameClickListener;

    public CustomAdapter(List<String> dataList, NameClickListener listener) {
        this.dataList = dataList;
        nameClickListener=listener;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new NameViewHolder(listItemView, nameClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        Log.d("onBindViewHolder", "Element "+ position + "set.");
        holder.setName(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class NameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView textView;
        private NameClickListener nameClickListener;

        public NameViewHolder(@NonNull View itemView, NameClickListener listener) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            nameClickListener=listener;
            itemView.setOnClickListener(this);
        }

        public void setName(String name){
            textView.setText(name);
        }

        @Override
        public void onClick(View v) {
            nameClickListener.onNameClick(getAdapterPosition());
        }
    }
}
