package com.example.helpdesk


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.helpdesk.databinding.FragmentReportBinding
import com.example.helpdesk.databinding.FragmentStartMainBinding
import kotlinx.android.synthetic.main.fragment_report.*

/**
 * A simple [Fragment] subclass.
 */
class report : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentReportBinding>(inflater,
            R.layout.fragment_report,container,false)
        binding.btnReport1.setOnClickListener { view->
            view.findNavController().navigate(reportDirections.actionReport3ToRepair(txt_requester.toString(),txt_title.toString(),txt_desciption.toString()))
        }


        return binding.root
    }



}
