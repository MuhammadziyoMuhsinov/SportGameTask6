package uz.muhammadziyo.sportgametask6

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import uz.muhammadziyo.sportgametask6.databinding.FragmentQuestionBinding
import uz.muhammadziyo.sportgametask6.databinding.ItemDialogBinding
import uz.muhammadziyo.sportgametask6.models.Mydata
import uz.muhammadziyo.sportgametask6.models.Mydata.correct
import uz.muhammadziyo.sportgametask6.models.Mydata.incorrect
import uz.muhammadziyo.sportgametask6.models.Question
import kotlin.properties.Delegates


class FragmentQuestion : Fragment() {

    private lateinit var binding: FragmentQuestionBinding
    private lateinit var list: ArrayList<Question>
    private var position = 0



    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentQuestionBinding.inflate(layoutInflater)
        correct = 0
        incorrect = 0
        list = ArrayList()

        loadList()
        loadQuestion()


        binding.btnAnswer1.setOnClickListener {
            if (list[position].correctAnswer == 1) {
                Snackbar.make(it,"correct!",1000).show()
                val son = correct
                correct=son!!+1


                if (position + 1 == list.size) {
       alertdialog()
                } else {
                    position += 1
                    loadQuestion()
                }
                binding.txtLevel.text = "level ${position + 1}"
            } else {
                Snackbar.make(it,"incorrect!",1000).show()
                val son = incorrect
                incorrect=son!!+1
                if (position + 1 == list.size) {
             alertdialog()
                } else {
                    position += 1
                    loadQuestion()
                }
                binding.txtLevel.text = "level ${position + 1}"
            }
        }



        binding.btnAnswer2.setOnClickListener {
            if (list[position].correctAnswer == 2) {
                Snackbar.make(it,"correct!",1000).show()
                val son = correct
                correct=son!!+1


                if (position + 1 == list.size) {
              alertdialog()
                } else {
                    position += 1
                    loadQuestion()
                }
                binding.txtLevel.text = "level ${position + 1}"
            } else {
                Snackbar.make(it,"incorrect!",1000).show()
                val son = incorrect
                incorrect=son!!+1
                if (position + 1 == list.size) {
            alertdialog()
                } else {
                    position += 1
                    loadQuestion()
                }
                binding.txtLevel.text = "level ${position + 1}"
            }
        }

        binding.btnAnswer3.setOnClickListener {
            if (list[position].correctAnswer == 3) {
                Snackbar.make(it,"correct!",1000).show()
                val son = correct
                correct=son!!+1

                if (position + 1 == list.size) {
                 alertdialog()
                } else {
                    position += 1
                    loadQuestion()
                }
                binding.txtLevel.text = "level ${position + 1}"
            } else {
                Snackbar.make(it,"incorrect!",1000).show()
                val son = incorrect
                incorrect=son!!+1
                if (position + 1 == list.size) {
                 alertdialog()
                } else {
                    position += 1
                    loadQuestion()
                }
                binding.txtLevel.text = "level ${position + 1}"
            }
        }

        binding.btnRight.setOnClickListener {
            if (position + 1 == list.size) {
                Toast.makeText(binding.root.context, "Full!", Toast.LENGTH_SHORT).show()
                alertdialog()
            } else {
                position += 1
                loadQuestion()
            }


        }
        binding.btnLeft.setOnClickListener {

            if (position == 0) {
                Toast.makeText(binding.root.context, "Full!", Toast.LENGTH_SHORT).show()
                Mydata.incorrect=0
                Mydata.correct=0
            } else {
                position -= 1
                val son = correct
                correct=son!!-1

                val son1 = incorrect
                incorrect=son1!!-1
                loadQuestion()
            }
        }
        binding.imgClose.setOnClickListener {
            findNavController().popBackStack()
        }






        return binding.root
    }


    private fun loadList() {
        list.add(Question("How long is football?",
            "45 minutes",
            "60 Minutes",
            "90 minutes",
            R.drawable.img,
            3))

        list.add(Question("What was the score in the Euro-2012 final?",
            "4 - 0",
            "3 - 0",
            "2 - 0",
            R.drawable.img_question,
            1))

        list.add(Question("Who won the Man of the Match award in the 2014 World Cup ",
            "Mario Goetze",
            "Sergio Aguero",
            "Bastian Schweinsteiger",
            R.drawable.img_question,
            1))

        list.add(Question("Which team has won the Africa Cup of Nations 7 times?",
            "Cameroon",
            "Egypt",
            "Senegal",
            R.drawable.img_question,
            2))

        list.add(Question("How many players are there on a baseball team?",
            "6",
            "11",
            "9",
            R.drawable.img_question,
            3))

        list.add(Question("JCH-2018da qaysi davlat g‘olib chiqdi?",
            "France",
            "Portugal",
            "Brazil",
            R.drawable.img_question,
            1))

        list.add(Question("Which country won the WC-2018?",
            "2008",
            "2006",
            "2004",
            R.drawable.img_question,
            3))

        list.add(Question("What is Muhammad Ali's real name?",
            "Liam Clay",
            "Cassius Clay",
            "Oliver Clay",
            R.drawable.img_question,
            3
        ))

        list.add(Question("Which country has the most Olympic gold medals in swimming?",
            "China",
            "The USA",
            "Australia",
            R.drawable.img_question,
            2

        ))

        list.add(Question("When was water polo invented?",
            "19th century",
            "20th century",
            "18th century",
            R.drawable.img_question,
            1
        ))

    }


    private fun loadQuestion() {
        binding.question.text = list[position].question
        binding.btnAnswer1.text = list[position].answer1
        binding.btnAnswer2.text = list[position].answer2
        binding.btnAnswer3.text = list[position].answer3
        binding.imgQuestion.setImageResource(list[position].image)

    }

    @SuppressLint("SetTextI18n")
    private fun alertdialog(){
        val alertDialog = AlertDialog.Builder(binding.root.context).create()
        val itemDialogBinding = ItemDialogBinding.inflate(LayoutInflater.from(binding.root.context))
        itemDialogBinding.correct.text = "correct answer: $correct"
        itemDialogBinding.incorrect.text = "incorrect answer: $incorrect"
        itemDialogBinding.btnNewstart.setOnClickListener {
            position = 0
            loadQuestion()
            alertDialog.cancel()
            Mydata.incorrect=0
            Mydata.correct=0
        }
        alertDialog.setView(itemDialogBinding.root)
        alertDialog.show()
    }

}