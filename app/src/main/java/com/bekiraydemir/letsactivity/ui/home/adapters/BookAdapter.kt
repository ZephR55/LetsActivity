package com.bekiraydemir.letsactivity.ui.home.adapters
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bekiraydemir.letsactivity.databinding.Recycler3Binding
import com.bekiraydemir.letsactivity.model.Books

class BookAdapter (
    val bookList: ArrayList<Books>,
    private val OnclickBooks: (position: Int) -> Unit
): RecyclerView.Adapter<BookHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        val binding = Recycler3Binding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BookHolder(binding)
    }

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        holder.binding.book.setImageResource(bookList[position].image)
        holder.binding.bookName.text= bookList[position].bookname
        holder.binding.bookLayout.setOnClickListener {
          OnclickBooks(position)
            // Log.e("TAG", position.toString())
        }



    }

    override fun getItemCount(): Int {
        return bookList.size

    }

}

class BookHolder(val binding: Recycler3Binding) : RecyclerView.ViewHolder(binding.root){


}