package com.example.newapp

object Constant {

    const val USER_NAME = "user_name"
    const val TOTAL_QUESTIONS = "total_questions"
    const val CORRECT_ANSWERS = "correct_answers"

    fun getQuestions(): ArrayList<Question> {
        val questionList = arrayListOf<Question>()
        questionList.add(
            Question(
                1,
                R.drawable.india,
                "What country does this flag belong to ?",
                "India",
                "usa",
                "srilanka",
                "japan",
                1
            )
        )

        questionList.add(
            Question(
                1,
                R.drawable.australia,
                "What country does this flag belong to ?",
                "australia",
                "usa",
                "srilanka",
                "japan",
                1
            )
        )

        questionList.add(
            Question(
                1,
                R.drawable.japan,
                "What country does this flag belong to ?",
                "germany",
                "japan",
                "srilanka",
                "japan",
                2
            )
        )

        questionList.add(
            Question(
                1,
                R.drawable.srilanka,
                "What country does this flag belong to ?",
                "germany",
                "srilanka",
                "usa",
                "japan",
                2
            )
        )

        questionList.add(
            Question(
                1,
                R.drawable.usa,
                "What country does this flag belong to ?",
                "germany",
                "usa",
                "srilanka",
                "japan",
                2
            )
        )

        questionList.add(
            Question(
                1,
                R.drawable.germany,
                "What country does this flag belong to ?",
                "germany",
                "usa",
                "srilanka",
                "japan",
                1
            )
        )

        return questionList
    }
}