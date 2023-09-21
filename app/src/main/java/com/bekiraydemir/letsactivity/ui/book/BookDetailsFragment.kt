package com.bekiraydemir.letsactivity.ui.book

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bekiraydemir.letsactivity.databinding.FragmentBookdetailsBinding
import com.bumptech.glide.Glide

class BookDetailsFragment: Fragment() {
    private lateinit var binding : FragmentBookdetailsBinding

    private val args by navArgs<BookDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        backButton()
        binding = FragmentBookdetailsBinding.inflate(inflater,container,false)
        val view = binding.root
          //fonskiyon cagirilir
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            bookname.text = args.bookItem.bookname
            author.text = args.bookItem.author


            Glide.with(requireContext())
                .load(args.bookItem.image)
                .into(detailImage3)
        }


        //name = args.item
        // age=args.

        //binding.tvName.text = name
        // binding.tvAge.text=age.toString()
    }

    fun backButton(){
        binding.buttonBook.setOnClickListener{ // geri tusu fonksiyonu
            findNavController().popBackStack()
        }

    }

}
