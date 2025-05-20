package com.example.imad5112_assignment2_flashcardapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class ReviewMode : AppCompatActivity() {

    private lateinit var revQuestions: TextView
    private lateinit var revQuestionsHeader: TextView
    private lateinit var revNextbt: Button
    private lateinit var revBackBt: Button
    private lateinit var revAnswerPrompt: TextView
    private lateinit var revScore: TextView

    private var intIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review_mode)

        revQuestions = findViewById(R.id.tvQuestionsRevMode)
        revQuestionsHeader = findViewById(R.id.tvQuestionsHeaderRevMode)
        revNextbt = findViewById(R.id.btnForward)
        revBackBt = findViewById(R.id.btnBack)
        revAnswerPrompt = findViewById(R.id.tvAnswerPromptRevMode)
        revScore = findViewById(R.id.tvScore)


        val userScore = intent.getIntExtra("The user's score", 0)
        val questionsArray = intent.getStringArrayExtra("Array holding questions")
        val questionsHeaderArray = intent.getStringArrayExtra("Array holding headers")
        val answersArray = intent.getBooleanArrayExtra("Array holding answers")

        val revExitBt = findViewById<Button>(R.id.btnExitRevMode)

        revScore.text = "Your score was: " + userScore + "/5"
        revQuestionsHeader.text = questionsHeaderArray!![intIndex]
        revQuestions.text = questionsArray!![intIndex]
        revAnswerPrompt.text = "This answer was " + answersArray!![intIndex] + "."

        revExitBt.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }

        revNextbt.setOnClickListener {
            while (intIndex < 5) {
                if (intIndex == 4) {
                    break
                } else {
                    intIndex++
                    revQuestionsHeader.text = questionsHeaderArray[intIndex]
                    revQuestions.text = questionsArray[intIndex]
                    revAnswerPrompt.text = "This answer was " + answersArray!![intIndex] + "."
                    break
                }


            }

            revBackBt.setOnClickListener {
                while (intIndex < 5) {
                    if (intIndex == 0) {
                        break
                    } else {
                        intIndex--
                        revQuestionsHeader.text = questionsHeaderArray[intIndex]
                        revQuestions.text = questionsArray[intIndex]
                        revAnswerPrompt.text = "This answer was " + answersArray!![intIndex] + "."
                        break
                    }
                }
            }
        }
    }
}