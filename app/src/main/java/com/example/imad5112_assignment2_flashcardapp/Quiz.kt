package com.example.imad5112_assignment2_flashcardapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class Quiz : AppCompatActivity() {

    private lateinit var quizQuestions: TextView
    private lateinit var quizQuestionsHeader: TextView
    private lateinit var nextBt: Button
    private lateinit var trueBt: Button
    private lateinit var falseBt: Button
    private lateinit var answerPrompt: TextView
    private var userScore = 0

    private val questionsArray = arrayOf<String>(
        "WWII started on the 1st of Sept. 1939.",
        "Japan was an Allied Power in WWII.",
        "Japan launched an attack on Pearl Harbor (USA) in 1941.",
        "The Soviet Union was an Axis Power in WWII.",
        "WWII ended on the 7th of Sept. 1945.",
        ""
    )
    private val questionsHeaderArray = arrayOf<String>(
        "Question 1:",
        "Question 2:",
        "Question 3:",
        "Question 4:",
        "Question 5:",
        ""
    )
    private val answersArray = booleanArrayOf(true, false, true, false, false)
    private var intIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)

        quizQuestions = findViewById(R.id.tvQuestions)
        quizQuestionsHeader = findViewById(R.id.tvQuestionsHeader)
        nextBt = findViewById(R.id.btnNext)
        trueBt = findViewById(R.id.btnTrue)
        falseBt = findViewById(R.id.btnFalse)
        answerPrompt = findViewById(R.id.tvAnswerPrompt)

       val exitBt = findViewById<Button>(R.id.btnExit)

        quizQuestionsHeader.text = questionsHeaderArray[intIndex]
        quizQuestions.text = questionsArray[intIndex]

        exitBt.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }

        nextBt.setOnClickListener {
            while (intIndex < 5) {
                intIndex++
                quizQuestionsHeader.text = questionsHeaderArray[intIndex]
                quizQuestions.text = questionsArray[intIndex]
                break
            }
            answerPrompt.text = ""
            if (intIndex == 5) {
                quizQuestionsHeader.text = "Your Result:"
                quizQuestions.text =
                    "You got " + userScore + " answers correct, out of a possible 5."
                if (userScore <= 3) {
                    answerPrompt.text = "You can do better than that! Keep studying!"
                } else {
                    if (userScore == 4) {
                        answerPrompt.text = "Great job! You did really well!"
                    } else {
                        if (userScore == 5) {
                            answerPrompt.text =
                                "You got a perfect score! You really know your stuff!"
                        } else {
                            if (userScore > 5) {
                                answerPrompt.text =
                                    "Uh... looks like something went wrong. Please try again and be sure to click once per answer."
                            }
                        }
                    }
                }
            }
        }

        trueBt.setOnClickListener {
            if (intIndex == 5) {
                answerPrompt.text = "What are you doing? The test is over!"
            } else {
                if (answersArray[intIndex] == true) {
                    answerPrompt.text = "Correct! You got the right answer!"
                    userScore += 1
                } else {
                    answerPrompt.text = "Incorrect! Sorry, that's not the right answer..."
                }
            }
        }
        falseBt.setOnClickListener {
            if (intIndex == 5) {
                answerPrompt.text = "What are you doing? The test is over!"
            } else {
                if (answersArray[intIndex] == false) {
                    answerPrompt.text = "Correct! You got the right answer!"
                    userScore += 1
                } else {
                    answerPrompt.text = "Incorrect! Sorry, that's not the right answer..."
                }
            }


        }
    }
}
