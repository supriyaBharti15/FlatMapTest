package com.example.flatmaptest.views.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flatmaptest.BR;
import com.example.flatmaptest.R;
import com.example.flatmaptest.databinding.DataItemBinding;
import com.example.flatmaptest.listeners.OnItemClickListener;
import com.example.flatmaptest.model.Data;
import com.example.flatmaptest.model.MasterDataModel;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.MyViewHolderClass> implements OnItemClickListener {
    private MasterDataModel masterDataModel;
    private Context context;

    public MainActivityAdapter(MasterDataModel masterDataModel, Context context) {
        this.masterDataModel = masterDataModel;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DataItemBinding dataItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.data_item,parent,false);
        return new MyViewHolderClass(dataItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderClass holder, int position) {
        Data data = masterDataModel.getAllUserResponse().getData().get(position);
        holder.dataItemBinding.setAllUserData(data);
        holder.dataItemBinding.setOnItemClicked(this);
    }

    @Override
    public int getItemCount() {
        return masterDataModel.getAllUserResponse().getData().size();
    }

    @Override
    public void onItemClicked(Data data) {
        Toast.makeText(context,data.getFirstName(),Toast.LENGTH_LONG).show();
    }


    public class MyViewHolderClass extends RecyclerView.ViewHolder {
        DataItemBinding dataItemBinding;

        public MyViewHolderClass(@NonNull DataItemBinding binding) {
            super(binding.getRoot());
            this.dataItemBinding = binding;
        }
        public void bind(Object obj){
            dataItemBinding.setVariable(com.example.flatmaptest.BR.allUserData,obj);
            dataItemBinding.executePendingBindings();
        }
    }
}
