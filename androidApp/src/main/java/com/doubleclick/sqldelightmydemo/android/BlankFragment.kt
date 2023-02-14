package com.doubleclick.sqldelightmydemo.android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.doubleclick.sqldelightmydemo.database.JobQueries
import com.doubleclick.sqldelightmydemo.database.NameQueries
import com.squareup.sqldelight.runtime.coroutines.asFlow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var name: NameQueries
    private lateinit var job: JobQueries
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.text).setOnClickListener {
            startActivity(Intent(requireActivity(), MainActivity2::class.java))
        }
        name = MyDB(requireContext().createDriver()).nameQueries
        job = MyDB(requireContext().createDriver()).jobQueries

        viewLifecycleOwner.lifecycleScope.launch {
//            https://developer.android.com/topic/libraries/architecture/coroutines
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                flow {
                    emit(job.getbyId(5).asFlow())
                }.buffer().collect {
                    Log.e("getAllData", "onCreate: ${it.first().executeAsOne()}")
                }
//            val row = job.getAllData().executeAsList()
//            row.groupBy { it.id }.map { (name, jop) ->
//                Log.e(TAG, "onCreate: $name ${jop.toString()}")
//            }

                /* flow<Flow<Query<Name>>> {
                 emit(
                     name.getAllData().asFlow()
                 )
             }.buffer().collect {
             }*/
            }
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}