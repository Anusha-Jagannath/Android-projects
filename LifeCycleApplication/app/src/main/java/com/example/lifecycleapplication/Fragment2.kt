package com.example.lifecycleapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.lifecycleapplication.databinding.ActivityMainBinding.bind
import com.example.lifecycleapplication.databinding.Fragment2Binding

class Fragment2 : Fragment(R.layout.fragment2) {


    private var binding: Fragment2Binding? = null
    val types = arrayOf("simple User", "Admin")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//
//      var option = binding?.spinnerQuantity
//      var result = binding?.displayText

//        val options = arrayOf("distance","weight","temperature","volume")
//        option?.adapter =
//            context?.let { ArrayAdapter<String>(it,android.R.layout.simple_list_item_1,options) }

//        option?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//                result?.text = options.get(p2)
//            }
//
//            override fun onNothingSelected(p0: AdapterView<*>?) {
//                result?.text = "Please select an option"
//            }
//
//        }
//
//
//       return super.onCreateView(inflater, container, savedInstanceState)



        val t=inflater.inflate(R.layout.fragment2, container, false)
        val spinner = t.findViewById<Spinner>(R.id.spinnerQuantity)
        spinner?.adapter = activity?.applicationContext?.let { ArrayAdapter(it, R.layout.support_simple_spinner_dropdown_item, types) } as SpinnerAdapter
        spinner?.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                println("erreur")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val type = parent?.getItemAtPosition(position).toString()
                Toast.makeText(activity,type, Toast.LENGTH_LONG).show()
                println(type)
            }

        }
        return t
    }

}

