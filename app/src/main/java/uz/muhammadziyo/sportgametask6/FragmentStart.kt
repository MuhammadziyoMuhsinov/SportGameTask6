package uz.muhammadziyo.sportgametask6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import uz.muhammadziyo.sportgametask6.databinding.FragmentStartBinding
import uz.muhammadziyo.sportgametask6.models.Mydata


class FragmentStart : Fragment() {

    private lateinit var binding: FragmentStartBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater)

        binding.start.setOnClickListener {
            val name = binding.edtName.text.toString()
            if (name.isNotEmpty()){
                Mydata.name = name
                findNavController().navigate(R.id.fragmentMenu)
            }else{
                Toast.makeText(binding.root.context, "Empty!", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }


}