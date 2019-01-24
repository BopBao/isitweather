package isitweather.poordogsbone.com.isitweather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import isitweather.poordogsbone.com.isitweather.fragments.AnalysisScreen
import isitweather.poordogsbone.com.isitweather.fragments.Camera2BasicFragment
import isitweather.poordogsbone.com.isitweather.fragments.StartScreen

class MainActivity : AppCompatActivity() {
    lateinit var analysisText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.inTransaction {
            add(R.id.container, Camera2BasicFragment.newInstance())
        }
    }

    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
        val fragmentTransaction = beginTransaction()
        fragmentTransaction.func()
        fragmentTransaction.commit()
    }

    fun changeToCameraFragment(){
        supportFragmentManager.inTransaction {
            replace(R.id.container, Camera2BasicFragment.newInstance())
        }
    }

    fun changeToAnalysisFragment(){
        supportFragmentManager.inTransaction {
            replace(R.id.container, AnalysisScreen.newInstance());
        }
    }

    fun receiveAnalysis(text: String){
        analysisText = text
    }

    fun displayAnalysis(): String{
        return analysisText
    }
}
