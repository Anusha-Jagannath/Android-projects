package com.example.quizapp

object Constants {

    fun getQuestions(): ArrayList<Question> {

        val questionList = arrayListOf<Question>()
        val question1 = Question(
            1,
            "Which country does this flag belongs to?",
            R.drawable.australia,
            "Australia",
            "India",
            "Japan",
            "Srilanka",
            1

        )

        val question2 = Question(
            1,
            "Which country does this flag belongs to?",
            R.drawable.india,
            "Australia",
            "India",
            "Japan",
            "Srilanka",
            2

        )

        val question3 = Question(
            1,
            "Which country does this flag belongs to?",
            R.drawable.germany,
            "Australia",
            "India",
            "Germany",
            "Srilanka",
            3

        )

        val question4 = Question(
            1,
            "Which country does this flag belongs to?",
            R.drawable.japan,
            "Australia",
            "India",
            "Japan",
            "Srilanka",
            3

        )

        val question5 = Question(
            1,
            "Which country does this flag belongs to?",
            R.drawable.srilanka,
            "Australia",
            "India",
            "Japan",
            "Srilanka",
            4

        )

        val question6 = Question(
            1,
            "Which country does this flag belongs to?",
            R.drawable.usa,
            "Australia",
            "India",
            "Japan",
            "usa",
            4

        )
        questionList.add(question1)
        questionList.add(question2)
        questionList.add(question3)
        questionList.add(question4)
        questionList.add(question5)
        questionList.add(question6)
        return questionList
    }
}