
package com.heyjeri.assistant

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.speech.tts.TextToSpeech
import java.util.Locale

class MainActivity : Activity(), TextToSpeech.OnInitListener {
    private lateinit var speech: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        speech = TextToSpeech(this, this)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER
        layout.setPadding(24, 32, 24, 24)
        layout.setBackgroundColor(Color.rgb(245, 248, 246))

        val title = TextView(this)
        title.text = "HeyJeri AI"
        title.textSize = 30f
        title.setTextColor(Color.rgb(20, 90, 65))
        title.gravity = Gravity.CENTER

        val message = TextView(this)
        message.text = "Assalamu Alaikum! Ami HeyJeri AI. Tomar assistant."
        message.textSize = 18f
        message.setPadding(0, 30, 0, 30)
        message.gravity = Gravity.CENTER

        val input = EditText(this)
        input.hint = "এখানে লিখো..."
        input.textSize = 18f

        val button = Button(this)
        button.text = "আমাকে বলো"

        button.setOnClickListener {
            val question = input.text.toString().trim()
            if (question.isNotEmpty()) {
                message.text = "তুমি বলেছ: $question"
                speech.speak(
                    question,
                    TextToSpeech.QUEUE_FLUSH,
                    null,
                    "heyjeri"
                )
            }
        }

        layout.addView(title)
        layout.addView(message)
        layout.addView(input)
        layout.addView(button)

        setContentView(layout)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            speech.language = Locale("bn", "BD")
        }
    }

    override fun onDestroy() {
        if (::speech.isInitialized) {
            speech.stop()
            speech.shutdown()
        }
        super.onDestroy()
    }
}
