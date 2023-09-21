package com.bekiraydemir.letsactivity.ui.home.adapters
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bekiraydemir.letsactivity.model.Musics
import com.bekiraydemir.letsactivity.databinding.Recycler2Binding

class MusicAdapter (
    private val musicList: ArrayList<Musics>,
    private val onClickMusics:(position:Int) -> Unit):
    RecyclerView.Adapter<MusicHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicHolder {
        val binding = Recycler2Binding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MusicHolder(binding)
    }

    override fun onBindViewHolder(holder: MusicHolder, position: Int) {
        holder.binding.music.setImageResource(musicList[position].image)
        holder.binding.musicName.text= musicList[position].musicname
        holder.binding.musicLayout.setOnClickListener {
            onClickMusics(position)
            // Log.e("TAG", position.toString())
        }

    }


    override fun getItemCount(): Int {
        return musicList.size

    }


}

class MusicHolder(val binding: Recycler2Binding) : RecyclerView.ViewHolder(binding.root){


}