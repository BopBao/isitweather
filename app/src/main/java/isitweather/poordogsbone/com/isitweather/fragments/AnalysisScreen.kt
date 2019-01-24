package isitweather.poordogsbone.com.isitweather.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import isitweather.poordogsbone.com.isitweather.MainActivity
import isitweather.poordogsbone.com.isitweather.R

class AnalysisScreen: Fragment() {
    lateinit var analysis: String

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is MainActivity){
            analysis = context.displayAnalysis()
        }
    }

    companion object {
        fun newInstance(): AnalysisScreen {
            return AnalysisScreen()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.analysis_fragment, container)

        val textView = view.findViewById(R.id.result_text) as TextView
        textView.text = analysis

        return view
    }
}
