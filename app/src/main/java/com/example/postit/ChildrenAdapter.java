package com.example.postit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.postit.databinding.ItemRequestBinding;

import java.util.ArrayList;

public class ChildrenAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<String> data = new ArrayList<>();

    // 리스너 객체 참조를 저장하는 변수
    private OnButtonClickListener listener = null;

    public interface OnButtonClickListener {
        void onItemClick(View view, String id);
    }
    public void setOnButtonClickListener(OnButtonClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RequestViewHolder(ItemRequestBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RequestViewHolder rvh = (RequestViewHolder) (holder);
        rvh.bind(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    void addData(ArrayList<String> data){
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    class RequestViewHolder extends RecyclerView.ViewHolder{
        ItemRequestBinding binding;

        public RequestViewHolder(@NonNull ItemRequestBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.acceptButton.setOnClickListener((v)->{
                if(listener!=null){
                    listener.onItemClick(v,data.get(getAdapterPosition()));
                }
            });
        }

        void bind(String id){
            binding.idTextView.setText(id);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }



}