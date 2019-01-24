/* Copyright 2017 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
==============================================================================*/

package isitweather.poordogsbone.com.isitweather.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.TextureView
import android.view.View

class CameraTextureView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : TextureView(context, attrs, defStyle){

    private var mWidthRatio = 0
    private var mHeightRatio = 0

    fun setAspectRatio(width: Int, height: Int){
        if(width < 0 || height < 0){
            return
        }
        mHeightRatio = height
        mWidthRatio = width
        requestLayout()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = View.MeasureSpec.getSize(widthMeasureSpec)
        val height = View.MeasureSpec.getSize(heightMeasureSpec)
        if (0 == mWidthRatio || 0 == mHeightRatio) {
            setMeasuredDimension(width, height)
        } else {
            if (width < height * mWidthRatio / mHeightRatio) {
                setMeasuredDimension(width, width * mHeightRatio / mWidthRatio)
            } else {
                setMeasuredDimension(height * mWidthRatio / mHeightRatio, height)
            }
        }
    }
}