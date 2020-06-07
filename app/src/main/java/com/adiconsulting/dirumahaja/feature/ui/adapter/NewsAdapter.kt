package com.adiconsulting.dirumahaja.feature.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.adiconsulting.dirumahaja.R
import com.adiconsulting.dirumahaja.feature.entity.ListTopHeadlineNews
import com.facebook.shimmer.ShimmerFrameLayout
import com.adiconsulting.dirumahaja.databinding.AdapterListNewsBinding
import com.adiconsulting.dirumahaja.extn.loadImage

const val SHIMMER = 0
const val DATA = 1
class NewsRepoAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var dataList = mutableListOf<ListTopHeadlineNews?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if(SHIMMER == viewType){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.shimmer_item,null)
            return ShimmerViewHolder(
                view
            )
        } else {
            val dataItemBinding: AdapterListNewsBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.adapter_list_news,
                parent, false
            )
            return DataViewHolder(
                dataItemBinding
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(dataList[position] == null) SHIMMER else DATA
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is DataViewHolder){
            holder.bind(dataList[position])
        }else  if(holder is ShimmerViewHolder){
            holder.bind()
        }
    }

    override fun getItemCount(): Int = dataList.count()

    fun updateList(list: List<ListTopHeadlineNews?>) {
        dataList.clear()
        dataList.addAll(list)
        notifyDataSetChanged()
    }
}

class ShimmerViewHolder(private var view: View) : RecyclerView.ViewHolder(view) {
    fun bind(){
        (view as ShimmerFrameLayout).startShimmerAnimation()
    }
}

class DataViewHolder(private var binding: AdapterListNewsBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(dataItem: ListTopHeadlineNews?) {
        binding.trendingRepo =
            NewsVM(
                dataItem,
                binding.root.resources
            )
        binding.newImageView.loadImage(dataItem?.urlToImage?:"")
    }
}