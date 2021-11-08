package com.example.navigation

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation.databinding.FragmentVocabMeaningBinding


class VocabMeaningFragment : Fragment() {
    private var _binding: FragmentVocabMeaningBinding? = null
    private val binding get() = _binding!!
    lateinit var recyclerView: RecyclerView
    private lateinit var wordId: String
    private lateinit var wordImageResource: String
    private lateinit var wordSoundResource: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentVocabMeaningBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let {
            wordId = it.getString(WORD).toString()
            wordImageResource = it.getString(IMAGERESOURCE).toString()
            wordSoundResource = it.getString(SOUNDRESOURCE).toString()
        }
        binding.text.setText(wordId) ///////////////////////////////////////////////
        binding.vocabImage.setImageResource(wordImageResource.toInt())
        binding.vocabSound.setOnClickListener{
            val clickSound = MediaPlayer.create(context, wordSoundResource.toInt())
            clickSound.start()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    companion object {
        const val WORD = "word"
        const val  IMAGERESOURCE = "imageResource"
        const val SOUNDRESOURCE = "soundResource"
    }


}