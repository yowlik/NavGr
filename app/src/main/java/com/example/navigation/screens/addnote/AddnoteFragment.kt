package com.example.navigation.screens.addnote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.navigation.APP
import com.example.navigation.R
import com.example.navigation.databinding.FragmentAddnoteBinding
import com.example.navigation.model.NoteModel


class AddnoteFragment : Fragment() {

    lateinit var binding: FragmentAddnoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAddnoteBinding.inflate(layoutInflater,container,false)
        return binding.root
        // Inflate the layout for this fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel=ViewModelProvider(this).get(AddNoteViewModel::class.java)
        binding.btnAddNote.setOnClickListener{
            val title=binding.etAddTitle.text.toString()
            val desc=binding.etAddDesc.text.toString()
            viewModel.insert(NoteModel(title = title, decription = desc)){}
            APP.navController.navigate((R.id.action_addnoteFragment_to_startFragment))
        }
        binding.btnBack.setOnClickListener{
            APP.navController.navigate(R.id.action_addnoteFragment_to_startFragment)
        }
    }


}