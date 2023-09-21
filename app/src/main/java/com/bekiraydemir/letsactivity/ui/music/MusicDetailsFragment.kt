package com.bekiraydemir.letsactivity.ui.music

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bekiraydemir.letsactivity.R
import com.bekiraydemir.letsactivity.databinding.FragmentDetailsBinding
import com.bekiraydemir.letsactivity.databinding.FragmentMusicdetailsBinding
import com.bekiraydemir.letsactivity.ui.movie.DetailsFragmentArgs
import com.bumptech.glide.Glide

class MusicDetailsFragment: Fragment() {
    private lateinit var binding : FragmentMusicdetailsBinding

    private val args by navArgs<MusicDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMusicdetailsBinding.inflate(inflater,container,false)
        val view = binding.root
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            musicName.text = args.musicItem.musicname
            singer.text = args.musicItem.singer


            Glide.with(requireContext())
                .load(args.musicItem.image)
                .into(detailImage2)
        }


        //name = args.item
        // age=args.

        //binding.tvName.text = name
        // binding.tvAge.text=age.toString()
    }
/*
    fun backButton(){
        binding.buttonMusic.setOnClickListener{ // geri tusu fonksiyonu
            findNavController().popBackStack()
        }

    }
*/



}
