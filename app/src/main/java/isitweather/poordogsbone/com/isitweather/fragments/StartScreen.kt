package isitweather.poordogsbone.com.isitweather.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import isitweather.poordogsbone.com.isitweather.MainActivity
import isitweather.poordogsbone.com.isitweather.R

class StartScreen : Fragment() {

    companion object {
        fun newInstance(): StartScreen {
            return StartScreen()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.start_screen, container, false)

        val text = view.findViewById(R.id.start_text) as TextView

        text.setOnClickListener {
            if (context is MainActivity) {
                (context as MainActivity).changeToCameraFragment()
            }
        }
        return view
    }

    override fun onResume() {
        super.onResume()
        val hasCamera = checkPermissions()
        if(hasCamera){
            Log.d("IsItWeather", "has camera permission on start screen")
        }else{
            getPermission()
        }
    }

    fun checkPermissions(): Boolean{
        context?.let { c ->
            return ContextCompat.checkSelfPermission(c, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
        }
    }

    fun getPermission(){
        activity?.let { act ->
            ActivityCompat.requestPermissions(act, arrayOf(Manifest.permission.CAMERA), 0)
        }
    }
}