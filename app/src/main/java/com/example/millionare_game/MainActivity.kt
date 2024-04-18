package com.example.millionare_game

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var currentRound = 0
    private lateinit var tvQuestion: TextView
    private lateinit var tvValue: TextView
    private lateinit var Button1: Button
    private lateinit var Button2: Button
    private lateinit var Button3: Button
    private lateinit var Button4: Button
    private val rounds = mutableListOf<Round>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Button1 = findViewById<Button>(R.id.button)
        Button2 = findViewById<Button>(R.id.button2)
        Button3 = findViewById<Button>(R.id.button3)
        Button4 = findViewById<Button>(R.id.button4)
        val tvQuestion: TextView = findViewById(R.id.tvQuestion) as TextView
        val tvValue: TextView = findViewById(R.id.tvValue) as TextView
        tvQuestion.text = "Тест"
         
    }
    private fun fillRounds(){
        rounds.run{
            add(Round("Что такое луна?", "Звезда","Планета","Спутник","Круга сыра",3,100))
            add(Round("В каком году запущен первый спутник?", "1957","1961","1965","1969",1,1000))
            add(Round("Сколько спутников у марса?", "0","1","2","4",3,10000))
            add(Round("Как называется спутник Плутона?", "Нет спутников","Харон","Энцелад","Ио",2,100000))
            add(Round("Какой крупнейший спутник у Юпитера?", "Европа","Каллисто","Титан","Ганимед",4,1000000))

        }
    }
    private fun updateUI(){
        tvQuestion.text = rounds[currentRound].question
        tvValue.text = rounds[currentRound].value.toString()
        Button1.text = rounds[currentRound].answer1
        Button2.text = rounds[currentRound].answer2
        Button3.text = rounds[currentRound].answer3
        Button4.text = rounds[currentRound].answer4
    }
    private fun checkAnswer(givenId: Int) =
        (givenId == rounds[currentRound].rightId)
    private fun goNextRound(): Boolean {
        if (currentRound >= rounds.size - 1) return false
        currentRound++
        updateUI()
        return true
    }
    private fun processRound(givenId: Int){
        if (checkAnswer(givenId)){
            if (!goNextRound()){
                Toast.makeText(this,"You win!", Toast.LENGTH_SHORT).show()
                finish()
            }
        } else{
            Toast.makeText(this, "You loose", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}