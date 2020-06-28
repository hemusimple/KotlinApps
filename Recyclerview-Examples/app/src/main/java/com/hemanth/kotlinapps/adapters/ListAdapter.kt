package com.innoviti.kotlinapps.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.innoviti.kotlinapps.R
import com.innoviti.kotlinapps.databinding.ItemRowBinding

class ListAdapter(context: Context) : RecyclerView.Adapter<ListAdapter.ListAdapterViewHolder>(){

    private   var c: Context=context;
    private lateinit var items:List<String>;

    public  fun setData(ii:List<String>){
        items = ii
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapterViewHolder {
       val itemRow :ItemRowBinding =DataBindingUtil.inflate(LayoutInflater.from(c),R.layout.item_row,parent,false);
       return  ListAdapterViewHolder(itemRow);
    }

    override fun getItemCount(): Int {
       return  items.size
    }

    override fun onBindViewHolder(holder: ListAdapterViewHolder, position: Int) {
             holder.names!!.text=items[position]
             holder.names!!.setOnClickListener(object :View.OnClickListener{
                 override fun onClick(v: View?) {
                    Toast.makeText(c,items[holder.adapterPosition],Toast.LENGTH_LONG).show()
                 }
             })
    }

    class  ListAdapterViewHolder(itemRowBinding: ItemRowBinding) :RecyclerView.ViewHolder( itemRowBinding.root ){
          var  names:TextView?=null;
        init {
           names = itemRowBinding.test;
        }
    }
}