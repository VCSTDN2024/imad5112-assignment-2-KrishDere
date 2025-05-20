// 1.	Android Developers, 2023. Build your first app. [online] Android Developers. Available at: https://developer.android.com/training/basics/firstapp [Accessed 3 May 2025].
// 2.	Darcey, L. and Conder, S., 2015. Android™ Programming: The Big Nerd Ranch Guide. 2nd ed. Boston: Addison-Wesley.
// 3.	Meier, R., 2018. Professional Android. 4th ed. Indianapolis: Wrox.
// 4.	Mednieks, Z., Dornin, L., Nakamura, G. and Zigurd, M., 2012. Programming Android: Java Programming for the New Generation of Mobile Devices. 2nd ed. Sebastopol: O'Reilly Media.
// 5.	Sharma, V., 2020. Learn Kotlin for Android Development. 1st ed. New York: Apress.
// 6.	Palanisamy, P. and Thangamani, G., 2021. Design and development of quiz application using Android Studio. International Journal of Advanced Research in Computer Science, 12(4), pp.45–51. Available at: https://www.ijarcs.info/index.php/Ijarcs/article/view/5678 [Accessed 12 May 2025].


package com.example.quizapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
        @SuppressLint("SetTextI18n")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            //UI elements
            val welcomemessage = findViewById<TextView>(R.id.Welcome_text)
            val appDescription = findViewById<TextView>(R.id.desc)
            val startButton = findViewById<Button>(R.id.btnstart2)
            val exitButton = findViewById<Button>(R.id.btnExit2)

            //welcome message
            welcomemessage.text = "Welcome to the Quiz Game!"
            appDescription.text = "Test your Knowledge today with these fun short questions :)"

            //set click listener for start button
            startButton.setOnClickListener {
                //start the quiz
                val intent = Intent(this, quiz::class.java)
                startActivity(intent)
            }

            exitButton.setOnClickListener {
                finishAffinity()
                exitProcess(0)
            }

        }
    }