package com.example.helpdesk


import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.helpdesk.databinding.FragmentRepairBinding
import com.example.helpdesk.databinding.FragmentStartMainBinding
import kotlinx.android.synthetic.main.fragment_repair.*
import timber.log.Timber
import java.util.*



/**
 * A simple [Fragment] subclass.
 */
class Repair : Fragment() {

    var Requester = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentRepairBinding>(inflater,
            R.layout.fragment_repair,container,false)
        binding.btnReport.setOnClickListener { view->
            view.findNavController().navigate(RepairDirections.actionRepairToReport3())
        }
        val args = RepairArgs.fromBundle(arguments!!)
        Requester = args.StringRequester
        Toast.makeText(context, "StringRequester: ${args.StringRequester}, StringTitle: ${args.StringTitle},StringDesciption: ${args.StringDesciption}", Toast.LENGTH_LONG).show()

        text.setText("hfjg")
        return binding.root
    }




}
