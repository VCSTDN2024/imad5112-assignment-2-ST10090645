/*Reference List for .kt file:
https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7BA1FF62F0-8E1A-47BC-99BD-CA07AE24427D%7D&file=IMAD5112_MM.docx&action=default&mobileredirect=true
https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7B44999D8E-32B6-4613-B393-F77FCC911175%7D&file=IPRG5111MM.docx&action=default&mobileredirect=true
https://www.geeksforgeeks.org/how-to-send-data-from-one-activity-to-second-activity-in-android/
*/

package com.example.imad5112_assignment2_flashcardapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val startBtn = findViewById<Button>(R.id.btnStartQuiz) // Button to start the quiz

        startBtn.setOnClickListener { // Starting the quiz by sending user to another screen
            val intent = Intent(this, Quiz::class.java)
            startActivity(intent)
        }
    }
}