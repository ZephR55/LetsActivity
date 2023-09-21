package com.bekiraydemir.letsactivity.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bekiraydemir.letsactivity.R
import com.bekiraydemir.letsactivity.databinding.FragmentDetailsBinding
import com.bumptech.glide.Glide


class DetailsFragment : Fragment() {
private lateinit var binding : FragmentDetailsBinding

private val args by navArgs<DetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentDetailsBinding.inflate(inflater,container,false)
        val view = binding.root
        backButton()
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            moviename.text = args.item.moviename
            releasedate.text = args.item.releasedate


           Glide.with(requireContext())
               .load(args.item.image)
               .into(detailImage)
        }


    }

    fun backButton (){
        binding.buttonMovie.setOnClickListener{ // geri tusu fonksiyonu
            findNavController().popBackStack()
        }

    }

}

