package com.example.quizapplication
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class quiz : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var BtnTrue: Button
    private lateinit var BtnFalse: Button
    private lateinit var Btn_next: Button
    private lateinit var feedbackTextView: TextView
    private var currentQuestionIndex = 0
    private var checkScore = 0

    companion object {
        val questions = arrayOf(
            "The Eiffel Tower is located in Paris.",
            "The Great Wall of China is visible from space.",
            "The only letter not in the periodic table is the letter J.",
            "There are four different blood groups.",
            "The Black box in a plane is black",
        )
        val answers = booleanArrayOf(true, false, true, true, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)

        // Initialize UI elements
        questionTextView = findViewById(R.id.questions_textView)
        BtnTrue = findViewById(R.id.BtnTrue)
        BtnFalse = findViewById(R.id.btnFalse)
        Btn_next = findViewById(R.id.Btn_next)
        feedbackTextView = findViewById(R.id.feedback_text_View)

        // Display the first question
        displayQuestion()
        feedbackTextView.text = ""
        // Set click listeners for answer buttons
        BtnTrue.setOnClickListener { checkAnswer(true) }
        BtnFalse.setOnClickListener { checkAnswer(false) }

        // Set click listener for next button
        Btn_next.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                displayQuestion()
                feedbackTextView.text = ""
                BtnTrue.isEnabled = true
                BtnFalse.isEnabled = true
            } else {
                val intent = Intent (this, score::class.java)
                intent.putExtra("checkScore", checkScore)  // FIXED: 'Intent' should be lowercase 'intent'
                startActivity(intent)
                finish()
            }
        }

        Btn_next.isEnabled = false
    }

    private fun displayQuestion() {
        questionTextView.text = questions[currentQuestionIndex]
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[currentQuestionIndex]
        if (userAnswer == correctAnswer) {
            feedbackTextView.text = "Correct!"
            feedbackTextView.setTextColor(Color.GREEN)
            checkScore++
        } else {
            feedbackTextView.text = "Incorrect!"
            feedbackTextView.setTextColor(Color.RED)
        }

        BtnTrue.isEnabled = false
        BtnFalse.isEnabled = false
        Btn_next.isEnabled = true
    }
}




